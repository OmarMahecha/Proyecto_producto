/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.model;

/**
 *
 * @author omar.mahecha
 */
public class TipoCertificacion implements java.io.Serializable {
        private int idTipoCertificacion;
    private String tipoCertificacion;

    public TipoCertificacion() {
    }

    public TipoCertificacion(int idTipoCertificacion, String tipoCertificacion) {
        this.idTipoCertificacion = idTipoCertificacion;
        this.tipoCertificacion = tipoCertificacion;
    }
    


    public int getIdTipoCertificacion() {
        return idTipoCertificacion;
    }

    public void setIdTipoCertificacion(int idTipoCertificacion) {
        this.idTipoCertificacion = idTipoCertificacion;
    }

    public String getTipoCertificacion() {
        return tipoCertificacion;
    }

    public void setTipoCertificacion(String tipoCertificacion) {
        this.tipoCertificacion = tipoCertificacion;
    }
    
    
}
