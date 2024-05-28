import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;

public class MenuSupervisor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuSupervisor frame = new MenuSupervisor();
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
	public MenuSupervisor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 414);
		setResizable(false);
		setTitle("Menu Supervisor");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panTitulo = new JPanel();
		panTitulo.setForeground(new Color(254, 240, 226));
		panTitulo.setBackground(new Color(254, 240, 226));
		panTitulo.setBorder(new EmptyBorder(40, 0, 40, 0));
		contentPane.add(panTitulo, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Menú de Supervisor");
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
		
		JButton btnEmpleados = new JButton("Gestión de Empleados");
		btnEmpleados.setForeground(new Color(0, 0, 64));
		btnEmpleados.setBackground(new Color(232, 252, 255));
		btnEmpleados.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnEmpleados.setAlignmentX(Component.CENTER_ALIGNMENT);
		panBotones.add(btnEmpleados);
		
		JButton btnInmuebles = new JButton("Gestión de Inmuebles");
		btnInmuebles.setForeground(new Color(0, 0, 64));
		btnInmuebles.setBackground(new Color(232, 252, 255));
		btnInmuebles.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnInmuebles.setAlignmentX(Component.CENTER_ALIGNMENT);
		panBotones.add(btnInmuebles);
		
		JButton btnFinanzas = new JButton("Gestión de Finanzas");
		btnFinanzas.setForeground(new Color(0, 0, 64));
		btnFinanzas.setBackground(new Color(232, 252, 255));
		btnFinanzas.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnFinanzas.setAlignmentX(Component.CENTER_ALIGNMENT);
		panBotones.add(btnFinanzas);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(0, 0, 64));
		btnSalir.setBackground(new Color(232, 252, 255));
		btnSalir.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
		panBotones.add(btnSalir);
		
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Menu m = new Menu();
				setVisible(false);
			}
		});
		
		setVisible(true);
	}

}
