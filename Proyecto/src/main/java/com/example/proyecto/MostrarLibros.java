package com.example.proyecto;

import javafx.scene.layout.AnchorPane;

import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
// Clase para mostrar los detalles de un libro en la interfaz de usuario
public class MostrarLibros extends Conexion{
    // Etiquetas y elementos de la interfaz de usuario
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
    // Instancia de Libros
    Libros libros = new Libros();
    // Etiqueta para mostrar el correo de contacto
    @javafx.fxml.FXML
    private Label correoLibros;

    // Instancia de Usuario
    Usuario usuario = new Usuario();

    // Método para establecer los datos del libro en la interfaz de usuario
    public void setData(Libros libros) {
        recuperarDatos();
        // Establecer los datos del libro en las etiquetas de la interfaz de usuario
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
    // Método para recuperar los datos del usuario actual
    private void recuperarDatos(){

        UsuarioHolder us = UsuarioHolder.getInstance();
        usuario = us.getUsuario();
    }
}
