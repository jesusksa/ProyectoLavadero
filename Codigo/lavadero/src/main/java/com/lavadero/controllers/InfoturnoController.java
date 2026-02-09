package com.lavadero.controllers;

import com.lavadero.DAOS.DAOTurno;
import com.lavadero.model.Turno;
import com.lavadero.util.SessionData;
import com.lavadero.util.SystemTools;
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
    private Turno turno;

    private static Stage stageEstado;

    public void initialize(){
        DAOTurno daoTurno = new DAOTurno();
        turno = daoTurno.obtenerPorId(SessionData.getTurno().getIdTurno());
        SystemTools.setearLabel(lbCliente,lbCliente.getText().concat(" "+turno.getCliente().formatearNombre()));
        SystemTools.setearLabel(lbVehiculo,lbVehiculo.getText().concat(" "+turno.getVehiculo().getTipoAuto().toString()));
        SystemTools.setearLabel(lbContacto,lbContacto.getText().concat(" "+turno.getCliente().getNumeroContacto()));
        SystemTools.setearLabel(lbDireccion,lbDireccion.getText().concat(" "+turno.getCliente().getDomicilio()));
        SystemTools.setearLabel(lbMatricula,lbMatricula.getText().concat(" "+turno.getVehiculo().getPatente()));
        SystemTools.setearLabel(lbFecha,lbFecha.getText().concat(" "+turno.getFechaTurno()));
        SystemTools.setearLabel(lbEstdo,lbEstdo.getText().concat(" "+turno.formatearEstado()));
        SystemTools.setearLabel(lbResponsables,lbResponsables.getText().concat(" "+turno.getEmpleados()));
        SystemTools.setearLabel(lbServicio,lbServicio.getText().concat(" "+turno.formatearServicio()));
        SystemTools.setearLabel(lbFormaPago,lbFormaPago.getText().concat(" "+turno.formatearPago()));
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
