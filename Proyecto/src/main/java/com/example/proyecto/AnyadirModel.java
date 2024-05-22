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
            String sql = "INSERT INTO alquileres (Ubicacion, nombre, precio, MetrosCuadrados, imagen, NumHabitaciones, Descripcion)" +
                    "VALUES '?', ?, ?, ?, ?, ?, ?, ?);";


            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1, a.getUbicacion());
            ps.setString(2, a.getNombre());
            ps.setString(3,String.valueOf(a.getPrecio()));
            ps.setString(4, String.valueOf(a.getMetrosCuadrados()));

            File imagen = a.getImageFile();
            FileInputStream FIS = new FileInputStream(imagen);

            ps.setBinaryStream(5, FIS, (int) imagen.length());
            ps.setInt(7, a.getnHabitaciones());
            ps.setString(8, a.getDescripcion());
            ResultSet rs = ps.executeQuery();


        } catch (SQLException |FileNotFoundException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }

    }


}
