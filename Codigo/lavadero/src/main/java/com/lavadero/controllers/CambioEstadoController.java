package com.lavadero.controllers;

import com.lavadero.App;
import com.lavadero.DAOS.DAOTurno;
import com.lavadero.model.EstadoLavado;
import com.lavadero.util.SessionData;
import com.lavadero.util.SystemTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;


import java.io.IOException;
import java.time.LocalTime;

public class CambioEstadoController {

    @FXML
    public AnchorPane apnContenidoAjusteEstado;
    @FXML
    private Button btnActualizarEstado;
    @FXML
    private Button btnEspera;
    @FXML
    private Button btnProceso;
    @FXML
    private Button btnFinalizado;
    @FXML
    private Button btnCancelado;

    @Getter
    @Setter
    private static CambioEstadoController instance;


    public void initialize(){
        instance = this;
        if(SessionData.getTurno().getEstado() == EstadoLavado.ESPERA){
            btnEspera.setDisable(true);
        }
        if(SessionData.getTurno().getEstado() == EstadoLavado.PROCESO){
            btnProceso.setDisable(true);
        }
    }

    public void cambioAEspera(ActionEvent actionEvent){
        if(SystemTools.createAlertConfirm("Cambio de Estado","¿Seguro que quiere cambiar a estado 'En Espera'?","")){
            SessionData.getTurno().setEstado(EstadoLavado.ESPERA);
            actualizarEstado();
            Stage stage = (Stage) btnEspera.getScene().getWindow();
            stage.close();
        }
    }

    public void cambioAProceso(ActionEvent actionEvent){
        if(SystemTools.createAlertConfirm("Cambio de Estado","¿Seguro que quiere cambiar a estado 'En Proceso'?","")){
            SessionData.getTurno().setEstado(EstadoLavado.PROCESO);
            SessionData.getTurno().setHoraInicio(LocalTime.now());
            actualizarEstado();
            Stage stage = (Stage) btnProceso.getScene().getWindow();
            stage.close();
        }
    }

    public void cambioAFinalizado(ActionEvent actionEvent) throws IOException {
        cargarContenidoCambiEstado(App.loadFXML("cambio-estado-finalizado"));
    }

    public void cambioACancelado(ActionEvent actionEvent) throws IOException {
        cargarContenidoCambiEstado(App.loadFXML("cambio-estado-cancelado"));
    }

    public void actualizarEstado(){
        DAOTurno daoTurno = new DAOTurno();
        daoTurno.actualizar(SessionData.getTurno());
        SystemTools.createAlert(Alert.AlertType.INFORMATION,"Actualización","Se actualizo el estado del turno correctamente","");
    }

    public void cargarContenidoCambiEstado(Parent p){
        apnContenidoAjusteEstado.getChildren().clear();
        apnContenidoAjusteEstado.getChildren().setAll(p);
        AnchorPane.setTopAnchor(p, 0.0);
        AnchorPane.setBottomAnchor(p, 0.0);
        AnchorPane.setLeftAnchor(p, 0.0);
        AnchorPane.setRightAnchor(p, 0.0);
    }

}
