package com.example.proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnyadirLibrosModel extends Conexion{

    public void AnyadirLibros(Libros l) {

        try {
            String sql = "INSERT INTO libros (isbn, editorial, precio, curso, Titulo, imagen, fecha_añadido)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = this.getConexion().prepareStatement(sql);

            ps.setString(1, l.getIsbn());
            ps.setString(2, l.getEditorial());
            ps.setDouble(3, l.getPrecio());
            ps.setString(4, l.getCurso());
            ps.setString(5, l.getTitulo());


            File imagen = l.getImage();
            FileInputStream FIS = new FileInputStream(imagen);
            ps.setBinaryStream(6, FIS, (int) imagen.length());

            ps.setDate(7, l.getFechaPublicacion());

            ps.executeUpdate();
            System.out.println("Libro añadido con éxito");
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
