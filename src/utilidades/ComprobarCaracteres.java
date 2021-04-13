package utilidades;

import java.math.BigInteger;

/**
 *
 * @author jose ramon
 */
public class ComprobarCaracteres  {

    public ComprobarCaracteres() {
    }

    public boolean comprobarLetras(String cadena) {
        boolean check;
        String cadenaComprobar;
        check = true;
        cadenaComprobar = devolverCadenaSinEspacios(cadena);
        if (cadenaComprobar.length() < 1) {
            check = false;
        } else {
            for (int i = 0; i < cadenaComprobar.length(); i++) {
                char caracter = cadenaComprobar.toUpperCase().charAt(i);
                int valorASCII = (int) caracter;
                //if (valorASCII != 181 && valorASCII != 144 && valorASCII != 214 && valorASCII != 224 && valorASCII != 223 && valorASCII != 165 && !(valorASCII > 64 && valorASCII < 91)) {
                // Codigos ASCII Dex para Ñ, Á, É, Í, Ó, Ú y Letras respectivamente
                if (valorASCII != 209 && valorASCII != 193 && valorASCII != 201 && valorASCII != 205 && valorASCII != 211 && valorASCII != 218 && !(valorASCII > 64 && valorASCII < 91)) {
                    check = false;
                }
            }
        }
        return check;
       
}
 
        /**
        *Comprueba enteros
        *Controlar que la cadena no tiene espacios 
        * @param cadena; cadena de caracteres para analizar
        * @return una variable de tipo boolean.
        * @exception NumberFormatException  control de error de la cadena, no existe la cadena adecuada
        * @see devolverCadenaSinEspacios hace referencia a devolver cadena sin espacios
*/    

    public boolean comprobarInt(String cadena) {
        boolean check;
        BigInteger numero;
        String cadenaComprobar;
        check = true;
        cadenaComprobar = devolverCadenaSinEspacios(cadena);
        if (cadenaComprobar.length() < 1) {
            check = false;
        } else {
            try {
                numero = new BigInteger(cadenaComprobar);
            } catch (NumberFormatException error) {
                check = false;
            }
        }
        return check;
    }

    public String devolverCadenaSinEspacios(String cadena) {
        String cadenaCorrecta;
        cadenaCorrecta = cadena.trim();
        return cadenaCorrecta;
    }

}
