package com.example.proyecto;


import javafx.scene.image.Image;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase para manejar operaciones relacionadas con libros en la base de datos
 */
public class LibrosModel extends Conexion {

    Usuario usuario = new Usuario();

    /**
     * Método para mostrar todos los libros disponibles
     * @return
     */
    public ArrayList<Libros> mostrarLibros() {

        ArrayList<Libros> listaLibros = new ArrayList<>();

        try {
            String sql = "SELECT isbn, Titulo, curso, asignatura, editorial, precio, imagen,id_usuario FROM libros ORDER BY fecha_anyadido ASC;";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // Recorrer el conjunto de resultados y crear objetos Libros
            while (rs.next()) {
                Image imagen = null;
                if (rs.getBlob("imagen") != null) {
                    Blob blob = rs.getBlob("imagen");
                    InputStream inputStream = blob.getBinaryStream();
                    imagen = new Image(inputStream);
                }

                String ISBN = rs.getString("isbn");
                String Titulo =  rs.getString("Titulo");
                String Curso = rs.getString("curso");
                String asignautra = rs.getString("asignatura");
                String editorial = rs.getString("editorial");
                double precio = rs.getDouble("precio");


                Libros l = new Libros(ISBN ,Titulo ,Curso , asignautra, editorial, precio,imagen);
                listaLibros.add(l);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            //se cierra conexion
            this.cerrarConexion();
        }
        return listaLibros;
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//

    /**
     * Método para mostrar los libros pertenecientes a un usuario específico
     * @param usuario
     * @return
     */
    public ArrayList<Libros> mostrarLibrosPorUsuario(Usuario usuario) {
        ArrayList<Libros> librosPorUsuario = new ArrayList<>();

        Usuario usuactual = UsuarioHolder.getInstance().getUsuario();

        try  {
            String sql = "SELECT  isbn, Titulo, curso, asignatura, editorial, precio, imagen FROM libros WHERE id_estudiante = ?";

            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1, usuactual.getId_usuario());
            ResultSet rs = ps.executeQuery();
            // Recorrer el conjunto de resultados y crear objetos Libros
            while (rs.next()) {
                Image imagen = null;
                if (rs.getBlob("imagen") != null) {
                    Blob blob = rs.getBlob("imagen");
                    InputStream inputStream = blob.getBinaryStream();
                    imagen = new Image(inputStream);
                }

                String ISBN = rs.getString("isbn");
                String Titulo =  rs.getString("Titulo");
                String Curso = rs.getString("curso");
                String asignautra = rs.getString("asignatura");
                String editorial = rs.getString("editorial");
                double precio = rs.getDouble("precio");

                // Crear un objeto Libros y agregarlo a la lista
                Libros l = new Libros(ISBN ,Titulo ,Curso , asignautra, editorial, precio,imagen);
                librosPorUsuario.add(l);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //se cierra conexion
            this.cerrarConexion();
        }

        return librosPorUsuario;
    }

}
