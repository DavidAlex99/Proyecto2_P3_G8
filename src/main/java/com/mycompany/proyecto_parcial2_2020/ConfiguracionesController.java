/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_parcial2_2020;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
/**
 * FXML Controller class
 *
 * @author PC
 */
public class ConfiguracionesController implements Initializable {


    @FXML
    private Button btAceptar;
    @FXML
    private Button btRegresar;
    @FXML
    private ComboBox<String> cbCantidad;
    @FXML
    private ComboBox<String> cbVisibilidad;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("1","2");
        cbCantidad.setItems(list);
        
        ObservableList<String> list2 = FXCollections.observableArrayList("Visible", "Oculto");
        cbVisibilidad.setItems(list2);
    }    
    
    @FXML
    private void botonAceptar(ActionEvent event) {
    }

    @FXML
    private void botonRegresar(ActionEvent event) {
         try{
            App.setRoot("Primary");
        }catch(Exception e){
            
        }
    }

}
