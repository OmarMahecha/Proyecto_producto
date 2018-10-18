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
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import sys.dao.ClienteDao;
import sys.dao.CotizacionDao;
import sys.dao.HistoricoDao;
import sys.dao.SolicitudDao;
import sys.imp.ClienteDaoImp;
import sys.imp.CotizacionDaoImp;
import sys.imp.HistoricoImp;
import sys.imp.SolicitudImp;
import sys.model.Cliente;
import sys.model.Cotizacion;
import sys.model.Estado;
import sys.model.Historico;
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
    private Cotizacion cotizacion;
    private String cotiza;
    private String numConf;
    private Historico historico;
    private Estado estado;
    private String obs;

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

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public String getCotiza() {
        return cotiza;
    }

    public void setCotiza(String cotiza) {
        this.cotiza = cotiza;
    }

    public String getNumConf() {
        return numConf;
    }

    public void setNumConf(String numConf) {
        this.numConf = numConf;
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void prepararNuevaSolicitud() {
        this.solicitud = new Solicitud();
        this.dpto = null;
        this.numConf = null;
        this.cotiza = null;
        this.obs = null;
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
            this.nuevoHistoricoSolicitud(solicitud, Estado.CREADA, "");
            this.prepararNuevaSolicitud();
        } catch (Exception e) {
            System.out.println("Error al Guardar solicitud " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A ocurrido un error al guardar la solicitud", null));
        }
    }

    public void agregarCotizacion() {
        String nit = null;
        this.numConf = null;
        nit = this.solicitud.getIdentificacionCliente().getIdentificacion();
        CotizacionDao cDao = new CotizacionDaoImp();
        this.numConf = cDao.obtenerCotizacionPorNumero(cotiza, nit);
        if (this.numConf != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cotizacion encontrada en ofimatica", null));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cotizacion no coincide con el cliente", null));

            this.numConf = null;

        }
        this.cotiza = null;

    }

    public void ingresaCotizacion() {
        SolicitudDao sDao = new SolicitudImp();
        this.solicitud.setNumeroCotizacion(numConf);
        sDao.updateSolicitud(solicitud);
        this.nuevoHistoricoSolicitud(solicitud, Estado.COTIZACION_RELACIONADA, this.obs);
        this.prepararNuevaSolicitud();
        RequestContext context = RequestContext.getCurrentInstance();
        context.update("formCrearSolicitud");
        RequestContext contextt = RequestContext.getCurrentInstance();
        contextt.execute("PF('dialogAgregarCotiza').hide();");
    }

    public void limpiaHistorico() {
        this.estado = new Estado();
        this.historico = new Historico();
        this.obs = null;
        this.solicitud = new Solicitud();
    }

    public void nuevoHistoricoSolicitud(Solicitud soli, int estado, String obs) {
        this.limpiaHistorico();
        Usuario us = new Usuario();
        Date fechaRegistro = new Date();
        this.estado.setIdEstado(estado);
        this.historico.setFechaActualizacion(fechaRegistro);
        this.historico.setIdEstado(this.estado);
        this.historico.setIdSolicitud(soli);
        this.historico.setObservacion(obs);
        FacesContext context = FacesContext.getCurrentInstance();
        us = (Usuario) context.getExternalContext().getSessionMap().get("ULogueado");
        this.historico.setIdUsuario(us);
        HistoricoDao HSDao = new HistoricoImp();
        HSDao.newHistorico(historico);
        this.limpiaHistorico();
    }

    public void enviarAProfesional() {
        this.nuevoHistoricoSolicitud(solicitud, Estado.ENVIADA_A_PROFESIONAL_CERTIFICACION, obs);
    }

}
