package com.example.proyecto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

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
    private ChoiceBox zonaFiltroChoicebox;
    @FXML
    private ImageView PerfilBOTON;
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
    @FXML
    private GridPane cosasGripPane;
    @FXML
    private HBox panelHBox;
    @FXML
    private Button filtrarButton;

    private ArrayList<Alquileres> alquileresArrayList;
    @FXML
    private ScrollPane alquileresScollPane;


    public void initialize(URL location, ResourceBundle resources) {

        perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        perfilBOTON.setOnMouseEntered(e -> perfilBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        perfilBOTON.setOnMouseExited(e -> perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        alquileresBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);");


        ObservableList<String> preciosAlquiler = FXCollections.observableArrayList();
        ObservableList<String> zonaAlquiler = FXCollections.observableArrayList();
        ObservableList<String> nHabitacionesAlquiler = FXCollections.observableArrayList();

        String precios1 = "1 Habitación";
        String precios2 = "2 Habitaciones";
        String precios3 = "3 Habitaciones";
        String precios4 = "4 Habitaciones";
        String precios5 = "5 Habitaciones";


        preciosAlquiler.add(precios1);
        preciosAlquiler.add(precios2);
        preciosAlquiler.add(precios3);
        preciosAlquiler.add(precios4);
        preciosAlquiler.add(precios5);

        NumHabChoiceBox.setItems(preciosAlquiler);


        String zona1 = "Zona centro";
        String zona2 = "Cerca de playa";
        String zona3 = "Cerca de Universidades";
        String zona4 = "Afueras";
        String zona5 = "Cerca de Ocio";


        zonaAlquiler.add(zona1);
        zonaAlquiler.add(zona2);
        zonaAlquiler.add(zona3);
        zonaAlquiler.add(zona4);
        zonaAlquiler.add(zona5);

        zonaFiltroChoicebox.setItems(zonaAlquiler);




        ChoiceBox<String> nHabitacioneschoiceBox = new ChoiceBox<>();
        nHabitacioneschoiceBox.setItems(nHabitacionesAlquiler);


        NumHabChoiceBox.setValue("Nº Hab");
        zonaFiltroChoicebox.setValue("Ubicación");
        nHabitacioneschoiceBox.setValue("Número Habitaciones");


        AlquileresModel am = new AlquileresModel();
        alquileresArrayList = am.mostrarAlquileres();

        for ( Alquileres alquileres : alquileresArrayList){

            String ubi = alquileres.getUbicacion();
            String nombre = alquileres.getNombre();
            Double precio = alquileres.getPrecio();
            String m2 = alquileres.getMetrosCuadrados();
            Integer nh = alquileres.getnHabitaciones();
            String desc = alquileres.getDescripcion();
           //Image image = alquileres.getImagen();

            Alquileres a = new Alquileres(ubi,nombre,precio,m2,nh,desc);

        }



        int column = 0;
        int row = 0;


        for (int i = 0; i < alquileresArrayList.size(); i++) {
            try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("MostrarAlquileres.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();


            MostrarAlquileres ma = fxmlLoader.getController();
            ma.setData(alquileresArrayList.get(i));

            if (column == 1) {
                column = 0;
                row++;
            }

            cosasGripPane.add(anchorPane, column++, row); //(child,column,row)
            //set grid width
            cosasGripPane.setMinWidth(Region.USE_COMPUTED_SIZE);
            cosasGripPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
            cosasGripPane.setMaxWidth(Region.USE_PREF_SIZE);

            //set grid height
            cosasGripPane.setMinHeight(Region.USE_COMPUTED_SIZE);
            cosasGripPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
            cosasGripPane.setMaxHeight(Region.USE_PREF_SIZE);

            GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
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
