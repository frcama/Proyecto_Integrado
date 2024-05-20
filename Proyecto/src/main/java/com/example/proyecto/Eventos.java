package com.example.proyecto;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Eventos  implements Initializable {


    FileChooser fileChooser = new FileChooser();

    @javafx.fxml.FXML
    private TextField link;
    @javafx.fxml.FXML
    private ImageView imagen;
    @javafx.fxml.FXML
    private Button addButton;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // fileChooser.setInitialDirectory(new File("C:\\Users\\TSMR1\\Pictures"));
    }


    @javafx.fxml.FXML
    public void onAddClicked(ActionEvent actionEvent) {

        File file = fileChooser.showOpenDialog(new Stage());
    }


}
