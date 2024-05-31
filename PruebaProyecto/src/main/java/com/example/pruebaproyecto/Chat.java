package com.example.pruebaproyecto;

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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Chat
{
    @FXML
    private Label label;
    @FXML
    private Button EnviarBOTON;
    @FXML
    private TextField MensajeTF;
    @FXML
    private AnchorPane panelDelChat;
    @FXML
    private Button atrasChatBOTON;


    private ObservableList<String> mensajes = FXCollections.observableArrayList();
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/proyecto/Chat.fxml"));
    @FXML
    private ScrollPane panelCHAT;
    @FXML
    private TextFlow textFlow;

    @FXML
    private void initialize() {
        // Configuración del tamaño de la fuente de la respuesta y negrita
        label.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-fill: blue");

        // Añadir mensaje de bienvenida del bot en azul
        mensajes.add("¡Hola! Soy EstuBot ¡Bienvenid@ al chat!\n\n¿Que tipo de información necessitas?\n\nAlquileres // libros // Eventos");


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
            if (texto.contains("alquileres en valencia")) {
                mensajes.add(" Bot: Puedo ayudarte con información sobre alquileres en Valencia. ¿Qué necesitas saber?");
            } else if (texto.contains("alquileres en barcelona")) {
                mensajes.add(" Bot: Ya sea alquileres, viviendas o detalles generales, puedo proporcionarte información sobre Barcelona. ¿Cuál es tu consulta?");
            } else if (texto.contains("alquileres en madrid")) {
                mensajes.add(" Bot: Estoy aquí para ayudarte con temas de alquileres, viviendas o cualquier pregunta sobre Madrid. ¿Qué estás buscando?");
            } else if (texto.contains("alquileres en sevilla")) {
                mensajes.add(" Bot: Puedo asistirte con información sobre alquileres, viviendas o cualquier otro tema relacionado con Sevilla. ¿En qué puedo ayudarte?");
            } else if (texto.contains("alquileres")) {
                mensajes.add(" Bot: ¿De qué tipo quieres la consulta? Precios // Ubicaciones // Otro");

                // Subcondiciones para 'alquileres'
                if (texto.contains("precios")) {
                    mensajes.add(" Bot: ¿Qué rango de precios te interesa? De 100 a 300 // De 300 a 500 // De 500 a 800 // De 800 a máximo");

                    // Subcondiciones para 'precios'
                    if (texto.contains("de 100 a 300")) {
                        mensajes.add(" Bot: Aquí tienes algunas opciones de alquileres entre 100 y 300.");
                    } else if (texto.contains("de 300 a 500")) {
                        mensajes.add(" Bot: Aquí tienes algunas opciones de alquileres entre 300 y 500.");
                    } else if (texto.contains("de 500 a 800")) {
                        mensajes.add(" Bot: Aquí tienes algunas opciones de alquileres entre 500 y 800.");
                    } else if (texto.contains("de 800 a max")) {
                        mensajes.add(" Bot: Aquí tienes algunas opciones de alquileres de 800 a máximo.");
                    }
                } else if (texto.contains("ubicaciones")) {
                    mensajes.add(" Bot: Disponemos de las siguientes ubicaciones: Zona Centro, Cerca de playa, Cerca de Universidades, Afueras de la Ciudad, Cerca de zona de Ocio");
                } else if (texto.contains("otro")) {
                    mensajes.add(" Bot: Por favor, especifica más sobre lo que necesitas saber.");
                }
            } else if (texto.contains("libros de matemáticas")) {
                mensajes.add(" Bot: Puedo recomendarte libros de Matemáticas. ¿Buscas libros de algún nivel educativo específico?");
            } else if (texto.contains("libros de física")) {
                mensajes.add(" Bot: Tengo una lista de libros esenciales de Física. ¿Para qué curso los necesitas?");
            } else if (texto.contains("libros de química")) {
                mensajes.add(" Bot: La Química es fascinante. ¿Qué tema de Química te interesa más?");
            } else if (texto.contains("libros de historia")) {
                mensajes.add(" Bot: La Historia está llena de aprendizajes. ¿Hay alguna época o evento histórico que te interese?");
            } else if (texto.contains("libros de literatura")) {
                mensajes.add(" Bot: La Literatura puede ser muy inspiradora. ¿Estás buscando literatura clásica, moderna o de algún autor en particular?");
            } else if (texto.contains("libros")) {
                mensajes.add(" Bot: Puedo recomendarte libros. ¿Qué géneros prefieres?");
                if (texto.contains("precios")) {
                    mensajes.add(" Bot: El precio de los libros varía. ¿Buscas algún libro en particular?");
                }
            } else if (texto.contains("eventos")) {
                mensajes.add(" Bot: Hay varios eventos próximos. ¿Te interesan eventos culturales, deportivos o sociales?");
            } else if (texto.contains("hola")) {
                mensajes.add(" Bot: ¡Hola! ¿En qué puedo ayudarte?");
            } else if (texto.contains("adios")) {
                mensajes.add(" Bot: ¡Hasta Luego!");
            } else {
                mensajes.add(" Bot: No he entendido tu mensaje. ¿Puedes proporcionar más detalles o reformular tu pregunta?");
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
            Text text2 = new Text(mensaje + "\n");
            text.setWrappingWidth(panelCHAT.getWidth() - 40);
            // Crea un HBox para contener el Text y aplicar el estilo de burbuja
            HBox messageBox = new HBox();
            messageBox.getChildren().add(text);
            messageBox.setAlignment(Pos.CENTER_LEFT); // Alinea los mensajes a la izquierda
            messageBox.setMinWidth(panelCHAT.getWidth() - 15); // Asegura que la caja de mensaje se extienda casi hasta el borde derecho
            messageBox.setMaxWidth(panelCHAT.getWidth() - 15); // Asegura que la caja de mensaje se extienda casi hasta el borde derecho
            messageBox.setPrefWidth(panelCHAT.getWidth() - 15); // Asegura que la caja de mensaje se extienda casi hasta el borde derecho



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
            VBox.setMargin(messageBox, new Insets(5,0, 5,0));
            // Añade el HBox al TextFlow
            textFlow.getChildren().add(messageBox);
        }
    }
@FXML
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