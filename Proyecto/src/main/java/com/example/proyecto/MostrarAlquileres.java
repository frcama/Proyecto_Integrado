package com.example.proyecto;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.util.ArrayList;

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

    @javafx.fxml.FXML
    public void initialize() {

        AlquileresModel am= new AlquileresModel();

        ArrayList<Alquileres> listaAlquileres = am.mostrarAlquileres();

        for ( Alquileres al : listaAlquileres){


             String ubicacion= al.getUbicacion();
             String nombre = al.getNombre();
             String precio = String.valueOf(al.getPrecio());
             String metrosCuadrados = al.getMetrosCuadrados();
             Image imagen = al.getImagen();
             String nHabitaciones = String.valueOf(al.getnHabitaciones());
             String Descripcion  = al.getDescripcion();

             nombreAlquilerLabel.setText(nombre);
             ubiAlquilerLabel.setText(ubicacion);
             metrosAlquilerLabel.setText(metrosCuadrados);
             nHabsAlquilerLabel.setText(nHabitaciones);
             imagenalquilerImageView.setImage(imagen);
             descripcionAlquilerLabel.setText(Descripcion);



        }



    }



}