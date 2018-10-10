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
public class Cotizacion implements java.io.Serializable{
    private String cotizacion;
     private String codigoServicio;
     private String servicio;
     private int cantidad;
     private int valorUnitario;
     private int total;
     private String nota;
     private int iva;
     private String nit;
     private int codigo;

    public Cotizacion() {
    }

    public Cotizacion(int codigo, String cotizacion, String codigoServicio, String servicio, int cantidad, int valorUnitario, int total, String nota, int iva, String nit) {
        this.codigo = codigo;
        this.cotizacion = cotizacion;
        this.codigoServicio = codigoServicio;
        this.servicio = servicio;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.total = total;
        this.nota = nota;
        this.iva = iva;
        this.nit = nit;
        
    }
    
     public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(String cotizacion) {
        this.cotizacion = cotizacion;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

   
    
     
}
