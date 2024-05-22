package com.example.proyecto;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.shape.Path;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnyadirModel extends Conexion{

        public void AnyadirAlquiler(Alquileres a) {


            try {
                String sql = "INSERT INTO Nuevos_alquileres (Ubicacion, nombre, precio, MetrosCuadrados, imagen, NumHabitaciones, Descripcion)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?);";

                PreparedStatement ps = this.getConexion().prepareStatement(sql);

                    ps.setString(1, a.getUbicacion());
                    ps.setString(2, a.getNombre());
                    ps.setDouble(3, a.getPrecio());
                    ps.setString(4, a.getMetrosCuadrados());
                    ps.setBytes(5, a.getArrayImagen());
                    ps.setInt(6, a.getnHabitaciones());
                    ps.setString(7, a.getDescripcion());
                    ps.executeUpdate();
                    System.out.println("Alquiler añadido con éxito");
                } catch (SQLException e) {
                    System.out.println("Error SQL: " + e.getMessage());
                }
        }

}
