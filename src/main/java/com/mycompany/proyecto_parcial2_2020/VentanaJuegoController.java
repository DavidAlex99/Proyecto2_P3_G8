/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_parcial2_2020;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author alexx
 */
public class VentanaJuegoController implements Initializable {


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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
}
