package com.lavadero.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import static com.lavadero.App.loadFXML;

public class InfoturnoController2 {
    public Label lbCliente;
    public Label lbVehiculo;
    public Label lbContacto;
    public Label lbDireccion;
    public Label lbMatricula;
    public Label lbFecha;
    public Label lbEstdo;
    public Label lbResponsables;
    public Label lbServicio;
    public Label lbFormaPago;

    private static Stage stageEstado;

    public void cambiarEstado(ActionEvent actionEvent) throws IOException {
        stageEstado = new Stage();
        stageEstado.setMaximized(false);
        Scene sceneEstado = new Scene(loadFXML("cambio-estado"));
        stageEstado.setTitle("Lavadero");
        Image icono = new Image(getClass().getResourceAsStream("/images/icono-ventana.png"));
        stageEstado.getIcons().add(icono);
        stageEstado.setScene(sceneEstado);
        stageEstado.show();
    }

    public void notificarTurno(ActionEvent actionEvent) throws IOException {
        ;
    }
}
