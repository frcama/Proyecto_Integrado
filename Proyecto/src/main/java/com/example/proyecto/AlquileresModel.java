package com.example.proyecto;

import javax.swing.*;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlquileresModel extends Conexion{



    public ArrayList<Alquileres> mostrarAlquileres() {

        ArrayList<Alquileres> alquileresLista = new ArrayList<>();

        try {
            String sql = "Select * from alquileres;";

            PreparedStatement ps = this.getConexion().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();


            // Crear el panel
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            while (rs.next()) {
                // Extraer los datos
                Blob imagenBlob = rs.getBlob("imagen");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");

                // Convertir Blob a ImageIcon
                byte[] imagenBytes = imagenBlob.getBytes(1, (int) imagenBlob.length());
                ImageIcon imagen = new ImageIcon(imagenBytes);

                // Crear un subpanel para cada objeto y añadir los datos
                JPanel subPanel = new JPanel();
                subPanel.add(new JLabel(imagen));
                subPanel.add(new JLabel("Descripción: " + descripcion));
                subPanel.add(new JLabel("Precio: " + precio));
                subPanel.add(new JLabel("Nombre: " + nombre));
                subPanel.add(new JLabel("Categoría: " + categoria));

                // Añadir el subpanel al panel principal
                panel.add(subPanel);



                // Crear un nuevo producto y añadirlo a la lista
              /*  Alquileres.add(new Alquileres(imagenBytes, descripcion, precio, nombre, categoria));
                Alquileres.add( new Alquileres(, nombre, precio, , imagenBytes);*/
            }

            // Crear el marco y añadir el panel
            JFrame frame = new JFrame("Datos de los productos");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);

            rs.close();
            ps.close();
            conexion.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return alquileresLista;
        }
}
