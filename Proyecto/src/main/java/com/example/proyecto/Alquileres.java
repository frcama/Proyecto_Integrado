package com.example.proyecto;

import javafx.scene.image.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;

public class Alquileres{


    private BufferedImage Bimagen;
    private int id_Alquiler;
    private String ubicacion;
    private String nombre;
    private double precio;
    private String metrosCuadrados;
    private Image imagen;
    private int nHabitaciones;
    private String Descripcion;
    private File imageFile;
    private Date fechaPublicacion;
    private String imgSrc;
    private String ciudad;

    

    public Alquileres(int id_Alquiler, String ubicacion, String nombre, Double precio, String metrosCuadrados, Image imagen, int nHabitaciones, String imgSrc) {
        this.id_Alquiler = id_Alquiler;
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.precio = precio;
        this.metrosCuadrados = metrosCuadrados;
        this.imagen = imagen;
        this.nHabitaciones = nHabitaciones;
        this.imgSrc=imgSrc;
    }

    public Alquileres(String ubicacion, String nombre, double precio, String metrosCuadrados,File imageFile, Image imagen, int nHabitaciones, String descripcion,String ciudad) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.precio = precio;
        this.metrosCuadrados = metrosCuadrados;
        this.imagen = imagen;
        this.imageFile=imageFile;
        this.nHabitaciones = nHabitaciones;
        this.Descripcion= descripcion;
        this.ciudad=ciudad;
    }

    public Alquileres(String ubicacion, String nombre, double precio, String metrosCuadrados, File imageFile, Image imagen ,int nHabitaciones, String descripcion, Date fechaPublicacion,String ciudad) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.precio = precio;
        this.metrosCuadrados = metrosCuadrados;
        this.imageFile= imageFile;
        this.imagen = imagen;
        this.nHabitaciones = nHabitaciones;
        Descripcion = descripcion;
        this.fechaPublicacion= fechaPublicacion;
        this.ciudad=ciudad;
    }

    public Alquileres(String ubicacion, String nombre, Double precio, String mc, Integer nh, String d,Image imagen) {

        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.precio = precio;
        this.metrosCuadrados = mc;
        this.nHabitaciones = nh;
        this.Descripcion = d;
        this.imagen=imagen;

    }

    public Alquileres(String ubicacion, String nombre, Double precio, String mc, Integer nh, String d,String ciudad, File imageFile) {

        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.precio = precio;
        this.metrosCuadrados = mc;
        this.nHabitaciones = nh;
        this.Descripcion = d;
        this.imageFile=imageFile;

    }

    public BufferedImage getBimagen() {
        return Bimagen;
    }

    public void setBimagen(BufferedImage bimagen) {
        Bimagen = bimagen;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        ciudad = ciudad;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Alquileres(){}


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
