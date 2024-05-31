package com.example.pruebaproyecto;

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
            AnchorPane pane = FXMLLoader.load(getClass().getResource("inicio_sesion.fxml"));
            this.panelTerminos.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @javafx.fxml.FXML
    public void aceptarTerminosBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona bien");
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.panelTerminos.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
