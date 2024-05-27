package com.example.proyecto;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Chat
{
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private Button EnviarBOTON;
    @javafx.fxml.FXML
    private TextField MensajeTF;
    @javafx.fxml.FXML
    private AnchorPane panelDelChat;
    @javafx.fxml.FXML
    private Button atrasChatBOTON;




    private ObservableList<String> mensajes = FXCollections.observableArrayList();
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/proyecto/Chat.fxml"));
    @javafx.fxml.FXML
    private ScrollPane panelCHAT;

    @javafx.fxml.FXML
    public void initialize() {
        // Configuración del tamaño de la fuente de la respuesta
        label.setStyle("-fx-font-size: 15px;");
    }

    @javafx.fxml.FXML
    public void EnviarBOTONclick(ActionEvent actionEvent) {
        String texto = MensajeTF.getText();
        mensajes.add(" Usuario: " + texto); // Agrega el mensaje del usuario a la lista de mensajes
        MensajeTF.clear();
        actualizarMensajes();

        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> {
            if (texto.contains("hola")) {
                mensajes.add(" Bot: ¡Hola!"); // Agregamos un espacio al inicio del mensaje
            }
            if (texto.contains("adios")) {
                mensajes.add(" Bot: ¡Hasta Luego!"); // Agregamos un espacio al inicio del mensaje
            }
            if (texto.contains("Alquileres")) {
                mensajes.add(" Bot: ¿Que deseas saber sobre el apartado Alquileres?"); // Agregamos un espacio al inicio del mensaje
            }
            actualizarMensajes();
        });
        pause.play();
    }













    private void actualizarMensajes() {
        StringBuilder sb = new StringBuilder();
        for (String mensaje : mensajes) {
            sb.append(mensaje).append("\n\n\n");
        }
        label.setText(sb.toString());
    }

    @javafx.fxml.FXML
    public void atrasChatBOTONclick(ActionEvent actionEvent) {
        // tu código aquí
    }

}
