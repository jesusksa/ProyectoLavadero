package com.lavadero.controllers;
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
import lombok.Setter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import java.io.IOException;

import static com.lavadero.App.loadFXML;


public class PrincipalOficinistaController {
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

    public void botonGestionDeTurnos(ActionEvent actionEvent) {
        try {
            // Cargar el archivo FXML de la nueva ventana
            Parent newWindowRoot = FXMLLoader.load(getClass().getResource("/views/gestion-turnos.fxml"));

            // Crear un nuevo Stage para la nueva ventana
            Stage newWindowStage = new Stage();
            newWindowStage.setTitle("gestion-turnos");
            newWindowStage.setScene(new Scene(newWindowRoot));

            // Mostrar la nueva ventana
            newWindowStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void botonConsultaModificaionDatos(ActionEvent actionEvent) {
    }

}