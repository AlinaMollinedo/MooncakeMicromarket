import java.time.LocalDate;
import java.util.*;
public class Supervisor extends Empleado{
	private ArrayList<Persona> supervisados;

	public Supervisor(int idPersona, int docIdentidad, String nombre, String paterno, String materno,
			LocalDate fechaNac, String correo, int genero, int estadoCivil, int tipo, int idEmpleado, int turno,
			int salario, int cargo, int estado, String usuario, String contrasenia, ArrayList<Persona> supervisados) {
		super(idPersona, docIdentidad, nombre, paterno, materno, fechaNac, correo, genero, estadoCivil, tipo,
				idEmpleado, turno, salario, cargo, estado, usuario, contrasenia);
		this.supervisados = supervisados;
	}

	public ArrayList<Persona> getSupervisados() {
		return supervisados;
	}

	public void setSupervisados(ArrayList<Persona> supervisados) {
		this.supervisados = supervisados;
	}

	@Override
	public String toString() {
		return "Supervisor [supervisados=" + supervisados + "]";
	}

	public void agregarSupervisado() {
		
	}
	
	public void eliminarSupervisado() {
		
	}
}
