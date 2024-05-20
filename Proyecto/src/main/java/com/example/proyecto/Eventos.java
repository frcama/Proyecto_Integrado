package com.example.proyecto;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Eventos  implements Initializable {


    FileChooser fileChooser = new FileChooser();

    @javafx.fxml.FXML
    private TextField link;
    @javafx.fxml.FXML
    private ImageView imagen;
    @javafx.fxml.FXML
    private Button addButton;
    @javafx.fxml.FXML
    private Button atrasEventosBOTON;
    @javafx.fxml.FXML
    private AnchorPane panelEventos;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // fileChooser.setInitialDirectory(new File("C:\\Users\\TSMR1\\Pictures"));
    }


    @javafx.fxml.FXML
    public void onAddClicked(ActionEvent actionEvent) {

        File file = fileChooser.showOpenDialog(new Stage());
    }


    @javafx.fxml.FXML
    public void atrasEventosBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.panelEventos.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
