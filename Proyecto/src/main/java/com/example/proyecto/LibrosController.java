package com.example.proyecto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    private GridPane cosasGripPane;
    @FXML
    private Button filtrarButton;
    @FXML
    private Button novedadesBOTON;
    @FXML
    private Button eventosBOTON;
    @FXML
    private Button addButton;
    @FXML
    private Button alquileresBOTON;
    @FXML
    private Button librosBOTON;
    @FXML
    private ChoiceBox editorialChoiceBox;
    @FXML
    private ChoiceBox cursoChoiceBox;

    private ArrayList<Libros> librosArrayList;
    @FXML
    private ChoiceBox asignaturaChoiceBox;
    @FXML
    private ScrollPane librosScrollPane;
    @FXML
    private HBox panelHBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        perfilBOTON.setOnMouseEntered(e -> perfilBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        perfilBOTON.setOnMouseExited(e -> perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        librosBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);");

        ObservableList<String> editoriales = FXCollections.observableArrayList();
        ObservableList<String> cursolibro = FXCollections.observableArrayList();
        ObservableList<String> asignaturas = FXCollections.observableArrayList();


        String editorial1 = "tompare";
        String editorial2 = "Bromera";
        String editorial3 = "Escribi";
        String editorial4 = "Quiqueeditoriales";

        editoriales.add(editorial1);
        editoriales.add(editorial2);
        editoriales.add(editorial3);
        editoriales.add(editorial4);

        editorialChoiceBox.setItems(editoriales);

        String curso1 = "Primer curso";
        String curso2 = "Segundo curso";
        String curso3 = "Tercer curso";
        String curso4 = "Cuarto curso";

        cursolibro.add(curso1);
        cursolibro.add(curso2);
        cursolibro.add(curso3);
        cursolibro.add(curso4);

        cursoChoiceBox.setItems(cursolibro);

        String asig1 = "Matematicas";
        String asig2 = "Lengua Castellana";
        String asig3 = "Fisica";
        String asig4 = "Biologia";

        asignaturas.add(asig1);
        asignaturas.add(asig2);
        asignaturas.add(asig3);
        asignaturas.add(asig4);

        asignaturaChoiceBox.setItems(asignaturas);

        editorialChoiceBox.setValue("Editorial");
        cursoChoiceBox.setValue("Curso");
        asignaturaChoiceBox.setValue("Asignatura");

        LibrosModel lm = new LibrosModel();
        librosArrayList = lm.mostrarLibros();

        for ( Libros libros : librosArrayList ){

            String titulo = libros.getTitulo() ;
            String isbn = libros.getIsbn();
            Double precio = libros.getPrecio();
            String curso = libros.getCurso();
            String editorial = libros.getEditorial();
            String asignatura = libros.getAsignatura();
            //Image image = alquileres.getImagen();

            Libros l = new Libros(isbn, titulo, precio, curso, editorial, asignatura);

        }

        int column = 0;
        int row = 0;


        for (int i = 0; i < librosArrayList.size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("MostrarLibros.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();


                MostrarLibros ml = fxmlLoader.getController();
                ml.setData(librosArrayList.get(i));

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
            this.PanelDeLibros.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    @FXML
    public void librosBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Libros.fxml"));
            this.PanelDeLibros.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    public void alquileresBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Alquileres.fxml"));
            this.PanelDeLibros.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    public void novedadesBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.PanelDeLibros.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
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

    @FXML
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

