/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import sys.model.Usuario;

/**
 *
 * @author omar.mahecha
 */
@Named(value = "permisosAplicacionBean")
@SessionScoped
public class PermisosAplicacionBean implements Serializable {

    public static boolean adjuntar;
    public static boolean verAdjunto;
    public static boolean enviarArevisionPreliminar;
    public static boolean asignarProf;
    public static boolean verHistorico;
    public static boolean asociarCoti;
    public static boolean enviarAExperto;
    public static boolean aprobacionProfesionalLogistico;
    public static boolean enviarAJefe;
    public static boolean apruebaJefe;
    public static boolean apruebaProf;
    public static boolean apruebaExperto;
    public static boolean devuelveExperto;
    public static boolean devuelveProf;
    public static boolean devuelveJefe;
    public static boolean enviarACliente;
    public static boolean ApruebaCliente;
    public static boolean RechazaCliente;
    public static boolean creaSoli;
    public static boolean aprobarPrioridad;
    public static boolean aprobarOfertaJefeVentas;

    public PermisosAplicacionBean() {
    }

    public void iniciaAcciones() {
        adjuntar = false;
        verAdjunto = false;
        enviarArevisionPreliminar = false;
        asignarProf = false;
        verHistorico = false;
        asociarCoti = false;
        enviarAExperto = false;
        enviarAJefe = false;
        apruebaJefe = false;
        apruebaProf = false;
        apruebaExperto = false;
        devuelveExperto = false;
        devuelveProf = false;
        devuelveJefe = false;
        enviarACliente = false;
        ApruebaCliente = false;
        RechazaCliente = false;
        creaSoli = false;
        aprobacionProfesionalLogistico = false;
        aprobarPrioridad = false;
        aprobarOfertaJefeVentas = false;

    }

    public boolean isAdjuntar() {
        return adjuntar;
    }

    public boolean isVerAdjunto() {
        return verAdjunto;
    }

    public boolean isEnviarArevisionPreliminar() {
        return enviarArevisionPreliminar;
    }

    public void setEnviarArevisionPreliminar(boolean enviarArevisionPreliminar) {
        PermisosAplicacionBean.enviarArevisionPreliminar = enviarArevisionPreliminar;
    }

    public boolean isAprobacionProfesionalLogistico() {
        return aprobacionProfesionalLogistico;
    }

    public void setAprobacionProfesionalLogistico(boolean aprobacionProfesionalLogistico) {
        PermisosAplicacionBean.aprobacionProfesionalLogistico = aprobacionProfesionalLogistico;
    }

    public boolean isVerHistorico() {
        return verHistorico;
    }

    public boolean isAsociarCoti() {
        return asociarCoti;
    }

    public boolean isEnviarAExperto() {
        return enviarAExperto;
    }

    public boolean isEnviarAJefe() {
        return enviarAJefe;
    }

    public boolean isApruebaJefe() {
        return apruebaJefe;
    }

    public boolean isApruebaProf() {
        return apruebaProf;
    }

    public boolean isApruebaExperto() {
        return apruebaExperto;
    }

    public boolean isDevuelveExperto() {
        return devuelveExperto;
    }

    public boolean isDevuelveProf() {
        return devuelveProf;
    }

    public boolean isDevuelveJefe() {
        return devuelveJefe;
    }

    public boolean isEnviarACliente() {
        return enviarACliente;
    }

    public boolean isApruebaCliente() {
        return ApruebaCliente;
    }

    public boolean isRechazaCliente() {
        return RechazaCliente;
    }

    public boolean isCreaSoli() {
        return creaSoli;
    }

    public boolean isAsignarProf() {
        return asignarProf;
    }

    public boolean isAprobarPrioridad() {
        return aprobarPrioridad;
    }

    public boolean isAprobarOfertaJefeVentas() {
        return aprobarOfertaJefeVentas;
    }

    public void setAprobarOfertaJefeVentas(boolean aprobarOfertaJefeVentas) {
        PermisosAplicacionBean.aprobarOfertaJefeVentas = aprobarOfertaJefeVentas;
    }

    public void setAprobarPrioridad(boolean aprobarPrioridad) {
        PermisosAplicacionBean.aprobarPrioridad = aprobarPrioridad;
    }

