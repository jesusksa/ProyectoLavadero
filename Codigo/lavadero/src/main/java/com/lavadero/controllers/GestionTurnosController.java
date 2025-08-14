package com.lavadero.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

import static com.lavadero.App.loadFXML;

public class GestionTurnosController implements Navegable, Avanzable{
    public static Stage stageRegistro;
    public GridPane gridTurnos;
    public MenuButton mbtnCuenta;
    public ScrollPane scllTurnos;
    private int currentRow = 0; // Para rastrear la fila actual en el GridPane
    private int currentColumn = 0; // Para rastrear la columna actual en la fila
    @FXML
    private Button btnPrev;
    @FXML
    private Button btnNext;

    @FXML
    private void initialize() {
        // Listener para detectar cuando el menú se despliega
        mbtnCuenta.showingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                mbtnCuenta.getStyleClass().add("pressed");
            } else {
                mbtnCuenta.getStyleClass().remove("pressed");
            }
        });

        // Generar un número aleatorio de turnos y agregarlos
        Random random = new Random();
        int numeroTurnos = random.nextInt(10) + 1; // Generar entre 1 y 10 turnos
        for (int i = 0; i < numeroTurnos; i++) {
            cargarTurnos();
        }

        //Se controla que las pilas de avanzar y retroceder no estén vacías y se deshabilita el botón en dicho caso
        BaseController.controlarVisibilidad(btnPrev, btnNext);
    }

    public void registrarTurno(ActionEvent actionEvent) throws IOException {
        stageRegistro = new Stage();
        Scene sceneRegistro = new Scene(loadFXML("registro-turno-datos-turno"));
        stageRegistro.setTitle("Lavadero");
        Image icono = new Image(getClass().getResourceAsStream("/images/icono-ventana.png"));
        stageRegistro.getIcons().add(icono);
        stageRegistro.setScene(sceneRegistro);
        stageRegistro.show();
    }

    public void anteriorPag(ActionEvent actionEvent) throws IOException {
        BaseController.anteriorPag(actionEvent);
    }

    public void home(ActionEvent actionEvent) throws IOException {
        BaseController.home(actionEvent);
    }

    public void siguientePag(ActionEvent actionEvent) throws IOException {
        BaseController.siguientePag(actionEvent);
    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
        BaseController.cerrarSesion(actionEvent);
    }

    public void filtrar(ActionEvent actionEvent) {
    }

    public void cargarTurnos(){
        // Crear un nuevo Pane y configurar sus hijos
        Pane pnTurno = new Pane();
        pnTurno.setPrefSize(100.0, 160.0);
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
        btnInfo.setLayoutX(250);
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
        btnInfo.setOnAction(actionEvent -> {

            try {
                avanzar("gestion-turnos", "info-turnos");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
        if (currentColumn >= 4) {
            currentColumn = 0;
            currentRow++;
        }
    }


    @Override
    public void avanzar(String viewActual, String viewNueva) throws IOException {
        BaseController.avanzar(viewActual, viewNueva,true);
    }
}
