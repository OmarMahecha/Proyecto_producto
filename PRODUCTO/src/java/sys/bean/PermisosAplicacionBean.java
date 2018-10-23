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
    public static boolean enviarAProf;
    public static boolean verHistorico;
    public static boolean asociarCoti;
    public static boolean enviarAExperto;
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

    public PermisosAplicacionBean() {
    }

    public void iniciaAcciones() {
        adjuntar = false;
        verAdjunto = false;
        enviarAProf = false;
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
    }

    public boolean isAdjuntar() {
        return adjuntar;
    }

    public boolean isVerAdjunto() {
        return verAdjunto;
    }

    public boolean isEnviarAProf() {
        return enviarAProf;
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

    public static boolean isCreaSoli() {
        return creaSoli;
    }

    public static void setCreaSoli(boolean creaSoli) {
        PermisosAplicacionBean.creaSoli = creaSoli;
    }

    public void setAdjuntar(boolean adjuntar) {
        PermisosAplicacionBean.adjuntar = adjuntar;
    }

    public void setVerAdjunto(boolean verAdjunto) {
        PermisosAplicacionBean.verAdjunto = verAdjunto;
    }

    public void setEnviarAProf(boolean enviarAProf) {
        PermisosAplicacionBean.enviarAProf = enviarAProf;
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
                enviarAProf = true;
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
                break;
            case PerfilBean.ASISTENTE_COMERCIAL:
                adjuntar = true;
                verAdjunto = true;
                enviarAProf = true;
                verHistorico = true;
                asociarCoti = true;
                enviarACliente = true;
                ApruebaCliente = true;
                RechazaCliente = true;
                enviarAExperto = false;
                enviarAJefe = false;
                apruebaJefe = false;
                apruebaProf = false;
                apruebaExperto = false;
                devuelveExperto = false;
                devuelveProf = false;
                devuelveJefe = false;
                creaSoli = true;
                break;
            case PerfilBean.EJECUTIVO_COMERCIAL:
                adjuntar = true;
                verAdjunto = true;
                enviarAProf = true;
                verHistorico = true;
                asociarCoti = true;
                enviarACliente = true;
                ApruebaCliente = true;
                RechazaCliente = true;
                enviarAExperto = false;
                enviarAJefe = false;
                apruebaJefe = false;
                apruebaProf = false;
                apruebaExperto = false;
                devuelveExperto = false;
                devuelveProf = false;
                devuelveJefe = false;
                creaSoli = true;
                break;
            case PerfilBean.PROFESIONAL_DE_CERTIFICACION:
                adjuntar = true;
                verAdjunto = true;
                enviarAProf = false;
                verHistorico = true;
                asociarCoti = false;
                enviarAExperto = true;
                enviarAJefe = true;
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
                break;
            case PerfilBean.EXPERTO_EN_AREA:
                adjuntar = false;
                verAdjunto = true;
                enviarAProf = false;
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
                break;
            case PerfilBean.JEFE_CERTIFICACION:
                adjuntar = false;
                verAdjunto = true;
                enviarAProf = false;
                verHistorico = true;
                asociarCoti = false;
                enviarAExperto = false;
                enviarAJefe = false;
                apruebaJefe = true;
                apruebaProf = false;
                apruebaExperto = false;
                devuelveExperto = false;
                devuelveProf = false;
                devuelveJefe = true;
                enviarACliente = false;
                ApruebaCliente = false;
                RechazaCliente = false;
                creaSoli = false;
                break;    
        }

    }
    /**
     * Creates a new instance of PermisosAplicacionBean
     */
}
