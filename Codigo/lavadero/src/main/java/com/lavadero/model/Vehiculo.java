package com.lavadero.model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vehiculo")
@Table(indexes = {
        @Index(name = "idx_vehiculo_patente", columnList = "patente"),
        @Index(name = "idx_vehiculo_modelo_vehiculo", columnList = "modelo_vehiculo")
})
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo", nullable = false, updatable = false)
    private Long idVehiculo;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String patente;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_vehiculo", nullable = false)
    private TipoAuto tipoAuto;

    @Column(name = "modelo_vehiculo", nullable = false)
    private String modeloAuto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_relacion", nullable = false)
    private TipoRelacion tipoRelacion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turno> turnos = new ArrayList<>();

    public Vehiculo(String patente, TipoAuto tipoAuto, String modeloAuto, TipoRelacion tipoRelacion) {
        this.patente = patente;
        this.tipoAuto = tipoAuto;
        this.modeloAuto = modeloAuto;
        this.tipoRelacion = tipoRelacion;
    }

    public Vehiculo(String patente, TipoAuto tipoAuto, String modeloAuto, TipoRelacion tipoRelacion, Cliente cliente) {
        this.patente = patente;
        this.tipoAuto = tipoAuto;
        this.modeloAuto = modeloAuto;
        this.tipoRelacion = tipoRelacion;
        this.cliente = cliente;
    }


}