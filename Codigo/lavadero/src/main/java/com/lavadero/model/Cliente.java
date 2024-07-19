package com.lavadero.model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;

    @NaturalId
    private Integer dni;
    private String nombres;
    private String apellidos;

    @Column(name = "numero_contacto")
    private String numeroContacto;
    private String domicilio;
}