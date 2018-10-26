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
import sys.dao.TipoAdjuntoPerfilDao;
import sys.model.TipoAdjuntoPerfil;
import sys.util.HibernateUtil;

/**
 *
 * @author omar.mahecha
 */
public class TipoAdjuntoPerfilImp implements TipoAdjuntoPerfilDao {

    private Session session;
    private Transaction t;

    @Override
    public List<TipoAdjuntoPerfil> ListarTipoAdjuntoPerfil() {
        session = null;
        t = null;
        List<TipoAdjuntoPerfil> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        String hql="select t from TipoAdjuntoPerfil t INNER JOIN FETCH t.idTipoAdjunto inner join fetch t.idPerfil";
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
    public void newTipoAdjuntoPerfil(TipoAdjuntoPerfil tipoAdjuntoPerfil) {
        session = null;
        t = null;
        try{
       session = HibernateUtil.getSessionFactory().openSession();
       t = session.beginTransaction();
       session.save(tipoAdjuntoPerfil);
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
    public void updateTipoAdjuntoPerfil(TipoAdjuntoPerfil tipoAdjuntoPerfil) {
        session = null;
        t = null;
        try{
        
        session= HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        session.update(tipoAdjuntoPerfil);
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
    public void deleteTipoAdjuntoPerfil(TipoAdjuntoPerfil tipoAdjuntoPerfil) {
         session = null;
        t = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            t = session.beginTransaction();
            session.delete(tipoAdjuntoPerfil);
            t.commit();
            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            t.rollback();
        }finally{
            
                session.close();
            
        }
    }

    @Override
    public List<TipoAdjuntoPerfil> ListarTipoAdjuntoPorPerfil(int perfil, int estado, int soli) {
        session = null;
        t = null;
        List<TipoAdjuntoPerfil> lista = null;
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