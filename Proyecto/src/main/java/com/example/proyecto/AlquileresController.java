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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlquileresController implements Initializable{
    @FXML
    private AnchorPane PanelAlquileres;
    @FXML
    private Button filtrarButton;
    @FXML
    private ChoiceBox zonaFiltroChoicebox;
    @FXML
    private ImageView PerfilBOTON;
    @FXML
    private ColumnConstraints col2GripPane;
    @FXML
    private ColumnConstraints col1GripPane;
    @FXML
    private GridPane cosasGripPane;
    @FXML
    private Button perfilBOTON;
    @FXML
    private Button novedadesBOTON;
    @FXML
    private Button eventosBOTON;
    @FXML
    private Button addButton11;
    @FXML
    private Button alquileresBOTON;
    @FXML
    private Button librosBOTON;
    @FXML
    private ChoiceBox NumHabChoiceBox;
    @FXML
    private TextField PrecioMaxTF;
    @FXML
    private TextField PrecioMinTF;


    public void initialize(URL location, ResourceBundle resources) {
        perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        perfilBOTON.setOnMouseEntered(e -> perfilBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        perfilBOTON.setOnMouseExited(e -> perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        alquileresBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);");



        ObservableList<String> preciosAlquiler = FXCollections.observableArrayList();
        ObservableList<String> zonaAlquiler = FXCollections.observableArrayList();
        ObservableList<String> nHabitacionesAlquiler = FXCollections.observableArrayList();

        String precios1= "1 Habitación";
        String precios2= "2 Habitaciones";
        String precios3= "3 Habitaciones";
        String precios4= "4 Habitaciones";
        String precios5= "5 Habitaciones";


        preciosAlquiler.add(precios1);
        preciosAlquiler.add(precios2);
        preciosAlquiler.add(precios3);
        preciosAlquiler.add(precios4);
        preciosAlquiler.add(precios5);

        NumHabChoiceBox.setItems(preciosAlquiler);


        String zona1= "Zona centro";
        String zona2= "Cerca de playa";
        String zona3= "Cerca de Universidades";
        String zona4="Afueras";
        String zona5= "Cerca de Ocio";


        zonaAlquiler.add(zona1);
        zonaAlquiler.add(zona2);
        zonaAlquiler.add(zona3);
        zonaAlquiler.add(zona4);
        zonaAlquiler.add(zona5);

        zonaFiltroChoicebox.setItems(zonaAlquiler);


        String nh1= "Zona centro";
        String nh2= "Cerca de playa";
        String nh3= "Cerca de Universidades";
        String nh4= "Afueras";
        String nh5= "Cerca de Ocio";


        nHabitacionesAlquiler.add(nh1);
        nHabitacionesAlquiler.add(nh2);
        nHabitacionesAlquiler.add(nh3);
        nHabitacionesAlquiler.add(nh4);
        nHabitacionesAlquiler.add(nh5);

//quique es gey
        ChoiceBox<String> nHabitacioneschoiceBox = new ChoiceBox<>();
        nHabitacioneschoiceBox.setItems(nHabitacionesAlquiler);



        NumHabChoiceBox.setValue("Nº Hab");
        zonaFiltroChoicebox.setValue("Ubicación");
        nHabitacioneschoiceBox.setValue("Número Habitaciones");

        //AlquileresModel am = new AlquileresModel();
        //ArrayList<Alquileres> lista = am.mostrarAlquileres();


       /* for (Alquileres a : lista){
            System.out.println(a.getImagen());
        }
        */
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
            AnchorPane pane = FXMLLoader.load(getClass().getResource("AnyadirAlquileres.fxml"));
            this.PanelAlquileres.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    public void filtrarBottonClick(ActionEvent actionEvent) {


    }

}
