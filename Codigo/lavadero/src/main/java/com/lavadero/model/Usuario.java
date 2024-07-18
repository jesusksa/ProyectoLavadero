package com.lavadero.model;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String nombreUsuario;
    private String contraseniaUsuario;
    private TipoRol rol;

}