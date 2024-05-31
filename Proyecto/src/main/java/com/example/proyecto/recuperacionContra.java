package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class recuperacionContra implements Initializable {
    @javafx.fxml.FXML
    private Button salirRECU;
    @javafx.fxml.FXML
    private Label mostrarContraRECU;
    @javafx.fxml.FXML
    private Label CodigoRECU_ERROR;
    @javafx.fxml.FXML
    private AnchorPane panelRecu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Código de inicialización para el controlador
    }

    @javafx.fxml.FXML
    public void salirRECUCLICK(ActionEvent actionEvent) {
        // Acción cuando se hace clic en el botón "salirRECU"
        System.out.println("funciona bien");
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("inicio_sesion.fxml"));
            this.panelRecu.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
