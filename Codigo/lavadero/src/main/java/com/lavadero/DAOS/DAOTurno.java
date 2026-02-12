package com.lavadero.DAOS;

import com.lavadero.model.EstadoLavado;
import com.lavadero.model.TipoAuto;
import com.lavadero.model.TipoServicio;
import com.lavadero.model.Turno;
import com.lavadero.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
        String query = "SELECT t FROM turno t WHERE (t.estado =: espera OR t.estado =: proceso) AND t.fechaTurno >=: fecha AND t.horaTurno >=: hora ORDER BY t.fechaTurno ASC, t.horaTurno ASC";
        List<Turno> turnos = session.createQuery(query, Turno.class)
                             .setParameter("espera", EstadoLavado.ESPERA).setParameter("proceso",EstadoLavado.PROCESO)
                             .setParameter("fecha",LocalDate.now())
                             .setParameter("hora",LocalTime.now())
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

    public List<Turno> obtenerTurnosFiltrados(String dni, String matricula, TipoServicio servicio, EstadoLavado estado, TipoAuto vehiculo, LocalDate fecha){
        Session session = sessionFactory.openSession();
        StringBuilder query = new StringBuilder("SELECT t FROM turno t WHERE 1=1 ");
        if(!dni.isEmpty()){
            query.append("AND t.cliente.dni =: dni ");
        }
        if(!matricula.isEmpty()){
            query.append("AND t.vehiculo.patente =: matricula ");
        }
        if(servicio != null){
            query.append("AND t.tipoServicio =: servicio ");
        }
        if(estado != null){
            query.append("AND t.estado =: estado ");
        }
        if(vehiculo != null){
            query.append("AND t.vehiculo.tipoAuto =: vehiculo ");
        }
        if(fecha != null){
            query.append("AND t.fechaTurno =: fechaTurno ");
        }

        Query<Turno> turnos = session.createQuery(query.toString(), Turno.class);
        if(!dni.isEmpty()){
            turnos.setParameter("dni",dni);
        }
        if(!matricula.isEmpty()){
            turnos.setParameter("matricula",matricula);
        }
        if(servicio != null){
            turnos.setParameter("servicio",servicio);
        }
        if(estado != null){
            turnos.setParameter("estado",estado);
        }
        if(vehiculo != null){
            turnos.setParameter("vehiculo",vehiculo);
        }
        if(fecha != null){
            turnos.setParameter("fechaTurno",fecha);
        }

        List<Turno> turnoslist = turnos.getResultList();
        session.close();
        return turnoslist;

    }

    public List<Turno> obtenerTurnosPorNombre(String nombreApe){
        Session session = sessionFactory.openSession();
        String query = "SELECT t from turno t "+
                            "WHERE lower(t.cliente.nombres) LIKE :texto "+
                            "OR lower(t.cliente.apellidos) LIKE :texto "+
                            "ORDER BY t.fechaTurno ASC, t.horaTurno ASC";

        List<Turno> turnos = session.createQuery(query, Turno.class).setParameter("texto","%" + nombreApe.toLowerCase() + "%").getResultList();

        session.close();
        return turnos;
    }

}
