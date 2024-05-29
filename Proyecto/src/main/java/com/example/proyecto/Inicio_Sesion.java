package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inicio_Sesion{

    @FXML
    Button inicioBOTON;
    @FXML
    private Text id_email;
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
    private PasswordField pass;

    @FXML
    public void initialize() {

        System.out.println("el boton llega ");

        Usuario u = new Usuario();

    }

    @FXML
    public void inicioBOTONclick(ActionEvent actionEvent) {


       Usuario usuarioAutenticado = autenticarUsuario(email, pass);

        if (usuarioAutenticado != null) {
            // Guarda el usuario en UsuarioHolder
            UsuarioHolder.getInstance().setUsuario(usuarioAutenticado);

            // Cambio de pantalla
            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
                this.panelDeInicio.getChildren().setAll(pane);
            } catch (IOException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Maneja la autenticación fallida
            System.out.println("Autenticación fallida. Por favor, verifique su correo y contraseña.");
        }

       try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.panelDeInicio.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private Usuario autenticarUsuario(TextField correo, TextField contra) {
        InicioSesionModel ism = new InicioSesionModel();
        ArrayList<Usuario> listaUsuarios = ism.loginUsuario(correo, contra);

        for (Usuario us : listaUsuarios) {
            if (us.getCorreo().equals(correo) && us.getContra().equals(contra)) {
                // Usuario autenticado correctamente
                return us;
            }
        }
        return null; // Usuario no autenticado
    }

}