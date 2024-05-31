package com.example.proyecto;

import javafx.scene.image.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;
// Clase para representar libros
public class Libros {
    // Atributos de la clase Libros
    private String titulo;
    private String isbn;
    private String editorial;
    private double precio;
    private String curso;
    private File image;
    private Date d;
    private String asignatura;
    private Image imagen;
    private Usuario u;
    private int id_usuario;


    // Métodos getters y setters para acceder y modificar los atributos de la clase
    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public Date getFechaPublicacion() {
        return d;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.d = fechaPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Libros(String titulo, String isbn, String editorial, double precio, String curso, File image, Usuario u ) {

        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.precio = precio;
        this.curso = curso;
        this.image = image;
        this.u = u;
    }


    public Libros(String titulo, String isbn, String editorial, double precio, String curso, File image) {

        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.precio = precio;
        this.curso = curso;
        this.image = image;

    }

    public Libros(String titulo, String isbn, String editorial, double precio, String curso, File image, Date d) {

        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.precio = precio;
        this.curso = curso;
        this.image = image;
        this.d = d;
    }

    //


    public Libros(String isbn, String titulo, Double precio, String curso, String editorial, String asignatura,Image imagen) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.precio = precio;
        this.curso = curso;
        this.asignatura = asignatura;
        this.imagen=imagen;
    }


    public Libros(String isbn, String titulo, String curso, String asignatura, String editorial, double precio,Image image) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.precio = precio;
        this.curso = curso;
        this.asignatura = asignatura;
        this.imagen=image;
    }

    public Libros(String titulo, String isbn, String editorial, double precio, String asignatura, String curso, File imagen, Date d) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.precio = precio;
        this.curso = curso;
        this.asignatura = asignatura;
        this.image = imagen;
        this.d = d;
    }

    public Libros() {
    }
}
