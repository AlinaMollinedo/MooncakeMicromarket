
public class Proveedor {
	private int idProveedor;
	private String nombre;
	private String descripcion;
	private int categoria;
	private String correo;
	private String url;
	private String direccion;
	private int metodoPago;

	public Proveedor(int idProveedor, String nombre, String descripcion, int categoria, String correo, String url,
			String direccion, int metodoPago) {
		super();
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.correo = correo;
		this.url = url;
		this.direccion = direccion;
		this.metodoPago = metodoPago;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(int metodoPago) {
		this.metodoPago = metodoPago;
	}

	@Override
	public String toString() {
		return "Proveedor [idProveedor=" + idProveedor + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", categoria=" + categoria + ", correo=" + correo + ", url=" + url + ", direccion=" + direccion
				+ ", metodoPago=" + metodoPago + "]";
	}

	
}
