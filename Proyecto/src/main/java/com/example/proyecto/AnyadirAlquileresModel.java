package com.example.proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnyadirAlquileresModel extends Conexion{

        public void AnyadirAlquiler(Alquileres a) {


            try {
                String sql = "INSERT INTO alquileres (Ubicacion, nombre, precio, MetrosCuadrados, imagen,FechaPublicacion, NumHabitaciones, Descripcion, ciudad)VALUES (?, ?, ?, ?, ?, ?, ?,?,?);";

                PreparedStatement ps = this.getConexion().prepareStatement(sql);

                    ps.setString(1, a.getUbicacion());
                    ps.setString(2, a.getNombre());
                    ps.setDouble(3, a.getPrecio());
                    ps.setString(4, a.getMetrosCuadrados());


                    File imagen = a.getImageFile();
                    FileInputStream FIS = new FileInputStream(imagen);
                    ps.setBinaryStream(5, FIS, (int) imagen.length());

                    ps.setDate(6, a.getFechaPublicacion());
                    ps.setInt(7, a.getnHabitaciones());
                    ps.setString(8, a.getDescripcion());
                    ps.setString(9, a.getCiudad());
                    ps.executeUpdate();
                    System.out.println("Alquiler añadido con éxito");
                } catch (SQLException e) {
                    System.out.println("Error SQL: " + e.getMessage());
                } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

}
