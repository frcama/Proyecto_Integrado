package com.example.proyecto;



import javafx.scene.image.Image;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

public class EventosModel extends Conexion{

    public ArrayList<Eventos> mostrarEventos() {

        ArrayList<Eventos> listaEventos = new ArrayList<>();

        try {
            String sql = "Select * from eventos_culturales";

            PreparedStatement ps = this.getConexion().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Image Imagen = null;
                if (rs.getBlob("imagen") != null) {
                    Blob blob = rs.getBlob("imagen");
                    InputStream inputStream = blob.getBinaryStream();
                    Imagen = new Image(inputStream);
                }

                String ubicacion = rs.getString("ubicacion");
                String nombre =  rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                Date fechaEvento = rs.getDate("fecha");
                String d = rs.getString("Descripcion");

                Eventos e = new Eventos(nombre,fechaEvento,ubicacion,fechaEvento,Imagen,d,precio);

            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }

        return listaEventos;

    }
//----------------------------------------------------------------------------------------------

}
