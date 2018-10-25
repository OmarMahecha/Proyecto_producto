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
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import sys.dao.TipoAdjuntoDao;
import sys.imp.TipoAdjuntoImp;
import sys.imp.TipoAdjuntoPerfilImp;
import sys.model.Solicitud;
import sys.model.TipoAdjunto;
import sys.model.TipoAdjuntoPerfil;
import sys.model.Usuario;

/**
 *
 * @author omar.mahecha
 */
@Named(value = "tipoAdjuntoBean")
@SessionScoped
public class TipoAdjuntoBean implements Serializable {

 private List<TipoAdjunto> listaTipoAdjuntos;
    private TipoAdjunto tipoAdjunto;
    private List<TipoAdjunto> listaTipoPorPerfil;
    private int estado;
    private int soli;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getSoli() {
        return soli;
    }

    public void setSoli(int soli) {
        this.soli = soli;
    }
    
    

    public List<TipoAdjunto> getListaTipoPorPerfil() { 
        int id = 0;
        FacesContext context = FacesContext.getCurrentInstance();
        Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("ULogueado");
        id = us.getIdPerfil().getIdPerfil();
        TipoAdjuntoImp sDao = new TipoAdjuntoImp();
        listaTipoPorPerfil = sDao.ListarTipoAdjuntoPorPerfil(id, estado, soli);
        this.estado =  0;
        this.soli =  0;
        return listaTipoPorPerfil;
    }

    public void setListaTipoPorPerfil(List<TipoAdjunto> listaTipoPorPerfil) {
        this.listaTipoPorPerfil = listaTipoPorPerfil;
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
