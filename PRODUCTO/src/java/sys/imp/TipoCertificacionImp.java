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
import sys.dao.TipoCertificacionDao;
import sys.model.TipoCertificacion;
import sys.util.HibernateUtil;

/**
 *
 * @author omar.mahecha
 */
public class TipoCertificacionImp implements TipoCertificacionDao{
    private Session session;
    private Transaction t;

    @Override
    public List<TipoCertificacion> ListarTipoCertificacion() {
        session = null;
        t = null;
        List<TipoCertificacion> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        String hql="SELECT t FROM TipoCertificacion t";
        try{

           lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage()+"error en lista de Tipo de Certificacion");
            t.rollback();
        }
        
        return lista;
    }

    @Override
    public void newTipoCertificacion(TipoCertificacion tipo) {
                session = null;
        t = null;
        try{
       session = HibernateUtil.getSessionFactory().openSession();
       t = session.beginTransaction();
       session.save(tipo);
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
    public void updateTipoCertificacion(TipoCertificacion tipo) {
          session = null;
        t = null;
        try{
        
        session= HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        session.update(tipo);
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
    public void deleteTipoCertificacion(TipoCertificacion tipo) {
           session = null;
        t = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            t = session.beginTransaction();
            session.delete(tipo);
            t.commit();
            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
        }finally{
            
                session.close();
            
        }
    }
}
