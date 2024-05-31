package com.example.proyecto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlquileresController implements Initializable {
    @FXML
    private AnchorPane PanelAlquileres;
    @FXML
    private ChoiceBox zonaFiltroChoicebox;
    @FXML
    private ImageView PerfilBOTON;
    @FXML
    private Button perfilBOTON;
    @FXML
    private Button novedadesBOTON;
    @FXML
    private Button eventosBOTON;
    @FXML
    private Button addButton11;
    @FXML
    private Button alquileresBOTON;
    @FXML
    private Button librosBOTON;
    @FXML
    private ChoiceBox NumHabChoiceBox;
    @FXML
    private TextField PrecioMaxTF;
    @FXML
    private TextField PrecioMinTF;
    @FXML
    private GridPane cosasGripPane;
    @FXML
    private HBox panelHBox;
    @FXML
    private Button filtrarButton;

    private ArrayList<Alquileres> alquileresArrayList;
    @FXML
    private ScrollPane alquileresScollPane;

    /**
     * Método initialize que se llama al cargar la interfaz
     * @param location
     * @param resources
     */
    public void initialize(URL location, ResourceBundle resources) {
/*
        // Configuración del botón perfil con estilos y eventos de ratón
        perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        perfilBOTON.setOnMouseEntered(e -> perfilBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        perfilBOTON.setOnMouseExited(e -> perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        // Estilo del botón de alquileres
        alquileresBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);");
*/
        // Creación de listas observables para las opciones de filtro
        ObservableList<String> zonaAlquiler = FXCollections.observableArrayList();
        ObservableList<String> nHabitacionesAlquiler = FXCollections.observableArrayList();

        // Añadir opciones a la lista de número de habitaciones

        String n = "";
        String n1 = "1";
        String n2 = "2";
        String n3 = "3";
        String n4 = "4";
        String n5 = "5";

        nHabitacionesAlquiler.add(n);
        nHabitacionesAlquiler.add(n1);
        nHabitacionesAlquiler.add(n2);
        nHabitacionesAlquiler.add(n3);
        nHabitacionesAlquiler.add(n4);
        nHabitacionesAlquiler.add(n5);

        NumHabChoiceBox.setItems(nHabitacionesAlquiler);
        // Añadir opciones a la lista de zonas
        String zona = "";
        String zona1 = "Zona centro";
        String zona2 = "Cerca de playa";
        String zona3 = "Cerca de Universidades";
        String zona4 = "Afueras";
        String zona5 = "Cerca de Ocio";

        zonaAlquiler.add(zona);
        zonaAlquiler.add(zona1);
        zonaAlquiler.add(zona2);
        zonaAlquiler.add(zona3);
        zonaAlquiler.add(zona4);
        zonaAlquiler.add(zona5);

        zonaFiltroChoicebox.setItems(zonaAlquiler);


        ChoiceBox<String> nHabitacioneschoiceBox = new ChoiceBox<>();
        nHabitacioneschoiceBox.setItems(nHabitacionesAlquiler);

        // Configuración de los valores predeterminados de las ChoiceBox
        NumHabChoiceBox.setValue("Nº Hab");
        zonaFiltroChoicebox.setValue("Ubicación");
        nHabitacioneschoiceBox.setValue("Número Habitaciones");

        // Creación de un modelo de alquileres y obtención de la lista de alquileres
        AlquileresModel am = new AlquileresModel();
        alquileresArrayList = am.mostrarAlquileres();
        // Creación de objetos Alquileres y configuración de sus atributos
        for ( Alquileres alquileres : alquileresArrayList){

            String ubi = alquileres.getUbicacion();
            String nombre = alquileres.getNombre();
            int precio = alquileres.getPrecio();
            String m2 = alquileres.getMetrosCuadrados();
            Integer nh = alquileres.getnHabitaciones();
            String desc = alquileres.getDescripcion();
            Image image = alquileres.getImagen();

            Alquileres a = new Alquileres(ubi,nombre,precio,m2,nh,desc,image);

        }
        // Configuración del GridPane para mostrar los alquileres
        int column = 0;
        int row = 0;


        for (int i = 0; i < alquileresArrayList.size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("MostrarAlquileres.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                Usuario u = new Usuario();
                PerfilModel pm= new PerfilModel();
                u = pm.perfilModel(u.getCorreo(),u.getContra());


                MostrarAlquileres ma = fxmlLoader.getController();
                ma.setData(alquileresArrayList.get(i));

                if (column == 1) {
                    column = 0;
                    row++;
                }

                cosasGripPane.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                cosasGripPane.setMinWidth(Region.USE_COMPUTED_SIZE);
                cosasGripPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                cosasGripPane.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                // Configuración de las dimensiones del GridPane
                cosasGripPane.setMinHeight(Region.USE_COMPUTED_SIZE);
                cosasGripPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                cosasGripPane.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Métodos para manejar eventos de botón
     * @param actionEvent
     */
    @FXML
    public void perfilBOTONclick(ActionEvent actionEvent) {

        System.out.println("funciona");
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Perfil.fxml"));
            this.PanelAlquileres.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void librosBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Libros.fxml"));
            this.PanelAlquileres.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    public void alquileresBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Alquileres.fxml"));
            this.PanelAlquileres.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    public void novedadesBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.PanelAlquileres.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void eventosBOTONclick(ActionEvent actionEvent) {
        System.out.println("funciona");

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Eventos.fxml"));
            this.PanelAlquileres.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void onAddClicked(ActionEvent actionEvent) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("AnyadirAlquileres.fxml"));
            this.PanelAlquileres.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void actualizarVista(ArrayList<Alquileres> alquileresArrayList) {
        cosasGripPane.getChildren().clear(); // Limpiar el grid pane

        int column = 0;
        int row = 0;

        for (Alquileres alquiler : alquileresArrayList) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("MostrarAlquileres.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                MostrarAlquileres al = fxmlLoader.getController();
                al.setData(alquiler);

                if (column == 1) { // Ajustar columnas a la necesidad del programa
                    column = 0;
                    row++;
                }

                cosasGripPane.add(anchorPane, column++, row); // (child, column, row)
                cosasGripPane.setMinWidth(Region.USE_COMPUTED_SIZE);
                cosasGripPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                cosasGripPane.setMaxWidth(Region.USE_PREF_SIZE);
                cosasGripPane.setMinHeight(Region.USE_COMPUTED_SIZE);
                cosasGripPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                cosasGripPane.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void filtrarBottonClick(ActionEvent actionEvent) {
        System.out.println("Funciona");

        String nHabsFiltrar = String.valueOf(NumHabChoiceBox.getValue()).trim();
        String zonaFiltrar = String.valueOf(zonaFiltroChoicebox.getValue()).trim();
        String precioMinString = PrecioMinTF.getText().trim();
        String precioMaxString = PrecioMaxTF.getText().trim();

        Double minFiltrar = !precioMinString.isEmpty() ? Double.valueOf(precioMinString) : null;
        Double maxFiltrar = !precioMaxString.isEmpty() ? Double.valueOf(precioMaxString) : null;

        // Filtrar los alquileres
        ArrayList<Alquileres> alquileresFiltrados = new ArrayList<>();
        for (Alquileres alquiler : alquileresArrayList) {
            boolean matchesNHabs = nHabsFiltrar.isEmpty() || "Nº Hab".equalsIgnoreCase(nHabsFiltrar) || alquiler.getnHabitaciones() == Integer.parseInt(nHabsFiltrar);
            boolean matchesZona = zonaFiltrar.isEmpty() || "null".equalsIgnoreCase(zonaFiltrar) || alquiler.getUbicacion().equalsIgnoreCase(zonaFiltrar);
            boolean matchesMin = minFiltrar == null || minFiltrar <= 0 || alquiler.getPrecio() >= minFiltrar;
            boolean matchesMax = maxFiltrar == null || maxFiltrar <= 0 || alquiler.getPrecio() <= maxFiltrar;

            // Verificar si hay algún filtro activo, si no hay, agregar el alquiler directamente
            if (nHabsFiltrar.isEmpty() && zonaFiltrar.isEmpty() && minFiltrar == null && maxFiltrar == null) {
                alquileresFiltrados.add(alquiler);
            } else {
                // Verificar si se cumplen todas las condiciones de los filtros activos
                if (matchesNHabs && matchesZona && matchesMin && matchesMax) {
                    alquileresFiltrados.add(alquiler);
                }
            }
        }
        // Verificar la cantidad de elementos en la lista de alquileres filtrados
        System.out.println("Cantidad de alquileres filtrados: " + alquileresFiltrados.size());
        // Actualizar la vista con los alquileres filtrados
        actualizarVista(alquileresFiltrados);
    }



}
