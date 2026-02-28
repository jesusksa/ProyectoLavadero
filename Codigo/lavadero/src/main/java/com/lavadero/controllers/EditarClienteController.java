package com.lavadero.controllers;

import com.lavadero.util.SessionData;
import com.lavadero.util.SystemNavigation;
import com.lavadero.util.SystemTools;
import com.lavadero.util.SystemValidations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditarClienteController {

    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtDNI;
    @FXML
    private TextField txtContacto;
    @FXML
    private TextField txtDireccion;

    public void initialize(){
        txtNombres.setText(SessionData.getCliente().getNombres());
        txtApellidos.setText(SessionData.getCliente().getApellidos());
        txtDNI.setText(String.valueOf(SessionData.getCliente().getDni()));
        txtDNI.setDisable(true);
        txtContacto.setText(SessionData.getCliente().getNumeroContacto());
        txtDireccion.setText(SessionData.getCliente().getDomicilio());
    }

    public void cancelar(ActionEvent actionEvent) throws IOException {
        SystemNavigation.cancelar();
    }

    public void confirmar(ActionEvent actionEvent) throws IOException {
        if(camposValidos()) {
            SessionData.getCliente().setNombres(txtNombres.getText());
            SessionData.getCliente().setApellidos((txtApellidos.getText()));
            SessionData.getCliente().setNumeroContacto(txtContacto.getText());
            SessionData.getCliente().setDomicilio(txtDireccion.getText());

            SystemTools.createAlert(Alert.AlertType.INFORMATION,"Edición Cliente","Cliente editado correctamente","");
            SystemNavigation.anteriorPag(false);
        }
    }

    public boolean camposValidos(){

        if(txtNombres.getText().isEmpty()){
            SystemTools.createAlert(Alert.AlertType.ERROR, "Error de datos", "Validacion de datos", "El nombre es obligatorio");
            return false;
        }else{
            String errorNombre = SystemValidations.validarNombre(txtNombres.getText());
            if(errorNombre != null){
                SystemTools.createAlert(Alert.AlertType.ERROR, "Error de datos", "Validacion de datos", errorNombre);
                return false;
            }
        }

        if(txtApellidos.getText().isEmpty()){
            SystemTools.createAlert(Alert.AlertType.ERROR, "Error de datos", "Validacion de datos", "El apellido es obligatorio");
            return false;
        }else{
            String errorApellido = SystemValidations.validarApellido(txtApellidos.getText());
            if(errorApellido != null){
                SystemTools.createAlert(Alert.AlertType.ERROR, "Error de datos", "Validacion de datos", errorApellido);
                return  false;
            }
        }

        if(txtContacto.getText().isEmpty()){
            SystemTools.createAlert(Alert.AlertType.ERROR, "Error de datos", "Validacion de datos", "El contacto es obligatorio");
            return false;
        }else{
            String errorContacto = SystemValidations.validarContacto(txtContacto.getText());
            if(errorContacto != null){
                SystemTools.createAlert(Alert.AlertType.ERROR, "Error de datos", "Validacion de datos", errorContacto);
                return false;
            }
        }

        if(txtDireccion.getText().isEmpty()){
            SystemTools.createAlert(Alert.AlertType.ERROR, "Error de datos", "Validacion de datos", "La dirección es obligatoria");
            return false;
        }else{
            String errorDirreccion = SystemValidations.validarDireccion(txtDireccion.getText());
            if(errorDirreccion != null){
                SystemTools.createAlert(Alert.AlertType.ERROR, "Error de datos", "Validacion de datos", errorDirreccion);
                return false;
            }
        }

        return true;
    }
}
