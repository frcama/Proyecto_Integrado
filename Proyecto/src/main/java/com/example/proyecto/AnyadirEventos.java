package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnyadirEventos {
    @javafx.fxml.FXML
    private Button subirButton;
    @javafx.fxml.FXML
    private ImageView muestraImagen;
    @javafx.fxml.FXML
    private Button atrasButton;
    @javafx.fxml.FXML
    private DatePicker fechaEventos;
    @javafx.fxml.FXML
    private TextField descripcionEventos;
    @javafx.fxml.FXML
    private TextField nombreEventos;
    @javafx.fxml.FXML
    private Spinner precioEventos;
    @javafx.fxml.FXML
    private AnchorPane PanelAnyadirEVENTOS;
    @javafx.fxml.FXML
    private TextField ubicacionEventos;
    @javafx.fxml.FXML
    private TextField tipoEventos;

    @javafx.fxml.FXML
    public void onSubirButtonClick(ActionEvent actionEvent) {


        Image imagenSeleccionada = muestraImagen.getImage();
        String imageUrl = imagenSeleccionada.getUrl().replace("file:", "");
        File imagen = new File(imageUrl);


        String tipo = "";
        String nombre= nombreEventos.getText();
        String descripcion = descripcionEventos.getText();
        String ubi = ubicacionEventos.getText();
        Date fechaEvento = Date.valueOf(fechaEventos.getValue());
        Date d = Date.valueOf(LocalDate.now());
        String p = String.valueOf(precioEventos.getValue());
        double precio = Double.valueOf(p);

        Eventos e = new Eventos(nombre,fechaEvento,ubi,d,imagen,descripcion,precio,tipo);

    }

    @javafx.fxml.FXML
    public void onAtrasButtonClick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Alquileres.fxml"));
            this.PanelAnyadirEVENTOS.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
}
