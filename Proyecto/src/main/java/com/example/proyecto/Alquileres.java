package com.example.proyecto;

public class Alquileres {


    private int id_Alquiler;
    private String lugar;
    private String nombre;
    private double precio;
    private String metrosCuadrados;
    private byte[] imagen;

    public Alquileres(int id_Alquiler, String lugar, String nombre, double precio, String metrosCuadrados, byte[] imagen) {
        this.id_Alquiler = id_Alquiler;
        this.lugar = lugar;
        this.nombre = nombre;
        this.precio = precio;
        this.metrosCuadrados = metrosCuadrados;
        this.imagen = imagen;
    }
    public Alquileres( String lugar, String nombre, double precio, String metrosCuadrados, byte[] imagen) {
        this.lugar = lugar;
        this.nombre = nombre;
        this.precio = precio;
        this.metrosCuadrados = metrosCuadrados;
        this.imagen = imagen;
    }

    public Alquileres(){

    }


    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getId_Alquiler() {
        return id_Alquiler;
    }

    public void setId_Alquiler(int id_Alquiler) {
        this.id_Alquiler = id_Alquiler;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(String metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }
}
