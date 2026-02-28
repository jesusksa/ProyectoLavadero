package com.lavadero.controllers;

import com.lavadero.DAOS.DAOCliente;
import com.lavadero.DAOS.DAOTurno;
import com.lavadero.DAOS.DAOVehiculo;
import com.lavadero.util.SessionData;
import com.lavadero.util.SystemNavigation;
import com.lavadero.util.SystemTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.List;

public class EditarDatosController {

    @FXML
    public Label lbFecha;
    @FXML
    public Label lbHora;
    @FXML
    public Label lbTipoServicio;
    @FXML
    public Label lbFormaPago;
    @FXML
    public Label lbNombrecliente;
    @FXML
    public Label lbDniCliente;
    @FXML
    public Label lbVehiculo;
    @FXML
    public Label lbModelo;
    @FXML
    public Label lbMatricula;

    public void initialize(){
        SystemTools.setearLabel(lbFecha, SessionData.getTurno().getFechaTurno().toString());
        SystemTools.setearLabel(lbHora,SessionData.getTurno().getHoraTurno().toString());
        SystemTools.setearLabel(lbTipoServicio,SessionData.getTurno().formatearServicio());
        SystemTools.setearLabel(lbFormaPago,SessionData.getTurno().formatearPago());
        SystemTools.setearLabel(lbNombrecliente,SessionData.getCliente().formatearNombre());
        SystemTools.setearLabel(lbDniCliente,SessionData.getCliente().formatearDni());
        SystemTools.setearLabel(lbVehiculo,SessionData.getVehiculo().getTipoAuto().toString());
        SystemTools.setearLabel(lbModelo,SessionData.getVehiculo().getModeloAuto());
        SystemTools.setearLabel(lbMatricula,SessionData.getVehiculo().getPatente());
    }

    public void confirmarEdicionTurno(ActionEvent actionEvent) throws IOException {
        if (SystemTools.createAlertConfirm("Edición Datos Turno","Confirme la actualizacion de datos","")){
            SessionData.getVehiculo().setCliente(SessionData.getCliente());
            SessionData.getCliente().setVehiculos(List.of(SessionData.getVehiculo()));

            DAOCliente daoCliente = new DAOCliente();
            daoCliente.actualizar(SessionData.getCliente());

            DAOVehiculo daoVehiculo = new DAOVehiculo();
            daoVehiculo.actualizar(SessionData.getVehiculo());


            SessionData.getTurno().setCliente(SessionData.getCliente());
            SessionData.getTurno().setVehiculo(SessionData.getVehiculo());
            SessionData.getTurno().setUsuario(SessionData.getUsuarioLogueado());

            DAOTurno daoTurno = new DAOTurno();
            daoTurno.actualizar(SessionData.getTurno());


            SystemNavigation.cancelar();
        }
    }

    public void cancelar(ActionEvent actionEvent) throws IOException {
        SystemNavigation.cancelar();
    }

    public void editarCliente(ActionEvent actionEvent) throws IOException {
        SystemNavigation.avanzar("editar-datos", "editar-cliente-vehiculo",true);
    }


    public void editarTurno(ActionEvent actionEvent) throws IOException {
        SystemNavigation.avanzar("editar-datos", "editar-turno",true);
    }

}
