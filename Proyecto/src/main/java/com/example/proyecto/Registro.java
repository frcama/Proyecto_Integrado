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

public class Registro extends Conexion implements Initializable {


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

    @FXML
    public void cancelarBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("inicio_sesion.fxml"));
            this.PanelDeRegistro.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        regisrtarseBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");        regisrtarseBOTON.setOnMouseEntered(e -> regisrtarseBOTON.setStyle("-fx-background-color: linear-gradient(to right, #0000FF, #EE82EE); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        regisrtarseBOTON.setOnMouseExited(e -> regisrtarseBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        cancelarBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        cancelarBOTON.setOnMouseEntered(e -> cancelarBOTON.setStyle("-fx-background-color: linear-gradient(to right, #0000FF, #EE82EE); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        cancelarBOTON.setOnMouseExited(e -> cancelarBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));


    }

    @FXML
    public void regisrtarseBOTONclick(ActionEvent actionEvent) {

        Usuario u = new Usuario();
        RegistroModel rm = new RegistroModel();

        System.out.println("funciona");
        String nombre =nombreTF.getText();
        String apellido = apellidosTF.getText();
        int numTel = Integer.valueOf(telefonoTF.getText());
        String DNI = dniTF.getText();
        String correo = correoTF.getText();


        String contra = contrasenyaTF.getText();
        String contra2 = RepeContrasenyaTF.getText();

        if ( contra2.equals(contra)){
            contra = contra2;
        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Las contraseñas no coinciden");
            a.showAndWait();
        }

        LocalDate FechaNacimiento = fechaNacimiento.getValue();
        LocalDate fechaHoy = LocalDate.now();
        int edad = Period.between(FechaNacimiento, fechaHoy).getYears();

        Usuario us = new Usuario(nombre,apellido,correo,DNI,edad,numTel,FechaNacimiento,contra);

        rm.anyadirResgistro(us);

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Terminos.fxml"));
            this.PanelDeRegistro.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


