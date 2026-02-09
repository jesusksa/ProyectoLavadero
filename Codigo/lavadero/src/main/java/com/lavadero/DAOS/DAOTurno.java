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
        List<Turno> turnos = session.createQuery(query,Turno.class).getResultList();
        session.close();
        return turnos;

    }

    public Turno obtenerPorId(Long idTurno) {
        Session session = sessionFactory.openSession();
        String query = "SELECT DISTINCT t FROM turno t "+
                       "LEFT JOIN FETCH t.cliente "+
                       "LEFT JOIN FETCH t.vehiculo "+
                       "LEFT JOIN FETCH t.empleados "+
                       "LEFT JOIN FETCH t.usuario "+
                       "WHERE t.idTurno =: idTurno ";
        Turno turno = session.createQuery(query, Turno.class).setParameter("idTurno",idTurno).getSingleResultOrNull();
        session.close();
        return turno;
    }


    public List<Turno> obtenerTurnosVigentes(){
        Session session = sessionFactory.openSession();
        String query = "SELECT t FROM turno t WHERE (t.estado =: espera OR t.estado =: proceso) AND t.fechaTurno >=: fecha ORDER BY t.fechaTurno ASC, t.horaTurno ASC";
        List<Turno> turnos = session.createQuery(query, Turno.class)
                             .setParameter("espera", EstadoLavado.ESPERA).setParameter("proceso",EstadoLavado.PROCESO)
                             .setParameter("fecha",LocalDate.now())
                             .getResultList();
        session.close();
        return turnos;
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
