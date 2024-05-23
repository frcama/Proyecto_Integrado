package com.example.proyecto;

import java.util.Date;

public class Eventos {
    private int id_evento;
    private String nombre;
    private Date fecha;
    private String lugar;
    public Eventos(int id_evento, String nombre, Date fecha, String lugar) {
        this.fecha = fecha;
        this.id_evento = id_evento;
        this.lugar = lugar;
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
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
}
