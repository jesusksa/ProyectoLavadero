package com.lavadero.controllers;


import javafx.event.ActionEvent;

import java.io.IOException;

/**
 * Interfaz que debe ser implementada por los controladores cuyas views contengan la botonera de navegación.
 * @see BaseController BaseController - contiene métodos estáticos que sirven de implementación para los métodos de la interfaz.
 */
public interface Navegable {

    /**
     * Corresponde al botón de "atrás" en la botonera de navegación (<).
     * @param actionEvent
     */
    public void anteriorPag(ActionEvent actionEvent) throws IOException;

    /**
     * Corresponde al botón de "home" en la botonera de navegación.
     * @param actionEvent
     */
    public void home(ActionEvent actionEvent) throws IOException;

    /**
     * Corresponde al botón de "adelante" en la botonera de navegación (>).
     * @param actionEvent
     */
    public void siguientePag(ActionEvent actionEvent) throws IOException;



}
