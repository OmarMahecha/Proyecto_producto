/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.model;

/**
 *
 * @author omar.mahecha
 */
public class TipoAdjuntoPerfil implements java.io.Serializable {

    private int idTipoAdjuntoPerfil;
    private TipoAdjunto idTipoAdjunto;
    private Perfil idPerfil;
    private Estado idEstado;

    public TipoAdjuntoPerfil() {
    }

    public TipoAdjuntoPerfil(int idTipoAdjuntoPerfil, TipoAdjunto idTipoAdjunto, Perfil idPerfil, Estado idEstado) {
        this.idTipoAdjuntoPerfil = idTipoAdjuntoPerfil;
        this.idTipoAdjunto = idTipoAdjunto;
        this.idPerfil = idPerfil;
        this.idEstado = idEstado;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }


    public int getIdTipoAdjuntoPerfil() {
        return idTipoAdjuntoPerfil;
    }

    public void setIdTipoAdjuntoPerfil(int idTipoAdjuntoPerfil) {
        this.idTipoAdjuntoPerfil = idTipoAdjuntoPerfil;
    }

    public TipoAdjunto getIdTipoAdjunto() {
        return idTipoAdjunto;
    }

    public void setIdTipoAdjunto(TipoAdjunto idTipoAdjunto) {
        this.idTipoAdjunto = idTipoAdjunto;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

}
