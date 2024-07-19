package com.lavadero.model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empleado", nullable = false)
    private Long idEmpleado;

    private String nombres;
    private String apellidos;

    @NaturalId
    private int dni;

}