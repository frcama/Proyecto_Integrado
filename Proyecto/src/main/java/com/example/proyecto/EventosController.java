package com.example.proyecto;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventosController implements Initializable {


    FileChooser fileChooser = new FileChooser();

    @javafx.fxml.FXML
    private AnchorPane PanelEventos;
    @javafx.fxml.FXML
    private Button perfilBOTON;
    @javafx.fxml.FXML
    private MenuItem chatNovedades;
    @javafx.fxml.FXML
    private Button novedadesBOTON;
    @javafx.fxml.FXML
    private Pane panelDesplegableEventos;
    @javafx.fxml.FXML
    private ImageView PerfilBOTON;
    @javafx.fxml.FXML
    private Button alquileresBOTON;
    @javafx.fxml.FXML
    private Button eventosBOTON;
    @javafx.fxml.FXML
    private Button addButton;
    @javafx.fxml.FXML
    private Button librosBOTON;


    public void initialize(URL location, ResourceBundle resources) {
        perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        perfilBOTON.setOnMouseEntered(e -> perfilBOTON.setStyle("-fx-background-color: linear-gradient(to right, #0000FF, #EE82EE); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        perfilBOTON.setOnMouseExited(e -> perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        novedadesBOTON.setStyle("-fx-background-color: #c2c2c2;");
        novedadesBOTON.setOnMouseEntered(e -> novedadesBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);"));
        novedadesBOTON.setOnMouseExited(e -> novedadesBOTON.setStyle("-fx-background-color: #c2c2c2;"));

        alquileresBOTON.setStyle("-fx-background-color: #c2c2c2;");
        alquileresBOTON.setOnMouseEntered(e -> alquileresBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);"));
        alquileresBOTON.setOnMouseExited(e -> alquileresBOTON.setStyle("-fx-background-color: #c2c2c2;"));

        addButton.setStyle("-fx-background-color: #c2c2c2;");
        addButton.setOnMouseEntered(e -> addButton.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);"));
        addButton.setOnMouseExited(e -> addButton.setStyle("-fx-background-color: #c2c2c2;"));

        librosBOTON.setStyle("-fx-background-color: #c2c2c2;");
        librosBOTON.setOnMouseEntered(e -> librosBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);"));
        librosBOTON.setOnMouseExited(e -> librosBOTON.setStyle("-fx-background-color: #c2c2c2;"));

        eventosBOTON.setStyle("-fx-background-color: #c2c2c2;");
        eventosBOTON.setOnMouseEntered(e -> eventosBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);"));
        eventosBOTON.setOnMouseExited(e -> eventosBOTON.setStyle("-fx-background-color: #c2c2c2;"));
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

    @javafx.fxml.FXML
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
