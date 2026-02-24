package com.lavadero.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class ConsultaModificacionController {
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
    }


    public void anteriorPag(ActionEvent actionEvent) throws IOException {

    }

    public void home(ActionEvent actionEvent) throws IOException {

    }

    public void siguientePag(ActionEvent actionEvent) throws IOException {

    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
    }
}
