package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.security.cert.PolicyNode;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
// Clase Registro que extiende de Conexion e implementa Initializable para manejar la interfaz de registro de usuario
public class Registro extends Conexion implements Initializable {

    @FXML
    private AnchorPane PanelDeRegistro;
    @FXML
    private Button cancelarBOTON;
    @FXML
    private Button registrarseBOTON;
    @FXML
    private TextField RepeContrasenyaRegistro;
    @FXML
    private TextField telefonoRegistro;
    @FXML
    private DatePicker fechaNacimientoRegistro;
    @FXML
    private TextField nombreRegistro;
    @FXML
    private TextField correoRegistro;
    @FXML
    private TextField contrasenyaRegistro;
    @FXML
    private TextField apellidosRegistro;
    @FXML
    private TextField dniRegistro;

    // Método que se llama cuando se hace clic en el botón cancelar
    @FXML
    public void cancelarBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");
        // Carga la interfaz de inicio de sesión y la establece en el panel de registro
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("inicio_sesion.fxml"));
            this.PanelDeRegistro.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Método initialize que se llama al inicializar el controlador
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    // Método que se llama cuando se hace clic en el botón de registrarse




    @FXML
    public void registrarseBOTONclick(ActionEvent actionEvent) {
        Usuario u = new Usuario();
        RegistroModel rm = new RegistroModel();

        System.out.println("funciona");
        // Obtención de los valores ingresados en los campos de texto
        String nombre =nombreRegistro.getText();
        String apellido = apellidosRegistro.getText();
        int numTel = Integer.valueOf(telefonoRegistro.getText());
        String DNI = dniRegistro.getText();
        String correo = correoRegistro.getText();


        String contra = contrasenyaRegistro.getText();
        String contra2 = RepeContrasenyaRegistro.getText();


        // Verificación de que las contraseñas coinciden
        if ( contra2.equals(contra)){
            contra = contra2;
        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Las contraseñas no coinciden");
            a.showAndWait();
        }

        // Cálculo de la edad del usuario
        LocalDate FechaNacimiento = fechaNacimientoRegistro.getValue();
        LocalDate fechaHoy = LocalDate.now();
        int edad = Period.between(FechaNacimiento, fechaHoy).getYears();
        // Creación de un nuevo objeto Usuario con los datos ingresado
        Usuario us = new Usuario(DNI,nombre,apellido,correo,numTel,edad,FechaNacimiento,contra);
        // Agregar el nuevo usuario al modelo de registro
        rm.anyadirResgistro(us);

        // Carga la interfaz de términos y la establece en el panel de registro
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Terminos.fxml"));
            this.PanelDeRegistro.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


