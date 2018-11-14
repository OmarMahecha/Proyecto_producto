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
import sys.dao.PerfilDao;
import sys.imp.PerfilImp;
import sys.model.Perfil;

/**
 *
 * @author omar.mahecha
 */
@Named(value = "perfilBean")
@SessionScoped
public class PerfilBean implements Serializable {
    
    private List<Perfil> listaPerfiles;
    private Perfil perfil;

    /**
     * Creates a new instance of PerfilBean
     */
    public PerfilBean() {
    }

    public void prepararNuevoPerfil(){
        this.perfil = new Perfil();
    }
    public List<Perfil> getListaPerfiles() {
        PerfilDao pDao = new PerfilImp();
        listaPerfiles = pDao.ListarPerfil();
        return listaPerfiles;
    }

    public void setListaPerfiles(List<Perfil> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    public void nuevoPerfil(){
        PerfilDao pDao = new PerfilImp();
        pDao.newPerfil(perfil);
        prepararNuevoPerfil();
        RequestContext context = RequestContext.getCurrentInstance();
            context.update("formPerfil");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogPerfil').hide();");
    }
    
    public void editarPerfil(){
        PerfilDao pDao = new PerfilImp();
        pDao.updatePerfil(perfil);
        prepararNuevoPerfil();
            RequestContext context = RequestContext.getCurrentInstance();
            context.update("formPerfil");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogEditarPerfil').hide();");
    }
    public void eliminarPerfil(){
    PerfilDao pDao = new PerfilImp();
        pDao.deletePerfil(perfil);
        prepararNuevoPerfil();
        RequestContext context = RequestContext.getCurrentInstance();
            context.update("formPerfil");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogEliminarPerfil').hide();");
        
    }
    
    
    
    public static final int ADMINISTRADOR = 1;
    public static final int EJECUTIVO_COMERCIAL  = 3;
    public static final int ASISTENTE_COMERCIAL = 4;
    public static final int PROFESIONAL_DE_CERTIFICACION = 5;
    public static final int JEFE_DE_VENTAS = 6;
    public static final int EXPERTO_EN_AREA = 8;
    public static final int JEFE_CERTIFICACION = 9;
    public static final int FINANCIERA = 9;
    public static final int PROFESIONAL_LOGISTICO = 11;

    public int getADMINISTRADOR() {
        return ADMINISTRADOR;
    }
    
    public int getEJECUTIVO_COMERCIAL() {
        return EJECUTIVO_COMERCIAL;
    }

    public int getASISTENTE_COMERCIAL() {
        return ASISTENTE_COMERCIAL;
    }

    public  int getPROFESIONAL_DE_CERTIFICACION() {
        return PROFESIONAL_DE_CERTIFICACION;
    }

    public int getJEFE_DE_VENTAS() {
        return JEFE_DE_VENTAS;
    }

    public int getJEFE_CERTIFICACION() {
        return JEFE_CERTIFICACION;
    }

    public int getFINANCIERA() {
        return FINANCIERA;
    }

    public int getEXPERTO_EN_AREA() {
        return EXPERTO_EN_AREA;
    }

    public int getPROFESIONAL_LOGISTICO() {
        return PROFESIONAL_LOGISTICO;
    }
    

}
