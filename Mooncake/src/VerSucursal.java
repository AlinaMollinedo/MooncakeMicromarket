import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VerSucursal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTable tabla;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerSucursal frame = new VerSucursal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VerSucursal(int g, int idSucursal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Dimensiones.x, Dimensiones.y, Dimensiones.width, Dimensiones.height);
		setResizable(true);
		setTitle(Gestionables.nombres[g].toUpperCase());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panTitulo = new JPanel();
		panTitulo.setForeground(new Color(254, 240, 226));
		panTitulo.setBackground(new Color(254, 240, 226));
		panTitulo.setBorder(new EmptyBorder(20, 0, 0, 0));
		contentPane.add(panTitulo, BorderLayout.NORTH);
		panTitulo.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblTitulo = new JLabel(Gestionables.nombres[g].toUpperCase());
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(0, 0, 64));
		lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 21));
		panTitulo.add(lblTitulo);
		
		JLabel lblSubtitulo = new JLabel("Sucursal " + Sucursal.nombre(idSucursal));
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 15));
		panTitulo.add(lblSubtitulo);
		 
		JPanel panBotones = new JPanel();
		panBotones.setBackground(new Color(254, 240, 226));
		panBotones.setBorder(new EmptyBorder(10, 0, 10, 15));
		FlowLayout fl_panBotones = (FlowLayout) panBotones.getLayout();
		fl_panBotones.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panBotones, BorderLayout.SOUTH);
		
		JButton btnCambiar = new JButton("Cambiar de sucursal");
		btnCambiar.setForeground(new Color(0, 0, 64));
		btnCambiar.setBackground(new Color(232, 252, 255));
		btnCambiar.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		
		btnCambiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tabla.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Seleccione a una sucursal.");
				} else {
					String ci = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();
					String appaterno= tabla.getValueAt(tabla.getSelectedRow(), 2).toString();
					String apmaterno = tabla.getValueAt(tabla.getSelectedRow(), 3).toString();
					String nombre = tabla.getValueAt(tabla.getSelectedRow(), 4).toString();
					int idEmpleado = Empleado.idEmpleado(ci, nombre, appaterno, apmaterno);
					
					String [] optt = Extras.nombres("nombreSucursal", "sucursales", "idSucursal");
					String [] opt = new String[optt.length - 1];
					int j = 0;
					for(int i = 0; i < optt.length; i++) {
						if(i != Empleado.sucursal(idEmpleado) - 1) {
							opt[j] = optt[i];
							j++;
						}
					}
					int op =JOptionPane.showOptionDialog(null, "Seleccione una sucursal: ", "Sucursal", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opt, null);
					int o = Extras.id(opt[op], "idSucursal", "nombreSucursal", "sucursales");
					Connection con =  null;
					
					if(op > -1) {
						try {
							Conexion c = new Conexion();
				    		con = c.conectar();
				    		
				    		String query = "update sucursalesEmpleados set sucursales_idSucursal = ? where empleados_idempleado = ?";
				    		
				    		PreparedStatement pstmt = con.prepareStatement(query);
				    		
				    		pstmt.setInt(1, o);
				    		pstmt.setInt(2, idEmpleado);
				    		
				    		pstmt.executeUpdate();
				    		
				    		pstmt.close();
				    		con.close();
				    		    		
				    		JOptionPane.showMessageDialog(null, "Success!");
				    		setVisible(false);
				    		VerSucursal vS = new VerSucursal(Gestionables.empleados, idSucursal);
				    		
						} catch (SQLException ee) {
					    	JOptionPane.showMessageDialog(null, ee);
					    } 
					}
				}
			}
		});
		
		if(g == Gestionables.empleados) {
			panBotones.add(btnCambiar);
			String [] col = new String[] {"NRO", "CI", "PATERNO", "MATERNO", "NOMBRE", "FECHA NACIMIENTO", "CORREO", "GENERO",
					"ESTADO CIVIL", "SALARIO", "CARGO", "ESTADO"};
			tabla = new JTable(Empleado.getDataSucursal(idSucursal), col);
		} else {
			panBotones.add(btnCambiar);
			String [] col = new String[] {"NRO", "NOMBRE", "DESCRIPCIÓN", "COSTO", "STOCK", "CATEGORÍA", "PROVEEDOR"};
			tabla = new JTable(Producto.getDataSucursal(idSucursal), col);
		}
		
		tabla.setBackground(new Color(232, 252, 255));
		tabla.setForeground(new Color(0, 0, 64));
		tabla.setFont(new Font("Verdana", Font.PLAIN, 10));
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollTabla = new JScrollPane(tabla);
		contentPane.add(scrollTabla, BorderLayout.CENTER);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 0, 64));
		btnVolver.setBackground(new Color(232, 252, 255));
		btnVolver.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		panBotones.add(btnVolver);

		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ver v = new Ver(Gestionables.sucursales, idSucursal, false);
				setVisible(false);
			}
		});
		
		setVisible(true);
	}

}
