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
    private ImageView PerfilBOTON;
    @FXML
    private AnchorPane PanelNovedades;
    @FXML
    private Button perfilBOTON2;
    @FXML
    private Button eventosBOTON2;
    @FXML
    private Button alquileresBOTON2;
    @FXML
    private Button novedadesBOTON2;
    @FXML
    private Button librosBOTON2;
    @FXML
    private Button addButton112;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        perfilBOTON.setOnMouseEntered(e -> perfilBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        perfilBOTON.setOnMouseExited(e -> perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        //funciones de botones

        novedadesBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);");

    }

    @Deprecated
    public void perfilBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Perfil.fxml"));
            this.PanelNovedades.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




    @Deprecated
    public void librosBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Libros.fxml"));
            this.PanelNovedades.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Deprecated
    public void alquileresBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Alquileres.fxml"));
            this.PanelNovedades.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Deprecated
    public void novedadesBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.PanelNovedades.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Deprecated
    public void eventosBOTONclick(ActionEvent actionEvent) {
            System.out.println("funciona");

            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("Eventos.fxml"));
                this.PanelNovedades.getChildren().setAll(pane);
            } catch (IOException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Deprecated
    public void chatNovedadesclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Chat.fxml"));
            this.PanelNovedades.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Deprecated
    public void onAddClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void perfilBOTON2click(ActionEvent actionEvent) {
    }

    @FXML
    public void eventosBOTON2click(ActionEvent actionEvent) {
    }

    @FXML
    public void librosBOTON2click(ActionEvent actionEvent) {
    }

    @FXML
    public void onAdd2Clicked(ActionEvent actionEvent) {
    }

    @FXML
    public void alquileresBOTON2click(ActionEvent actionEvent) {
    }

    @FXML
    public void novedadesBOTON2click(ActionEvent actionEvent) {
    }
}
