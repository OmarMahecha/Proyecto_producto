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
import sys.dao.TipoAdjuntoDao;
import sys.model.TipoAdjunto;
import sys.model.TipoAdjuntoPerfil;
import sys.util.HibernateUtil;

/**
 *
 * @author omar.mahecha
 */
public class TipoAdjuntoImp implements TipoAdjuntoDao{
    private Session session;
    private Transaction t;
    @Override
    public List<TipoAdjunto> ListarTipoAdjunto() {
        session = null;
        t = null;
        List<TipoAdjunto> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        String hql="SELECT t FROM TipoAdjunto t";
        try{

           lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage()+"error en lista TipoAdjunto");
            t.rollback();
        }
        
        return lista;
    }

    @Override
    public void newTipoAdjunto(TipoAdjunto tipoAdjunto) {
        session = null;
        t = null;
        try{
       session = HibernateUtil.getSessionFactory().openSession();
       t = session.beginTransaction();
       session.save(tipoAdjunto);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"TipoAdjunto creada con éxito",null));
       t.commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"TipoAdjunto no se pudo guardar, Informe al administrador",null));
        }finally{
                session.close();    

        }  
    }

    @Override
    public void updateTipoAdjunto(TipoAdjunto tipoAdjunto) {
          session = null;
        t = null;
        try{
        
        session= HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        session.update(tipoAdjunto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"TipoAdjunto Modificada con éxito",null));
        t.commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No fue posible modificar la TipoAdjunto, Informe al administrador",null));
        }finally{
                session.close();

        }
    }

    @Override
    public void deleteTipoAdjunto(TipoAdjunto tipoAdjunto) {
         session = null;
        t = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            t = session.beginTransaction();
            session.delete(tipoAdjunto);
            t.commit();
            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
        }finally{
            
                session.close();
            
        }
    }

    @Override
    public List<TipoAdjunto> ListarTipoAdjuntoPorPerfil(int perfil, int estado, int soli) {
        session = null;
        t = null;
        List<TipoAdjunto> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        String hql="select a from TipoAdjuntoPerfil t INNER JOIN  t.idTipoAdjunto a  inner join t.idPerfil p inner join t.idEstado e where (p.idPerfil = :perfil and e.idEstado = :estado) and a.idTipoAdjunto not in (select t from Adjunto a inner join  a.idSolicitud  s inner join   a.idTipoAdjunto t where s.idSolicitud = :soli)";
        try{

           lista = session.createQuery(hql).setParameter("perfil", perfil).setParameter("estado", estado).setParameter("soli", soli).list();
            t.commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage()+"error en lista TipoAdjuntoPerfil");
            t.rollback();
        }
        
        return lista;
    }
    
    
}