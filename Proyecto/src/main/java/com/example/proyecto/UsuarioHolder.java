package com.example.proyecto;
/**
/Clase que actúa como un singleton para almacenar el usuario actual
 */
public class UsuarioHolder {

    /**
     *La instancia única de UsuarioHolder
     */

    private static final UsuarioHolder instance = new UsuarioHolder();
    private Usuario usuario; // Variable para almacenar el usuario actual

    /**
     *Constructor privado para evitar la creación de instancias fuera de la clase
     */


    private UsuarioHolder() {
    }


    /**
     * Método para obtener la única instancia de UsuarioHolder
     */

    public static UsuarioHolder getInstance() {
        return instance;
    }

    /**
     *
     * Método para establecer el usuario
     */




    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    /**
     *
     * Método para obtener el usuario
     */

    public Usuario getUsuario() {
        return usuario;
    }


    /**
     * Metodo para limpiar el usuario
     */


    public void clear() {
        usuario = null;
    }
}
