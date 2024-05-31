// RecuperarContraModel.java

package com.example.proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;

public class RecuperarContraModel extends Conexion {

    public String obtenerContraseña(String correo, LocalDate fechaNacimiento) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = this.getConexion();
            String query = "SELECT contrasenya FROM estudiantes WHERE email = ? AND fecha_nacimiento = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, correo);
            statement.setDate(2, Date.valueOf(fechaNacimiento));

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("contrasenya");
            } else {
                return null; // No se encontró un usuario con esos datos
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
