package com.lavadero.controllers;

import com.lavadero.App;
import com.lavadero.DAOS.DAOEmpelado;
import com.lavadero.DAOS.DAOTurno;
import com.lavadero.model.Empleado;
import com.lavadero.model.EstadoLavado;
import com.lavadero.util.SessionData;
import com.lavadero.util.SystemTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CambioEstadoFinalizadoController {

    @FXML
    public TilePane tileEmpleados;
    @FXML
    private Button btnConfirmar;

    private List<Empleado> empleados;
    private final List<CheckBox> checkBoxes = new ArrayList<>();

    public void initialize(){
        DAOEmpelado daoEmpelado = new DAOEmpelado();
        empleados = daoEmpelado.obtenerTodos();
        cargarCheckBoxEmpleados();
    }

    public void confirmarFinalizacion(ActionEvent actionEvent) throws IOException {
        if(SystemTools.createAlertConfirm("Cambio de Estado","¿Seguro que quiere cambiar a estado 'Finalizado'?","")){
            List<Empleado> empleados = new ArrayList<>();

            for (CheckBox cb : checkBoxes) {
                if (cb.isSelected()) {
                    empleados.add((Empleado) cb.getUserData());
                }
            }


            SessionData.getTurno().setEmpleados(empleados);
            SessionData.getTurno().setHoraFinalizado(LocalTime.now());
            SessionData.getTurno().setEstado(EstadoLavado.FINALIZADO);

            DAOTurno daoTurno = new DAOTurno();
            daoTurno.actualizar(SessionData.getTurno());
            SystemTools.createAlert(Alert.AlertType.INFORMATION,"Actualización","Se actualizo el estado del turno correctamente","");
            Stage stage = (Stage) btnConfirmar.getScene().getWindow();
            stage.close();
        }else {
            CambioEstadoController.getInstance().cargarContenidoCambiEstado(App.loadFXML("cambio-estado"));
        }
    }

    private void cargarCheckBoxEmpleados() {
        for (Empleado e : empleados) {
            CheckBox cb = new CheckBox(e.formatearNombre());

            // guardamos el objeto Empleado dentro del checkbox
            cb.setUserData(e);

            cb.setPrefWidth(220);
            tileEmpleados.getChildren().add(cb);
            checkBoxes.add(cb);
        }
    }


}
