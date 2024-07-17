module com.lavadero {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.lavadero to javafx.fxml;
    exports com.lavadero;
}
