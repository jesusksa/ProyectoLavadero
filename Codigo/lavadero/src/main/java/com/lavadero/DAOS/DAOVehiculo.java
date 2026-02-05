package com.lavadero.DAOS;

import com.lavadero.model.Cliente;
import com.lavadero.model.Vehiculo;
import com.lavadero.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DAOVehiculo implements DAO<Vehiculo> {
    private SessionFactory sessionFactory;

    public DAOVehiculo(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Vehiculo obtenerVehiculoPorPatente(String patente){
        Session session = sessionFactory.openSession();
        String query = "SELECT v FROM vehiculo v WHERE v.patente =: patente";
        Vehiculo vehiculo = session.createQuery(query, Vehiculo.class).setParameter("patente",patente).getSingleResultOrNull();
        session.close();
        return vehiculo;
    }

    public List<Vehiculo> obtenerVehiculosPorCliente(Cliente cliente){
        Session session = sessionFactory.openSession();
        String query = "SELECT v FROM vehiculo v WHERE v.cliente = :cliente";
        List vehiculos = session.createQuery(query, Vehiculo.class).setParameter("cliente",cliente).getResultList();
        session.close();
        return vehiculos;
    }

}
