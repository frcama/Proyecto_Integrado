module com.example.eventos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.eventos to javafx.fxml;
    exports com.example.eventos;
}