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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registro extends Conexion implements Initializable {


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
    public void cancelarBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("inicio_sesion.fxml"));
            this.PanelDeRegistro.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void aceptarBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Terminos.fxml"));
            this.PanelDeRegistro.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        aceptarBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        aceptarBOTON.setOnMouseEntered(e -> aceptarBOTON.setStyle("-fx-background-color: linear-gradient(to right, #0000FF, #EE82EE); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        aceptarBOTON.setOnMouseExited(e -> aceptarBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        cancelarBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        cancelarBOTON.setOnMouseEntered(e -> cancelarBOTON.setStyle("-fx-background-color: linear-gradient(to right, #0000FF, #EE82EE); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        cancelarBOTON.setOnMouseExited(e -> cancelarBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));


    }
}


