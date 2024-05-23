package com.example.proyecto;

import javafx.scene.image.Image;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InicioSesionModel extends Conexion{

    public ArrayList<Usuario> anyadirResgistro() {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            String sql = "select * from estudiantes";

            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               // Usuario a = new Usuario(rs.getString("nombre"),rs.getString("apellido"),rs.getString("correo"),rs.getString("DNI"),rs.getInt("edad"), rs.getInt("telefono"),);
               // usuarios.add(a);
            }
            ps.execute();
            System.out.println("");
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());

        }
        return usuarios;
    }
}
