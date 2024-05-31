package com.example.pruebaproyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditarPerfil extends Perfil{
    @FXML
    private ImageView fotoPerfil;
    @FXML
    private Button atrasDePerfilBOTON;
    @FXML
    private Button CerrarSesionBOTON;
    @FXML
    private AnchorPane panelDePerfil;
    @FXML
    private Button cambiosbutton;
    @FXML
    private TextField NuevoCorreoTF;
    @FXML
    private TextField NuevoApelllidoTF;
    @FXML
    private TextField NuevoNombreTF;
    @FXML
    private PasswordField NuevaContrasenyaTF;
    @FXML
    private DatePicker NuevaFechaTF;

    @Deprecated
    public void EditarFotoclick(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            fotoPerfil.setImage(image);
        }
    }

    @FXML
    public void atrasDePerfilBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Perfil.fxml"));
            this.panelDePerfil.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void CerrarSesionBOTONCLICK(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("inicio_sesion.fxml"));
            this.panelDePerfil.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
Usuario u = new Usuario();
    @FXML
    public void cambiosButtonClick(ActionEvent actionEvent) {
        boolean datosActualizados = false;

        if (!u.getNombre().equals(NuevoNombreTF.getText())) {
            EditarPerfilModel.actualizarNombre();
            datosActualizados = true;
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Tu Nombre es el mismo");
            a.showAndWait();
        }

        if (!u.getApellido().equals(NuevoApelllidoTF.getText())) {
            EditarPerfilModel.actualizarNombre();
            datosActualizados = true;
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Tu Apellido es el mismo");
            a.showAndWait();
        }

        if (!u.getCorreo().equals(NuevoCorreoTF.getText())) {
            EditarPerfilModel.actualizarNombre();
            datosActualizados = true;
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Tu Correo es el mismo");
            a.showAndWait();
        }

        if (!u.getFechanacimiento().equals(NuevaFechaTF.getValue())) { // Asumiendo que NuevaFechaTF es un DatePicker
            EditarPerfilModel.actualizarNombre();
            datosActualizados = true;
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Tu Fecha es la misma");
            a.showAndWait();
        }

        if (!u.getContra().equals(NuevaContrasenyaTF.getText())) {
            EditarPerfilModel.actualizarNombre();
            datosActualizados = true;
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Tu contraseña es la misma");
            a.showAndWait();
        }

        // Si se han actualizado los datos, mostrar un mensaje de éxito
        if (datosActualizados) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Tus datos han sido actualizados con éxito");
            a.showAndWait();
        }
    }



}

