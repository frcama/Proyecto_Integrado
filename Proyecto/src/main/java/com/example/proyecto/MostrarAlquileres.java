package com.example.proyecto;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MostrarAlquileres extends Conexion{
    @javafx.fxml.FXML
    private Label nombreAlquilerLabel;
    @javafx.fxml.FXML
    private Label nHabsAlquilerLabel;
    @javafx.fxml.FXML
    private Label precioAlquilerLabel;
    @javafx.fxml.FXML
    private ImageView imagenalquilerImageView;
    @javafx.fxml.FXML
    private Label metrosAlquilerLabel;
    @javafx.fxml.FXML
    private Label ubiAlquilerLabel;
    @javafx.fxml.FXML
    private AnchorPane panelMostrarAlquiler;
    @javafx.fxml.FXML
    private Label descripcionAlquilerLabel;

    Alquileres alquiler = new Alquileres();

    public void setData(Alquileres alquiler) {
        this.alquiler = alquiler;
        nombreAlquilerLabel.setText(alquiler.getNombre());
        precioAlquilerLabel.setText(String.valueOf(alquiler.getPrecio()+"€"));
        //Image image = new Image(getClass().getResourceAsStream(alquiler.getImgSrc()));
        //imagenalquilerImageView.setImage(image);
        metrosAlquilerLabel.setText(alquiler.getMetrosCuadrados() + " metros cuadrados");
        ubiAlquilerLabel.setText(alquiler.getUbicacion());
        descripcionAlquilerLabel.setText(alquiler.getDescripcion());
        nHabsAlquilerLabel.setText(String.valueOf(alquiler.getnHabitaciones() + " núm Habitaciones"));
    }
}

