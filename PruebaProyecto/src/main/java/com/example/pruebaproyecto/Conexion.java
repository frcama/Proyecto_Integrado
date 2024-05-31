package com.example.pruebaproyecto;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    boolean conexion;

    private java.sql.Connection conn;
    private String cadenaConexion = "jdbc:mysql://localhost:3306/estubook";
    private String nombreUsuario = "root";
    private String password = "1234";

    protected static void abrirConexion() {
    }

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

    public static void cerrarConexion() {

    }
}
