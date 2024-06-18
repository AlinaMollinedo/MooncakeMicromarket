import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

public class MenuAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdmin frame = new MenuAdmin();
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
	
	public MenuAdmin() {
		int id = 0;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Dimensiones.x, Dimensiones.y, Dimensiones.width, Dimensiones.height);
		setResizable(false);
		setTitle("Menu Administrador");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panTitulo = new JPanel();
		panTitulo.setForeground(new Color(254, 240, 226));
		panTitulo.setBackground(new Color(254, 240, 226));
		panTitulo.setBorder(new EmptyBorder(30, 0, 30, 0));
		contentPane.add(panTitulo, BorderLayout.NORTH);
		panTitulo.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblTitulo = new JLabel("Menú de Administrador");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(0, 0, 64));
		lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 21));
		panTitulo.add(lblTitulo);
		
		JPanel panBotones = new JPanel();
		panBotones.setBackground(new Color(254, 240, 226));
		panBotones.setBorder(new EmptyBorder(0, 250, 50, 250));
		contentPane.add(panBotones, BorderLayout.CENTER);
		panBotones.setLayout(new GridLayout(5, 1, 5, 5));
		
		JButton btnProductos = new JButton("Gestión de Productos");
		btnProductos.setForeground(new Color(0, 0, 64));
		btnProductos.setBackground(new Color(232, 252, 255));
		btnProductos.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnProductos.setAlignmentX(Component.CENTER_ALIGNMENT);
		panBotones.add(btnProductos);
		
		btnProductos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Gestion ges = new Gestion(Gestionables.productos, id);
			}
		});
		
		JButton btnEmpleados = new JButton("Gestión de Empleados");
		btnEmpleados.setForeground(new Color(0, 0, 64));
		btnEmpleados.setBackground(new Color(232, 252, 255));
		btnEmpleados.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnEmpleados.setAlignmentX(Component.CENTER_ALIGNMENT);
		panBotones.add(btnEmpleados);
		
		btnEmpleados.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ver v = new Ver(Gestionables.empleados, id);
			}
		});
		
		JButton btnClientes = new JButton("Gestión de Clientes");
		btnClientes.setForeground(new Color(0, 0, 64));
		btnClientes.setBackground(new Color(232, 252, 255));
		btnClientes.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnClientes.setAlignmentX(Component.CENTER_ALIGNMENT);
		panBotones.add(btnClientes);
		
		btnClientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ver v = new Ver(Gestionables.clientes, id);
			}
		});
		
		JButton btnSucursales = new JButton("Gestión de Sucursales");
		btnSucursales.setForeground(new Color(0, 0, 64));
		btnSucursales.setBackground(new Color(232, 252, 255));
		btnSucursales.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnSucursales.setAlignmentX(Component.CENTER_ALIGNMENT);
		panBotones.add(btnSucursales);
		
		btnSucursales.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ver v = new Ver(Gestionables.sucursales, id);
			}
		});
		
		JButton btnInmuebles = new JButton("Gestión de Inmuebles");
		btnInmuebles.setForeground(new Color(0, 0, 64));
		btnInmuebles.setBackground(new Color(232, 252, 255));
		btnInmuebles.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnInmuebles.setAlignmentX(Component.CENTER_ALIGNMENT);
		panBotones.add(btnInmuebles);
		
		btnInmuebles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Gestion ges = new Gestion(Gestionables.inmuebles, id);
			}
		});
		
		JPanel panSalir = new JPanel();
		panSalir.setBackground(new Color(254, 240, 226));
		panSalir.setBorder(new EmptyBorder(0, 0, 10, 15));
		FlowLayout flowLayout = (FlowLayout) panSalir.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panSalir, BorderLayout.SOUTH);
		
		JButton btnSalir = new JButton("Cerrar Sesión");
		btnSalir.setForeground(new Color(0, 0, 64));
		btnSalir.setBackground(new Color(232, 252, 255));
		btnSalir.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
		panSalir.add(btnSalir);
		
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Se ha cerrado sesión");
				Menu m = new Menu();
				setVisible(false);
			}
		});
		
		setVisible(true);
	}

}
