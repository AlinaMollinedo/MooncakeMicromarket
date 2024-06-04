import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
    final static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    final static String user = "system";
    final static String pass = "12345";

    public Connection conectar() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);
            throw e;
        }
        return con;
    }

    public void cerrarConexion(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
