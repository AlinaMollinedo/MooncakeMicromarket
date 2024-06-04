import java.time.*;
import java.util.ArrayList;
public abstract class Persona {
	private int idPersona;
	private int docIdentidad;
	private String nombre;
	private String paterno;
	private String materno;
	private LocalDate fechaNac;
	private String correo;
	private int genero;
	private int estadoCivil;
	private int tipo;
	
	public Persona(int idPersona, int docIdentidad, String nombre, String paterno, String materno, LocalDate fechaNac,
			String correo, int genero, int estadoCivil, int tipo) {
		this.idPersona = idPersona;
		this.docIdentidad = docIdentidad;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.fechaNac = fechaNac;
		this.correo = correo;
		this.genero = genero;
		this.estadoCivil = estadoCivil;
		this.tipo = tipo;
	}
	
	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public int getDocIdentidad() {
		return docIdentidad;
	}

	public void setDocIdentidad(int docIdentidad) {
		this.docIdentidad = docIdentidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public int getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(int estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", docIdentidad=" + docIdentidad + ", nombre=" + nombre
				+ ", paterno=" + paterno + ", materno=" + materno + ", fechaNac=" + fechaNac + ", correo=" + correo
				+ ", genero=" + genero + ", estadoCivil=" + estadoCivil + ", tipo=" + tipo + "]";
	}

	public abstract void nuevo();
	
	public abstract void modificar();
	
	//public abstract ArrayList<?> leer() throws Exception;
		
	public Boolean verificarPersona() {
		return true;
	}
}
