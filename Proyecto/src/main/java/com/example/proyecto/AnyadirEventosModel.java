package com.example.proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.image.Image;


public class AnyadirEventosModel extends Conexion{

    public void AnyadirAlquiler(Eventos ev) {


        try {
            String sql = "INSERT INTO eventos_culturales (nombre, fecha, ubicacion, fecha_anyadido,imagen,descripcion, precio,tipoEvento)VALUES (?, ?, ?, ?, ?, ?, ?,?);";

            PreparedStatement ps = this.getConexion().prepareStatement(sql);

            ps.setString(1,ev.getNombre());
            ps.setDate(2,ev.getFechaEvento());
            ps.setString(3,ev.getUbicacion());
            ps.setDate(4,ev.getFecha_anyadido());

            File imagen = ev.getImageFile();
            FileInputStream FIS = new FileInputStream(imagen);
            ps.setBinaryStream(5, FIS, (int) imagen.length());

            ps.setString(6, ev.getDescripcion());
            ps.setDouble(7,ev.getPrecio());
            ps.setString(8,ev.getTipo());

            ps.executeUpdate();
            System.out.println("Evento añadido con éxito");
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
