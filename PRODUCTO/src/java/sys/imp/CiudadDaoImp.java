/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.imp;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.CiudadDao;
import sys.model.Ciudad;
import sys.util.HibernateUtil;

/**
 *
 * @author omar.mahecha
 */
public class CiudadDaoImp implements CiudadDao {
    private Session session;
    private Transaction t;
    @Override
    public List<Ciudad> listarCiudad() throws Exception {
        List<Ciudad> lista = null;
         session = HibernateUtil.getSessionFactory().openSession();
         t = session.beginTransaction();
         String hql = "From Ciudad c order by c.nomCiu";
    try{
        lista = session.createQuery(hql).list();
        t.commit();
    }catch(HibernateException e){
        System.out.println("error en lista Ciudad "+e.getMessage());
        t.rollback();
    }finally{

                session.close();    

        }
    return lista;

    }

    @Override
    public List<Ciudad> listarCiudadPorDpto(String dpto) throws Exception {
        List<Ciudad> lista = null;
         session = HibernateUtil.getSessionFactory().openSession();
         t = session.beginTransaction();
         String hql = "from Ciudad WHERE nomDpto = :dpto";
    try{
        lista = session.createQuery(hql).setParameter("dpto", dpto).list();
        t.commit();
    }catch(HibernateException e){
        System.out.println("error en lista Ciudad "+e.getMessage());
        t.rollback();
    }finally{

                session.close();    

        }
    return lista;

    }
    
}
