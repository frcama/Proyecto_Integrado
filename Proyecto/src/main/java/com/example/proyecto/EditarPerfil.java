package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para editar el perfil del usuario
 */
public class EditarPerfil extends Perfil{
    @FXML
    private ImageView fotoPerfil;
    @FXML
    private Button atrasDePerfilBOTON;
    @FXML
    private Button CerrarSesionBOTON;
    @FXML
    private AnchorPane panelDePerfil;
    @FXML
    private Button cambiosbutton;
    @FXML
    private TextField NuevoCorreoTF;
    @FXML
    private TextField NuevoApelllidoTF;
    @FXML
    private TextField NuevoNombreTF;
    @FXML
    private PasswordField NuevaContrasenyaTF;
    @FXML
    private DatePicker NuevaFechaTF;
    @FXML
    private Label apellidosEditarPerfil;
    @FXML
    private Label nombreEditarPerfil;
    @FXML
    private Label correoEditarPerfil;

    /**
     * Método para manejar el evento de hacer clic en el botón "Atrás"
     * @param actionEvent
     */

    @FXML
    public void atrasDePerfilBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Perfil.fxml"));
            this.panelDePerfil.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método para manejar el evento de hacer clic en el botón "Cerrar Sesión"
     * @param actionEvent
     */
    @FXML
    public void CerrarSesionBOTONCLICK(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("inicio_sesion.fxml"));
            this.panelDePerfil.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Instancia de usuario
     */
    Usuario u = new Usuario();

    /**
     * Método para manejar el evento de hacer clic en el botón de cambios
     * @param actionEvent
     */
    @FXML
    public void cambiosButtonClick(ActionEvent actionEvent) {
        boolean datosActualizados = false;
        /**
         * Verificar si se han realizado cambios en el nombre
         */
        if (!u.getNombre().equals(NuevoNombreTF.getText())) {
            EditarPerfilModel.actualizarNombre();
            datosActualizados = true;
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Tu Nombre es el mismo");
            a.showAndWait();
        }
        /**
         * Verificar si se han realizado cambios en el apellido
         */
        if (!u.getApellido().equals(NuevoApelllidoTF.getText())) {
            EditarPerfilModel.actualizarNombre();
            datosActualizados = true;
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Tu Apellido es el mismo");
            a.showAndWait();
        }
        /**
         * Verificar si se han realizado cambios en el correo electrónico
         */
        if (!u.getCorreo().equals(NuevoCorreoTF.getText())) {
            EditarPerfilModel.actualizarNombre();
            datosActualizados = true;
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Tu Correo es el mismo");
            a.showAndWait();
        }
        /**
         * Verificar si se han realizado cambios en la fecha de nacimiento
         */
        if (!u.getFechanacimiento().equals(NuevaFechaTF.getValue())) { // Asumiendo que NuevaFechaTF es un DatePicker
            EditarPerfilModel.actualizarNombre();
            datosActualizados = true;
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Tu Fecha es la misma");
            a.showAndWait();
        }
        /**
         * Verificar si se han realizado cambios en la contraseña
         */
        if (!u.getContra().equals(NuevaContrasenyaTF.getText())) {
            EditarPerfilModel.actualizarNombre();
            datosActualizados = true;
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Tu contraseña es la misma");
            a.showAndWait();
        }

        /**
         * Si se han actualizado los datos, mostrar un mensaje de éxito
         */
        if (datosActualizados) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Tus datos han sido actualizados con éxito");
            a.showAndWait();
        }
    }

}

