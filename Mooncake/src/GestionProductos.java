import java.util.*;
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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GestionProductos extends JFrame {

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
					GestionProductos frame = new GestionProductos();
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
	
	public GestionProductos(int idSucursal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Dimensiones.x, Dimensiones.y, Dimensiones.width, Dimensiones.height);
		setResizable(false);
		setTitle("Gestión Productos");
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
		
		JLabel lblTitulo = new JLabel("Gestión de Productos");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(0, 0, 64));
		lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 21));
		panTitulo.add(lblTitulo);
		
		JPanel panBotones = new JPanel();
		panBotones.setBackground(new Color(254, 240, 226));
		panBotones.setBorder(new EmptyBorder(0, 250, 50, 250));
		contentPane.add(panBotones, BorderLayout.CENTER);
		panBotones.setLayout(new GridLayout(6, 1, 5, 5));
		
		JButton btnVer = new JButton("Ver productos");
		btnVer.setForeground(new Color(0, 0, 64));
		btnVer.setBackground(new Color(232, 252, 255));
		btnVer.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnVer.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btnVer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//VerProductos vp = new VerProductos(idSucursal);
			}
		});
		
		JButton btnModificar = new JButton("Modificar producto");
		btnModificar.setForeground(new Color(0, 0, 64));
		btnModificar.setBackground(new Color(232, 252, 255));
		btnModificar.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnModificar.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btnModificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//ModficarProductos mp = new ModficarProductos();
			}
		});
		
		JButton btnNuevo = new JButton("Nuevo producto");
		btnNuevo.setForeground(new Color(0, 0, 64));
		btnNuevo.setBackground(new Color(232, 252, 255));
		btnNuevo.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnNuevo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btnNuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//NuevoProducto np = new NuevoProducto();
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar productos");
		btnEliminar.setForeground(new Color(0, 0, 64));
		btnEliminar.setBackground(new Color(232, 252, 255));
		btnEliminar.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnEliminar.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//EliminarProductos ep = EliminarProductos();
			}
		});
		
		JButton btnPedido = new JButton("Realizar pedido");
		btnPedido.setForeground(new Color(0, 0, 64));
		btnPedido.setBackground(new Color(232, 252, 255));
		btnPedido.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnPedido.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btnPedido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//RealizarPedido rp = RealizarPedido();
			}
		});
		
		if(idSucursal != 0) {
			Sucursal s = Sucursal.buscar(idSucursal);
			JLabel lblSubtitulo = new JLabel("Sucursal " + s.getNombre());
			lblSubtitulo.setHorizontalAlignment(SwingConstants.LEFT);
			lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 15));
			panTitulo.add(lblSubtitulo);
			
			panBotones.add(btnVer);
			panBotones.add(btnPedido);
		} else {
			panBotones.add(btnVer);
			panBotones.add(btnModificar);
			panBotones.add(btnNuevo);
			panBotones.add(btnEliminar);
			panBotones.add(btnPedido);
		}
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 0, 64));
		btnVolver.setBackground(new Color(232, 252, 255));
		btnVolver.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		panBotones.add(btnVolver);
		
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MenuAdmin m = new MenuAdmin();
				setVisible(false);
			}
		});
		
		setVisible(true);
	}
}
