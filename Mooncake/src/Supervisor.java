import java.time.LocalDate;
import java.util.*;
public class Supervisor extends Empleado{
	private ArrayList<Persona> supervisados;

	public Supervisor(int idPersona, int docIdentidad, int complemento, int expedicion, String nombre, String paterno,
			String materno, int genero, int estadoCivil, LocalDate fechaNac, int celular1, int celular2, int telefono1,
			int telefono2, String correo, String direccion1, String direccion2, int turno, LocalDate fechaIngreso,
			int salarioHora, int posicion) {
		super(idPersona, docIdentidad, complemento, expedicion, nombre, paterno, materno, genero, estadoCivil, fechaNac,
				celular1, celular2, telefono1, telefono2, correo, direccion1, direccion2, turno, fechaIngreso,
				salarioHora, posicion);
		
		this.supervisados = new ArrayList<Persona>();
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
