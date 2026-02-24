package com.lavadero.util;

import com.lavadero.App;
import com.lavadero.controllers.PrimaryController;
import java.util.Stack;
import javafx.event.ActionEvent;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;



public class SystemNavigation {

    /* ===============================
       VARIABLES (MISMO NOMBRE)
       =============================== */
    @Setter
    @Getter
    private static Stack<String> pilaRetroceso = new Stack<>();
    @Setter
    @Getter
    private static Stack<String> pilaAvance = new Stack<>();
    @Setter
    @Getter
    private static String contenidoActual;
    @Setter
    @Getter
    private static PrimaryController primaryController = PrimaryController.getInstance();


    /* ===============================
       MÉTODOS (MISMO NOMBRE)
       =============================== */

    public static void anteriorPag(boolean addPila) throws IOException {
        if (!pilaRetroceso.isEmpty()) {
            if (addPila) {
                pilaAvance.add(contenidoActual);
            }
            contenidoActual = pilaRetroceso.pop();
            primaryController.cargarContenido(App.loadFXML(contenidoActual));
            primaryController.controlarVisibilidad();
        }
    }

    public static void inicio    () throws IOException {
        pilaRetroceso.removeAllElements();
        pilaAvance.removeAllElements();
        primaryController.cargarContenido(App.loadFXML("turnos"));
        primaryController.controlarVisibilidad();
    }

    public static void siguientePag(boolean addPila) throws IOException {
        if (!pilaAvance.isEmpty()) {
            if(addPila) {
                pilaRetroceso.add(contenidoActual);
            }
            contenidoActual = pilaAvance.pop();
            primaryController.cargarContenido(App.loadFXML(contenidoActual));
            primaryController.controlarVisibilidad();
        }
    }

    public static void avanzar(String viewActual, String viewNueva, boolean addPila) throws IOException {

        if (addPila) {
            pilaRetroceso.add(viewActual);
        }

        contenidoActual = viewNueva;

        primaryController.cargarContenido(App.loadFXML(viewNueva));
        primaryController.controlarVisibilidad();
    }

    public static void cancelar() throws IOException {

        if (!getPilaRetroceso().isEmpty()) {

            setContenidoActual(getPilaRetroceso().pop());

            primaryController.cargarContenido(App.loadFXML(getContenidoActual()));

            primaryController.controlarVisibilidad();
        }
    }

    public  static void cancel() throws IOException {
        pilaRetroceso.removeAllElements();
        pilaAvance.removeAllElements();

        primaryController.cargarContenido(App.loadFXML("turnos"));
        primaryController.controlarVisibilidad();
    }

}

