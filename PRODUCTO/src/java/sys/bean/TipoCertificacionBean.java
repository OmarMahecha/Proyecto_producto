/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import org.primefaces.context.RequestContext;
import sys.dao.TipoCertificacionDao;
import sys.imp.TipoCertificacionImp;
import sys.model.TipoCertificacion;

/**
 *
 * @author omar.mahecha
 */
@Named(value = "tipoCertificacionBean")
@SessionScoped
public class TipoCertificacionBean implements Serializable {

    private List<TipoCertificacion> listaTipoCertificacion;
    private TipoCertificacion tipoCertificacion;

    /**
     * Creates a new instance of TipoCertificacionBean
     */
    public TipoCertificacionBean() {
    }

     public void prepararNuevoTipoCertificacion(){
        this.tipoCertificacion = new TipoCertificacion();
    }

    public List<TipoCertificacion> getListaTipoCertificacions() {
        TipoCertificacionImp sDao = new TipoCertificacionImp();
        listaTipoCertificacion = sDao.ListarTipoCertificacion();        
          return listaTipoCertificacion;
    }

    public void setListaTipoCertificacions(List<TipoCertificacion> listaTipoCertificacion) {
        this.listaTipoCertificacion = listaTipoCertificacion;
    }

    public TipoCertificacion getTipoCertificacion() {
        return tipoCertificacion;
    }

    public void setTipoCertificacion(TipoCertificacion tipoCertificacion) {
        this.tipoCertificacion = tipoCertificacion;
    }
    
        public void nuevoTipoCertificacion(){
        TipoCertificacionDao pDao = new TipoCertificacionImp();
        pDao.newTipoCertificacion(tipoCertificacion);
        prepararNuevoTipoCertificacion();
        RequestContext context = RequestContext.getCurrentInstance();
            context.update("formTipoCertificacion");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogTipoCertificacion').hide();");
    }
    
    public void editarTipoCertificacion(){
        TipoCertificacionDao pDao = new TipoCertificacionImp();
        pDao.updateTipoCertificacion(tipoCertificacion);
        prepararNuevoTipoCertificacion();
        RequestContext context = RequestContext.getCurrentInstance();
            context.update("formTipoCertificacion");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogEditarTipoCertificacion').hide();");
    }
    public void eliminarTipoCertificacion(){
    TipoCertificacionDao pDao = new TipoCertificacionImp();
        pDao.deleteTipoCertificacion(tipoCertificacion);
        prepararNuevoTipoCertificacion();
        RequestContext context = RequestContext.getCurrentInstance();
            context.update("formTipoCertificacion");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogEliminarTipoCertificacion').hide();");
    }

}
