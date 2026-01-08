package com.lavadero.controllers;

import com.lavadero.App;
import com.lavadero.model.Turno;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;

public class TurnoTarjetaController {
    public Label lblCliente;
    public Label lblMatricula;
    public Label lblVehiculo;
    public Label lblServicio;
    public Label lblEstado;

    public void masInformacion(ActionEvent actionEvent) throws IOException {
        PrimaryController.avanzar("turnos","info-turnos",true);
    }

    public void setData(Turno turno) {

    }
}
