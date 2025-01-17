package com.lavadero.controllers;

import com.lavadero.App;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.regex.Pattern;

public class SesionController {
    @FXML
    private ToggleButton botonMostrarContraseña;
    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoContraseniaDescubierta;
    @FXML
    private PasswordField campoContrasenia;
    @FXML
    private Button botonAceptar;

    @FXML
    private void mostrarContrasenia(ActionEvent actionEvent) {
        if(botonMostrarContraseña.isSelected()){
            botonMostrarContraseña.setText("Ocultar");
            campoContraseniaDescubierta.setText(campoContrasenia.getText());
            campoContrasenia.setVisible(false);
            campoContraseniaDescubierta.setVisible(true);
        } else {
            botonMostrarContraseña.setText("Mostrar");
            campoContrasenia.setText(campoContraseniaDescubierta.getText());
            campoContraseniaDescubierta.setVisible(false);
            campoContrasenia.setVisible(true);
        }
    }

    @FXML
    public void initialize() {
        campoContraseniaDescubierta.setVisible(false);
    }

    @FXML
    private void validarCredenciales(ActionEvent actionEvent) {
        String nombreUsuario = campoNombre.getText();
        String contrasenia = campoContrasenia.getText();

        if(campoContraseniaDescubierta.isVisible()){
            contrasenia = campoContraseniaDescubierta.getText();
        } else {
            contrasenia = campoContrasenia.getText();
        }

        //No se completó alguno de los campos
        if(nombreUsuario.isEmpty() || contrasenia.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "No se han rellenado todos los campos.");
            alert.show();
        }

        //Longitud de nombre de usuario incorrecta
        else if (nombreUsuario.length() < 5 || nombreUsuario.length() > 30){
            Alert alert = new Alert(Alert.AlertType.ERROR, "La longitud de nombre de usuario ingresada no es adecuada.");
            alert.show();

        //Nombre de usuario con caracteres especiales
        } else if (!nombreUsuario.chars().allMatch(Character::isLetter)){
            Alert alert = new Alert(Alert.AlertType.ERROR, "No se permiten carácteres especiales en el nombre de usuario.");
            alert.show();

        //Contraseña con formato incorrecto
        } else if (!validarContrasenia(contrasenia)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Formato de contraseña incorrecto. La contraseña " +
                    "debe tener una longitud mínima de 10 carácteres e incluir al menos un número.");
            alert.show();
        }


    }

    private boolean validarContrasenia(String contrasenia){
        String regex = "^(?=.*\\d).{10,}$";
        return Pattern.matches(regex, contrasenia);
    }


}
