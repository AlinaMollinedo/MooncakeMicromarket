import java.time.*;
import java.util.ArrayList;
public class Empleado extends Persona{
	private int turno;
	private LocalDate fechaIngreso;
	private int salarioHora;
	private int posicion;
	private int idSupervisor;
	private Boolean estado;
	private String usuario;
	private String contrasena;

	public Empleado(int idPersona, int docIdentidad, int complemento, int expedicion, String nombre, String paterno,
			String materno, int genero, int estadoCivil, LocalDate fechaNac, int celular1, int celular2, int telefono1,
			int telefono2, String correo, String direccion1, String direccion2, int turno, LocalDate fechaIngreso,
			int salarioHora, int posicion, int idSupervisor, Boolean estado, String usuario, String contrasena) {
		super(idPersona, docIdentidad, complemento, expedicion, nombre, paterno, materno, genero, estadoCivil, fechaNac,
				celular1, celular2, telefono1, telefono2, correo, direccion1, direccion2);
		this.turno = turno;
		this.fechaIngreso = fechaIngreso;
		this.salarioHora = salarioHora;
		this.posicion = posicion;
		this.idSupervisor = idSupervisor;
		this.estado = estado;
		this.usuario = usuario;
		this.contrasena = contrasena;
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
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
				+ ", posicion=" + posicion + ", idSupervisor=" + idSupervisor + ", estado=" + estado + ", usuario="
				+ usuario + ", contrasena=" + contrasena + "]";
	}

	public void establecerAcceso() {
		
	}

	public void nuevo() {
		
	}

	public void modificar() {
		
	}

	public ArrayList<Empleado> leer() {
		ArrayList <Empleado> empleados = new ArrayList <Empleado>();
		return empleados;
	}
	
	public static String nombrePosicion(int posicion) {
		switch(posicion) {
		case 1:
			return "Cajero";
		case 2:
			return "Conserje";
		case 3:
			return "Guardia";
		}
		return null;
	}
}
