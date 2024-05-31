// RecuperarContraController.java

package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecuperarContraController {
    @FXML
    private AnchorPane panelRecu;
    @FXML
    private Button compDatosButton;
    @FXML
    private TextField correoRecuTextField;
    @FXML
    private DatePicker nacimientoDatePicker;
    @FXML
    private Label contraseñaLabel;

    private RecuperarContraModel model;
    @FXML
    private Button salirRECU;
    @FXML
    private Label incorrectoLabel;

    public RecuperarContraController() {
        model = new RecuperarContraModel();
    }

    @FXML
    public void datosButtonClick(ActionEvent actionEvent) {
        String correo = correoRecuTextField.getText();
        LocalDate fechaNacimiento = nacimientoDatePicker.getValue();
        // Código de inicialización para el controlador
        if (correo.isEmpty() || fechaNacimiento == null) {
            incorrectoLabel.setText("Por favor, completa todos los campos.");
            return;
        }

        String contraseña = model.obtenerContraseña(correo, fechaNacimiento);
        if (contraseña != null) {
            contraseñaLabel.setText(contraseña);
        } else {
            incorrectoLabel.setText("Correo o fecha de nacimiento incorrectos.");
        }
    }

    @FXML
    public void salirRECUCLICK(ActionEvent actionEvent) {
        // Acción cuando se hace clic en el botón "salirRECU"
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Inicio_sesion.fxml"));
            this.panelRecu.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
