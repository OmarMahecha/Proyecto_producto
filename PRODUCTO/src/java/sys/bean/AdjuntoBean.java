/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.URL;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.apache.poi.util.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;
import sys.dao.AdjuntoDao;
import sys.imp.AdjuntoImp;
import sys.model.Adjunto;
import sys.model.Solicitud;
import sys.model.TipoAdjunto;
import sys.model.Usuario;


/**
 *
 * @author omar.mahecha
 */
@Named(value = "adjuntoBean")
@SessionScoped
public class AdjuntoBean implements Serializable {

    private List<Adjunto> listaAdjuntos;
    private Adjunto adjunto;
    private Usuario usuario;
    private Solicitud solicitud;
    private TipoAdjunto tipoAdjunto;
    private String archivo;
    private int tipo;
    private int idSoli;
    private byte[] contenido;
    private DefaultStreamedContent download;
    private String ruta;
    /**
     * Creates a new instance of AdjuntoBean
     */
    public AdjuntoBean() {
    }

    public List<Adjunto> getListaAdjuntos() {
        AdjuntoDao aDao = new AdjuntoImp();
        listaAdjuntos = aDao.ListarAdjunto(idSoli);
        return listaAdjuntos;
    }

    public void setListaAdjuntos(List<Adjunto> listaAdjuntos) {
        this.listaAdjuntos = listaAdjuntos;
    }

    public Adjunto getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(Adjunto adjunto) {
        this.adjunto = adjunto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public TipoAdjunto getTipoAdjunto() {
        return tipoAdjunto;
    }

    public void setTipoAdjunto(TipoAdjunto tipoAdjunto) {
        this.tipoAdjunto = tipoAdjunto;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getIdSoli() {
        return idSoli;
    }

    public void setIdSoli(int idSoli) {
        this.idSoli = idSoli;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    

    public void prepararNuevoAdjunto() {
        this.adjunto = new Adjunto();
        this.archivo = null;
        this.solicitud = new Solicitud();
        this.tipoAdjunto = new TipoAdjunto();
        this.usuario = new Usuario();
        this.idSoli = 0;
        this.tipo=0;
        this.ruta= null;
    }

    public void nuevoAdjunto() {
        this.solicitud.setIdSolicitud(idSoli);
        Date fechaAdjunto = new Date();
        try {
            String ruta = null;
            if (this.archivo != null) {
                ruta =File.separator + File.separator + "servidor02" + File.separator + "RepositorioProducto" + File.separator + archivo;
                FileOutputStream fos = new FileOutputStream(ruta);
                fos.write(contenido);
                fos.close();
                this.adjunto.setFechaAdjunto(fechaAdjunto);
                this.adjunto.setIdSolicitud(solicitud);
                this.tipoAdjunto.setIdTipoAdjunto(tipo);
                this.adjunto.setIdTipoAdjunto(tipoAdjunto);
                FacesContext context = FacesContext.getCurrentInstance();
                usuario = (Usuario) context.getExternalContext().getSessionMap().get("ULogueado");
                this.adjunto.setIdUsuario(usuario);
                this.adjunto.setRutaAdjunto(ruta);

                AdjuntoDao pDao = new AdjuntoImp();
                pDao.newAdjunto(adjunto);
                if(tipo == TipoAdjuntoBean.getOFERTA_COMERCIAL()){
                SolicitudBean sBean = new SolicitudBean();
                sBean.nuevoHistoricoSolicitud(solicitud, EstadoBean.OFERTA_COMERCIAL_ADJUNTA, "Documento adjunto");
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No hay ningun archivo para adjuntar", null));
            }
            prepararNuevoAdjunto();

            RequestContext context = RequestContext.getCurrentInstance();
            context.update("formCrearSolicitud");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogAdjuntarDocumento').hide();");
        } catch (IOException e) {
            System.out.println("Error al Guardar solicitud " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A ocurrido un error al guardar el archivo", null));
        }
    }

    public DefaultStreamedContent getDownload() {
        return download;
    }

    public void setDownload(DefaultStreamedContent download) {
        this.download = download;
    }

    public void editarAdjunto() {
        AdjuntoDao pDao = new AdjuntoImp();
        pDao.updateAdjunto(adjunto);
        prepararNuevoAdjunto();
        /*  RequestContext context = RequestContext.getCurrentInstance();
            context.update("formAdjunto");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogEditarAdjunto').hide();");*/
    }

    public void eliminarAdjunto() {
        AdjuntoDao pDao = new AdjuntoImp();
        pDao.deleteAdjunto(adjunto);
        prepararNuevoAdjunto();
        /*  RequestContext context = RequestContext.getCurrentInstance();
            context.update("formAdjunto");
            RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogEliminarAdjunto').hide();");*/
    }

    public void adminCargaArchivo(FileUploadEvent event) {
        try {
            UploadedFile files = event.getFile();
            archivo = files.getFileName();
            contenido = IOUtils.toByteArray(files.getInputstream());
        } catch (IOException e) {
            System.out.println("Error al Guardar solicitud " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A ocurrido un error al guardar el archivo", null));
        }
    }
    
        public String getNombreArchivo(String archivo) {
        File objetofile = new File(archivo);
        this.archivo = objetofile.getName();
        return this.archivo;
    }

   /* public void abrirarchivo(String archivo) {

        try {

            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El archivo " + this.archivo + " Se esta abriendo", null));
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se encontro archivo adjunto para esta solicitud", null));
        }catch (Exception ex) {

            System.out.println(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se encontro archivo adjunto para esta solicitud", null));
        }
        RequestContext contextt = RequestContext.getCurrentInstance();
            contextt.execute("PF('dialogAbrirAdjunto').hide();");
    }*/
    
    public void prepDownload(String date) throws FileNotFoundException {
  File file = new File(date);
  InputStream input = new FileInputStream(file);
  ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
  setDownload(new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));
}
    
     public void downloadView(String r) throws FileNotFoundException {  
          File file = new File(r);
        InputStream input = new FileInputStream(file);
      ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
      setDownload(new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));
    }
    
    

}
