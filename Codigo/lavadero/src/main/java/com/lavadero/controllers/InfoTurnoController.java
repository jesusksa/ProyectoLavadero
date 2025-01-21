package com.lavadero.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;

import java.io.IOException;

public class InfoTurnoController {
    public MenuButton mbtnCuenta;

    @FXML
    public void initialize() {
        // Listener para detectar cuando el menú se despliega
        mbtnCuenta.showingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                mbtnCuenta.getStyleClass().add("pressed");
            } else {
                mbtnCuenta.getStyleClass().remove("pressed");
            }
        });
    }

    public void anteriorPag(ActionEvent actionEvent) {
    }

    public void home(ActionEvent actionEvent) {
    }

    public void siguientePag(ActionEvent actionEvent) {
    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("¿Seguro que desea abandonar la sesion iniciada?");
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK){
            //conectar para cerrar Sesion

        }else {
            alert.close();
        }
    }

    public void notificarRetiro(ActionEvent actionEvent) {
    }

    public void cambiarEstado(ActionEvent actionEvent) {
    }
}
