/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_parcial2_2020;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class ConfiguracionesController implements Initializable {

    @FXML
    private ChoiceBox<?> chCantidad;
    @FXML
    private ChoiceBox<?> chVisibilidad;
    @FXML
    private Button btAceptar;
   
    @FXML
    private Button btRegresar;

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        // TODO
    }    

    @FXML
    private void botonAceptar(ActionEvent event) {
    }


    @FXML
    private void botonRegresar(ActionEvent event) {
        try{
            App.setRoot("primary");
        }catch(Exception e){
       }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
}
