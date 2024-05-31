package com.example.proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.image.Image;

// Clase AnyadirEventosModel que extiende de Conexion
public class AnyadirEventosModel extends Conexion{
    // Método para añadir un evento a la base de datos
    public void AnyadirAlquiler(Eventos ev) {


        try {
            // Consulta SQL para insertar un nuevo evento en la tabla eventos_culturales
            String sql = "INSERT INTO eventos_culturales (nombre, fecha, ubicacion, fecha_anyadido,imagen,descripcion, precio,tipoEvento)VALUES (?, ?, ?, ?, ?, ?, ?,?);";
            // Preparar la declaración SQL
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            // Establecer los parámetros de la consulta utilizando los datos del objeto Eventos
            ps.setString(1,ev.getNombre());
            ps.setDate(2,ev.getFechaEvento());
            ps.setString(3,ev.getUbicacion());
            ps.setDate(4,ev.getFecha_anyadido());
            // Obtener el archivo de imagen y convertirlo en un FileInputStream
            File imagen = ev.getImageFile();
            FileInputStream FIS = new FileInputStream(imagen);
            ps.setBinaryStream(5, FIS, (int) imagen.length());

            ps.setString(6, ev.getDescripcion());
            ps.setDouble(7,ev.getPrecio());
            ps.setString(8,ev.getTipo());
            // Ejecutar la actualización de la base de datos
            ps.executeUpdate();
            System.out.println("Evento añadido con éxito");
        } catch (SQLException e) {
            // Manejo de la excepción SQL
            System.out.println("Error SQL: " + e.getMessage());
        } catch (FileNotFoundException e) {
            // Manejo de la excepción de archivo no encontrado
            throw new RuntimeException(e);
        }


    }
}
