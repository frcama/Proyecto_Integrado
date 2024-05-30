package com.example.proyecto;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
// Clase MostrarAlquileres extiende de Conexion, permite mostrar la información de un alquiler específico
public class MostrarAlquileres extends Conexion{
    // Definición de los componentes de la interfaz gráfica
    @javafx.fxml.FXML
    private Label nombreAlquilerLabel;
    @javafx.fxml.FXML
    private Label nHabsAlquilerLabel;
    @javafx.fxml.FXML
    private Label precioAlquilerLabel;
    @javafx.fxml.FXML
    private ImageView imagenalquilerImageView;
    @javafx.fxml.FXML
    private Label metrosAlquilerLabel;
    @javafx.fxml.FXML
    private Label ubiAlquilerLabel;
    @javafx.fxml.FXML
    private AnchorPane panelMostrarAlquiler;
    @javafx.fxml.FXML
    private Label descripcionAlquilerLabel;
    // Instancia de Alquileres
    Alquileres alquiler = new Alquileres();
    @javafx.fxml.FXML
    private Label ciudadAlquiler;
    // Método para establecer los datos del alquiler en los componentes de la interfaz gráfica
    public void setData(Alquileres alquiler) {
        // Asignar el objeto Alquiler recibido a la instancia local
        this.alquiler = alquiler;
        // Crear una instancia de PerfilModel y Usuario
        PerfilModel pm= new PerfilModel();
        Usuario u = new Usuario();
        // Obtener el perfil del usuario
        u = pm.perfilModel(u.getCorreo(),u.getContra());
        // Establecer los datos del alquiler en los labels correspondientes
        nombreAlquilerLabel.setText(alquiler.getNombre());
        precioAlquilerLabel.setText(String.valueOf(alquiler.getPrecio()+"€"));

        metrosAlquilerLabel.setText(alquiler.getMetrosCuadrados() + " metros cuadrados");
        ubiAlquilerLabel.setText(alquiler.getUbicacion());
        descripcionAlquilerLabel.setText(alquiler.getDescripcion());
        nHabsAlquilerLabel.setText(String.valueOf(alquiler.getnHabitaciones() + " núm Habitaciones"));
        ciudadAlquiler.setText(alquiler.getCiudad());


        // Establecer la imagen del alquiler en el ImageView si está disponible
        if (alquiler.getImagen() != null) {
            imagenalquilerImageView.setImage(alquiler.getImagen());
        }
    }
}

