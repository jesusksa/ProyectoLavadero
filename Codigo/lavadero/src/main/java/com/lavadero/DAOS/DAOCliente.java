package com.lavadero.DAOS;

import com.lavadero.model.Cliente;
import com.lavadero.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAOCliente implements DAO<Cliente> {
    private SessionFactory sessionFactory;

    public DAOCliente(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }


}
