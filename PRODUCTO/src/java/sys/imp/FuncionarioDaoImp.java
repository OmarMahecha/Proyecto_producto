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
import sys.dao.FuncionarioDao;
import sys.model.Funcionario;
import sys.util.HibernateUtil;

/**
 *
 * @author omar.mahecha
 */
public class FuncionarioDaoImp implements FuncionarioDao{
    private Session session;
    private Transaction t;
    @Override
    public List<Funcionario> Listafuncionario() {
        List<Funcionario> lista = null;
         session = HibernateUtil.getSessionFactory().openSession();
         t = session.beginTransaction();
         String hql = "select f From Funcionario f where not exists (select  u  from Usuario u where u.cedula = f) order by f.nombres";
    try{
        lista = session.createQuery(hql).list();
        t.commit();
    }catch(HibernateException e){
        System.out.println("error en lista funcionario "+e.getMessage());
        t.rollback();
    }finally{

                session.close();    

        }
    return lista;

    }
    
}
