package com.example.proyecto;

import javafx.scene.image.Image;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class AlquileresModel extends Conexion{
    /**
     * Método para mostrar todos los alquileres, ordenados por fecha de añadido
     * @return
     */
    public ArrayList<Alquileres> mostrarAlquileres() {
        this.conexion = true;
        ArrayList<Alquileres> alquileresLista = new ArrayList<>();

        try {
            String sql = "SELECT Ubicacion, nombre, precio, MetrosCuadrados, imagen, NumHabitaciones, Descripcion, Ciudad,contacto FROM alquileres ORDER BY fecha_anyadido DESC;";
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
                int precio = rs.getInt("precio");
                String mc = rs.getString("MetrosCuadrados");
                Integer nh = rs.getInt("NumHabitaciones");
                String d = rs.getString("Descripcion");
                String ci = rs.getString("Ciudad");

                // Crea un objeto Alquileres con los valores obtenidos y lo añade a la lista
                Alquileres a = new Alquileres(ubicacion,nombre,precio,mc,nh,d,imagen, ci);
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
//
public ArrayList<Alquileres> mostrarAlquileresPorUsuario(Usuario usuario) {
    this.conexion = true;
    ArrayList<Alquileres> alquileresListaPorUsuario = new ArrayList<>();
    Usuario usuactual = UsuarioHolder.getInstance().getUsuario();

    try {
        String sql = "SELECT * FROM alquileres where id_usuario = ? ORDER BY fecha_anyadido ASC;";
        PreparedStatement ps = this.getConexion().prepareStatement(sql);
        ps.setInt(1, usuactual.getId_usuario());
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
            int precio = rs.getInt("precio");
            String mc = rs.getString("MetrosCuadrados");
            Integer nh = rs.getInt("NumHabitaciones");
            String d = rs.getString("Descripcion");
            String ci = rs.getString("Ciudad");

            // Crea un objeto Alquileres con los valores obtenidos y lo añade a la lista
            Alquileres a = new Alquileres(ubicacion,nombre,precio,mc,nh,d,imagen, ci);
            alquileresListaPorUsuario.add(a);
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
    return alquileresListaPorUsuario;
}
}
