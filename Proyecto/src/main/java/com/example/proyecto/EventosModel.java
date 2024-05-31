package com.example.proyecto;



import javafx.scene.image.Image;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

public class EventosModel extends Conexion{

    public ArrayList<Eventos> mostrarEventos() {

        ArrayList<Eventos> listaEventos = new ArrayList<>();

        try {
            String sql = "Select * from eventos_culturales ORDER BY fecha_anyadido ASC;";

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
                String tipo = rs.getString("tipoEvento");

                Eventos e = new Eventos(nombre,fechaEvento,ubicacion,d,precio,tipo, Imagen);
                listaEventos.add(e);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }

        return listaEventos;

    }
//----------------------------------------------------------------------------------------------

    public ArrayList<Eventos> mostrarEventosPorUsuario(Usuario usuario) {
        ArrayList<Eventos> listaEventosPorUsuario = new ArrayList<>();
        Usuario usuactual = UsuarioHolder.getInstance().getUsuario();


        try  {
            String sql = "SELECT * FROM eventos_culturales WHERE id_estudiante = ? order by fecha_anyadido ASC";

            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1, usuactual.getId_usuario());
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
                String tipo = rs.getString("tipoEvento");

                Eventos e = new Eventos(nombre,fechaEvento,ubicacion,d,precio,tipo, Imagen);
                listaEventosPorUsuario.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaEventosPorUsuario;
    }
}
