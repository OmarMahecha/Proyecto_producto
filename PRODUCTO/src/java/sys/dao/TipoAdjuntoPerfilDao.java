/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.TipoAdjuntoPerfil;

/**
 *
 * @author omar.mahecha
 */
public interface TipoAdjuntoPerfilDao {

    public List<TipoAdjuntoPerfil> ListarTipoAdjuntoPerfil();

    public void newTipoAdjuntoPerfil(TipoAdjuntoPerfil tipoAdjuntoPerfil);

    public void updateTipoAdjuntoPerfil(TipoAdjuntoPerfil tipoAdjuntoPerfil);

    public void deleteTipoAdjuntoPerfil(TipoAdjuntoPerfil tipoAdjuntoPerfil);
    
    public List<TipoAdjuntoPerfil> ListarTipoAdjuntoPorPerfil(int perfil, int estado, int soli);
}
