package com.example.proyecto;

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
    private TextField ubiTextField;
    @javafx.fxml.FXML
    private TextField m2textField;
    @javafx.fxml.FXML
    private AnchorPane PanelAnyadirALQUILERES;
    @javafx.fxml.FXML
    private TextField descripciontextField;
    @javafx.fxml.FXML
    private Button atrasBOTON;
    @javafx.fxml.FXML
    private Spinner nHabitacionesSpinner;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpinnerValueFactory<Integer> valueFactoryInteger =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10000000,0,1);

        precioSpinner.setValueFactory(valueFactoryInteger);


        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,1,1);

        nHabitacionesSpinner.setValueFactory(valueFactory);

    }


    @javafx.fxml.FXML
    public void onSubirButtonClick(ActionEvent actionEvent) {

        AnyadirAlquileresModel am = new AnyadirAlquileresModel();

        Image imagenSeleccionada = muestraImagen.getImage();
        //File imagen = new File(imagenSeleccionada.getUrl());
        File imagen = new File ( "c:\\descarga.jpg");

        String nombre= nombreDescripcion.getText();
        String descripcion = descripciontextField.getText();
        String m2 = m2textField.getText();
        String ubi = ubiTextField.getText();
        int nHabs = (Integer) nHabitacionesSpinner.getValue();
        int precio = (Integer) precioSpinner.getValue();

        Alquileres a = new Alquileres(ubi, nombre,precio,m2,imagen,nHabs,descripcion );

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