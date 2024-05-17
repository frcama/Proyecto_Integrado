package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.security.cert.PolicyNode;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inicio_Sesion
{

    @javafx.fxml.FXML
    private Button inicioBOTON;
    @javafx.fxml.FXML
    private Text id_email;
    @javafx.fxml.FXML
    private TextField pass;
    @javafx.fxml.FXML
    private ImageView tiktok;
    @javafx.fxml.FXML
    private Text id_pass;
    @javafx.fxml.FXML
    private ImageView logo;
    @javafx.fxml.FXML
    private ImageView instagram;
    @javafx.fxml.FXML
    private TextField email;
    @javafx.fxml.FXML
    private AnchorPane panelInicioSesion;
    @javafx.fxml.FXML
    private Button crearBOTON;

    @javafx.fxml.FXML
    public void initialize() {

    }


    @javafx.fxml.FXML
    public void inicioBOTONclick(ActionEvent actionEvent) {
            System.out.println("funciona bien");
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.panelInicioSesion.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @javafx.fxml.FXML
    public void crearBOTONCLICK(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Registro.fxml"));
            this.panelInicioSesion.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
