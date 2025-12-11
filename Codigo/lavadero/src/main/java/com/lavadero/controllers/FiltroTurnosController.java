package com.lavadero.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class FiltroTurnosController {
    public TextField txtDni;
    public TextField txtEstado;
    public TextField txtVehiculo;
    public TextField txtLavado;
    public TextField txtFecha;
    public TextField txtMatricula;

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
        BaseController.cerrarSesion(actionEvent);
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

    public void filtrado(ActionEvent actionEvent) {
    }
}