    public void setAsignarProf(boolean asignarProf) {
        PermisosAplicacionBean.asignarProf = asignarProf;
    }

    public void setCreaSoli(boolean creaSoli) {
        PermisosAplicacionBean.creaSoli = creaSoli;
    }

    public void setAdjuntar(boolean adjuntar) {
        PermisosAplicacionBean.adjuntar = adjuntar;
    }

    public void setVerAdjunto(boolean verAdjunto) {
        PermisosAplicacionBean.verAdjunto = verAdjunto;
    }

    public void setVerHistorico(boolean verHistorico) {
        PermisosAplicacionBean.verHistorico = verHistorico;
    }

    public void setAsociarCoti(boolean asociarCoti) {
        PermisosAplicacionBean.asociarCoti = asociarCoti;
    }

    public void setEnviarAExperto(boolean enviarAExperto) {
        PermisosAplicacionBean.enviarAExperto = enviarAExperto;
    }

    public void setEnviarAJefe(boolean enviarAJefe) {
        PermisosAplicacionBean.enviarAJefe = enviarAJefe;
    }

    public void setApruebaJefe(boolean apruebaJefe) {
        PermisosAplicacionBean.apruebaJefe = apruebaJefe;
    }

    public void setApruebaProf(boolean apruebaProf) {
        PermisosAplicacionBean.apruebaProf = apruebaProf;
    }

    public void setApruebaExperto(boolean apruebaExperto) {
        PermisosAplicacionBean.apruebaExperto = apruebaExperto;
    }

    public void setDevuelveExperto(boolean devuelveExperto) {
        PermisosAplicacionBean.devuelveExperto = devuelveExperto;
    }

    public void setDevuelveProf(boolean devuelveProf) {
        PermisosAplicacionBean.devuelveProf = devuelveProf;
    }

    public void setDevuelveJefe(boolean devuelveJefe) {
        PermisosAplicacionBean.devuelveJefe = devuelveJefe;
    }

    public void setEnviarACliente(boolean enviarACliente) {
        PermisosAplicacionBean.enviarACliente = enviarACliente;
    }

    public void setApruebaCliente(boolean ApruebaCliente) {
        PermisosAplicacionBean.ApruebaCliente = ApruebaCliente;
    }

    public void setRechazaCliente(boolean RechazaCliente) {
        PermisosAplicacionBean.RechazaCliente = RechazaCliente;
    }

