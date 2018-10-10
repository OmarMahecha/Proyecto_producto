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
import sys.dao.EstadoDao;
import sys.model.Estado;
import sys.util.HibernateUtil;

/**
 *
 * @author omar.mahecha
 */
public class EstadoImp implements EstadoDao{
    private Session session;
    private Transaction t;
    @Override
    public List<Estado> ListarEstado() {
        session = null;
        t = null;
        List<Estado> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        String hql="SELECT e FROM Estado e";
        try{

           lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage()+"error en lista Estado");
            t.rollback();
        }
        
        return lista;
    }

    @Override
    public void newEstado(Estado estado) {
        session = null;
        t = null;
        try{
       session = HibernateUtil.getSessionFactory().openSession();
       t = session.beginTransaction();
       session.save(estado);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Estado creado con éxito",null));
       t.commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Estado no se pudo guardar, Informe al administrador",null));
        }finally{
                session.close();    

        }  
    }

    @Override
    public void updateEstado(Estado Estado) {
          session = null;
        t = null;
        try{
        
        session= HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        session.update(Estado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Estado Modificada con éxito",null));
        t.commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No fue posible modificar la Estado, Informe al administrador",null));
        }finally{
                session.close();

        }
    }

    @Override
    public void deleteEstado(Estado Estado) {
         session = null;
        t = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            t = session.beginTransaction();
            session.delete(Estado);
            t.commit();
            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
        }finally{
            
                session.close();
            
        }
    }
    
    
}

