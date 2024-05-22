package com.example.proyecto;

import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class AlquileresController implements Initializable{
    @javafx.fxml.FXML
    private Button perfilBOTON;
    @javafx.fxml.FXML
    private Pane panelDesplegableNOVEDADES;
    @javafx.fxml.FXML
    private Button novedadesBOTON;
    @javafx.fxml.FXML
    private AnchorPane PanelAlquileres;
    @javafx.fxml.FXML
    private Button alquileresBOTON;
    @javafx.fxml.FXML
    private Button eventosBOTON;
    @javafx.fxml.FXML
    private Button librosBOTON;
    @FXML
    private Button addButton11;
    @FXML
    private Menu menuAyuda;
    @FXML
    private ChoiceBox precioFiltroChoicebox;
    @FXML
    private ChoiceBox nHabitacioneschoiceBox;
    @FXML
    private Menu menuMO;
    @FXML
    private MenuItem chatNovedades;
    @FXML
    private Button filtrarButton;
    @FXML
    private ChoiceBox zonaFiltroChoicebox;
    @FXML
    private ImageView PerfilBOTON;
    @FXML
    private MenuBar menuMenuBar;


    public void initialize(URL location, ResourceBundle resources) {
        perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        perfilBOTON.setOnMouseEntered(e -> perfilBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        perfilBOTON.setOnMouseExited(e -> perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        novedadesBOTON.setStyle("-fx-background-color: #c2c2c2;");
        novedadesBOTON.setOnMouseEntered(e -> novedadesBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);"));
        novedadesBOTON.setOnMouseExited(e -> novedadesBOTON.setStyle("-fx-background-color: #c2c2c2;"));

        alquileresBOTON.setStyle("-fx-background-color: #c2c2c2;");
        alquileresBOTON.setOnMouseEntered(e -> alquileresBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);"));
        alquileresBOTON.setOnMouseExited(e -> alquileresBOTON.setStyle("-fx-background-color: #c2c2c2;"));

        addButton11.setStyle("-fx-background-color: #c2c2c2;");
        addButton11.setOnMouseEntered(e -> addButton11.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);"));
        addButton11.setOnMouseExited(e -> addButton11.setStyle("-fx-background-color: #c2c2c2;"));

        librosBOTON.setStyle("-fx-background-color: #c2c2c2;");
        librosBOTON.setOnMouseEntered(e -> librosBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);"));
        librosBOTON.setOnMouseExited(e -> librosBOTON.setStyle("-fx-background-color: #c2c2c2;"));

        eventosBOTON.setStyle("-fx-background-color: #c2c2c2;");
        eventosBOTON.setOnMouseEntered(e -> eventosBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);"));
        eventosBOTON.setOnMouseExited(e -> eventosBOTON.setStyle("-fx-background-color: #c2c2c2;"));









        ObservableList<String> preciosAlquiler = FXCollections.observableArrayList();
        ObservableList<String> zonaAlquiler = FXCollections.observableArrayList();
        ObservableList<String> nHabitacionesAlquiler = FXCollections.observableArrayList();

        String precios1= "0-50";
        String precios2= "50-75";
        String precios3= "75-100";
        String precios4= "100-200";
        String precios5= "200-300";
        String precios6= "+ de 300";

        preciosAlquiler.add(precios1);
        preciosAlquiler.add(precios2);
        preciosAlquiler.add(precios3);
        preciosAlquiler.add(precios4);
        preciosAlquiler.add(precios5);
        preciosAlquiler.add(precios6);

        precioFiltroChoicebox.setItems(preciosAlquiler);


        String zona1= "";
        String zona2= "50-75";
        String zona3= "75-100";
        String zona4= "100-200";
        String zona5= "200-300";
        String zona6= "+ de 300";

        zonaAlquiler.add(zona1);
        zonaAlquiler.add(zona2);
        zonaAlquiler.add(zona3);
        zonaAlquiler.add(zona4);
        zonaAlquiler.add(zona5);
        zonaAlquiler.add(zona6);

        zonaFiltroChoicebox.setItems(zonaAlquiler);


        String nh1= "1 Habitación";
        String nh2= "2 Habitaciones";
        String nh3= "3 Habitaciones";
        String nh4= "4 Habitaciones";
        String nh5= "5 Habitaciones";
        String nh6= "+ de 5 Habitaciones";

        nHabitacionesAlquiler.add(nh1);
        nHabitacionesAlquiler.add(nh2);
        nHabitacionesAlquiler.add(nh3);
        nHabitacionesAlquiler.add(nh4);
        nHabitacionesAlquiler.add(nh5);
        nHabitacionesAlquiler.add(nh6);

        nHabitacioneschoiceBox.setItems(nHabitacionesAlquiler);



        precioFiltroChoicebox.setValue("$ Precio ");
        zonaFiltroChoicebox.setValue("Ubicación");
        nHabitacioneschoiceBox.setValue("Número Habitaciones");
    }

    @FXML
    public void perfilBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Perfil.fxml"));
            this.PanelAlquileres.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void librosBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Libros.fxml"));
            this.PanelAlquileres.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    public void alquileresBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Alquileres.fxml"));
            this.PanelAlquileres.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    public void novedadesBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.PanelAlquileres.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void eventosBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Eventos.fxml"));
            this.PanelAlquileres.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void onAddClicked(ActionEvent actionEvent) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("anadir.fxml"));
            this.PanelAlquileres.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void chatNovedadesclick(ActionEvent actionEvent) {
    }

    @FXML
    public void filtrarBottonClick(ActionEvent actionEvent) {


    }
}
