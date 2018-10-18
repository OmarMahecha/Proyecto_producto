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
   
    public static final int CREADA = 1;
    public static final int ENVIADA_A_PROFESIONAL_CERTIFICACION = 2;
    public static final int RECHAZADA_POR_PROFESIONAL_CERTIFICACION = 3;
    public static final int APROBADA_POR_PROFESIONAL_CERTIFICACION = 4;
    public static final int COTIZACION_RELACIONADA = 5;

    public int getCREADA() {
        return CREADA;
    }

    public static int getENVIADA_A_PROFESIONAL_CERTIFICACION() {
        return ENVIADA_A_PROFESIONAL_CERTIFICACION;
    }

    public static int getRECHAZADA_POR_PROFESIONAL_CERTIFICACION() {
        return RECHAZADA_POR_PROFESIONAL_CERTIFICACION;
    }

    public static int getAPROBADA_POR_PROFESIONAL_CERTIFICACION() {
        return APROBADA_POR_PROFESIONAL_CERTIFICACION;
    }
    




}



