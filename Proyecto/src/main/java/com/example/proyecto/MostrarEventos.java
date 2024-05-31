package com.example.proyecto;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
// Clase para mostrar los detalles de un evento en la interfaz de usuario
public class MostrarEventos {
    // Etiquetas y elementos de la interfaz de usuario
    @javafx.fxml.FXML
    private Label precioEventoLabel;
    @javafx.fxml.FXML
    private Label descripcionEventoLabel;
    @javafx.fxml.FXML
    private Label fechaEventoLabel;
    @javafx.fxml.FXML
    private Label ubiEventoLabel;
    @javafx.fxml.FXML
    private ImageView imagenEventoImageView;
    @javafx.fxml.FXML
    private AnchorPane panelMostrarAlquiler;
    // Etiquetas y elementos de la interfaz de usuario
    Eventos evento = new Eventos();
    // Etiqueta para mostrar el tipo de evento
    @javafx.fxml.FXML
    private Label tipoEventoLabel;
    // Instancia de Usuario
    Usuario usuario = new Usuario();
    // Etiqueta para mostrar la asignatura relacionada con el evento
    @javafx.fxml.FXML
    private Label asignaturaLabel;
    // Etiqueta para mostrar el correo de contacto del usuario
    @javafx.fxml.FXML
    private Label correoEvento;
    // Etiqueta para mostrar el nombre del evento
    @javafx.fxml.FXML
    private Label nombreEventolabel;
    // Método para establecer los datos del evento en la interfaz de usuario
    public void setData(Eventos evento) {
        // Recuperar datos del usuario
        recuperarDatos();
        // Crear una instancia del modelo de perfil


        // Establecer los datos del evento en las etiquetas de la interfaz de usuario
        nombreEventolabel.setText(evento.getNombre());
        tipoEventoLabel.setText(evento.getTipo());
        precioEventoLabel.setText(String.valueOf(evento.getPrecio()+""));
        ubiEventoLabel.setText(evento.getUbicacion());
        descripcionEventoLabel.setText(evento.getDescripcion());
        fechaEventoLabel.setText(String.valueOf(evento.getFechaEvento()));
        correoEvento.setText(usuario.getCorreo());

        // Establecer la imagen en el ImageView
        if (evento.getImagen() != null) {
            imagenEventoImageView.setImage(evento.getImagen());
        }
    }
    // Método para recuperar los datos del usuario actual
    private void recuperarDatos(){

        UsuarioHolder us = UsuarioHolder.getInstance();
        usuario = us.getUsuario();
    }
}
