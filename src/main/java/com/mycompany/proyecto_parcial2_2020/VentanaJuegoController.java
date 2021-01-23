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
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.Carta;
import modelo.Configuracion;
import modelo.Juego;
import modelo.Mazo;
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
    //
    
    Juego juego;
    
    @FXML
    private Label lbCarga;
    //FILA y columna dde la alineacion ganadora
    public ArrayList<Integer> filaAlineacion = new ArrayList<>();
    public ArrayList<Integer> columnaAlineacion = new ArrayList<>();
    public ArrayList<Integer> filaAlineacion2;
    public ArrayList<Integer> columnaAlineacion2;
    //filas y columnad de las cartas  que voy marcando
    
    //agg
    public ArrayList<Integer> filasMarcadas = new ArrayList<Integer>();
    public ArrayList<Integer> columnasMarcadas = new ArrayList<Integer>();
    
    //objetos tipo carta ue va saliendo del mazo, es ecir que va alternando, primera carta: tipo, segunda cata:tipo etc ect
    public ArrayList<Carta> cartaMazo = new ArrayList<>();
    
    //cartas variaddo de su posicion e tablero
    public ArrayList<Mazo> mazoAlternante = new ArrayList<>();
    
    
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
       //imgPosicionGanadora.setImage(new Image(getClass().getResourceAsStream(App.pathimagenes + "match.png")));
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
        //ArrayList<Integer> filast = new ArrayList<>();
        //ArrayList<Integer> columnast = new ArrayList<>();
        //String url = juego.muestreoAlineacion(); 
        juego = new Juego();
        //imgPosicionGanadora.setImage(new Image(getClass().getResourceAsStream(App.pathimagenes + "match.png")));
        System.out.println(juego.muestreoAlineacion());
        imgAlineacionGanadora.setImage(new Image(getClass().getResourceAsStream(App.pathimagenes + juego.muestreoAlineacion())));
        System.out.println("estas son las columnas ganadoras" + juego.getColumnasA2());
        System.out.println("estas son lasfilas ganadoras" + juego.getFilasA2());
        
        filaAlineacion = juego.getFilasA2();
        columnaAlineacion = juego.getColumnasA2();
        
        
        
        /*filaAlineacion.remove(4);
        filaAlineacion.remove(5);
        filaAlineacion.remove(6);
        filaAlineacion.remove(7);
        columnaAlineacion.remove(4);
        columnaAlineacion.remove(5);
        columnaAlineacion.remove(6);
        columnaAlineacion.remove(7);*/
        //prueba
        for(Integer i:filaAlineacion){
            System.out.println(i);
        }
        for(Integer i:columnaAlineacion){
            System.out.println(i);
        }
        
        
        
        
        
        //ArrayList<Integer> filast = juego.getFilasAlineacion();
        //ArrayList<Integer> columnast = juego.getColumnasAlineacion();
        /*CORREGIR
        filaAlineacion.add(filast.get(0));
        filaAlineacion.add(filast.get(1));
        filaAlineacion.add(filast.get(2));
        filaAlineacion.add(filast.get(3));
        columnaAlineacion.add(columnast.get(0));
        columnaAlineacion.add(columnast.get(1));
        columnaAlineacion.add(columnast.get(2));
        columnaAlineacion.add(columnast.get(3));
        //prueba
        for(Integer i:filaAlineacion){
            System.out.println(i);
        }
        for(Integer i:columnaAlineacion){
            System.out.println(i);
        }*/
    }
     
    
    //Tomamos los datos de la lista de cartas para llenar el tablero
    public void llenarTablero(){
        /*ArrayList<Carta> cartas = tablero.getCartas();
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
        }*/ 
        /////////////////////////
        
        ArrayList<Carta> cartas = tablero.getCartas();
        //int fila = 0;
        //int columna = 0;
        ArrayList<Integer> num = new ArrayList<>();
        Random aleatorio = new Random(System.currentTimeMillis());
        //for (int i = 0; i<25 ; i++) {
            int intAleatorio = aleatorio.nextInt(55);
            if (num.contains(intAleatorio) == false ){
                //StackPane stcFrijol = new StackPane();
                //Pane paneFrijol = new Pane();
                num.add(intAleatorio);
                Image url = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
                ImageView imgCarta1 = new ImageView(url);
                imgCarta1.setFitHeight(105);
                imgCarta1.setFitWidth(61);
                ////////////
                //Image url00 = new Image(getClass().getResourceAsStream(App.pathimagenes + "frejol.png"));
                //ImageView imgCarta00 = new ImageView(url00);
                //imgCarta00.setFitHeight(40);
                //imgCarta00.setFitWidth(25);
                //paneFrijol.getChildren().add(imgCarta00);
                //stcFrijol.getChildren().add(paneFrijol);
                gpTablero.add(imgCarta1,0,0);  
                //gpTablero.add(stcFrijol,0,0);
                /////////////////////////////
                
                /*prueba poniendo frejol
                Image url00 = new Image(getClass().getResourceAsStream(App.pathimagenes + "frejol.png"));
                ImageView imgCarta00 = new ImageView(url00);
                imgCarta00.setFitHeight(40);
                imgCarta00.setFitWidth(25);
                gpTablero.add(imgCarta00,0,0);*/  
                ////////////////////////////
                Mazo m1 = new Mazo(cartas.get(intAleatorio),0,0);
                mazoAlternante.add(m1);
                
                /*Image url = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
                ImageView img = new ImageView(url);
                
                while(num.contains(intAleatorio) == true){
                    aleatorio = new Random(System.currentTimeMillis());
                    intAleatorio = aleatorio.nextInt(54);
                }
                img.setFitHeight(120);
                img.setFitWidth(90);
                gpTablero.add(img,columna,fila);
                fila++;
                if(fila == 4){
                    fila = 0;
                    columna++;
                }
                 if(columna == 4)
                    columna = 0;*/
            }
        aleatorio = new Random(System.currentTimeMillis());
        intAleatorio = aleatorio.nextInt(54);
            while(num.contains(intAleatorio) == true){
                    aleatorio = new Random(System.currentTimeMillis());
                    intAleatorio = aleatorio.nextInt(54);
                }
            num.add(intAleatorio);
            Image url = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
            ImageView imgCarta2 = new ImageView(url);
            imgCarta2.setFitHeight(105);
            imgCarta2.setFitWidth(61);
            gpTablero.add(imgCarta2,1,0); 
            Mazo m1 = new Mazo(cartas.get(intAleatorio),1,0);
            mazoAlternante.add(m1);
            
            //imgCarta2.setImage(new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen())));
            
        //IMAGENCARTA 3
        aleatorio = new Random(System.currentTimeMillis());
        intAleatorio = aleatorio.nextInt(53);
        while(num.contains(intAleatorio) == true){
                    aleatorio = new Random(System.currentTimeMillis());
                    intAleatorio = aleatorio.nextInt(53);
                }
            num.add(intAleatorio);
            Image url1 = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
            ImageView imgCarta3 = new ImageView(url1);
            imgCarta3.setFitHeight(105);
            imgCarta3.setFitWidth(61);
            gpTablero.add(imgCarta3,2,0); 
            Mazo m2 = new Mazo(cartas.get(intAleatorio),2,0);
            mazoAlternante.add(m2);
            
            //imgCarta3.setImage(new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen())));
            
        //IMAGENCARTA 4
        aleatorio = new Random(System.currentTimeMillis());
        intAleatorio = aleatorio.nextInt(52);
        while(num.contains(intAleatorio) == true){
                    aleatorio = new Random(System.currentTimeMillis());
                    intAleatorio = aleatorio.nextInt(52);
                }
            num.add(intAleatorio);
            Image url2 = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
            ImageView imgCarta4 = new ImageView(url2);
            imgCarta4.setFitHeight(105);
            imgCarta4.setFitWidth(61);
            gpTablero.add(imgCarta4,3,0); 
            Mazo m3 = new Mazo(cartas.get(intAleatorio),3,0);
            mazoAlternante.add(m3);
            
            //imgCarta4.setImage(new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen())));
            
        //IMAGEN CARTA 5
        aleatorio = new Random(System.currentTimeMillis());
        intAleatorio = aleatorio.nextInt(51);
        while(num.contains(intAleatorio) == true){
                    aleatorio = new Random(System.currentTimeMillis());
                    intAleatorio = aleatorio.nextInt(51);
                }
            num.add(intAleatorio);
            Image url3 = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
            ImageView imgCarta5 = new ImageView(url3);
            imgCarta5.setFitHeight(105);
            imgCarta5.setFitWidth(61);
            gpTablero.add(imgCarta5,0,1); 
            Mazo m4 = new Mazo(cartas.get(intAleatorio),0,1);
            mazoAlternante.add(m4);
            
            //imgCarta5.setImage(new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen())));
            
        //IMAGEN CARTA 6
        aleatorio = new Random(System.currentTimeMillis());
        intAleatorio = aleatorio.nextInt(50);
        while(num.contains(intAleatorio) == true){
                    aleatorio = new Random(System.currentTimeMillis());
                    intAleatorio = aleatorio.nextInt(50);
                }
            num.add(intAleatorio);
            Image url4 = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
            ImageView imgCarta6 = new ImageView(url4);
            imgCarta6.setFitHeight(105);
            imgCarta6.setFitWidth(61);
            gpTablero.add(imgCarta6,1,1);
            Mazo m5 = new Mazo(cartas.get(intAleatorio),1,1);
            mazoAlternante.add(m5);
            
            //imgCarta6.setImage(new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen())));
            
        //IMAGEN CARATA 7
        aleatorio = new Random(System.currentTimeMillis());
        intAleatorio = aleatorio.nextInt(49);
        while(num.contains(intAleatorio) == true){
                    aleatorio = new Random(System.currentTimeMillis());
                    intAleatorio = aleatorio.nextInt(49);
                }
            num.add(intAleatorio);
            Image url5 = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
            ImageView imgCarta7 = new ImageView(url5);
            imgCarta7.setFitHeight(105);
            imgCarta7.setFitWidth(61);
            gpTablero.add(imgCarta7,2,1);
            Mazo m6 = new Mazo(cartas.get(intAleatorio),2,1);
            mazoAlternante.add(m6);
            
            //imgCarta7.setImage(new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen())));
            
        //IMAGEN CARTA 8
        aleatorio = new Random(System.currentTimeMillis());
        intAleatorio = aleatorio.nextInt(48);
        while(num.contains(intAleatorio) == true){
                    aleatorio = new Random(System.currentTimeMillis());
                    intAleatorio = aleatorio.nextInt(48);
                }
            num.add(intAleatorio);
            Image url6 = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
            ImageView imgCarta8 = new ImageView(url6);
            imgCarta8.setFitHeight(105);
            imgCarta8.setFitWidth(61);
            gpTablero.add(imgCarta8,3,1);
            Mazo m7 = new Mazo(cartas.get(intAleatorio),3,1);
            mazoAlternante.add(m7);
            
            //imgCarta8.setImage(new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen())));
            
        //IMAGEN CARTA 9
        aleatorio = new Random(System.currentTimeMillis());
        intAleatorio = aleatorio.nextInt(47);
        while(num.contains(intAleatorio) == true){
                    aleatorio = new Random(System.currentTimeMillis());
                    intAleatorio = aleatorio.nextInt(47);
                }
            num.add(intAleatorio);
            Image url7 = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
            ImageView imgCarta9 = new ImageView(url7);
            imgCarta9.setFitHeight(105);
            imgCarta9.setFitWidth(61);
            gpTablero.add(imgCarta9,0,2);
            Mazo m8 = new Mazo(cartas.get(intAleatorio),0,2);
            mazoAlternante.add(m8);
            
            //imgCarta9.setImage(new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen())));
            
        //IMAGEN CARTA 10
        aleatorio = new Random(System.currentTimeMillis());
        intAleatorio = aleatorio.nextInt(46);
        while(num.contains(intAleatorio) == true){
                    aleatorio = new Random(System.currentTimeMillis());
                    intAleatorio = aleatorio.nextInt(46);
                }
            num.add(intAleatorio);
            Image url8 = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
            ImageView imgCarta10 = new ImageView(url8);
            imgCarta10.setFitHeight(105);
            imgCarta10.setFitWidth(61);
            gpTablero.add(imgCarta10,1,2);
            Mazo m9 = new Mazo(cartas.get(intAleatorio),1,2);
            mazoAlternante.add(m9);
            
            //imgCarta10.setImage(new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen())));
            
        //IMAGEN CARTA 11
        aleatorio = new Random(System.currentTimeMillis());
        intAleatorio = aleatorio.nextInt(46);
        while(num.contains(intAleatorio) == true){
                    aleatorio = new Random(System.currentTimeMillis());
                    intAleatorio = aleatorio.nextInt(46);
                }
            num.add(intAleatorio);
            Image url9 = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
            ImageView imgCarta11 = new ImageView(url9);
            imgCarta11.setFitHeight(105);
            imgCarta11.setFitWidth(61);
            gpTablero.add(imgCarta11,2,2);
            Mazo m10 = new Mazo(cartas.get(intAleatorio),2,2);
            mazoAlternante.add(m10);
            
            //imgCarta11.setImage(new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen())));
            
        //IMAGEN CARTA 12
        aleatorio = new Random(System.currentTimeMillis());
        intAleatorio = aleatorio.nextInt(45);
        while(num.contains(intAleatorio) == true){
                    aleatorio = new Random(System.currentTimeMillis());
                    intAleatorio = aleatorio.nextInt(45);
                }
            num.add(intAleatorio);
            Image url10 = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
            ImageView imgCarta12 = new ImageView(url10);
            imgCarta12.setFitHeight(105);
            imgCarta12.setFitWidth(61);
            gpTablero.add(imgCarta12,3,2);
            Mazo m11 = new Mazo(cartas.get(intAleatorio),3,2);
            mazoAlternante.add(m11);
            
            //imgCarta12.setImage(new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen())));
            
        //IMAGEN CARTA 13
        aleatorio = new Random(System.currentTimeMillis());
        intAleatorio = aleatorio.nextInt(44);
        while(num.contains(intAleatorio) == true){
                    aleatorio = new Random(System.currentTimeMillis());
                    intAleatorio = aleatorio.nextInt(53);
                }
            num.add(intAleatorio);
            Image url11 = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
            ImageView imgCarta13 = new ImageView(url11);
            imgCarta13.setFitHeight(105);
            imgCarta13.setFitWidth(61);
            gpTablero.add(imgCarta13,0,3);
            Mazo m12 = new Mazo(cartas.get(intAleatorio),0,3);
            mazoAlternante.add(m12);
            
            //imgCarta13.setImage(new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen())));
            
        //IMAGEN CARTA 14
        aleatorio = new Random(System.currentTimeMillis());
        intAleatorio = aleatorio.nextInt(43);
        while(num.contains(intAleatorio) == true){
                    aleatorio = new Random(System.currentTimeMillis());
                    intAleatorio = aleatorio.nextInt(43);
                }
            num.add(intAleatorio);
            Image url12 = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
            ImageView imgCarta14 = new ImageView(url12);
            imgCarta14.setFitHeight(105);
            imgCarta14.setFitWidth(61);
            gpTablero.add(imgCarta14,1,3);
            Mazo m13 = new Mazo(cartas.get(intAleatorio),1,3);
            mazoAlternante.add(m13);
            
            //imgCarta14.setImage(new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen())));
            
        //IMAGEN CARTA 15
        aleatorio = new Random(System.currentTimeMillis());
        intAleatorio = aleatorio.nextInt(42);
        while(num.contains(intAleatorio) == true){
                    aleatorio = new Random(System.currentTimeMillis());
                    intAleatorio = aleatorio.nextInt(42);
                }
            num.add(intAleatorio);
            Image url13 = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
            ImageView imgCarta15 = new ImageView(url13);
            imgCarta15.setFitHeight(105);
            imgCarta15.setFitWidth(61);
            gpTablero.add(imgCarta15,2,3);
            Mazo m14 = new Mazo(cartas.get(intAleatorio),2,3);
            mazoAlternante.add(m14);
            
            //imgCarta15.setImage(new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen())));
            
        //IMAGEN CARTA 16
        aleatorio = new Random(System.currentTimeMillis());
        intAleatorio = aleatorio.nextInt(41);
        while(num.contains(intAleatorio) == true){
                    aleatorio = new Random(System.currentTimeMillis());
                    intAleatorio = aleatorio.nextInt(41);
                }
            num.add(intAleatorio);
            Image url14 = new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen()));
            ImageView imgCarta16 = new ImageView(url14);
            imgCarta16.setFitHeight(105);
            imgCarta16.setFitWidth(61);
            gpTablero.add(imgCarta16,3,3);
            Mazo m15 = new Mazo(cartas.get(intAleatorio),3,3);
            mazoAlternante.add(m15);
            
            //imgCarta16.setImage(new Image(getClass().getResourceAsStream(cartas.get(intAleatorio).getRutaImagen())));
            
    }
    
    ////////////////////////
        public void marcarCarta1(javafx.scene.input.MouseEvent event) {
        //StackPane stcfrijol = new StackPane();
        //Pane pnfrijol = new Pane();
        Node clickedNode = event.getPickResult().getIntersectedNode();
        int colIndex = 0;
        int rowIndex = 0;
        if (clickedNode != gpTablero) {
            // click on descendant node
            colIndex = GridPane.getColumnIndex(clickedNode);
            rowIndex = GridPane.getRowIndex(clickedNode);
            System.out.println("Mouse clicked cell: " + colIndex + " And: " + rowIndex);
            filasMarcadas.add(rowIndex);
            columnasMarcadas.add(colIndex);
            
    }
        ponerFrejol(colIndex, rowIndex);
        //marcarCarta(colIndex, rowIndex);
        
        //PRUEBA
        for (Mazo m1: mazoAlternante){
            System.out.println("La fila es " + m1.getColumna());
            
            
        /*Node result = null;
        ObservableList<Node> childrens = gpTablero.getChildren();

        for (Node node : childrens) {
        if(gpTablero.getRowIndex(node) == rowIndex && gpTablero.getColumnIndex(node) == colIndex) {
            result = node;
            System.out.println(result.getClass());
            break;
            
        }*/
        
        }
        
}//////////////////////
        
    public void ponerFrejol(int colIndex, int rowIndex){
        StackPane stcFrijol = new StackPane();
        Pane paneFrijol = new Pane();
        Image url00 = new Image(getClass().getResourceAsStream(App.pathimagenes + "frejol.png"));
        ImageView imgCarta00 = new ImageView(url00);
        imgCarta00.setFitHeight(40);
        imgCarta00.setFitWidth(25);
        paneFrijol.getChildren().add(imgCarta00);
        stcFrijol.getChildren().add(paneFrijol);
        gpTablero.add(stcFrijol,colIndex, rowIndex);
        

        //paneFrijol.getChildren().add(imgCarta00);
        //gpTablero.add(paneFrijol,0,0);
        //gpTablero.add(pnfrijol,0,0);
    }    
        
    //verifiacion que la carta que se clikea sea la misma del mazo
    //recibe como parametros la columna y la fila que se clickea
    //etse metodo iria dentro cuando se clickea
    public void VerificarCartaMazo(int colIndex, int rowIndex){
        for(Mazo m: mazoAlternante){
            if(m.getColumna() == colIndex && m.getFila() == rowIndex){
                System.out.println("ssi esta bien xdxdxd");
                for(Carta c: cartaMazo){
                    //comparacion
                    if(c.equals(m.getCarta())){
                        System.out.println("ESTA MAS BIEN XDXDXDXD");
                        //agregado una x cuando sale bien la coincidencia
                        //filasMarcadas.add(rowIndex);
                        //columnasMarcadas.add(colIndex);
                        System.out.println("La fila es " + filasMarcadas);
                        
                                
                    }
                    //si coge                                                                                                                                                                                                                          
                }
            }else{
                System.out.println("esta mal  xdxdxd");
            }
        }
    } 
    ////////////
    //esta se va a llamar cuando se aprete el boton
    public void VerificarCartaAlineacion(ActionEvent event){
        for(Integer i: juego.getColumnasA2()){
            System.out.println(i);
        }
        int i = 0;
        while(i < 4){
            int f = filaAlineacion.get(i);
            int c = columnaAlineacion.get(i);
            for(Mazo m:mazoAlternante){
                if(f == m.getFila() && c == m.getColumna()){
                    i++;
                }else{
                    mostrarAlerta("No tiene la alineacion completa", Alert.AlertType.ERROR);
                    
            }
        }
    
    }
    }
        
        ////////////////////
    public static void mostrarAlerta(String mensaje, Alert.AlertType e){
        Alert alert = new Alert(e);
        alert.setTitle("");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }    
        //////////////////
        ////////////
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
                //lenar en la lista de cartasmazo
                cartaMazo.add(c);
                
                
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



