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
@Entity(name = "cliente")
@Table(indexes = {
        @Index(name = "idx_cliente_dni", columnList = "dni"),
        @Index(name = "idx_cliente_apellidos", columnList = "apellidos")
})
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente", nullable = false, updatable = false)
    private Long idCliente;

    @NaturalId
    @Column(nullable = false, unique = true)
    private Integer dni;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(name = "numero_contacto", nullable = false)
    private String numeroContacto;

    @Column(nullable = false)
    private String domicilio;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("patente")
    private List<Vehiculo> vehiculos = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turno> turnos;

}