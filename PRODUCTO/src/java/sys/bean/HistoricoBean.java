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
import sys.dao.HistoricoDao;
import sys.imp.HistoricoImp;
import sys.model.Historico;

/**
 *
 * @author omar.mahecha
 */
@Named(value = "historicoBean")
@SessionScoped
public class HistoricoBean implements Serializable {
 
    /**
     * Creates a new instance of HistoricoBean
     */
    public HistoricoBean() {
    }
    
    private List<Historico> listaHistoricos;
    private Historico historico;
    private int idSolicitud;

    public List<Historico> getListaHistoricos() {
        HistoricoDao hDao = new HistoricoImp();
        listaHistoricos = hDao.ListarHistorico(idSolicitud);
        return listaHistoricos;
    }

    public void setListaHistoricos(List<Historico> listaHistoricos) {
        this.listaHistoricos = listaHistoricos;
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    
    public void limpiaH(){
        idSolicitud = 0;
        setListaHistoricos(null);
        
    }
    
    
}
