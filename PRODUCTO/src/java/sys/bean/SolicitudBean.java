/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.poi.util.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import sys.dao.ClienteDao;
import sys.dao.SolicitudDao;
import sys.imp.ClienteDaoImp;
import sys.imp.SolicitudImp;
import sys.model.Cliente;
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
    private String idCliente;
    private Cliente cliente;
    private String dpto;
    private String archivo;
    private byte[] contenido;

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

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public void prepararNuevaSolicitud() {
        this.solicitud = new Solicitud();
        this.dpto = null;
    }

    public void agregarDatosCliente() {
        ClienteDao cDao = new ClienteDaoImp();
        this.cliente = cDao.obtenerClientePorCodigo(idCliente);
        if (this.cliente != null) {
            this.idCliente = null;
            this.solicitud.setIdentificacionCliente(this.cliente);
            this.cliente = new Cliente();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente encontrado en Ofimatica", null));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cliente no encontrado en Ofimatica", null));
            this.solicitud.setIdentificacionCliente(null);
            this.idCliente = null;

        }
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
            this.solicitud.setCiudadDepartamento(dpto);
            FacesContext context = FacesContext.getCurrentInstance();
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
