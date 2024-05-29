package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

        InicioSesionModel ism = new InicioSesionModel();

        String contra = pass.getText();
        String correo = email.getText();

        ArrayList<Usuario> listausuarios = ism.loginUsuario(correo, contra);

        for ( Usuario u : listausuarios){
            String passBDA = u.getContra();
            String emailBDA = u.getCorreo();
            if(contra.equals(passBDA) && correo.equals(emailBDA) ){
                enviarDatos(actionEvent);
                // Cambio de pantalla
                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
                    this.panelDeInicio.getChildren().setAll(pane);
                } catch (IOException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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



    private void enviarDatos(ActionEvent event){


        Usuario u = new Usuario();
        u.setContra(pass.getText());
        u.setCorreo(email.getText());

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        try {
            Parent root = FXMLLoader.load(Inicio_Sesion.class.getClassLoader().getResource("inicio_sesion.fxml"));
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

}