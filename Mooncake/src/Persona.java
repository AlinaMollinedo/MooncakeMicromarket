import java.time.*;
public abstract class Persona {
	private int idPersona;
	private int docIdentidad;
	private int complemento;
	private int expedicion;
	private String nombre;
	private String paterno;
	private String materno;
	private int genero;
	private int estadoCivil;
	private LocalDate fechaNac;
	private int celular1;
	private int celular2;
	private int telefono1;
	private int telefono2;
	private String correo;
	private String direccion1;
	private String direccion2;
	
	public Persona(int idPersona, int docIdentidad, int complemento, int expedicion, String nombre, String paterno,
			String materno, int genero, int estadoCivil, LocalDate fechaNac, int celular1, int celular2, int telefono1,
			int telefono2, String correo, String direccion1, String direccion2) {
		this.idPersona = idPersona;
		this.docIdentidad = docIdentidad;
		this.complemento = complemento;
		this.expedicion = expedicion;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.genero = genero;
		this.estadoCivil = estadoCivil;
		this.fechaNac = fechaNac;
		this.celular1 = celular1;
		this.celular2 = celular2;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.correo = correo;
		this.direccion1 = direccion1;
		this.direccion2 = direccion2;
	}
	
	public Persona(int idPersona, int docIdentidad, String nombre, String paterno, String materno, 
			int genero, int estadoCivil, LocalDate fechaNac, int celular1, int celular2, int telefono1,
			String correo, String direccion1) {
		this.idPersona = idPersona;
		this.docIdentidad = docIdentidad;
		this.complemento = 0;
		this.expedicion = 0;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.genero = genero;
		this.estadoCivil = estadoCivil;
		this.fechaNac = fechaNac;
		this.celular1 = celular1;
		this.celular2 = celular2;
		this.telefono1 = telefono1;
		this.telefono2 = 0;
		this.correo = correo;
		this.direccion1 = direccion1;
		this.direccion2 = new String();
	}
	
	public Persona(int idPersona) {
		this.idPersona = idPersona;
		this.docIdentidad = 0;
		this.complemento = 0;
		this.expedicion = 0;
		this.nombre = new String();
		this.paterno = new String();
		this.materno = new String();
		this.genero = 0;
		this.estadoCivil = 0;
		this.fechaNac = null;
		this.celular1 = 0;
		this.celular2 = 0;
		this.telefono1 = 0;
		this.telefono2 = 0;
		this.correo = new String();
		this.direccion1 = new String();
		this.direccion2 = new String();
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
	public int getComplemento() {
		return complemento;
	}
	public void setComplemento(int complemento) {
		this.complemento = complemento;
	}
	public int getExpedicion() {
		return expedicion;
	}
	public void setExpedicion(int expedicion) {
		this.expedicion = expedicion;
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
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public int getCelular1() {
		return celular1;
	}
	public void setCelular1(int celular1) {
		this.celular1 = celular1;
	}
	public int getCelular2() {
		return celular2;
	}
	public void setCelular2(int celular2) {
		this.celular2 = celular2;
	}
	public int getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(int telefono1) {
		this.telefono1 = telefono1;
	}
	public int getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(int telefono2) {
		this.telefono2 = telefono2;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion1() {
		return direccion1;
	}
	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}
	public String getDireccion2() {
		return direccion2;
	}
	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}
	
	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", docIdentidad=" + docIdentidad + ", complemento=" + complemento
				+ ", expedicion=" + expedicion + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno
				+ ", genero=" + genero + ", estadoCivil=" + estadoCivil + ", fechaNac=" + fechaNac + ", celular1="
				+ celular1 + ", celular2=" + celular2 + ", telefono1=" + telefono1 + ", telefono2=" + telefono2
				+ ", correo=" + correo + ", direccion1=" + direccion1 + ", direccion2=" + direccion2 + "]";
	}
	
	public abstract void nuevo();
	
	public abstract void modificar();
	
	public abstract void leer();
		
	public Boolean verificarPersona() {
		return true;
	}
}
