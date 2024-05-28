import java.time.*;
import java.util.*;

public abstract class Transaccion {
	private int idTransaccion;
	private LocalTime horaTransaccion;
	private ArrayList<Producto> productos;
	private ArrayList<Integer> cantidades;
	private int metodoPago;
	private int total;
	
	public Transaccion(int idTransaccion, LocalTime horaTransaccion, int metodoPago, int total) {
		this.idTransaccion = idTransaccion;
		this.horaTransaccion = horaTransaccion;
		this.productos = new ArrayList<Producto>();
		this.cantidades = new ArrayList<Integer>();
		this.metodoPago = metodoPago;
		this.total = total;
	}

	public int getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public LocalTime getHoraTransaccion() {
		return horaTransaccion;
	}

	public void setHoraTransaccion(LocalTime horaTransaccion) {
		this.horaTransaccion = horaTransaccion;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public ArrayList<Integer> getCantidades() {
		return cantidades;
	}

	public void setCantidades(ArrayList<Integer> cantidades) {
		this.cantidades = cantidades;
	}

	public int getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(int metodoPago) {
		this.metodoPago = metodoPago;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Transaccion [idTransaccion=" + idTransaccion + ", horaTransaccion=" + horaTransaccion + ", productos="
				+ productos + ", cantidades=" + cantidades + ", metodoPago=" + metodoPago + ", total=" + total + "]";
	}
		
	public abstract void realizarTransaccion();
}
