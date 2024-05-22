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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Anyadir implements Initializable {

    FileChooser fileChooser = new FileChooser();

    @javafx.fxml.FXML
    private AnchorPane PanelAnyadir;
    @javafx.fxml.FXML
    private Spinner precioSpinner;
    @javafx.fxml.FXML
    private TextField nombreDescripcion;
    @javafx.fxml.FXML
    private Button subirButton;
    @javafx.fxml.FXML
    private ImageView muestraImagen;
    @javafx.fxml.FXML
    private Button atrasButton;
    @javafx.fxml.FXML
    private Spinner nHabitacionesSpinner;
    @javafx.fxml.FXML
    private TextField ubiTextField;
    @javafx.fxml.FXML
    private TextField m2textField;
    @javafx.fxml.FXML
    private TextField descripciontextField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpinnerValueFactory<Integer> valueFactoryInteger =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10000000,0,1);

        precioSpinner.setValueFactory(valueFactoryInteger);



        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,1,1);

        nHabitacionesSpinner.setValueFactory(valueFactory);


    }


    public void onSubirButtonClick(ActionEvent actionEvent) {

        AnyadirModel am = new AnyadirModel();


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

    @javafx.fxml.FXML
    public void OnSubirImagenbutton(ActionEvent actionEvent) {
        File file = fileChooser.showOpenDialog(new Stage());
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

        FileChooser fileChooser = new FileChooser();
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

    @javafx.fxml.FXML
    public void onAtrasButtonClick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.PanelAnyadir.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}