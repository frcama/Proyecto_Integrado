package com.example.proyecto;

import java.time.LocalDate;
import java.util.Date;

public class Usuario {

    private String nombre;
    private String apellido;
    private String correo;
    private String DNI;
    private int edad;
    private int telefono;
    private LocalDate fechanacimiento;
    private String contra;
    private String id_usuario;


    public Usuario(String nombre, String id_usuario, String DNI, String apellido, String correo, int edad, int telefono, LocalDate fechanacimiento, String contra) {
        this.nombre = nombre;
        this.id_usuario = id_usuario;
        this.DNI = DNI;
        this.apellido = apellido;
        this.correo = correo;
        this.edad = edad;
        this.telefono = telefono;
        this.fechanacimiento = fechanacimiento;
        this.contra = contra;
    }



    public Usuario(String nombre, String DNI, String apellido, String correo, int edad, int telefono, LocalDate fechanacimiento, String contra) {
        this.nombre = nombre;

        this.DNI = DNI;
        this.apellido = apellido;
        this.correo = correo;
        this.edad = edad;
        this.telefono = telefono;
        this.fechanacimiento = fechanacimiento;
        this.contra = contra;
    }

    public Usuario(String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
    }

    public Usuario(String nombre, String correo, String DNI, String id_usuario) {
        this.nombre = nombre;
        this.correo = correo;
        this.DNI = DNI;
        this.id_usuario = id_usuario;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {

        this.fechanacimiento = fechanacimiento;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Usuario(){}
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


}