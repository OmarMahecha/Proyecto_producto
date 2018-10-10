/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.CotizacionDao;
import sys.imp.CotizacionDaoImp;
import sys.model.Cotizacion;
import sys.model.Solicitud;
import sys.util.HibernateUtil;

/**
 *
 * @author omar.mahecha
 */
@Named(value = "cotizacionBean")
@SessionScoped
public class CotizacionBean implements Serializable {

    private List<Cotizacion> listaCotizaciones; 
    private Cotizacion cotizacion;
    private String numCotizacion;
    private int porcentaje = 0;
    private int sub = 0;
    private String subt = "";
    private String iva = "";
    private String incluidoIva = "";
    Session session;
    Transaction transaction;
    private Solicitud solicitud = new Solicitud();

    
    public CotizacionBean() {
    }

    public List<Cotizacion> getListaCotizaciones() {
       numCotizacion =  solicitud.getNumeroCotizacion();
        //numCotizacion =  solicitud.getNumeroCotizacion();
        CotizacionDao sDao = new CotizacionDaoImp();
        listaCotizaciones = sDao.ListarCotizaciones(numCotizacion);
        this.valoresCotizacion();
            
        
        return listaCotizaciones;
    }
    public void valoresCotizacion(){
        this.sub = 0;
        this.iva = "";
        this.incluidoIva = "";
        for (Cotizacion lis : this.listaCotizaciones){
            this.sub += lis.getTotal();
            this.iva =new DecimalFormat("###,###.###").format(this.sub*lis.getIva()/100);
            this.incluidoIva =new DecimalFormat("###,###.###").format(this.sub+(this.sub*lis.getIva()/100));
            this.subt = new DecimalFormat("###,###.###").format(this.sub);
            this.porcentaje = lis.getIva();
        }
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
public String getSubt() {
        return subt;
    }

    public void setSubt(String subt) {
        this.subt = subt;
    }
    public int getSub() {
        return sub;
    }

    public void setSub(int sub) {
        this.sub = sub;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getIncluidoIva() {
        return incluidoIva;
    }

    public void setIncluidoIva(String incluidoIva) {
        this.incluidoIva = incluidoIva;
    }

    public void setListaCotizaciones(List<Cotizacion> listaCotizaciones) {
        this.listaCotizaciones = listaCotizaciones;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public String getNumCotizacion() {
        return numCotizacion;
    }

    public void setNumCotizacion(String numCotizacion) {
        this.numCotizacion = numCotizacion;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
    
    
    public void prepararNuevaCotizacion(){
        cotizacion = new Cotizacion();
        this.numCotizacion = null;
        solicitud = new Solicitud();
    }
    
    

}
