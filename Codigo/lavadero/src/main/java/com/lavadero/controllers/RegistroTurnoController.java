package com.lavadero.controllers;

import com.lavadero.model.FormaPago;
import com.lavadero.model.TipoServicio;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistroTurnoController {
    public ChoiceBox cboxLavado;
    public ChoiceBox cboxPago;
    public MenuButton mbtnCuenta;
    public ChoiceBox cboxHora;
    private static List<String> horarioInvierno = List.of("08Hs", "09Hs", "10Hs", "11Hs", "12Hs", "13Hs", "14Hs", "15Hs", "16Hs");
    private static List<String> horarioVerano = List.of("07Hs", "08Hs", "09Hs", "10Hs", "11Hs", "12Hs", "17Hs", "18Hs", "19Hs", "20Hs", "21Hs");
    public DatePicker dateFecha;
    public Button btnPrev;
    public Button btnNext;
    private int mesActual = LocalDate.now().getMonthValue();


    public void initialize(){
        cboxLavado.getItems().addAll(TipoServicio.values());
        cboxPago.getItems().addAll(FormaPago.values());

        cboxHora.getItems().addAll(temporada()); //Aun hay que comprobar las horas disponibles

        // Listener para detectar cuando el menú se despliega
        mbtnCuenta.showingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                mbtnCuenta.getStyleClass().add("pressed");
            } else {
                mbtnCuenta.getStyleClass().remove("pressed");
            }
        });
        BaseController.controlarVisibilidad(btnPrev, btnNext);
    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
        BaseController.cerrarSesion(actionEvent);
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

    public void Cancelar(ActionEvent actionEvent) throws IOException {
        GestionTurnosController.stageRegistro.close();
    }

    public void Continuar(ActionEvent actionEvent) throws IOException {

        /*
        * crear losprimeros datos del turno
        * verificar fecha y hora cada momento
        * */
        BaseController.avanzar("registro-turno-datos-turno","registro-turno-datos-cliente",false);
    }

    public List temporada(){
        if (mesActual >= 3 && mesActual <= 8){
            return horarioInvierno;
        }else{
            return horarioVerano;
        }
    }
}
