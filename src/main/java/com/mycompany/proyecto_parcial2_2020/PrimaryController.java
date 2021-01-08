package com.mycompany.proyecto_parcial2_2020;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {
    @FXML
    private Button btnOpciones;
    @FXML
    private Button btnCofiguraciones;
    @FXML
    private Button btnReporte;
    @FXML
    private Button btnuevoJuego;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    //hacer metodos para hacer switch a las ventanas de configuracioes, reporte etc
}
