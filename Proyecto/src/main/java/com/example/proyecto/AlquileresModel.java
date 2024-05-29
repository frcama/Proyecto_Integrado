package com.example.proyecto;

import javafx.scene.image.Image;
import javafx.scene.shape.Path;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;

public class AlquileresModel extends Conexion{
    // Método para mostrar todos los alquileres, ordenados por fecha de añadido
    public ArrayList<Alquileres> mostrarAlquileres() {
        this.conexion = true;
        ArrayList<Alquileres> alquileresLista = new ArrayList<>();

        try {
            String sql = "SELECT Ubicacion, nombre, precio, MetrosCuadrados, imagen, NumHabitaciones, Descripcion FROM alquileres ORDER BY fecha_anyadido DESC;";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // Itera sobre los resultados de la consulta
            while (rs.next()) {
                Image imagen = null;
                if (rs.getBlob("imagen") != null) {
                    Blob blob = rs.getBlob("imagen");
                    InputStream inputStream = blob.getBinaryStream();
                    imagen = new Image(inputStream); //crea imagen en javaFX

                }
                // Obtiene los valores de las columnas de la fila actual
                String ubicacion = rs.getString("Ubicacion");
                String nombre =  rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                String mc = rs.getString("MetrosCuadrados");
                Integer nh = rs.getInt("NumHabitaciones");
                String d = rs.getString("Descripcion");

                // Crea un objeto Alquileres con los valores obtenidos y lo añade a la lista
                Alquileres a = new Alquileres(ubicacion,nombre,precio,mc,nh,d,imagen);
                alquileresLista.add(a);
            }
            // Cierra el ResultSet y el PreparedStatement
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
        //se cierra conexion
            this.cerrarConexion();
        }
        return alquileresLista;
        }
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Método para filtrar los alquileres en función de varios criterios
    public ArrayList<Alquileres> filtrosAlquiler(String zona, Double min, Double max, String habs) {
        this.conexion = true; // Indica que la conexión está activa
        ArrayList<Alquileres> alquileresLista = new ArrayList<>();

        try {
            // Construye la consulta SQL dinámicamente en función de los parámetros de filtro
            StringBuilder sql = new StringBuilder("SELECT * FROM alquileres WHERE 1 = 1");
            if (habs != null && !habs.isEmpty()) {
                sql.append(" AND NumHabitaciones = ?");
            }
            if (min != null) {
                sql.append(" AND precio >= ?");
            }
            if (max != null) {
                sql.append(" AND precio <= ?");
            }
            if (zona != null && !zona.isEmpty()) {
                sql.append(" AND Ubicacion = ?");
            }

            // Prepara la consulta
            PreparedStatement ps = this.getConexion().prepareStatement(sql.toString());

            // Establece los parámetros de la consulta en función de los valores proporcionados
            int paramIndex = 1;
            if (habs != null && !habs.isEmpty()) {
                ps.setString(paramIndex++, habs);
            }
            if (min != null) {
                ps.setDouble(paramIndex++, min);
            }
            if (max != null) {
                ps.setDouble(paramIndex++, max);
            }
            if (zona != null && !zona.isEmpty()) {
                ps.setString(paramIndex++, zona);
            }

            // Ejecuta la consulta
            ResultSet rs = ps.executeQuery();

            // Procesa los resultados de la consulta
            while (rs.next()) {
                Image imagen = null;
                if (rs.getBlob("imagen") != null) {
                    Blob blob = rs.getBlob("imagen");
                    InputStream inputStream = blob.getBinaryStream();
                    imagen = new Image(inputStream);
                }
                // Obtiene los valores de las columnas de la fila actual
                String ubicacion = rs.getString("Ubicacion");
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                String mc = rs.getString("MetrosCuadrados");
                String fileImagen = rs.getString("imagen");
                Integer nh = rs.getInt("NumHabitaciones");
                String d = rs.getString("Descripcion");
                // Crea un objeto Alquileres con los valores obtenidos y lo añade a la lista
                Alquileres a = new Alquileres(ubicacion, nombre, precio, mc, nh, d, imagen);
                alquileresLista.add(a);
            }

            // Cierra el ResultSet y PreparedStatement
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierra la conexión
            this.cerrarConexion();
        }
        return alquileresLista;
    }
}
