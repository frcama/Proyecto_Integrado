package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.cert.PolicyNode;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnyadirLibros implements Initializable {
    @FXML
    private Spinner precioSpinner;
    @FXML
    private Button subirButton;
    @FXML
    private ImageView muestraImagen;
    @FXML
    private Button atrasBOTON;
    @FXML
    private TextField editorialTextField;
    @FXML
    private TextField cursoTextField;
    @FXML
    private AnchorPane PanelAnyadirLIBROS;
    @FXML
    private TextField tituloTextField;
    @FXML
    private TextField isbnTextField;
    @FXML
    private TextField asignaturaTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpinnerValueFactory<Integer> valueFactoryInteger =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10000000,0,1);

        precioSpinner.setValueFactory(valueFactoryInteger);

    }

    @FXML
    public void atrasBOTONclick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Libros.fxml"));
            this.PanelAnyadirLIBROS.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    public void onSubirButtonClick(ActionEvent actionEvent) {

        AnyadirLibrosModel al = new AnyadirLibrosModel();


        Image imagenSeleccionada = muestraImagen.getImage();
        String imageUrl = imagenSeleccionada.getUrl().replace("file:", "");
        File imagen = new File(imageUrl);

        String titulo= tituloTextField.getText();
        String editorial = editorialTextField.getText();
        String isbn = isbnTextField.getText();
        String curso = cursoTextField.getText();
        double precio = (Integer) precioSpinner.getValue();
        String asignatura = asignaturaTextField.getText();
        Date d = Date.valueOf(LocalDate.now());

        Libros l = new Libros(titulo, isbn, editorial, precio, asignatura, curso, imagen, d);

        al.AnyadirLibros(l);



    }

    @FXML
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
