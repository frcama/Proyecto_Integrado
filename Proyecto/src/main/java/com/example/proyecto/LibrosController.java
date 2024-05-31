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
    private ChoiceBox<String> cursoChoiceBox;

    private ArrayList<Libros> librosArrayList;
    @FXML
    private ScrollPane librosScrollPane;
    @FXML
    private HBox panelHBox;
    @FXML
    private TextField asignaturaTextField;
    @FXML
    private TextField editorialTextField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        perfilBOTON.setOnMouseEntered(e -> perfilBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        perfilBOTON.setOnMouseExited(e -> perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        librosBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);");
*/
        ObservableList<String> cursolibro = FXCollections.observableArrayList();

        String curso1 = "Primero";
        String curso2 = "Segundo";
        String curso3 = "Tercero";
        String curso4 = "Cuarto";
        String cursovacio = " ";

        cursolibro.add(cursovacio);
        cursolibro.add(curso1);
        cursolibro.add(curso2);
        cursolibro.add(curso3);
        cursolibro.add(curso4);

        cursoChoiceBox.setItems(cursolibro);

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

        String editorialfiltrar = editorialTextField.getText().trim();
        String asignaturafiltrar = asignaturaTextField.getText().trim();
        String cursofiltrar = cursoChoiceBox.getValue();

        // Verificar si no se ha seleccionado ningún filtro o el texto está vacío
        if ((editorialfiltrar.isEmpty() || "Editorial".equalsIgnoreCase(editorialfiltrar)) &&
                (asignaturafiltrar.isEmpty() || "Asignatura".equalsIgnoreCase(asignaturafiltrar)) &&
                (cursofiltrar == null || cursofiltrar.isEmpty() || "Curso".equalsIgnoreCase(cursofiltrar))) {
            actualizarVista(librosArrayList); // Mostrar todos los libros
            return;
        }

        ArrayList<Libros> librosFiltrados = new ArrayList<>();
        for (Libros libro : librosArrayList) {
            boolean matchesEditorial = editorialfiltrar.isEmpty() || "Editorial".equalsIgnoreCase(editorialfiltrar) || libro.getEditorial().equalsIgnoreCase(editorialfiltrar);
            boolean matchesAsignatura = asignaturafiltrar.isEmpty() || "Asignatura".equalsIgnoreCase(asignaturafiltrar) || (libro.getAsignatura() != null && libro.getAsignatura().equalsIgnoreCase(asignaturafiltrar));
            boolean matchesCurso = cursofiltrar == null || cursofiltrar.isEmpty() || "Curso".equalsIgnoreCase(cursofiltrar) || libro.getCurso().equals(cursofiltrar);

            if (matchesEditorial && matchesAsignatura && matchesCurso) {
                librosFiltrados.add(libro);
            }
        }

        // Si no se encontraron libros filtrados, mostrar todos los libros
        if (librosFiltrados.isEmpty()) {
            actualizarVista(librosArrayList);
        } else {
            actualizarVista(librosFiltrados);
        }
    }


}

