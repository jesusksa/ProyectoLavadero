package com.lavadero.model;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo{
    private TipoAuto tipoAuto;
    private int modeloAuto;
    private double tamanioAuto;
    private String patente;
    
    

}