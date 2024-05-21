package com.example.proyecto;

public class Alquileres {


    private int id_Alquiler;
    private String lugar;
    private String nombre;
    private double precio;
    private double metrosCuadrados;

    public Alquileres(int id_Alquiler, String lugar, String nombre, double precio, double metrosCuadrados) {
        this.id_Alquiler = id_Alquiler;
        this.lugar = lugar;
        this.nombre = nombre;
        this.precio = precio;
        this.metrosCuadrados = metrosCuadrados;
    }

    public Alquileres(){

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

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }
}
