package com.lavadero.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.lavadero.util.SystemTools;
import jakarta.persistence.*;
import javafx.scene.control.Alert;
import lombok.*;


@Getter
@Setter
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

    @Column(name = "hora_turno")
    private LocalTime horaTurno;

    @Column(name = "hora_inicio") //nullable = false luego
    private LocalTime horaInicio;

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

    public Turno(){
        this.estado = EstadoLavado.ESPERA;
    }

    public Turno(LocalDate fechaTurno, TipoServicio tipoServicio, FormaPago formaPago, Cliente cliente, Vehiculo vehiculo, LocalTime hora) {
        this.fechaTurno = fechaTurno;
        this.tipoServicio = tipoServicio;
        this.formaPago = formaPago;
        this.estado = EstadoLavado.ESPERA;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.horaTurno = hora;
    }

    public Turno(LocalDate fechaTurno, TipoServicio tipoServicio, FormaPago formaPago, Cliente cliente, Usuario usuario, Vehiculo vehiculo, LocalTime hora) {
        this.fechaTurno = fechaTurno;
        this.tipoServicio = tipoServicio;
        this.formaPago = formaPago;
        this.estado = EstadoLavado.ESPERA;
        this.cliente = cliente;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.horaTurno = hora;
    }

    public String formatearServicio(){
        switch (this.tipoServicio){
            case LAVADO_COMUN:
                return "Lavado Comun";
            case LAVADO_COMPLETO:
                return "Lavado Completo";
            case LAVADO_COMPLETO_MOTOR:
                return "Lavado Comp más Motor";
            default:
                SystemTools.createAlert(Alert.AlertType.ERROR, "Error de formato", "Formato de dato invalido", "Por favor revise las datos ingresados");
                return "";
        }
    }

    public String formatearPago(){
        switch (this.formaPago){
            case TARJETA_DEBITO:
                return "Tarjeta de Debito";
            case TARJETA_CREDITO:
                return "Tarjeta de Credito";
            case BILLETERA_VIRTUAL:
                return "Billetera Virtual";
            case MONEDA_EXTRANJERA:
                return "Moneda Extranjera";
            case MERCADO_PAGO:
                return "Mercado Pago";
            case EFECTIVO:
                return "Efectivo";
            default:
                SystemTools.createAlert(Alert.AlertType.ERROR, "Error de formato", "Formato de dato invalido", "Por favor revise las datos ingresados");
                return "";
        }
    }

    public String formatearEstado(){
        switch (this.estado){
            case ESPERA:
                return "En Espera";
            case CANCELADO:
                return "Cancelado";
            case PROCESO:
                return "En Proceso";
            case FINALIZADO:
                return "Finalizado";
            default:
                SystemTools.createAlert(Alert.AlertType.ERROR, "Error de formato", "Formato de dato invalido", "Por favor revise las datos ingresados");
                return "";
        }
    }

    public String formatearFecha(){
        return this.fechaTurno.getDayOfMonth() + "/" + this.fechaTurno.getMonthValue() + "/" + this.fechaTurno.getYear();
    }

    public String formatearHora(){
        return this.horaTurno + "Hs";
    }

    public String formatearFechaHora() {
        return this.fechaTurno.getDayOfMonth() + "/" + this.fechaTurno.getMonthValue() + " " + this.horaTurno.getHour() + "Hs";
    }

    public String formatearEmpleados() {
        if (empleados == null || empleados.isEmpty()) {
            return "Sin empleados asignados";
        }

        return empleados.stream()
                .map(Empleado::formatearNombre)
                .collect(Collectors.joining(" - "));
    }

}