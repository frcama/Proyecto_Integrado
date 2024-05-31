package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Terminos {


    @javafx.fxml.FXML
    private Button aceptarTerminosBOTON;
    @javafx.fxml.FXML
    private Button cancelarTerminosBOTON;
    @javafx.fxml.FXML
    private AnchorPane panelTerminos;

    @javafx.fxml.FXML
    public void cancelarTerminosBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona bien");
        try {
            // Cargar la vista de inicio de sesión al cancelar los términos
            AnchorPane pane = FXMLLoader.load(getClass().getResource("inicio_sesion.fxml"));
            // Establecer la vista de inicio de sesión en el panel de términos
            this.panelTerminos.getChildren().setAll(pane);
        } catch (IOException ex) {
            // Manejar cualquier excepción de E/S que ocurra durante la carga de la vista
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @javafx.fxml.FXML
    public void aceptarTerminosBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona bien");
        try {
            // Cargar la vista de novedades al aceptar los términos
            AnchorPane pane = FXMLLoader.load(getClass().getResource("inicio_sesion.fxml"));
            // Establecer la vista de novedades en el panel de términos
            this.panelTerminos.getChildren().setAll(pane);
        } catch (IOException ex) {
            // Manejar cualquier excepción de E/S que ocurra durante la carga de la vista
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
