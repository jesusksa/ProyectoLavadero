package com.lavadero.controllers;
import com.lavadero.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lombok.Setter;


import java.io.IOException;

import static com.lavadero.App.loadFXML;


public class PrincipalOficinistaController {
    @Setter
    private static Stage stage;
    public Label titulo;
    public Button buttonG;
    public Button buttonCyM;
    public HBox boxButtons;
    public ImageView imageG;
    public ImageView imageCyM;
    public MenuButton mbtnCuenta;

    @FXML
    public void initialize() {
    }

    public void botonGestionDeTurnos(ActionEvent actionEvent) throws IOException {
    }

    public void botonConsultaModificaionDatos(ActionEvent actionEvent) throws IOException {
    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
    }

}