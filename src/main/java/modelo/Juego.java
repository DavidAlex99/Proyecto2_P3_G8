/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author cholo
 */
public class Juego {
    private String fecha;
    private int duracion;
    private ArrayList<Jugador> jugadores;
    private Jugador ganador;
    private Configuracion configuracion;
    private Mazo mazo;
    private ArrayList<Carta> cartasjugadas;
    private Alineacion alineacion;
    
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
    
    public void verificarJuego(){
    }
    //COMPLETAR METODO!!!
}

