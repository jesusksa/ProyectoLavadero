package com.lavadero.util;

import com.lavadero.DAOS.*;
import com.lavadero.model.*;
import org.mindrot.jbcrypt.BCrypt;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CargaDatos {
    public static void cargar(){

        // 1. USUARIOS (Claves: oficina->1234, adminis->1234, admin->admin)
        Usuario userOficina = new Usuario("office", BCrypt.hashpw("1234", BCrypt.gensalt()), TipoRol.OFICINISTA);
        Usuario userAdminis = new Usuario("adminis", BCrypt.hashpw("1234", BCrypt.gensalt()), TipoRol.ADMINISTRATIVO);
        Usuario userRoot = new Usuario("admin", BCrypt.hashpw("admin", BCrypt.gensalt()), TipoRol.ADMINISTRADOR);

        DAOUsuario daoUsuario = new DAOUsuario();
        daoUsuario.agregar(userOficina);
        daoUsuario.agregar(userAdminis);
        daoUsuario.agregar(userRoot);

        // 2. EMPLEADOS
        DAOEmpelado daoEmpleado = new DAOEmpelado();
        daoEmpleado.agregar(new Empleado("Juan Carlos", "Perez", 25345678));
        daoEmpleado.agregar(new Empleado("Mariela", "Sosa", 32890123));
        daoEmpleado.agregar(new Empleado("Roberto", "Gomez", 21765432));
        daoEmpleado.agregar(new Empleado("Claudio", "Fernandez", 28456123));

        // 3. CLIENTES
        DAOCliente daoCliente = new DAOCliente();
        Cliente c0 = new Cliente(29220008, "Maria", "Sosa", "1148580661", "Calle 685");
        Cliente c1 = new Cliente(32910399, "Diego", "Diaz", "1130921212", "Calle 801");
        Cliente c2 = new Cliente(30977417, "Nicolas", "Fernandez", "1148702266", "Calle 1558");
        Cliente c3 = new Cliente(34619223, "Maria", "Acosta", "1173970671", "Calle 456");
        Cliente c4 = new Cliente(26218437, "Lucia", "Romero", "1173737340", "Calle 1708");
        Cliente c5 = new Cliente(21108692, "Martin", "Martinez", "1164423976", "Calle 589");
        Cliente c6 = new Cliente(21436970, "Jorge", "Diaz", "1139645977", "Calle 847");
        Cliente c7 = new Cliente(21707045, "Maria", "Torres", "1126788665", "Calle 459");
        Cliente c8 = new Cliente(27718072, "Martin", "Garcia", "1113592796", "Calle 692");
        Cliente c9 = new Cliente(41383164, "Maria", "Gomez", "1158339100", "Calle 1868");
        Cliente c10 = new Cliente(36421627, "Laura", "Romero", "1132080714", "Calle 891");
        Cliente c11 = new Cliente(37377312, "Lucia", "Garcia", "1154203963", "Calle 457");

        // 4. VEHÍCULOS (Patentes AAA 123)
        DAOVehiculo daoVehiculo = new DAOVehiculo();

        Vehiculo v5 = new Vehiculo("ZKV 426", TipoAuto.AUTOMOVIL, "Ford Ranger Negro", TipoRelacion.DUEÑO);
        v5.setCliente(c0); c0.setVehiculos(List.of(v5)); daoCliente.agregar(c0); daoVehiculo.agregar(v5);

        Vehiculo v10 = new Vehiculo("CEQ 458", TipoAuto.UTILITARIO, "Ford Focus Bordeaux", TipoRelacion.DUEÑO);
        v10.setCliente(c1); c1.setVehiculos(List.of(v10)); daoCliente.agregar(c1); daoVehiculo.agregar(v10);

        Vehiculo v6 = new Vehiculo("HJB 108", TipoAuto.UTILITARIO, "VW Gol Azul", TipoRelacion.CONDUCTOR);
        v6.setCliente(c2);
        Vehiculo v7 = new Vehiculo("SUT 515", TipoAuto.UTILITARIO, "Peugeot 208 Rojo", TipoRelacion.DUEÑO);
        v7.setCliente(c2);
        c2.setVehiculos(List.of(v6, v7)); daoCliente.agregar(c2); daoVehiculo.agregar(v6); daoVehiculo.agregar(v7);

        Vehiculo v12 = new Vehiculo("FRO 508", TipoAuto.CAMIONETA, "Chevrolet Onix Rojo", TipoRelacion.CONDUCTOR);
        v12.setCliente(c3); c3.setVehiculos(List.of(v12)); daoCliente.agregar(c3); daoVehiculo.agregar(v12);

        daoCliente.agregar(c4); // Cliente sin vehículo inicial

        Vehiculo v1 = new Vehiculo("CQB 582", TipoAuto.UTILITARIO, "Peugeot Partner Azul", TipoRelacion.DUEÑO);
        v1.setCliente(c5);
        Vehiculo v14 = new Vehiculo("LXK 544", TipoAuto.AUTOMOVIL, "Ford Ranger Blanco", TipoRelacion.CONDUCTOR);
        v14.setCliente(c5);
        c5.setVehiculos(List.of(v1, v14)); daoCliente.agregar(c5); daoVehiculo.agregar(v1); daoVehiculo.agregar(v14);

        Vehiculo v4 = new Vehiculo("FUL 005", TipoAuto.CAMION, "Honda Civic Azul", TipoRelacion.CONDUCTOR);
        v4.setCliente(c6); c6.setVehiculos(List.of(v4)); daoCliente.agregar(c6); daoVehiculo.agregar(v4);

        daoCliente.agregar(c7); daoCliente.agregar(c8); daoCliente.agregar(c9);

        Vehiculo v0 = new Vehiculo("OKP 234", TipoAuto.CAMION, "VW Gol Gris Plata", TipoRelacion.CONDUCTOR);
        v0.setCliente(c10);
        Vehiculo v8 = new Vehiculo("WKO 533", TipoAuto.AUTOMOVIL, "Renault Kangoo Rojo", TipoRelacion.DUEÑO);
        v8.setCliente(c10);
        c10.setVehiculos(List.of(v0, v8)); daoCliente.agregar(c10); daoVehiculo.agregar(v0); daoVehiculo.agregar(v8);

        Vehiculo v2 = new Vehiculo("AZO 245", TipoAuto.AUTOMOVIL, "Toyota Hilux Gris Plata", TipoRelacion.DUEÑO);
        v2.setCliente(c11);
        Vehiculo v3 = new Vehiculo("PAG 579", TipoAuto.AUTOMOVIL, "Ford Ranger Rojo", TipoRelacion.CONDUCTOR);
        v3.setCliente(c11);
        Vehiculo v9 = new Vehiculo("MUF 822", TipoAuto.AUTOMOVIL, "Citroen Berlingo Gris Oscuro", TipoRelacion.DUEÑO);
        v9.setCliente(c11);
        c11.setVehiculos(List.of(v2, v3, v9)); daoCliente.agregar(c11); daoVehiculo.agregar(v2); daoVehiculo.agregar(v3); daoVehiculo.agregar(v9);

        // 5. TURNOS (30 turnos: Hoy, Mañana y Pasado)
        DAOTurno daoTurno = new DAOTurno();
        LocalDate hoy = LocalDate.now();
        LocalDate maniana = LocalDate.now().plusDays(1);
        LocalDate pManiana = LocalDate.now().plusDays(2);
        LocalDate ppManiana = LocalDate.now().plusDays(3);
        if (esSabado(hoy)){
            hoy = hoy.plusDays(2);
            maniana = maniana.plusDays(2);
            pManiana = pManiana.plusDays(2);
            ppManiana = ppManiana.plusDays(2);
        } else if (esDomingo(hoy)) {
            hoy = hoy.plusDays(1);
            maniana = maniana.plusDays(1);
            pManiana = pManiana.plusDays(1);
            ppManiana = ppManiana.plusDays(1);
        }

        if (esSabado(maniana)){
            maniana = maniana.plusDays(2);
            pManiana = pManiana.plusDays(2);
            ppManiana = ppManiana.plusDays(2);
        }

        if (esSabado(pManiana)){
            pManiana = pManiana.plusDays(2);
            ppManiana = ppManiana.plusDays(2);
        }

        if (esSabado(ppManiana)){
            ppManiana = ppManiana.plusDays(2);
        } else if (esDomingo(ppManiana)) {
            ppManiana = ppManiana.plusDays(1);
        }

        // --- HOY ---
        System.out.println("Hoy es: "+hoy.getDayOfWeek());
        daoTurno.agregar(new Turno(hoy, TipoServicio.LAVADO_COMUN, FormaPago.TARJETA_DEBITO, c11, userOficina, v9, LocalTime.of(8, 0)));
        daoTurno.agregar(new Turno(hoy, TipoServicio.LAVADO_COMUN, FormaPago.TARJETA_CREDITO, c10, userOficina, v8, LocalTime.of(8, 0)));
        daoTurno.agregar(new Turno(hoy, TipoServicio.LAVADO_COMPLETO_MOTOR, FormaPago.EFECTIVO, c6, userOficina, v4, LocalTime.of(9, 0)));
        daoTurno.agregar(new Turno(hoy, TipoServicio.LAVADO_COMUN, FormaPago.TARJETA_DEBITO, c11, userOficina, v2, LocalTime.of(9, 0)));
        daoTurno.agregar(new Turno(hoy, TipoServicio.LAVADO_COMPLETO, FormaPago.TARJETA_CREDITO, c3, userOficina, v12, LocalTime.of(10, 0)));
        daoTurno.agregar(new Turno(hoy, TipoServicio.LAVADO_COMPLETO, FormaPago.BILLETERA_VIRTUAL, c1, userOficina, v10, LocalTime.of(11, 0)));
        daoTurno.agregar(new Turno(hoy, TipoServicio.LAVADO_COMUN, FormaPago.EFECTIVO, c11, userOficina, v2, LocalTime.of(14, 0)));
        daoTurno.agregar(new Turno(hoy, TipoServicio.LAVADO_COMPLETO_MOTOR, FormaPago.BILLETERA_VIRTUAL, c5, userOficina, v1, LocalTime.of(15, 0)));

        // --- MAÑANA ---
        System.out.println("Mañana es: "+maniana.getDayOfWeek());
        daoTurno.agregar(new Turno(maniana, TipoServicio.LAVADO_COMUN, FormaPago.MERCADO_PAGO, c11, userOficina, v2, LocalTime.of(8, 0)));
        daoTurno.agregar(new Turno(maniana, TipoServicio.LAVADO_COMPLETO, FormaPago.TARJETA_CREDITO, c5, userOficina, v1, LocalTime.of(8, 0)));
        daoTurno.agregar(new Turno(maniana, TipoServicio.LAVADO_COMPLETO, FormaPago.TARJETA_CREDITO, c5, userOficina, v14, LocalTime.of(9, 0)));
        daoTurno.agregar(new Turno(maniana, TipoServicio.LAVADO_COMPLETO, FormaPago.TARJETA_DEBITO, c0, userOficina, v5, LocalTime.of(10, 0)));

        // --- PASADO MAÑANA ---
        System.out.println("Pasado Mañana es: "+pManiana.getDayOfWeek());
        daoTurno.agregar(new Turno(pManiana, TipoServicio.LAVADO_COMPLETO, FormaPago.BILLETERA_VIRTUAL, c1, userOficina, v10, LocalTime.of(10, 0)));
        daoTurno.agregar(new Turno(pManiana, TipoServicio.LAVADO_COMUN, FormaPago.MERCADO_PAGO, c0, userOficina, v5, LocalTime.of(12, 0)));
        daoTurno.agregar(new Turno(pManiana, TipoServicio.LAVADO_COMPLETO_MOTOR, FormaPago.TARJETA_DEBITO, c11, userOficina, v3, LocalTime.of(15, 0)));

        // --- PASADO PASADO MAÑANA ---
        System.out.println("Pasado Pasado Mañana es: "+ppManiana.getDayOfWeek());
        daoTurno.agregar(new Turno(ppManiana, TipoServicio.LAVADO_COMPLETO, FormaPago.TARJETA_DEBITO, c11, userOficina, v9, LocalTime.of(8, 0)));
        daoTurno.agregar(new Turno(ppManiana, TipoServicio.LAVADO_COMUN, FormaPago.MERCADO_PAGO, c3, userOficina, v12, LocalTime.of(9, 0)));
        daoTurno.agregar(new Turno(ppManiana, TipoServicio.LAVADO_COMPLETO_MOTOR, FormaPago.MERCADO_PAGO, c11, userOficina, v2, LocalTime.of(9, 0)));
        daoTurno.agregar(new Turno(ppManiana, TipoServicio.LAVADO_COMPLETO_MOTOR, FormaPago.TARJETA_DEBITO, c10, userOficina, v0, LocalTime.of(11, 0)));
        daoTurno.agregar(new Turno(ppManiana, TipoServicio.LAVADO_COMUN, FormaPago.EFECTIVO, c11, userOficina, v9, LocalTime.of(13, 0)));

        System.out.println("¡Base de datos cargada con éxito con datos profesionales!");

    }

    public static boolean esSabado(LocalDate fecha) {
        DayOfWeek dia = fecha.getDayOfWeek();
        return dia == DayOfWeek.SATURDAY;
    }

    public static boolean esDomingo(LocalDate fecha){
        DayOfWeek dia = fecha.getDayOfWeek();
        return dia == DayOfWeek.SUNDAY;
    }

}
