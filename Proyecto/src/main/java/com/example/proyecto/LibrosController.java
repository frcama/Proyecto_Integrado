package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibrosController implements Initializable {


    @FXML
    private Button perfilBOTON;
    @FXML
    private AnchorPane PanelDeLibros;
    @FXML
    private ImageView PerfilBOTON1;
    @FXML
    private ColumnConstraints col2GripPane;
    @FXML
    private ChoiceBox precioFiltroChoicebox;
    @FXML
    private ChoiceBox nHabitacioneschoiceBox;
    @FXML
    private ColumnConstraints col1GripPane;
    @FXML
    private GridPane cosasGripPane;
    @FXML
    private Button filtrarButton;
    @FXML
    private ChoiceBox zonaFiltroChoicebox;
    @FXML
    private Button eventosBOTON2;
    @FXML
    private Button novedadesBOTON2;
    @FXML
    private Button alquileresBOTON2;
    @FXML
    private Button librosBOTON2;
    @FXML
    private Button addButton2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        perfilBOTON.setOnMouseEntered(e -> perfilBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        perfilBOTON.setOnMouseExited(e -> perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        librosBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);");

    }



    @FXML
    public void perfilBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Perfil.fxml"));
            this.PanelDeLibros.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    @Deprecated
    public void librosBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Libros.fxml"));
            this.PanelDeLibros.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Deprecated
    public void alquileresBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Alquileres.fxml"));
            this.PanelDeLibros.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Deprecated
    public void novedadesBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.PanelDeLibros.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Deprecated
    public void eventosBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Eventos.fxml"));
            this.PanelDeLibros.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ChatLibros(){
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Chat.fxml"));
            this.PanelDeLibros.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Deprecated
    public void onAddClicked(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("AnyadirLibros.fxml"));
            this.PanelDeLibros.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void filtrarBottonClick(ActionEvent actionEvent) {
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

