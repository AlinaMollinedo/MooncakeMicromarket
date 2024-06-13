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

	public static ArrayList<Sucursal> leer(){
		ArrayList <Sucursal> sucursales = new ArrayList <Sucursal>();
		String query = "SELECT * FROM Sucursales";
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
				int idSucursal = rs.getInt("idSucursal");
				String nombre = rs.getString("nombreSucursal");
				int dir = rs.getInt("Direcciones_idDireccion");
				
				sucursales.add(new Sucursal(idSucursal, nombre, dir));
			}
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		
		return sucursales;
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
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return null;
	}
	
	/*
	public static Sucursal buscar(int id) {
		ArrayList <Sucursal> sucursales = leer();
		for(Sucursal s:sucursales) {
			if(s.getIdSucursal() == id) {
				return s;
			}
		}
		return new Sucursal(1111, "Los Pinos", 11);
	}
	/*
	public static int empleadoSucursal(int idEmpleado) {
		ArrayList <Sucursal> sucursales = leer();
		for(Sucursal s:sucursales) {
			for(Empleado e:s.getEmpleados()) {
				if(e.getIdPersona() == idEmpleado) {
					return s.getIdSucursal();
				}
			}
		}
		return 0;
	}
	*/
}
