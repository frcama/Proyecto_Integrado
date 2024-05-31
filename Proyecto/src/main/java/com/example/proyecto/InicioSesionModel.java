package com.example.proyecto;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase para manejar el inicio de sesión de usuarios
 */
public class InicioSesionModel extends Conexion {
    /**
     * Método para iniciar sesión de usuario
     * @param email
     * @param contra
     * @return
     */
    public Usuario loginUsuario(TextField email, TextField contra) {
        /**
         * Crear un objeto Usuario para almacenar los datos del usuario
         */
        Usuario u = new Usuario();

        try {
            /**
             * Consulta SQL para verificar si el email y la contraseña coinciden en la base de datos
             */
            String sql = "SELECT * FROM estudiantes WHERE email = ? AND contrasenya = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1, String.valueOf(email.getText()));
            ps.setString(2, String.valueOf(contra.getText()));

            /**
             * Ejecutar la consulta
             */
            ResultSet resultSet = ps.executeQuery();


            if (resultSet.next()) {
                /**
                 * Los datos coinciden, llenar el objeto Usuario con la información obtenida
                 */
                System.out.println("El email y la contraseña existen en la base de datos.");
                u.setCorreo(resultSet.getString("email"));
                u.setContra(resultSet.getString("contrasenya"));
                u.setDNI(resultSet.getString("dni_estudiante"));
                u.setId_usuario(resultSet.getInt("id_estudiante"));
                u.setEdad(resultSet.getInt("edad"));
                u.setNombre(resultSet.getString("nombre"));
                u.setApellido(resultSet.getString("apellidos"));
                u.setTelefono(resultSet.getInt("telefono"));
                u.setFechanacimiento(resultSet.getDate("fecha_nacimiento").toLocalDate());

            } else {
                /**
                 * No se encontraron coincidencias, mostrar mensaje de error
                 */
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("El Usuario no existe !");
                a.showAndWait();

                System.out.println("El email y la contraseña no se encontraron en la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: !");
        }finally {
            /**
             * Cerrar la conexión con la base de datos
             */
            this.cerrarConexion();
        }
        /**
         * Devolver el objeto Usuario con la información obtenida
         */
        return u;
    }
}