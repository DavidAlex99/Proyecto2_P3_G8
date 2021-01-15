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
import java.util.Random;
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

    public static ArrayList<Integer> indices;
    public static ArrayList<Carta> cartas = new ArrayList<>();
    public static ArrayList<ImageView> panelesimages = new ArrayList<>();
    
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
        @FXML
    private ImageView imgCarta1;
    @FXML
    private ImageView imgCarta2;
    @FXML
    private ImageView imgCarta3;
    @FXML
    private ImageView imgCarta4;
    @FXML
    private ImageView imgCarta5;
    @FXML
    private ImageView imgCarta6;
    @FXML
    private ImageView imgCarta7;
    @FXML
    private ImageView imgCarta8;
    @FXML
    private ImageView imgCarta9;
    @FXML
    private ImageView imgCarta10;
    @FXML
    private ImageView imgCarta11;
    @FXML
    private ImageView imgCarta12;
    @FXML
    private ImageView imgCarta13;
    @FXML
    private ImageView imgCarta14;
    @FXML
    private ImageView imgCarta15;
    @FXML
    private ImageView imgCarta16;
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
    
        //3. METODO PARA PNER LAS CARTAS EN EL TABLERO
    public void ponerCartasTablero(){
        //3.1 llenado de la sta cartas con os indices de las cartas
        indices = new ArrayList<Integer>();
        int ind = 0;
        while(ind<54){
            indices.add(ind + 1);
            ind ++;
        }
        ///////////////////////////////////////////////////////////
        Random x = new Random();
        ///////////////////////////////////////////////////////////
        // ITERADOR PARA LA CANTIDAD DE CARTAS QUE E NECESIA PARA COMPLETAR EL TABLERO
        int i = 0;
        //ITERADOR PARA LAS POSICIONES DE LAS CARTAS LAS CARATAS QUE TENGO DISPONIBLE EL MAZO COMPLETOPARA EL TABLERO
        int x1 = 54;
        while(i<17){
            //3.2 ESO ME DEVUELVE UN NUMERO RADOM DENTRO DEL LIMITE, NUMERO RANDOM QUE REPRESETARIA UN INDICE
            int n = x.nextInt(x1 - 1);
            //3.3 DEVUELVE LA CARTA POR EL INDICE, EN ESTE CASO EL NUMERO DE LA CARTA
            int card = indices.get(n);
            indices.remove(n);

            for(Carta c1: cartas){
                if(c1.getNumero()==n){
                    InputStream input = null;
                    try{
                        //3.6 PARA ESTO LE HE PUESTO NOMBRE A CADA IMAGEVIEW EN LA MATRIZ DE BAAJAS
                        String fileName = App.pathimagenes + c1.getRutaImagen();
                        input = App.class.getResource(fileName).openStream();
                        Image image = new Image(input, 100, 100, false , false);
                        panelesimages.get(i).setImage(image);
                    }catch(IOException ex){
                        System.out.println("No se puede cargar la imagen");   
        }
    }
}
            //3.4 AUMENTO EL ITERADOR EN 1
            i++;
            //3.5RESTA DEL NUMERO DE CAARTAS QUE SE ENCUENTRA EN EL MAZO
            x1 = x1 -1;
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
