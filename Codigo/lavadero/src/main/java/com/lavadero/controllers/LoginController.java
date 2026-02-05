package com.lavadero.controllers;

import com.lavadero.App;
import com.lavadero.DAOS.DAOUsuario;
import com.lavadero.util.SessionData;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {


    public TextField txtUsuario;
    public PasswordField txtPassword;

    public void login(ActionEvent actionEvent) throws IOException {
        App.setRoot("base");
        DAOUsuario daoUsuario = new DAOUsuario();
        SessionData.setUsuarioLogueado(daoUsuario.obtenerUsuario("office"));
    }
}
