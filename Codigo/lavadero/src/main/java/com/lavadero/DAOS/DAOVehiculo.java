package com.lavadero.DAOS;

import com.lavadero.model.Vehiculo;
import com.lavadero.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAOVehiculo implements DAO<Vehiculo> {
    private SessionFactory sessionFactory;

    public DAOVehiculo(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

}
