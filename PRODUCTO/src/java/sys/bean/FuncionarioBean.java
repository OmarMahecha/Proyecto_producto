/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import sys.dao.FuncionarioDao;
import sys.imp.FuncionarioDaoImp;
import sys.model.Funcionario;

/**
 *
 * @author omar.mahecha
 */
@Named(value = "funcionarioBean")
@SessionScoped
public class FuncionarioBean implements Serializable {
    private Funcionario funcionario = new Funcionario();
    private List<Funcionario> listaFuncionario;
    FuncionarioDao fDao = new FuncionarioDaoImp();
    /**
     * Creates a new instance of FuncionarioBean
     */
    public FuncionarioBean() {
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getListaFuncionario() {
        listaFuncionario = fDao.Listafuncionario();
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }
    
       public void preparaFuncionario (){
        funcionario = new Funcionario();
    }

    
}
