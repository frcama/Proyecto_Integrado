package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PublicacionesController implements Initializable {

    @javafx.fxml.FXML
    private ScrollPane novedadesScollPane;
    @javafx.fxml.FXML
    private GridPane cosasGripPane;
    @javafx.fxml.FXML
    private Button atrasButton;
    @javafx.fxml.FXML
    private HBox panelHBoxNovedades;

    private Usuario usuario;
    @javafx.fxml.FXML
    private AnchorPane panelPublicaciones;

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){

        ArrayList<Libros> librosArrayList = new ArrayList<>();
        ArrayList<Eventos> eventosArrayList = new ArrayList<>();
        ArrayList<Alquileres> alquileresArrayList = new ArrayList<>();

        // Load books
        LibrosModel lm = new LibrosModel();
        librosArrayList = lm.mostrarLibros();

        // Load rentals
        AlquileresModel am = new AlquileresModel();
        alquileresArrayList = am.mostrarAlquileres();

        // Load events
        EventosModel em = new EventosModel();
        eventosArrayList = em.mostrarEventos();

        // Load books uploaded by the current user
        LibrosModel librosModel = new LibrosModel();
        librosArrayList = librosModel.mostrarLibrosPorUsuario(usuario);

        // Load events uploaded by the current user

        EventosModel eventosModel = new EventosModel();
        eventosArrayList = eventosModel.mostrarEventosPorUsuario(usuario);

        // Load rentals uploaded by the current user
        AlquileresModel alquileresModel = new AlquileresModel();
        alquileresArrayList = alquileresModel.mostrarAlquileresPorUsuario(usuario);

        // Clear the GridPane before adding new content
        cosasGripPane.getChildren().clear();

        int row = 0;

        // Add books to the GridPane
        for (Libros libro : librosArrayList) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("MostrarLibros.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                MostrarLibros ml = fxmlLoader.getController();
                ml.setData(libro);

                // Aplica la clase de estilo definida en el archivo CSS al AnchorPane
                anchorPane.getStyleClass().add("anchor-pane-content");

                cosasGripPane.add(anchorPane, 0, row++); // Add always in column 0 and increase the row
                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Add rentals to the GridPane
        for (Alquileres alquiler : alquileresArrayList) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("MostrarAlquileres.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                MostrarAlquileres ma = fxmlLoader.getController();
                ma.setData(alquiler);

                // Aplica la clase de estilo definida en el archivo CSS al AnchorPane
                anchorPane.getStyleClass().add("anchor-pane-content");

                cosasGripPane.add(anchorPane, 0, row++); // Add always in column 0 and increase the row
                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Add events to the GridPane
        for (Eventos evento : eventosArrayList) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("MostrarEventos.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                MostrarEventos me = fxmlLoader.getController();
                me.setData(evento);

                // Aplica la clase de estilo definida en el archivo CSS al AnchorPane
                anchorPane.getStyleClass().add("anchor-pane-content");

                cosasGripPane.add(anchorPane, 0, row++); // Add always in column 0 and increase the row
                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void atrasBotonCLick(ActionEvent actionEvent) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Perfil.fxml"));
            this.panelPublicaciones.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
