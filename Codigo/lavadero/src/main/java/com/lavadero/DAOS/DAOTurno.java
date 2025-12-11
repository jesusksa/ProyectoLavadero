package com.lavadero.DAOS;

import com.lavadero.model.Turno;
import com.lavadero.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAOTurno implements DAO<Turno> {
    private SessionFactory sessionFactory;

    public DAOTurno(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

}
