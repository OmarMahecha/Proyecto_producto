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
public class Estado implements java.io.Serializable {


     private int idEstado;
     private String estado;

    public Estado() {
    }

    public Estado(int idEstado, String estado) {
       this.idEstado = idEstado;
       this.estado = estado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   





}



