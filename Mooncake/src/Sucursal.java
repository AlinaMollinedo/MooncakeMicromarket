import java.util.*;

import javax.swing.JOptionPane;

import java.sql.*;

public class Sucursal{
	private int idSucursal;
	private String nombre;
	private int direccion;
	
	public Sucursal(int idSucursal, String nombre, int direccion) {
		super();
		this.idSucursal = idSucursal;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public int getIdSucursal() {
		return idSucursal;
	}



	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getDireccion() {
		return direccion;
	}



	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Sucursal [idSucursal=" + idSucursal + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	public static String nombre(int idSucursal){
		String query = "select nombresucursal from sucursales where idsucursal = '"+idSucursal+"'";
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
				return rs.getString("nombreSucursal");
			}
			stmt.close();
			rs.close();
			con.close();
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return null;
	}
	
	public static int count() {
		String query = "select count(0) from sucursales";
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
	
	public static String[] nombres() {
		String [] data = new String[count()];
		int i = 0;
		String query = "select nombresucursal from sucursales order by idsucursal asc";
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
				data[i] = rs.getString("nombresucursal");
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
	
	public static int id(String str) {
		String query = "select idsucursal from sucursales where nombresucursal like '"+str+"'";
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
				return rs.getInt("idsucursal");
			}
			stmt.close();
			rs.close();
			con.close();
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return -1;
	}
	
	public static int nroEmpleados(int idSucursal) {
		String query = "select count(empleados_idempleado) from sucursalesempleados, empleados, estados "
				+ "where sucursales_idsucursal = "+idSucursal+" and idempleado = empleados_idempleado and idestado = estados_idestado "
				+ "and tipoestado_idtipo <> 3";
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
				return rs.getInt("count(empleados_idempleado)");
			}
			stmt.close();
			rs.close();
			con.close();
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return -1;
	}
	
	public static int nroProductos(int idSucursal) {
		String query = "select count(idproducto) from sucursalesproductos where sucursales_idsucursal = "+idSucursal+"";
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
				return rs.getInt("count(idproducto)");
			}
			stmt.close();
			rs.close();
			con.close();
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return -1;
	}
	
	public static String [][] getData(){
		String [][] data = new String[count()][8];
		int i = 0, j = 0;
		String query = "select idsucursal, nombresucursal, ciudades.nombre, nombrezona, calle, nro "
				+ "from sucursales, direcciones, ciudades, zonas "
				+ "where direcciones_iddireccion = iddireccion and ciudades_idciudad = idciudad and zonas_idzona = idzona "
				+ "order by idsucursal asc";
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
				int id = rs.getInt("idSucursal");
				
				data[i][j] = rs.getString("idSucursal");
				j++;
				data[i][j] = rs.getString("nombresucursal");
				j++;
				data[i][j] = rs.getString("Nombre");
				j++;
				data[i][j] = rs.getString("nombrezona");
				j++;
				data[i][j] = rs.getString("calle");
				j++;
				data[i][j] = rs.getString("nro");
				j++;
				data[i][j] = String.valueOf(nroEmpleados(id));
				j++;
				data[i][j] = String.valueOf(nroProductos(id));
				j = 0;
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
	
	public static String [] getData(int id){
		String [] data = new String[5];
		String query = "select nombresucursal, ciudades_idciudad, zonas_idzona, calle, nro "
				+ "from sucursales, direcciones "
				+ "where direcciones_iddireccion = iddireccion and idsucursal = "+id+"";
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
				data[0] = rs.getString("nombresucursal");
				data[1] = rs.getString("ciudades_idciudad");
				data[2] = rs.getString("zonas_idzona");
				data[3] = rs.getString("calle");
				data[4] = rs.getString("nro");
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
	
	public static int maxId() {
		String query = "select max(idSucursal) from sucursales";
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
				return rs.getInt("max(idSucursal)");
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
