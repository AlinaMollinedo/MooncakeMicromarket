import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductoUnitario extends Producto implements Descuento {
    private String categoria;

    public ProductoUnitario(int cod, String nombre, int cantidad, double precio, String descripcion, Date fechaVencimiento, String categoria) {
        super(cod, nombre, cantidad, precio, descripcion, fechaVencimiento);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public double calcularDescuento(double porcentaje) {
        return getPrecio() - (getPrecio() * porcentaje / 100);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return super.toString() + ";" + categoria;
    }
}
