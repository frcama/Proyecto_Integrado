package com.example.proyecto;

import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InicioSesionModel extends Conexion {

    public Usuario loginUsuario(String email, String contra) {
        Usuario u = new Usuario();

        try {
            String sql = "SELECT * FROM estudiantes WHERE email = ? AND contraseña = ?;";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, contra);


            ResultSet resultSet = ps.executeQuery();


            if (resultSet.next()) {
                System.out.println("El email y la contraseña existen en la base de datos.");
                u.setCorreo(resultSet.getString("email"));
                u.setContra(resultSet.getString("contraseña"));
                u.setDNI(resultSet.getString("dni_estudiante"));

            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("El Usuario no existe !");
                a.showAndWait();

                System.out.println("El email y la contraseña no se encontraron en la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: !");
        }finally {
            this.cerrarConexion();
        }
        return u;
    }
}