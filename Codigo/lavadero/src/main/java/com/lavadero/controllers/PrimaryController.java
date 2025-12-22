package com.lavadero.controllers;

import com.lavadero.App;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;

import java.io.IOException;

@Getter
public class PrimaryController {
    public AnchorPane pnFondo;
    public MenuButton mbtnCuenta;
    public AnchorPane apnContenido;

    private static PrimaryController instance;
    public static PrimaryController getInstance() {
        return instance;
    }



    public void initialize() throws IOException {
        instance = this;
        mbtnCuenta.showingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                mbtnCuenta.getStyleClass().add("pressed");
            } else {
                mbtnCuenta.getStyleClass().remove("pressed");
            }
        });

        Parent view = App.loadFXML("turnos");

        cargarContenido(view);

    }

    public void cerrarSesion(ActionEvent actionEvent) {
    }

    public void anteriorPag(ActionEvent actionEvent) {
    }

    public void home(ActionEvent actionEvent) {
    }

    public void siguientePag(ActionEvent actionEvent) {
    }

    public void cargarContenido(Parent p){
        apnContenido.getChildren().clear();
        apnContenido.getChildren().setAll(p);
        AnchorPane.setTopAnchor(p, 0.0);
        AnchorPane.setBottomAnchor(p, 0.0);
        AnchorPane.setLeftAnchor(p, 0.0);
        AnchorPane.setRightAnchor(p, 0.0);
    }
}
