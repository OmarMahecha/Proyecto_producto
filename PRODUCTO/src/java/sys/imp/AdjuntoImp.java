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
import sys.dao.AdjuntoDao;
import sys.model.Adjunto;
import sys.util.HibernateUtil;

/**
 *
 * @author omar.mahecha
 */
public class AdjuntoImp implements AdjuntoDao{
    private Session session;
    private Transaction t;
    @Override
    public List<Adjunto> ListarAdjunto(int idSolicitud) {
        session = null;
        t = null;
        List<Adjunto> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        String hql="SELECT a FROM Adjunto a LEFT JOIN FETCH a.idSolicitud s LEFT JOIN FETCH a.idUsuario u LEFT JOIN FETCH a.idTipoAdjunto where s.idSolicitud = :idSoli";
        try{

           lista = session.createQuery(hql).setParameter("idSoli", idSolicitud).list();
            t.commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage()+"error en lista Adjuntos");
            t.rollback();
        }
        
        return lista;
    }

    @Override
    public void newAdjunto(Adjunto adjunto) {
        session = null;
        t = null;
        try{
       session = HibernateUtil.getSessionFactory().openSession();
       t = session.beginTransaction();
       session.save(adjunto);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Adjunto creada con éxito",null));
       t.commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Adjunto no se pudo guardar, Informe al administrador",null));
        }finally{
                session.close();    

        }  
    }

    @Override
    public void updateAdjunto(Adjunto adjunto) {
          session = null;
        t = null;
        try{
        
        session= HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        session.update(adjunto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Adjunto Modificado con éxito",null));
        t.commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No fue posible modificar Adjunto, Informe al administrador",null));
        }finally{
                session.close();

        }
    }

    @Override
    public void deleteAdjunto(Adjunto adjunto) {
         session = null;
        t = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            t = session.beginTransaction();
            session.delete(adjunto);
            t.commit();
            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
        }finally{
            
                session.close();
            
        }
    }
    
    
}
