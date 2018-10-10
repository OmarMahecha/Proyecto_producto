/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.Historico;

/**
 *
 * @author omar.mahecha
 */
public interface HistoricoDao {
    public List<Historico> ListarHistorico();
    public void newHistorico(Historico historico);
    public void updateHistorico(Historico historico);
    public void deleteHistorico (Historico historico);

}
