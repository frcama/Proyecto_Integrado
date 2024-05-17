package com.example.proyecto;

import javafx.event.ActionEvent;
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

    @javafx.fxml.FXML
    private Button aceptarBOTON;
    @javafx.fxml.FXML
    private TextField contrasenyaTF;
    @javafx.fxml.FXML
    private TextField nombreTF;
    @javafx.fxml.FXML
    private TextField dniTF;
    @javafx.fxml.FXML
    private DatePicker fechaNacimiento;
    @javafx.fxml.FXML
    private TextField RepeContrasenyaTF;
    @javafx.fxml.FXML
    private Button cancelarBOTON;
    @javafx.fxml.FXML
    private TextField apellidosTF;
    @javafx.fxml.FXML
    private TextField correoTF;
    @javafx.fxml.FXML
    private TextField telefonoTF;
    @javafx.fxml.FXML
    private AnchorPane panelRegistro;


    @javafx.fxml.FXML
    public void cancelarBOTONclick(ActionEvent actionEvent) {
        try {

            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("NO SE REGISTRO NINGUN USUARI0");
            a.showAndWait();
            AnchorPane pane = FXMLLoader.load(getClass().getResource("inicio_sesion.fxml"));
            this.panelRegistro.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void aceptarBOTONclick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("inicio_sesion.fxml"));
            this.panelRegistro.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


