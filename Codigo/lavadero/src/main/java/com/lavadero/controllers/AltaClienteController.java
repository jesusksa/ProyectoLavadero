package com.lavadero.controllers;

import com.lavadero.model.Cliente;
import com.lavadero.util.SessionData;
import com.lavadero.util.SystemNavigation;
import com.lavadero.util.SystemTools;
import com.lavadero.util.SystemValidations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AltaClienteController {
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

    private Cliente clienteNew = new Cliente();


    public void cancelar(ActionEvent actionEvent) throws IOException {
        SystemNavigation.cancelar();
    }

    public void registrarCliente(ActionEvent actionEvent) throws IOException {
        if(camposValidos()) {
            clienteNew.setNombres(txtNombres.getText());
            clienteNew.setApellidos(txtApellidos.getText());
            clienteNew.setDni(Integer.valueOf(txtDNI.getText()));
            clienteNew.setNumeroContacto("+54"+txtContacto.getText());
            clienteNew.setDomicilio(txtDireccion.getText());

            SessionData.setCliente(clienteNew);

            SystemTools.createAlert(Alert.AlertType.INFORMATION,"Alta Cliente","Cliente registrado correctamente","");

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

        if(txtDNI.getText().isEmpty()){
            SystemTools.createAlert(Alert.AlertType.ERROR, "Error de datos", "Validacion de datos", "El DNI es obligatorio");
            return false;
        }else{
            String errorDni = SystemValidations.validarDni(txtDNI.getText());
            if(errorDni != null){
                SystemTools.createAlert(Alert.AlertType.ERROR, "Error de datos", "Validacion de datos", errorDni);
                return false;
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
