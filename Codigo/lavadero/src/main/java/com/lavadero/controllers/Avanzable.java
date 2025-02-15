package com.lavadero.controllers;

import java.io.IOException;

/**
 * Interfaz que debe ser implementada por aquellos controladores que permitan pasar a otra view.
 * Si no se implementa esta interfaz, la botonera de navegación no funcionará.
 * @see Navegable Navegable - interfaz con métodos para implementar la botonera de navegación.
 */
public interface Avanzable {

    /**
     *
     * @param viewActual viewActual - Vista actual.
     * @param viewNueva viewNueva - Vista a la que se avanza.
     * @throws IOException
     */
    public void avanzar(String viewActual, String viewNueva) throws IOException;

}
