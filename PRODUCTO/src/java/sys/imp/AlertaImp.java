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
import sys.dao.AlertaDao;
import sys.model.Alerta;
import sys.util.HibernateUtil;

/**
 *
 * @author omar.mahecha
 */
public class AlertaImp implements AlertaDao{
    private Session session;
    private Transaction t;
    @Override
    public List<Alerta> ListarAlerta() {
        session = null;
        t = null;
        List<Alerta> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        String hql="SELECT a FROM Alerta a";
        try{

           lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage()+"error en lista Alerta");
            t.rollback();
        }
        
        return lista;
    }

    @Override
    public void newAlerta(Alerta Alerta) {
        session = null;
        t = null;
        try{
       session = HibernateUtil.getSessionFactory().openSession();
       t = session.beginTransaction();
       session.save(Alerta);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta creada con éxito",null));
       t.commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta no se pudo guardar, Informe al administrador",null));
        }finally{
                session.close();    

        }  
    }

    @Override
    public void updateAlerta(Alerta Alerta) {
          session = null;
        t = null;
        try{
        
        session= HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        session.update(Alerta);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta Modificada con éxito",null));
        t.commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No fue posible modificar la Alerta, Informe al administrador",null));
        }finally{
                session.close();

        }
    }

    @Override
    public void deleteAlerta(Alerta Alerta) {
         session = null;
        t = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            t = session.beginTransaction();
            session.delete(Alerta);
            t.commit();
            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
        }finally{
            
                session.close();
            
        }
    }
    
    
}

