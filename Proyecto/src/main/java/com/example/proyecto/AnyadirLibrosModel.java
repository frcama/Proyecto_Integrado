package com.example.proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
// Clase AnyadirLibrosModel que extiende Conexion para manejar la base de datos
public class AnyadirLibrosModel extends Conexion{
    // Método para añadir libros a la base de datos
    public void AnyadirLibros(Libros l) {

        try {
            // SQL para insertar un nuevo libro en la base de datos
            String sql = "INSERT INTO libros (isbn, Titulo, curso, asignatura, editorial, precio, imagen, fecha_anyadido)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            // Preparar la declaración SQL
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            // Configurar los parámetros de la declaración SQL con los datos del objeto Libros
            ps.setString(1, l.getIsbn());
            ps.setString(2, l.getTitulo());
            ps.setString(3, l.getCurso());
            ps.setString(4, l.getAsignatura());
            ps.setString(5, l.getEditorial());
            ps.setDouble(6, l.getPrecio());

            // Obtener el archivo de imagen y configurarlo en la declaración SQL
            File imagen = l.getImage();
            FileInputStream FIS = new FileInputStream(imagen);
            ps.setBinaryStream(7, FIS, (int) imagen.length());
            // Establecer la fecha de publicación
            ps.setDate(8, l.getFechaPublicacion());
            // Ejecutar la declaración SQL
            ps.executeUpdate();
            System.out.println("Libro añadido con éxito");
        } catch (SQLException e) {
            // Capturar y mostrar errores SQL
            System.out.println("Error SQL: " + e.getMessage());
        } catch (FileNotFoundException e) {
            // Manejar el caso de archivo de imagen no encontrado
            throw new RuntimeException(e);
        }

    }
}
