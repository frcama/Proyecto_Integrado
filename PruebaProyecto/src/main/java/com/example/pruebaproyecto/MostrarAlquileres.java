package com.example.pruebaproyecto;

import com.example.pruebaproyecto.proyecto.Alquileres;
import javafx.scene.control.Label;
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
    @javafx.fxml.FXML
    private Label ciudadAlquiler;


    Usuario usuario = new Usuario();
    @javafx.fxml.FXML
    private Label correoAlquiler;

    public void setData(Alquileres alquiler) {
        recuperarDatos();

        this.alquiler = alquiler;
        PerfilModel pm= new PerfilModel();
        Usuario u = new Usuario();
        u = pm.perfilModel(u.getCorreo(),u.getContra());

        nombreAlquilerLabel.setText(alquiler.getNombre());
        precioAlquilerLabel.setText(String.valueOf(alquiler.getPrecio()+"€"));

        metrosAlquilerLabel.setText(alquiler.getMetrosCuadrados() + " metros cuadrados");
        ubiAlquilerLabel.setText(alquiler.getUbicacion());
        descripcionAlquilerLabel.setText(alquiler.getDescripcion());
        nHabsAlquilerLabel.setText(String.valueOf(alquiler.getnHabitaciones() + " núm Habitaciones"));
        ciudadAlquiler.setText(alquiler.getCiudad());
        correoAlquiler.setText("Contacto: " +usuario.getCorreo());

        // Establecer la imagen en el ImageView
        if (alquiler.getImagen() != null) {
            imagenalquilerImageView.setImage(alquiler.getImagen());
        }
    }
    private void recuperarDatos(){

        UsuarioHolder us = UsuarioHolder.getInstance();
        usuario = us.getUsuario();
    }
}

