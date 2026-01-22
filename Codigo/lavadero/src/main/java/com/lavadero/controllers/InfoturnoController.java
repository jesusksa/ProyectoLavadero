package com.lavadero.controllers;

import com.lavadero.model.Turno;
import com.lavadero.util.SessionData;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

import static com.lavadero.App.loadFXML;

public class InfoturnoController {
    public Label lbCliente;
    public Label lbVehiculo;
    public Label lbContacto;
    public Label lbDireccion;
    public Label lbMatricula;
    public Label lbFecha;
    public Label lbEstdo;
    public Label lbResponsables;
    public Label lbServicio;
    public Label lbFormaPago;

    @Setter
    @Getter
    private Turno turno = SessionData.getTurnoActual();

    private static Stage stageEstado;

    public void initialize(){
        lbCliente.setText(lbCliente.getText().concat(" "+turno.getCliente().getNombres()+" "+turno.getCliente().getApellidos()));
        lbVehiculo.setText(lbVehiculo.getText().concat(" "+turno.getVehiculo().getTipoAuto().toString()));
        lbContacto.setText(lbContacto.getText().concat(" "+turno.getCliente().getNumeroContacto()));
        lbDireccion.setText(lbDireccion.getText().concat(" "+turno.getCliente().getDomicilio()));
        lbMatricula.setText(lbMatricula.getText().concat(" "+turno.getVehiculo().getPatente()));
        lbFecha.setText(lbFecha.getText().concat(" "+turno.getFechaTurno()));
        lbEstdo.setText(lbEstdo.getText().concat(" "+turno.getEstado()));
        lbResponsables.setText(lbResponsables.getText().concat(" "+turno.getEmpleados()));
        lbServicio.setText(lbServicio.getText().concat(" "+turno.getTipoServicio()));
        lbFormaPago.setText(lbFormaPago.getText().concat(" "+turno.getFormaPago()));
    }

    public void cambiarEstado(ActionEvent actionEvent) throws IOException {
        stageEstado = new Stage();
        stageEstado.setMaximized(false);
        Scene sceneEstado = new Scene(loadFXML("cambio-estado"));
        stageEstado.setTitle("Lavadero");
        Image icono = new Image(getClass().getResourceAsStream("/images/icono-ventana.png"));
        stageEstado.getIcons().add(icono);
        stageEstado.setScene(sceneEstado);
        stageEstado.show();
    }

    public void notificarTurno(ActionEvent actionEvent) throws IOException {
        ;
    }
}
