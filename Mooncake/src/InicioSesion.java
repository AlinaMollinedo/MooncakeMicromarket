import java.awt.EventQueue;

import java.util.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPan12;

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
		txtPan12.setFont(new Font("Verdana", Font.PLAIN, 11));
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
		
		JPasswordField passf = new JPasswordField(10);
		passf.setFont(new Font("Verdana", Font.PLAIN, 11));
		pan22.add(passf);
		
		JCheckBox chbxPass = new JCheckBox("Mostrar contraseña");
		chbxPass.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 10));
		chbxPass.setBackground(new Color(254, 240, 226));
		chbxPass.setFocusable(false);
		pan22.add(chbxPass);
		
		chbxPass.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				if(chbxPass.isSelected()) {
					passf.setEchoChar((char) 0);
				} else {
					passf.setEchoChar('\u2022');
				}
			}
		});
		
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
				String pass = new String(passf.getPassword());
				
				Boolean esEmpl = Empleado.isEmpleado(user, pass);
				
				if(esEmpl) {
					int idEmpleado = Empleado.id(user, pass);
					int idSucursal = Empleado.sucursal(idEmpleado);
					switch(Empleado.cargo(user, pass)) {
					case 1:
						MenuAdmin mA = new MenuAdmin(); 
						setVisible(false);
						break;
					case 2:
						MenuSupervisor mS = new MenuSupervisor(idSucursal);
						setVisible(false);
						break;
					default:
						MenuEmpleado mE = new MenuEmpleado(idSucursal, idEmpleado);
						setVisible(false);
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
				}
			}
		});
		
		contentPane.getRootPane().setDefaultButton(btnIngresar);
		
		setVisible(true);
	}

}
