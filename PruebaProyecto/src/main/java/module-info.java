module com.example.pruebaproyecto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pruebaproyecto to javafx.fxml;
    exports com.example.pruebaproyecto;
}