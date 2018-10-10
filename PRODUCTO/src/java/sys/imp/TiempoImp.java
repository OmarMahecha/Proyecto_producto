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
import sys.dao.TiempoDao;
import sys.model.Tiempo;
import sys.util.HibernateUtil;

/**
 *
 * @author omar.mahecha
 */
public class TiempoImp implements TiempoDao{
    private Session session;
    private Transaction t;
    @Override
    public List<Tiempo> ListarTiempo() {
        session = null;
        t = null;
        List<Tiempo> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        String hql="SELECT t FROM Tiempo t";
        try{

           lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage()+"error en lista Tiempo");
            t.rollback();
        }
        
        return lista;
    }

    @Override
    public void newTiempo(Tiempo tiempo) {
        session = null;
        t = null;
        try{
       session = HibernateUtil.getSessionFactory().openSession();
       t = session.beginTransaction();
       session.save(tiempo);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Tiempo creada con éxito",null));
       t.commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Tiempo no se pudo guardar, Informe al administrador",null));
        }finally{
                session.close();    

        }  
    }

    @Override
    public void updateTiempo(Tiempo tiempo) {
          session = null;
        t = null;
        try{
        
        session= HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        session.update(tiempo);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Tiempo Modificada con éxito",null));
        t.commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No fue posible modificar la Tiempo, Informe al administrador",null));
        }finally{
                session.close();

        }
    }

    @Override
    public void deleteTiempo(Tiempo tiempo) {
         session = null;
        t = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            t = session.beginTransaction();
            session.delete(tiempo);
            t.commit();
            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
        }finally{
            
                session.close();
            
        }
    }
    
    
}

