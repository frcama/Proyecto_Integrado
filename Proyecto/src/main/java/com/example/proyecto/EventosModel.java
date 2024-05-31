package com.example.proyecto;



import javafx.scene.image.Image;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

/**
 * Clase para manejar las consultas relacionadas con eventos
 */
public class EventosModel extends Conexion{
    /**
     * Método para obtener y mostrar todos los eventos culturales
     * @return
     */
    public ArrayList<Eventos> mostrarEventos() {
        /**
         * Lista para almacenar los eventos
         */
        ArrayList<Eventos> listaEventos = new ArrayList<>();


        try {
            /**
             * Consulta SQL para seleccionar todos los eventos ordenados por fecha de añadido
             */
            String sql = "Select * from eventos_culturales ORDER BY fecha_anyadido DESC;";
            /**
             * Preparar la declaración SQL
             */
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            // Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            // Iterar sobre los resultados de la consulta
            while (rs.next()) {
                // Obtener la imagen del evento, si existe
                Image Imagen = null;
                if (rs.getBlob("imagen") != null) {
                    Blob blob = rs.getBlob("imagen");
                    InputStream inputStream = blob.getBinaryStream();
                    Imagen = new Image(inputStream);
                }
                /**
                 * Obtener otros datos del evento
                 */
                String ubicacion = rs.getString("ubicacion");
                String nombre =  rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                Date fechaEvento = rs.getDate("fecha");
                String d = rs.getString("Descripcion");
                String tipo = rs.getString("tipoEvento");
                /**
                 * Crear un objeto Eventos y añadirlo a la lista
                 */
                Eventos e = new Eventos(nombre,fechaEvento,ubicacion,d,precio,tipo, Imagen);
                listaEventos.add(e);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
        // Devolver la lista de eventos
        return listaEventos;

    }
//----------------------------------------------------------------------------------------------

    /**
     * Método para obtener y mostrar los eventos de un usuario específico
     * @param usuario
     * @return
     */
    public ArrayList<Eventos> mostrarEventosPorUsuario(Usuario usuario) {
        // Lista para almacenar los eventos del usuario
        ArrayList<Eventos> listaEventosPorUsuario = new ArrayList<>();
        // Obtener el usuario actual
        Usuario usuactual = UsuarioHolder.getInstance().getUsuario();


        try  {
            /**
             * Consulta SQL para seleccionar los eventos del usuario actual ordenados por fecha de añadido
             */
            String sql = "SELECT * FROM eventos_culturales WHERE id_usuario = ? order by fecha_anyadido ASC";
            // Preparar la declaración SQL
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1, usuactual.getId_usuario());
            // Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            // Iterar sobre los resultados de la consulta
            while (rs.next()) {
                // Obtener la imagen del evento, si existe
                Image Imagen = null;
                if (rs.getBlob("imagen") != null) {
                    Blob blob = rs.getBlob("imagen");
                    InputStream inputStream = blob.getBinaryStream();
                    Imagen = new Image(inputStream);
                }
                // Obtener otros datos del evento
                String ubicacion = rs.getString("ubicacion");
                String nombre =  rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                Date fechaEvento = rs.getDate("fecha");
                String d = rs.getString("Descripcion");
                String tipo = rs.getString("tipoEvento");
                // Crear un objeto Eventos y añadirlo a la lista
                Eventos e = new Eventos(nombre,fechaEvento,ubicacion,d,precio,tipo, Imagen);
                listaEventosPorUsuario.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Devolver la lista de eventos del usuario
        return listaEventosPorUsuario;
    }
}
