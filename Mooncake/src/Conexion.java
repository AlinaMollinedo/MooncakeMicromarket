import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	final static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String user = "SYSTEM";
	final static String pass = "12345666";
	
	public Connection conectar() throws Exception{
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}
}
