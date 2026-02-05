package com.lavadero.util;

import com.lavadero.DAOS.DAOCliente;
import com.lavadero.DAOS.DAOVehiculo;

public class SystemValidations {

    /* =======================
       NOMBRE / APELLIDO
       ======================= */

    public static String validarNombre(String nombre) {

        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
            return "El nombre solo puede contener letras";

        if (nombre.length() < 3)
            return "El nombre es demasiado corto";

        return null;
    }

    public static String validarApellido(String apellido) {

        if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
            return "El apellido solo puede contener letras";

        if (apellido.length() < 4)
            return "El apellido es demasiado corto";

        return null;
    }

    /* =======================
       DNI
       ======================= */

    public static String validarDni(String dni) {
        if (!dni.matches("\\d+"))
            return "El DNI solo puede contener números";

       if (dni.length() < 7 || dni.length() > 8) {
           return "El DNI debe tener 7 u 8 dígitos";
       }

       DAOCliente daoCliente = new DAOCliente();
       if(daoCliente.obtenerClientePorDni(Integer.valueOf(dni)) != null){
            return "El DNI ya esta registrado";
       }

       return null;
    }

    /* =======================
       CONTACTO
       ======================= */

    public static String validarContacto(String contacto) {

        if (!contacto.matches("[0-9+\\- ]+"))
            return "El contacto tiene un formato inválido";

        if (contacto.length() < 8)
            return "El contacto es demasiado corto";

        return null;
    }

    /* =======================
       DIRECCIÓN
       ======================= */

    public static String validarDireccion(String direccion) {
        if (direccion.length() < 5)
            return "La dirección es demasiado corta";

        return null;
    }

    public static String validarModeloAuto(String modelo){
        if (modelo.length() < 2 || modelo.length() > 50) {
            return "El modelo debe tener entre 2 y 50 caracteres";
        }

        if (!modelo.matches("^[A-Za-z0-9 ]+$")) {
            return "El modelo contiene caracteres no válidos";
        }

        if (modelo.matches("\\d+")) {
            return "El modelo no puede ser solo números";
        }
        return null;
    }

    public static String validarPatente(String patente) {

        patente = patente.toUpperCase().trim();

        // Formatos comunes en Argentina:
        // ABC123  |  AB123CD
        if (!patente.matches("([A-Z]{3}\\d{3}|[A-Z]{2}\\d{3}[A-Z]{2})")) {
            return "Formato de patente inválido";
        }

        DAOVehiculo daoVehiculo= new DAOVehiculo();
        if(daoVehiculo.obtenerVehiculoPorPatente(patente) != null){
            return "Un vehiculo con la misma patente ya esta registrado";
        }
        return null;
    }

}
