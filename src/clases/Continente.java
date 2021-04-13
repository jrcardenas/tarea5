package clases;

/** 
 * 
 * @author javier
 */
public class Continente {

    int idContinente;
    String nombreContinente;

    public Continente(int idContinente, String nombreContinente) {
        this.idContinente = idContinente;
        this.nombreContinente = nombreContinente;
    }

    public int getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(int idContinente) {
        this.idContinente = idContinente;
    }

    public String getNombreContinente() {
        return nombreContinente;
    }

    public void setNombreContinente(String nombreContinente) {
        this.nombreContinente = nombreContinente;
    }

    @Override
    public String toString() {
        return "Continente{" + "idContinente=" + idContinente + ", nombreContinente=" + nombreContinente + '}';
    }

}
