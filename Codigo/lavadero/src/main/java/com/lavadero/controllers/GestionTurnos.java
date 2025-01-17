package com.lavadero.controllers;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GestionTurnos {
    public GridPane gridTurnos;
    private int currentRow = 0; // Para rastrear la fila actual en el GridPane
    private int currentColumn = 0; // Para rastrear la columna actual en la fila

    public void RegistrarTurno(ActionEvent actionEvent) {
        CargarTurnos();
    }

    public void AnteriorPag(ActionEvent actionEvent) {
    }

    public void Home(ActionEvent actionEvent) {
    }

    public void SiguientePag(ActionEvent actionEvent) {
    }

    public void CargarTurnos(){
        // Crear un nuevo Pane y configurar sus hijos
        Pane pnTurno = new Pane();
        pnTurno.setPrefSize(160.0, 160.0);
        pnTurno.setStyle("-fx-background-color: white;");

        //Label de Cliente
        Label lbCliente = new Label("Cliente: Trafalgar D Water Law");
        lbCliente.setLayoutX(15);
        lbCliente.setLayoutY(15);

        //Label de Matricula
        Label lbMatricula = new Label("Matrícula: 11MDL");
        lbMatricula.setLayoutX(15);
        lbMatricula.setLayoutY(35);

        //label de Vehiculo
        Label lbVehiculo = new Label("Tipo de vehículo: utilitario");
        lbVehiculo.setLayoutX(15);
        lbVehiculo.setLayoutY(55);

        //Label de Lavado
        Label lbLavado = new Label("Tipo de lavado: completo");
        lbLavado.setLayoutX(15);
        lbLavado.setLayoutY(75);

        //Label de Estado
        Label lbEstado = new Label("Estado: en espera");
        lbEstado.setLayoutX(15);
        lbEstado.setLayoutY(95);

        //Circulo de Estado
        Circle cleEstado = new Circle();
        cleEstado.setRadius(10); // Radio del círculo
        cleEstado.setLayoutX(140); // Posición X
        cleEstado.setLayoutY(105); // Posición Y
        cleEstado.setFill(Color.web("#00ff26")); // Color en formato hexadecimal
        cleEstado.setOpacity(1.0); // Opacidad total

        //Boton de Mas info
        Button btnInfo = new Button();
        btnInfo.setLayoutX(280);
        btnInfo.setLayoutY(50);
        btnInfo.setPrefSize(40.0, 40.0);
        btnInfo.setStyle(
                "-fx-background-color: #57C4E5; " +      // Color inicia
                        "-fx-background-radius: 20px; " +         // Radio de los bordes
                        "-fx-text-fill: white; "                  // Color del texto (opcional)
        );
        // Cambiar el color cuando el mouse entra
        btnInfo.setOnMouseEntered(event -> {
            btnInfo.setStyle(
                    "-fx-background-color: #4EA3BC; " +     // Nuevo color cuando el mouse está sobre el botón
                            "-fx-background-radius: 20px; " +         // Mantener el radio de los bordes
                            "-fx-text-fill: white; "                  // Mantener el color del texto
            );
        });
        // Restaurar el color original cuando el mouse sale
        btnInfo.setOnMouseExited(event -> {
            btnInfo.setStyle(
                    "-fx-background-color: #57C4E5; " +      // Color original
                            "-fx-background-radius: 20px; " +         // Mantener el radio de los bordes
                            "-fx-text-fill: white; "                  // Mantener el color del texto
            );
        });
        ImageView icon = new ImageView(new Image(getClass().getResource("/images/icono-interrogante2.png").toExternalForm()));
        icon.setFitHeight(30.0);
        icon.setFitWidth(30.0);
        btnInfo.setGraphic(icon);

        // Añadir los hijos al Pane
        pnTurno.getChildren().addAll(lbCliente, lbMatricula, lbVehiculo, lbLavado, lbEstado, cleEstado, btnInfo);

        // Añadir el Pane al GridPane
        gridTurnos.add(pnTurno, currentColumn, currentRow);
        // Establecer márgenes de 10px alrededor del Pane
        GridPane.setMargin(pnTurno, new Insets(10, 10, 10, 10));

        // Calcular la siguiente posición (columnas: 0, 1, 2)
        currentColumn++;
        if (currentColumn >= 3) {
            currentColumn = 0;
            currentRow++;
        }
    }
}
