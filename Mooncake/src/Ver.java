import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class Ver extends JFrame {

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
					Ver frame = new Ver();
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
	public Ver(int g, int idSucursal, Boolean empleado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Dimensiones.x, Dimensiones.y, Dimensiones.widthTabla, Dimensiones.heightTabla);
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
				
		JPanel panBotones = new JPanel();
		panBotones.setBackground(new Color(254, 240, 226));
		panBotones.setBorder(new EmptyBorder(10, 0, 10, 15));
		contentPane.add(panBotones, BorderLayout.SOUTH);
		panBotones.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setForeground(new Color(0, 0, 64));
		btnNuevo.setBackground(new Color(232, 252, 255));
		btnNuevo.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		
		btnNuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(g) {
				case 1:
					NuevoEmpleado nE = new NuevoEmpleado(idSucursal, 0);
					setVisible(false);
					break;
				case 3:
					NuevaSucursal nS = new NuevaSucursal(idSucursal);
					setVisible(false);
					break;
				}
			}
		});
		
		JButton btnModificar = new JButton("Modificar datos");
		btnModificar.setForeground(new Color(0, 0, 64));
		btnModificar.setBackground(new Color(232, 252, 255));
		btnModificar.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		
		btnModificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(g) {
				case 1:
					if(tabla.getSelectionModel().isSelectionEmpty()) {
						JOptionPane.showMessageDialog(null, "Seleccione a un empleado.");
					} else {
						String ci = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();
						String appaterno= tabla.getValueAt(tabla.getSelectedRow(), 2).toString();
						String apmaterno = tabla.getValueAt(tabla.getSelectedRow(), 3).toString();
						String nombre = tabla.getValueAt(tabla.getSelectedRow(), 4).toString();
						int idEmpleado = Empleado.idEmpleado(ci, nombre, appaterno, apmaterno);
						NuevoEmpleado mE = new NuevoEmpleado(idSucursal, idEmpleado);
						setVisible(false);
					}
					break;
				case 2:
					if(tabla.getSelectionModel().isSelectionEmpty()) {
						JOptionPane.showMessageDialog(null, "Seleccione a un cliente.");
					} else {
						String ci = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();
						String appaterno= tabla.getValueAt(tabla.getSelectedRow(), 3).toString();
						String apmaterno = tabla.getValueAt(tabla.getSelectedRow(), 4).toString();
						String nombre = tabla.getValueAt(tabla.getSelectedRow(), 5).toString();
						int idCliente = Cliente.id(ci, nombre, appaterno, apmaterno);
						ModificarCliente mC = new ModificarCliente(idSucursal, idCliente);
						setVisible(false);
					}
					break;
				case 3:
					if(tabla.getSelectionModel().isSelectionEmpty()) {
						JOptionPane.showMessageDialog(null, "Seleccione a una sucursal.");
					} else {
						int iidSucursal = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
						NuevaSucursal nS = new NuevaSucursal(iidSucursal);
						setVisible(false);
					}
					break;
				}
			}
		});
		
		JButton btnModUsuario = new JButton("Modificar usuario");
		btnModUsuario.setForeground(new Color(0, 0, 64));
		btnModUsuario.setBackground(new Color(232, 252, 255));
		btnModUsuario.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		
		btnModUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tabla.getSelectionModel().isSelectionEmpty()) {
						JOptionPane.showMessageDialog(null, "Seleccione a un empleado.");
				} else {
					String ci = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();
					String appaterno= tabla.getValueAt(tabla.getSelectedRow(), 2).toString();
					String apmaterno = tabla.getValueAt(tabla.getSelectedRow(), 3).toString();
					String nombre = tabla.getValueAt(tabla.getSelectedRow(), 4).toString();
					int idEmpleado = Empleado.idEmpleado(ci, nombre, appaterno, apmaterno);
					EstablecerUsuario eu = new EstablecerUsuario(true, idEmpleado, idSucursal);
					setVisible(false);
				}
			}
		});
		
		JButton btnVerEmpleados = new JButton("Ver empleados");
		btnVerEmpleados.setForeground(new Color(0, 0, 64));
		btnVerEmpleados.setBackground(new Color(232, 252, 255));
		btnVerEmpleados.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		
		btnVerEmpleados.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tabla.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Seleccione a una sucursal.");
				} else {
					int iidSucursal = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
					VerSucursal v = new VerSucursal(Gestionables.empleados, iidSucursal);
					setVisible(false);
				}
				
			}
		});
		
		JButton btnVerProductos = new JButton("Ver productos");
		btnVerProductos.setForeground(new Color(0, 0, 64));
		btnVerProductos.setBackground(new Color(232, 252, 255));
		btnVerProductos.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		
		btnVerProductos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tabla.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Seleccione a una sucursal.");
				} else {
					int iidSucursal = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
					VerSucursal v = new VerSucursal(Gestionables.productos, iidSucursal);
					setVisible(false);
				}
				
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 0, 64));
		btnVolver.setBackground(new Color(232, 252, 255));
		btnVolver.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));

		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		JButton btnSalir = new JButton("Cerrar Sesión");
		btnSalir.setForeground(new Color(0, 0, 64));
		btnSalir.setBackground(new Color(232, 252, 255));
		btnSalir.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Se ha cerrado sesión");
				Menu m = new Menu();
				setVisible(false);
			}
		});
		
		if(idSucursal > 0) {
			String s = Sucursal.nombre(idSucursal);
			JLabel lblSubtitulo = new JLabel("Sucursal " + s);
			lblSubtitulo.setHorizontalAlignment(SwingConstants.LEFT);
			lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 15));
			panTitulo.add(lblSubtitulo);
		}
		
		switch(g) {
		case 0:
			if(empleado) {
				panBotones.add(btnSalir);
			} else {
				panBotones.add(btnVolver);
			}
			if(idSucursal > 0 ) {
				String [] col0 = new String[]{"NRO", "NOMBRE", "DESCRIPCIÓN", "COSTO", "STOCK", "CATEGORÍA", "PROVEEDOR"};
				tabla = new JTable(Producto.getDataSucursal(idSucursal), col0);
			} else {
				String [] col0 = new String[]{"NRO", "NOMBRE", "DESCRIPCIÓN", "COSTO", "STOCK", "CATEGORÍA", "PROVEEDOR"};
				tabla = new JTable(Producto.getData(), col0);
			}
			break;
		case 1:
			panBotones.add(btnNuevo);
			panBotones.add(btnModificar);
			panBotones.add(btnModUsuario);
			panBotones.add(btnVolver);
			if(idSucursal > 0 ) {
				String [] col1 = new String[]{"NRO", "CI", "PATERNO", "MATERNO", "NOMBRE", "FECHA NACIMIENTO", "CORREO", "GENERO",
						"ESTADO CIVIL", "SALARIO", "CARGO", "ESTADO"};
				tabla = new JTable(Empleado.getDataSucursal(idSucursal), col1);
			} else {
				String [] col1 = new String[]{"NRO", "CI", "PATERNO", "MATERNO", "NOMBRE", "FECHA NACIMIENTO", "CORREO", "GENERO",
						"ESTADO CIVIL", "SALARIO", "CARGO", "ESTADO", "SUCURSAL"};
				tabla = new JTable(Empleado.getData(), col1);
			}
			break;
		case 2:
			panBotones.add(btnModificar);
			panBotones.add(btnVolver);
			String [] col2 = new String[]{"NRO", "CI", "PUNTOS", "PATERNO", "MATERNO", "NOMBRE", "FECHA NACIMIENTO", "CORREO", "GENERO",
					"ESTADO CIVIL"};
			tabla = new JTable(Cliente.getData(), col2);
			break;
		case 3:
			panBotones.add(btnVerEmpleados);
			panBotones.add(btnVerProductos);
			panBotones.add(btnVolver);
			String [] col3= new String[] {"NRO", "NOMBRE", "CIUDAD", "ZONA", "CALLE", "N°", "NRO EMPLEADOS", "NRO PRODUCTOS"};
			tabla = new JTable(Sucursal.getData(), col3);
			break;
		}
		
		tabla.setBackground(new Color(232, 252, 255));
		tabla.setForeground(new Color(0, 0, 64));
		tabla.setFont(new Font("Verdana", Font.PLAIN, 10));
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollTabla = new JScrollPane(tabla);
		contentPane.add(scrollTabla, BorderLayout.CENTER);
		
		setVisible(true);
	}

}
