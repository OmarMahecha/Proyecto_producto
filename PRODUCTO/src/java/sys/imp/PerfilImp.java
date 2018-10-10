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
import sys.dao.PerfilDao;
import sys.model.Perfil;
import sys.util.HibernateUtil;

/**
 *
 * @author omar.mahecha
 */
public class PerfilImp implements PerfilDao{
    private Session session;
    private Transaction t;
    @Override
    public List<Perfil> ListarPerfil() {
        session = null;
        t = null;
        List<Perfil> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        String hql="SELECT p FROM Perfil p";
        try{

           lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage()+"error en lista Perfil");
            t.rollback();
        }
        
        return lista;
    }

    @Override
    public void newPerfil(Perfil perfil) {
        session = null;
        t = null;
        try{
       session = HibernateUtil.getSessionFactory().openSession();
       t = session.beginTransaction();
       session.save(perfil);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Perfil creada con éxito",null));
       t.commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Perfil no se pudo guardar, Informe al administrador",null));
        }finally{
                session.close();    

        }  
    }

    @Override
    public void updatePerfil(Perfil perfil) {
          session = null;
        t = null;
        try{
        
        session= HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        session.update(perfil);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Perfil Modificado con éxito",null));
        t.commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No fue posible modificar el Perfil, Informe al administrador",null));
        }finally{
                session.close();

        }
    }

    @Override
    public void deletePerfil(Perfil perfil) {
         session = null;
        t = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            t = session.beginTransaction();
            session.delete(perfil);
            t.commit();
            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No fue posible eliminar el Perfil, Informe al administrador",null));
        }finally{
            
                session.close();
            
        }
    }
    
    
}

