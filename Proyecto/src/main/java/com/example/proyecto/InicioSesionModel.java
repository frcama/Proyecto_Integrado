package com.example.proyecto;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;

public class InicioSesionModel extends Conexion {

    public ArrayList<Usuario> loginUsuario(TextField email, TextField contra) {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM estudiantes WHERE email = ? AND contraseña = ?;";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1, email.getText());
            ps.setString(2, contra.getText());


            ResultSet resultSet = ps.executeQuery();


            if (resultSet.next()) {
                System.out.println("El email y la contraseña existen en la base de datos.");
                Usuario u = new Usuario();
                 u.setCorreo(resultSet.getString("email"));
                u.setContra(resultSet.getString("contraseña"));
                listaUsuarios.add(u);

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
        return listaUsuarios;
    }
}