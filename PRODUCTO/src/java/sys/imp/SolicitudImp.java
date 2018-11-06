/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.imp;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.SolicitudDao;
import sys.model.Solicitud;
import sys.util.HibernateUtil;

/**
 *
 * @author omar.mahecha
 */
public class SolicitudImp implements SolicitudDao{
    private Session session;
    private Transaction t;
    @Override
    public List<Solicitud> ListarSolicitudes() {
        session = null;
        t = null;
        List<Solicitud> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        String hql="SELECT s FROM Solicitud s LEFT JOIN FETCH s.idEstadoActual LEFT JOIN FETCH s.idUsuario u LEFT JOIN FETCH s.idProfesionalAsignado p LEFT JOIN FETCH s.idTipoCertificacion order by s.idSolicitud desc";
        try{

           lista = session.createQuery(hql).setMaxResults(100).list();
            t.commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage()+"error en lista solicitud");
            t.rollback();
        }
        
        return lista;
    }

    @Override
    public void newSolicitud(Solicitud solicitud) throws Exception {
        session = null;
        t = null;
        try{
       session = HibernateUtil.getSessionFactory().openSession();
       t = session.beginTransaction();
       session.save(solicitud);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Solicitud creada con éxito",null));
       t.commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Solicitud no se pudo guardar, Informe al administrador",null));
        }finally{
                session.close();    

        }  
    }

    @Override
    public void updateSolicitud(Solicitud solicitud) {
          session = null;
        t = null;
        try{
        
        session= HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        session.update(solicitud);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Solicitud Modificada con éxito",null));
        t.commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No fue posible modificar la solicitud, Informe al administrador",null));
        }finally{
                session.close();

        }
    }

    @Override
    public void deleteSolicitud(Solicitud solicitud) {
         session = null;
        t = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            t = session.beginTransaction();
            session.delete(solicitud);
            t.commit();
            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
        }finally{
            
                session.close();
            
        }
    }

    @Override
    public List<Solicitud> buscarPorIdSoli(int id) {
        session = null;
        t = null;
        List<Solicitud> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        String hql="SELECT s FROM Solicitud s LEFT JOIN FETCH s.idEstadoActual LEFT JOIN FETCH s.idUsuario u LEFT JOIN FETCH s.idProfesionalAsignado p LEFT JOIN FETCH s.idTipoCertificacion where s.idSolicitud= :id";
        try{

           lista = session.createQuery(hql).setParameter("id", id).setMaxResults(100).list();
            t.commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage()+"error en lista solicitud");
            t.rollback();
        }
        
        return lista;
    }


    @Override
    public List<Solicitud> ListarSolicitudesPorUsuario(int idUser, String hql) {
        session = null;
        t = null;
        List<Solicitud> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        //"SELECT s FROM Solicitud s LEFT JOIN FETCH s.idEstadoActual LEFT JOIN FETCH s.idUsuario u LEFT JOIN FETCH s.idProfesionalAsignado p LEFT JOIN FETCH s.idTipoCertificacion order by s.idSolicitud desc";
        try{

           lista = session.createQuery(hql).setParameter("idUser", idUser).setMaxResults(100).list();
            t.commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage()+"error en lista solicitud");
            t.rollback();
        }
        
        return lista;
    }
    
    
}
