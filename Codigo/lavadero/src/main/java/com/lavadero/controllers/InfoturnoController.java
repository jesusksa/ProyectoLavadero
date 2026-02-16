package com.lavadero.controllers;

import com.lavadero.DAOS.DAOTurno;
import com.lavadero.model.EstadoLavado;
import com.lavadero.model.Turno;
import com.lavadero.util.SessionData;
import com.lavadero.util.SystemNavigation;
import com.lavadero.util.SystemTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
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
    @FXML
    private Button btnEstado;

    @Setter
    @Getter
    private Turno turno;

    private static Stage stageEstado;

    public void initialize(){


        limpiarLabels();
        cargarTurno();
    }

    public void editarDatosTurnos() throws IOException {
        SessionData.setTurno(turno);
        SessionData.setVehiculo(turno.getVehiculo());
        SessionData.setCliente(turno.getCliente());
        SystemNavigation.avanzar("info-turnos","editar-datos",true);
    }

    public void cambiarEstado(ActionEvent actionEvent) throws IOException {
            stageEstado = new Stage();
            stageEstado.setMaximized(false);
            Scene sceneEstado = new Scene(loadFXML("cambio-estado"));
            stageEstado.setTitle("Lavadero");
            Image icono = new Image(getClass().getResourceAsStream("/images/icono-ventana.png"));
            stageEstado.getIcons().add(icono);
            stageEstado.setScene(sceneEstado);
            stageEstado.initModality(Modality.APPLICATION_MODAL);

            // 🔑 CLAVE
            stageEstado.setOnHidden(ev -> cargarTurno());
            stageEstado.showAndWait();
    }

    public void notificarTurno(ActionEvent actionEvent) throws IOException {
        ;
    }

    public void cargarTurno(){
        DAOTurno daoTurno = new DAOTurno();
        turno = daoTurno.obtenerPorId(SessionData.getTurno().getIdTurno());
        SystemTools.setearLabel(lbCliente,turno.getCliente().formatearNombre());
        SystemTools.setearLabel(lbVehiculo,turno.getVehiculo().getTipoAuto().toString());
        SystemTools.setearLabel(lbContacto,turno.getCliente().getNumeroContacto());
        SystemTools.setearLabel(lbDireccion,turno.getCliente().getDomicilio());
        SystemTools.setearLabel(lbMatricula,turno.getVehiculo().getPatente());
        SystemTools.setearLabel(lbFecha,turno.formatearFecha());
        SystemTools.setearLabel(lbEstdo,turno.formatearEstado());
        SystemTools.setearLabel(lbResponsables,turno.formatearEmpleados());
        SystemTools.setearLabel(lbServicio,turno.formatearServicio());
        SystemTools.setearLabel(lbFormaPago,turno.formatearPago());
        if(turno.getEstado() == EstadoLavado.FINALIZADO || turno.getEstado() == EstadoLavado.CANCELADO){
            btnEstado.setDisable(true);
        }
    }

    public void limpiarLabels(){
        lbCliente.setText("");
        lbVehiculo.setText("");
        lbContacto.setText("");
        lbDireccion.setText("");
        lbMatricula.setText("");
        lbFecha.setText("");
        lbEstdo.setText("");
        lbResponsables.setText("");
        lbServicio.setText("");
        lbFormaPago.setText("");
    }
}
