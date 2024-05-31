import java.awt.EventQueue;

import java.util.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtPan12;
	private JTextField txtPan22;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
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
	
	public InicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Dimensiones.x, Dimensiones.y, Dimensiones.width, Dimensiones.height);
		setResizable(false);
		setTitle("Iniciar Sesión");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(254, 240, 226));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panTitulo = new JPanel();
		panTitulo.setBackground(new Color(254, 240, 226));
		panTitulo.setBorder(new EmptyBorder(50, 0, 50, 0));
		contentPane.add(panTitulo, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Inicio de Sesión");
		lblTitulo.setForeground(new Color(0, 0, 64));
		lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 21));
		panTitulo.add(lblTitulo);
		
		JPanel panDatos = new JPanel();
		panDatos.setBackground(new Color(254, 240, 226));
		panDatos.setBorder(new EmptyBorder(10, 100, 100, 100));
		contentPane.add(panDatos, BorderLayout.CENTER);
		panDatos.setLayout(new GridLayout(2, 2, 5, 15));
		
		JPanel pan11 = new JPanel();
		pan11.setBackground(new Color(254, 240, 226));
		FlowLayout flowLayout_1 = (FlowLayout) pan11.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panDatos.add(pan11);
		
		JLabel lblPan11 = new JLabel("Usuario:");
		lblPan11.setFont(new Font("UD Digi Kyokasho NP-R", Font.PLAIN, 13));
		pan11.add(lblPan11);
		
		JPanel pan12 = new JPanel();
		pan12.setBackground(new Color(254, 240, 226));
		FlowLayout flowLayout_2 = (FlowLayout) pan12.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panDatos.add(pan12);
		
		txtPan12 = new JTextField();
		pan12.add(txtPan12);
		txtPan12.setColumns(10);
		
		JPanel pan21 = new JPanel();
		pan21.setBackground(new Color(254, 240, 226));
		FlowLayout flowLayout_3 = (FlowLayout) pan21.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		panDatos.add(pan21);
		
		JLabel lblPan21 = new JLabel("Contraseña:");
		lblPan21.setFont(new Font("UD Digi Kyokasho NP-R", Font.PLAIN, 13));
		pan21.add(lblPan21);
		
		JPanel pan22 = new JPanel();
		pan22.setBackground(new Color(254, 240, 226));
		FlowLayout flowLayout_4 = (FlowLayout) pan22.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panDatos.add(pan22);
		
		txtPan22 = new JTextField();
		pan22.add(txtPan22);
		txtPan22.setColumns(10);
		
		JPanel panBotones = new JPanel();
		panBotones.setBackground(new Color(254, 240, 226));
		panBotones.setBorder(new EmptyBorder(0, 0, 10, 15));
		FlowLayout flowLayout = (FlowLayout) panBotones.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panBotones, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 0, 64));
		btnVolver.setBackground(new Color(232, 252, 255));
		btnVolver.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		panBotones.add(btnVolver);
		
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Menu m = new Menu();
				setVisible(false);
			}
		});
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(new Color(0, 0, 64));
		btnIngresar.setBackground(new Color(232, 252, 255));
		btnIngresar.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		panBotones.add(btnIngresar);
		
		btnIngresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user = txtPan12.getText();
				String pass = txtPan22.getText();
				int idSucursal = 0;
				Boolean flag = true;
				
				// Leer BD
				ArrayList<Empleado> empleados = new ArrayList<Empleado>();
				ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();
				
				// Para pruebas
				empleados.add(new Empleado(100, 12345, 0, 0, "Maria", "Lopez", "Cuadros", 2, 1, null, 0, 0, 0, 0, "maria.lopez@gmail.com", "su casa", "su otra casa", 3, null, 10, 2, 9876, true, "maria.lopez", "hola1234"));
				empleados.add(new Empleado(9876, 12345, 0, 0, "Nikita", "Fukurov", "Ramos", 2, 1, null, 0, 0, 0, 0, "nikita.fuku@gmail.com", "su casa", "su otra casa", 3, null, 10, 4, 0, true, "nikita.fukurov", "lmaoo"));
				empleados.add(new Empleado(102, 12345, 0, 0, "Alexander", "Soriano", "Ramirez", 2, 1, null, 0, 0, 0, 0, "alexxsoriano@gmail.com", "su casa", "su otra casa", 3, null, 10, 2, 9876, true, "alexander.soriano", "lol"));
				
				sucursales.add(new Sucursal(1111, "Los Pinos", "los pinos lol", 9876, 0, 0, null, null, null, null));
				sucursales.get(0).setEmpleados(empleados);
				
				for(Empleado em:empleados) {
					// Ingreso como empleado o supervisor
					if(user.equals(em.getUsuario()) && pass.equals(em.getContrasena()) && em.getEstado()) {
						/*
						for(Sucursal su:sucursales) {
							for(Empleado empl:su.getEmpleados()) {
								if(em.getIdPersona() == empl.getIdPersona()) {
									idSucursal = su.getIdSucursal();
								}
							}
						}
						*/
						idSucursal = Sucursal.empleadoSucursal(em.getIdPersona());
						if(em.getPosicion() != 4) {
							MenuEmpleado m = new MenuEmpleado(idSucursal, em.getPosicion());
							flag = false;
							break;
						} else {
							MenuSupervisor m = new MenuSupervisor(idSucursal);
							flag = false;
							break;
						}
					// Ingreso como administrador	
					} else if(user.equals(Admin.usuario) && pass.equals(Admin.contrasena)) {
						MenuAdmin m = new MenuAdmin();
						flag = false;
						break;
					}
				}
				// Ingreso como tercero
				if(flag) {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
					System.out.println("lol");
				}
			}
		});
		
		setVisible(true);
	}

}
