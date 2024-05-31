package com.example.pruebaproyecto;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
    @javafx.fxml.FXML
    private Label correoLibros;


    Usuario usuario = new Usuario();


    public void setData(Libros libros) {
        recuperarDatos();

        this.libros = libros;

        tituloLibroLabel.setText(libros.getTitulo());
        precioLabel.setText(libros.getPrecio() + "€");
        //Image image = new Image(getClass().getResourceAsStream(alquiler.getImgSrc()));
        //imagenalquilerImageView.setImage(image);
        editorialLabel.setText(libros.getEditorial());
        asignaturaLabel.setText(libros.getAsignatura());
        cursoLabel.setText("Curso: " + libros.getCurso() );
        isbnLabel.setText(libros.getIsbn());
        correoLibros.setText("Contacto:" +usuario.getCorreo());

        // Establecer la imagen en el ImageView
        if (libros.getImagen() != null) {
            libroimagenImageView.setImage(libros.getImagen());
        }

    }
    private void recuperarDatos(){

        UsuarioHolder us = UsuarioHolder.getInstance();
        usuario = us.getUsuario();
    }
}
