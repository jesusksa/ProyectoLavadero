package com.lavadero.util;

import com.lavadero.model.FormaPago;
import com.lavadero.model.TipoServicio;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class SystemTools {

    public static void createAlert(Alert.AlertType tipoAlerta, String titulo, String encabezado, String contenido){
        Alert alert = new Alert(tipoAlerta);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    public static boolean createAlertConfirm(String titulo, String encabezado, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);

        Optional<ButtonType> result = alert.showAndWait();

        return result.isPresent() && result.get() == ButtonType.OK;
    }

    public static void setearLabel(Label label, String contenido){
        label.setText(contenido);
    }

    public static List<String> formatearTipoLavado(){
        return List.of("LAVADO COMUN", "LAVADO COMPLETO","LAVADO COMP MÁS MOTOR");
    }

    public static TipoServicio formatearTipoLavado(String tipo){
        switch (tipo){
            case "LAVADO COMUN":
                return TipoServicio.LAVADO_COMUN;
            case "LAVADO COMPLETO":
                return TipoServicio.LAVADO_COMPLETO;
            case "LAVADO COMP + MOTOR":
                return TipoServicio.LAVADO_COMPLETO_MOTOR;
        }
        return null;
    }

    public static List<String> formatearFormaPago(){
        return List.of("EFECTIVO","TARJETA DE CREDITO","TARJETA DE DEBITO","BILLETERA VIRTUAL","MERCADO PAGO","MONEDA EXTRANJERA");
    }

    public static FormaPago formatearFormapago(String pago){
        switch (pago){
            case "EFECTIVO":
                return FormaPago.EFECTIVO;
            case "TARJETA DE CREDITO":
                return FormaPago.TARJETA_CREDITO;
            case "TARJETA DE DEBITO":
                return FormaPago.TARJETA_DEBITO;
            case "BILLETERA VIRTUAL":
                return FormaPago.BILLETERA_VIRTUAL;
            case "MERCADO PAGO":
                return FormaPago.MERCADO_PAGO;
            case "MONEDA EXTRANJERA":
                return FormaPago.MONEDA_EXTRANJERA;
        }
        return null;
    }
}
