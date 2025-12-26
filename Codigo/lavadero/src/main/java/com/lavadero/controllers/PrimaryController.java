package com.lavadero.controllers;

import com.lavadero.App;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.Stack;

import static com.lavadero.App.loadFXML;

@Getter
public class PrimaryController {
    public AnchorPane pnFondo;
    public MenuButton mbtnCuenta;
    public AnchorPane apnContenido;

    @Setter
    private static String contenidoActual;
    @Getter
    private static Stack<String> pilaRetroceso = new Stack<>();
    @Getter
    private static Stack<String> pilaAvance = new Stack<>();

    private static PrimaryController instance;
    public Button btnPrev;
    public Button btnNext;

    public static PrimaryController getInstance() {
        return instance;
    }



    public void initialize() throws IOException {
        instance = this;
        mbtnCuenta.showingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                mbtnCuenta.getStyleClass().add("pressed");
            } else {
                mbtnCuenta.getStyleClass().remove("pressed");
            }
        });

        cargarContenido(App.loadFXML("turnos"));

        controlarVisibilidad(btnPrev,btnNext);

    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cerrar sesión");
        alert.setHeaderText("¿Seguro que desea abandonar la sesion iniciada?");
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK){
            Scene scene = new Scene(loadFXML("sesion"));
            App.getMainStage().setScene(scene);
        }else {
            alert.close();
        }
    }

    public void anteriorPag(ActionEvent actionEvent) throws IOException {
        //Controla que la pila para retroceder no está vacía
        if(!pilaRetroceso.isEmpty()){

            //Se añade la escena actual a la pila de avance
            pilaAvance.add(contenidoActual);

            //Se retira la última escena de la pila de retroceso
            contenidoActual = pilaRetroceso.pop();
            cargarContenido(App.loadFXML(contenidoActual));
            controlarVisibilidad(btnPrev,btnNext);
        }
    }

    public void home(ActionEvent actionEvent) throws IOException {
        pilaRetroceso.removeAllElements();
        pilaAvance.removeAllElements();

        cargarContenido(App.loadFXML("turnos"));
        controlarVisibilidad(btnPrev,btnNext);
    }

    public void siguientePag(ActionEvent actionEvent) throws IOException {
        //Controla que la pila para retroceder no está vacía
        if(!pilaAvance.isEmpty()){

            //Se añade la escena actual a la pila de retroceso
            pilaRetroceso.add(contenidoActual);

            //Se retira la última escena de la pila de avance
            contenidoActual = pilaAvance.pop();
            cargarContenido(App.loadFXML(contenidoActual));
            controlarVisibilidad(btnPrev,btnNext);
        }
    }

    public void cargarContenido(Parent p){
        apnContenido.getChildren().clear();
        apnContenido.getChildren().setAll(p);
        AnchorPane.setTopAnchor(p, 0.0);
        AnchorPane.setBottomAnchor(p, 0.0);
        AnchorPane.setLeftAnchor(p, 0.0);
        AnchorPane.setRightAnchor(p, 0.0);
    }

    public static void avanzar(String viewActual, String viewNueva, boolean addPila) throws IOException{
        //Estas sentencias permiten que se utilice la botonera de navegación de forma correcta.
        if(addPila){
            PrimaryController.getPilaRetroceso().add(viewActual);
        }
        PrimaryController.setContenidoActual(viewNueva);

        PrimaryController.getInstance().cargarContenido(App.loadFXML(viewNueva));

        controlarVisibilidad(PrimaryController.getInstance().btnPrev, PrimaryController.instance.btnNext);
    }

    public static void controlarVisibilidad(Button button1, Button button2){
        button1.setDisable(pilaRetroceso.isEmpty());
        button2.setDisable(pilaAvance.isEmpty());
    }
}
