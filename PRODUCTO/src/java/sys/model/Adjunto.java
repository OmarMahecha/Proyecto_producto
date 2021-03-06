package sys.model;
// Generated 3/10/2018 12:48:46 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Adjunto generated by hbm2java
 */
public class Adjunto  implements java.io.Serializable {


     private int idAdjunto;
     private Solicitud idSolicitud;
     private TipoAdjunto idTipoAdjunto;
     private Date fechaAdjunto;
     private Usuario idUsuario;
     private String rutaAdjunto;

    public Adjunto() {
    }

    public Adjunto(int idAdjunto, Solicitud idSolicitud, TipoAdjunto idTipoAdjunto, Date fechaAdjunto, Usuario idUsuario, String rutaAdjunto) {
       this.idAdjunto = idAdjunto;
       this.idSolicitud = idSolicitud;
       this.idTipoAdjunto = idTipoAdjunto;
       this.fechaAdjunto = fechaAdjunto;
       this.idUsuario = idUsuario;
       this.rutaAdjunto = rutaAdjunto;
    }
   
    public int getIdAdjunto() {
        return this.idAdjunto;
    }
    
    public void setIdAdjunto(int idAdjunto) {
        this.idAdjunto = idAdjunto;
    }
    public Solicitud getIdSolicitud() {
        return this.idSolicitud;
    }
    
    public void setIdSolicitud(Solicitud idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    public TipoAdjunto getIdTipoAdjunto() {
        return this.idTipoAdjunto;
    }
    
    public void setIdTipoAdjunto(TipoAdjunto idTipoAdjunto) {
        this.idTipoAdjunto = idTipoAdjunto;
    }
    public Date getFechaAdjunto() {
        return this.fechaAdjunto;
    }
    
    public void setFechaAdjunto(Date fechaAdjunto) {
        this.fechaAdjunto = fechaAdjunto;
    }
    public Usuario getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getRutaAdjunto() {
        return this.rutaAdjunto;
    }
    
    public void setRutaAdjunto(String rutaAdjunto) {
        this.rutaAdjunto = rutaAdjunto;
    }




}


