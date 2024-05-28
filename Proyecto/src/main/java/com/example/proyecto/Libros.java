package com.example.proyecto;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;
import java.time.LocalDate;

public class Libros {

    private String titulo;
    private String isbn;
    private String editorial;
    private double precio;
    private String curso;
    private BufferedImage imagen;
    private File image;
    private Date d;
    private String asignatura;



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

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    public Libros(String titulo, String isbn, String editorial, double precio, String curso, BufferedImage imagen, Date d) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.precio = precio;
        this.curso = curso;
        this.imagen = imagen;
        this.d = d;
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

    public Libros(String isbn, String titulo, Double precio, String curso, String editorial, String asignatura) {
    }

    public Libros() {
    }
}
