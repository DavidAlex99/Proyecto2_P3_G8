
package modelo;


public class Configuracion {
    private boolean visible;
    private int numOponentes;
    
    public Configuracion( boolean visible, int numOponentes){
        this.visible = visible;
        this.numOponentes = numOponentes;    
    }
    public boolean getVisible(){
        return visible;
    }
    public int getOponentes(){
        return numOponentes;
    }
}
