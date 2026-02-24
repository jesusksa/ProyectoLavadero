package com.lavadero.util;

import com.lavadero.model.Cliente;
import com.lavadero.model.Turno;
import com.lavadero.model.Usuario;
import com.lavadero.model.Vehiculo;
import javafx.scene.control.Label;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class SessionData {




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
       DATOS DE SESIÓN
       ======================= */

    // Usuario que inició sesión
    @Setter
    @Getter
    private static Usuario usuarioLogueado;

    /* =======================
       TURNO
       ======================= */

    // Turno actualmente seleccionado
    @Setter
    @Getter
    private static Turno turno;

    public static void limpiarTurno() {
        turno = null;
    }

    @Setter
    @Getter
    private static Cliente cliente;

    public static void limpiarCliente(){cliente = null;}

    @Setter
    @Getter
    private static Vehiculo vehiculo;

    public static void limpiarVehiculo(){vehiculo = null;}

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
