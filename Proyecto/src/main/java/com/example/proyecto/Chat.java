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


    private ObservableList<String> mensajes = FXCollections.observableArrayList();
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/proyecto/Chat.fxml"));
    @javafx.fxml.FXML
    private ScrollPane panelCHAT;
    @FXML
    private TextFlow textFlow;

    @FXML
    private void initialize() {
        // Configuración del tamaño de la fuente de la respuesta y negrita
        label.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-fill: blue");

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
                mensajes.add(" Bot: ¡Hola! ¿En que puedo ayudarte?");
            }
            if (texto.contains("adios")) {
                mensajes.add(" Bot: ¡Hasta Luego!");
            }
            if (texto.contains("ubicacion de alquiler")) {
                mensajes.add(" Bot: Puedo ayudarte a encontrar alquileres. ¿Qué tipo de propiedad buscas?");

            } else if (texto.contains("ubicacion de libros")) {
                mensajes.add(" Bot: Los libros que buscas pueden estar en la biblioteca o en una librería cercana.");
            }
            else if (texto.contains("ubicacion de eventos")) {
                mensajes.add(" Bot:¿Hay algún evento en particular que buscas?");
            }
            if (texto.contains("eventos")) {
                mensajes.add(" Bot: Hay varios eventos próximos. ¿Te interesan eventos culturales, deportivos o sociales?");
            }
            if (texto.contains("precios de libros")) {
                mensajes.add(" Bot: El precio de los libros varía. ¿Buscas algún libro en particular?");
            } else if (texto.contains("precios de alquileres")) {
                mensajes.add(" Bot: Los precios de alquiler pueden variar según la ubicación y el tipo de propiedad. ¿En qué área estás interesado?");
            } else if (texto.contains("precios de libros")) {
                mensajes.add(" Bot: El costo de los libros depende del género y la novedad. ¿Hay algún título específico que te interese?");
            }
            if (texto.contains("alquileres")) {
                mensajes.add(" Bot: Tengo información sobre alquileres de viviendas, oficinas y locales comerciales. ¿Qué necesitas?");
            }
            if (texto.contains("libros")) {
                mensajes.add(" Bot: Puedo recomendarte libros basados en tus intereses. ¿Qué géneros prefieres?");
            }

            if (texto.contains("fecha de eventos")) {
                mensajes.add(" Bot: Puedo informarte sobre las fechas de los próximos eventos. ¿Qué tipo de evento buscas?");
            }
            if (texto.contains("habitaciones de alquiler")) {
                mensajes.add(" Bot: Tengo información sobre habitaciones disponibles para alquilar. ¿Prefieres una zona en particular?");
            }
            if (texto.contains("ayuda con el perfil")) {
                mensajes.add(" Bot: Puedo asistirte con la configuración de tu perfil. ¿Qué necesitas ajustar?");
            }
            if (texto.contains("cambiar contraseña")) {
                mensajes.add(" Bot: Cambiar tu contraseña regularmente mejora la seguridad. ¿Quieres que te guíe en el proceso?");
            }
            if (texto.contains("zonas de alquileres")) {
                mensajes.add(" Bot: Hay varias zonas populares para alquilar. ¿Buscas algo céntrico o más tranquilo?");
            }
            if (texto.contains("zonas de eventos")) {
                mensajes.add(" Bot: Los eventos se realizan en distintas zonas. ¿Tienes preferencia por alguna área en particular?");
            }
            if (texto.contains("tipos de eventos")) {
                mensajes.add(" Bot: Existen eventos culturales, deportivos, tecnológicos, entre otros. ¿Cuál es tu interés?");
            }
            if (texto.contains("tipos de libros")) {
                mensajes.add(" Bot: Hay libros de ficción, no ficción, educativos, etc. ¿Qué tipo de lectura prefieres?");
            }
            if (texto.contains("informacion sobre editoriales")) {
                mensajes.add(" Bot: Puedo proporcionarte datos de editoriales reconocidas. ¿Buscas alguna en especial?");
            }
            if (texto.contains("informacion sobre alquileres")) {
                mensajes.add(" Bot: ¿Necesitas consejos sobre contratos de alquiler o cómo encontrar una buena oferta?");
            }
            if (texto.contains("informacion sobre libros")) {
                mensajes.add(" Bot: Si necesitas recomendaciones o datos de libros, estoy aquí para ayudarte.");
            }
            if (texto.contains("informacion sobre eventos")) {
                mensajes.add(" Bot: Puedo darte detalles sobre eventos actuales o futuros. ¿Qué tipo de información necesitas?");
            }
            if (texto.contains("ubicacion de pisos")) {
                mensajes.add(" Bot: Puedo ayudarte a encontrar pisos. ¿Qué características buscas?");
            } else if (texto.contains("precios de pisos")) {
                mensajes.add(" Bot: Los precios de los pisos varían según la zona y las comodidades. ¿Tienes un presupuesto en mente?");
            } else if (texto.contains("pisos")) {
                mensajes.add(" Bot: Tengo información sobre pisos en alquiler y venta. ¿Qué estás buscando exactamente?");
            }

            // Contains para precios máximos y mínimos
            if (texto.contains("precio maximo de libros")) {
                mensajes.add(" Bot: ¿Cuál es el precio máximo que estás dispuesto a pagar por un libro?");
            } else if (texto.contains("precio minimo de libros")) {
                mensajes.add(" Bot: Tenemos opciones para todos los presupuestos. ¿Buscas algo en particular?");
            } else if (texto.contains("precio maximo de alquileres")) {
                mensajes.add(" Bot: ¿Cuál es tu límite de precio para un alquiler?");
            } else if (texto.contains("precio minimo de alquileres")) {
                mensajes.add(" Bot: Puedo mostrarte opciones de alquiler que se ajusten a tu presupuesto mínimo.");
            }

            if (texto.contains("ubicacion de viviendas")) {
                mensajes.add(" Bot: Puedo ayudarte a encontrar viviendas. ¿Qué requisitos tienes?");
            } else if (texto.contains("precios de viviendas")) {
                mensajes.add(" Bot: Los precios de las viviendas varían mucho. ¿Qué rango de precio estás considerando?");
            } else if (texto.contains("viviendas")) {
                mensajes.add(" Bot: Tengo información sobre viviendas en alquiler o venta. ¿Qué tipo de vivienda buscas?");
            }

            // Nuevos contains para 'comercios locales'
            if (texto.contains("ubicacion de comercios locales")) {
                mensajes.add(" Bot: Puedo mostrarte dónde encontrar comercios locales para alquilar. ¿Qué tipo de negocio tienes?");
            } else if (texto.contains("precios de comercios locales")) {
                mensajes.add(" Bot: Los precios de alquiler de comercios locales dependen de la ubicación y el tamaño. ¿Tienes alguna preferencia?");
            } else if (texto.contains("comercios locales")) {
                mensajes.add(" Bot: ¿Estás buscando alquilar un local comercial? Puedo ayudarte con eso.");
            }
            if (texto.contains("lugares para pasear universidades")) {
                mensajes.add(" Bot: Hay varios lugares agradables para pasear cerca de las universidades. ¿Estás buscando algún lugar en particular?");
            }

            // Contains para asignaturas de cada curso de la universidad y carreras
            if (texto.contains("asignaturas universidad")) {
                mensajes.add(" Bot: Puedo proporcionarte información sobre las asignaturas de diferentes cursos y carreras universitarias. ¿Qué carrera te interesa?");
            } else if (texto.contains("carreras universidad")) {
                mensajes.add(" Bot: Existen muchas carreras universitarias con distintas asignaturas. ¿Hay alguna carrera específica que quieras explorar?");
            }

            // Contains para libros de asignaturas de las carreras
            if (texto.contains("libros de asignaturas")) {
                mensajes.add(" Bot: Puedo recomendarte libros para las asignaturas de las carreras que mencionaste. ¿Para qué carrera y curso necesitas los libros?");
            }

            // Contains para cursos de las carreras
            if (texto.contains("cursos de la carrera")) {
                mensajes.add(" Bot: Las carreras universitarias suelen tener 4 o 5 cursos. ¿En qué curso estás interesado?");
            }
            if (texto.contains("libros de Matemáticas")) {
                mensajes.add(" Bot: Puedo recomendarte libros de Matemáticas. ¿Buscas libros de algún nivel educativo específico?");
            }

