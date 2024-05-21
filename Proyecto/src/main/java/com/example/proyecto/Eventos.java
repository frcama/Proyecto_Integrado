package com.example.proyecto;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Eventos  implements Initializable {


    FileChooser fileChooser = new FileChooser();

    @javafx.fxml.FXML
    private Pane panelDesplegableNOVEDADES;
    @javafx.fxml.FXML
    private Button addButton11;
    @javafx.fxml.FXML
    private Button alquileresBOTON1;
    @javafx.fxml.FXML
    private ImageView PerfilBOTON1;
    @javafx.fxml.FXML
    private Button novedadesBOTON1;
    @javafx.fxml.FXML
    private Button eventosBOTON1;
    @javafx.fxml.FXML
    private Button librosBOTON1;
    @javafx.fxml.FXML
    private Button perfilBOTON1;
    @javafx.fxml.FXML
    private AnchorPane PanelEventos;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // fileChooser.setInitialDirectory(new File("C:\\Users\\TSMR1\\Pictures"));
    }


    @javafx.fxml.FXML
    public void onAddClicked(ActionEvent actionEvent) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("anadir.fxml"));
            this.PanelEventos.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @javafx.fxml.FXML
    public void perfilBOTONclick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Perfil.fxml"));
            this.PanelEventos.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Deprecated
    public void chatNovedadesclick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void librosBOTONclick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Libros.fxml"));
            this.PanelEventos.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void alquileresBOTONclick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Alquileres.fxml"));
            this.PanelEventos.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void novedadesBOTONclick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.PanelEventos.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void eventosBOTONclick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Eventos.fxml"));
            this.PanelEventos.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
