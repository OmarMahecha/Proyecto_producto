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
import sys.dao.RegionalDao;
import sys.model.Regional;
import sys.util.HibernateUtil;

/**
 *
 * @author omar.mahecha
 */
public class RegionalDaoImp implements RegionalDao{
    private Session session;
    private Transaction t;
    
    @Override
    public List<Regional> ListaRegional() {
        List<Regional> lista = null;
         session = HibernateUtil.getSessionFactory().openSession();
         t = session.beginTransaction();
         String hql = "From Regional";
    try{
        lista = session.createQuery(hql).list();
        t.commit();
    }catch(HibernateException e){
        System.out.println("error en lista Regional "+e.getMessage());
        t.rollback();
    }finally{

                session.close();    

        }
    return lista;

    }
    
}
