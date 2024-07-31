package com.lavadero.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuario")
@Table(indexes = {
        @Index(name = "idx_usuario_nombre_usuario", columnList = "nombre_usuario")
})
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false, updatable = false)
    private Long idUsuario;

    @Column(name = "nombre_usuario", nullable = false, unique = true)
    private String nombreUsuario;

    @Column(name = "contrasenia_usuario", nullable = false)
    private String contraseniaUsuario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoRol rol;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turno> turnos;
}