/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.Ciudad;

/**
 *
 * @author omar.mahecha
 */
public interface CiudadDao {
    public List<Ciudad> listarCiudad() throws Exception;
    public List<Ciudad> listarCiudadPorDpto(String dpto) throws Exception;
}
