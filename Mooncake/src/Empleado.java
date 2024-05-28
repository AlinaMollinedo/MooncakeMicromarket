import java.time.*;
public class Empleado extends Persona{
	private int turno;
	private LocalDate fechaIngreso;
	private int salarioHora;
	private int posicion;
	private int idSupervisor;
	private String usuario;
	private String contrasena;
	
	public Empleado(int idPersona, int docIdentidad, int complemento, int expedicion, String nombre, String paterno,
			String materno, int genero, int estadoCivil, LocalDate fechaNac, int celular1, int celular2, int telefono1,
			int telefono2, String correo, String direccion1, String direccion2, int turno, LocalDate fechaIngreso,
			int salarioHora, int posicion, int idSupervisor) {
		super(idPersona, docIdentidad, complemento, expedicion, nombre, paterno, materno, genero, estadoCivil, fechaNac,
				celular1, celular2, telefono1, telefono2, correo, direccion1, direccion2);
		this.turno = turno;
		this.fechaIngreso = fechaIngreso;
		this.salarioHora = salarioHora;
		this.posicion = posicion;
		this.idSupervisor = idSupervisor;
		this.usuario = new String();
		this.contrasena = new String();
	}
	
	public Empleado(int idPersona, int docIdentidad, int complemento, int expedicion, String nombre, String paterno,
			String materno, int genero, int estadoCivil, LocalDate fechaNac, int celular1, int celular2, int telefono1,
			int telefono2, String correo, String direccion1, String direccion2, int turno, LocalDate fechaIngreso,
			int salarioHora, int posicion) {
		super(idPersona, docIdentidad, complemento, expedicion, nombre, paterno, materno, genero, estadoCivil, fechaNac,
				celular1, celular2, telefono1, telefono2, correo, direccion1, direccion2);
		this.turno = turno;
		this.fechaIngreso = fechaIngreso;
		this.salarioHora = salarioHora;
		this.posicion = posicion;
		this.idSupervisor = 0;
		this.usuario = new String();
		this.contrasena = new String();
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getSalarioHora() {
		return salarioHora;
	}

	public void setSalarioHora(int salarioHora) {
		this.salarioHora = salarioHora;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getIdSupervisor() {
		return idSupervisor;
	}

	public void setIdSupervisor(int idSupervisor) {
		this.idSupervisor = idSupervisor;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Empleado [turno=" + turno + ", fechaIngreso=" + fechaIngreso + ", salarioHora=" + salarioHora
				+ ", posicion=" + posicion + ", idSupervisor=" + idSupervisor + ", usuario=" + usuario + ", contrasena="
				+ contrasena + "]";
	}
	
	public void establecerAcceso() {
		
	}

	public void nuevo() {
		
	}

	public void modificar() {
		
	}

	public void leer() {
		
	}
	
	
}
