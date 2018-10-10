/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.Alerta;

/**
 *
 * @author omar.mahecha
 */
public interface AlertaDao {
    public List<Alerta> ListarAlerta();
    public void newAlerta(Alerta Alerta);
    public void updateAlerta(Alerta Alerta);
    public void deleteAlerta (Alerta Alerta);

}
