
package modelo;

import com.mycompany.proyecto_parcial2_2020.App;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Configuracion implements Serializable {
    private String visible;
    private int numOponentes;
    public Configuracion datos;
   
    
    public Configuracion(int numOponentes, String visible){
        this.visible = visible;
        this.numOponentes = numOponentes;    
    }

    public Configuracion() {
        
    }

    
    
    public String getVisible(){
        return visible;
    }
    public int getOponentes(){
        return numOponentes;
    }
    
    
   public void lecturaDatos(){
      
        //recupera los datos escogidos por el jugador del archivo serializado 
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(App.pathDatos))){
          
            datos = ((ArrayList<Configuracion>)in.readObject()).get(0);
            this.numOponentes= datos.getOponentes();
            this.visible=datos.getVisible();
          
        } catch (FileNotFoundException ex) {
            System.out.println("Error de IoException");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
   }
}
