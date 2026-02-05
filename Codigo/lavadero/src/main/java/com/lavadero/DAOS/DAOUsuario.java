package com.lavadero.DAOS;

import com.lavadero.model.Usuario;
import com.lavadero.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DAOUsuario implements DAO<Usuario>{
    private SessionFactory sessionFactory;

    public DAOUsuario(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Usuario obtenerUsuario(String nombreUsuario){
        Session session = sessionFactory.openSession();
        String query = "SELECT u FROM usuario u WHERE u.nombreUsuario = :nombreUsuario";
        return session.createQuery(query, Usuario.class).setParameter("nombreUsuario",nombreUsuario).getSingleResultOrNull();
    }
}
