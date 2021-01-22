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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author cholo
 */
public class JugadorController implements Initializable {

    @FXML
    private Button btnjuego;
    @FXML
    private TextField txtNombre;
    @FXML
    private Button btnGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    

    @FXML
    private void ingresaJuego(ActionEvent event) {
        
        try{
            App.setRoot("VentanaJuego");
        }catch(Exception e){
            
        }
        //System.out.println(txtNombre.getText());
    }

    @FXML
    private void guardarDatos(ActionEvent event) {
        System.out.println(txtNombre.getText());
    }
    
}
