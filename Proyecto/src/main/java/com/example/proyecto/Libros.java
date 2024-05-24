package com.example.proyecto;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

public class Libros {

    private String titulo;
    private String isbn;
    private String editorial;
    private double precio;
    private int curso;
    private BufferedImage imagen;
    private LocalDate fechaPublicacion;

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
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

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    public Libros(String titulo, String isbn, String editorial, double precio, int curso, BufferedImage imagen, LocalDate fechaPublicacion) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.precio = precio;
        this.curso = curso;
        this.imagen = imagen;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Libros() {
    }
}
