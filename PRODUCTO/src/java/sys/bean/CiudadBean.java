/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import sys.dao.CiudadDao;
import sys.imp.CiudadDaoImp;
import sys.model.Ciudad;

/**
 *
 * @author omar.mahecha
 */
@Named(value = "ciudadBean")
@SessionScoped
public class CiudadBean implements Serializable {
private Ciudad ciudad = new Ciudad();
private List<Ciudad> listaCiudad;
private List<Ciudad> listaPorDpto;
    CiudadDao cDao = new CiudadDaoImp();
    /**
     * Creates a new instance of CiudadBean
     */
    public CiudadBean() {
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public List<Ciudad> getListaCiudad() throws Exception {
        listaCiudad = cDao.listarCiudad();
        return listaCiudad;
    }

    public void setListaCiudad(List<Ciudad> listaCiudad) {
        this.listaCiudad = listaCiudad;
    }

    public List<Ciudad> getListaPorDpto(String dpto) throws Exception {
        listaPorDpto = cDao.listarCiudadPorDpto(dpto);
        return listaPorDpto;
    }

    public void setListaPorDpto(List<Ciudad> listaPorDpto) {
        this.listaPorDpto = listaPorDpto;
    }
    
}
