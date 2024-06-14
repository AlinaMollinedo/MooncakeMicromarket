import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class Gestion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion frame = new Gestion();
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
	public Gestion(int g, int idSucursal){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Dimensiones.x, Dimensiones.y, Dimensiones.width, Dimensiones.height);
		setResizable(false);
		setTitle("Gestión de " + Gestionables.nombres[g]);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panTitulo = new JPanel();
		panTitulo.setForeground(new Color(254, 240, 226));
		panTitulo.setBackground(new Color(254, 240, 226));
		panTitulo.setBorder(new EmptyBorder(20, 0, 20, 0));
		contentPane.add(panTitulo, BorderLayout.NORTH);
		panTitulo.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblTitulo = new JLabel(Gestionables.nombres[g].toUpperCase());
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(0, 0, 64));
		lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 21));
		panTitulo.add(lblTitulo);
		
		JTable tabla = new JTable();
		
		JPanel panBotones = new JPanel();
		panBotones.setBackground(new Color(254, 240, 226));
		panBotones.setBorder(new EmptyBorder(0, 0, 10, 15));
		FlowLayout fl_panBotones = (FlowLayout) panBotones.getLayout();
		fl_panBotones.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panBotones, BorderLayout.SOUTH);
		
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
					//Empleado.nuevo();
					break;
				}
			}
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(0, 0, 64));
		btnModificar.setBackground(new Color(232, 252, 255));
		btnModificar.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		
		btnModificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(g) {
				case 1:
					//int fila = tabla.getSelectedRow();
					int col = 0;
					//Empleado.modificar(tabla.getValueAt(fila, col));
					break;
				}
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(0, 0, 64));
		btnEliminar.setBackground(new Color(232, 252, 255));
		btnEliminar.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		
		if(idSucursal > 0) {
			String s = Sucursal.nombre(idSucursal);
			JLabel lblSubtitulo = new JLabel("Sucursal " + s);
			lblSubtitulo.setHorizontalAlignment(SwingConstants.LEFT);
			lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 15));
			panTitulo.add(lblSubtitulo);
			
			switch(g) {
			case 1:
				Empleado.leer();
				String [] col = new String[]{"ID", "CI", "NOMBRE", "PATERNO", "MATERNO", "FECHA NACIMIENTO", "CORREO", "GENERO",
						"ESTADO CIVIL", "SALARIO", "CARGO"};
				tabla = new JTable(Empleado.getDataSucursal(idSucursal), col);
				
				panBotones.add(btnNuevo);
				panBotones.add(btnModificar);
				panBotones.add(btnEliminar);
				break;
			}
		}
				
		tabla.setBackground(new Color(232, 252, 255));
		tabla.setForeground(new Color(0, 0, 64));
		tabla.setFont(new Font("Verdana", Font.PLAIN, 10));
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
				setVisible(false);
			}
		});
		
		setVisible(true);
	}

}
