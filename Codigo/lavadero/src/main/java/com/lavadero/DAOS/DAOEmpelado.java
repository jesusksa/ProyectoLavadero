package com.lavadero.DAOS;

import com.lavadero.model.Empleado;
import com.lavadero.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAOEmpelado implements DAO<Empleado> {
    private SessionFactory sessionFactory;

    public DAOEmpelado(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }


}
