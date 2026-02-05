package com.lavadero.DAOS;

import com.lavadero.model.EstadoLavado;
import com.lavadero.model.Turno;
import com.lavadero.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.time.LocalTime;
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

    public List<LocalTime> obtenerHorasNoDisponiblesPorDia(LocalDate fecha){
        Session session = sessionFactory.openSession();
        String query = "SELECT t.horaTurno" +
                       " FROM turno t" +
                       " WHERE t.fechaTurno =: fecha" +
                       " AND t.estado =: estado" +
                       " GROUP BY t.horaTurno" +
                       " HAVING COUNT(t) >= 2";

        List<LocalTime> horas = session.createQuery(query,LocalTime.class)
                                .setParameter("fecha",fecha)
                                .setParameter("estado",EstadoLavado.ESPERA)
                                .getResultList();

        session.close();
        return horas;
    }

}
