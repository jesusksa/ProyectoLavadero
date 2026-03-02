package com.lavadero.controllers;


import com.lavadero.DAOS.DAOTurno;
import com.lavadero.model.FormaPago;
import com.lavadero.model.TipoServicio;
import com.lavadero.util.CalendarioSistema;
import com.lavadero.util.SessionData;
import com.lavadero.util.SystemNavigation;
import com.lavadero.util.SystemTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public class EditarTurnoController {

    @FXML
    private DatePicker dateFecha;
    @FXML
    private ChoiceBox cboxHora;
    @FXML
    private ChoiceBox cboxLavado;
    @FXML
    private ChoiceBox cboxPago;

    public void initialize(){
        cboxLavado.getItems().setAll(SystemTools.formatearTipoLavado());
        cboxPago.getItems().setAll(SystemTools.formatearFormaPago());

        dateFecha.setValue(SessionData.getTurno().getFechaTurno());
        cboxHora.setValue(SessionData.getTurno().getHoraTurno());
        cargarHorasDisponibles(SessionData.getTurno().getFechaTurno());
        cboxLavado.setValue(SessionData.getTurno().formatearServicio());
        cboxPago.setValue(SessionData.getTurno().formatearPago());


        dateFecha.setEditable(false); // evita que escriban a mano

        dateFecha.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);

                if (empty || date == null) {
                    setDisable(true);
                    return;
                }

                // Bloquear días pasados
                if (date.isBefore(LocalDate.now())) {
                    setDisable(true);
                    return;
                }

                // Bloquear sábados y domingos
                DayOfWeek dia = date.getDayOfWeek();
                if (dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY) {
                    setDisable(true);
                    setStyle("-fx-background-color: #e0e0e0; -fx-text-fill: #9e9e9e;");
                    return;
                }
            }
        });

        // 2️⃣ Cuando cambia la fecha → recalcular horas
        dateFecha.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (newDate != null) {
                cargarHorasDisponibles(newDate);
            }
        });
    }

    public void cancelar(ActionEvent actionEvent) throws IOException {
        SystemNavigation.cancelar();
    }

    public void confirmar(ActionEvent actionEvent) throws IOException {
        if(dateFecha.getValue() == null){
            SystemTools.createAlert(Alert.AlertType.ERROR,
                    "Información",
                    "Todos los campos son obligatorios",
                    "El campo fecha esta vacio, por favor seleccione una fecha");

        }else if(cboxHora.getValue() == null){
            SystemTools.createAlert(Alert.AlertType.ERROR,
                    "Información",
                    "Todos los campos son obligatorios",
                    "El campo hora esta vacio, por favor seleccione una hora");

        }else if(cboxPago.getValue() == null){
            SystemTools.createAlert(Alert.AlertType.ERROR,
                    "Información",
                    "Todos los campos son obligatorios",
                    "El campo forma de pago esta vacio, por favor selecionar una forma de pago");

        }else if(cboxLavado.getValue() == null){
            SystemTools.createAlert(Alert.AlertType.ERROR,
                    "Información",
                    "Todos los campos son obligatorios",
                    "El campo servicio esta vacio, por favor selecionar un tipo de servicio");

        }else{
            SessionData.getTurno().setFechaTurno(dateFecha.getValue());
            SessionData.getTurno().setHoraTurno((LocalTime) cboxHora.getValue());
            SessionData.getTurno().setTipoServicio(SystemTools.formatearTipoLavado(cboxLavado.getValue().toString()));
            SessionData.getTurno().setFormaPago(SystemTools.formatearFormapago(cboxPago.getValue().toString()));

            SystemNavigation.anteriorPag(false);
        }
    }

    private void cargarHorasDisponibles(LocalDate fecha) {

        cboxHora.getItems().clear();

        // Horas laborales del sistema (invierno / verano)
        List<LocalTime> horasLaborales =
                CalendarioSistema.horasLaborales(fecha);

        // Horas que ya están completas (2 turnos)
        DAOTurno daoTurno = new DAOTurno();
        List<LocalTime> horasNoDisponibles =
                daoTurno.obtenerHorasNoDisponiblesPorDia(fecha);

        // A - B → horas disponibles
        horasLaborales.removeAll(horasNoDisponibles);

        cboxHora.getItems().addAll(horasLaborales);
    }
}
