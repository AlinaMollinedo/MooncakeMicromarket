import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) throws Exception{
    	Menu m = new Menu(); 
    	
    	/*
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            ProductoPeso productoPeso = new ProductoPeso(1, "Manzana", 50, 3.5, "Manzanas frescas", sdf.parse("01/06/2024"), 1.2);
            ProductoUnitario productoUnitario = new ProductoUnitario(2, "Lata de Atun", 30, 2.0, "Atun en lata", sdf.parse("01/12/2024"), "Comida enlatada");

            productoPeso.registrarProductoTxt("productos.txt");
            productoUnitario.registrarProductoTxt("productos.txt");

            ArrayList<Producto> productos = Producto.leerProductosTxt("productos.txt");
            for (Producto producto : productos) {
                System.out.println(producto.toString());
                if (producto instanceof Descuento) {
                    Descuento descuento = (Descuento) producto;
                    System.out.println("Precio con descuento del 10%: " + descuento.calcularDescuento(10));
                }
            }

            // Sobrescribir productos en el archivo
            Producto.sobreEscribirProductosTxt("productos.txt", productos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

}
