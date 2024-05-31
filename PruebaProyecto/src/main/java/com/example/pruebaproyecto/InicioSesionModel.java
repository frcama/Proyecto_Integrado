package com.example.pruebaproyecto;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InicioSesionModel extends Conexion {

    public Usuario loginUsuario(TextField email, TextField contra) {
        Usuario u = new Usuario();

        try {
            String sql = "SELECT * FROM estudiantes WHERE email = ? AND contrasenya = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1, String.valueOf(email.getText()));
            ps.setString(2, String.valueOf(contra.getText()));


            ResultSet resultSet = ps.executeQuery();


            if (resultSet.next()) {
                System.out.println("El email y la contraseña existen en la base de datos.");
                u.setCorreo(resultSet.getString("email"));
                u.setContra(resultSet.getString("contrasenya"));
                u.setDNI(resultSet.getString("dni_estudiante"));
                u.setId_usuario(resultSet.getInt("id_estudiante"));
                u.setEdad(resultSet.getInt("edad"));
                u.setNombre(resultSet.getString("nombre"));
                u.setApellido(resultSet.getString("apellidos"));
                u.setTelefono(resultSet.getInt("telefono"));

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