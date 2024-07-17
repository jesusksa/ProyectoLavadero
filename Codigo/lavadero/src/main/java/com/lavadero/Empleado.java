package com.lavadero;
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