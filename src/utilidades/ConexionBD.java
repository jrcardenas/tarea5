package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javier
 */
public class ConexionBD {

    private static final String sDriver = "com.mysql.cj.jdbc.Driver";
    private static final String rURL = "jdbc:mysql://";
    private static final String db_host = "localhost";
    private static final String db_name = "fcd_ad_to2";
    private static final String time_zone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String db_user = "root";
    private static final String db_pw = "";

    private static final String sURL = rURL + db_host + "/" + db_name + time_zone;

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public ConexionBD() {
    }

    public void conectar() throws ClassNotFoundException {
        try {
            Class.forName(sDriver).newInstance();
            conn = DriverManager.getConnection(sURL, db_user, db_pw);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desConectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
    private void nullearParametros() {
        stmt = null;
        rs = null;
    }

    public ResultSet ejecutarConsultaSelect(String query) {
        nullearParametros();
        ResultSet devolverResultado = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if (stmt.execute(query)) {
                rs = stmt.getResultSet();
            }
            devolverResultado = rs;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return devolverResultado;
    }

    public String ejecutarConsultaSelectSimpleOFinal(String query) {
        nullearParametros();
        String devolverResultado = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if (stmt.execute(query)) {
                rs = stmt.getResultSet();
            }
            try {
                while (rs.next()) {
                    for (int x = 1; x <= rs.getMetaData().getColumnCount(); x++) {
                        devolverResultado = rs.getString(x);
                    }
                }
            } catch (SQLException sqlEx) {
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return devolverResultado;
    }

    public void ejecutarConsultaSinReturn(String query) {
        nullearParametros();
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}
