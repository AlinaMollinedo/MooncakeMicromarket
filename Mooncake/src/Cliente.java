import java.time.LocalDate;
import java.util.ArrayList;

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

	public void nuevo() {
		
	}

	public void modificar() {
		
	}

	public ArrayList<Cliente> leer() {
		ArrayList <Cliente> clientes = new ArrayList <Cliente>();
		return clientes;
	}
	
	
}
