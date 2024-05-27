package com.example.proyecto;

import java.awt.*;
import java.io.File;
import java.util.Date;

public class Eventos {
    private int id_evento;
    private String nombre;
    private Date fechaEvento;
    private String ubicacion;
    private Date fecha_anyadido;
    private Image Imagen;
    private String descripcion;
    private double precio;
    private String tipo;
    private File imageFile;

    public Eventos(int id_evento, String nombre, Date fechaEvento, String ubicacion, Date fecha_anyadido, Image Imagen, String descripcion, double precio) {
        this.id_evento = id_evento;
        this.nombre = nombre;
        this.fechaEvento = fechaEvento;
        this.ubicacion = ubicacion;
        this.fecha_anyadido = fecha_anyadido;
        this.Imagen = Imagen;
        this.descripcion = descripcion;
        this.precio = precio;

    }

    public Eventos( String nombre, Date fechaEvento, String ubicacion, Date fecha_anyadido, Image Imagen, String descripcion, double precio, String tipo) {
        this.nombre = nombre;
        this.fechaEvento = fechaEvento;
        this.ubicacion = ubicacion;
        this.fecha_anyadido = fecha_anyadido;
        this.Imagen = Imagen;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
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
        return Imagen;
    }

    public void setImagen(Image imagen) {
        this.Imagen = imagen;
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
