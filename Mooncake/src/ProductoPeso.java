import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductoPeso extends Producto implements Descuento {
    private double pesoPorKilo;

    public ProductoPeso(int cod, String nombre, int cantidad, double precio, String descripcion, Date fechaVencimiento, double pesoPorKilo) {
        super(cod, nombre, cantidad, precio, descripcion, fechaVencimiento);
        this.pesoPorKilo = pesoPorKilo;
    }

    public double getPesoPorKilo() {
        return pesoPorKilo;
    }

    public void setPesoPorKilo(double pesoPorKilo) {
        this.pesoPorKilo = pesoPorKilo;
    }

    public double calcularPesoTotal(double cantidadKilos) {
        return pesoPorKilo * cantidadKilos;
    }

    @Override
    public double calcularDescuento(double porcentaje) {
        return getPrecio() - (getPrecio() * porcentaje / 100);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return super.toString() + ";" + pesoPorKilo;
    }
}
