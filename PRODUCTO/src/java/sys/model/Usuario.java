package sys.model;
// Generated 3/10/2018 12:48:46 PM by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int idUsuario;
     private String usuario;
     private Funcionario cedula;
     private Perfil idPerfil;
     private String password;
     private boolean isActivo;

    public Usuario() {
    }

	
    public Usuario(int idUsuario, String usuario, Perfil idPerfil) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.idPerfil = idPerfil;
    }
    public Usuario(int idUsuario, String usuario, Funcionario cedula, Perfil idPerfil, String password, boolean isActivo) {
       this.idUsuario = idUsuario;
       this.usuario = usuario;
       this.cedula = cedula;
       this.idPerfil = idPerfil;
       this.password = password;
       this.isActivo = isActivo;
    }
   
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Funcionario getCedula() {
        return cedula;
    }

    public void setCedula(Funcionario cedula) {
        this.cedula = cedula;
    }



    public Perfil getIdPerfil() {
        return this.idPerfil;
    }
    
    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

        public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsActivo() {
        return isActivo;
    }

    public void setIsActivo(boolean isActivo) {
        this.isActivo = isActivo;
    }


}


