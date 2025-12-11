package com.lavadero.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegistroTurnoClienteVehiculoController {
    public TextField txtDNI;
    public Label lbNombre;
    public Label lbApellido;
    public Label lbDni;
    public Label lbNumContacto;
    public Label lbDomicilio;
    public ChoiceBox cboxVehiculos;
    public Label lbTipoVeh;
    public Label lbModelo;
    public Label lbMatricula;
    public Label lbRelacion;
    public Label lbDomicilio1;

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

    public void buscarCliente(ActionEvent actionEvent) {
    }

    public void altaCliente(ActionEvent actionEvent) {
    }

    public void editarCliente(ActionEvent actionEvent) {
    }

    public void altaVehiculo(ActionEvent actionEvent) {
    }

    public void editarVehiculo(ActionEvent actionEvent) {
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
