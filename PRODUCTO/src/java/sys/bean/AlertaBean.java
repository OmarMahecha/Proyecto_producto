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
import sys.dao.AlertaDao;
import sys.imp.AlertaImp;
import sys.model.Alerta;

/**
 *
 * @author omar.mahecha
 */
@Named(value = "alertaBean")
@SessionScoped
public class AlertaBean implements Serializable {

    private List<Alerta> listaAlertas;
    private Alerta alerta;
    /**
     * Creates a new instance of AlertaBean
     */
    public AlertaBean() {
    }
    
    public void prepararNuevoAlerta(){
        this.alerta = new Alerta();
    }

    public List<Alerta> getListaAlertas() {
        AlertaImp sDao = new AlertaImp();
        listaAlertas = sDao.ListarAlerta();        
          return listaAlertas;
    }

    public void setListaAlertas(List<Alerta> listaAlertas) {
        this.listaAlertas = listaAlertas;
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }
    
        public void nuevoAlerta(){
        AlertaDao pDao = new AlertaImp();
        pDao.newAlerta(alerta);
        prepararNuevoAlerta();
        RequestContext context = RequestContext.getCurrentInstance();
            context.update("formAlerta");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogAlerta').hide();");
    }
    
    public void editarAlerta(){
        AlertaDao pDao = new AlertaImp();
        pDao.updateAlerta(alerta);
        prepararNuevoAlerta();
        RequestContext context = RequestContext.getCurrentInstance();
            context.update("formAlerta");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogEditarAlerta').hide();");
    }
    public void eliminarAlerta(){
    AlertaDao pDao = new AlertaImp();
        pDao.deleteAlerta(alerta);
        prepararNuevoAlerta();
        RequestContext context = RequestContext.getCurrentInstance();
            context.update("formAlerta");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogEliminarAlerta').hide();");
    }

    
}
