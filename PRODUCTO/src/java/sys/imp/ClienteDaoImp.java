/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.imp;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.ClienteDao;
import sys.model.Cliente;
import sys.util.HibernateUtil;

/**
 *
 * @author omar.mahecha
 */
public class ClienteDaoImp implements ClienteDao{
        private Session session;
        private Transaction t;
    @Override
   
    public List<Cliente> ListarClientes() {
        session = null;
        t = null;
         List<Cliente> lista = null;
         Query query;
         session = HibernateUtil.getSessionFactory().openSession();
         t = session.beginTransaction();
        //String hql="SELECT s FROM Solicitud s LEFT JOIN FETCH s.fkIdEstadoSolicitud LEFT JOIN FETCH s.fkIdPatron";
        String hql="From Cliente";
       
        try{
            query = session.createQuery(hql);
            int max = 100;
            query.setMaxResults(max);
            //query.setFirstResult(7 * max);
            lista = query.list();
            t.commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage()+" error consulta cliente");
            t.rollback();
        }
        
        return lista;
    }

    @Override
    public Cliente obtenerClientePorCodigo(String ident){
        session = null;
        t = null;
       Cliente cliente = null;
        try{
         session = HibernateUtil.getSessionFactory().openSession();
         t = session.beginTransaction();
        String hql = "FROM Cliente where identificacion = :identificacion";
        Query q = session.createQuery(hql);
        q.setParameter("identificacion", ident);
        cliente = (Cliente) q.uniqueResult();
        t.commit();
        session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage()+" error consulta cliente");
            t.rollback();
    }
        return cliente;
    }
}
