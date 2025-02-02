package com.lavadero.controllers;
import com.lavadero.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    public MenuButton mbtnCuenta;

    @FXML
    private AnchorPane AnchorPrincipal;

    @FXML
    private VBox panel;

    @FXML
    public void initialize() {
        // Listener para detectar cuando el menú se despliega
        mbtnCuenta.showingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                mbtnCuenta.getStyleClass().add("pressed");
            } else {
                mbtnCuenta.getStyleClass().remove("pressed");
            }
        });
    }

    public void botonGestionDeTurnos(ActionEvent actionEvent) throws IOException {
        Scene scene = new Scene(loadFXML("gestion-turnos"));
        App.getMainStage().setScene(scene);
    }

    public void botonConsultaModificaionDatos(ActionEvent actionEvent) throws IOException {
        Scene scene = new Scene(loadFXML("consulta-modificacion"));
        App.getMainStage().setScene(scene);
    }

    public void buttonOficinista(ActionEvent actionEvent) {
    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
        BaseController.cerrarSesion(actionEvent);
    }
}