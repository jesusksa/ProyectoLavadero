package com.lavadero.DAOS;

import com.lavadero.model.Empleado;
import com.lavadero.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;

public class DAOEmpelado implements DAO<Empleado> {
    private SessionFactory sessionFactory;

    public DAOEmpelado(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Empleado> obtenerTodos(){
        Session session = sessionFactory.openSession();
        String query = "SELECT e FROM empleado e";
        List<Empleado> empleados = session.createQuery(query,Empleado.class).getResultList();
        session.close();
        return  empleados;
    }
}
