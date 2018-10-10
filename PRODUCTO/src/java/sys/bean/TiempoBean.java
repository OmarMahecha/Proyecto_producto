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
import sys.dao.TiempoDao;
import sys.imp.TiempoImp;
import sys.model.Tiempo;

/**
 *
 * @author omar.mahecha
 */
@Named(value = "tiempoBean")
@SessionScoped
public class TiempoBean implements Serializable {

   private List<Tiempo> listaTiempos;
    private Tiempo tiempo;
    /**
     * Creates a new instance of TiempoBean
     */
    public TiempoBean() {
    }
    
    public void prepararNuevoTiempo(){
        this.tiempo = new Tiempo();
    }

    public List<Tiempo> getListaTiempos() {
        TiempoDao sDao = new TiempoImp();
        listaTiempos = sDao.ListarTiempo();        
return listaTiempos;
    }

    public void setListaTiempos(List<Tiempo> listaTiempos) {
        this.listaTiempos = listaTiempos;
    }

    public Tiempo getTiempo() {
        return tiempo;
    }

    public void setTiempo(Tiempo tiempo) {
        this.tiempo = tiempo;
    }
    
        public void nuevoTiempo(){
        TiempoDao pDao = new TiempoImp();
        pDao.newTiempo(tiempo);
        prepararNuevoTiempo();
        RequestContext context = RequestContext.getCurrentInstance();
            context.update("formTiempo");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogTiempo').hide();");
    }
    
    public void editarTiempo(){
        TiempoDao pDao = new TiempoImp();
        pDao.updateTiempo(tiempo);
        prepararNuevoTiempo();
        RequestContext context = RequestContext.getCurrentInstance();
            context.update("formTiempo");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogEditarTiempo').hide();");
    }
    public void eliminarTiempo(){
    TiempoDao pDao = new TiempoImp();
        pDao.deleteTiempo(tiempo);
        prepararNuevoTiempo();
        RequestContext context = RequestContext.getCurrentInstance();
            context.update("formTiempo");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogEliminarTiempo').hide();");
    }

    
}
