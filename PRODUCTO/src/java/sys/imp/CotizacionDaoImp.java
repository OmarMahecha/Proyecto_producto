/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.imp;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.CotizacionDao;
import sys.model.Cotizacion;
import sys.util.HibernateUtil;

/**
 *
 * @author omar.mahecha
 */
public class CotizacionDaoImp implements CotizacionDao{

    @Override
    public Cotizacion obtenerCotizacionPorNumero(Session session, String num) throws Exception {
       String hql = "select min(c) FROM Cotizacion c  where cotizacion = :cotizacion";
       Query q = session.createQuery(hql);
        q.setParameter("cotizacion", num);

        return (Cotizacion) q.uniqueResult();
    }

    @Override
    public List<Cotizacion> ListarCotizaciones(String num) {
        List<Cotizacion> lista = null;
         //SQLQuery query;
         Query query;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        String hql = "FROM Cotizacion where cotizacion = :cotizacion";     
       // String hql="select * from Vista_cotizacion where Cotizacion = ?";
        
       
        try{
            query = session.createQuery(hql); 
            //createSQLQuery(hql);
            //query.setParameter(0, num);
            query.setParameter("cotizacion", num);
            //query.addEntity("Vista_cotizacion", Cotizacion.class);
            //query.setFirstResult(7 * max);
            lista = query.list();
            t. commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage()+" error consulta cotizacion");
            t.rollback();
        }
        
        return lista;
    }

    @Override
    public String totalCotizacion(String num) throws Exception {
        String total = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "SELECT CAST(sum(total) + ((sum(total)*iva)/100)AS string) as totales FROM Cotizacion as c where c.cotizacion = :cotizacion group by iva";
        Query q = session.createQuery(hql);
        q.setParameter("cotizacion", num);
        total = (String) q.uniqueResult();
        t. commit();
        session.close();
        return total;
    }
    
}
