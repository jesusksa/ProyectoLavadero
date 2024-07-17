module com.lavadero {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens com.lavadero to javafx.fxml, lombok;
    exports com.lavadero;
}
