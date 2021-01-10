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
    }

    @FXML
    private void reporte(ActionEvent event) {
    }

    @FXML
    private void configuraciones(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
