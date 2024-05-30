package com.example.proyecto;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MostrarEventos {
    @javafx.fxml.FXML
    private Label precioEventoLabel;
    @javafx.fxml.FXML
    private Label descripcionEventoLabel;
    @javafx.fxml.FXML
    private Label fechaEventoLabel;
    @javafx.fxml.FXML
    private Label nombreLibroLabel;
    @javafx.fxml.FXML
    private Label ubiEventoLabel;
    @javafx.fxml.FXML
    private ImageView imagenEventoImageView;
    @javafx.fxml.FXML
    private AnchorPane panelMostrarAlquiler;

    Eventos evento = new Eventos();
    @javafx.fxml.FXML
    private Label tipoEventoLabel;

    Usuario usuario = new Usuario();
    @javafx.fxml.FXML
    private Label correoEvento;

    public void setData(Eventos evento) {
        recuperarDatos();

        PerfilModel pm= new PerfilModel();
        Usuario u = new Usuario();
        u = pm.perfilModel(u.getCorreo(),u.getContra());


        nombreLibroLabel.setText(evento.getNombre());
        tipoEventoLabel.setText(evento.getTipo());
        precioEventoLabel.setText(String.valueOf(evento.getPrecio()+"€"));
        ubiEventoLabel.setText(evento.getUbicacion());
        descripcionEventoLabel.setText(evento.getDescripcion());
        fechaEventoLabel.setText(String.valueOf(evento.getFechaEvento()));
        correoEvento.setText("Contacto:" +u.getCorreo());

        // Establecer la imagen en el ImageView
        if (evento.getImagen() != null) {
            imagenEventoImageView.setImage(evento.getImagen());
        }
    }

    private void recuperarDatos(){

        UsuarioHolder us = UsuarioHolder.getInstance();
        usuario = us.getUsuario();
    }
}
