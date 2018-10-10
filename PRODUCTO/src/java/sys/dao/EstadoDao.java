/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.Estado;

/**
 *
 * @author omar.mahecha
 */
public interface EstadoDao {
    public List<Estado> ListarEstado();
    public void newEstado(Estado estado);
    public void updateEstado(Estado estado);
    public void deleteEstado (Estado estado);

}
