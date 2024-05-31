package com.example.proyecto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase AnyadirEventos que implementa Initializable para inicializar la interfaz gráfica al cargar
 */
public class AnyadirEventos  implements Initializable {

    // Definición de elementos de la interfaz gráfica mediante anotaciones FXML
    @javafx.fxml.FXML
    private Button subirButton;
    @javafx.fxml.FXML
    private ImageView muestraImagen;
    @javafx.fxml.FXML
    private Button atrasButton;
    @javafx.fxml.FXML
    private DatePicker fechaEventos;
    @javafx.fxml.FXML
    private TextField descripcionEventos;
    @javafx.fxml.FXML
    private TextField nombreEventos;
    @javafx.fxml.FXML
    private Spinner precioEventos;
    @javafx.fxml.FXML
    private AnchorPane PanelAnyadirEVENTOS;
    @javafx.fxml.FXML
    private TextField ubicacionEventos;
    @javafx.fxml.FXML
    private ChoiceBox tipoEventoChoiceBox;


    Usuario usuario = new Usuario();


    /**
     * Método que se ejecuta al inicializar la interfaz gráfica
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        recuperarDatos();
        // Configuración del Spinner para seleccionar el precio del evento
        SpinnerValueFactory<Integer> valueFactoryInteger =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10000000,0,1);

        precioEventos.setValueFactory(valueFactoryInteger);


        /**
         * Creación de una lista observable para los tipos de eventos
         */
        ObservableList<String> tipoEvento = FXCollections.observableArrayList();

        // Adición de tipos de eventos a la lista
        String t1 = "Festival";
        String t2 = "Charla";
        String t3 = "Paellas Universitarias";
        String t4 = "Monologos";
        String t5 = "Congresos";


        tipoEvento.add(t1);
        tipoEvento.add(t2);
        tipoEvento.add(t3);
        tipoEvento.add(t4);
        tipoEvento.add(t5);
        // Configuración del ChoiceBox con los tipos de eventos
        tipoEventoChoiceBox.setItems(tipoEvento);
        tipoEventoChoiceBox.setValue("TipoEvento");

    }

    /**
     * Método que se ejecuta al hacer clic en el botón "Subir"
     * @param actionEvent
     */
    @javafx.fxml.FXML
    public void onSubirButtonClick(ActionEvent actionEvent) {

        // Crear una instancia del modelo AnyadirEventosModel
        AnyadirEventosModel aem = new AnyadirEventosModel();
        // Obtener la imagen seleccionada y su ruta
        Image imagenSeleccionada = muestraImagen.getImage();
        String imageUrl = imagenSeleccionada.getUrl().replace("file:", "");
        File imagen = new File(imageUrl);

        // Obtener los datos ingresados en los campos de la interfaz
        String tipo = String.valueOf(tipoEventoChoiceBox.getValue());
        String nombre= nombreEventos.getText();
        String descripcion = descripcionEventos.getText();
        String ubi = ubicacionEventos.getText();
        Date fechaEvento = Date.valueOf(fechaEventos.getValue());
        Date d = Date.valueOf(LocalDate.now());
        String p = String.valueOf(precioEventos.getValue());
        int precio =Integer.valueOf(p);
        int id_usuario= usuario.getId_usuario();

        // Crear una instancia del evento con los datos ingresados
        Eventos e = new Eventos(nombre,fechaEvento,ubi,d,imagenSeleccionada,imagen,descripcion,precio,tipo,id_usuario);
        // Llamar al método para añadir el evento
        aem.AnyadirAlquiler(e);
    }
    private void recuperarDatos(){

        UsuarioHolder us = UsuarioHolder.getInstance();
        usuario = us.getUsuario();
    }

    /**
     * Método que se ejecuta al hacer clic en el botón "Atrás"
     * @param actionEvent
     */
    @javafx.fxml.FXML
    public void onAtrasButtonClick(ActionEvent actionEvent) {
        try {
            // Cargar el nuevo panel (Eventos.fxml) y reemplazar el actual
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Eventos.fxml"));
            this.PanelAnyadirEVENTOS.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que se ejecuta al hacer clic en el botón "Subir Imagen"
     * @param actionEvent
     */
    @javafx.fxml.FXML
    public void OnSubirImagenbutton(ActionEvent actionEvent) {
        // Crear un selector de archivos
        FileChooser fileChooser = new FileChooser();

        // Configurar los filtros de extensión antes de mostrar el diálogo
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        // Mostrar el diálogo para seleccionar un archivo de imagen
        File file = fileChooser.showOpenDialog(new Stage());
        // Si se selecciona un archivo, mostrar la imagen en el ImageView de la interfaz
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            muestraImagen.setImage(image);
        }
    }


}
