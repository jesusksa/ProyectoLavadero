package com.lavadero.controllers;

import com.lavadero.DAOS.DAOTurno;
import com.lavadero.model.EstadoLavado;
import com.lavadero.model.TipoAuto;
import com.lavadero.model.TipoServicio;
import com.lavadero.model.Turno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FiltroTurnosController {
    @FXML
    public TextField txtDni;
    @FXML
    public ComboBox<EstadoLavado> cboxEstado;
    @FXML
    public ComboBox<TipoAuto> cboxVehiculo;
    @FXML
    public ComboBox<TipoServicio> cboxServicio;
    @FXML
    public DatePicker dtFecha;
    @FXML
    public TextField txtMatricula;
    @FXML
    private Button btnFiltrar;

    public void initialize(){
        cboxEstado.getItems().setAll(EstadoLavado.values());
        cboxServicio.getItems().setAll(TipoServicio.values());
        cboxVehiculo.getItems().setAll(TipoAuto.values());
    }

    public void filtrar(ActionEvent actionEvent) {
        DAOTurno daoTurno = new DAOTurno();
        List<Turno> turnosFiltrados = daoTurno.obtenerTurnosFiltrados(txtDni.getText(),
                                        txtMatricula.getText(),
                                        cboxServicio.getValue(),
                                        cboxEstado.getValue(),
                                        cboxVehiculo.getValue(),
                                        dtFecha.getValue());

        TurnosController.getControlador().setFiltro(true);
        TurnosController.getControlador().setListaTurnos(turnosFiltrados);
        Stage stage = (Stage) btnFiltrar.getScene().getWindow();
        stage.close();
    }
}
