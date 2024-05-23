package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NovedadesOS implements Initializable {

    @javafx.fxml.FXML
    private Button perfilBOTON2;
    @javafx.fxml.FXML
    private MenuItem ChatAyudaOS;
    @javafx.fxml.FXML
    private Button BOTONNOVEDADES2;
    @javafx.fxml.FXML
    private Button eventosBOTON2;
    @javafx.fxml.FXML
    private Button alquileresBOTON2;
    @javafx.fxml.FXML
    private Button librosBOTON2;
    @javafx.fxml.FXML
    private Button addButton112;
    @javafx.fxml.FXML
    private ImageView PerfilBOTON;
    @javafx.fxml.FXML
    private MenuItem FondoBlancoOS;
    @javafx.fxml.FXML
    private MenuItem FondoOscuroOS;
    @javafx.fxml.FXML
    private AnchorPane PanelNovedadesOscuro;

    @Deprecated
    public void onAddClicked(ActionEvent actionEvent) {
    }

    @Deprecated
    public void perfilBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Perfil.fxml"));
            this.PanelNovedadesOscuro.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Deprecated
    public void chatNovedadesclick(ActionEvent actionEvent) {
        System.out.println("funciona");
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Chat.fxml"));
            this.PanelNovedadesOscuro.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Deprecated
    public void librosBOTONclick(ActionEvent actionEvent) {
    }

    @Deprecated
    public void alquileresBOTONclick(ActionEvent actionEvent) {
    }

    @Deprecated
    public void novedadesBOTONclick(ActionEvent actionEvent) {
    }

    @Deprecated
    public void eventosBOTONclick(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        perfilBOTON2.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        perfilBOTON2.setOnMouseEntered(e -> perfilBOTON2.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        perfilBOTON2.setOnMouseExited(e -> perfilBOTON2.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        //funciones de botones

        BOTONNOVEDADES2.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);");

    }

    @javafx.fxml.FXML
    public void perfilBOTON2click(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void eventosBOTON2click(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void FondoOscuroOSclick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void librosBOTON2click(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onAdd2Clicked(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void FondoBlancoOS(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.PanelNovedadesOscuro.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void alquileresBOTON2click(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ChatAyudaOSclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Chat.fxml"));
            this.PanelNovedadesOscuro.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void BOTONNOVEDADES2CLICK(ActionEvent actionEvent) {
    }
}
