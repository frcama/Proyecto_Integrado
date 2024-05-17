package com.example.proyecto;

import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

public class Eventos {
    @javafx.fxml.FXML
    private ImageView imagen;
    @javafx.fxml.FXML
    private TextArea textarea;




    public void uploadImage() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imagen.setImage(image);
        }
    }
}
