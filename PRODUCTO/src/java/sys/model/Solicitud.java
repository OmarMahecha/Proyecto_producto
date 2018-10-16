package sys.model;
// Generated 3/10/2018 12:48:46 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Solicitud generated by hbm2java
 */
public class Solicitud  implements java.io.Serializable {


     private int idSolicitud;
     private Usuario idUsuario;
     private Date fechaCreacion;
     private Estado idEstadoActual;
     private Date tiempoOfertaComercial;
     private Boolean esPrioridad;
     private Boolean esAtipico;
     private Date tiempoAtipico;
     private String observacionAtipico;
     private String observacionPrioridad;
     private String nombreContacto;
     private String cargoContacto;
     private String correoContacto;
     private String direccionCliente;
     private String celularTelefono;
     private String ciudadDepartamento;
     private String numeroCotizacion;
     private Cliente identificacionCliente;

    public Solicitud() {
    }

	
    public Solicitud(int idSolicitud, Usuario idUsuario, Date fechaCreacion, Estado idEstadoActual) {
        this.idSolicitud = idSolicitud;
        this.idUsuario = idUsuario;
        this.fechaCreacion = fechaCreacion;
        this.idEstadoActual = idEstadoActual;
    }
    public Solicitud(int idSolicitud, Usuario idUsuario, Date fechaCreacion,Estado idEstadoActual, Date tiempoOfertaComercial, Boolean esPrioridad, Boolean esAtipico, Date tiempoAtipico, String observacionAtipico, String observacionPrioridad, String nombreContacto, String cargoContacto, String correoContacto, String direccionCliente, String celularTelefono, String ciudadDepartamento, String numeroCotizacion, Cliente identificacionCliente) {
       this.idSolicitud = idSolicitud;
       this.idUsuario = idUsuario;
       this.fechaCreacion = fechaCreacion;
       this.idEstadoActual = idEstadoActual;
       this.tiempoOfertaComercial = tiempoOfertaComercial;
       this.esPrioridad = esPrioridad;
       this.esAtipico = esAtipico;
       this.tiempoAtipico = tiempoAtipico;
       this.observacionAtipico = observacionAtipico;
       this.observacionPrioridad = observacionPrioridad;
       this.nombreContacto = nombreContacto;
       this.cargoContacto = cargoContacto;
       this.correoContacto = correoContacto;
       this.direccionCliente = direccionCliente;
       this.celularTelefono = celularTelefono;
       this.ciudadDepartamento = ciudadDepartamento;
       this.numeroCotizacion = numeroCotizacion;
       this.identificacionCliente = identificacionCliente;
    }
   
    public int getIdSolicitud() {
        return this.idSolicitud;
    }
    
    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    public Usuario getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Estado getIdEstadoActual() {
        return this.idEstadoActual;
    }
    
    public void setIdEstadoActual(Estado idEstadoActual) {
        this.idEstadoActual = idEstadoActual;
    }
    public Date getTiempoOfertaComercial() {
        return this.tiempoOfertaComercial;
    }
    
    public void setTiempoOfertaComercial(Date tiempoOfertaComercial) {
        this.tiempoOfertaComercial = tiempoOfertaComercial;
    }
    public Boolean getEsPrioridad() {
        return this.esPrioridad;
    }
    
    public void setEsPrioridad(Boolean esPrioridad) {
        this.esPrioridad = esPrioridad;
    }
    public Boolean getEsAtipico() {
        return this.esAtipico;
    }
    
    public void setEsAtipico(Boolean esAtipico) {
        this.esAtipico = esAtipico;
    }
    public Date getTiempoAtipico() {
        return this.tiempoAtipico;
    }
    
    public void setTiempoAtipico(Date tiempoAtipico) {
        this.tiempoAtipico = tiempoAtipico;
    }
    public String getObservacionAtipico() {
        return this.observacionAtipico;
    }
    
    public void setObservacionAtipico(String observacionAtipico) {
        this.observacionAtipico = observacionAtipico;
    }
    public String getObservacionPrioridad() {
        return this.observacionPrioridad;
    }
    
    public void setObservacionPrioridad(String observacionPrioridad) {
        this.observacionPrioridad = observacionPrioridad;
    }


    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getCargoContacto() {
        return cargoContacto;
    }

    public void setCargoContacto(String cargoContacto) {
        this.cargoContacto = cargoContacto;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getCelularTelefono() {
        return celularTelefono;
    }

    public void setCelularTelefono(String celularTelefono) {
        this.celularTelefono = celularTelefono;
    }

    public String getCiudadDepartamento() {
        return ciudadDepartamento;
    }

    public void setCiudadDepartamento(String ciudadDepartamento) {
        this.ciudadDepartamento = ciudadDepartamento;
    }

    public String getNumeroCotizacion() {
        return numeroCotizacion;
    }

    public void setNumeroCotizacion(String numeroCotizacion) {
        this.numeroCotizacion = numeroCotizacion;
    }

    public Cliente getIdentificacionCliente() {
        return identificacionCliente;
    }

    public void setIdentificacionCliente(Cliente identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
    }

    


}


