package com.example.proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroModel extends Conexion{

    public void anyadirResgistro(Usuario us) {


        try {
            // Consulta SQL para insertar un nuevo registro de usuario en la base de datos
            String sql = "INSERT INTO  estudiantes (dni_estudiante, nombre, apellidos, email, telefono,edad, fecha_nacimiento, contrasenya) VALUES (?, ?, ?, ?, ?, ?, ?,?);";

            PreparedStatement ps = this.getConexion().prepareStatement(sql);

            // Establecer los parámetros de la consulta SQL con los datos del usuario
            ps.setString(1, us.getDNI());
            ps.setString(2, us.getNombre());
            ps.setString(3, us.getApellido());
            ps.setString(4, us.getCorreo());
            ps.setInt(5, us.getTelefono());
            ps.setInt(6, us.getEdad());
            ps.setDate(7, Date.valueOf(us.getFechanacimiento()));
            ps.setString(8, us.getContra());

            // Ejecutar la consulta SQL para añadir el nuevo registro de usuario
            ps.execute();
            System.out.println("Usuario añadido con éxito");
        } catch (SQLException e) {
            // Manejar cualquier error de SQL que ocurra durante la ejecución de la consulta
            System.out.println("Error SQL: " + e.getMessage());

        }
    }

}
