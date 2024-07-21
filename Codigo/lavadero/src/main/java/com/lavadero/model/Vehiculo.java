package com.lavadero.model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;


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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "tamanio_vehiculo", nullable = false)
    private double tamanioAuto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

}