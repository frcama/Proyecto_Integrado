package com.example.proyecto;

import javafx.scene.layout.AnchorPane;

import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
// Clase MostrarLibros para mostrar la información de un libro específico
public class MostrarLibros extends Conexion{
    // Definición de los componentes de la interfaz gráfica que se enlazan con el archivo FXML
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

    // Objeto Libros que representa el libro que se va a mostrar
    Libros libros = new Libros();
    // Método para establecer los datos del libro
    public void setData(Libros libros) {
        // Asignar el objeto libro recibido al atributo de la clase
        this.libros = libros;
        // Configurar las etiquetas con los datos del libro
        tituloLibroLabel.setText(libros.getTitulo());
        precioLabel.setText(libros.getPrecio() + "€");
        //Image image = new Image(getClass().getResourceAsStream(alquiler.getImgSrc()));
        //imagenalquilerImageView.setImage(image);
        editorialLabel.setText(libros.getEditorial());
        asignaturaLabel.setText(libros.getAsignatura());
        cursoLabel.setText("Curso: " + libros.getCurso() );
        isbnLabel.setText(libros.getIsbn());

        // Establecer la imagen en el ImageView, si está disponible
        if (libros.getImagen() != null) {
            libroimagenImageView.setImage(libros.getImagen());
        }

    }
}
