package com.lavadero.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import static com.lavadero.App.loadFXML;

public class InfoTurnoController {
    public MenuButton mbtnCuenta;
    private static Stage stageEstado;
    @FXML
    private Button btnPrev;
    @FXML
    private Button btnNext;

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

        BaseController.setEscenaActual("info-turnos");
        BaseController.controlarVisibilidad(btnPrev, btnNext);
    }

    public void anteriorPag(ActionEvent actionEvent) throws IOException {
        BaseController.anteriorPag(actionEvent);
    }

    public void home(ActionEvent actionEvent) throws IOException {
        BaseController.home(actionEvent);
    }

    public void siguientePag(ActionEvent actionEvent) throws IOException {
        BaseController.siguientePag(actionEvent);
    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
        BaseController.cerrarSesion(actionEvent);
    }

    public void notificarRetiro(ActionEvent actionEvent) {
    }

    public void cambiarEstado(ActionEvent actionEvent) throws IOException {
        stageEstado = new Stage();
        stageEstado.setMinWidth(800);
        stageEstado.setMinHeight(400);
        stageEstado.setMaxWidth(800);
        stageEstado.setMaxHeight(400);
        stageEstado.setMaximized(false);
        Scene sceneEstado = new Scene(loadFXML("cambio-estado"));
        stageEstado.setTitle("Lavadero");
        Image icono = new Image(getClass().getResourceAsStream("/images/icono-ventana.png"));
        stageEstado.getIcons().add(icono);
        stageEstado.setScene(sceneEstado);
        stageEstado.show();
    }
}
