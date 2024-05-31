package com.example.proyecto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.cert.PolicyNode;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase AnyadirLibros que implementa Initializable para manejar la inicialización de la interfaz de usuario
 */
public class AnyadirLibros implements Initializable {
    @FXML
    private Spinner precioSpinner;
    @FXML
    private Button subirButton;
    @FXML
    private ImageView muestraImagen;
    @FXML
    private Button atrasBOTON;
    @FXML
    private TextField editorialTextField;
    @FXML
    private AnchorPane PanelAnyadirLIBROS;
    @FXML
    private TextField tituloTextField;
    @FXML
    private TextField isbnTextField;
    @FXML
    private TextField asignaturaTextField;
    @FXML
    private ChoiceBox cursoChoiceBox;

    /**
     * Método initialize se ejecuta al cargar la interfaz de usuario
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configuración del Spinner para el precio del libro
        SpinnerValueFactory<Integer> valueFactoryInteger =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);

        precioSpinner.setValueFactory(valueFactoryInteger);
        // Creación de la lista de opciones para el ChoiceBox de cursos
        ObservableList<String> cursosLibros = FXCollections.observableArrayList();

        String curso1 = "Primero";
        String curso2 = "Segundo";
        String curso3 = "Tercero";
        String curso4 = "Cuarto";


        cursosLibros.add(curso1);
        cursosLibros.add(curso2);
        cursosLibros.add(curso3);
        cursosLibros.add(curso4);


        cursoChoiceBox.setItems(cursosLibros);

    }

    /**
     * Método para manejar el evento de clic en el botón "Atrás"
     * @param actionEvent
     */
    @FXML
    public void atrasBOTONclick(ActionEvent actionEvent) {
        try {
            // Cargar el nuevo AnchorPane desde el archivo FXML y reemplazar el contenido del panel actual
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Libros.fxml"));
            this.PanelAnyadirLIBROS.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método para manejar el evento de clic en el botón "Subir"
     * @param actionEvent
     */
    @FXML
    public void onSubirButtonClick(ActionEvent actionEvent) {

        AnyadirLibrosModel al = new AnyadirLibrosModel();

        // Obtener la imagen seleccionada y su ruta
        Image imagenSeleccionada = muestraImagen.getImage();
        String imageUrl = imagenSeleccionada.getUrl().replace("file:", "");
        File imagen = new File(imageUrl);
        // Obtener los datos de los campos de texto y controles
        String titulo= tituloTextField.getText();
        String editorial = editorialTextField.getText();
        String isbn = isbnTextField.getText();
        String curso = String.valueOf(cursoChoiceBox.getValue());
        double precio = (Integer) precioSpinner.getValue();
        String asignatura = asignaturaTextField.getText();
        Date d = Date.valueOf(LocalDate.now());
        // Crear un nuevo objeto Libros con los datos obtenidos
        Libros l = new Libros(titulo, isbn, editorial, precio, asignatura, curso, imagen, d);
        // Llamar al método para añadir el libro a la base de datos
        al.AnyadirLibros(l);



    }

    /**
     * Método para manejar el evento de clic en el botón "Subir Imagen"
     * @param actionEvent
     */
    @FXML
    public void OnSubirImagenbutton(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        // Configurar los filtros de extensión antes de mostrar el diálogo
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        // Mostrar el diálogo de selección de archivos
        File file = fileChooser.showOpenDialog(new Stage());
        // Si se selecciona un archivo, cargarlo y mostrar la imagen en el ImageView
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            muestraImagen.setImage(image);
        }
    }
}
