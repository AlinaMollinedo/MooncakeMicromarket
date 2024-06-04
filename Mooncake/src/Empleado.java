import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class Empleado extends Persona{
	private int idEmpleado;
	private int turno;
	private int salario;
	private int cargo;
	private int estado;
	private String usuario;
	private String contrasenia;

	public Empleado(int idPersona, int docIdentidad, String nombre, String paterno, String materno, LocalDate fechaNac,
			String correo, int genero, int estadoCivil, int tipo, int idEmpleado, int turno, int salario, int cargo,
			int estado, String usuario, String contrasenia) {
		super(idPersona, docIdentidad, nombre, paterno, materno, fechaNac, correo, genero, estadoCivil, tipo);
		this.idEmpleado = idEmpleado;
		this.turno = turno;
		this.salario = salario;
		this.cargo = cargo;
		this.estado = estado;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", turno=" + turno + ", salario=" + salario + ", cargo=" + cargo
				+ ", estado=" + estado + ", usuario=" + usuario + ", contrasenia=" + contrasenia + "]";
	}

	public void nuevo() {
		
	}

	public void modificar() {
		
	}
	
	public static ArrayList<Empleado> leer() throws Exception{
		ArrayList <Empleado> empleados = new ArrayList <Empleado>();
		String query = "SELECT * FROM Empleados, Personas, Usuarios "
				+ "WHERE Empleados.Personas_idPersona = Personas.idPersona "
				+ "AND Usuarios.Empleados_idEmpleado = Empleados.idEmpleado";
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
				int idPersona = rs.getInt("idPersona");
				int docId = rs.getInt("CI");
				String nombre = rs.getString("Nombre");
				String paterno = rs.getString("apPaterno");
				String materno = rs.getString("apMaterno");
				
				Date fn = rs.getDate("fechaNac"); 
		        LocalDate fechaNac = fn.toLocalDate();
		        
				String correo = rs.getString("correo");
				int genero = rs.getInt("Generos_idGenero");
				int estadoC = rs.getInt("EstadosCiviles_idEstadoC");
				int tipo = rs.getInt("TiposPersonas_idTipoPersona");
				int idEmpleado = rs.getInt("idEmpleado");
				int turno = rs.getInt("Turnos_idTurno");
				int salario = rs.getInt("Salario");
				int cargo = rs.getInt("Cargos_idCargo");
				int estado = rs.getInt("Estados_idEstado");
				String usuario = rs.getString("usuario");
				String contrasenia = rs.getString("contrasenia");
				
				empleados.add(new Empleado(idPersona, docId, nombre, paterno, materno, 
						fechaNac, correo, genero, estadoC, tipo, idEmpleado, turno, salario, 
						cargo, estado, usuario, contrasenia));
			}
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		
		return empleados;
	}
	
	public static Boolean isEmpleado(String user, String pass) throws Exception {
		ArrayList <Empleado> empleados = leer();
		for(Empleado e:empleados) {
			if(e.getUsuario().equals(user) && e.getContrasenia().equals(pass)) {
				return true;
			}
		}
		return false;
	}
	
	public static Empleado buscar(String user, String pass) throws Exception{
		ArrayList <Empleado> empleados = leer();
		for(Empleado e:empleados) {
			if(e.getUsuario().equals(user) && e.getContrasenia().equals(pass)) {
				return e;
			}
		}
		return null;
	}
	
	public static Empleado buscar(int idEmpleado) throws Exception{
		ArrayList <Empleado> empleados = leer();
		for(Empleado e:empleados) {
			if(e.getIdEmpleado() == idEmpleado) {
				return e;
			}
		}
		return null;
	}
	
	public static String nombrePosicion(int idEmpleado) throws Exception{
		String query = "SELECT nombreCargo FROM Cargos, Empleados "
				+ "WHERE idCargo = Empleados.Cargos_idCargo AND Empleados.idEmpleado = '"+idEmpleado+"'";
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
				return rs.getString("nombreCargo");
			}
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		
		return null;
	}
	
	public static int sucursal(int idEmpleado) {
		String query = "SELECT sucursales.idsucursal as idSucursal "
				+ "FROM sucursalesEmpleados, sucursales, empleados "
				+ "WHERE sucursalesEmpleados.empleados_idEmpleado = empleados.idEmpleado "
				+ "AND sucursalesEmpleados.sucursales_idSucursal = sucursales.idSucursal AND idEmpleado = '"+idEmpleado+"'";
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
				return rs.getInt("idSucursal");
			}
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		
		return 0;
	}
}