// Contains para libros de Física
            if (texto.contains("libros de Física")) {
                mensajes.add(" Bot: Tengo una lista de libros esenciales de Física. ¿Para qué curso los necesitas?");
            }

// Contains para libros de Química
            if (texto.contains("libros de Química")) {
                mensajes.add(" Bot: La Química es fascinante. ¿Qué tema de Química te interesa más?");
            }

// Contains para libros de Historia
            if (texto.contains("libros de Historia")) {
                mensajes.add(" Bot: La Historia está llena de aprendizajes. ¿Hay alguna época o evento histórico que te interese?");
            }

// Contains para libros de Literatura
            if (texto.contains("libros de Literatura")) {
                mensajes.add(" Bot: La Literatura puede ser muy inspiradora. ¿Estás buscando literatura clásica, moderna o de algún autor en particular?");
            }


            if (texto.contains("matemáticas")) {
                mensajes.add(" Bot: Puedo recomendarte libros de Matemáticas. ¿Buscas libros de algún nivel educativo específico?");
            }

// Contains para libros de Física
            if (texto.contains("física")) {
                mensajes.add(" Bot: Tengo una lista de libros esenciales de Física. ¿Para qué curso los necesitas?");
            }

// Contains para libros de Química
            if (texto.contains("química")) {
                mensajes.add(" Bot: La Química es fascinante. ¿Qué tema de Química te interesa más?");
            }

