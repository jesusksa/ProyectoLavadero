package com.lavadero.controllers;
import com.lavadero.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import lombok.Setter;


import java.io.IOException;

import java.io.IOException;

import static com.lavadero.App.loadFXML;


public class PrincipalOficinistaController {
    @Setter
    private static Stage stage;
    public ImageView imgeUsuario;
    public Label titulo;
    public Button buttonG;
    public Button buttonCyM;
    public HBox boxButtons;
    public ImageView imageG;
    public ImageView imageCyM;

    @FXML
    private AnchorPane AnchorPrincipal;

    @FXML
    private VBox panel;

    @FXML
    private Button buttonOficinista;

    public void botonGestionDeTurnos(ActionEvent actionEvent) throws IOException {
        Scene scene = new Scene(loadFXML("gestion-turnos"));
        App.getMainStage().setScene(scene);
    }

    public void botonConsultaModificaionDatos(ActionEvent actionEvent) {
    }

    public void buttonOficinista(ActionEvent actionEvent) {
    }
}