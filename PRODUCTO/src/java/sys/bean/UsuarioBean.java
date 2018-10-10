/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import sys.dao.UsuarioDao;
import sys.imp.UsuarioImp;
import sys.model.Funcionario;
import sys.model.Perfil;
import sys.model.Usuario;

/**
 *
 * @author omar.mahecha
 */
@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    private List<Usuario> listaUsuarios;
    private Usuario usuario = new Usuario();
    private Usuario Logueado = new Usuario();
    private Perfil perfil = new Perfil();
    private Funcionario funcionario = new Funcionario();
    private boolean restablecer = false;
    UsuarioDao uDao = new UsuarioImp();
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }

    public List<Usuario> getListaUsuarios() {
        listaUsuarios = uDao.ListarUsuario();
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getLogueado() {
        return Logueado;
    }

    public void setLogueado(Usuario Logueado) {
        this.Logueado = Logueado;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }


    public boolean isRestablecer() {
        return restablecer;
    }

    public void setRestablecer(boolean restablecer) {
        this.restablecer = restablecer;
    }
    public void restablecerPas(){
        String segunda = null;
        if(this.restablecer){
         
         
         this.usuario.setPassword(segunda); 
        }    
    }
    
    
    public void validaSession(){
        try {
            FacesContext context = FacesContext. getCurrentInstance();
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("ULogueado");
            if (us == null) {
                context.getExternalContext().redirect("/PRODUCTO/faces/Error.xhtml");
            }
            if (this.Logueado == null) {
                context.getExternalContext().redirect("/PRODUCTO/faces/Error.xhtml");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error al validar sesion");
        }
    }
    
    public void logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        this.Logueado = new Usuario();
        this.usuario = new Usuario();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesion Finalziada", "Cierre Completado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String logueo() {
        FacesMessage msg = null;
        String redir = null;
        String usu = this.usuario.getUsuario();
        String pas = this.usuario.getPassword();
            this.usuario = new Usuario();
        this.usuario = uDao.obtenerUporUsuario(usu);
        if (this.usuario != null) {
            if (this.usuario.getPassword().trim().equals(pas)) {
                if (this.usuario.isIsActivo()) {
                    this.Logueado = this.usuario;
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ULogueado", this.Logueado);
                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@ "+ this.Logueado.getUsuario(),null);
                    redir = "views/Solicitudes/solicitud.xhtml?faces-redirect=true";
                }else{
                    msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario "+this.usuario.getUsuario()+ " Inactivo", null);
                }
            }else{
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña Incorrecta", "La contraseña es incorrecta, Intente de nuevo");
            }

        }else{
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario Incorrecto", "El usuario no existe");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.usuario = new Usuario();
        usu = null;
        pas = null;
        return redir;
    }
    
       public void preparaNuevoUsuario(){
        usuario = new Usuario();
        perfil = new Perfil();
        funcionario = new Funcionario();
        this.restablecer = false;
    }
    
    public void nuevoUsuario(){
        try{
        this.usuario.setIdPerfil(perfil);
        this.usuario.setCedula(funcionario);
        uDao.newUsuario(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha creado el Usuario con exito", null));
        } catch (Exception e) {
            System.out.println("Error al Guardar Usuario " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A ocurrido un error al guardar el Usuario", null));
        }finally {
            this.preparaNuevoUsuario();
            RequestContext context = RequestContext.getCurrentInstance();
            context.update("formUsuario");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogUsuario').hide();");
        }
            
    }
    
    public void actualizarUsuario(){
        try{
        this.usuario.setIdPerfil(perfil);
        this.usuario.setCedula(funcionario);
        uDao.updateUsuario(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha Modificado el Usuario con exito", null));
        } catch (Exception e) {
            System.out.println("Error al Modificar Usuario " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A ocurrido un error al modificar Usuario", null));
        }finally {
            this.preparaNuevoUsuario();
             RequestContext context = RequestContext.getCurrentInstance();
            context.update("formUsuario");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogEditarUsuario').hide();");
        }
            
    }
    
    public void eliminarUsuario(){
         try{
        uDao.deleteUsuario(usuario);
        
        } catch (Exception e) {
            System.out.println("Error al Eliminar Usuario " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A ocurrido un error al Eliminar Usuario", null));
        }finally {
            this.preparaNuevoUsuario();
        }
    }
    
}
