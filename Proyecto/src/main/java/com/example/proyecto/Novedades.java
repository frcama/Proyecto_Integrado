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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
private Button perfilBOTON;
@FXML
private Button addButton11;
@FXML
private AnchorPane PanelNovedades;
@FXML
private MenuItem FondoBlanco;
@FXML
private Button novedadesBOTON;
@FXML
private MenuItem FondoOscuro;
@FXML
private Button alquileresBOTON;
@FXML
private Button eventosBOTON;
@FXML
private MenuItem ChatAyuda;
@FXML
private Button librosBOTON;
@FXML
private ScrollPane novedadesScollPane;
@FXML
private GridPane cosasGripPaneNovedades;
@FXML
private HBox panelHBoxNovedades;


    @Override
public void initialize(URL location, ResourceBundle resources) {

    perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
    perfilBOTON.setOnMouseEntered(e -> perfilBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
    perfilBOTON.setOnMouseExited(e -> perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

    //funciones de botones

    novedadesBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);");

}
//-----------------------------------------------------------------------------------------------
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
//-----------------------------------------------------------------------------------------------

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

//-----------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------

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
//-----------------------------------------------------------------------------------------------
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
//-----------------------------------------------------------------------------------------------
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




@FXML
public void FondoBlancoclick(ActionEvent actionEvent) {
    System.out.println("funciona");

    try {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
        this.PanelNovedades.getChildren().setAll(pane);
    } catch (IOException ex) {
        Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
    }
}

@FXML
public void FondoOscuroclick(ActionEvent actionEvent) {
    System.out.println("funciona");

    try {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("NovedadesOs.fxml"));
        this.PanelNovedades.getChildren().setAll(pane);
    } catch (IOException ex) {
        Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
    }
}

@FXML
public void ChatAyudaclick(ActionEvent actionEvent) {
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
}
