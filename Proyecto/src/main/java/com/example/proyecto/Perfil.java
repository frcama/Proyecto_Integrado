package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Perfil {
    @javafx.fxml.FXML
    private Button atrasDePerfilBOTON;
    @javafx.fxml.FXML
    private AnchorPane panelDePerfil;
    @javafx.fxml.FXML
    private Button EditarFotoPerfil;

    @javafx.fxml.FXML
    public void atrasDePerfilBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.panelDePerfil.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void EditarFotoPerfilclick(ActionEvent actionEvent) {
    }
}
