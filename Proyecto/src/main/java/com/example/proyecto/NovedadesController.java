package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NovedadesController implements Initializable {

@FXML
private ImageView PerfilBOTON;
@FXML
private Button perfilBOTON;
@FXML
private AnchorPane PanelNovedades;
    @FXML
private Button novedadesBOTON;
    @FXML
private Button alquileresBOTON;
@FXML
private Button eventosBOTON;
    @FXML
private Button librosBOTON;
@FXML
private ScrollPane novedadesScollPane;
    @FXML
private HBox panelHBoxNovedades;
@FXML
private GridPane cosasGripPane;

private Usuario usuario;
    @FXML
    private Button addButton11;

    public void setUsuario(Usuario usuario){
    this.usuario = usuario;
}

@Override
public void initialize(URL location, ResourceBundle resources){


        perfilBOTON.setStyle("-fx-background-color: F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        perfilBOTON.setOnMouseEntered(e -> perfilBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        perfilBOTON.setOnMouseExited(e -> perfilBOTON.setStyle("-fx-background-color: F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        novedadesBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);");

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
public void alquileresBOTONclick(ActionEvent actionEvent) {
    System.out.println("funciona");

    try {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Alquileres.fxml"));
        this.PanelNovedades.getChildren().setAll(pane);
    } catch (IOException ex) {
        Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    @FXML
    public void onAddClicked(ActionEvent actionEvent) {
    }
}
