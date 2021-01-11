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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author PC
 */
public class ReporteController implements Initializable {


    @FXML
    private TextField tfReporte;
    @FXML
    private Label lbReporte;
    @FXML
    private Button btRegresar;
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        // TODO
    }    
    
    @FXML
    private void mostrarReporte(ActionEvent event) {
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
