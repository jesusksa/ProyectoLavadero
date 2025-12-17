package com.lavadero.DAOS;

import com.lavadero.model.Turno;
import com.lavadero.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DAOTurno implements DAO<Turno> {
    private SessionFactory sessionFactory;

    public DAOTurno(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Turno> obtenerTodos(){
        Session session = sessionFactory.openSession();
        String query = "SELECT t FROM turno t";

        return session.createQuery(query,Turno.class).getResultList();

    }

}
