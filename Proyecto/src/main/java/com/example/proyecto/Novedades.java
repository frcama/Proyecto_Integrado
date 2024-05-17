package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Novedades {


    @javafx.fxml.FXML
    private Pane panelDesplegableNOVEDADES;
    @javafx.fxml.FXML
    private AnchorPane PanelNovedades;
    @javafx.fxml.FXML
    private Button novedadesBOTON;
    @javafx.fxml.FXML
    private ImageView PerfilBOTON;
    @javafx.fxml.FXML
    private Button alquileresBOTON;
    @javafx.fxml.FXML
    private Button eventosBOTON;
    @javafx.fxml.FXML
    private Button librosBOTON;


    public void librosBOTON(ActionEvent actionEvent) {
        System.out.println("funciona");
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Libros.fxml"));
            this.PanelNovedades.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
