/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.Solicitud;
/**
 *
 * @author omar.mahecha
 */
public interface SolicitudDao {
    public List<Solicitud> ListarSolicitudes();
    public List<Solicitud> ListarSolicitudesPorUsuario(int idUsuer, String hql);
    public void newSolicitud(Solicitud solicitud) throws Exception;
    public void updateSolicitud(Solicitud solicitud);
    public void deleteSolicitud (Solicitud solicitud);
    public List<Solicitud> buscarPorIdSoli(int id);
    public List<Solicitud> buscarPorCotizacion(String cot);
}
