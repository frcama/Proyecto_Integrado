package com.example.proyecto;
// Importación necesaria para manejar imágenes
import javafx.scene.image.Image;
// Importación necesaria para manejar fechas
import java.io.File;
import java.sql.Date;
// Clase que representa un evento
public class Eventos {
    private int id_evento;
    private String nombre;
    private Date fechaEvento;
    private String ubicacion;
    private Date fecha_anyadido;
    private Image imagen;
    private String descripcion;
    private double precio;
    private String tipo;
    private File imageFile;

private Usuario u ;


    // Constructor de la clase con parámetros completos
    public Eventos( String nombre, Date fechaEvento, String ubicacion, Date fecha_anyadido, Image imagen, File imageFile, String descripcion, double precio, String tipo) {
        this.nombre = nombre;
        this.fechaEvento = fechaEvento;
        this.ubicacion = ubicacion;
        this.fecha_anyadido = fecha_anyadido;
        this.imagen = imagen;
        this.imageFile=imageFile;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
        this.imagen=imagen;
    }
    // Constructor vacío de la clase
    public Eventos(){

    }
    // Constructor de la clase con parámetros básicos
    public Eventos( String nombre, Date fechaEvento, String ubicacion, String descripcion, double precio, String tipo, Image imagen, Usuario u ) {
        this.nombre = nombre;
        this.fechaEvento = fechaEvento;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
        this.imagen=imagen;
        this.u = u;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }
    // Constructor de la clase con parámetros básicos y sin usuario
    public Eventos(String nombre, Date fechaEvento, String ubicacion, String descripcion, double precio, String tipo, Image imagen) {
        this.nombre = nombre;
        this.fechaEvento = fechaEvento;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
        this.imagen=imagen;
    }

    // Getters y Setters para todos los atributos de la clase
    public File getImageFile() {
        return imageFile;
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha_anyadido() {
        return fecha_anyadido;
    }

    public void setFecha_anyadido(Date fecha_anyadido) {
        this.fecha_anyadido = fecha_anyadido;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
