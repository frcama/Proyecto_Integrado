package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Perfil implements Initializable {
    FileChooser fileChooser = new FileChooser();

    @FXML
    private ImageView fotoPerfil;
    @FXML
    private Button atrasDePerfilBOTON;
    @FXML
    private Button CerrarSesionBOTON;
    @FXML
    private Button editarPerfil;
    @FXML
    private AnchorPane panelDePerfil;
    @FXML
    private Label nombrePerfil;
    @FXML
    private Label fechaNacimientoPerfil;
    @FXML
    private Label contrsaenaPerfil;
    @FXML
    private Label apellidosPerfil;

    Usuario usuario = new Usuario();
    @FXML
    private Button verPubsButton;
    @FXML
    private Label correoPerfilLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Recuperar los datos del usuario actual
        recuperarDatos();
        if (usuario != null && correoPerfilLabel != null) {
            correoPerfilLabel.setText(usuario.getCorreo());
            nombrePerfil.setText(usuario.getNombre());
            contrsaenaPerfil.setText(usuario.getContra());
            apellidosPerfil.setText(usuario.getApellido());
            fechaNacimientoPerfil.setText(String.valueOf(usuario.getFechanacimiento()));

        }
    }
    // Método para recuperar los datos del usuario actual
    private void recuperarDatos(){

        UsuarioHolder us = UsuarioHolder.getInstance();
         usuario = us.getUsuario();
    }
    // Método para regresar a la pantalla de novedades desde el perfil
    @javafx.fxml.FXML
    public void atrasDePerfilBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.panelDePerfil.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Método para cerrar la sesión
    @javafx.fxml.FXML
    public void CerrarSesionBOTONCLICK(ActionEvent actionEvent) {
        System.out.println("funciona");
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("inicio_sesion.fxml"));
            this.panelDePerfil.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Método para editar el perfil del usuario
    @javafx.fxml.FXML
    public void editarPerfilclick(ActionEvent actionEvent) {


        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("EditarPerfil.fxml"));
            this.panelDePerfil.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



@FXML
public void verPubsCLick(ActionEvent actionEvent){
    try {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Publicaciones.fxml"));
        this.panelDePerfil.getChildren().setAll(pane);
    } catch (IOException ex) {
        Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
    }
}


}
