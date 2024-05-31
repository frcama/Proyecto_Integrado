package com.example.proyecto;

import javafx.scene.image.Image;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PerfilModel extends Conexion{

    // Método para obtener el perfil del usuario
    public Usuario perfilModel(String emailUsuario, String contraUsuario) {
        this.conexion = true; // Marcar la conexión como exitosa

        Usuario u = new Usuario(); // Crear una instancia de Usuario

        try {
            String sql = "SELECT * FROM estudiantes WHERE email = ? AND contraseña = ?;";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1, emailUsuario);
            ps.setString(2, contraUsuario);

            ResultSet rs = ps.executeQuery();

            // Obtener los datos del usuario del resultado de la consulta

            while (rs.next()) {

                String nombre = rs.getString("nombre");
                String correo = rs.getString("email");
                u= new Usuario(nombre,correo);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace(); // Manejar cualquier error de SQL

        } finally {
            //se cierra conexion
            this.cerrarConexion();
        }

    return u; // Devolver el objeto Usuario
    }

}

