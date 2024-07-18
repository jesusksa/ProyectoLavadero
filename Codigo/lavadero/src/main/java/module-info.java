module com.lavadero {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires org.hibernate.orm.core;

    opens com.lavadero to javafx.fxml, lombok;
    exports com.lavadero;
    exports com.lavadero.model;
    opens com.lavadero.model to javafx.fxml, lombok;
    exports com.lavadero.controllers;
    opens com.lavadero.controllers to javafx.fxml, lombok;
}
