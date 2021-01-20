
package modelo;

import java.util.ArrayList;
import java.util.Random;


public class Juego {
    private String fecha;
    private int duracion;
    private ArrayList<Jugador> jugadores;
    private Jugador ganador;
    private Configuracion configuracion;
    private Mazo mazo;
    private ArrayList<Carta> cartasjugadas;
    private Alineacion alineacion;
        //lista con las filas y columnas, par ordenado con el mismo indice
    private ArrayList<Integer> filasAlineacion;
    private ArrayList<Integer> columnasAlineacion;
    private ArrayList<Alineacion> alineaciones = new ArrayList<>();
    
    public Juego(String fecha, int duracion, ArrayList<Jugador> jugadores, Jugador ganador, Configuracion configuracion, Mazo mazo, ArrayList<Carta> cartasjugadas, Alineacion alineacion){
        this.fecha =fecha;
        this.duracion= duracion;
        this.jugadores = new ArrayList<>();
        this.ganador = ganador;
        this.configuracion = configuracion;
        this.mazo = mazo;
        this.cartasjugadas = cartasjugadas;
        this.alineacion= alineacion;
    }
    public Juego(){
        filasAlineacion = new ArrayList<>();
        columnasAlineacion = new ArrayList<>();
    }
    public String getFecha(){
        return fecha;
    }
    public int getDuracion(){
        return duracion;
    }
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    public Jugador getGanador(){
        return ganador;
    }
    public Configuracion getConfiguracion(){
        return configuracion;
    }
    public Mazo getMazo(){
        return mazo;
    }
    public ArrayList<Carta> getCartasJugadas(){
        return cartasjugadas;
    }
    public Alineacion getAlineacion(){
        return alineacion;
    }

    public ArrayList getColumnasAlineacion(){
        return columnasAlineacion;
    }
    public ArrayList getFilasAlineacion(){
        return filasAlineacion;
    }
    
    public void verificarJuego(){
    }
    //COMPLETAR METODO!!!
    //agregado 2 
    //metodo para la alineacion. llamar metodo en elintialize
    public String muestreoAlineacion(){
        //hice tres listas, uno para el columnas y otro para las filas, el mismo indice para las dos listas es el par ordenado
        //y otra en el que tieene las posiciones que se encentra en el enum, haciendo un random indice para elegir cualquiers
        //String[] alineaciones = {"ESQUINA","FILA","COLUMNA"};
        alineaciones.add(Alineacion.FILA);
        alineaciones.add(Alineacion.COLUMNA);
        alineaciones.add(Alineacion.ESQUINA);
        Random x = new Random();
        int ind = x.nextInt(3);
        //alineacion de la lista  alineacion con el random
        Alineacion p = alineaciones.get(ind);
        if(p.equals(Alineacion.COLUMNA)){
            filasAlineacion.add(0);//fila posicion 0
            filasAlineacion.add(1);//fila posicion 1
            filasAlineacion.add(2);//fila posicion 2
            filasAlineacion.add(3);//fila posicion 3
            columnasAlineacion.add(0);//4 veces el mismo numero agregao ya que es la misma columna
            columnasAlineacion.add(0);
            columnasAlineacion.add(0);
            columnasAlineacion.add(0);
        }else if(p.equals(Alineacion.ESQUINA)){
            filasAlineacion.add(0);//fila posicion 0
            filasAlineacion.add(0);//fila posicion 
            filasAlineacion.add(3);//fila posicion 2
            filasAlineacion.add(3);//fila posicion 3
            columnasAlineacion.add(0);
            columnasAlineacion.add(3);
            columnasAlineacion.add(0);
            columnasAlineacion.add(3);
        }else if(p.equals(Alineacion.FILA)){
            filasAlineacion.add(1);//fila posicion 0
            filasAlineacion.add(1);//fila posicion 
            filasAlineacion.add(1);//fila posicion 2
            filasAlineacion.add(1);//fila posicion 3
            columnasAlineacion.add(0);
            columnasAlineacion.add(1);
            columnasAlineacion.add(2);
            columnasAlineacion.add(3);
        }
    return p + ".png";    
    }
}

