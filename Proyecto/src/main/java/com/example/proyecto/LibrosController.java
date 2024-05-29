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
    private ChoiceBox<String> editorialChoiceBox;
    @FXML
    private ChoiceBox<String> cursoChoiceBox;

    private ArrayList<Libros> librosArrayList;
    @FXML
    private ScrollPane librosScrollPane;
    @FXML
    private HBox panelHBox;
    @FXML
    private TextField asignaturaTextField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        perfilBOTON.setOnMouseEntered(e -> perfilBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        perfilBOTON.setOnMouseExited(e -> perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        librosBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);");

        ObservableList<String> editoriales = FXCollections.observableArrayList();
        ObservableList<String> cursolibro = FXCollections.observableArrayList();
        ObservableList<String> asignaturas = FXCollections.observableArrayList();


        String editorial1 = "tonpare";
        String editorial2 = "Bromera";
        String editorial3 = "Escribi";
        String editorial4 = "Quiqueeditoriales";

        editoriales.add(editorial1);
        editoriales.add(editorial2);
        editoriales.add(editorial3);
        editoriales.add(editorial4);

        editorialChoiceBox.setItems(editoriales);

        String curso1 = "Primero";
        String curso2 = "Segundo";
        String curso3 = "Tercero";
        String curso4 = "Cuarto";

        cursolibro.add(curso1);
        cursolibro.add(curso2);
        cursolibro.add(curso3);
        cursolibro.add(curso4);

        cursoChoiceBox.setItems(cursolibro);

        editorialChoiceBox.setValue("Editorial");
        cursoChoiceBox.setValue("Curso");

        LibrosModel lm = new LibrosModel();
        librosArrayList = lm.mostrarLibros();

        for ( Libros libros : librosArrayList ){

            String titulo = libros.getTitulo() ;
            String isbn = libros.getIsbn();
            Double precio = libros.getPrecio();
            String curso = libros.getCurso();
            String editorial = libros.getEditorial();
            String asignatura = libros.getAsignatura();
            Image image = libros.getImagen();

            Libros l = new Libros(isbn, titulo, precio, curso, editorial, asignatura,image);

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


    private void actualizarVista(ArrayList<Libros> librosFiltrados) {
        cosasGripPane.getChildren().clear(); // Limpiar el grid pane

        int column = 0;
        int row = 0;

        for (Libros libro : librosFiltrados) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("MostrarLibros.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                MostrarLibros ml = fxmlLoader.getController();
                ml.setData(libro);

                if (column == 1) { // Ajustar columnas a la necesidad del programa
                    column = 0;
                    row++;
                }

                cosasGripPane.add(anchorPane, column++, row); // (child, column, row)
                cosasGripPane.setMinWidth(Region.USE_COMPUTED_SIZE);
                cosasGripPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                cosasGripPane.setMaxWidth(Region.USE_PREF_SIZE);
                cosasGripPane.setMinHeight(Region.USE_COMPUTED_SIZE);
                cosasGripPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                cosasGripPane.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                e.printStackTrace();
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
        System.out.println("Funciona");

        String editorialfiltrar = editorialChoiceBox.getValue();
        String asignaturafiltrar = asignaturaTextField.getText().trim();
        String cursofiltrar = cursoChoiceBox.getValue();

        ArrayList<Libros> librosFiltrados = new ArrayList<>();
        for (Libros libro : librosArrayList) {
            boolean matchesEditorial = editorialfiltrar.equals("Editorial") || libro.getEditorial().equals(editorialfiltrar);
            boolean matchesAsignatura = asignaturafiltrar.equals("Asignatura") || libro.getAsignatura().equalsIgnoreCase(asignaturafiltrar);
            boolean matchesCurso = cursofiltrar.equals("Curso") || libro.getCurso().equals(cursofiltrar);

            if (matchesEditorial && matchesAsignatura && matchesCurso) {
                librosFiltrados.add(libro);
            }
        }

        actualizarVista(librosFiltrados);

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

