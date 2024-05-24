package com.example.proyecto;

import com.mysql.cj.xdevapi.PreparableStatement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibrosModel extends Conexion {

   /* public ArrayList<Libros> mostrarLibros() {

        ArrayList<Libros> listaLibros = new ArrayList<>();

        try {
            String sql = "Select * from libros;";

            PreparedStatement ps = this.getConexion().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();


            while (rs.next()) {

                byte[] imgBytes = rs.getBytes(6);
                // Convertir bytes a BufferedImage
                InputStream in = new ByteArrayInputStream(imgBytes);
                BufferedImage img = ImageIO.read(in);
                listaLibros.add(new Libros(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), img));

                return listaLibros;
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer la imagen: " + e.getMessage());
        }

        return listaLibros;

    }
*/

}
