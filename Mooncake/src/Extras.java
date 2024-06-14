import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Extras {
	public static int generosCount() {
		String query = "select count(0) from generos";
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
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		
		return 0;
	}
	
	public static String[] generosNombres() {
		String [] data = new String[generosCount()];
		int i = 0;
		String query = "select nombregenero from generos order by idgenero asc";
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
				data[i] = rs.getString("nombreGenero");
				i++;
			}
			return data;
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return data;
	}
	
	public static int generosId(String str) {
		String query = "select idgenero from generos where nombregenero like '"+str+"'";
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
				return rs.getInt("idGenero");
			}
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return -1;
	}
	
	public static int estadosCivilesCount() {
		String query = "select count(0) from estadosciviles";
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
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		
		return 0;
	}
	
	public static String[] estadosCivilesNombres() {
		String [] data = new String[estadosCivilesCount()];
		int i = 0;
		String query = "select nombreestadoc from estadosciviles order by idestadoc asc";
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
				data[i] = rs.getString("nombreestadoc");
				i++;
			}
			return data;
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return data;
	}
	
	public static int estadosCivilesId(String str) {
		String query = "select idestadoc from estadosciviles where nombreestadoc like '"+str+"'";
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
				return rs.getInt("idestadoc");
			}
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return -1;
	}
	
	public static int cargosCount() {
		String query = "select count(0) from cargos";
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
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		
		return 0;
	}
	
	public static String[] cargosNombres() {
		String [] data = new String[cargosCount()];
		int i = 0;
		String query = "select nombrecargo from cargos order by idcargo asc";
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
				data[i] = rs.getString("nombrecargo");
				i++;
			}
			return data;
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return data;
	}
	
	public static int cargosId(String str) {
		String query = "select idcargo from cargos where nombrecargo like '"+str+"'";
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
				return rs.getInt("idcargo");
			}
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return -1;
	}
	
	public static int estadosCount() {
		String query = "select count(0) from tipoestado";
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
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		
		return 0;
	}
	
	public static String[] estadosNombres() {
		String [] data = new String[estadosCount()];
		int i = 0;
		String query = "select nombre from tipoestado order by idtipo asc";
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
				data[i] = rs.getString("nombre");
				i++;
			}
			return data;
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return data;
	}
	
	public static int estadosId(String str) {
		String query = "select idtipo from tipoestado where nombre like '"+str+"'";
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
				return rs.getInt("idtipo");
			}
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return -1;
	}
	
	public static int turnosCount() {
		String query = "select count(0) from turnos";
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
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		
		return 0;
	}
	
	public static String[] turnosNombres() {
		String [] data = new String[turnosCount()];
		int i = 0;
		String query = "select nombreturno from turnos order by idturno asc";
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
				data[i] = rs.getString("nombreturno");
				i++;
			}
			return data;
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return data;
	}
	
	public static int turnoId(String str) {
		String query = "select idturno from turnos where nombreturno like '"+str+"'";
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
				return rs.getInt("idturno");
			}
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return -1;
	}
}
