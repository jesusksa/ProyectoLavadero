package com.lavadero.DAOS;

import com.lavadero.model.Usuario;
import com.lavadero.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class DAOUsuario implements DAO<Usuario>{
    private SessionFactory sessionFactory;

    public DAOUsuario(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
}
