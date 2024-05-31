package com.example.proyecto;
// Importando los paquetes necesarios
import com.sun.jdi.connect.spi.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
// Definición de la clase para establecer una conexión con la base de datos
public class Conexion {
    boolean conexion;
    // Parámetros de conexión a la base de datos
    private java.sql.Connection conn;
    private String cadenaConexion = "jdbc:mysql://localhost:3306/estubook";
    private String nombreUsuario = "root";
    private String password = "1234";
    // Método para abrir una conexión a la base de datos - Actualmente vacío y no utilizado
    protected static void abrirConexion() {
    }
    // Método para obtener una conexión a la base de datos
    public java.sql.Connection getConexion() {


        try {
            // Registrando el controlador JDBC de MySQL
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            // Estableciendo la conexión a la base de datos
            this.conn = DriverManager.getConnection(this.cadenaConexion, this.nombreUsuario, this.password);
            return this.conn;// Devuelve el objeto de conexión establecido

        } catch (SQLException e) {
            e.printStackTrace();// Imprimiendo la pila de llamadas en caso de una excepción
            return null;// Devuelve null si la conexión falla
        }
    }
    // Método para cerrar la conexión a la base de datos - Actualmente vacío y no utilizado
    public static void cerrarConexion() {

    }
}
