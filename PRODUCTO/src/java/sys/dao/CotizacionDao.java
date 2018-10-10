/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import org.hibernate.Session;
import sys.model.Cotizacion;

/**
 *
 * @author omar.mahecha
 */
public interface CotizacionDao {
    public List<Cotizacion> ListarCotizaciones(String num);
    public Cotizacion obtenerCotizacionPorNumero(Session session, String num)throws Exception;
    public String totalCotizacion(String num)throws Exception;
    
}
