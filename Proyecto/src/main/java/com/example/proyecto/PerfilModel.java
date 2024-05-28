package com.example.proyecto;

import javafx.scene.image.Image;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PerfilModel extends Conexion{

    public Usuario perfilModel(String emailUsuario, String contraUsuario) {
        this.conexion = true;

        Usuario u = new Usuario();

        try {
            String sql = "SELECT * FROM estudiantes WHERE email = ? AND contraseña = ?;";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1, emailUsuario);
            ps.setString(2, contraUsuario);

            ResultSet rs = ps.executeQuery();


            while (rs.next()) {

                String nombre = rs.getString("nombre");
                String correo = rs.getString("email");
                u= new Usuario(nombre,correo);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            //se cierra conexion
            this.cerrarConexion();
        }

    return u;
    }

}

