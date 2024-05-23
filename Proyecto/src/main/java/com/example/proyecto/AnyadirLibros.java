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

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.PolicyNode;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnyadirLibros {
    @FXML
    private Spinner precioSpinner;
    @FXML
    private TextField ubiTextField;
    @FXML
    private TextField nombreDescripcion;
    @FXML
    private TextField m2textField;
    @FXML
    private Button subirButton;
    @FXML
    private ImageView muestraImagen;
    @FXML
    private TextField descripciontextField;
    @FXML
    private Spinner nHabitacionesSpinner;
    @FXML
    private AnchorPane PanelAnyadirLIBROS;
    @FXML
    private Button atrasBOTON;
    private AnchorPane PanelAnyadirALQUILERES;

    @FXML
    public void atrasBOTONclick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Libros.fxml"));
            this.PanelAnyadirALQUILERES.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    public void onSubirButtonClick(ActionEvent actionEvent) {

        AnyadirAlquileresModel am = new AnyadirAlquileresModel();


        Image imagenSeleccionada = muestraImagen.getImage();
        File imagen = new File(String.valueOf(imagenSeleccionada));
        // Convertir la imagen a un array de bytes
        byte[] imagenBytes = null;
        try {
            BufferedImage bImage = ImageIO.read(imagen);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos);
            imagenBytes = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String nombre= nombreDescripcion.getText();
        String descripcion = descripciontextField.getText();
        String m2 = m2textField.getText();
        String ubi = ubiTextField.getText();
        int nHabs = (Integer) nHabitacionesSpinner.getValue();
        int precio = (Integer) precioSpinner.getValue();

        Alquileres a = new Alquileres(ubi, nombre,precio,m2,imagenBytes,nHabs,descripcion );

        am.AnyadirAlquiler(a);

    }

    @FXML
    public void OnSubirImagenbutton(ActionEvent actionEvent) {
        FileChooser fileChooser = null;
        File file = fileChooser.showOpenDialog(new Stage());
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

        fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccione una imagen");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            // Convertir el archivo de imagen en un array de bytes
            byte[] imagenBytes = null;
            try {
                BufferedImage bImage = ImageIO.read(selectedFile);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ImageIO.write(bImage, "jpg", bos);
                imagenBytes = bos.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (file != null) {
                Image image = new Image(file.toURI().toString());
                muestraImagen.setImage(image);
            }
        }
    }
}
