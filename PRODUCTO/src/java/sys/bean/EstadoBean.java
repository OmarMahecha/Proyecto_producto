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
    
public static final int SOLICITUD_DE_CERTIFICACION_CREADA = 1;
public static final int ENVIADA_A_REVISION_PRELIMINAR = 2;
public static final int DEVUELTA_POR_PROFESIONAL = 4;
public static final int REENVIADA_A_REVISION_PRELIMINAR = 5;
public static final int DOCUMENTACION_COMPLETA = 7;
public static final int SOLICITUD_DE_CERTIFICACION_CANCELADA = 8;
public static final int ENVIADA_A_EXPERTO_EN_EL_AREA = 10;
public static final int DEVUELTA_POR_EXPERTO_EN_EL_AREA = 11;
public static final int REENVIADA_A_EXPERTO_EN_EL_AREA = 12;
public static final int ENVIADA_A__ASESOR_COMERCIAL = 13;
public static final int OFERTA_COMERCIAL_ADJUNTA = 14;
public static final int OFERTA_ENVIADA_A_PROFESIONAL = 15;
public static final int OFERTA_COMERCIAL_DEVUELTA = 16;
public static final int OFERTA_POR_AUTORIZAR = 17;
public static final int OFERTA_COMERCIAL_AUTORIZADA = 18;
public static final int ENVIADA_AL_CLIENTE = 19;
public static final int ACEPTADA_POR_EL_CLIENTE = 20;
public static final int SOLICITUD_ASIGNADA = 22;
public static final int COTIZACION_ASIGNADA = 23;
public static final int PROGRAMACION_SERVICIO_EVALUACION = 24;
public static final int PROGRAMA_AUDITORIA_Y_AUDITORIA_PRELIMINAR = 25;
public static final int PRIORIDAD_APROBADA_POR_COMERCIAL = 26;
public static final int PRIORIDAD_NO_APROBADA_POR_COMERCIAL = 27;

public  int getSOLICITUD_DE_CERTIFICACION_CREADA() {
        return SOLICITUD_DE_CERTIFICACION_CREADA;
    }

    public  int getENVIADA_A_REVISION_PRELIMINAR() {
        return ENVIADA_A_REVISION_PRELIMINAR;
    }

    public  int getDEVUELTA_POR_PROFESIONAL() {
        return DEVUELTA_POR_PROFESIONAL;
    }

    public  int getREENVIADA_A_REVISION_PRELIMINAR() {
        return REENVIADA_A_REVISION_PRELIMINAR;
    }

    public int getDOCUMENTACION_COMPLETA() {
        return DOCUMENTACION_COMPLETA;
    }

    public int getSOLICITUD_ASIGNADA() {
        return SOLICITUD_ASIGNADA;
    }

    public  int getSOLICITUD_DE_CERTIFICACION_CANCELADA() {
        return SOLICITUD_DE_CERTIFICACION_CANCELADA;
    }

    public  int getENVIADA_A_EXPERTO_EN_EL_AREA() {
        return ENVIADA_A_EXPERTO_EN_EL_AREA;
    }

    public  int getDEVUELTA_POR_EXPERTO_EN_EL_AREA() {
        return DEVUELTA_POR_EXPERTO_EN_EL_AREA;
    }

    public  int getREENVIADA_A_EXPERTO_EN_EL_AREA() {
        return REENVIADA_A_EXPERTO_EN_EL_AREA;
    }

    public  int getENVIADA_A__ASESOR_COMERCIAL() {
        return ENVIADA_A__ASESOR_COMERCIAL;
    }

    public  int getOFERTA_COMERCIAL_ADJUNTA() {
        return OFERTA_COMERCIAL_ADJUNTA;
    }

    public  int getOFERTA_ENVIADA_A_PROFESIONAL() {
        return OFERTA_ENVIADA_A_PROFESIONAL;
    }

    public  int getOFERTA_COMERCIAL_DEVUELTA() {
        return OFERTA_COMERCIAL_DEVUELTA;
    }

    public  int getOFERTA_POR_AUTORIZAR() {
        return OFERTA_POR_AUTORIZAR;
    }

    public  int getOFERTA_COMERCIAL_AUTORIZADA() {
        return OFERTA_COMERCIAL_AUTORIZADA;
    }

    public  int getENVIADA_AL_CLIENTE() {
        return ENVIADA_AL_CLIENTE;
    }

    public  int getACEPTADA_POR_EL_CLIENTE() {
        return ACEPTADA_POR_EL_CLIENTE;
    }

    public int getCOTIZACION_ASIGNADA() {
        return COTIZACION_ASIGNADA;
    }
    
    public int getPROGRAMACION_SERVICIO_EVALUACION() {
        return PROGRAMACION_SERVICIO_EVALUACION;
    }
    
    public int getPROGRAMA_AUDITORIA_Y_AUDITORIA_PRELIMINAR() {
        return PROGRAMA_AUDITORIA_Y_AUDITORIA_PRELIMINAR;
    }

    public int getPRIORIDAD_APROBADA_POR_COMERCIAL() {
        return PRIORIDAD_APROBADA_POR_COMERCIAL;
    }

    public int getPRIORIDAD_NO_APROBADA_POR_COMERCIAL() {
        return PRIORIDAD_NO_APROBADA_POR_COMERCIAL;
    }

}
