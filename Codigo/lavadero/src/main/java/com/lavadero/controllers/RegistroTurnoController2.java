package com.lavadero.controllers;

import com.lavadero.App;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class RegistroTurnoController2 {
    
    //Pantalla de cliente y vehiculo
    public TextArea txtCliente;
    public Label lbNombreCliente;
    public Label lbDniCliente;
    public Label lbContactoCliente;
    public Label lbDomicilioCliente;
    
    public ChoiceBox cboxVehiculosCliente;
    public Label lbVehiculo;
    public Label lbModelo;
    public Label lbMatricula;
    
    //Pantalla de confirmar
    public Label lbFecha;
    public Label lbHora;
    public Label lbTipoServicio;
    public Label lbFormaPago;


    public void cancelar(ActionEvent actionEvent) {
    }

    public void continuar(ActionEvent actionEvent) throws IOException {
        PrimaryController.avanzar("registro-turno-datos-turno","registro-turno-datos-cliente-vehiculo",true);
    }

    public void buscarCliente(ActionEvent actionEvent) {
    }

    public void registrarCliente(ActionEvent actionEvent){
    }

    public void editarCliente(ActionEvent actionEvent){
    }

    public void registrarVehiculo(ActionEvent actionEvent){
    }

    public void editarVehiculo(ActionEvent actionEvent){
    }

    public void editarTurno(ActionEvent actionEvent) {
    }

    public void continuar2(ActionEvent actionEvent) throws IOException {
        PrimaryController.avanzar("registro-turno-datos-cliente-vehiculo","registro-turno-confirmacion",true);
    }

    public void confirmarTurno(ActionEvent actionEvent) {
    }
    
}
