
package modelo;

import java.util.Objects;

public class Carta {
    private String numero;
    private String nombre;
    private String rutaImagen;
    
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
    
}
