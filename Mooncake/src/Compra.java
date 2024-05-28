import java.time.*;
import java.util.*;

public class Compra extends Transaccion{
	private int idProveedor;

	public Compra(int idTransaccion, LocalTime horaTransaccion, int metodoPago, int total, int idProveedor) {
		super(idTransaccion, horaTransaccion, metodoPago, total);
		this.idProveedor = idProveedor;
	}
	
	public void realizarTransaccion() {
		
	}
}
