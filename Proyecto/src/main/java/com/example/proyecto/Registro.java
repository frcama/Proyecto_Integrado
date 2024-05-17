package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.security.cert.PolicyNode;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registro extends Conexion{

    @FXML
    private Button aceptarBOTON;
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
    private Button cancelarBOTON;
    @FXML
    private TextField apellidosTF;
    @FXML
    private TextField correoTF;
    @FXML
    private TextField telefonoTF;
    @FXML
    private AnchorPane PanelDeRegistro;


    @FXML
    public void aceptarBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("inicio_sesion.fxml"));
            this.PanelDeRegistro.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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


}


