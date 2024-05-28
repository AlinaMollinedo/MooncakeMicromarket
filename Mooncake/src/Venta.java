import java.time.*;
import java.util.*;

public class Venta extends Transaccion{
	private int idCliente;

	public Venta(int idTransaccion, LocalTime horaTransaccion, int metodoPago, int total, int idCliente) {
		super(idTransaccion, horaTransaccion, metodoPago, total);
		this.idCliente = idCliente;
	}
	
	public void realizarTransaccion() {
		
	}
}
