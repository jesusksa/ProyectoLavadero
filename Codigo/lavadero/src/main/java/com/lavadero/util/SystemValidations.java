package com.lavadero.util;

import com.lavadero.DAOS.DAOCliente;
import com.lavadero.DAOS.DAOUsuario;
import com.lavadero.DAOS.DAOVehiculo;

import java.util.regex.Pattern;

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
        // 1. Normalizamos: Pasamos a mayúsculas y quitamos espacios externos
        patente = patente.toUpperCase().trim();

        // 2. Expresión Regular Mejorada:
        // ([A-Z]{3}\s?\d{3}      -> LLL NNN o LLLNNN
        // |                      -> O
        // [A-Z]{2}\s?\d{3}\s?[A-Z]{2}) -> LL NNN LL o LLNNNLL
        String regex = "^([A-Z]{3}\\s?\\d{3}|[A-Z]{2}\\s?\\d{3}\\s?[A-Z]{2})$";

        if (!patente.matches(regex)) {
            return "Formato de patente inválido (Ej: ABC123 o AB123CD)";
        }

        // 3. Recomendación: Quitar el espacio interno antes de consultar la BD
        // Esto asegura que "KSA 114" y "KSA114" sean tratados como lo mismo
        String patenteLimpia = patente.replace(" ", "");

        DAOVehiculo daoVehiculo = new DAOVehiculo();
        if (daoVehiculo.obtenerVehiculoPorPatente(patenteLimpia) != null) {
            return "Un vehículo con la misma patente ya está registrado";
        }

        return null;
    }

    public static String validarNombreUsuario(String usuario){
        if(usuario.length() < 5 || usuario.length() > 30){
            return "La longitud de nombre de usuario ingresada no es adecuada.";
        }

        return null;
    }

    public static String validarContrasenia(String contrasenia){
        String regex = "^(?=.*\\d).{10,}$";
        if(Pattern.matches(regex, contrasenia)){
            return "Formato de contraseña incorrecto. La contraseña debe tener una longitud mínima de 10 caracteres e incluir al menos un número.";
        }
        return null;
    }

}
