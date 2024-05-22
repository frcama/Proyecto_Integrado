package com.example.proyecto;

import com.sun.jdi.connect.spi.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection conexion;

    private java.sql.Connection conn;
    private String cadenaConexion = "jdbc:mysql://localhost:3306/estubook";
    private String nombreUsuario = "root";
    private String password = "1234";

    public java.sql.Connection getConexion() {

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.conn = DriverManager.getConnection(this.cadenaConexion, this.nombreUsuario, this.password);
            return this.conn;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void cerrarConexion() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
