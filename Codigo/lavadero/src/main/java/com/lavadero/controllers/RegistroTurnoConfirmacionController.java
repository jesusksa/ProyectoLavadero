package com.lavadero.controllers;

import com.lavadero.DAOS.DAOCliente;
import com.lavadero.DAOS.DAOTurno;
import com.lavadero.DAOS.DAOUsuario;
import com.lavadero.DAOS.DAOVehiculo;
import com.lavadero.util.SessionData;
import com.lavadero.util.SystemNavigation;
import com.lavadero.util.SystemTools;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import org.hibernate.SessionEventListener;

import java.io.IOException;
import java.util.List;

public class RegistroTurnoConfirmacionController {
    //Pantalla de confirmar
    public Label lbFecha;
    public Label lbHora;
    public Label lbTipoServicio;
    public Label lbFormaPago;
    public Label lbNombrecliente;
    public Label lbDniCliente;
    public Label lbVehiculo;
    public Label lbModelo;
    public Label lbMatricula;

    public void initialize(){
        SystemTools.setearLabel(lbFecha,SessionData.getTurno().getFechaTurno().toString());
        SystemTools.setearLabel(lbHora,SessionData.getTurno().getHoraTurno().toString());
        SystemTools.setearLabel(lbTipoServicio,SessionData.getTurno().formatearServicio());
        SystemTools.setearLabel(lbFormaPago,SessionData.getTurno().formatearPago());
        SystemTools.setearLabel(lbNombrecliente,SessionData.getCliente().formatearNombre());
        SystemTools.setearLabel(lbDniCliente,SessionData.getCliente().formatearDni());
        SystemTools.setearLabel(lbVehiculo,SessionData.getVehiculo().getTipoAuto().toString());
        SystemTools.setearLabel(lbModelo,SessionData.getVehiculo().getModeloAuto());
        SystemTools.setearLabel(lbMatricula,SessionData.getVehiculo().getPatente());
    }

    public void cancelar(ActionEvent actionEvent) throws IOException {
        SessionData.limpiarTurno();
        SessionData.limpiarCliente();
        SessionData.limpiarVehiculo();
        SystemNavigation.cancel();
    }

    public void confirmarTurno(ActionEvent actionEvent) throws IOException {
        SessionData.getVehiculo().setCliente(SessionData.getCliente());
        SessionData.getCliente().setVehiculos(List.of(SessionData.getVehiculo()));

        DAOCliente daoCliente = new DAOCliente();
        daoCliente.agregar(SessionData.getCliente());

        DAOVehiculo daoVehiculo = new DAOVehiculo();
        daoVehiculo.agregar(SessionData.getVehiculo());


        SessionData.getTurno().setCliente(SessionData.getCliente());
        SessionData.getTurno().setVehiculo(SessionData.getVehiculo());
        SessionData.getTurno().setUsuario(SessionData.getUsuarioLogueado());

        DAOTurno daoTurno = new DAOTurno();
        daoTurno.agregar(SessionData.getTurno());

        SessionData.limpiarTurno();
        SessionData.limpiarCliente();
        SessionData.limpiarVehiculo();

        SystemNavigation.inicio();
    }

    public void editarCliente(ActionEvent actionEvent) throws IOException {
        SystemNavigation.avanzar("registro-turno-confirmacion", "editar-cliente",true);
    }

    public void editarVehiculo(ActionEvent actionEvent) throws IOException {
        SystemNavigation.avanzar("registro-turno-confirmacion", "editar-vehiculo",true);
    }

    public void editarTurno(ActionEvent actionEvent) throws IOException {
        SystemNavigation.avanzar("registro-turno-confirmacion", "editar-turno",true);
    }
}
