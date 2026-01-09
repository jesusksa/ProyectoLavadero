package com.lavadero.controllers;

import com.lavadero.App;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextArea;


import java.io.IOException;

public class CambioEstadoController2 {

    public AnchorPane apnContenidoAjusteEstado;
    public GridPane gdResponsables;
    public TextArea txtMotivoCancelacion;

    public void cambioAEspera(ActionEvent actionEvent){
    }

    public void cambioAProceso(ActionEvent actionEvent){
    }

    public void cambioAFinalizado(ActionEvent actionEvent) throws IOException {
        cargarContenidoCambiEstado(App.loadFXML("cambio-estado-finalizado"));
    }

    public void cambioACancelado(ActionEvent actionEvent) throws IOException {
        cargarContenidoCambiEstado(App.loadFXML("cambio-estado-cancelado"));
    }

    public void confirmarEdicionTurno(ActionEvent actionEvent){
    }

    public void confirmarFinalizacion(ActionEvent actionEvent){
    }

    public void confirmarCancelacion(ActionEvent actionEvent){
    }

    public void cargarContenidoCambiEstado(Parent p){
        apnContenidoAjusteEstado.getChildren().clear();
        apnContenidoAjusteEstado.getChildren().setAll(p);
        AnchorPane.setTopAnchor(p, 0.0);
        AnchorPane.setBottomAnchor(p, 0.0);
        AnchorPane.setLeftAnchor(p, 0.0);
        AnchorPane.setRightAnchor(p, 0.0);
    }

}
