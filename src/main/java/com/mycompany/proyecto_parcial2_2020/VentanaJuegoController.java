/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_parcial2_2020;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Carta;
/**
 * FXML Controller class
 *
 * @author alexx
 */
public class VentanaJuegoController implements Initializable {

    public static ArrayList<Carta> cartas = new ArrayList<>();
    @FXML
    private VBox vboxCartas;
    @FXML
    private ImageView imgPosicionGanadora;
    @FXML
    private ImageView imgPosicionOponentes;
    @FXML
    private GridPane gpCartasMias;
    @FXML
    private HBox hboxMazo;
    @FXML
    private ImageView imgCartaMazo;
    @FXML
    private Button btnLoteria;
    /**
     * Initializes the controller class.
     */
    
    //2.8 PONEMOS EN MARCHA EL METODO PARA LEER EL ARCHIVO
    public VentanaJuegoController(){
        lecturaArchivoCarta();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    //2. PRIMERAMNETE HACEMOS LA LECTURA DEL ARCHIVO, UNA MANERA ES ESTA, GUARDANDO EN UNA LISTA Y HACIENDO DICCIONARIO
    //(AHI VEMOS SI LO GUARDAMOS EN UNA LISTA O LE DEJAMOS EN UN DICCIONARIO)
    public void lecturaArchivoCarta(){
        try {
            //2.1 SE HACE LA LECTURA NORMAL DE ARCHIVOS, EN ESTE CASO, SE GUARDO EN UNA LISTA PARA MAYOR FACILIDAD
            List<String> lineas = Files.readAllLines(Paths.get(App.pathArchivo));
            //2.2 FOR PARA COGER SUBLISTAS DE LA LISTA, DICHAS SUBLISTAS, SON NUMEROS Y EL NOMBRE
            for(String l:lineas){
                String[] separado = l.split(",");      
                InputStream input = null;
                try {
                    //2. SE PROCEDE A COGER LA RUTA DE LA IMAGEN QUE SE ENCUENTRA EN LA CLASE APP, COMPLMENTADO EL JOMBRE
                    // DE LA CARTA EL CUAL ES EL NUMERO.PNG
                    String fileName = App.pathimagenes + separado[0] + ".png";

                    //2.4 SE ABRE E STREAM DEL ARCHIVO FOTO
                    input = App.class.getResource(fileName).openStream();
           
                    //2.5 SE CREA LA IMAGEN
                    Image image = new Image(input, 100, 100, false, false);
                    imgCartaMazo.setImage(image);
                    //2.6 SELO PASA AL CONSTRUCTOR DE LA CLASE CARTA, EL RPIMERO ARGUMENTO COMO ERA UN STRING SE LO PASA A INT
                    Carta c = new Carta(Integer.parseInt(separado[0]), separado[1], fileName);
                    //2.7 SE LO PASA PARA GUARADARLO EN LA LISTADE OBJETOS CARTAS
                    cartas.add(c);
                    
                    System.out.println(separado[0]);
                    System.out.println(separado[1]);
                    System.out.println(separado[2]);

                } catch (Exception ex) {
                    System.out.println("no se encuentra archivo de imagen");
                } finally {
                    if (input != null) {
                        try {
                            input.close();
                        } catch (IOException ex) {
                            System.out.println("no se pudo cerrar");
                }
            }
        }
}
                
                
         
        
    }catch (IOException ex) {
            System.out.println(ex + "no se encuentra");
}
}

   
    //3. METODO PARA  HCER EL LLENADO DE LAS IMAGENES EN EL TABLERO
    private void cargarCartasTablero(){
        
    }
    
    
    //4. METODO PARA LLENAR EL IMAGEVIEW EN DONDE SE MUESTRAN LAS CARTAS QUE SE VAN
    // PASANDO DE UNA EN UNA
    private void cargarmazo(){/*
        //4.1 LEEMOS LA IMAGEN, COMO ES UNA IMAGE SE HACE UN INPUTSTREAM
        InputStream input = null;
        //4.2 TRY CATCH PARA HACER LA LECTURA DE LAS IMAGENES POR SI OCURRE UN ERROR
        try{
            String filename = App.pathimagenes + 
        }
        
    }
}*/
    }
    
    @FXML
    private void verificarGanador(ActionEvent event){
        try{
            App.setRoot("Secondary");
        }catch(Exception e){
            
        }
        
    }
}
