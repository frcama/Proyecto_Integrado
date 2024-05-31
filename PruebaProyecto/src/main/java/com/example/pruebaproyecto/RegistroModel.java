package com.example.pruebaproyecto;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroModel extends Conexion{

    public void anyadirResgistro(Usuario us) {


        try {
            String sql = "INSERT INTO  estudiantes (dni_estudiante, nombre, apellidos, email, telefono,edad, fecha_nacimiento, contrasenya) VALUES (?, ?, ?, ?, ?, ?, ?,?);";

            PreparedStatement ps = this.getConexion().prepareStatement(sql);

            ps.setString(1, us.getDNI());
            ps.setString(2, us.getNombre());
            ps.setString(3, us.getApellido());
            ps.setString(4, us.getCorreo());
            ps.setInt(5, us.getTelefono());
            ps.setInt(6, us.getEdad());
            ps.setDate(7, Date.valueOf(us.getFechanacimiento()));
            ps.setString(8, us.getContra());

            ps.execute();
            System.out.println("Usuario añadido con éxito");
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());

        }
    }

}
