package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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
    private PasswordField pass;
    @FXML
    private Button recu_contrasenya;

    @FXML
    public void initialize() {

        System.out.println("el boton llega ");
        Usuario u = new Usuario();

    }

    @FXML
    public void inicioBOTONclick(ActionEvent actionEvent) {
        InicioSesionModel ism = new InicioSesionModel();
        String contra = pass.getText();
        String correo = email.getText();

        Usuario us = ism.loginUsuario(email, pass); // Asegúrate de que este método devuelva un usuario válido

        if (us != null) {
            String passBDA = us.getContra();
            String emailBDA = us.getCorreo();
            if (contra.equals(passBDA) && correo.equals(emailBDA)) {
                // Actualiza UsuarioHolder con la información del usuario
                UsuarioHolder usuarioHolder = UsuarioHolder.getInstance();
                usuarioHolder.setUsuario(us);

                enviarDatos(actionEvent);

                // Cambio de pantalla
                try {
                    URL fxmlLocation = getClass().getClassLoader().getResource("inicio_sesion.fxml");
                    if (fxmlLocation == null) {
                        throw new IOException("No se pudo encontrar el archivo FXML en la ruta especificada.");
                    }
                    AnchorPane pane = FXMLLoader.load(fxmlLocation);
                    this.panelDeInicio.getChildren().setAll(pane);
                } catch (IOException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, "Error cargando la pantalla de inicodeSEsion.", ex);
                    ex.printStackTrace();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("El correo o la contraseña son incorrectos.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("El usuario no existe.");
            alert.showAndWait();
        }
    }

    private void enviarDatos(ActionEvent event) {
        Usuario u = new Usuario();
        u.setContra(pass.getText());
        u.setCorreo(email.getText());

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        try {
            URL fxmlLocation = getClass().getClassLoader().getResource("inicio_sesion.fxml");
            if (fxmlLocation == null) {
                throw new IOException("No se pudo encontrar el archivo FXML en la ruta especificada.");
            }
            Parent root = FXMLLoader.load(fxmlLocation);

            // Paso 1
            UsuarioHolder holder = UsuarioHolder.getInstance();
            // Paso 2
            holder.setUsuario(u);

            Scene scene = new Scene(root);
            stage.setTitle("Tutorial JavaFX");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error creando ventana: %s", e.getMessage()));
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

}