/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.TipoAdjunto;

/**
 *
 * @author omar.mahecha
 */
public interface TipoAdjuntoDao {
    public List<TipoAdjunto> ListarTipoAdjunto();
    public void newTipoAdjunto(TipoAdjunto tipoAdjunto);
    public void updateTipoAdjunto(TipoAdjunto tipoAdjunto);
    public void deleteTipoAdjunto (TipoAdjunto tipoAdjunto);
    public List<TipoAdjunto> ListarTipoAdjuntoPorPerfil(int perfil, int estado, int soli);
}
