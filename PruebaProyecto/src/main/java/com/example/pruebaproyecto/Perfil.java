package com.example.pruebaproyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Perfil implements Initializable {
    FileChooser fileChooser = new FileChooser();

    @javafx.fxml.FXML
    private ImageView fotoPerfil;
    @javafx.fxml.FXML
    private Button atrasDePerfilBOTON;
    @javafx.fxml.FXML
    private Button CerrarSesionBOTON;
    @javafx.fxml.FXML
    private Button editarPerfil;
    @javafx.fxml.FXML
    private AnchorPane panelDePerfil;
    @javafx.fxml.FXML
    private Label nombrePerfil;
    @javafx.fxml.FXML
    private Label fechaNacimientoPerfil;
    @javafx.fxml.FXML
    private Label contrsaenaPerfil;
    @javafx.fxml.FXML
    private Label correoPerfil;
    @javafx.fxml.FXML
    private Label apellidosPerfil;

    Usuario usuario = new Usuario();
    @javafx.fxml.FXML
    private Button verPubsButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        recuperarDatos();


        correoPerfil.setText(usuario.getCorreo());
        nombrePerfil.setText(usuario.getNombre());
        contrsaenaPerfil.setText(usuario.getContra());
        apellidosPerfil.setText(usuario.getApellido());
        fechaNacimientoPerfil.setText(String.valueOf(usuario.getFechanacimiento()));


    }
    private void recuperarDatos(){

        UsuarioHolder us = UsuarioHolder.getInstance();
         usuario = us.getUsuario();
    }

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

    @Deprecated
    public void EditarFotoPerfilclick(ActionEvent actionEvent) {

        File file = fileChooser.showOpenDialog(new Stage());
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            fotoPerfil.setImage(image);
        }
    }

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

    @javafx.fxml.FXML
    public void editarPerfilclick(ActionEvent actionEvent) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("EditarPerfil.fxml"));
            this.panelDePerfil.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void verPubsCLick(ActionEvent actionEvent) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Publicaciones.fxml"));
            this.panelDePerfil.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
