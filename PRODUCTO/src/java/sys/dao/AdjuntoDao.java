/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.Adjunto;

/**
 *
 * @author omar.mahecha
 */
public interface AdjuntoDao {
        public List<Adjunto> ListarAdjunto(int idSolicitud);
    public void newAdjunto(Adjunto adjunto);
    public void updateAdjunto(Adjunto adjunto);
    public void deleteAdjunto (Adjunto adjunto);
}
