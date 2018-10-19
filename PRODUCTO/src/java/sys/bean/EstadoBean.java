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
import sys.dao.EstadoDao;
import sys.dao.PerfilDao;
import sys.imp.EstadoImp;
import sys.model.Estado;


/**
 *
 * @author omar.mahecha
 */
@Named(value = "estadoBean")
@SessionScoped
public class EstadoBean implements Serializable {
    private List<Estado> listaEstados;
    private Estado estado;
    /**
     * Creates a new instance of EstadoBean
     */
    public EstadoBean() {
    }
    
    public void prepararNuevoEstado(){
        this.estado = new Estado();
    }

    public List<Estado> getListaEstados() {
        EstadoImp sDao = new EstadoImp();
        listaEstados = sDao.ListarEstado();
        return listaEstados;
    }

    public void setListaEstados(List<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
        public void nuevoEstado(){
        EstadoDao pDao = new EstadoImp();
        pDao.newEstado(estado);
        prepararNuevoEstado();
        RequestContext context = RequestContext.getCurrentInstance();
            context.update("formEstado");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogEstado').hide();");
    }
    
    public void editarEstado(){
        EstadoDao pDao = new EstadoImp();
        pDao.updateEstado(estado);
        prepararNuevoEstado();
        RequestContext context = RequestContext.getCurrentInstance();
            context.update("formEstado");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogEditarEstado').hide();");
    }
    public void eliminarEstado(){
    EstadoDao pDao = new EstadoImp();
        pDao.deleteEstado(estado);
        prepararNuevoEstado();
        RequestContext context = RequestContext.getCurrentInstance();
            context.update("formEstado");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogEliminarEstado').hide();");
    }
    
     public static final int CREADA = 1;
    public static final int ENVIADA_A_PROFESIONAL_CERTIFICACION = 2;
    public static final int RECHAZADA_POR_PROFESIONAL_CERTIFICACION = 5;
    public static final int APROBADA_POR_PROFESIONAL_CERTIFICACION = 4;
    public static final int COTIZACION_RELACIONADA = 6;

    public int getCREADA() {
        return CREADA;
    }

    public int getENVIADA_A_PROFESIONAL_CERTIFICACION() {
        return ENVIADA_A_PROFESIONAL_CERTIFICACION;
    }

    public int getRECHAZADA_POR_PROFESIONAL_CERTIFICACION() {
        return RECHAZADA_POR_PROFESIONAL_CERTIFICACION;
    }

    public int getAPROBADA_POR_PROFESIONAL_CERTIFICACION() {
        return APROBADA_POR_PROFESIONAL_CERTIFICACION;
    }
}
