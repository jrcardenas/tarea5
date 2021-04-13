package clases;

import java.math.BigInteger;
import java.util.Comparator;

/**
 *
 * @author javier
 */
public class Pais {

    int idPais;
    int idContinente;
    String nombrePais;
    BigInteger numHabitantes;

    public Pais(int idPais, int idContinente, String nombrePais, BigInteger numHabitantes) {
        this.idPais = idPais;
        this.idContinente = idContinente;
        this.nombrePais = nombrePais;
        this.numHabitantes = numHabitantes;
    }

    public Pais(int idContinente, String nombrePais, BigInteger numHabitantes) {
        this.idContinente = idContinente;
        this.nombrePais = nombrePais;
        this.numHabitantes = numHabitantes;
    }

    public static Comparator<Pais> comparadorNombre = new Comparator<Pais>() {
        public int compare(Pais p1, Pais p2) {
            String PaisNombre1 = p1.getNombrePais().toUpperCase();
            String PaisNombre2 = p2.getNombrePais().toUpperCase();
            return PaisNombre1.compareTo(PaisNombre2);
        }
    };

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(int idContinente) {
        this.idContinente = idContinente;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public BigInteger getNumHabitantes() {
        return numHabitantes;
    }

    public void setNumHabitantes(BigInteger numHabitantes) {
        this.numHabitantes = numHabitantes;
    }

    @Override
    public String toString() {
        return "Pais{" + "idPais=" + idPais + ", idContinente=" + idContinente + ", nombrePais=" + nombrePais + ", numHabitantes=" + numHabitantes + '}';
    }

}
