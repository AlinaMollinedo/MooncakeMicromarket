import java.util.*;
public class Sucursal{
	private int idSucursal;
	private String nombre;
	private String direccion;
	private int idSupervisor;
	private int telefono1;
	private int telefono;
	private ArrayList<Producto> productos;
	private ArrayList<Empleado> empleados;
	private ArrayList<Transaccion> transacciones;
	private ArrayList<Proveedor> proveedores;
	
	public Sucursal(int idSucursal, String nombre, String direccion, int idSupervisor, int telefono1,
			int telefono, ArrayList<Producto> productos, ArrayList<Empleado> empleados,
			ArrayList<Transaccion> transacciones, ArrayList<Proveedor> proveedores) { 
		this.idSucursal = idSucursal;
		this.nombre = nombre;
		this.direccion = direccion;
		this.idSupervisor = idSupervisor;
		this.telefono1 = telefono1;
		this.telefono = telefono;
		this.productos = new ArrayList<Producto>();
		this.empleados = new ArrayList<Empleado>();
		this.transacciones = new ArrayList<Transaccion>();
		this.proveedores = new ArrayList<Proveedor>();
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getIdSupervisor() {
		return idSupervisor;
	}

	public void setIdSupervisor(int idSupervisor) {
		this.idSupervisor = idSupervisor;
	}

	public int getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(int telefono1) {
		this.telefono1 = telefono1;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(ArrayList<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	@Override
	public String toString() {
		return "Sucursal [idSucursal=" + idSucursal + ", nombre=" + nombre + ", direccion="
				+ direccion + ", idSupervisor=" + idSupervisor + ", telefono1=" + telefono1 + ", telefono=" + telefono
				+ ", productos=" + productos + ", empleados=" + empleados + ", transacciones=" + transacciones
				+ ", proveedores=" + proveedores + "]";
	}
	
	public static ArrayList<Sucursal> leer() {
		ArrayList <Sucursal> sucursales = new ArrayList <Sucursal>();
		return sucursales;
	}
	
	public static Sucursal buscar(int id) {
		ArrayList <Sucursal> sucursales = leer();
		for(Sucursal s:sucursales) {
			if(s.getIdSucursal() == id) {
				return s;
			}
		}
		return new Sucursal(1111, "Los Pinos", "los pinos lol", 9876, 0, 0, null, null, null, null);
	}
	
	public static int empleadoSucursal(int idEmpleado) {
		ArrayList <Sucursal> sucursales = leer();
		for(Sucursal s:sucursales) {
			for(Empleado e:s.getEmpleados()) {
				if(e.getIdPersona() == idEmpleado) {
					return s.getIdSucursal();
				}
			}
		}
		return 0;
	}
}
