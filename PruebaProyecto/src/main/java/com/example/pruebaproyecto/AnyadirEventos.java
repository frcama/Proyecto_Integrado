package com.example.pruebaproyecto;

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

public class AnyadirEventos  implements Initializable {
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        SpinnerValueFactory<Integer> valueFactoryInteger =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10000000,0,1);

        precioEventos.setValueFactory(valueFactoryInteger);



        ObservableList<String> tipoEvento = FXCollections.observableArrayList();


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

        tipoEventoChoiceBox.setItems(tipoEvento);
        tipoEventoChoiceBox.setValue("TipoEvento");

    }
    @javafx.fxml.FXML
    public void onSubirButtonClick(ActionEvent actionEvent) {


        AnyadirEventosModel aem = new AnyadirEventosModel();
        Image imagenSeleccionada = muestraImagen.getImage();
        String imageUrl = imagenSeleccionada.getUrl().replace("file:", "");
        File imagen = new File(imageUrl);


        String tipo = String.valueOf(tipoEventoChoiceBox.getValue());
        String nombre= nombreEventos.getText();
        String descripcion = descripcionEventos.getText();
        String ubi = ubicacionEventos.getText();
        Date fechaEvento = Date.valueOf(fechaEventos.getValue());
        Date d = Date.valueOf(LocalDate.now());
        String p = String.valueOf(precioEventos.getValue());
        double precio = Double.valueOf(p);


        Eventos e = new Eventos(nombre,fechaEvento,ubi,d,imagenSeleccionada,imagen,descripcion,precio,tipo);

        aem.AnyadirAlquiler(e);
    }

    @javafx.fxml.FXML
    public void onAtrasButtonClick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Eventos.fxml"));
            this.PanelAnyadirEVENTOS.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void OnSubirImagenbutton(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        // Configurar los filtros de extensión antes de mostrar el diálogo
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

        File file = fileChooser.showOpenDialog(new Stage());

        if (file != null) {
            Image image = new Image(file.toURI().toString());
            muestraImagen.setImage(image);
        }
    }


}
