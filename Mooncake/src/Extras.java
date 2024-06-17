import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Extras {
	public static int count(String tabla) {
		String query = "select count(0) from "+tabla+"";
		Connection con =  null;
		
		try {
    		Conexion c = new Conexion();
    		con = c.conectar();
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
		
		try (Statement stmt = con.createStatement()){
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				return rs.getInt("Count(0)");
			}
			stmt.close();
			rs.close();
			con.close();
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		
		return 0;
	}
	
	public static String[] nombres(String nombre, String tabla, String id) {
		String [] data = new String[count(tabla)];
		int i = 0;
		String query = "select "+nombre+" from "+tabla+" order by "+id+" asc";
		Connection con =  null;
		
		try {
    		Conexion c = new Conexion();
    		con = c.conectar();
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
		
		try (Statement stmt = con.createStatement()){
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				data[i] = rs.getString(nombre);
				i++;
			}
			stmt.close();
			rs.close();
			con.close();
			return data;
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return data;
	}
	
	public static int id(String str, String id, String nombre, String tabla) {
		String query = "select "+id+" from "+tabla+" where "+nombre+" like '"+str+"'";
		Connection con =  null;
		
		try {
    		Conexion c = new Conexion();
    		con = c.conectar();
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
		
		try (Statement stmt = con.createStatement()){
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				return rs.getInt(id);
			}
			stmt.close();
			rs.close();
			con.close();
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return -1;
	}
}
