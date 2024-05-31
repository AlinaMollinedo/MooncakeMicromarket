import java.time.*;
import java.util.*;

public class Venta extends Transaccion{
	private int idCliente;

	public Venta(int idTransaccion, LocalTime horaTransaccion, int metodoPago, int total, int idCliente) {
		super(idTransaccion, horaTransaccion, metodoPago, total);
		this.idCliente = idCliente;
	}
	
	
	public int getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	@Override
	public String toString() {
		return "Venta [idCliente=" + idCliente + "]";
	}


	public void realizarTransaccion() {
		
	}
}
