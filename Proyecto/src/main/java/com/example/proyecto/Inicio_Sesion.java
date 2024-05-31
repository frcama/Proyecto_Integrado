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
// Clase Inicio_Sesion que maneja la interfaz de inicio de sesión

public class Inicio_Sesion{

    @FXML
    Button inicioBOTON;
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
    // Método que se ejecuta al inicializar la clase
    @FXML
    public void initialize() {

        System.out.println("el boton llega ");
        Usuario u = new Usuario();

    }
    // Método que se ejecuta al hacer clic en el botón de inicio de sesión
    @FXML
    public void inicioBOTONclick(ActionEvent actionEvent) {
        InicioSesionModel ism = new InicioSesionModel();
        String contra = pass.getText();
        String correo = email.getText();
        // Intentar iniciar sesión y obtener el usuario correspondiente
        Usuario us = ism.loginUsuario(email, pass); // Asegúrate de que este método devuelva un usuario válido

        if (us != null) {
            String passBDA = us.getContra();
            String emailBDA = us.getCorreo();
            if (contra.equals(passBDA) && correo.equals(emailBDA)) {
               enviarDatos(actionEvent);

                // Cambio de pantalla a la interfaz de inicio de sesión
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
                // Mostrar alerta si el correo o la contraseña son incorrectos
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("El correo o la contraseña son incorrectos.");
                alert.showAndWait();
            }
        } else {
            // Mostrar alerta si el usuario no existe
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("El usuario no existe.");
            alert.showAndWait();
        }
    }
    // Método para enviar datos y cambiar de pantalla
    private void enviarDatos(ActionEvent event) {
        InicioSesionModel ism = new InicioSesionModel();
        Usuario us = ism.loginUsuario(email, pass);

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        try {

            // Paso 1
            // Guardar el usuario en un holder para compartir datos entre pantallas
            UsuarioHolder holder = UsuarioHolder.getInstance();
            // Paso 2
            holder.setUsuario(us);

            // Cargar la nueva interfaz de Novedades
            Parent root = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("estubok");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error creando ventana: %s", e.getMessage()));
        }
    }
    // Método que se ejecuta al hacer clic en el botón de crear cuenta
    @FXML
    public void crearBOTONCLICK(ActionEvent actionEvent) {
        System.out.println("funciona bien");
        try {
            // Cargar la interfaz de registro
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Registro.fxml"));
            this.panelDeInicio.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Método que se ejecuta al hacer clic en el botón de recuperación de contraseña
    @FXML
    public void recu_contraclick(ActionEvent actionEvent) {
        System.out.println("funciona bien");
        try {
            // Cargar la interfaz de recuperación de contraseña
            AnchorPane pane = FXMLLoader.load(getClass().getResource("recuperacionContra.fxml"));
            this.panelDeInicio.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}