package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnyadirAlquileresOs implements Initializable {

    FileChooser fileChooser = new FileChooser();

    @javafx.fxml.FXML
    private Spinner precioSpinner;
    @javafx.fxml.FXML
    private TextField nombreDescripcion;
    @javafx.fxml.FXML
    private ImageView muestraImagen;
    @javafx.fxml.FXML
    private TextField ubiTextField;
    @javafx.fxml.FXML
    private TextField m2textField;
    @javafx.fxml.FXML
    private TextField descripciontextField;
    @javafx.fxml.FXML
    private Spinner nHabitacionesSpinner;
    @javafx.fxml.FXML
    private AnchorPane PanelAnyadirALQUILERES;
    @javafx.fxml.FXML
    private Button subirButton2;
    @javafx.fxml.FXML
    private Button SubirImagen2;
    @javafx.fxml.FXML
    private Button atrasBOTON2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpinnerValueFactory<Integer> valueFactoryInteger =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10000000,0,1);

        precioSpinner.setValueFactory(valueFactoryInteger);


        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,1,1);

        nHabitacionesSpinner.setValueFactory(valueFactory);

    }


    @Deprecated
    public void onSubirButtonClick(ActionEvent actionEvent) {

        AnyadirAlquileresModel am = new AnyadirAlquileresModel();

        Image imagenSeleccionada = muestraImagen.getImage();
        String imageUrl = imagenSeleccionada.getUrl().replace("file:", "");
        File imagen = new File(imageUrl);

        String nombre= nombreDescripcion.getText();
        String descripcion = descripciontextField.getText();
        String m2 = m2textField.getText();
        String ubi = ubiTextField.getText();
        int nHabs = (Integer) nHabitacionesSpinner.getValue();
        int precio = (Integer) precioSpinner.getValue();
        Date d = Date.valueOf(LocalDate.now());

        Alquileres a = new Alquileres(ubi, nombre,precio,m2,imagen,nHabs,descripcion,d);

        am.AnyadirAlquiler(a);
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

    @Deprecated
    public void atrasBOTONclick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Alquileres.fxml"));
            this.PanelAnyadirALQUILERES.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @javafx.fxml.FXML
    public void OnSubirImagen2button(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void atrasBOTON2click(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onSubirButton2Click(ActionEvent actionEvent) {
    }
}