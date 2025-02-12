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


public class PrincipalOficinistaController implements Avanzable {
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
        avanzar("", "gestion-turnos");
    }

    public void botonConsultaModificaionDatos(ActionEvent actionEvent) throws IOException {
        avanzar("", "consulta-modificacion");
    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
        BaseController.cerrarSesion(actionEvent);
    }

    @Override
    public void avanzar(String viewActual, String viewNueva) throws IOException {
        Scene scene = new Scene(loadFXML(viewNueva));
        App.getMainStage().setScene(scene);
    }
}