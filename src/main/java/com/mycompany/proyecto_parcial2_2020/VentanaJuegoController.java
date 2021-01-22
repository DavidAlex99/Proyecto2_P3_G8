/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_parcial2_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.Carta;
import modelo.Configuracion;
import modelo.Juego;
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
    private HBox hboxMazo;
    @FXML
    private ImageView imgCartaMazo;
    @FXML
    private Button btnLoteria;
    @FXML
    private GridPane gpTablero;
    
    private Tablero tablero = new Tablero();
    public Configuracion configuracion;
    
    @FXML
    private ImageView imgAlineacionGanadora;
    @FXML
    private GridPane gpTableroOponente;
    //agregado 2001
    Juego juego;
    @FXML
    private Label lbCarga;
    
    
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
        //////////////////////////////////////////////
       //AGREGADO
       llenarTablero();
       tableroOponente();
       Carta.listaTodasCartas();
       Carta.obtenerCartaAleatorioMazo();
       cargarImagenAlineacion();
       //llenarMazo();
       
       Thread t = new Thread(new Runnable() {
       @Override
       public void run() {
        while(true){
            try{
                Platform.runLater(()-> llenarMazo());
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            }
       }
       
       });
       t.start();
    }

    
    //agregado 2001
    public void cargarImagenAlineacion(){
        //String url = juego.muestreoAlineacion(); 
        juego = new Juego();
        //imgPosicionGanadora.setImage(new Image(getClass().getResourceAsStream(App.pathimagenes + "match.png")));
        //System.out.println(juego.muestreoAlineacion());
        imgAlineacionGanadora.setImage(new Image(getClass().getResourceAsStream(App.pathimagenes + juego.muestreoAlineacion())));
        //System.out.println(juego.getColumnasAlineacion());
        //System.out.println(juego.getFilasAlineacion());
        
        
    }
     
    
    //Tomamos los datos de la lista de cartas para llenar el tablero
    public void llenarTablero(){
        ArrayList<Carta> cartas = tablero.getCartas();
        int fila = 0;
        int columna = 0;
        ArrayList<Integer> num = new ArrayList<>();
        Random aleatorio = new Random(System.currentTimeMillis());
        for (int i = 0; i<25 ; i++) {
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
        //AGREGADO
    public void llenarMazo(){
        
        ArrayList<Carta> cartas = tablero.getCartas();
        ArrayList<String> indice = Carta.cartasAleatoriasMazo;
        Random r = new Random();
        int x = 54;
        int num = r.nextInt(x);
        String ur = indice.get(num);
        for(Carta c:cartas){
            if(c.getNumero().equalsIgnoreCase(ur)){
                Image url = new Image(getClass().getResourceAsStream(c.getRutaImagen()));
                imgCartaMazo.setImage(url);
                indice.remove(num);
                x--;
                
                
                //Llenado deL con las condiciones  LABEL
                if (indice.size() == 41){
                    lbCarga.setText(" 25% DE CARTAS MOSTRADAS");
                }else if (indice.size() == 27){
                    lbCarga.setText(" 50% DE CARTAS MOSTRADAS");
                }else if (indice.size() == 14){
                    lbCarga.setText(" 75% DE CARTAS MOSTRADAS");
                }
        
        }
    }
    }
    
    
   
    
    
    
    
 
   public void tableroOponente(){
       configuracion= new Configuracion();
       configuracion.lecturaDatos();
       
       if(configuracion.getVisible().equals("Visible")){
        //System.out.println("Hola");
        ArrayList<Carta> cartas = tablero.getCartas();
        int fila = 0;
        int columna = 0;
        ArrayList<Integer> num = new ArrayList<>();
        Random aleatorio = new Random(System.currentTimeMillis());
        //System.out.println(cartas.get(0).getRutaImagen());
        for (int i = 0; i<25 ; i++) {
            int intAleatorio = aleatorio.nextInt(55);
            if (num.contains(intAleatorio) == false ){
                num.add(intAleatorio);
                Image url = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
                ImageView img = new ImageView(url);
                img.setFitHeight(40);
                img.setFitWidth(30);
                gpTableroOponente.add(img,columna,fila);
                fila++;
                if(fila == 4){
                    fila = 0;
                    columna++;
                }
                 if(columna == 4)
                    columna = 0;
           

            }
        } 
       }else {
           ArrayList<Carta> cartas = tablero.getCartas();
        int fila = 0;
        int columna = 0;
           //System.out.println(cartas.get(0).getRutaImagen());
        ArrayList<Integer> num = new ArrayList<>();
        Random aleatorio = new Random(System.currentTimeMillis());
        for (int i = 0; i<25 ; i++) {
            int intAleatorio = aleatorio.nextInt(55);
            if (num.contains(intAleatorio) == false ){
                num.add(intAleatorio);
                Image url = new Image(getClass().getResourceAsStream("Imagenes/match.png"));
                ImageView img = new ImageView(url);
                img.setFitHeight(40);
                img.setFitWidth(30);
                gpTableroOponente.add(img,columna,fila);
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
        
   
}

                
         
        
    
        
    
    @FXML
    private void verificarGanador(ActionEvent event){
        try{
            App.setRoot("Secondary");
        }catch(Exception e){
            
        }
        
    }

    
}



