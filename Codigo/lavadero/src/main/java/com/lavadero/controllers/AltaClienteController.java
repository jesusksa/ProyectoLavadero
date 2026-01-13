package com.lavadero.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AltaClienteController {
    private TextField txtNombres;
    private TextField txtApellidos;
    private TextField txtDNI;
    private TextField txtContacto;
    private TextField txtDireccion;

    public void altaVehiculo(ActionEvent actionEvent) throws IOException {
        PrimaryController.avanzar(PrimaryController.getPilaRetroceso().firstElement(), "alta-vehiculo",false);
    }

    public void cancelar(ActionEvent actionEvent){
    }

    public void registrarCliente(ActionEvent actionEvent){
    }
}
