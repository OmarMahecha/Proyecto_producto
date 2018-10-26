/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.TipoCertificacion;

/**
 *
 * @author omar.mahecha
 */
public interface TipoCertificacionDao {
     public List<TipoCertificacion> ListarTipoCertificacion();
    public void newTipoCertificacion(TipoCertificacion tipo);
    public void updateTipoCertificacion(TipoCertificacion tipo);
    public void deleteTipoCertificacion (TipoCertificacion tipo);
}
