package com.lavadero.controllers;

import com.lavadero.App;
import com.lavadero.DAOS.DAOUsuario;
import com.lavadero.model.Usuario;
import com.lavadero.util.SessionData;
import com.lavadero.util.SystemTools;
import com.lavadero.util.SystemValidations;
import com.lavadero.util.VersionUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtNombreUsuario;
    @FXML
    private TextField txtContraVisible;
    @FXML
    private PasswordField txtContrasenia;
    @FXML
    private ToggleButton btnMostrarContra;
    @FXML
    private Label lblVersion;

    private Usuario userLogin;


    public void initialize(){
        txtContraVisible.setVisible(false);
        lblVersion.setText("Versión: " + VersionUtils.getVersion());
    }
    public void login(ActionEvent actionEvent) throws IOException {
        String nombreUsuario = txtNombreUsuario.getText();
        String contrasenia = txtContrasenia.getText();

        if(txtContraVisible.isVisible()){
            contrasenia = txtContraVisible.getText();
        }else{
            contrasenia = txtContrasenia.getText();
        }

        if(camposValidos(nombreUsuario, contrasenia) && validarUsuario(nombreUsuario,contrasenia)){
            App.setRoot("base");
        }
    }

    public void mostrarContrasenia(ActionEvent actionEvent){
        if(btnMostrarContra.isSelected()){
            btnMostrarContra.setText("Ocultar");
            txtContraVisible.setText(txtContrasenia.getText());
            txtContrasenia.setVisible(false);
            txtContraVisible.setVisible(true);
        }else{
            btnMostrarContra.setText("Mostrar");
            txtContrasenia.setText(txtContraVisible.getText());
            txtContrasenia.setVisible(true);
            txtContraVisible.setVisible(false);
        }
    }

    public boolean camposValidos(String nameUser, String passw){
        if(nameUser.isEmpty()){
            SystemTools.createAlert(Alert.AlertType.ERROR,"Error de datos","Validación de datos","El nombre de usuario es obligatorio");
            return false;
        }else{
            String errorNombreUsuario = SystemValidations.validarNombreUsuario(nameUser);
            if(errorNombreUsuario != null){
                SystemTools.createAlert(Alert.AlertType.ERROR,"Error de datos","Validación de datos",errorNombreUsuario);
                return false;
            }
        }

        if(passw.isEmpty()){
            SystemTools.createAlert(Alert.AlertType.ERROR,"Error de datos","Validación de datos","La contraseña es obligatoria");
            return false;
        }else{
            String errorContrasenia = SystemValidations.validarContrasenia(passw);
            if(errorContrasenia != null){
                SystemTools.createAlert(Alert.AlertType.ERROR,"Error de datos","Validación de datos",errorContrasenia);
                return false;
            }
        }

        return true;
    }

    public boolean validarUsuario(String nameUser, String passw){
        DAOUsuario daoUsuario = new DAOUsuario();
        userLogin = daoUsuario.obtenerUsuario(nameUser);
        if(userLogin != null &&  BCrypt.checkpw(passw, userLogin.getContraseniaUsuario())){
            SessionData.setUsuarioLogueado(userLogin);
            return true;
        }else{
            SystemTools.createAlert(Alert.AlertType.ERROR,"Erro de datos","Usuario no encontrado","Verifique los datos ingresados");
            return false;
        }
    }
}
