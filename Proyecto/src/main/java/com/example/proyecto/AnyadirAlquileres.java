package com.example.proyecto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.security.cert.PolicyNode;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnyadirAlquileres implements Initializable {
    // FileChooser para seleccionar archivos de imagen
    FileChooser fileChooser = new FileChooser();
    // Componentes de la interfaz declarados con @javafx.fxml.FXML para ser inyectados desde el archivo FXML
    @javafx.fxml.FXML
    private Spinner precioSpinner;
    @javafx.fxml.FXML
    private TextField nombreDescripcion;
    @javafx.fxml.FXML
    private Button subirButton;
    @javafx.fxml.FXML
    private ImageView muestraImagen;
    @javafx.fxml.FXML
    private TextField m2textField;
    @javafx.fxml.FXML
    private TextField descripciontextField;
    @javafx.fxml.FXML
    private Spinner nHabitacionesSpinner;
    @javafx.fxml.FXML
    private AnchorPane PanelAnyadirALQUILERES;
    @javafx.fxml.FXML
    private Button atrasBOTON;
    @javafx.fxml.FXML
    private ChoiceBox ubicacionChoiceBox;
    @javafx.fxml.FXML
    private TextField ciudadNombreAlquiler;

    // Método inicializador que se ejecuta al cargar el FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configura el Spinner para el precio
        SpinnerValueFactory<Integer> valueFactoryInteger =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10000000,0,1);

        precioSpinner.setValueFactory(valueFactoryInteger);

        // Configura el Spinner para el número de habitaciones
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,1,1);

        nHabitacionesSpinner.setValueFactory(valueFactory);

        // Crea una lista observable para las opciones de ubicación
        ObservableList<String> zonaAlquiler = FXCollections.observableArrayList();

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
        // Establece las opciones en el ChoiceBox de ubicación
        ubicacionChoiceBox.setItems(zonaAlquiler);


    }

    // Método para manejar el evento del botón "Subir"
    @javafx.fxml.FXML
    public void onSubirButtonClick(ActionEvent actionEvent) {
        // Crea una instancia del modelo AnyadirAlquileresModel
        AnyadirAlquileresModel am = new AnyadirAlquileresModel();
        // Obtiene la imagen seleccionada y su ruta
        Image imagenSeleccionada = muestraImagen.getImage();
        String imageUrl = imagenSeleccionada.getUrl().replace("file:", "");
        File imagen = new File(imageUrl);
        // Obtiene los valores de los campos de texto y los controles
        String nombre= nombreDescripcion.getText();
        String descripcion = descripciontextField.getText();
        String m2 = m2textField.getText();
        String ubi = String.valueOf(ubicacionChoiceBox.getValue());
        int nHabs = (Integer) nHabitacionesSpinner.getValue();
        int precio = (Integer) precioSpinner.getValue();
        Date d = Date.valueOf(LocalDate.now());
        String ciudad = ciudadNombreAlquiler.getText();
        // Crea una instancia de Alquileres con los valores obtenidos
        Alquileres a = new Alquileres(ubi, nombre,precio,m2,imagen,nHabs,descripcion,d,ciudad);
        // Llama al método para añadir el alquiler en el modelo
        am.AnyadirAlquiler(a);
    }
    // Método para manejar el evento del botón "Subir Imagen"
    @javafx.fxml.FXML
    public void OnSubirImagenbutton(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        // Configurar los filtros de extensión antes de mostrar el diálogo
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        // Muestra el diálogo para seleccionar un archivo
        File file = fileChooser.showOpenDialog(new Stage());
        // Si se selecciona un archivo, establece la imagen en el ImageView
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            muestraImagen.setImage(image);
        }
    }
    // Método para manejar el evento del botón "Atrás"
    @javafx.fxml.FXML
    public void atrasBOTONclick(ActionEvent actionEvent) {
        try {
            // Carga el archivo FXML de la vista anterior
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Alquileres.fxml"));
            // Reemplaza el contenido del panel actual con el contenido de la vista anterior
            this.PanelAnyadirALQUILERES.getChildren().setAll(pane);
        } catch (IOException ex) {
            // Manejo de excepciones
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}