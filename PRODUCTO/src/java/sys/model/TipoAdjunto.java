package sys.model;
// Generated 3/10/2018 12:48:46 PM by Hibernate Tools 4.3.1



/**
 * TipoAdjunto generated by hbm2java
 */
public class TipoAdjunto  implements java.io.Serializable {


     private int idTipoAdjunto;
     private String nombreTipoAdjunto;

    public TipoAdjunto() {
    }

    public TipoAdjunto(int idTipoAdjunto, String nombreTipoAdjunto) {
       this.idTipoAdjunto = idTipoAdjunto;
       this.nombreTipoAdjunto = nombreTipoAdjunto;
    }
   
    public int getIdTipoAdjunto() {
        return this.idTipoAdjunto;
    }
    
    public void setIdTipoAdjunto(int idTipoAdjunto) {
        this.idTipoAdjunto = idTipoAdjunto;
    }
    public String getNombreTipoAdjunto() {
        return this.nombreTipoAdjunto;
    }
    
    public void setNombreTipoAdjunto(String nombreTipoAdjunto) {
        this.nombreTipoAdjunto = nombreTipoAdjunto;
    }




}


