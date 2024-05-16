package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registro extends Conexion{
    String hola = "hola";
    @javafx.fxml.FXML
    private Button Crear_Cuenta;
    @javafx.fxml.FXML
    private AnchorPane panel1;

    @Deprecated
    public void Aceptar(ActionEvent actionEvent) {

    }


    @javafx.fxml.FXML
    public void clickCrearCuenta(ActionEvent actionEvent) {





        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("inicio_sesion.fxml"));
            this.panel1.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}