// Contains para libros de Historia
            if (texto.contains("historia")) {
                mensajes.add(" Bot: La Historia está llena de aprendizajes. ¿Hay alguna época o evento histórico que te interese?");
            }

// Contains para libros de Literatura
            if (texto.contains("literatura")) {
                mensajes.add(" Bot: La Literatura puede ser muy inspiradora. ¿Estás buscando literatura clásica, moderna o de algún autor en particular?");
            }

            // Contains para alquileres y viviendas en Valencia o solo la ciudad
            if (texto.contains("alquileres en Valencia") || texto.contains("viviendas en Valencia") || texto.contains("Valencia")) {
                mensajes.add(" Bot: Puedo ayudarte con información sobre alquileres, viviendas o cualquier otra consulta sobre Valencia. ¿Qué necesitas saber?");
            }

// Contains para alquileres y viviendas en Barcelona o solo la ciudad
            if (texto.contains("alquileres en Barcelona") || texto.contains("viviendas en Barcelona") || texto.contains("Barcelona")) {
                mensajes.add(" Bot: Ya sea alquileres, viviendas o detalles generales, puedo proporcionarte información sobre Barcelona. ¿Cuál es tu consulta?");
            }

// Contains para alquileres y viviendas en Madrid o solo la ciudad
            if (texto.contains("alquileres en Madrid") || texto.contains("viviendas en Madrid") || texto.contains("Madrid")) {
                mensajes.add(" Bot: Estoy aquí para ayudarte con temas de alquileres, viviendas o cualquier pregunta sobre Madrid. ¿Qué estás buscando?");
            }

// Contains para alquileres y viviendas en Sevilla o solo la ciudad
            if (texto.contains("alquileres en Sevilla") || texto.contains("viviendas en Sevilla") || texto.contains("Sevilla")) {
                mensajes.add(" Bot: Puedo asistirte con información sobre alquileres, viviendas o cualquier otro tema relacionado con Sevilla. ¿En qué puedo ayudarte?");
            }




// Contains para cuando no se entiende el mensaje
            if (!texto.contains("hola") && !texto.contains("adios") && !texto.contains("ubicacion") &&
                    !texto.contains("eventos") && !texto.contains("precios") && !texto.contains("alquileres") &&
                    !texto.contains("libros") && !texto.contains("fecha") && !texto.contains("habitaciones") &&
                    !texto.contains("ayuda") && !texto.contains("cambiar") && !texto.contains("zonas") &&
                    !texto.contains("tipos") && !texto.contains("informacion") &&
                    !texto.contains("ubicacion de viviendas") && !texto.contains("precios de viviendas") &&
                    !texto.contains("viviendas") && !texto.contains("ubicacion de comercios locales") &&
                    !texto.contains("precios de comercios locales") && !texto.contains("comercios locales") &&
                    !texto.contains("lugares para pasear universidades") && !texto.contains("asignaturas universidad") &&
                    !texto.contains("carreras universidad") && !texto.contains("libro de asignaturas") &&
                    !texto.contains("cursos de la carrera") && !texto.contains("libro de Matemáticas") &&
                    !texto.contains("libro de Física") && !texto.contains("libro de Química") &&
                    !texto.contains("libro de Historia") && !texto.contains("libro de Literatura") &&
                    !texto.contains("Matemáticas") && !texto.contains("Física") &&
                    !texto.contains("Química") && !texto.contains("Historia") &&
                    !texto.contains("literatura") && !texto.contains("valencia") && !texto.contains("barcelona")
                    && !texto.contains("madrid") && !texto.contains("sevilla")) {
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
