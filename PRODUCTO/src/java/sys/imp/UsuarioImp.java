/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.imp;

import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.UsuarioDao;
import sys.model.Usuario;
import sys.util.HibernateUtil;
/**
 *
 * @author omar.mahecha
 */
public class UsuarioImp implements UsuarioDao, Serializable {

    @Override
    public List<Usuario> ListarUsuario() {
        List<Usuario> lista = null;
        Session session= null;
         session = HibernateUtil.getSessionFactory().openSession();
         Transaction t;
         t = session.beginTransaction();
         String hql = "From Usuario u inner join fetch u.idPerfil p inner join fetch u.cedula c order by  u.idUsuario desc";
    try{
        lista = session.createQuery(hql).list();
        t.commit();
    }catch(HibernateException e){
        System.out.println("error en lista de Usuarios"+e.getMessage());
        t.rollback();
    }finally{   
            session.close();
        }
    return lista;

    }

    @Override
    public void newUsuario(Usuario usuario) throws Exception {

        Session session= null;
        try{
       session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       session.save(usuario);
       session.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
                session.close();    
        }  

    }

    @Override
    public void updateUsuario(Usuario usuario) {
         Session session= null;
        try{
        
        session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
                session.close();
        }

    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        Session session= null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(usuario);
            session.getTransaction().commit();
            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{

                session.close();

        }

    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {
        Usuario usuario = null;
        Session session= null;
        Transaction t = null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        String hql = "SELECT u FROM Usuario u inner JOIN FETCH  u.idPerfil p inner join fetch u.cedula WHERE u.idUsuario = :id";
        Query q = session.createQuery(hql);
        q.setParameter("id", id);
        usuario = (Usuario) q.uniqueResult();
        t.commit();
        session.close();
        }catch(HibernateException e){
            System.out.println(e);
            t.rollback();
            
        }
        
        return usuario;
    }

    @Override
    public Usuario obtenerUporUsuario(String nameUs) {
        Usuario usuario = null;
        Session session= null;
        Transaction t = null;
        try{
        
         session = HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        String hql = "FROM Usuario u left join fetch u.idPerfil inner join fetch u.cedula where u.usuario = :nameUs ";
        Query q = session.createQuery(hql);
        q.setParameter("nameUs", nameUs);
        usuario = (Usuario) q.uniqueResult();
        t.commit();
        session.close();
        }catch(HibernateException e){
            System.out.println(e);
            t.rollback();
        }
        
        return usuario;
    }
    
}
