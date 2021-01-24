/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_parcial2_2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import modelo.Configuracion;
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
    
    //private Configuracion configuracion = new Configuracion();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Agrega valores a los combobox
        ObservableList<String> list = FXCollections.observableArrayList("1","2");
        cbCantidad.setItems(list);
        
        ObservableList<String> list2 = FXCollections.observableArrayList("Visible", "Oculto");
        cbVisibilidad.setItems(list2);
    }    
    
    @FXML
    private void botonAceptar(ActionEvent event) {
        
      //Toma los valores escogidos en el comboBox
        Configuracion configuracion = new Configuracion(Integer.parseInt(cbCantidad.getValue()), cbVisibilidad.getValue());
        
        
         
        //Crea el archivo donde se guardaran los datos escogidos por el usuario
        File file =new File("visibilidad.ser");
        
        try {
             
            FileOutputStream fileOutput = new FileOutputStream(file);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            ArrayList<Configuracion> lista = new ArrayList<Configuracion>();
            lista.add(configuracion);
            objectOutput.writeObject(lista);
            objectOutput.flush();
            objectOutput.close();
            fileOutput.close();
            System.out.println("Datos guardados correctamente");
 
        } catch (FileNotFoundException e) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException e) {
            System.out.println("Error: Fallo en la escritura en el fichero. ");
        }
        
    }

    @FXML
    private void botonRegresar(ActionEvent event) {
         try{
            App.setRoot("Primary");
        }catch(Exception e){
            
        }
    }

}
