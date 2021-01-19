
package modelo;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Carta {
    private String numero;
    private String nombre;
    private String rutaImagen;
    
    //AGREGADO 1901221
    public static ArrayList<String> cartasAleatoriasMazo = new ArrayList<>();
    //AGREGADO 19012021
    public static ArrayList<Integer> numerosTodasCartas2 = new ArrayList<>();
    
    public Carta(String numero, String nombre, String rutaImagen){
        this.numero= numero;
        this.nombre = nombre;
        this.rutaImagen = rutaImagen;
    }
    
    
    public String getNumero(){
        return numero;
    }
    public String getNombre(){
        return nombre;
    }
    public String getRutaImagen(){
        return rutaImagen;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.rutaImagen, other.rutaImagen)) {
            return false;
        }
        return true;
    }
    
    //AGREGADO 190120121
    public static ArrayList listaTodasCartas(){
        //3.1 llenado de la sta cartas con os indices de las cartas
        
        int ind = 0;
        while(ind<54){
            numerosTodasCartas2.add(ind + 1);
            ind = ind + 1;
        }
        return numerosTodasCartas2;
    }
    
    //AGREGADO 19012021
    public static ArrayList obtenerCartaAleatorioMazo(){
        Random r = new Random();
        int i = 1;
        int x1 = 53;
        while(i<54){
            int n1 = r.nextInt(x1);
            String numero = String.valueOf(numerosTodasCartas2.get(n1));
            cartasAleatoriasMazo.add(numero);
            //DESCARTAR ESE NUMERO DE LALISTA DONDE ESTAN TODOS LOS NUMEROS
            numerosTodasCartas2.remove(n1);
            x1--;
            i++;
        } 
        return cartasAleatoriasMazo;
    }
    
}
