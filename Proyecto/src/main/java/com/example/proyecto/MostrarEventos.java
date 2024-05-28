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



    Alquileres alquiler = new Alquileres();
    @javafx.fxml.FXML
    private Label nombrePublicadoEvento;

    public void setData(Eventos evento,String nombre) {

        PerfilModel pm= new PerfilModel();
        Usuario u = new Usuario();
        u = pm.perfilModel(u.getCorreo(),u.getContra());


        nombreLibroLabel.setText(evento.getNombre());
        precioEventoLabel.setText(String.valueOf(evento.getPrecio()+"€"));
        //Image image = new Image(getClass().getResourceAsStream(evento.getImgSrc()));
        //imagenalquilerImageView.setImage(image);
        ubiEventoLabel.setText(evento.getUbicacion());
        descripcionEventoLabel.setText(evento.getDescripcion());
        fechaEventoLabel.setText(String.valueOf(evento.getFechaEvento()));
        nombrePublicadoEvento.setText(u.getNombre());

    }
}
