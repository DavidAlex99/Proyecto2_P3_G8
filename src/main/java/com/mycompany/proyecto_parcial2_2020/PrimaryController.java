/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_parcial2_2020;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
/**
 * FXML Controller class
 *
 * @author PC
 */
public class PrimaryController implements Initializable {


    @FXML
    private Label lbLoteria;
    @FXML
    private Button btnNuevoJuego;
    @FXML
    private Button btnReporte;
    @FXML
    private Button btnConfiguraciones;
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        // TODO
    }    
    
    @FXML
    private void nuevoJuego(ActionEvent event) {
        try{
            App.setRoot("VentanaJuego");
        }catch(Exception e){
            
        }
        
    }

    @FXML
    private void reporte(ActionEvent event) {
        try{
            App.setRoot("reporte");
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }
    @FXML
    private void configuraciones(ActionEvent event) {
        try{
            App.setRoot("configuraciones");
        }catch(Exception e){
    }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //To change body of generated methods, choose Tools | Templates.
    }

}
