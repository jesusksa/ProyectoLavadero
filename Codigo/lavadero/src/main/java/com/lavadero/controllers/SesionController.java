package com.lavadero.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SesionController {
    @FXML
    private PasswordField txtContra;
    @FXML
    private TextField txtnombreUsuario;

    public void IniciarSesion(ActionEvent actionEvent) {

        String usuario = txtnombreUsuario.getText();
        String cotrasenia = txtContra.getText();

        System.out.println(usuario + ":"+cotrasenia);
    }
}
