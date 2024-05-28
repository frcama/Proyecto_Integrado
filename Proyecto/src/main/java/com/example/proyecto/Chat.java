package com.example.proyecto;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @FXML
    private TextFlow textFlow;


    private ObservableList<String> mensajes = FXCollections.observableArrayList();
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/proyecto/Chat.fxml"));
    @javafx.fxml.FXML
    private ScrollPane panelCHAT;

    @FXML
    private void initialize() {
        // Configuración del tamaño de la fuente de la respuesta y negrita
        label.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-fill: blue");

        // Añadir mensaje de bienvenida del bot en azul
        mensajes.add("            ¡Hola! Soy EstuBot ¡Bienvenid@ al chat!");

        // Ajustar el padding del TextFlow
        textFlow.setPadding(new Insets(90, 0, 0, 0));

        // Actualizar mensajes para mostrar el mensaje de bienvenida
        actualizarMensajes();
    }


    @FXML
    public void EnviarBOTONclick(ActionEvent actionEvent) {
        String texto = MensajeTF.getText().toLowerCase(); // Convert user's input to lowercase
        mensajes.add(" Usuario: " + texto); // Agrega el mensaje del usuario a la lista de mensajes
        MensajeTF.clear();
        actualizarMensajes();

        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> {
            if (texto.contains("hola")) {
                mensajes.add(" Bot: ¡Hola!");
            }
            if (texto.contains("adios")) {
                mensajes.add(" Bot: ¡Hasta Luego!");
            }
            if (texto.contains("ubicacion de alquiler")) {
                mensajes.add(" Bot: Puedo ayudarte a encontrar alquileres. ¿Qué tipo de propiedad buscas?");
            }
            if (texto.contains("ubicacion de libros")) {
                mensajes.add(" Bot: Los libros que buscas pueden estar en la biblioteca o en una librería cercana.");
            }
            if (texto.contains("eventos")) {
                mensajes.add(" Bot: Hay varios eventos próximos. ¿Te interesan eventos culturales, deportivos o sociales?");
            }
            if (texto.contains("precios de libros")) {
                mensajes.add(" Bot: El precio de los libros varía. ¿Buscas algún libro en particular?");
            }
            if (texto.contains("alquileres")) {
                mensajes.add(" Bot: Tengo información sobre alquileres de viviendas, oficinas y locales comerciales. ¿Qué necesitas?");
            }
            if (texto.contains("libros")) {
                mensajes.add(" Bot: Puedo recomendarte libros basados en tus intereses. ¿Qué géneros prefieres?");
            }
            if (texto.contains("ubicacion de eventos")) {
                mensajes.add(" Bot: Los eventos suelen realizarse en centros de convenciones, estadios o parques. ¿Hay algún evento en particular que buscas?");
            }

            actualizarMensajes();
        });
        pause.play();
    }




    private void actualizarMensajes() {
        textFlow.getChildren().clear(); // Limpia los mensajes anteriores

        // Configura el TextFlow para que sea el único hijo del ScrollPane y se ajuste automáticamente
        panelCHAT.setContent(textFlow);
        textFlow.setMaxWidth(panelCHAT.getWidth() - 20); // Ajusta el ancho máximo para evitar el desbordamiento
        textFlow.setPadding(new Insets(5, 10, 5, 10)); // Añade un relleno para evitar que el texto toque los bordes

        for (String mensaje : mensajes) {
            Text text = new Text(mensaje + "\n"); // Crea el objeto Text con el mensaje y un salto de línea

            // Crea un HBox para contener el Text y aplicar el estilo de burbuja
            HBox messageBox = new HBox();
            messageBox.getChildren().add(text);
            messageBox.setAlignment(Pos.CENTER_LEFT); // Alinea los mensajes a la izquierda
            messageBox.setMinWidth(panelCHAT.getWidth() - 20); // Asegura que la caja de mensaje se extienda casi hasta el borde derecho
            messageBox.setMaxWidth(panelCHAT.getWidth() - 20); // Asegura que la caja de mensaje se extienda casi hasta el borde derecho
            messageBox.setPrefWidth(panelCHAT.getWidth() - 20); // Asegura que la caja de mensaje se extienda casi hasta el borde derecho

            // Ajusta el borde y el relleno
            messageBox.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color: black; -fx-border-width: 1; -fx-padding: 10;");

            // Aplica estilos diferentes para el usuario y el bot
            if (mensaje.startsWith(" Usuario: ")) {
                text.setStyle("-fx-fill: green; -fx-font-size: 15px; -fx-font-weight: bold;");
                messageBox.setStyle("-fx-background-color: lightgreen; -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color: black; -fx-border-width: 1; -fx-padding: 10;");

            } else if (mensaje.startsWith(" Bot: ")) {
                text.setStyle("-fx-fill: blue; -fx-font-size: 15px; -fx-font-weight: bold;");
                messageBox.setStyle("-fx-background-color: lightblue; -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color: black; -fx-border-width: 1; -fx-padding: 10;");
            }

            // Añade un margen entre mensajes
            VBox.setMargin(messageBox, new Insets(5, 0, 5, 0));

            // Añade el HBox al TextFlow
            textFlow.getChildren().add(messageBox);
        }
    }









    @javafx.fxml.FXML
    public void atrasChatBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.panelDelChat.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}