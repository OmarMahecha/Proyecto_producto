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
public class Cliente implements java.io.Serializable{
    private String identificacion;
     private String nombre;
     private String busca;

    public Cliente() {
    }

    public Cliente(String identificacion, String nombre, String busca) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.busca = busca;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }
     
     
    
}
