package com.lavadero.controllers;

import com.lavadero.App;
import com.lavadero.model.Turno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static com.lavadero.App.loadFXML;

public class TurnosController {

    public TextArea txtBusqueda;
    @FXML
    private GridPane gridTurnos;

    int col = 0;
    int row = 0;

    private List<Turno> listaTurnos; // tus turnos de BD u origen

    @FXML
    public void initialize() throws IOException {
        // Generar un número aleatorio de turnos y agregarlos
        Random random = new Random();
        int numeroTurnos = random.nextInt(10) + 1; // Generar entre 1 y 10 turnos
        for (int i = 0; i < numeroTurnos; i++) {
            cargarTurnos();
        }
    }

    public void cargarTurnos() throws IOException {
        Parent view = App.loadFXML("turno-tarjeta");

        AnchorPane pnTurno = new AnchorPane();
        pnTurno.getChildren().setAll(view);

        // Añadir el Pane al GridPane
        gridTurnos.add(pnTurno, col, row);
        // Establecer márgenes de 10px alrededor del Pane


        // Calcular la siguiente posición (columnas: 0, 1, 2)
        col++;
        if (col >= 4) {
            col = 0;
            row++;
        }

    }

    public void registrarTurno(ActionEvent actionEvent) throws IOException {
        PrimaryController.avanzar("turnos","registro-turno-datos-turno",true);
    }

    public void filtrar(ActionEvent actionEvent) throws IOException {
        Stage stageEstado = new Stage();
        stageEstado.setMinWidth(600);
        stageEstado.setMinHeight(420);
        stageEstado.setMaxWidth(600);
        stageEstado.setMaxHeight(420);
        stageEstado.setMaximized(false);
        Scene sceneEstado = new Scene(loadFXML("filtros"));
        stageEstado.setTitle("Lavadero");
        Image icono = new Image(getClass().getResourceAsStream("/images/icono-ventana.png"));
        stageEstado.getIcons().add(icono);
        stageEstado.setScene(sceneEstado);
        stageEstado.show();
    }

    public void buscarTurno(ActionEvent actionEvent) {
    }

}
