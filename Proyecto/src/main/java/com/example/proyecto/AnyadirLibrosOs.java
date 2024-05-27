package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnyadirLibrosOs {
    @FXML
    private Spinner precioSpinner;
    @FXML
    private TextField ubiTextField;
    @FXML
    private TextField nombreDescripcion;
    @FXML
    private TextField m2textField;
    @FXML
    private ImageView muestraImagen;
    @FXML
    private TextField descripciontextField;
    @FXML
    private Spinner nHabitacionesSpinner;
    private AnchorPane PanelAnyadirALQUILERES;
    @FXML
    private AnchorPane PanelAnyadirLIBROSOs;
    @FXML
    private Button subirButton2;
    @FXML
    private Button SubirImagen2;
    @FXML
    private Button atrasBOTON2;

    @FXML
    public void atrasBOTONclick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Libros.fxml"));
            this.PanelAnyadirALQUILERES.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Deprecated
    public void onSubirButtonClick(ActionEvent actionEvent) {

        AnyadirAlquileresModel am = new AnyadirAlquileresModel();


        Image imagenSeleccionada = muestraImagen.getImage();
        File imagen = new File(imagenSeleccionada.getUrl());

        String nombre= nombreDescripcion.getText();
        String descripcion = descripciontextField.getText();
        String m2 = m2textField.getText();
        String ubi = ubiTextField.getText();
        int nHabs = (Integer) nHabitacionesSpinner.getValue();
        int precio = (Integer) precioSpinner.getValue();



    }

    @Deprecated
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

    @FXML
    public void OnSubirImagen2button(ActionEvent actionEvent) {
    }

    @FXML
    public void onSubirButton2Click(ActionEvent actionEvent) {
    }
}
