package com.lavadero.util;

import com.lavadero.DAOS.*;
import com.lavadero.model.*;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CargaDatos {
    public static void cargar(){

        // Clientes
        Cliente cliente1 = new Cliente(1000,"Naruto","Uzumaki","11111111","Aldea de la hoja");
        Cliente cliente2 = new Cliente(1001,"Sasuke","Uchiha","22222222","Desertor");
        Cliente cliente3 = new Cliente(1002,"Sakura","Haruno","33333333","Aldea de la hoja");
        Cliente cliente4 = new Cliente(1003,"Boruto","Uzumaki","44444444","Aldea de la hoja");

        //Vehiculos
        Vehiculo vehiculo1 = new Vehiculo("Uzu13", TipoAuto.AUTOMOVIL,"Chebrolet Camaro 2010", TipoRelacion.DUEÑO);
        Vehiculo vehiculo2 = new Vehiculo("Uch05", TipoAuto.CAMION,"Volkswagen 2018", TipoRelacion.DUEÑO);
        Vehiculo vehiculo3 = new Vehiculo("Har34", TipoAuto.CAMIONETA,"Peugeot 2021", TipoRelacion.DUEÑO);
        Vehiculo vehiculo4 = new Vehiculo("Uzu80", TipoAuto.UTILITARIO,"Yamaha 2024", TipoRelacion.DUEÑO);
        Vehiculo vehiculo5 = new Vehiculo("Uzu56", TipoAuto.AUTOMOVIL,"Lamborgini ferrari 2025", TipoRelacion.CONDUCTOR);

        cliente1.setVehiculos(List.of(vehiculo1,vehiculo4));
        cliente2.setVehiculos(List.of(vehiculo2));
        cliente3.setVehiculos(List.of(vehiculo3));
        cliente4.setVehiculos(List.of(vehiculo5));

        vehiculo1.setCliente(cliente1);
        vehiculo4.setCliente(cliente1);
        vehiculo2.setCliente(cliente2);
        vehiculo3.setCliente(cliente3);
        vehiculo5.setCliente(cliente4);


        //Persistencia
        DAOCliente daoCliente = new DAOCliente();
        daoCliente.agregar(cliente1);
        daoCliente.agregar(cliente2);
        daoCliente.agregar(cliente3);
        daoCliente.agregar(cliente4);

        DAOVehiculo daoVehiculo = new DAOVehiculo();
        daoVehiculo.agregar(vehiculo1);
        daoVehiculo.agregar(vehiculo2);
        daoVehiculo.agregar(vehiculo3);
        daoVehiculo.agregar(vehiculo4);
        daoVehiculo.agregar(vehiculo5);



        //Empleados
        Empleado empelado1 = new Empleado("Jesús","Casabillanos",1);
        Empleado empelado2 = new Empleado("Joaquín","Pralong",2);
        Empleado empelado3 = new Empleado("Gaston","Pralong",3);
        Empleado empelado4 = new Empleado("Marcos","barbozza",4);

        //Persistencia
        DAOEmpelado daoEmpelado = new DAOEmpelado();
        daoEmpelado.agregar(empelado1);
        daoEmpelado.agregar(empelado2);
        daoEmpelado.agregar(empelado3);
        daoEmpelado.agregar(empelado4);

        //Usuarios
        Usuario usuario1 = new Usuario("office", BCrypt.hashpw("365kk", BCrypt.gensalt()),TipoRol.OFICINISTA);
        Usuario usuario2 = new Usuario("offic2", BCrypt.hashpw("242314kk", BCrypt.gensalt()),TipoRol.OFICINISTA);
        Usuario usuario3 = new Usuario("marcos15", BCrypt.hashpw("jesus15", BCrypt.gensalt()),TipoRol.ADMINISTRATIVO);
        Usuario usuario4 = new Usuario("admin", BCrypt.hashpw("admin", BCrypt.gensalt()),TipoRol.ADMINISTRADOR);

        //Persistencia
        DAOUsuario daoUsuario = new DAOUsuario();
        daoUsuario.agregar(usuario1);
        daoUsuario.agregar(usuario2);
        daoUsuario.agregar(usuario3);
        daoUsuario.agregar(usuario4);


        //Turnos
        Turno turno1 = new Turno(LocalDate.now(),TipoServicio.LAVADO_COMUN,FormaPago.EFECTIVO,cliente1,usuario1,vehiculo1, LocalTime.of(9,0));
        Turno turno2 = new Turno(LocalDate.now(),TipoServicio.LAVADO_COMPLETO,FormaPago.MERCADO_PAGO,cliente2,usuario2,vehiculo2,LocalTime.of(9,0));
        Turno turno3 = new Turno(LocalDate.now(),TipoServicio.LAVADO_COMPLETO_MOTOR,FormaPago.BILLETERA_VIRTUAL,cliente3,usuario1,vehiculo3,LocalTime.of(10,0));
        Turno turno4 = new Turno(LocalDate.now().plusDays(1),TipoServicio.LAVADO_COMUN,FormaPago.TARJETA_CREDITO,cliente1,usuario2,vehiculo4,LocalTime.of(18,0));
        Turno turno5 = new Turno(LocalDate.now().plusDays(2),TipoServicio.LAVADO_COMUN,FormaPago.TARJETA_DEBITO,cliente4,usuario3,vehiculo5,LocalTime.of(18,0));

        //Persistencia
        DAOTurno daoTurno = new DAOTurno();
        daoTurno.agregar(turno1);
        daoTurno.agregar(turno2);
        daoTurno.agregar(turno3);
        daoTurno.agregar(turno4);
        daoTurno.agregar(turno5);

    }

}
