package com.example.proyecto;


import javafx.event.ActionEvent;
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
    private ImageView PerfilBOTON;
    @javafx.fxml.FXML
    private ImageView novedadesBOTON;
    @javafx.fxml.FXML
    private ColumnConstraints col2GripPane;
    @javafx.fxml.FXML
    private ChoiceBox precioFiltroChoicebox;
    @javafx.fxml.FXML
    private ChoiceBox nHabitacioneschoiceBox;
    @javafx.fxml.FXML
    private ColumnConstraints col1GripPane;
    @javafx.fxml.FXML
    private GridPane cosasGripPane;
    @javafx.fxml.FXML
    private Button filtrarButton;
    @javafx.fxml.FXML
    private ChoiceBox zonaFiltroChoicebox;
    @javafx.fxml.FXML
    private Button perfilBOTON;
    @javafx.fxml.FXML
    private Button novedadesBOTON1;
    @javafx.fxml.FXML
    private Button eventosBOTON;
    @javafx.fxml.FXML
    private Button addButton;
    @javafx.fxml.FXML
    private Button alquileresBOTON;
    @javafx.fxml.FXML
    private Button librosBOTON;


    public void initialize(URL location, ResourceBundle resources) {
        perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        perfilBOTON.setOnMouseEntered(e -> perfilBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        perfilBOTON.setOnMouseExited(e -> perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        eventosBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);");

    }


    @javafx.fxml.FXML
    public void onAddClicked(ActionEvent actionEvent) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("AnyadirEventos.fxml"));
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

    @javafx.fxml.FXML
    public void filtrarBottonClick(ActionEvent actionEvent) {



    }

    @Deprecated
    public void perfilBOTON2click(ActionEvent actionEvent) {
    }

    @Deprecated
    public void eventosBOTON2click(ActionEvent actionEvent) {
    }

    @Deprecated
    public void librosBOTON2click(ActionEvent actionEvent) {
    }

    @Deprecated
    public void onAdd2Clicked(ActionEvent actionEvent) {
    }

    @Deprecated
    public void alquileresBOTON2click(ActionEvent actionEvent) {
    }

    @Deprecated
    public void novedadesBOTON2click(ActionEvent actionEvent) {
    }
}
