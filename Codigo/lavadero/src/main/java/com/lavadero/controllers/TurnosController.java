package com.lavadero.controllers;

import com.lavadero.App;
import com.lavadero.DAOS.DAOTurno;
import com.lavadero.model.Turno;
import com.lavadero.util.SessionData;
import com.lavadero.util.SystemNavigation;
import com.lavadero.util.SystemTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.List;

import static com.lavadero.App.loadFXML;

public class TurnosController {

    public TextArea txtBusqueda;
    @FXML
    private GridPane gridTurnos;
    @FXML
    private Button btnBorrarFiltros;

    int col = 0;
    int row = 0;

    @Setter
    @Getter
    private boolean filtro = false;

    @Setter
    @Getter
    private List<Turno> listaTurnos; // tus turnos de BD u origen

    @Setter
    @Getter
    public static TurnosController controlador;

    @FXML
    public void initialize() throws IOException {
        controlador = this;
        cargarTurnos();

    }

    public void cargarTurnos() throws IOException {
        gridTurnos.getChildren().clear();
        col = 0;
        row = 0;
        if(!filtro){
            DAOTurno daoTurno = new DAOTurno();
            listaTurnos = daoTurno.obtenerTurnosVigentes();
            btnBorrarFiltros.setVisible(false);
        }else{
            btnBorrarFiltros.setVisible(true);
        }

        for(Turno turno: listaTurnos){
            cargarTurno(turno);
        }
    }

    public  void cargarTurno(Turno turno) throws IOException {
        SessionData.setTurno(turno);

        Parent view = App.loadFXML("turno-tarjeta");

        AnchorPane pnTurno = new AnchorPane();
        pnTurno.getChildren().setAll(view);


        // Añadir el Pane al GridPane
        gridTurnos.add(pnTurno, col, row);
        // Establecer márgenes de 10px alrededor del Pane


        // Calcular la siguiente posición (columnas: 0, 1, 2)
        col++;
        if (col >= 3) {
            col = 0;
            row++;
        }
    }

    public void registrarTurno(ActionEvent actionEvent) throws IOException {
        SystemNavigation.avanzar("turnos","registro-turno-datos-turno",true);
    }

    public void filtrar(ActionEvent actionEvent) throws IOException {
        Stage stageEstado = new Stage();
        stageEstado.setMinWidth(600);
        stageEstado.setMinHeight(455);
        stageEstado.setMaxWidth(600);
        stageEstado.setMaxHeight(420);
        stageEstado.setMaximized(false);
        Scene sceneEstado = new Scene(loadFXML("filtros"));
        stageEstado.setTitle("Lavadero");
        Image icono = new Image(getClass().getResourceAsStream("/images/icono-ventana.png"));
        stageEstado.getIcons().add(icono);
        stageEstado.setScene(sceneEstado);
        stageEstado.initModality(Modality.APPLICATION_MODAL);

        // 🔑 CLAVE
        stageEstado.setOnHidden(ev -> {
            try {
                cargarTurnos();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        stageEstado.show();
    }

    public void desacerFiltros(ActionEvent actionEvent) throws IOException {
        filtro = false;
        cargarTurnos();
    }

    public void buscarTurno(ActionEvent actionEvent) throws IOException {
        if(txtBusqueda.getText().isEmpty()){
            SystemTools.createAlert(Alert.AlertType.ERROR,"Error de datos","Debe proporcionar un nombre","");
        }else{
            DAOTurno daoTurno = new DAOTurno();
            listaTurnos = daoTurno.obtenerTurnosPorNombre(txtBusqueda.getText());
            if(listaTurnos == null){
                SystemTools.createAlert(Alert.AlertType.ERROR,"Error de datos","No se encontro cliente asociado","Verifique los datos ingresados");
            }else{
                filtro = true;
                txtBusqueda.clear();
                cargarTurnos();
            }
        }
    }

}
