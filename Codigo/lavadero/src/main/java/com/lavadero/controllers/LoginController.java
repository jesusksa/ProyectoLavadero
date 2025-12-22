package com.lavadero.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {


    public TextField txtUsuario;
    public PasswordField txtPassword;

    public void login(ActionEvent actionEvent) throws IOException {
        BaseController.avanzar("sesion","base",true);
    }
}
