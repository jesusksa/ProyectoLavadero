package com.lavadero.model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "empleado")
@Table(indexes = {
        @Index(name = "idx_empleado_dni", columnList = "dni"),
        @Index(name = "idx_empleado_apellidos", columnList = "apellidos")
})
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empleado", nullable = false, updatable = false)
    private Long idEmpleado;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @NaturalId
    @Column(nullable = false, unique = true)
    private int dni;

    @ManyToMany(mappedBy = "empleados")
    private List<Turno> turnos;

}