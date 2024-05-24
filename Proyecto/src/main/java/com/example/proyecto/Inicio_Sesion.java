package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inicio_Sesion{

    @FXML
    Button inicioBOTON;
    @FXML
    private Text id_email;
    @FXML
    private TextField pass;
    @FXML
    private Text id_pass;
    @FXML
    private ImageView logo;
    @FXML
    private TextField email;
    @FXML
    private Button crearBOTON;
    @FXML
    private AnchorPane panelDeInicio;
    @FXML
    private Button recu_contra;

    @FXML
    public void initialize() {
        System.out.println("el boton llega ");

    }

    @FXML
    public void inicioBOTONclick(ActionEvent actionEvent) {
        Usuario u = new Usuario();
        InicioSesionModel ism = new InicioSesionModel();
        ArrayList<Usuario> listaUsuarios = ism.loginUsuario(email, pass);

        String emailUsuario = email.getText();
        String contraUsuario = pass.getText();
        String emailBDA;
        String passBDA;
        for (Usuario us : listaUsuarios){
          emailBDA = us.getCorreo();
          passBDA = us.getContra();



            if (emailBDA != null && emailBDA.equals(emailUsuario) && passBDA.equals(contraUsuario)){
                //cambio de pantalla
                System.out.println("el if entra y compara");
                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
                    this.panelDeInicio.getChildren().setAll(pane);
                } catch (IOException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }

            }else{

            }


        }



//dentro del if

    }

    @FXML
    public void crearBOTONCLICK(ActionEvent actionEvent) {
        System.out.println("funciona bien");
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Registro.fxml"));
            this.panelDeInicio.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void recu_contraclick(ActionEvent actionEvent) {
        System.out.println("funciona bien");
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("recuperacionContra.fxml"));
            this.panelDeInicio.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}