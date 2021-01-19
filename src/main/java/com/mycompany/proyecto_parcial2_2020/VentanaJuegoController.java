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
import javafx.scene.text.Text;
import modelo.Carta;
import modelo.Tablero;
/**
 * FXML Controller class
 *
 * @author alexx
 */
public class VentanaJuegoController  {

    
    @FXML
    private VBox vboxCartas;
    @FXML
    private ImageView imgPosicionGanadora;
    @FXML
    private ImageView imgPosicionOponentes;
    @FXML
    private HBox hboxMazo;
    @FXML
    private ImageView imgCartaMazo;
    @FXML
    private Button btnLoteria;
    @FXML
    private GridPane gpTablero;
    
    private Tablero tablero = new Tablero();
    
    
    //public VentanaJuegoController(){
      //  ArrayList<Integer> indices;
        //ArrayList<Carta> cartas = new ArrayList<>();
       // ArrayList<ImageView> panelesimages = new ArrayList<>();
    //}
    
    
    public void initialize() {
        //Llenar el Gridpane gpTablero
       tablero.lecturaArchivoCarta();
       gpTablero.setVgap(15);
       gpTablero.setHgap(30);
        llenarTablero();
    } 
    
    //Tomamos los datos de la lista de cartas para llenar el tablero
    public void llenarTablero(){
        ArrayList<Carta> cartas = tablero.getCartas();
        int fila = 0;
        int columna = 0;
        ArrayList<Integer> num = new ArrayList<>();
        Random aleatorio = new Random(System.currentTimeMillis());
        for (int i = 0; i<22 ; i++) {
            int intAleatorio = aleatorio.nextInt(55);
            if (num.contains(intAleatorio) == false ){
                num.add(intAleatorio);
                Image url = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
                ImageView img = new ImageView(url);
                img.setFitHeight(120);
                img.setFitWidth(90);
                gpTablero.add(img,columna,fila);
                fila++;
                if(fila == 4){
                    fila = 0;
                    columna++;
                }
                 if(columna == 4)
                    columna = 0;
           

            }
        } 
    }
                
                
         
        
    
        
    
    @FXML
    private void verificarGanador(ActionEvent event){
        try{
            App.setRoot("Secondary");
        }catch(Exception e){
            
        }
        
    }

    
}
