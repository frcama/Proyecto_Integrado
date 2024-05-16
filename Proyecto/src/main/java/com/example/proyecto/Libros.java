package com.example.proyecto;

public class Libros {

    private String titulo;
    private String isbn;
    private String editorial;
    private double precio;
    private int curso;

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

    public Libros(String titulo, String isbn, String editorial, double precio, int curso) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.precio = precio;
        this.curso = curso;
    }
    public Libros(){}
}
