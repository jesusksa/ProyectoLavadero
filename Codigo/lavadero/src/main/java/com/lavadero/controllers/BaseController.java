package com.lavadero.controllers;

import com.lavadero.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Optional;

import static com.lavadero.App.loadFXML;

public class BaseController {
    public MenuButton mbtnCuenta;
    public ScrollPane scllTurnos;
    private int currentRow = 0; // Para rastrear la fila actual en el GridPane
    private int currentColumn = 0; // Para rastrear la columna actual en la fila

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

    public static void cerrarSesion(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cerrar sesión");
        alert.setHeaderText("¿Seguro que desea abandonar la sesion iniciada?");
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK){
            Scene scene = new Scene(loadFXML("inicio-sesion"));
            App.getMainStage().setScene(scene);
        }else {
            alert.close();
        }
    }
}
