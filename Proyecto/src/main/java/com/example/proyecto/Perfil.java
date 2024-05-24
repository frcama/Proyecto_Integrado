package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Perfil {
    FileChooser fileChooser = new FileChooser();

    @javafx.fxml.FXML
    private TextField nombreusuarioPerfil;
    @javafx.fxml.FXML
    private TextField descripccionPerfil;
    @javafx.fxml.FXML
    private TextField nombrePerfil;
    @javafx.fxml.FXML
    private DatePicker fechaNacimientoPerfil;
    @javafx.fxml.FXML
    private PasswordField contrsaenaPerfil;
    @javafx.fxml.FXML
    private ImageView fotoPerfil;
    @javafx.fxml.FXML
    private AnchorPane panelDePerfilOs;
    @javafx.fxml.FXML
    private Button CerrarSesionBOTON2;
    @javafx.fxml.FXML
    private Button atrasDePerfilBOTON2;
    @javafx.fxml.FXML
    private Button EditarFotoPerfil2;

    @Deprecated
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

    @Deprecated
    public void CerrarSesionBOTONCLICK(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("inicio_sesion.fxml"));
            this.panelDePerfil.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Deprecated
    public void editarPerfilclick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void atrasDePerfilBOTON2click(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void EditarFotoPerfil2click(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void CerrarSesionBOTON2CLICK(ActionEvent actionEvent) {
    }
}
