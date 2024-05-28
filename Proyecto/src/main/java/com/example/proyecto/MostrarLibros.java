package com.example.proyecto;

import javafx.scene.layout.AnchorPane;

import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class MostrarLibros extends Conexion{
    @javafx.fxml.FXML
    private Label isbnLabel;
    @javafx.fxml.FXML
    private Label editorialLabel;
    @javafx.fxml.FXML
    private Label precioLabel;
    @javafx.fxml.FXML
    private Label asignaturaLabel;
    @javafx.fxml.FXML
    private Label tituloLibroLabel;
    @javafx.fxml.FXML
    private Label cursoLabel;
    @javafx.fxml.FXML
    private AnchorPane panelMostrarLibros;
    @javafx.fxml.FXML
    private ImageView libroimagenImageView;
    
    Libros libros = new Libros();

    public void setData(Libros libros) {

        this.libros = libros;

        tituloLibroLabel.setText(libros.getTitulo());
        precioLabel.setText(libros.getPrecio() + "€");
        //Image image = new Image(getClass().getResourceAsStream(alquiler.getImgSrc()));
        //imagenalquilerImageView.setImage(image);
        editorialLabel.setText(libros.getEditorial());
        asignaturaLabel.setText(libros.getAsignatura());
        cursoLabel.setText(libros.getCurso());
        isbnLabel.setText(libros.getIsbn());

    }
}
