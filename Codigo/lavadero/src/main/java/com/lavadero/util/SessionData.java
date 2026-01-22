package com.lavadero.util;

import com.lavadero.model.Turno;
import com.lavadero.model.Usuario;

import java.time.LocalDate;

public class SessionData {

    /* =======================
       DATOS DE SESIÓN
       =======================

    // Usuario que inició sesión
    private static Usuario usuarioLogueado;

    // Fecha seleccionada en vistas de turnos
    private static LocalDate fechaSeleccionada;

    // Rol / permisos
    private static boolean esAdmin;

    /* =======================
       USUARIO
       =======================

    public static Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public static void setUsuarioLogueado(Usuario usuario) {
        usuarioLogueado = usuario;
        esAdmin = usuario != null && usuario.isAdmin(); // ajustá según tu modelo
    }

    public static boolean isAdmin() {
        return esAdmin;
    }
    */

    /* =======================
       TURNO
       ======================= */

    // Turno actualmente seleccionado
    private static Turno turnoActual;

    public static Turno getTurnoActual() {
        return turnoActual;
    }

    public static void setTurnoActual(Turno turno) {
        turnoActual = turno;
    }

    public static void limpiarTurno() {
        turnoActual = null;
    }


    /* =======================
       FECHA / FILTROS
       =======================

    public static LocalDate getFechaSeleccionada() {
        return fechaSeleccionada;
    }

    public static void setFechaSeleccionada(LocalDate fecha) {
        fechaSeleccionada = fecha;
    }

    /* =======================
       LIMPIEZA TOTAL (LOGOUT)
       =======================

    public static void clear() {
        usuarioLogueado = null;
        turnoActual = null;
        fechaSeleccionada = null;
        esAdmin = false;
    }
    */

    private SessionData() {
        // Evita instanciación
    }
}
