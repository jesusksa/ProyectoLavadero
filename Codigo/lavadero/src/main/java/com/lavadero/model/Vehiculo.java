package com.lavadero.model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vehiculo")
public class Vehiculo{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_vehiculo", nullable = false)
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
}