package com.lavadero.model;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Turno {
    private int idTurno;
    private LocalDate fechaTurno;
    private LocalTime horaIngreso;
    private LocalTime horaFinalizado;
    private int plataforma;
    private TipoServicio tipoServicio;
    private FormaPago formaPago;
    private EstadoLavado estado;

    

    
}