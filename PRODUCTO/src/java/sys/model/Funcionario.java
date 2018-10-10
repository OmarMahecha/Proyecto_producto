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
public class Funcionario implements java.io.Serializable{
    private String cedula;
    private String nombres;
    private String cargo;
    
    public Funcionario(){
        
    } 

    public Funcionario(String cedula, String nombres, String cargo) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.cargo = cargo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
}
