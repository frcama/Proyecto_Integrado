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
    private int id_usuario;

    /**
     * Constructor que inicializa un usuario con todos los atributos proporcionados.
     */
    public Usuario(String nombre, int id_usuario, String DNI, String apellido, String correo, int edad, int telefono, LocalDate fechanacimiento, String contra) {
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

    /**
     * Constructor que inicializa un usuario sin el ID de usuario, pero con todos los demás atributos.
     */

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
    /**
     * Constructor que inicializa un usuario solo con el nombre y el correo electrónico.
     */
    public Usuario(String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
    }
    /**
     * Constructor que inicializa un usuario con el nombre, el correo electrónico, el DNI y el ID de usuario.
     */
    public Usuario(String nombre, String correo, String DNI, int id_usuario) {
        this.nombre = nombre;
        this.correo = correo;
        this.DNI = DNI;
        this.id_usuario = id_usuario;
    }
    /**
     * Devuelve el ID del usuario.
     */
    public int getId_usuario() {
        return id_usuario;
    }
    /**
     * Establece el ID del usuario.
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    /**
     * Devuelve el teléfono del usuario.
     */
    public int getTelefono() {
        return telefono;
    }
    /**
     * Establece el teléfono del usuario.
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    /**
     * Devuelve la fecha de nacimiento del usuario.
     */
    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }
    /**
     * Establece la fecha de nacimiento del usuario.
     */
    public void setFechanacimiento(LocalDate fechanacimiento) {

        this.fechanacimiento = fechanacimiento;
    }
    /**
     * Devuelve la contraseña del usuario.
     */
    public String getContra() {
        return contra;
    }
    /**
     * Establece la contraseña del usuario.
     */
    public void setContra(String contra) {
        this.contra = contra;
    }
    /**
     * Constructor sin argumentos.
     */
    public Usuario(){}
    /**
     * Devuelve el nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Devuelve el correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * Establece el correo electrónico del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * Devuelve el apellido del usuario.
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * Establece el apellido del usuario.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * Devuelve el DNI del usuario.
     */
    public String getDNI() {
        return DNI;
    }
    /**
     * Establece el DNI del usuario.
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    /**
     * Devuelve la edad del usuario.
     */
    public int getEdad() {
        return edad;
    }
    /**
     * Establece la edad del usuario.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }


}