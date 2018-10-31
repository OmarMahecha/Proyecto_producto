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
import java.util.Calendar;
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
import sys.dao.UsuarioDao;
import sys.imp.ClienteDaoImp;
import sys.imp.CotizacionDaoImp;
import sys.imp.HistoricoImp;
import sys.imp.SolicitudImp;
import sys.imp.UsuarioImp;
import sys.model.Cliente;
import sys.model.Cotizacion;
import sys.model.Estado;
import sys.model.Historico;
import sys.model.Solicitud;
import sys.model.TipoCertificacion;
import sys.model.Usuario;
/**
 *
 * @author omar.mahecha
 */
@Named(value = "solicitudBean")
@SessionScoped
public class SolicitudBean implements Serializable {

    private List<Solicitud> listaSolicitudes;
    private List<Usuario> listaProfesionales;
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
    private int tipoCert;
    private int usuario;

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

    public int getTipoCert() {
        return tipoCert;
    }

    public void setTipoCert(int tipoCert) {
        this.tipoCert = tipoCert;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    
    

    public List<Usuario> getListaProfesionales() {
        UsuarioDao uDao = new UsuarioImp();
        listaProfesionales = uDao.ListarUsuarioPorPerfil(PerfilBean.PROFESIONAL_DE_CERTIFICACION);
        return listaProfesionales;
    }

    public void setListaProfesionales(List<Usuario> listaProfesionales) {
        this.listaProfesionales = listaProfesionales;
    }
    
    
    public void prepararNuevaSolicitud() {
        this.solicitud = new Solicitud();
        this.dpto = null;
        this.numConf = null;
        this.cotiza = null;
        this.tipoCert = 0;
        this.usuario = 0;
    }

    public void nuevoCliente() {
        try {
            Usuario us = null;
            Date fechaSolicitud = new Date();
            this.solicitud.setFechaCreacion(fechaSolicitud);
            Estado est = new Estado();
            TipoCertificacion tCert = new TipoCertificacion();
            tCert.setIdTipoCertificacion(tipoCert);
            est.setIdEstado(EstadoBean.SOLICITUD_DE_CERTIFICACION_CREADA);
            this.solicitud.setIdTipoCertificacion(tCert);
            this.solicitud.setIdEstadoActual(est);
            this.solicitud.setEsAtipico(Boolean.FALSE);
            this.solicitud.setCiudadDepartamento(dpto);
            FacesContext context = FacesContext.getCurrentInstance();
            us = (Usuario) context.getExternalContext().getSessionMap().get("ULogueado");
            this.solicitud.setIdUsuario(us);
            SolicitudDao sDao = new SolicitudImp();
            sDao.newSolicitud(solicitud);
            this.nuevoHistoricoSolicitud(solicitud, EstadoBean.SOLICITUD_DE_CERTIFICACION_CREADA, "");
            this.prepararNuevaSolicitud();
        } catch (Exception e) {
            System.out.println("Error al Guardar solicitud " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A ocurrido un error al guardar la solicitud", null));
        }
    }

    public void agregarCotizacion() {
        this.numConf = null;
        CotizacionDao cDao = new CotizacionDaoImp();
        this.numConf = cDao.obtenerCotizacionPorNumero(cotiza);
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
        this.nuevoHistoricoSolicitud(solicitud, EstadoBean.OFERTA_COMERCIAL_ADJUNTA, obs);
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
        this.nuevoHistoricoSolicitud(solicitud, EstadoBean.ENVIADA_A_REVISION_PRELIMINAR, obs);
        RequestContext contextt = RequestContext.getCurrentInstance();
        contextt.execute("PF('dialogEnviaProf').hide();");
        prepararNuevaSolicitud();
    }
    
    public void asignarAProfesional() {
        Usuario prof = new Usuario();
        prof.setIdUsuario(usuario);
        this.solicitud.setIdProfesionalAsignado(prof);
        editarSolicitud();
        this.nuevoHistoricoSolicitud(solicitud, EstadoBean.ENVIADA_A_REVISION_PRELIMINAR, obs);
        RequestContext contextt = RequestContext.getCurrentInstance();
        contextt.execute("PF('dialogAsignaProf').hide();");
        prepararNuevaSolicitud();
    }
    
    public void aprobarProfesional() {
        this.nuevoHistoricoSolicitud(solicitud, EstadoBean.DOCUMENTACION_COMPLETA, obs);
        RequestContext contextt = RequestContext.getCurrentInstance();
        contextt.execute("PF('dialogRevPreTecnica').hide();");
    }
    
    public void rechazarProfesional() {
        this.nuevoHistoricoSolicitud(solicitud, EstadoBean.SOLICITUD_DE_CERTIFICACION_CANCELADA, obs);
        RequestContext contextt = RequestContext.getCurrentInstance();
        contextt.execute("PF('dialogRevPreTecnica').hide();");
    }
    

    public void devolverProfesional() {
        this.nuevoHistoricoSolicitud(solicitud, EstadoBean.DEVUELTA_POR_PROFESIONAL, obs);
        RequestContext contextt = RequestContext.getCurrentInstance();
        contextt.execute("PF('dialogRevPreTecnica').hide();");
    }
    
    public void enviarExperto() {
        this.nuevoHistoricoSolicitud(solicitud, EstadoBean.ENVIADA_A_EXPERTO_EN_EL_AREA, obs);
        RequestContext contextt = RequestContext.getCurrentInstance();
        contextt.execute("PF('dialogEnviaExp').hide();");
    }
    
    public void enviarAsesorComercial() {
        this.nuevoHistoricoSolicitud(solicitud, EstadoBean.ENVIADA_A__ASESOR_COMERCIAL, obs);
        RequestContext contextt = RequestContext.getCurrentInstance();
        contextt.execute("PF('dialogRevSolicitud').hide();");
    }
    
    public void devolverExperto() {
        this.nuevoHistoricoSolicitud(solicitud, EstadoBean.DEVUELTA_POR_EXPERTO_EN_EL_AREA, obs);
        RequestContext contextt = RequestContext.getCurrentInstance();
        contextt.execute("PF('dialogRevSolicitud').hide();");
    }
    
    public void enviarAprobOC() {
        this.nuevoHistoricoSolicitud(solicitud, EstadoBean.OFERTA_ENVIADA_A_PROFESIONAL, obs);
        RequestContext contextt = RequestContext.getCurrentInstance();
        contextt.execute("PF('dialogEnvAprobOC').hide();");
    }
    
    public void editarSolicitud(){
        SolicitudDao sDao = new SolicitudImp();
        sDao.updateSolicitud(solicitud);          
    }
    
    public String calculoDeTiempo(int idSoli ){
        String mensaje = null;
        Date actual = new Date();
        Historico historico = new Historico();
        HistoricoDao his = new HistoricoImp();
        historico = his.obtieneUltimoHistorico(idSoli);
        if(historico != null){
        System.out.println("ggggggggggggggggg"+actual.getTime()+"  pppppppppppppppppppppp"+historico.getFechaActualizacion().getTime());
        System.out.print("kkkkkkkkkkkkkkkkkkkkk"+(actual.getTime()-historico.getFechaActualizacion().getTime())/1000);
        int diferencia = (int) ((actual.getTime()-historico.getFechaActualizacion().getTime())/1000);
         int dias=0;
        int horas=0;
        int minutos=0;
        if(diferencia>86400) {
            dias=(int)Math.floor(diferencia/86400);
            diferencia=diferencia-(dias*86400);
        }
        if(diferencia>3600) {
            horas=(int)Math.floor(diferencia/3600);
            diferencia=diferencia-(horas*3600);
        }
        if(diferencia>60) {
            minutos=(int)Math.floor(diferencia/60);
            diferencia=diferencia-(minutos*60);
        }
    
        mensaje = "Hay "+dias+" dias, "+horas+" horas, "+minutos+" minutos y "+diferencia+" segundos de diferencia";
        }
    
    return mensaje;     
    }
    


}