package com.lavadero.controllers;

import com.lavadero.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Optional;
import java.util.Stack;

import static com.lavadero.App.loadFXML;

public class CambioEstadoController {

//    @Setter
//    private static String escenaActual;
//    @Getter
//    private static Stack<String> pilaRetrocesoEstado = new Stack<>();
//    @Getter
//    private static Stack<String> pilaAvanceEstado = new Stack<>();


    public MenuButton mbtnCuenta;
    public Button btnHome;
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
//        BaseController.setEscenaActual("cambio-estado");
//        BaseController.controlarVisibilidad(btnPrev, btnNext);
    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
        BaseController.cerrarSesion(actionEvent);
    }

    public void anteriorPag(ActionEvent actionEvent) throws IOException {
//        BaseController.anteriorPag(actionEvent);
    }

    public void home(ActionEvent actionEvent) throws IOException {
        BaseController.home(actionEvent);
    }

    public void siguientePag(ActionEvent actionEvent) throws IOException {
//        BaseController.siguientePag(actionEvent);
    }

    public void CambioEstadoEspera(ActionEvent actionEvent) {
    }

    public void CambioEstadoProceso(ActionEvent actionEvent) {
    }

    public void CambioEstadoFinalizado(ActionEvent actionEvent) {
    }

    public void CambioEstadoCancelado(ActionEvent actionEvent) {
    }
}
