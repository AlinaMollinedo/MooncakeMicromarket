import java.io.*;
import java.util.*;
import javax.swing.*;
import java.text.*;

public class Producto {
    private int idProducto;
    private String nombre;
    private int cantidad;
    private double precio;
    private String descripcion;
    private Date fechaVencimiento;
    
    public Producto(int cod, String nombre, int cantidad, double precio, String descripcion, Date fechaVencimiento) {
        this.idProducto = cod;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return idProducto + ";" + nombre + ";" + cantidad + ";" + precio
                + ";" + descripcion + ";" + fechaVencimiento;
    }
    
    public void registrarProductoTxt(String filename) {
        try {
            FileWriter escritor = new FileWriter(filename, true);
            escritor.write(this.toString() + "\n");
            escritor.close();
        } catch (IOException excp) {
            JOptionPane.showMessageDialog(null, excp.getMessage());
        }
    }
    
    public static ArrayList<Producto> leerProductosTxt(String filename) {
        ArrayList<Producto> productos = new ArrayList<>();
        String linea;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            BufferedReader lector = new BufferedReader(new FileReader(filename));
            while ((linea = lector.readLine()) != null) {
                try {
                    String[] datos = linea.split(";");
                    int cod = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    int cant = Integer.parseInt(datos[2]);
                    double precio = Double.parseDouble(datos[3]);
                    String desc = datos[4];
                    Date fechaVencimiento = sdf.parse(datos[5]);
                    String tipo = datos[6];

                    if (tipo.equals("ProductoPeso")) {
                        double pesoPorKilo = Double.parseDouble(datos[7]);
                        productos.add(new ProductoPeso(cod, nombre, cant, precio, desc, fechaVencimiento, pesoPorKilo));
                    } else if (tipo.equals("ProductoUnitario")) {
                        String categoria = datos[7];
                        productos.add(new ProductoUnitario(cod, nombre, cant, precio, desc, fechaVencimiento, categoria));
                    }
                } catch (java.text.ParseException e) {
                    JOptionPane.showMessageDialog(null, "Fecha inválida en la línea: " + linea);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Número invaido en la línea: " + linea);
                }
            }
            lector.close();
        } catch (IOException excp) {
            JOptionPane.showMessageDialog(null, excp.getMessage());
        }
        return productos;
    }
    
    public static void sobreEscribirProductosTxt(String filename, ArrayList<Producto> productos) {
        try {
            FileWriter escritor = new FileWriter(filename);
            for (Producto producto : productos) {
                escritor.write(producto.toString() + "\n");
            }
            escritor.close();
        } catch (IOException excp) {
            JOptionPane.showMessageDialog(null, excp.getMessage());
        }
    }
}

