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

    public ArrayList<Alquileres> mostrarAlquileres() {
        this.conexion = true;
        ArrayList<Alquileres> alquileresLista = new ArrayList<>();

        try {
            String sql = "SELECT  Ubicacion, nombre, precio, MetrosCuadrados, imagen, NumHabitaciones, Descripcion FROM alquileres";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Image imagen = null;
                if (rs.getBlob("imagen") != null) {
                    Blob blob = rs.getBlob("imagen");
                    InputStream inputStream = blob.getBinaryStream();
                    imagen = new Image(inputStream);
                }

                String ubicacion = rs.getString("Ubicacion");
                String nombre =  rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                String mc = rs.getString("MetrosCuadrados");
                Integer nh = rs.getInt("NumHabitaciones");
                String d = rs.getString("Descripcion");


                Alquileres a = new Alquileres(ubicacion,nombre,precio,mc,nh,d);
                alquileresLista.add(a);
            }

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
/*
public ArrayList<Alquileres> PorPreciosEntre() {
    this.conexion = true;
    ArrayList<Alquileres> alquileresLista = new ArrayList<>();

    try {
        String sql = "Select * from alquileres where precio between (?,?)";
        PreparedStatement ps = this.getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Image combertir = new Image(rs.getBlob("imagen").getBinaryStream());
            Alquileres a = new Alquileres(rs.getString("ubicacion"), rs.getString("nombre"), rs.getDouble("precio"), rs.getString("metrosCuadrados"),combertir, rs.getInt("NumHabitaciones"), rs.getString("Descripcion"));
            alquileresLista.add(a);
        }

        rs.close();
        ps.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        //se cierra conexion
        this.cerrarConexion();
    }
    return alquileresLista;
}

 */
}
