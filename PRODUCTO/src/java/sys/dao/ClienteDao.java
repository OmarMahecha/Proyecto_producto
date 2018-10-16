/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import org.hibernate.Session;
import sys.model.Cliente;


/**
 *
 * @author omar.mahecha
 */
public interface ClienteDao {
    
        public List<Cliente> ListarClientes();
        public Cliente obtenerClientePorCodigo(String id);
}
