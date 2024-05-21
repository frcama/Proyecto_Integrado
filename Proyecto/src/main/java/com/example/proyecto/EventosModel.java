package com.example.proyecto;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventosModel extends Conexion{

    public ArrayList<Eventos> mostrarEventos() {

        ArrayList<Eventos> listaEventos = new ArrayList<>();

        try {
            String sql = "Select * from eventos_culturales";

            PreparedStatement ps = this.getConexion().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();


            while (rs.next()) {

                byte[] imgBytes = rs.getBytes(6);
                // Convertir bytes a BufferedImage
                InputStream in = new ByteArrayInputStream(imgBytes);
                BufferedImage img = ImageIO.read(in);
                listaEventos.add(new Eventos(rs.getInt(1),rs.getString(2),rs.getDate(3), rs.getString(4)));

                return listaEventos;
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer la imagen: " + e.getMessage());
        }

        return listaEventos;

    }

}
