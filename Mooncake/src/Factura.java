
public class Factura {
	private int idFactura;
	private String nitVendedor;
	private int nroFactura;
	private String codAut;
	private int idTransaccion;
	private int idCliente;
	
	public Factura(int idFactura, String nitVendedor, int nroFactura, String codAut, int idTransaccion, int idCliente) {
		this.idFactura = idFactura;
		this.nitVendedor = nitVendedor;
		this.nroFactura = nroFactura;
		this.codAut = codAut;
		this.idTransaccion = idTransaccion;
		this.idCliente = idCliente;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getNitVendedor() {
		return nitVendedor;
	}

	public void setNitVendedor(String nitVendedor) {
		this.nitVendedor = nitVendedor;
	}

	public int getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}

	public String getCodAut() {
		return codAut;
	}

	public void setCodAut(String codAut) {
		this.codAut = codAut;
	}

	public int getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", nitVendedor=" + nitVendedor + ", nroFactura=" + nroFactura
				+ ", codAut=" + codAut + ", idTransaccion=" + idTransaccion + ", idCliente=" + idCliente + "]";
	}
	
	
}
