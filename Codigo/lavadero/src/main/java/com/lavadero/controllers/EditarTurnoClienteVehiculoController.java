package com.lavadero.controllers;

import com.lavadero.DAOS.DAOCliente;
import com.lavadero.DAOS.DAOVehiculo;
import com.lavadero.model.Cliente;
import com.lavadero.model.Vehiculo;
import com.lavadero.util.SessionData;
import com.lavadero.util.SystemNavigation;
import com.lavadero.util.SystemTools;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.io.IOException;
import java.util.List;

public class EditarTurnoClienteVehiculoController {
    //Pantalla de cliente y vehiculo
    public TextArea txtCliente;
    public Label lbNombreCliente;
    public Label lbDniCliente;
    public Label lbContactoCliente;
    public Label lbDomicilioCliente;

    public Button btnEditarCliente;
    public Button btnEditarVehiculo;

    public ChoiceBox cboxVehiculosCliente;
    public Label lbVehiculo;
    public Label lbModelo;
    public Label lbMatricula;

    public void initialize(){
        btnEditarCliente.setDisable(true);
        btnEditarVehiculo.setDisable(true);

        if (SessionData.getCliente() != null) {
            cargarCliente(SessionData.getCliente());
        }
        if(SessionData.getVehiculo() != null){
            cargarVehiculo(SessionData.getVehiculo());
        }
        cboxVehiculosCliente.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, vehiculoAnterior, vehiculoSeleccionado) -> {

                    if (vehiculoSeleccionado != null) {
                        SessionData.setVehiculo((Vehiculo) vehiculoSeleccionado);
                        cargarVehiculo(SessionData.getVehiculo());
                    }
                });

        cboxVehiculosCliente.setConverter(new StringConverter<Vehiculo>() {

            @Override
            public String toString(Vehiculo v) {
                if (v == null) {
                    return "";
                }
                return v.getPatente() + " - " + v.getModeloAuto();
            }

            @Override
            public Vehiculo fromString(String string) {
                return null; // No se usa
            }
        });


    }

    public void buscarCliente(ActionEvent actionEvent) {

        Integer dniABuscar = Integer.parseInt(txtCliente.getText());
        DAOCliente daoCliente = new DAOCliente();
        SessionData.setCliente(daoCliente.obtenerClientePorDni(dniABuscar));
        if (SessionData.getCliente() == null){
            btnEditarCliente.setDisable(true);
            SystemTools.createAlert(Alert.AlertType.ERROR,"Error de busqueda", "Cliente no encontrado", "Revise los datos ingresados");

        }else{

            cargarCliente(SessionData.getCliente());

            DAOVehiculo daoVehiculo = new DAOVehiculo();
            List<Vehiculo> vehiculos = daoVehiculo.obtenerVehiculosPorCliente(SessionData.getCliente());
            cboxVehiculosCliente.getItems().setAll(vehiculos);
        }

    }

    public void registrarCliente(ActionEvent actionEvent) throws IOException {
        SystemNavigation.avanzar("editar-cliente-vehiculo", "alta-cliente",true);
    }

    public void editarCliente(ActionEvent actionEvent) throws IOException {
        if(SessionData.getCliente() == null){
            SystemTools.createAlert(Alert.AlertType.ERROR, "Error", "No se ah seleccionado ningun cliente", "Por favor debe buscar un cliente");

        }else{
            SystemNavigation.avanzar("editar-cliente-vehiculo", "editar-cliente",true);
        }
    }

    public void registrarVehiculo(ActionEvent actionEvent) throws IOException {
        SystemNavigation.avanzar("editar-cliente-vehiculo", "alta-vehiculo",true);
    }

    public void editarVehiculo(ActionEvent actionEvent) throws IOException {
        if(SessionData.getVehiculo() == null) {
            SystemTools.createAlert(Alert.AlertType.ERROR, "Error", "No se ah seleccionado ningun vehiculo", "Por favor debe seleccionar un vehiculo");
        }else {
            SystemNavigation.avanzar("editar-cliente-vehiculo", "editar-vehiculo", true);
        }
    }

    public void continuar(ActionEvent actionEvent) throws IOException {
        if(SessionData.getCliente() == null) {
            SystemTools.createAlert(Alert.AlertType.ERROR, "Error de datos", "Falta de datos", "Debe seleccionar o registrar un cliente para continuar");

        }else if (SessionData.getVehiculo() == null){
            SystemTools.createAlert(Alert.AlertType.ERROR, "Error de datos", "Falta de datos", "Debe seleccionar o registrar un vehiculo para continuar");

        }else{
            SystemNavigation.cancelar();
        }
    }

    public void cancelar(ActionEvent actionEvent) throws IOException {
        SessionData.limpiarTurno();
        SessionData.limpiarCliente();
        SessionData.limpiarVehiculo();
        SystemNavigation.cancel();
    }

    public void cargarCliente(Cliente cliente){
        btnEditarCliente.setDisable(false);
        SystemTools.setearLabel(lbNombreCliente," "+cliente.formatearNombre());
        SystemTools.setearLabel(lbDniCliente," "+cliente.formatearDni());
        SystemTools.setearLabel(lbContactoCliente," "+cliente.getNumeroContacto());
        SystemTools.setearLabel(lbDomicilioCliente," "+cliente.getDomicilio());
    }

    public void cargarVehiculo(Vehiculo vehiculo){
        btnEditarVehiculo.setDisable(false);
        SystemTools.setearLabel(lbVehiculo," "+vehiculo.getTipoAuto().toString());
        SystemTools.setearLabel(lbModelo," "+vehiculo.getModeloAuto());
        SystemTools.setearLabel(lbMatricula," "+vehiculo.getPatente());
    }
}
