package com.example.proyecto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MostrarEventos {
    @FXML
    private Label precioEventoLabel;
    @FXML
    private Label descripcionEventoLabel;
    @FXML
    private Label fechaEventoLabel;
    @FXML
    private Label nombreLibroLabel;
    @FXML
    private Label ubiEventoLabel;
    @FXML
    private ImageView imagenEventoImageView;
    @FXML
    private AnchorPane panelMostrarAlquiler;


    Alquileres alquiler = new Alquileres();
    @FXML
    private Label nombrePropietario;

@FXML
    public void setData(Eventos evento) {

        PerfilModel pm= new PerfilModel();
        Usuario u = new Usuario();
        u = pm.perfilModel(u.getCorreo(),u.getContra());


        nombreLibroLabel.setText(evento.getNombre());
        precioEventoLabel.setText(String.valueOf(evento.getPrecio()+"€"));
        ubiEventoLabel.setText(evento.getUbicacion());
        descripcionEventoLabel.setText(evento.getDescripcion());
        fechaEventoLabel.setText(String.valueOf(evento.getFechaEvento()));
        nombrePropietario.setText(u.getNombre());

        // Establecer la imagen en el ImageView
        if (evento.getImagen() != null) {
            imagenEventoImageView.setImage(evento.getImagen());
        }
    }
}
