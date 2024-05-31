package com.example.proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnyadirLibrosModel extends Conexion{
    Usuario usuario = new Usuario();
    public void AnyadirLibros(Libros l) {

        recuperarDatos();
        try {
            String sql = "INSERT INTO libros (isbn, Titulo, curso, asignatura, editorial, precio, imagen, fecha_anyadido, id_estudiante)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = this.getConexion().prepareStatement(sql);

            ps.setString(1, l.getIsbn());
            ps.setString(2, l.getTitulo());
            ps.setString(3, l.getCurso());
            ps.setString(4, l.getAsignatura());
            ps.setString(5, l.getEditorial());
            ps.setDouble(6, l.getPrecio());


            File imagen = l.getImage();
            FileInputStream FIS = new FileInputStream(imagen);
            ps.setBinaryStream(7, FIS, (int) imagen.length());

            ps.setDate(8, l.getFechaPublicacion());
            ps.setInt(9, usuario.getId_usuario());

            ps.executeUpdate();
            System.out.println("Libro añadido con éxito");
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void recuperarDatos(){

        UsuarioHolder us = UsuarioHolder.getInstance();
        usuario = us.getUsuario();

    }
}
