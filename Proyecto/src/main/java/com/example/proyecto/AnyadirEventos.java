package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.sql.Date;
import java.time.LocalDate;

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
        AnyadirAlquileresModel am = new AnyadirAlquileresModel();

        Image imagenSeleccionada = muestraImagen.getImage();
        String imageUrl = imagenSeleccionada.getUrl().replace("file:", "");
        File imagen = new File(imageUrl);


        String tipo = "";
        String nombre= nombreEventos.getText();
        String descripcion = descripcionEventos.getText();
        String ubi = ubicacionEventos.getText();
        Date fechaEvento = Date.valueOf(fechaEventos.getValue());
        Date d = Date.valueOf(LocalDate.now());



    }

    @javafx.fxml.FXML
    public void onAtrasButtonClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void OnSubirImagenbutton(ActionEvent actionEvent) {
    }
}
