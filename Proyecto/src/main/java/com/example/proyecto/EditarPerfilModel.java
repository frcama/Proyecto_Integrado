package com.example.proyecto;

import javafx.scene.control.Alert;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Clase para manejar la lógica de actualización del perfil de usuario en la base de datos
 */
public class EditarPerfilModel extends Conexion{
    /**
     * Método para actualizar el nombre del usuario (actualmente vacío)
     */
    public static void actualizarNombre() {
    }

    /**
     * Método para actualizar todos los datos del usuario en la base de datos
     * @param u
     * @param nuevoNombre
     * @param nuevoApellido
     * @param nuevoCorreo
     * @param nuevaFechaNacimiento
     * @param nuevaContrasenya
     */
    public void actualizarUsuario(Usuario u, String nuevoNombre, String nuevoApellido, String nuevoCorreo, LocalDate nuevaFechaNacimiento, String nuevaContrasenya) {
        // Asumiendo que 'u' es el objeto de usuario actual con sus datos actuales
        // Asumiendo que 'perfilModel' es una instancia de una clase que maneja la conexión a la base de datos

        try {
            /**
             * Iniciar conexión a la base de datos
             */
            Conexion.abrirConexion();

            /**
             * Preparar la consulta SQL con todas las actualizaciones necesarias
             */
            String sql = "UPDATE estudiantes SET nombre = ?, apellido = ?, correo = ?, fechanacimiento = ?, contra = ? WHERE correo = ?";

            /**
             * Preparar la declaración para ejecutar la consulta
             */
            Conexion conn = null;
            PreparedStatement pstmt = conn.getConexion().prepareStatement(sql);

            /**
             * Establecer los parámetros de la consulta
             */
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevoApellido);
            pstmt.setString(3, nuevoCorreo);
            pstmt.setDate(4, Date.valueOf(nuevaFechaNacimiento)); // Asegúrate de convertir LocalDate a Date
            pstmt.setString(5, nuevaContrasenya);
            pstmt.setString(6, u.getCorreo()); // Usar el correo actual como identificador único

            /**
             * Ejecutar la consulta
             */
            int filasAfectadas = pstmt.executeUpdate();

            /**
             * Verificar si se realizó alguna actualización
             */
            if (filasAfectadas > 0) {
                // Actualizar los datos del objeto 'u'
                u.setNombre(nuevoNombre);
                u.setApellido(nuevoApellido);
                u.setCorreo(nuevoCorreo);
                u.setFechanacimiento(nuevaFechaNacimiento);
                u.setContra(nuevaContrasenya);
            } else {
                /**
                 * Mostrar un mensaje si no se encontró el registro para actualizar
                 */
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("No se encontró el usuario para actualizar");
                a.showAndWait();
            }

            /**
             * Cerrar la declaración preparada y la conexión a la base de datos
             */
            pstmt.close();
            Conexion.cerrarConexion();

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar excepciones de SQL
        }
    }

}
