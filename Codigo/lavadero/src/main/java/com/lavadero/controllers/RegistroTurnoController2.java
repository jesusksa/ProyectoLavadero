package com.lavadero.controllers;

import com.lavadero.App;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalTime;

public class RegistroTurnoController2 {
    
    public Spinner spHora;

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

    public void initialize(){
        //Validar luego el horario de verano eh invierno, ajustar horas al rango horario laboral
        //SpinnerValueFactory<Integer> horaFactory =
                //new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, LocalTime.now().getHour());
        //spHora.setValueFactory(horaFactory);
    }

    public void cancelar(ActionEvent actionEvent) throws IOException {
        PrimaryController.avanzar(PrimaryController.getPilaRetroceso().firstElement(), "turnos",false);
        PrimaryController.getPilaRetroceso().removeAllElements();
        PrimaryController.getPilaAvance().removeAllElements();
        PrimaryController.controlarVisibilidad(PrimaryController.getInstance().btnPrev, PrimaryController.getInstance().btnNext);
    }

    public void continuar(ActionEvent actionEvent) throws IOException {
        PrimaryController.avanzar("registro-turno-datos-turno","registro-turno-datos-cliente-vehiculo",true);
    }

    public void buscarCliente(ActionEvent actionEvent) {
    }

    public void registrarCliente(ActionEvent actionEvent) throws IOException {
        PrimaryController.avanzar(PrimaryController.getPilaRetroceso().firstElement(), "alta-cliente",false);
    }

    public void editarCliente(ActionEvent actionEvent) throws IOException {
        PrimaryController.avanzar(PrimaryController.getPilaRetroceso().firstElement(), "editar-cliente",false);
    }

    public void registrarVehiculo(ActionEvent actionEvent) throws IOException {
        PrimaryController.avanzar(PrimaryController.getPilaRetroceso().firstElement(), "alta-vehiculo",false);
    }

    public void editarVehiculo(ActionEvent actionEvent) throws IOException {
        PrimaryController.avanzar(PrimaryController.getPilaRetroceso().firstElement(), "editar-vehiculo",false);
    }

    public void editarTurno(ActionEvent actionEvent) throws IOException {
        PrimaryController.avanzar(PrimaryController.getPilaRetroceso().firstElement(), "editar-turno",false);
    }

    public void continuar2(ActionEvent actionEvent) throws IOException {
        PrimaryController.avanzar("registro-turno-datos-cliente-vehiculo","registro-turno-confirmacion",true);
    }

    public void confirmarTurno(ActionEvent actionEvent) throws IOException {
        PrimaryController.avanzar("registro-turno-confirmacion","turnos",false);
    }
    
}
