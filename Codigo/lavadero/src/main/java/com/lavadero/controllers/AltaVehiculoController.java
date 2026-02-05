package com.lavadero.controllers;

import com.lavadero.model.TipoAuto;
import com.lavadero.model.TipoRelacion;
import com.lavadero.model.TipoRol;
import com.lavadero.model.Vehiculo;
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
import java.util.List;

public class AltaVehiculoController {

    @FXML
    private ChoiceBox<TipoAuto> cboxTipoVehiculo;
    @FXML
    private TextField txtPatente;
    @FXML
    private TextField txtModelo;
    @FXML
    private ChoiceBox cboxTipoAsociacion;

    private Vehiculo vehiculoNew = new Vehiculo();

    public void initialize(){
        cboxTipoVehiculo.getItems().setAll(TipoAuto.values());
        cboxTipoAsociacion.getItems().setAll(TipoRelacion.values());
    }

    public void cancelar(ActionEvent actionEvent) throws IOException {
        SystemNavigation.cancelar();
    }

    public void registrarVehiculo(ActionEvent actionEvent) throws IOException {
        if(camposValidos()) {
            vehiculoNew.setTipoAuto(cboxTipoVehiculo.getValue());
            vehiculoNew.setModeloAuto(txtModelo.getText());
            vehiculoNew.setPatente(txtPatente.getText());
            vehiculoNew.setTipoRelacion((TipoRelacion) cboxTipoAsociacion.getValue());

            SessionData.setVehiculo(vehiculoNew);
            SystemTools.createAlert(Alert.AlertType.INFORMATION,"Alta Vehiculo","Vehiculo registrado correctamente","");

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

        if(txtPatente.getText().isEmpty()){
            SystemTools.createAlert(Alert.AlertType.ERROR,"Error de datos","Validación de datos","La patente es obligatoria");
            return false;
        }else{
            String errorPatente = SystemValidations.validarPatente(txtPatente.getText());
            if(errorPatente != null){
                SystemTools.createAlert(Alert.AlertType.ERROR,"Error de datos","Validación de datos", errorPatente);
                return  false;
            }
        }

        if(cboxTipoAsociacion.getValue() == null){
            SystemTools.createAlert(Alert.AlertType.ERROR,"Error de datos","Validación de datos","Elija un tipo de asociacion");
            return false;
        }

        return true;
    }
}
