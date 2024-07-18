package com.lavadero.model;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    private String nombre;
    private String apellido;
    private int dni;

}