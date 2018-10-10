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
import sys.dao.RegionalDao;
import sys.imp.RegionalDaoImp;
import sys.model.Regional;

/**
 *
 * @author omar.mahecha
 */
@Named(value = "regionalBean")
@SessionScoped
public class RegionalBean implements Serializable {
private Regional regional = new Regional();
    private List<Regional> listaRegional;
    RegionalDao rDao = new RegionalDaoImp();
    /**
     * Creates a new instance of RegionalBean
     */
    public RegionalBean() {
    }

    public Regional getRegional() {
        return regional;
    }

    public void setRegional(Regional regional) {
        this.regional = regional;
    }

    public List<Regional> getListaRegional() {
        listaRegional = rDao.ListaRegional();
        return listaRegional;
    }

    public void setListaRegional(List<Regional> listaRegional) {
        this.listaRegional = listaRegional;
    }
    
}
