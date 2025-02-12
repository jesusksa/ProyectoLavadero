package com.lavadero.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class ConsultaModificacionController implements Avanzable, Navegable{
    public MenuButton mbtnCuenta;
    public ScrollPane scllTurnos;
    private int currentRow = 0; // Para rastrear la fila actual en el GridPane
    private int currentColumn = 0; // Para rastrear la columna actual en la fila
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


    @Override
    public void avanzar(String viewActual, String viewNueva) throws IOException {
        BaseController.avanzar(viewActual, viewNueva);
    }

    @FXML
    private void cargarTurnos(ActionEvent actionEvent) throws IOException {
        avanzar("consulta-modificacion", "consulta-modificacion-turnos");
    }
}
