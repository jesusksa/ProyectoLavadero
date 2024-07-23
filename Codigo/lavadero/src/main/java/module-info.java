module com.lavadero {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;

    opens com.lavadero to javafx.fxml, lombok;
    exports com.lavadero;
    exports com.lavadero.model;
    opens com.lavadero.model to javafx.fxml, lombok, org.hibernate.orm.core;
    exports com.lavadero.controllers;
    opens com.lavadero.controllers to javafx.fxml, lombok;
}
