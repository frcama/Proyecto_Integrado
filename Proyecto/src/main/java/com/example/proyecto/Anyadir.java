package com.example.proyecto;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Anyadir
{
    @javafx.fxml.FXML
    private AnchorPane PanelAnyadir;
    @javafx.fxml.FXML
    private TextField descripcion;
    @javafx.fxml.FXML
    private Spinner precioSpinner;
    @javafx.fxml.FXML
    private TextField nombreDescripcion;
    @javafx.fxml.FXML
    private Button subirButton;
    @javafx.fxml.FXML
    private ImageView muestraImagenChoiceBox;
    @javafx.fxml.FXML
    private ChoiceBox categoriaChoiceBox;


    @javafx.fxml.FXML
    public void onSubirButtonClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void OnSubirImagenbutton(ActionEvent actionEvent) {
    }
}