package com.example.proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnyadirAlquileresModel extends Conexion{
    // Método para añadir un alquiler a la base de datos
        public void AnyadirAlquiler(Alquileres a) {


            try {
                // Sentencia SQL para insertar un nuevo registro en la tabla alquileres
                String sql = "INSERT INTO alquileres (Ubicacion, nombre, precio, MetrosCuadrados, imagen,fecha_anyadido, NumHabitaciones, Descripcion, Ciudad)VALUES (?, ?, ?, ?, ?, ?, ?,?,?);";
                // Prepara la sentencia SQL utilizando la conexión establecida en la clase base 'Conexion'
                PreparedStatement ps = this.getConexion().prepareStatement(sql);
                // Establece los valores de los parámetros en la sentencia SQL
                    ps.setString(1, a.getUbicacion());
                    ps.setString(2, a.getNombre());
                    ps.setDouble(3, a.getPrecio());
                    ps.setString(4, a.getMetrosCuadrados());

                // Obtiene el archivo de imagen y lo convierte a FileInputStream para almacenarlo como un flujo binario
                    File imagen = a.getImageFile();
                    FileInputStream FIS = new FileInputStream(imagen);
                    ps.setBinaryStream(5, FIS, (int) imagen.length());
                // Establece los valores restantes de los parámetros en la sentencia SQL
                    ps.setDate(6, a.getFechaPublicacion());
                    ps.setInt(7, a.getnHabitaciones());
                    ps.setString(8, a.getDescripcion());
                    ps.setString(9, a.getCiudad());
                // Ejecuta la sentencia SQL para insertar el nuevo registro
                    ps.executeUpdate();
                    System.out.println("Alquiler añadido con éxito");
                } catch (SQLException e) {
                    // Manejo de excepciones SQL
                    System.out.println("Error SQL: " + e.getMessage());
                } catch (FileNotFoundException e) {
                // Manejo de excepciones de archivo no encontrado
                throw new RuntimeException(e);
            }
        }

}
