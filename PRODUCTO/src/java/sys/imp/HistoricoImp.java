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
import sys.dao.HistoricoDao;
import sys.model.Historico;
import sys.util.HibernateUtil;

/**
 *
 * @author omar.mahecha
 */
public class HistoricoImp implements HistoricoDao {

    private Session session;
    private Transaction t;

    @Override
    public List<Historico> ListarHistorico(int soli) {
        session = null;
        t = null;
        List<Historico> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        String hql = "SELECT h FROM Historico h left join fetch h.idSolicitud s left join fetch h.idEstado e left join fetch h.idUsuario u where s.idSolicitud = :soli order by h.fechaActualizacion desc";
        try {

            lista = session.createQuery(hql).setParameter("soli", soli).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage() + "error en lista Historico");
            t.rollback();
        }

        return lista;
    }

    @Override
    public void newHistorico(Historico Historico) {
        session = null;
        t = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            t = session.beginTransaction();
            session.save(Historico);
            t.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Historico creada con éxito", null));
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            t.rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Historico no se pudo guardar, Informe al administrador", null));
        } finally {
            session.close();

        }
    }

    @Override
    public void updateHistorico(Historico Historico) {
        session = null;
        t = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            t = session.beginTransaction();
            session.update(Historico);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Historico Modificada con éxito", null));
            t.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            t.rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No fue posible modificar la Historico, Informe al administrador", null));
        } finally {
            session.close();

        }
    }

    @Override
    public void deleteHistorico(Historico Historico) {
        session = null;
        t = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            t = session.beginTransaction();
            session.delete(Historico);
            t.commit();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            t.rollback();
        } finally {

            session.close();

        }
    }

    @Override
    public Historico obtieneUltimoHistorico(int soli) {
        session = null;
        t = null;
        Historico historico = new Historico();
        session = HibernateUtil.getSessionFactory().openSession();
        t = session.beginTransaction();
        String hql = "SELECT max(h) FROM Historico h left join  h.idSolicitud s left join  h.idEstado e left join  h.idUsuario u where s.idSolicitud = :soli";
        try {

            historico = (Historico) session.createQuery(hql).setParameter("soli", soli).uniqueResult();

            t.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage() + "error al obtener Historico");
            t.rollback();
        }

        return historico;
    }

}
