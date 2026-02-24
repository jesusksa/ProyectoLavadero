package com.lavadero.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarioSistema {

    private static final int PLATAFORMAS = 2;

    //Nuevas cosas q agrega chatgpt

    public static int maxTurnosPorDia(LocalDate fecha) {
        return  horasLaborales(fecha).size() * PLATAFORMAS;
    }


    //Primera version de chatgpt

    /* ======================
       TEMPORADA
       ====================== */

    public static boolean esVerano(LocalDate fecha) {
        int mes = fecha.getMonthValue();
        // Primavera + Verano
        return (mes >= 9 && mes <= 12) || (mes >= 1 && mes <= 2);
    }

    /* ======================
       HORARIOS
       ====================== */

    public static List<LocalTime> horasLaborales(LocalDate fecha) {
        return esVerano(fecha)
                ? horarioVerano()
                : horarioInvierno();
    }

    private static List<LocalTime> horarioInvierno() {
        // 08 a 16 (inclusive)
        return generarRangoHoras(8, 15);
    }

    private static List<LocalTime> horarioVerano() {
        List<LocalTime> horas = new ArrayList<>();
        horas.addAll(generarRangoHoras(7, 11));
        horas.addAll(generarRangoHoras(17, 20));
        return horas;
    }

    private static List<LocalTime> generarRangoHoras(int desde, int hasta) {
        List<LocalTime> horas = new ArrayList<>();
        for (int h = desde; h <= hasta; h++) {
            horas.add(LocalTime.of(h, 0));
        }
        return horas;
    }

    public static boolean tieneHorarioLaboral(LocalDate date) {
        return true;
    }
}

