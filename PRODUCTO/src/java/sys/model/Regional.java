
package sys.model;

/**
 *
 * @author omar.mahecha
 */
public class Regional implements java.io.Serializable{
    private String codZona;
    private String nombre;
    
    
    public Regional(){
        
    } 

    public Regional(String codZona, String nombre) {
        this.codZona = codZona;
        this.nombre = nombre;
        
    }

    public String getCodZona() {
        return codZona;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    
    
}