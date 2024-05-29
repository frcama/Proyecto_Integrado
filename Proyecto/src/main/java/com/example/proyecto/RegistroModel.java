package com.example.proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroModel extends Conexion{

    public void anyadirResgistro(Usuario u) {


        try {
            String sql = "INSERT INTO estudiantes VALUES (?, ?, ?, ?, ?, ?, ?,?);";

            PreparedStatement ps = this.getConexion().prepareStatement(sql);

            ps.setString(1, u.getDNI());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellido());
            ps.setString(4, u.getCorreo());
            ps.setInt(5, u.getTelefono());
            ps.setInt(6, u.getEdad());
            ps.setDate(7, Date.valueOf(u.getFechanacimiento()));
            ps.setString(8, u.getContra());

            ps.execute();
            System.out.println("Alquiler añadido con éxito");
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());


        }
    }

}
