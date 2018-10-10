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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.ClienteDao;
import sys.imp.ClienteDaoImp;
import sys.model.Cliente;
import sys.util.HibernateUtil;



/**
 *
 * @author omar.mahecha
 */
@Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {

    private List<Cliente> listaClientes; 
    private Cliente cliente;
    Session session;
    Transaction transaction;
    
    
    public ClienteBean() {
    }


    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public List<Cliente> getListaClientes() {
        ClienteDao sDao = new ClienteDaoImp();
        listaClientes = sDao.ListarClientes();
        return listaClientes;
    }
    
    public void prepararNuevoCliente(){
        cliente = new Cliente();
    }
    
    
        
   
    
    
}
