/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import sys.dao.SolicitudDao;
import sys.imp.SolicitudImp;
import sys.model.Estado;
import sys.model.Solicitud;
import sys.model.Usuario;

/**
 *
 * @author omar.mahecha
 */
@Named(value = "solicitudBean")
@SessionScoped
public class SolicitudBean implements Serializable {
    private List<Solicitud> listaSolicitudes;
    private Solicitud solicitud;
    /**
     * Creates a new instance of SolicitudBean
     */
    public SolicitudBean() {
    }

    public List<Solicitud> getListaSolicitudes() {
        SolicitudImp sDao = new SolicitudImp();
        listaSolicitudes = sDao.ListarSolicitudes();
        return listaSolicitudes;
    }

    public void setListaSolicitudes(List<Solicitud> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
    public void prepararNuevaSolicitud(){
        this.solicitud = new Solicitud();
    }
    
        public void nuevoCliente() {
        try {
    Usuario us = null;
                Date fechaSolicitud = new Date();
                this.solicitud.setFechaCreacion(fechaSolicitud);
                Estado est = new Estado();
                est.setIdEstado(1);
                this.solicitud.setIdEstadoActual(est);
                this.solicitud.setEsAtipico(Boolean.FALSE);
                this.solicitud.setEsPrioridad(Boolean.FALSE);
                FacesContext context = FacesContext. getCurrentInstance();
                us = (Usuario) context.getExternalContext().getSessionMap().get("ULogueado");
                this.solicitud.setIdUsuario(us);
                 SolicitudDao sDao = new SolicitudImp();
                sDao.newSolicitud(solicitud);
                this.prepararNuevaSolicitud();
                 } catch (Exception e) {
            System.out.println("Error al Guardar solicitud " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A ocurrido un error al guardar la solicitud", null));
        }
        }
}
