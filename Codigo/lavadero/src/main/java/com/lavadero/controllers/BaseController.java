package com.lavadero.controllers;

import com.lavadero.App;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Optional;

public class BaseController {
    public MenuItem mItmGesTurn;
    public MenuItem mItmRegTurn;
    public MenuItem mItmGesEmp;
    public MenuItem mItmAltaEmp;
    public MenuItem mItmBajaEmp;
    public MenuItem mItmInfo;
    public MenuItem mItemEditarCuenta;
    public MenuItem mItmSalir;
    public Pane panePrincipal;

    public void GestionarTurnos(ActionEvent actionEvent) {
    }

    public void RegistrarTurno(ActionEvent actionEvent) {
    }

    public void GestionarEmpleados(ActionEvent actionEvent) {
    }

    public void AltaEmpleado(ActionEvent actionEvent) {
    }

    public void BajaEmpleado(ActionEvent actionEvent) {
    }

    public void InformacionCuenta(ActionEvent actionEvent) {
    }

    public void EditarCuenta(ActionEvent actionEvent) {
    }

    public void CerrarSesion(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cerrar sesión");
        alert.setHeaderText("¿Estás seguro de que deseas cerrar sesión?");
        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.get() == ButtonType.OK) {
            App.setRoot("inicio-sesion");
        }
    }
}
