package com.example.proyecto;

import com.sun.jdi.connect.spi.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection conexion = null;

    public Connection getConexion() {
        String cadenaConexion = "jdbc:mysql://localhost:3306/usuarios_db";
        String usuario = "root";
        String password = "1234";

        try {

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.conexion = (Connection) DriverManager.getConnection(cadenaConexion, usuario, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conexion;
    }
}
