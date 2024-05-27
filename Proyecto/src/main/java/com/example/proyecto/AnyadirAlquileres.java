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

    FileChooser fileChooser = new FileChooser();

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpinnerValueFactory<Integer> valueFactoryInteger =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10000000,0,1);

        precioSpinner.setValueFactory(valueFactoryInteger);


        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,1,1);

        nHabitacionesSpinner.setValueFactory(valueFactory);


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

        ubicacionChoiceBox.setItems(zonaAlquiler);

    }


    @javafx.fxml.FXML
    public void onSubirButtonClick(ActionEvent actionEvent) {

        AnyadirAlquileresModel am = new AnyadirAlquileresModel();

        Image imagenSeleccionada = muestraImagen.getImage();
        String imageUrl = imagenSeleccionada.getUrl().replace("file:", "");
        File imagen = new File(imageUrl);

        String nombre= nombreDescripcion.getText();
        String descripcion = descripciontextField.getText();
        String m2 = m2textField.getText();
        String ubi = String.valueOf(ubicacionChoiceBox.getValue());
        int nHabs = (Integer) nHabitacionesSpinner.getValue();
        int precio = (Integer) precioSpinner.getValue();
        Date d = Date.valueOf(LocalDate.now());

        Alquileres a = new Alquileres(ubi, nombre,precio,m2,imagen,nHabs,descripcion,d);

        am.AnyadirAlquiler(a);
    }

    @javafx.fxml.FXML
    public void OnSubirImagenbutton(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        // Configurar los filtros de extensión antes de mostrar el diálogo
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

        File file = fileChooser.showOpenDialog(new Stage());

        if (file != null) {
            Image image = new Image(file.toURI().toString());
            muestraImagen.setImage(image);
        }
    }

    @javafx.fxml.FXML
    public void atrasBOTONclick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Alquileres.fxml"));
            this.PanelAnyadirALQUILERES.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}