    public void validaPermisos() {
        iniciaAcciones();
        FacesContext context = FacesContext.getCurrentInstance();
        Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("ULogueado");
        switch (us.getIdPerfil().getIdPerfil()) {
            case PerfilBean.ADMINISTRADOR:
                adjuntar = true;
                verAdjunto = true;
                enviarArevisionPreliminar = true;
                asignarProf = true;
                verHistorico = true;
                asociarCoti = true;
                enviarAExperto = true;
                enviarAJefe = true;
                apruebaJefe = true;
                apruebaProf = true;
                apruebaExperto = true;
                devuelveExperto = true;
                devuelveProf = true;
                devuelveJefe = true;
                enviarACliente = true;
                ApruebaCliente = true;
                RechazaCliente = true;
                creaSoli = true;
                aprobacionProfesionalLogistico = true;
                aprobarPrioridad = true;
                aprobarOfertaJefeVentas = true;
                break;
            case PerfilBean.ASISTENTE_COMERCIAL:
                adjuntar = true;
                verAdjunto = true;
                enviarArevisionPreliminar = true;
                asignarProf = false;
                verHistorico = true;
                asociarCoti = true;
                enviarAExperto = false;
                enviarAJefe = false;
                apruebaJefe = false;
                apruebaProf = false;
                apruebaExperto = false;
                devuelveExperto = false;
                devuelveProf = false;
                devuelveJefe = false;
                enviarACliente = true;
                ApruebaCliente = true;
                RechazaCliente = true;
                creaSoli = true;
                aprobacionProfesionalLogistico = false;
                aprobarPrioridad = false;
                aprobarOfertaJefeVentas = false;
                break;
            case PerfilBean.EJECUTIVO_COMERCIAL:
                adjuntar = true;
                verAdjunto = true;
                enviarArevisionPreliminar = true;
                asignarProf = false;
                verHistorico = true;
                asociarCoti = true;
                enviarAExperto = false;
                enviarAJefe = false;
                apruebaJefe = false;
                apruebaProf = false;
                apruebaExperto = false;
                devuelveExperto = false;
                devuelveProf = false;
                devuelveJefe = false;
                enviarACliente = true;
                ApruebaCliente = true;
                RechazaCliente = true;
                creaSoli = true;
                aprobacionProfesionalLogistico = false;
                aprobarPrioridad = false;
                aprobarOfertaJefeVentas = false;
                break;
            case PerfilBean.PROFESIONAL_DE_CERTIFICACION:
                adjuntar = true;
                verAdjunto = true;
                enviarArevisionPreliminar = false;
                asignarProf = false;
                verHistorico = true;
                asociarCoti = false;
                enviarAExperto = true;
                enviarAJefe = false;
                apruebaJefe = false;
                apruebaProf = true;
                apruebaExperto = false;
                devuelveExperto = false;
                devuelveProf = true;
                devuelveJefe = false;
                enviarACliente = false;
                ApruebaCliente = false;
                RechazaCliente = false;
                creaSoli = false;
                aprobacionProfesionalLogistico = false;
                aprobarPrioridad = false;
                aprobarOfertaJefeVentas = false;
                break;
            case PerfilBean.EXPERTO_EN_AREA:
                adjuntar = false;
                verAdjunto = true;
                enviarArevisionPreliminar = false;
                asignarProf = false;
                verHistorico = true;
                asociarCoti = false;
                enviarAExperto = false;
                enviarAJefe = false;
                apruebaJefe = false;
                apruebaProf = false;
                apruebaExperto = true;
                devuelveExperto = true;
                devuelveProf = false;
                devuelveJefe = false;
                enviarACliente = false;
                ApruebaCliente = false;
                RechazaCliente = false;
                creaSoli = false;
                aprobacionProfesionalLogistico = false;
                aprobarPrioridad = false;
                aprobarOfertaJefeVentas = false;
                break;
            case PerfilBean.JEFE_CERTIFICACION:
                adjuntar = true;
                verAdjunto = true;
                enviarArevisionPreliminar = false;
                asignarProf = true;
                verHistorico = true;
                asociarCoti = false;
                enviarAExperto = false;
                enviarAJefe = false;
                apruebaJefe = true;
                apruebaProf = false;
                apruebaExperto = true;
                devuelveExperto = true;
                devuelveProf = false;
                devuelveJefe = true;
                enviarACliente = false;
                ApruebaCliente = false;
                RechazaCliente = false;
                creaSoli = false;
                aprobacionProfesionalLogistico = false;
                aprobarPrioridad = false;
                aprobarOfertaJefeVentas = false;
                break;
            case PerfilBean.JEFE_DE_VENTAS:
                adjuntar = true;
                verAdjunto = true;
                enviarArevisionPreliminar = true;
                asignarProf = false;
                verHistorico = true;
                asociarCoti = true;
                enviarAExperto = false;
                enviarAJefe = false;
                apruebaJefe = false;
                apruebaProf = false;
                apruebaExperto = false;
                devuelveExperto = false;
                devuelveProf = false;
                devuelveJefe = false;
                enviarACliente = true;
                ApruebaCliente = true;
                RechazaCliente = true;
                creaSoli = true;
                aprobacionProfesionalLogistico = false;
                aprobarPrioridad = true;
                aprobarOfertaJefeVentas = true;
                break;
            case PerfilBean.PROFESIONAL_LOGISTICO:
                adjuntar = false;
                verAdjunto = true;
                enviarArevisionPreliminar = false;
                asignarProf = false;
                verHistorico = true;
                asociarCoti = false;
                enviarAExperto = false;
                enviarAJefe = false;
                apruebaJefe = false;
                apruebaProf = false;
                apruebaExperto = false;
                devuelveExperto = false;
                devuelveProf = false;
                devuelveJefe = false;
                enviarACliente = false;
                ApruebaCliente = false;
                RechazaCliente = false;
                creaSoli = false;
                aprobacionProfesionalLogistico = true;
                aprobarPrioridad = false;
                aprobarOfertaJefeVentas = false;
                break;
        }

    }
    /**
     * Creates a new instance of PermisosAplicacionBean
     */
}
