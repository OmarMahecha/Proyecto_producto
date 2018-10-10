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
import sys.dao.TipoAdjuntoDao;
import sys.imp.TipoAdjuntoImp;
import sys.model.TipoAdjunto;

/**
 *
 * @author omar.mahecha
 */
@Named(value = "tipoAdjuntoBean")
@SessionScoped
public class TipoAdjuntoBean implements Serializable {

 private List<TipoAdjunto> listaTipoAdjuntos;
    private TipoAdjunto tipoAdjunto;
    /**
     * Creates a new instance of TipoAdjuntoBean
     */
    public TipoAdjuntoBean() {
    }
    
    public void prepararNuevoTipoAdjunto(){
        this.tipoAdjunto = new TipoAdjunto();
    }

    public List<TipoAdjunto> getListaTipoAdjuntos() {
        TipoAdjuntoImp sDao = new TipoAdjuntoImp();
        listaTipoAdjuntos = sDao.ListarTipoAdjunto();        

        return listaTipoAdjuntos;
    }

    public void setListaTipoAdjuntos(List<TipoAdjunto> listaTipoAdjuntos) {
        this.listaTipoAdjuntos = listaTipoAdjuntos;
    }

    public TipoAdjunto getTipoAdjunto() {
        return tipoAdjunto;
    }

    public void setTipoAdjunto(TipoAdjunto tipoAdjunto) {
        this.tipoAdjunto = tipoAdjunto;
    }
    
        public void nuevoTipoAdjunto(){
        TipoAdjuntoDao tDao = new TipoAdjuntoImp();
        tDao.newTipoAdjunto(tipoAdjunto);
        prepararNuevoTipoAdjunto();
        RequestContext context = RequestContext.getCurrentInstance();
            context.update("formTipoAdjunto");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogTipoAdjunto').hide();");
    }
    
    public void editarTipoAdjunto(){
        TipoAdjuntoDao pDao = new TipoAdjuntoImp();
        pDao.updateTipoAdjunto(tipoAdjunto);
        prepararNuevoTipoAdjunto();
                RequestContext context = RequestContext.getCurrentInstance();
            context.update("formTipoAdjunto");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogEditarTipoAdjunto').hide();");
    }
    public void eliminarTipoAdjunto(){
    TipoAdjuntoDao pDao = new TipoAdjuntoImp();
        pDao.deleteTipoAdjunto(tipoAdjunto);
        prepararNuevoTipoAdjunto();
                RequestContext context = RequestContext.getCurrentInstance();
            context.update("formTipoAdjunto");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogEliminarTipoAdjunto').hide();");
    }

    
}
