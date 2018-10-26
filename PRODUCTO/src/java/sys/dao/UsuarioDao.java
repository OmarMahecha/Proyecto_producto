/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

/**
 *
 * @author omar.mahecha
 */
import java.util.List;
import sys.model.Usuario;

/**
 *
 * @author omar.mahecha
 */
public interface UsuarioDao {
    public List<Usuario> ListarUsuario();
    public void newUsuario(Usuario Usuario)throws Exception;
    public void updateUsuario(Usuario Usuario);
    public void deleteUsuario (Usuario Usuario);
    public Usuario obtenerUsuarioPorId(int id);
    public Usuario obtenerUporUsuario(String nameUs);
    public List<Usuario> ListarUsuarioPorPerfil(int idPerfil);
    
}
