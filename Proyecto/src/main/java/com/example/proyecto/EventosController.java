package com.example.proyecto;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
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
    private Button filtrarButton;
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
    @javafx.fxml.FXML
    private ChoiceBox TipoFiltroChoicebox;
    @javafx.fxml.FXML
    private TextField maxPreciofiltroEvento;
    @javafx.fxml.FXML
    private ScrollPane eventosScollPane;
    @javafx.fxml.FXML
    private HBox panelHBoxEventos;
    @javafx.fxml.FXML
    private GridPane cosasGripPaneEvento;

    public void initialize(URL location, ResourceBundle resources) {
        perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        perfilBOTON.setOnMouseEntered(e -> perfilBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        perfilBOTON.setOnMouseExited(e -> perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        eventosBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);");


        ObservableList<String> tipoEvento = FXCollections.observableArrayList();


        String t1 = "Festival";
        String t2 = "Charla";
        String t3 = "Paellas Universitarias";
        String t4 = "Monologos";
        String t5 = "Congresos";


        tipoEvento.add(t1);
        tipoEvento.add(t2);
        tipoEvento.add(t3);
        tipoEvento.add(t4);
        tipoEvento.add(t5);

        TipoFiltroChoicebox.setItems(tipoEvento);
        TipoFiltroChoicebox.setValue("TipoEvento");
        maxPreciofiltroEvento.setText("Precio Max");

        EventosModel em = new EventosModel();
        ArrayList<Eventos> eventosArrayList = em.mostrarEventos();
/*
        for ( Eventos eventos : eventosArrayList){

            String ubi = eventos.getUbicacion();
            String nombre = eventos.getNombre();
            Double precio = eventos.getPrecio();
            String desc = eventos.getDescripcion();
            Date fecha
            //Image image = eventos.getImagen();

            Alquileres a = new Alquileres(ubi,nombre,precio,m2,nh,desc);

        }
*/
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
