package com.example.proyecto;

import javafx.scene.image.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;
// Clase Alquileres que representa la información de un alquiler
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
    private int id_Usuario;
    private String contacto;
    private Usuario u;
    // Métodos getter y setter para cada atributo
    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    // Constructor que inicializa varios atributos del alquiler, incluyendo el usuario asociado
    public Alquileres(int id_Alquiler, String ubicacion, String nombre, Double precio, String metrosCuadrados, Image imagen, int nHabitaciones, String imgSrc, Usuario u) {
        this.id_Alquiler = id_Alquiler;
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.precio = precio;
        this.metrosCuadrados = metrosCuadrados;
        this.imagen = imagen;
        this.nHabitaciones = nHabitaciones;
        this.imgSrc=imgSrc;
        this.u = u;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }
    // Constructor que inicializa varios atributos del alquiler sin el usuario asociado
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
    // Constructor que inicializa varios atributos del alquiler, incluyendo el archivo de imagen
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
    // Constructor que inicializa todos los atributos del alquiler
    public Alquileres(String ubicacion, String nombre, double precio, String metrosCuadrados, File imageFile, Image imagen ,int nHabitaciones, String descripcion, Date fechaPublicacion,String ciudad,String contacto,int id_Usuario) {
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
        this.contacto=contacto;
        this.id_Usuario=id_Usuario;
    }
    // Otro constructor con diferentes parámetros
    public Alquileres(String ubicacion, String nombre, Double precio, String mc, Integer nh, String d,Image imagen) {

        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.precio = precio;
        this.metrosCuadrados = mc;
        this.nHabitaciones = nh;
        this.Descripcion = d;
        this.imagen=imagen;

    }
    // Otro constructor que incluye ciudad y archivo de imagen
    public Alquileres(String ubicacion, String nombre, Double precio, String mc, Integer nh, String d,String ciudad, File imageFile) {

        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.precio = precio;
        this.metrosCuadrados = mc;
        this.nHabitaciones = nh;
        this.Descripcion = d;
        this.imageFile=imageFile;

    }
    // Otro constructor que incluye imagen y ciudad
    public Alquileres(String ubicacion, String nombre, Double precio, String mc, Integer nh, String d, Image imagen, String ci) {

        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.precio = precio;
        this.metrosCuadrados = mc;
        this.nHabitaciones = nh;
        this.Descripcion = d;
        this.imagen = imagen;
        this.ciudad = ci;
    }
    // Métodos getter y setter para cada atributo
    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
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

    // Constructor por defecto
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
