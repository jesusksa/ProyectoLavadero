package com.lavadero.model;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {

    private int dni;
    private String nombres;
    private String apellidos;
    private String contacto;
    private String domicilio;


}