package com.example.pruebaproyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
// Clase Registro que extiende de Conexion e implementa Initializable para manejar la interfaz de registro de usuario
public class Registro extends Conexion implements Initializable {

    // Definición de los componentes de la interfaz gráfica que se enlazan con el archivo FXML
    @FXML
    private TextField contrasenyaTF;
    @FXML
    private TextField nombreTF;
    @FXML
    private TextField dniTF;
    @FXML
    private DatePicker fechaNacimiento;
    @FXML
    private TextField RepeContrasenyaTF;
    @FXML
    private AnchorPane PanelDeRegistro;
    @FXML
    private Button cancelarBOTON;
    @FXML
    private TextField apellidosTF;
    @FXML
    private TextField correoTF;
    @FXML
    private TextField telefonoTF;
    @FXML
    private Button regisrtarseBOTON;

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
        // Configuración de estilos para el botón de registrarse
        regisrtarseBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");        regisrtarseBOTON.setOnMouseEntered(e -> regisrtarseBOTON.setStyle("-fx-background-color: linear-gradient(to right, #0000FF, #EE82EE); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        regisrtarseBOTON.setOnMouseExited(e -> regisrtarseBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        // Configuración de estilos para el botón de cancelar
        cancelarBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        cancelarBOTON.setOnMouseEntered(e -> cancelarBOTON.setStyle("-fx-background-color: linear-gradient(to right, #0000FF, #EE82EE); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        cancelarBOTON.setOnMouseExited(e -> cancelarBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));


    }
    // Método que se llama cuando se hace clic en el botón de registrarse
    @FXML
    public void regisrtarseBOTONclick(ActionEvent actionEvent) {
        // Creación de un nuevo usuario y un modelo de registro
        Usuario u = new Usuario();
        RegistroModel rm = new RegistroModel();

        System.out.println("funciona");
        // Obtención de los valores ingresados en los campos de texto
        String nombre =nombreTF.getText();
        String apellido = apellidosTF.getText();
        int numTel = Integer.valueOf(telefonoTF.getText());
        String DNI = dniTF.getText();
        String correo = correoTF.getText();


        String contra = contrasenyaTF.getText();
        String contra2 = RepeContrasenyaTF.getText();


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
        LocalDate FechaNacimiento = fechaNacimiento.getValue();
        LocalDate fechaHoy = LocalDate.now();
        int edad = Period.between(FechaNacimiento, fechaHoy).getYears();
        // Creación de un nuevo objeto Usuario con los datos ingresado
        Usuario us = new Usuario(nombre,apellido,correo,DNI,edad,numTel,FechaNacimiento,contra);
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


