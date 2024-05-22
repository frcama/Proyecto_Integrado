package com.example.proyecto;


import javafx.scene.image.Image;
import java.io.File;

public class Alquileres{


    private int id_Alquiler;
    private String ubicacion;
    private String nombre;
    private double precio;
    private String metrosCuadrados;
    private Image imagen;
    private int nHabitaciones;
    private String Descripcion;
    private File imageFile;
    private byte[] arrayImagen;

    public Alquileres(int id_Alquiler, String ubicacion, String nombre, double precio, String metrosCuadrados, Image imagen, int nHabitaciones) {
        this.id_Alquiler = id_Alquiler;
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.precio = precio;
        this.metrosCuadrados = metrosCuadrados;
        this.imagen = imagen;
        this.nHabitaciones = nHabitaciones;
    }

    public Alquileres(String ubicacion, String nombre, double precio, String metrosCuadrados,File imageFile, Image imagen, int nHabitaciones, String descripcion) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.precio = precio;
        this.metrosCuadrados = metrosCuadrados;
        this.imagen = imagen;
        this.imageFile=imageFile;
        this.nHabitaciones = nHabitaciones;
        this.Descripcion= descripcion;
    }

    public Alquileres(String ubicacion, String nombre, double precio, String metrosCuadrados, byte[] arrayImagen, int nHabitaciones, String descripcion) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.precio = precio;
        this.metrosCuadrados = metrosCuadrados;
        this.arrayImagen = arrayImagen;
        this.nHabitaciones = nHabitaciones;
        Descripcion = descripcion;
    }

    public Alquileres(String ubicacion, String nombre, double precio, String metrosCuadrados, javafx.scene.image.Image combertir, int nHabitaciones){

    }

    public Alquileres(String ubicacion, String nombre, double precio, String metrosCuadrados, javafx.scene.image.Image combertir, int nHabitaciones, String descripcion) {
    }

    public Alquileres(String ubi, String nombre, int precio, String m2, File imagen, javafx.scene.image.Image imagenSeleccionada, int nHabs, String descripcion) {


    }

    public byte[] getArrayImagen() {
        return arrayImagen;
    }

    public void setArrayImagen(byte[] arrayImagen) {
        this.arrayImagen = arrayImagen;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public int getnHabitaciones() {
        return nHabitaciones;
    }

    public void setnHabitaciones(int nHabitaciones) {
        this.nHabitaciones = nHabitaciones;
    }

    public int getId_Alquiler() {
        return id_Alquiler;
    }

    public void setId_Alquiler(int id_Alquiler) {
        this.id_Alquiler = id_Alquiler;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public File getImageFile() {
        return imageFile;
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
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
