package com.example.proyecto;

public class UsuarioHolder {

    // La instancia única de UsuarioHolder
    private static final UsuarioHolder instance = new UsuarioHolder();
    private Usuario usuario;

    // Constructor privado para evitar la creación de instancias fuera de la clase
    private UsuarioHolder() {
    }


    // Método para obtener la única instancia de UsuarioHolder
    public static UsuarioHolder getInstance() {
        return instance;
    }

    // Método para establecer el usuario
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Método para obtener el usuario
    public Usuario getUsuario() {
        return usuario;
    }

    // Método para limpiar el usuario
    public void clear() {
        usuario = null;
    }
}
