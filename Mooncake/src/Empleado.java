import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
	private static ArrayList <Empleado> empleados;

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
	
	public Empleado(int docIdentidad, String nombre, String paterno, String materno, LocalDate fechaNac,
			String correo, int genero, int estadoCivil, int tipo, int turno, int salario, int cargo,
			int estado) {
		super(docIdentidad, nombre, paterno, materno, fechaNac, correo, genero, estadoCivil, tipo);
		this.turno = turno;
		this.salario = salario;
		this.cargo = cargo;
		this.estado = estado;
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
		return super.toString() + "Empleado [idEmpleado=" + idEmpleado + ", turno=" + turno + ", salario=" + salario + ", cargo=" + cargo
				+ ", estado=" + estado + ", usuario=" + usuario + ", contrasenia=" + contrasenia + "]";
	}

	public void nuevo() {
		
	}

	public void modificar() {
		
	}
	
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		Empleado.empleados = empleados;
	}

	public static void leer(){
		empleados = new ArrayList <Empleado>();
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
	}
	
	public static Boolean isEmpleado(String user, String pass){
		String query = "select usuario, contrasenia from estados, empleados, usuarios "
				+ "where idestado = estados_idestado and idempleado = empleados_idempleado and estados.tipoestado_idtipo = 1";
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
				String usuario = rs.getString("usuario");
				String contrasenia = rs.getString("contrasenia");
				
				if(usuario.contentEquals(user) && contrasenia.equals(pass)) {
					return true;
				}
				
			}
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return false;
	}
	
	public static int idCargo(String user, String pass){
		String query = "select cargos_idcargo from empleados, usuarios "
				+ "where empleados_idempleado = idempleado and usuario like '"+user+"' and contrasenia like '"+pass+"'";
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
				return rs.getInt("cargos_idcargo");
				
			}
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return -1;
	}
	
	public static int idCargo(int id){
		String query = "select cargos_idcargo from empleados where idempleado = "+id+"";
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
				return rs.getInt("cargos_idcargo");
				
			}
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return -1;
	}
	
	public static int idEmpleado(String user, String pass){
		String query = "select idempleado from empleados, usuarios "
				+ "where empleados_idempleado = idempleado and usuario like '"+user+"' and contrasenia like '"+pass+"'";
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
				return rs.getInt("idempleado");
				
			}
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return -1;
	}
	
	public static int idEmpleado(String ci, String nombre, String appaterno, String apmaterno){
		String query = "select idempleado from personas, empleados "
				+ "where ci = "+ci+"  and nombre like '"+nombre+"' and appaterno like '"+appaterno+"' and apmaterno like '"+apmaterno+"' and idpersona = personas_idpersona";
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
				return rs.getInt("idempleado");
				
			}
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return -1;
	}
	
	public static Integer [] ids(int idEmpleado){
		Integer [] ids = new Integer[3];
		String query = "select idpersona, iddireccion, idtelefono "
				+ "from personas, direcciones, direccionespersonas, telefonos, telefonospersonas, empleados "
				+ "where idpersona = direccionespersonas.personas_idpersona and iddireccion = direccionespersonas.direcciones_iddireccion and "
				+ "idtelefono = telefonospersonas.telefonos_id_telefono and telefonospersonas.personas_idpersona = idpersona and "
				+ "idpersona = empleados.personas_idpersona and idempleado = "+idEmpleado+"";
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
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return ids;
	}
	
	public static String nombreCargo(int idEmpleado){
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
	
	public static int count() {
		String query = "select count(0) from empleados";
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
	
	public static String [][] getData(){
		String [][] data = new String[count()][11];
		int i = 0, j = 0;
		String query = "select ci, nombre, appaterno, apmaterno, fechanac, correo, nombregenero, nombreestadoc, salario, nombrecargo "
				+ "from personas, empleados, generos, estadosciviles, cargos "
				+ "where idpersona = personas_idpersona and generos_idgenero = idgenero and estadosciviles_idestadoc = idestadoc and cargos_idcargo = idcargo "
				+ "order by appaterno asc, apmaterno asc, nombre asc";
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
				data[i][j] = rs.getString("Nombre");
				j++;
				data[i][j] = rs.getString("ApPaterno");
				j++;
				data[i][j] = rs.getString("ApMaterno");
				j++;
				data[i][j] = rs.getString("FechaNac");
				j++;
				data[i][j] = rs.getString("Correo");
				j++;
				data[i][j] = rs.getString("NombreGenero");
				j++;
				data[i][j] = rs.getString("NombreEstadoC");
				j++;
				data[i][j] = rs.getString("Salario");
				j++;
				data[i][j] = rs.getString("NombreCargo");
				j = 0;
				i++;
			}
			return data;
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return data;
	}
	
	public static String [] getData(int id){
		String [] data = new String[17];
		String query = "select personas.ci, personas.nombre, personas.appaterno, personas.apmaterno, generos_idgenero, estadosciviles_idestadoc, personas.fechanac, telefono, personas.correo, "
				+ "ciudades.idciudad, zonas.idzona, calle, nro, empleados.cargos_idcargo, estados.tipoestado_idtipo, empleados.salario, empleados.turnos_idturno "
				+ "from personas, empleados, direcciones, direccionespersonas, ciudades, zonas, telefonos, telefonospersonas, estados "
				+ "where idpersona = empleados.personas_idpersona and direccionespersonas.personas_idpersona = personas.idpersona and direccionespersonas.direcciones_iddireccion = direcciones.iddireccion and direcciones.ciudades_idciudad = ciudades.idciudad "
				+ "and direcciones.zonas_idzona = zonas.idzona and telefonospersonas.telefonos_id_telefono = telefonos.idtelefono and telefonospersonas.personas_idpersona = personas.idpersona and "
				+ "empleados.estados_idestado = estados.idestado and empleados.idempleado = "+id+"";
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
				data[13] = rs.getString("cargos_idcargo");
				data[14] = rs.getString("tipoestado_idtipo");
				data[15] = rs.getString("salario");
				data[16] = rs.getString("turnos_idturno");
			}
			return data;
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return data;
	}
	
	public static int countSucursal(int idSucursal) {
		String query = "select count(0) from empleados, sucursalesempleados "
				+ "where empleados_idempleado = idempleado and sucursales_idsucursal = '"+idSucursal+"'";
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
	
	public static String [][] getDataSucursal(int idSucursal){
		String [][] data = new String[countSucursal(idSucursal)][11];
		int i = 0, j = 0;
		String query = "select ci, nombre, appaterno, apmaterno, fechanac, correo, nombregenero, nombreestadoc, salario, nombrecargo "
				+ "from personas, empleados, generos, estadosciviles, cargos, sucursalesempleados "
				+ "where idpersona = personas_idpersona and generos_idgenero = idgenero and estadosciviles_idestadoc = idestadoc "
				+ "and cargos_idcargo = idcargo and sucursales_idsucursal = '"+idSucursal+"' and empleados_idempleado = idempleado "
				+ "order by appaterno asc, apmaterno asc, nombre asc";
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
				data[i][j] = rs.getString("Nombre");
				j++;
				data[i][j] = rs.getString("ApPaterno");
				j++;
				data[i][j] = rs.getString("ApMaterno");
				j++;
				data[i][j] = rs.getString("FechaNac");
				j++;
				data[i][j] = rs.getString("Correo");
				j++;
				data[i][j] = rs.getString("NombreGenero");
				j++;
				data[i][j] = rs.getString("NombreEstadoC");
				j++;
				data[i][j] = rs.getString("Salario");
				j++;
				data[i][j] = rs.getString("NombreCargo");
				j = 0;
				i++;
			}
			return data;
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		return data;
	}
	
	public static String [] usuario(int idEmpleado) {
		String [] uc = new String[2]; 
		String query = "select usuario, contrasenia from empleados, usuarios "
				+ "where empleados_idempleado = idempleado and idempleado = "+idEmpleado+"";
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
				uc[0] = rs.getString("usuario");
				uc[1] = rs.getString("contrasenia");
			}
		}catch(SQLException e) {
			 JOptionPane.showMessageDialog(null, e);
		}
		
		return uc;
	}
	
	public static void eliminar(int idEmpleado) {
		Connection con =  null;
		
		try {
    		Conexion c = new Conexion();
    		con = c.conectar();
    		
    		String query = "delete from sucursalesempleados where empleados_idempleado = ?";
    		PreparedStatement pstmt = con.prepareStatement(query);
    		pstmt.setInt(1, idEmpleado);
    		pstmt.executeUpdate();
    		
    		query = "delete from usuarios where empleados_idempleado= ?";
    		pstmt = con.prepareStatement(query);
    		pstmt.setInt(1, idEmpleado);
    		pstmt.executeUpdate();
    		
    		query = "delete from empleados where idempleado = ?";
    		pstmt = con.prepareStatement(query);
    		pstmt.setInt(1, idEmpleado);
    		pstmt.executeUpdate();
    		
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
	}
}
