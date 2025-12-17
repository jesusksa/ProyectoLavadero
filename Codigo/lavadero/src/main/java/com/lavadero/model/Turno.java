package com.lavadero.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "turno")
@Table(indexes = {
        @Index(name = "idx_turno_hora_finalizado", columnList = "hora_finalizado")
})
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno", nullable = false, updatable = false)
    private Long idTurno;

    @Column(name = "fecha_turno", nullable = false)
    private LocalDate fechaTurno;

    @Column(name = "hora_ingreso") //nullable = false luego
    private LocalTime horaIngreso;

    @Column(name = "hora_finalizado")
    private LocalTime horaFinalizado;

    @Column(nullable = false)
    private int plataforma;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_servicio", nullable = false)
    private TipoServicio tipoServicio;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pago", nullable = false)
    private FormaPago formaPago;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_lavado", nullable = false)
    private EstadoLavado estado;

    @Column(name = "motivo_cancelado")
    private String motivo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "turno_empleado",
            joinColumns = @JoinColumn(name = "id_turno"),
            inverseJoinColumns = @JoinColumn(name = "id_empleado")
    )
    private List<Empleado> empleados = new ArrayList<>(2);

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_vehiculo",nullable = false)
    private Vehiculo vehiculo;

    public Turno(LocalDate fechaTurno, TipoServicio tipoServicio, FormaPago formaPago, Cliente cliente, Vehiculo vehiculo) {
        this.fechaTurno = fechaTurno;
        this.tipoServicio = tipoServicio;
        this.formaPago = formaPago;
        this.estado = EstadoLavado.ESPERA;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }

    public Turno(LocalDate fechaTurno, TipoServicio tipoServicio, FormaPago formaPago, Cliente cliente, Usuario usuario, Vehiculo vehiculo) {
        this.fechaTurno = fechaTurno;
        this.tipoServicio = tipoServicio;
        this.formaPago = formaPago;
        this.estado = EstadoLavado.ESPERA;
        this.cliente = cliente;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
    }

}