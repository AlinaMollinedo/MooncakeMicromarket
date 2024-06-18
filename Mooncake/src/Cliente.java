import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Cliente extends Persona{
	private int idCliente;
	private int puntos;
	

	public Cliente(int idPersona, int docIdentidad, String nombre, String paterno, String materno, LocalDate fechaNac,
			String correo, int genero, int estadoCivil, int tipo, int idCliente, int puntos) {
		super(idPersona, docIdentidad, nombre, paterno, materno, fechaNac, correo, genero, estadoCivil, tipo);
		this.idCliente = idCliente;
		this.puntos = puntos;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", puntos=" + puntos + "]";
	}
	
	public static int count() {
		String query = "select count(0) from clientes";
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
	
	public static int id(String ci, String nombre, String appaterno, String apmaterno){
		String query = "select idcliente from personas, clientes "
				+ "where ci = "+ci+" and nombre like '"+nombre+"' and appaterno like '"+appaterno+"' and apmaterno like '"+apmaterno+"' and idpersona = personas_idpersona";
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
				return rs.getInt("idcliente");
				
			}
			stmt.close();
			rs.close();
			con.close();
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return -1;
	}
	
	public static Integer [] ids(int idCliente){
		Integer [] ids = new Integer[3];
		String query = "select idpersona, iddireccion, idtelefono "
				+ "from personas, clientes, direcciones, direccionespersonas, telefonos, telefonospersonas "
				+ "where idpersona = direccionespersonas.personas_idpersona and iddireccion = direccionespersonas.direcciones_iddireccion and "
				+ "idtelefono = telefonospersonas.telefonos_id_telefono and telefonospersonas.personas_idpersona = idpersona and "
				+ "idpersona = clientes.personas_idpersona and idcliente = "+idCliente+"";
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
				ids[0] = rs.getInt("idPersona");
				ids[1] = rs.getInt("idDireccion");
				ids[2] = rs.getInt("idTelefono");
				
			}
			stmt.close();
			rs.close();
			con.close();
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return ids;
	}
	
	public static String [][] getData(){
		String [][] data = new String[count()][10];
		int i = 0, j = 0;
		String query = "select ci, puntos, appaterno, apmaterno, personas.nombre as nombre, fechanac, correo, nombregenero, nombreestadoc "
				+ "from personas, clientes, generos, estadosciviles "
				+ "where idpersona = personas_idpersona and generos_idgenero = idgenero and estadosciviles_idestadoc = idestadoc "
				+ "order by appaterno asc, apmaterno asc, personas.nombre asc";
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
				data[i][j] = String.valueOf(i + 1);
				j++;
				data[i][j] = rs.getString("CI");
				j++;
				data[i][j] = rs.getString("Puntos");
				j++;
				data[i][j] = rs.getString("ApPaterno");
				j++;
				data[i][j] = rs.getString("ApMaterno");
				j++;
				data[i][j] = rs.getString("Nombre");
				j++;
				data[i][j] = rs.getString("FechaNac");
				j++;
				data[i][j] = rs.getString("Correo");
				j++;
				data[i][j] = rs.getString("NombreGenero");
				j++;
				data[i][j] = rs.getString("NombreEstadoC");
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
		String [] data = new String[13];
		String query = "select personas.ci, personas.nombre, personas.appaterno, personas.apmaterno, generos_idgenero, estadosciviles_idestadoc, personas.fechanac, telefono, personas.correo, "
				+ "ciudades.idciudad, zonas.idzona, calle, nro "
				+ "from personas, clientes, direcciones, direccionespersonas, ciudades, zonas, telefonos, telefonospersonas "
				+ "where idpersona = clientes.personas_idpersona and direccionespersonas.personas_idpersona = personas.idpersona and direccionespersonas.direcciones_iddireccion = direcciones.iddireccion and direcciones.ciudades_idciudad = ciudades.idciudad "
				+ "and direcciones.zonas_idzona = zonas.idzona and telefonospersonas.telefonos_id_telefono = telefonos.idtelefono and telefonospersonas.personas_idpersona = personas.idpersona and "
				+ "idcliente = "+id+"";
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
				data[0] = rs.getString("CI");
				data[1] = rs.getString("Nombre");
				data[2] = rs.getString("ApPaterno");
				data[3] = rs.getString("ApMaterno");
				data[4] = rs.getString("generos_idgenero");
				data[5] = rs.getString("estadosciviles_idestadoc");
				data[6] = rs.getString("fechaNac");
				data[7] = rs.getString("telefono");
				data[8] = rs.getString("correo");
				data[9] = rs.getString("idciudad");
				data[10] = rs.getString("idzona");
				data[11] = rs.getString("calle");
				data[12] = rs.getString("nro");
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
}
