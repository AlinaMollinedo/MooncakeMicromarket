import java.time.LocalDate;

public class Cliente extends Persona{
	private String razonSocial;
	private int nit;
	
	public Cliente(int idPersona, int docIdentidad, int complemento, int expedicion, String nombre, String paterno,
			String materno, int genero, int estadoCivil, LocalDate fechaNac, int celular1, int celular2, int telefono1,
			int telefono2, String correo, String direccion1, String direccion2, String razonSocial, int nit) {
		super(idPersona, docIdentidad, complemento, expedicion, nombre, paterno, materno, genero, estadoCivil, fechaNac,
				celular1, celular2, telefono1, telefono2, correo, direccion1, direccion2);
		this.razonSocial = razonSocial;
		this.nit = nit;
	}
	
	public Cliente(int idPersona, int docIdentidad, String nombre, String paterno, String materno, int genero, int estadoCivil, 
			LocalDate fechaNac, int celular1, int celular2, int telefono1, String correo, String direccion1, String razonSocial, int nit) {
		super(idPersona, docIdentidad, nombre, paterno, materno, genero, estadoCivil, fechaNac,
				celular1, celular2, telefono1, correo, direccion1);
		this.razonSocial = razonSocial;
		this.nit = nit;
	}

	public Cliente(int idPersona, String razonSocial, int nit) {
		super(idPersona);
		this.razonSocial = razonSocial;
		this.nit = nit;
	}

	public void nuevo() {
		
	}

	public void modificar() {
		
	}

	public void leer() {
		
	}
	
	
}
