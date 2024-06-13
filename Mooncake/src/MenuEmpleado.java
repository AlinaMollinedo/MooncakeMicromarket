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

public class MenuEmpleado extends JFrame {

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
					MenuEmpleado frame = new MenuEmpleado();
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
	public MenuEmpleado(int idSucursal, int idEmpleado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Dimensiones.x, Dimensiones.y, Dimensiones.width, Dimensiones.height);
		setResizable(false);
		
		String cargo = Empleado.nombrePosicion(idEmpleado);
		
		setTitle("Menu " + cargo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panTitulo = new JPanel();
		panTitulo.setForeground(new Color(254, 240, 226));
		panTitulo.setBackground(new Color(254, 240, 226));
		panTitulo.setBorder(new EmptyBorder(40, 0, 40, 0));
		contentPane.add(panTitulo, BorderLayout.NORTH);
		panTitulo.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblTitulo = new JLabel("Menú de " + cargo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(0, 0, 64));
		lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 21));
		panTitulo.add(lblTitulo);
		
		String s = Sucursal.nombre(idSucursal);
		
		JLabel lblSubtitulo = new JLabel("Sucursal '" + s + "'");
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 15));
		panTitulo.add(lblSubtitulo);
		
		JPanel panBotones = new JPanel();
		panBotones.setBackground(new Color(254, 240, 226));
		panBotones.setBorder(new EmptyBorder(0, 250, 50, 250));
		contentPane.add(panBotones, BorderLayout.CENTER);
		panBotones.setLayout(new GridLayout(5, 1, 5, 5));
		
		JButton btnVenta = new JButton("Venta");
		btnVenta.setForeground(new Color(0, 0, 64));
		btnVenta.setBackground(new Color(232, 252, 255));
		btnVenta.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnVenta.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btnVenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton btnPedido = new JButton("Pedir implementos");
		btnPedido.setForeground(new Color(0, 0, 64));
		btnPedido.setBackground(new Color(232, 252, 255));
		btnPedido.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnPedido.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		int cargoo = 0;
		try {
			cargoo = Empleado.buscar(idEmpleado).getCargo();
		}catch(Exception ex) {
			 JOptionPane.showMessageDialog(null, ex);
		}
		
		switch(cargoo) {
		case 3:
			panBotones.add(btnVenta);
			break;
		case 4:
			panBotones.add(btnPedido);
			break;
		}
		
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
