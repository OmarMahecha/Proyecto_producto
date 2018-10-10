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
public class Ciudad implements java.io.Serializable{
    private String codigo;
    private String nomCiu;
    private String nomDpto;
    
    public Ciudad(){
        
    }

    public Ciudad(String codigo, String nomCiu, String nomDpto) {
        this.codigo = codigo;
        this.nomCiu = nomCiu;
        this.nomDpto = nomDpto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomCiu() {
        return nomCiu;
    }

    public void setNomCiu(String nomCiu) {
        this.nomCiu = nomCiu;
    }

    public String getNomDpto() {
        return nomDpto;
    }

    public void setNomDpto(String nomDpto) {
        this.nomDpto = nomDpto;
    }
    
    
}
