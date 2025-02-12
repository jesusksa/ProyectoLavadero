package com.lavadero.controllers;

import com.lavadero.model.EstadoLavado;
import com.lavadero.model.Turno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;

import java.io.IOException;
import java.util.Date;

public class ConsultaModificacionTurnosController implements Navegable, Avanzable{

    @FXML
    private TableView<RegistroTabla> tablaTurnos;
    @FXML
    private Button btnMasInformacion;
    @FXML
    private Button btnPrev;
    @FXML
    private Button btnNext;

    public class RegistroTabla {

        @Getter
        private final String id;
        @Getter
        private final Date fecha;
        @Getter
        private final EstadoLavado estadoLavado;
        @Getter
        private final String nombreCliente;
        @Getter
        private final String dniCliente;
        @Getter
        private final String matriculaVehiculo;
        @Getter
        private final Turno turno;

        public RegistroTabla(String id, Date fecha, EstadoLavado estadoLavado, String nombreCliente, String dniCliente, String matriculaVehiculo, Turno turno) {
            this.id = id;
            this.fecha = fecha;
            this.estadoLavado = estadoLavado;
            this.nombreCliente = nombreCliente;
            this.dniCliente = dniCliente;
            this.matriculaVehiculo = matriculaVehiculo;
            this.turno = turno;
        }
    }

    @FXML
    public void initialize(){

        //Seteo de columnas para la tabla
        TableColumn<RegistroTabla, String> colId = new TableColumn<>("Identificador");
        TableColumn<RegistroTabla, Date> colFecha = new TableColumn<>("Fecha");
        TableColumn<RegistroTabla, String> colEstadoLavado = new TableColumn<>("Estado lavado");
        TableColumn<RegistroTabla, String> colNombreCliente = new TableColumn<>("Nombre cliente");
        TableColumn<RegistroTabla, String> colDNICliente = new TableColumn<>("DNI cliente");
        TableColumn<RegistroTabla, String> colMatricula = new TableColumn<>("Matrícula vehículo");

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colEstadoLavado.setCellValueFactory(new PropertyValueFactory<>("estadoLavado"));
        colNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
        colDNICliente.setCellValueFactory(new PropertyValueFactory<>("dniCliente"));
        colMatricula.setCellValueFactory(new PropertyValueFactory<>("matriculaVehiculo"));

        tablaTurnos.getColumns().add(colId);
        tablaTurnos.getColumns().add(colFecha);
        tablaTurnos.getColumns().add(colEstadoLavado);
        tablaTurnos.getColumns().add(colNombreCliente);
        tablaTurnos.getColumns().add(colDNICliente);
        tablaTurnos.getColumns().add(colMatricula);

        //Se deshabilita el botón si no hay ningún registro de la tabla seleccionado
        btnMasInformacion.disableProperty().bind(tablaTurnos.getSelectionModel().selectedItemProperty().isNull());

        BaseController.controlarVisibilidad(btnPrev, btnNext);
    }

    @Override
    public void avanzar(String viewActual, String viewNueva) throws IOException {

    }

    @Override
    public void anteriorPag(ActionEvent actionEvent) throws IOException {
        BaseController.anteriorPag(actionEvent);
    }

    @Override
    public void home(ActionEvent actionEvent) throws IOException {
        BaseController.home(actionEvent);
    }

    @Override
    public void siguientePag(ActionEvent actionEvent) throws IOException {
        BaseController.siguientePag(actionEvent);
    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
        BaseController.cerrarSesion(actionEvent);
    }
}
