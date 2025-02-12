package com.lavadero.controllers;

import com.lavadero.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

import static com.lavadero.App.loadFXML;

public class BaseController {

    @Setter
    private static String escenaActual;
    @Getter
    private static Stack<String> pilaRetroceso = new Stack<>();
    @Getter
    private static Stack<String> pilaAvance = new Stack<>();


    public MenuButton mbtnCuenta;

    @FXML
    public void initialize() {
        // Listener para detectar cuando el menú se despliega
        mbtnCuenta.showingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                mbtnCuenta.getStyleClass().add("pressed");
            } else {
                mbtnCuenta.getStyleClass().remove("pressed");
            }
        });
    }

    /**
     * Posible implementación para el método con el mismo nombre de la interfaz Navegable.
     * @param actionEvent
     * @throws IOException
     * @throws EmptyStackException
     */
    public static void anteriorPag(ActionEvent actionEvent) throws IOException, EmptyStackException {

        //Controla que la pila para retroceder no está vacía
        if(!pilaRetroceso.isEmpty()){

            //Se añade la escena actual a la pila de avance
            pilaAvance.add(escenaActual);

            //Se retira la última escena de la pila de retroceso
            escenaActual = pilaRetroceso.pop();
            Scene scene = new Scene(loadFXML(escenaActual));
            App.getMainStage().setScene(scene);
        }
    }

    /**
     * Posible implementación para el método con el mismo nombre de la interfaz Navegable.
     * @param actionEvent
     * @throws IOException
     * @throws EmptyStackException
     */
    public static void home(ActionEvent actionEvent) throws IOException {
        pilaRetroceso.removeAllElements();
        pilaAvance.removeAllElements();

        Scene scene = new Scene(loadFXML("principal-oficinista"));
        App.getMainStage().setScene(scene);
    }

    /**
     * Posible implementación para el método con el mismo nombre de la interfaz Navegable.
     * @param actionEvent
     * @throws IOException
     * @throws EmptyStackException
     */
    public static void siguientePag(ActionEvent actionEvent) throws IOException, EmptyStackException {

        //Controla que la pila para retroceder no está vacía
        if(!pilaAvance.isEmpty()){

            //Se añade la escena actual a la pila de retroceso
            pilaRetroceso.add(escenaActual);

            //Se retira la última escena de la pila de avance
            escenaActual = pilaAvance.pop();
            Scene scene = new Scene(loadFXML(escenaActual));
            App.getMainStage().setScene(scene);
        }
    }

    public static void cerrarSesion(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cerrar sesión");
        alert.setHeaderText("¿Seguro que desea abandonar la sesion iniciada?");
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK){
            Scene scene = new Scene(loadFXML("inicio-sesion"));
            App.getMainStage().setScene(scene);
        }else {
            alert.close();
        }
    }

    public static void controlarVisibilidad(Button button1, Button button2){
        button1.setDisable(pilaRetroceso.isEmpty());
        button2.setDisable(pilaAvance.isEmpty());
    }

    /**
     * Posible implementación para el método con el mismo nombre de la interfaz Avanzable.
     * @param viewActual viewActual - Nombre de la view desde la cual se invoca este método.
     * @param viewNueva viewNueva - Nombre de la view a la cual se avanzará.
     * @throws IOException
     */
    public static void avanzar(String viewActual, String viewNueva) throws IOException{
        //Estas sentencias permiten que se utilice la botonera de navegación de forma correcta.
        BaseController.getPilaRetroceso().add(viewActual);
        BaseController.setEscenaActual(viewNueva);

        Scene scene = new Scene(loadFXML(viewNueva));
        App.getMainStage().setScene(scene);
    }

}
