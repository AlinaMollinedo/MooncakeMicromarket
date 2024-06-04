import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Categorias {
	int idCategoria;
	String nombre;
	int tipo; //1: unidad --- 2: peso
	
	public Categorias(int idCategoria, String nombre, int tipo) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public static void escribirCategoria(int id, String nombre, int tipo) {
	    try {
	        ValueChecker.checkInt(id); 
	        ValueChecker.checkString(nombre); 
	        ValueChecker.checkInt(tipo); 
	        
	        ValueChecker.checkMaxLength(nombre, 20);
	        
	        Conexion conexion = new Conexion();
	        Connection conn = conexion.conectar();
	        
	        String sql = "INSERT INTO categorias (IDCATEGORIA, NOMBRECAT, TIPOSCAT_IDTIPOSCAT) VALUES (?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, id);
	        pstmt.setString(2, nombre);
	        pstmt.setInt(3, tipo);
	        
	        pstmt.executeUpdate();
	        
	        pstmt.close();
	        conexion.cerrarConexion(conn);
	    } catch (InvalidStringLengthException e) {
	        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error de longitud", JOptionPane.ERROR_MESSAGE);
	    } catch (NotIntegerException | NotStringException e) {
	        // mensaje en la excepcion
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: " + e.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static ArrayList<Categorias> leerCategorias() {
        ArrayList<Categorias> categorias = new ArrayList<>();
        try {
        	Conexion conexion = new Conexion();
	        Connection conn = conexion.conectar();
            String sql = "SELECT IDCATEGORIA, NOMBRECAT, TIPOSCAT_IDTIPOSCAT FROM categorias";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IDCATEGORIA");
                String nombre = rs.getString("NOMBRECAT");
                int tipo = rs.getInt("TIPOSCAT_IDTIPOSCAT");
                Categorias categoria = new Categorias(id, nombre, tipo);
                categorias.add(categoria);
            }
            pstmt.close();
            conexion.cerrarConexion(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: " + e.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return categorias;
    }

	@Override
	public String toString() {
		return "Categorias [idCategoria=" + idCategoria + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}
}
