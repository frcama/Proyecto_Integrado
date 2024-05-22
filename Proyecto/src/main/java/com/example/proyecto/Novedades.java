package com.example.proyecto;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Novedades implements Initializable {

    @FXML
    private Button perfilBOTON;
    @FXML
    private Pane panelDesplegableNOVEDADES;
    @FXML
    private Button novedadesBOTON;
    @FXML
    private ImageView PerfilBOTON;
    @FXML
    private Button alquileresBOTON;
    @FXML
    private Button eventosBOTON;
    @FXML
    private Button librosBOTON;
    @FXML
    private AnchorPane PanelNovedades;
    @FXML
    private MenuItem chatNovedades;
    @FXML
    private Menu menuAyuda;
    @FXML
    private Menu menuMO;
    @FXML
    private MenuBar menuMenuBar;
    @FXML
    private Button addButton11;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        perfilBOTON.setOnMouseEntered(e -> perfilBOTON.setStyle("-fx-background-color: linear-gradient(to right, #0000FF, #EE82EE); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        perfilBOTON.setOnMouseExited(e -> perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        //funciones de botones

        novedadesBOTON.setStyle("-fx-background-color: #c2c2c2;");
        novedadesBOTON.setOnMouseEntered(e -> novedadesBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);"));
        novedadesBOTON.setOnMouseExited(e -> novedadesBOTON.setStyle("-fx-background-color: #c2c2c2;"));

        alquileresBOTON.setStyle("-fx-background-color: #c2c2c2;");
        alquileresBOTON.setOnMouseEntered(e -> alquileresBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);"));
        alquileresBOTON.setOnMouseExited(e -> alquileresBOTON.setStyle("-fx-background-color: #c2c2c2;"));

        librosBOTON.setStyle("-fx-background-color: #c2c2c2;");
        librosBOTON.setOnMouseEntered(e -> librosBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);"));
        librosBOTON.setOnMouseExited(e -> librosBOTON.setStyle("-fx-background-color: #c2c2c2;"));

        eventosBOTON.setStyle("-fx-background-color: #c2c2c2;");
        eventosBOTON.setOnMouseEntered(e -> eventosBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);"));
        eventosBOTON.setOnMouseExited(e -> eventosBOTON.setStyle("-fx-background-color: #c2c2c2;"));

    }

// #00C9FF
    @FXML
    public void perfilBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Perfil.fxml"));
            this.PanelNovedades.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




    @FXML
    public void librosBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Libros.fxml"));
            this.PanelNovedades.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    public void alquileresBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Alquileres.fxml"));
            this.PanelNovedades.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    public void novedadesBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.PanelNovedades.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void eventosBOTONclick(ActionEvent actionEvent) {
            System.out.println("funciona");

            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("Eventos.fxml"));
                this.PanelNovedades.getChildren().setAll(pane);
            } catch (IOException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    public void chatNovedadesclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Chat.fxml"));
            this.PanelNovedades.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    public void onAddClicked(ActionEvent actionEvent) {
    }
}
