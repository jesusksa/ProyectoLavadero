package com.lavadero.model;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private String nombre;
    private String apellido;
    private String contacto;
    private String domicilio;
    private int dni;

}