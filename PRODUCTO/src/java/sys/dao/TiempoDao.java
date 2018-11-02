/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.Tiempo;

/**
 *
 * @author omar.mahecha
 */
public interface TiempoDao {
        public List<Tiempo> ListarTiempo();
    public void newTiempo(Tiempo tiempo);
    public void updateTiempo(Tiempo tiempo);
    public void deleteTiempo (Tiempo tiempo);
    public Tiempo BuscaTiempoPorEstado (int estado);

}
