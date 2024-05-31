import java.time.*;
import java.util.*;

public class Compra extends Transaccion{
	private int idProveedor;

	public Compra(int idTransaccion, LocalTime horaTransaccion, int metodoPago, int total, int idProveedor) {
		super(idTransaccion, horaTransaccion, metodoPago, total);
		this.idProveedor = idProveedor;
	}
	
	
	public int getIdProveedor() {
		return idProveedor;
	}



	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	

	@Override
	public String toString() {
		return "Compra [idProveedor=" + idProveedor + "]";
	}


	public void realizarTransaccion() {
		
	}
}
