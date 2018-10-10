/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.Perfil;

/**
 *
 * @author omar.mahecha
 */
public interface PerfilDao {
    public List<Perfil> ListarPerfil();
    public void newPerfil(Perfil perfil);
    public void updatePerfil(Perfil perfil);
    public void deletePerfil (Perfil perfil);

}
