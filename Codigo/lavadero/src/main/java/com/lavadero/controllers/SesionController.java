package com.lavadero.controllers;

import com.lavadero.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SesionController {
    @FXML
    private PasswordField txtContra;
    @FXML
    private TextField txtnombreUsuario;

    public void IniciarSesion(ActionEvent actionEvent) throws IOException {

        String usuario = txtnombreUsuario.getText();
        String cotrasenia = txtContra.getText();


        if(usuario.equals("root") && cotrasenia.equals("12345")){
            App.setRoot("VentanaBase");
        }else {
            System.out.println("NO NO");
        }

    }
}
