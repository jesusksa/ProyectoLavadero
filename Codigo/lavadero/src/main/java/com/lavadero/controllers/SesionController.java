package com.lavadero.controllers;

import com.lavadero.App;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

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



}
