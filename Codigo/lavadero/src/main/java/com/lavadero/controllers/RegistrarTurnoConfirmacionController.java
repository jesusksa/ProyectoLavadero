package com.lavadero.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;

public class RegistrarTurnoConfirmacionController {
    public Label txtFecha;
    public Label txtHora;
    public Label txtServicio;
    public Label txtFormPago;
    public Label txtCliente;
    public Label txtDni;
    public Label txtVehiculo;
    public Label txtModelo;
    public Label txtMatricula;

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

    public void cancelar(ActionEvent actionEvent) {
        GestionTurnosController.stageRegistro.close();
    }

    public void volver(ActionEvent actionEvent) throws IOException {
        BaseController.anteriorPag(actionEvent);
    }

    public void confirmarTurno(ActionEvent actionEvent) {
        /*
        * Verificartodo
        * Confirmar
        * */
        GestionTurnosController.stageRegistro.close();
    }

    public void editarTurno(ActionEvent actionEvent) {
    }

    public void editarCliente(ActionEvent actionEvent) {
    }

    public void editarVehiculo(ActionEvent actionEvent) {
    }
}
