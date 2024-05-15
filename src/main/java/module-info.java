module com.example.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jdi;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.proyecto to javafx.fxml;
    exports com.example.proyecto;
}