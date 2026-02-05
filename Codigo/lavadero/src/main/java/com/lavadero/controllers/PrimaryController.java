package com.lavadero.controllers;

import com.lavadero.App;
import com.lavadero.util.SessionData;
import com.lavadero.util.SystemNavigation;
import com.lavadero.util.SystemTools;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.Stack;

import static com.lavadero.App.loadFXML;

public class PrimaryController {
    public AnchorPane pnFondo;
    public MenuButton mbtnCuenta;
    public AnchorPane apnContenido;

    @Setter
    @Getter
    private static PrimaryController instance;
    public Button btnPrev;
    public Button btnNext;



    public void initialize() throws IOException {
        instance = this;
        SystemNavigation.setPrimaryController(this);
        mbtnCuenta.showingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                mbtnCuenta.getStyleClass().add("pressed");
            } else {
                mbtnCuenta.getStyleClass().remove("pressed");
            }
        });

        cargarContenido(App.loadFXML("turnos"));

        controlarVisibilidad();


    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {

        if (SystemTools.createAlertConfirm("Cerrar sesión","¿Seguro que desea abandonar la sesion iniciada?","")){
            Scene scene = new Scene(loadFXML("sesion"));
            App.getMainStage().setScene(scene);
        }
    }

    public void anteriorPag(ActionEvent actionEvent) throws IOException {
        SystemNavigation.anteriorPag(true);
        controlarVisibilidad();
    }

    public void home(ActionEvent actionEvent) throws IOException {
        SessionData.limpiarTurno();
        SessionData.limpiarVehiculo();
        SessionData.limpiarCliente();
        SystemNavigation.inicio();
        controlarVisibilidad();
    }

    public void siguientePag(ActionEvent actionEvent) throws IOException {
        SystemNavigation.siguientePag(true);
        controlarVisibilidad();
    }

    public void cargarContenido(Parent p){
        apnContenido.getChildren().clear();
        apnContenido.getChildren().setAll(p);
        AnchorPane.setTopAnchor(p, 0.0);
        AnchorPane.setBottomAnchor(p, 0.0);
        AnchorPane.setLeftAnchor(p, 0.0);
        AnchorPane.setRightAnchor(p, 0.0);
    }

    public void avanzar(String viewActual, String viewNueva, boolean addPila) throws IOException{
        SystemNavigation.avanzar(viewActual,viewNueva,addPila);
        PrimaryController.getInstance().cargarContenido(App.loadFXML(viewNueva));
        controlarVisibilidad();
    }

    public void controlarVisibilidad(){
        btnPrev.setDisable(SystemNavigation.getPilaRetroceso().isEmpty());
        btnNext.setDisable(SystemNavigation.getPilaAvance().isEmpty());
    }
}
