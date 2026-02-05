package com.lavadero.controllers;

import com.lavadero.App;
import com.lavadero.model.Turno;
import com.lavadero.util.SessionData;
import com.lavadero.util.SystemNavigation;
import com.lavadero.util.SystemTools;
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
    private Turno turno = SessionData.getTurno();

    public void initialize(){
        SystemTools.setearLabel(lblCliente,lblCliente.getText().concat(" "+turno.getCliente().formatearNombre()));
        SystemTools.setearLabel(lblMatricula,lblMatricula.getText().concat(" "+turno.getVehiculo().getPatente()));
        SystemTools.setearLabel(lblVehiculo,lblVehiculo.getText().concat(" "+turno.getVehiculo().getTipoAuto()));
        SystemTools.setearLabel(lblServicio,lblServicio.getText().concat(" "+turno.formatearServicio()));
        SystemTools.setearLabel(lblEstado,lblEstado.getText().concat(" "+turno.formatearEstado()));
    }

    public void masInformacion(ActionEvent actionEvent) throws IOException {
        SessionData.setTurno(turno);
        SystemNavigation.avanzar("turnos","info-turnos",true);
    }

}
