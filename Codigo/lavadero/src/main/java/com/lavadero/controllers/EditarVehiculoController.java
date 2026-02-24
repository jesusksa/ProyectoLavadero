package com.lavadero.controllers;

import com.lavadero.model.TipoAuto;
import com.lavadero.model.TipoRelacion;
import com.lavadero.util.SessionData;
import com.lavadero.util.SystemNavigation;
import com.lavadero.util.SystemTools;
import com.lavadero.util.SystemValidations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditarVehiculoController {

    @FXML
    private ChoiceBox cboxTipoVehiculo;
    @FXML
    private TextField txtPatente;
    @FXML
    private TextField txtModelo;
    @FXML
    private ChoiceBox cboxTipoAsociacion;

    public void initialize(){
        txtPatente.setText(SessionData.getVehiculo().getPatente());
        txtPatente.setDisable(true);
        txtModelo.setText(SessionData.getVehiculo().getModeloAuto());
        cboxTipoVehiculo.getItems().setAll(TipoAuto.values());
        cboxTipoVehiculo.setValue(SessionData.getVehiculo().getTipoAuto());
        cboxTipoAsociacion.getItems().setAll(TipoRelacion.values());
        cboxTipoAsociacion.setValue(SessionData.getVehiculo().getTipoRelacion());
    }
    public void cancelar(ActionEvent actionEvent) throws IOException {
        SystemNavigation.cancelar();
    }

    public void confirmar(ActionEvent actionEvent) throws IOException {
        if(camposValidos()) {
            SessionData.getVehiculo().setTipoAuto((TipoAuto) cboxTipoVehiculo.getValue());
            SessionData.getVehiculo().setModeloAuto(txtModelo.getText());
            SessionData.getVehiculo().setTipoRelacion((TipoRelacion) cboxTipoAsociacion.getValue());

            SystemTools.createAlert(Alert.AlertType.INFORMATION,"Editar Vehiculo","Vehiculo editado correctamente","");

            SystemNavigation.anteriorPag(false);
        }
    }

    public boolean camposValidos(){
        if(cboxTipoVehiculo.getValue() == null){
            SystemTools.createAlert(Alert.AlertType.ERROR,"Error de datos","Validación de datos","El tipo de vehiculo es obligatorio");
            return false;
        }

        if(txtModelo.getText().isEmpty()){
            SystemTools.createAlert(Alert.AlertType.ERROR,"Error de datos","Validación de datos","El modelo es obligatorio");
            return false;
        }else{
            String errorModelo = SystemValidations.validarModeloAuto(txtModelo.getText());
            if(errorModelo != null){
                SystemTools.createAlert(Alert.AlertType.ERROR,"Error de datos", "Validación de datos", errorModelo);
                return false;
            }
        }

        if(cboxTipoAsociacion.getValue() == null){
            SystemTools.createAlert(Alert.AlertType.ERROR,"Error de datos","Validación de datos","Elija un tipo de asociacion");
            return false;
        }

        return true;
    }
}
