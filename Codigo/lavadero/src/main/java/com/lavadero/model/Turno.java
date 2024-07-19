package com.lavadero.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "turno")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_turno", nullable = false)
    private Long idTurno;

    @Column(name = "fecha_turno")
    private LocalDate fechaTurno;

    @Column(name = "hora_ingreso")
    private LocalTime horaIngreso;

    @Column(name = "hora_finalizado")
    private LocalTime horaFinalizado;

    private int plataforma;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_servicio")
    private TipoServicio tipoServicio;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pago")
    private FormaPago formaPago;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_lavado")
    private EstadoLavado estado;

}