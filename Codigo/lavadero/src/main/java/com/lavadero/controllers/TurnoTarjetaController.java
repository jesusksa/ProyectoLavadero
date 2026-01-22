package com.lavadero.controllers;

import com.lavadero.App;
import com.lavadero.model.Turno;
import com.lavadero.util.SessionData;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

public class TurnoTarjetaController {
    public Label lblCliente;
    public Label lblMatricula;
    public Label lblVehiculo;
    public Label lblServicio;
    public Label lblEstado;

    @Setter
    @Getter
    private Turno turno = SessionData.getTurnoActual();

    public void initialize(){
        lblCliente.setText(lblCliente.getText().concat(turno.getCliente().getNombres()+" "+turno.getCliente().getApellidos()));
        lblMatricula.setText(lblMatricula.getText().concat(turno.getVehiculo().getPatente()));
        lblVehiculo.setText(lblVehiculo.getText().concat(turno.getVehiculo().getTipoAuto().toString()));
        lblServicio.setText(lblServicio.getText().concat(turno.getTipoServicio().toString()));
        lblEstado.setText(lblEstado.getText().concat(turno.getEstado().toString()));
    }

    public void masInformacion(ActionEvent actionEvent) throws IOException {
        SessionData.setTurnoActual(turno);
        PrimaryController.avanzar("turnos","info-turnos",true);
    }

}
