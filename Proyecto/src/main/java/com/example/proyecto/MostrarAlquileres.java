package com.example.proyecto;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Clase para controlar la vista de un alquiler en el sistema
 */
public class MostrarAlquileres extends Conexion{
    // Etiquetas y elementos de la interfaz de usuario
    @javafx.fxml.FXML
    private Label nombreAlquilerLabel;
    @javafx.fxml.FXML
    private Label nHabsAlquilerLabel;
    @javafx.fxml.FXML
    private Label precioAlquilerLabel;
    @javafx.fxml.FXML
    private Label metrosAlquilerLabel;
    @javafx.fxml.FXML
    private Label ubiAlquilerLabel;
    @javafx.fxml.FXML
    private AnchorPane panelMostrarAlquiler;
    @javafx.fxml.FXML
    private Label descripcionAlquilerLabel;
    // Instancia de Alquileres
    Alquileres alquiler = new Alquileres();
    @javafx.fxml.FXML
    private Label ciudadAlquiler;

    // Instancia de Usuario
    Usuario usuario = new Usuario();
    @javafx.fxml.FXML
    private Label AlquilerLabel;
    @javafx.fxml.FXML
    private Label contactoLabel;
    @javafx.fxml.FXML
    private ImageView imagenAlquilerImageView;

    /**
     * Método para establecer los datos del alquiler en la interfaz de usuario
     * @param alquiler
     */
    public void setData(Alquileres alquiler) {
        // Recuperar datos del usuario
        recuperarDatos();
        // Asignar el alquiler actual
        this.alquiler = alquiler;
        // Crear una instancia del modelo de perfil
        PerfilModel pm= new PerfilModel();
        Usuario u = new Usuario();
        // Obtener los datos del perfil del usuario actual
        u = pm.perfilModel(u.getCorreo(),u.getContra());
        // Establecer los datos del alquiler en las etiquetas de la interfaz de usuario
        nombreAlquilerLabel.setText(alquiler.getNombre());
        precioAlquilerLabel.setText(String.valueOf(alquiler.getPrecio()));

        metrosAlquilerLabel.setText(alquiler.getMetrosCuadrados() + " metros cuadrados");
        ubiAlquilerLabel.setText(alquiler.getUbicacion());
        descripcionAlquilerLabel.setText(alquiler.getDescripcion());
        nHabsAlquilerLabel.setText(String.valueOf(alquiler.getnHabitaciones() + " núm Habitaciones"));
        ciudadAlquiler.setText(alquiler.getCiudad());
        contactoLabel.setText("Contacto: " +usuario.getCorreo());

        // Establecer la imagen en el ImageView
        if (alquiler.getImagen() != null) {
            imagenAlquilerImageView.setImage(alquiler.getImagen());
        }
    }

    /**
     * Método para recuperar los datos del usuario actual
     */
    private void recuperarDatos(){

        UsuarioHolder us = UsuarioHolder.getInstance();
        usuario = us.getUsuario();
    }
}

