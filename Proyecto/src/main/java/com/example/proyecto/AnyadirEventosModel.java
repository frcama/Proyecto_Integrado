package com.example.proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnyadirEventosModel extends Conexion{

    public void AnyadirAlquiler(Eventos e) {


        try {
            String sql = "INSERT INTO eventos_culturales (Ubicacion, nombre, precio, MetrosCuadrados, imagen,FechaPublicacion, NumHabitaciones, Descripcion)VALUES (?, ?, ?, ?, ?, ?, ?,?);";

            PreparedStatement ps = this.getConexion().prepareStatement(sql);



            File imagen = e.getImageFile();
            FileInputStream FIS = new FileInputStream(imagen);
            ps.setBinaryStream(5, FIS, (int) imagen.length());

            ps.setDate(6, a.getFechaPublicacion());
            ps.setInt(7, a.getnHabitaciones());
            ps.setString(8, a.getDescripcion());
            ps.executeUpdate();
            System.out.println("Alquiler añadido con éxito");
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
