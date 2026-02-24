package com.lavadero.controllers;

import com.lavadero.App;
import com.lavadero.DAOS.DAOTurno;
import com.lavadero.model.EstadoLavado;
import com.lavadero.util.SessionData;
import com.lavadero.util.SystemTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class CambioEstadoCanceladoController {

    @FXML
    public TextArea txtMotivoCancelacion;
    @FXML
    private Button btnConfirmar;

    public void confirmarCancelacion(ActionEvent actionEvent) throws IOException {
        if(!txtMotivoCancelacion.getText().isEmpty() && SystemTools.createAlertConfirm("Cambio de Estado","¿Seguro que quiere cambiar a estado 'Cancelado'?","")){
            SessionData.getTurno().setEstado(EstadoLavado.CANCELADO);
            SessionData.getTurno().setMotivo(txtMotivoCancelacion.getText());
            DAOTurno daoTurno = new DAOTurno();
            daoTurno.actualizar(SessionData.getTurno());
            SystemTools.createAlert(Alert.AlertType.INFORMATION,"Actualización","Se actualizo el estado del turno correctamente","");
            Stage stage = (Stage) btnConfirmar.getScene().getWindow();
            stage.close();
        }else if(txtMotivoCancelacion.getText().isEmpty()){
            SystemTools.createAlert(Alert.AlertType.ERROR,"Error de datos","Motivo de cancelación obligatorio","Por favor introduzca el motivo de cancelar el turno");
        }else {
            CambioEstadoController.getInstance().cargarContenidoCambiEstado(App.loadFXML("cambio-estado"));
        }
    }
}
