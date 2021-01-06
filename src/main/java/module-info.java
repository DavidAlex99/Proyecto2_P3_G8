module com.mycompany.proyecto_parcial2_2020 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.proyecto_parcial2_2020 to javafx.fxml;
    exports com.mycompany.proyecto_parcial2_2020;
}