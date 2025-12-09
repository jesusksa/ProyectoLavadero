package com.lavadero.controllers;

import javafx.event.ActionEvent;

import java.io.IOException;

public class RegistroTurnoClienteVehiculoController {
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

    public void altaCliente(ActionEvent actionEvent) {
    }

    public void editarCliente(ActionEvent actionEvent) {
    }

    public void volver(ActionEvent actionEvent) throws IOException {
        BaseController.anteriorPag(actionEvent);
    }

    public void continuar(ActionEvent actionEvent) throws IOException {

        /*
        * Validar datos del cliente
        * Validar datos del vehiculo
        *
        * */
        BaseController.avanzar("registro-turno-datos-cliente-vehiculo","registro-turno-confirmacion",false);
    }

    public void cancelar(ActionEvent actionEvent) {
        GestionTurnosController.stageRegistro.close();
    }
}
