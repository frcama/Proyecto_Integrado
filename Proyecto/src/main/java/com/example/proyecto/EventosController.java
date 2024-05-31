package com.example.proyecto;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;

/**
 * Controlador para la vista de eventos
 */
public class EventosController implements Initializable {

    /**
     * Componentes de la vista
     */
    FileChooser fileChooser = new FileChooser();

    @javafx.fxml.FXML
    private AnchorPane PanelEventos;
    @javafx.fxml.FXML
    private ImageView PerfilBOTON;
    @javafx.fxml.FXML
    private ImageView novedadesBOTON;
    @javafx.fxml.FXML
    private Button filtrarButton;
    @javafx.fxml.FXML
    private Button perfilBOTON;
    @javafx.fxml.FXML
    private Button novedadesBOTON1;
    @javafx.fxml.FXML
    private Button eventosBOTON;
    @javafx.fxml.FXML
    private Button addButton;
    @javafx.fxml.FXML
    private Button alquileresBOTON;
    @javafx.fxml.FXML
    private Button librosBOTON;
    @javafx.fxml.FXML
    private ChoiceBox<String> TipoFiltroChoicebox;
    @javafx.fxml.FXML
    private TextField maxPreciofiltroEvento;
    @javafx.fxml.FXML
    private ScrollPane eventosScollPane;
    @javafx.fxml.FXML
    private HBox panelHBoxEventos;
    @javafx.fxml.FXML
    private GridPane cosasGripPaneEvento;
    // Lista de eventos
    ArrayList<Eventos> eventosArrayList = new ArrayList<>();
    @javafx.fxml.FXML
    private DatePicker fechafiltroDatePicker;

    /**
     * Método de inicialización del controlador
     * @param location
     * @param resources
     */
    public void initialize(URL location, ResourceBundle resources) {
        /*
        perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';");
        perfilBOTON.setOnMouseEntered(e -> perfilBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000); -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));
        perfilBOTON.setOnMouseExited(e -> perfilBOTON.setStyle("-fx-background-color:  F2F2F2; -fx-shape: 'M70,50 m-70,0 a70,70 0 1,0 140,0 a70,70 0 1,0 -140,0';"));

        eventosBOTON.setStyle("-fx-background-color: linear-gradient(to right, #ffff00, #ff0000);");
*/
        // Configuración inicial de la vista y carga de datos
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

        TipoFiltroChoicebox.setItems(tipoEvento);
        TipoFiltroChoicebox.setValue("TipoEvento");
        maxPreciofiltroEvento.setText("Precio Max");

        EventosModel em = new EventosModel();
        eventosArrayList = em.mostrarEventos();
        /**
         * Iteración sobre la lista de eventos para mostrarlos en la vista
         */
        for ( Eventos eventos : eventosArrayList) {

            String ubi = eventos.getUbicacion();
            String nombre = eventos.getNombre();
            Double precio = eventos.getPrecio();
            String desc = eventos.getDescripcion();
            Date fecha = eventos.getFechaEvento();
            Image image = eventos.getImagen();
            String tipo = eventos.getTipo();

            Eventos ev = new Eventos(nombre, fecha, ubi, desc, precio, tipo,image);

        }

        /**
         * Configuración de la disposición de los eventos en la vista
         */
        int column = 0;
        int row = 0;


        for (int i = 0; i < eventosArrayList.size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("MostrarEventos.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();


                Usuario u = new Usuario();
                PerfilModel pm= new PerfilModel();
                u = pm.perfilModel(u.getCorreo(),u.getContra());

                MostrarEventos me = fxmlLoader.getController();
                me.setData(eventosArrayList.get(i));

                if (column == 1) {
                    column = 0;
                    row++;
                }

                cosasGripPaneEvento.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                cosasGripPaneEvento.setMinWidth(Region.USE_COMPUTED_SIZE);
                cosasGripPaneEvento.setPrefWidth(Region.USE_COMPUTED_SIZE);
                cosasGripPaneEvento.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                cosasGripPaneEvento.setMinHeight(Region.USE_COMPUTED_SIZE);
                cosasGripPaneEvento.setPrefHeight(Region.USE_COMPUTED_SIZE);
                cosasGripPaneEvento.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void actualizarVista(ArrayList<Eventos> eventosFiltrados) {

        cosasGripPaneEvento.getChildren().clear(); // Limpiar el grid pane

        int column = 0;
        int row = 0;

        for (Eventos eventos : eventosFiltrados) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("MostrarEventos.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                MostrarEventos me = fxmlLoader.getController();
                me.setData(eventos);

                if (column == 1) { // Ajustar columnas a la necesidad del programa
                    column = 0;
                    row++;
                }

                cosasGripPaneEvento.add(anchorPane, column++, row); // (child, column, row)
                cosasGripPaneEvento.setMinWidth(Region.USE_COMPUTED_SIZE);
                cosasGripPaneEvento.setPrefWidth(Region.USE_COMPUTED_SIZE);
                cosasGripPaneEvento.setMaxWidth(Region.USE_PREF_SIZE);
                cosasGripPaneEvento.setMinHeight(Region.USE_COMPUTED_SIZE);
                cosasGripPaneEvento.setPrefHeight(Region.USE_COMPUTED_SIZE);
                cosasGripPaneEvento.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @javafx.fxml.FXML
    public void onAddClicked(ActionEvent actionEvent) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("AnyadirEventos.fxml"));
            this.PanelEventos.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void perfilBOTONclick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Perfil.fxml"));
            this.PanelEventos.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @javafx.fxml.FXML
    public void librosBOTONclick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Libros.fxml"));
            this.PanelEventos.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void alquileresBOTONclick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Alquileres.fxml"));
            this.PanelEventos.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void novedadesBOTONclick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Novedades.fxml"));
            this.PanelEventos.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void eventosBOTONclick(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Eventos.fxml"));
            this.PanelEventos.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void filtrarBottonClick(ActionEvent actionEvent) {
        System.out.println("Funciona");

        // Obtener los valores de los filtros seleccionados
        double precioMaximo;
        try {
            precioMaximo = Double.parseDouble(maxPreciofiltroEvento.getText());
        } catch (NumberFormatException e) {
            precioMaximo = Double.MAX_VALUE; // Establecer un valor alto si el campo está vacío o no es un número válido
        }

        LocalDate fechaEvento = fechafiltroDatePicker.getValue();
        String tipoEvento = TipoFiltroChoicebox.getValue();

        ArrayList<Eventos> eventosFiltrados = new ArrayList<>();

        for (Eventos evento : eventosArrayList) {
            boolean matchesTipo = tipoEvento == null || tipoEvento.isEmpty() || "Tipo Evento".equalsIgnoreCase(tipoEvento) || evento.getTipo().equalsIgnoreCase(tipoEvento);
            boolean matchesPrecio = precioMaximo <= 0 || evento.getPrecio() <= precioMaximo;
            boolean matchesFecha = fechaEvento == null || evento.getFechaEvento().toLocalDate().isEqual(fechaEvento);

            // Aplicar filtros según las combinaciones de variables
            if (matchesTipo && matchesPrecio && matchesFecha) {
                eventosFiltrados.add(evento);
            }
        }

        /**
         * Actualizar la vista con los eventos filtrados
         */
        if (eventosFiltrados.isEmpty()) {
            actualizarVista(eventosArrayList); // Mostrar todos los eventos si no hay filtros aplicados
        } else {
            actualizarVista(eventosFiltrados); // Mostrar eventos filtrados si hay resultados
        }
    }


}
