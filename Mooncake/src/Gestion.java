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
		panTitulo.setBorder(new EmptyBorder(30, 0, 30, 0));
		contentPane.add(panTitulo, BorderLayout.NORTH);
		panTitulo.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblTitulo = new JLabel("Gestión de " + Gestionables.nombres[g]);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(0, 0, 64));
		lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 21));
		panTitulo.add(lblTitulo);
		
		JPanel panBotones = new JPanel();
		panBotones.setBackground(new Color(254, 240, 226));
		panBotones.setBorder(new EmptyBorder(0, 250, 50, 250));
		contentPane.add(panBotones, BorderLayout.CENTER);
		panBotones.setLayout(new GridLayout(5, 1, 5, 5));
		
		JButton btnVer = new JButton("Ver " + Gestionables.nombres[g]);
		btnVer.setForeground(new Color(0, 0, 64));
		btnVer.setBackground(new Color(232, 252, 255));
		btnVer.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnVer.setAlignmentX(Component.CENTER_ALIGNMENT);
		panBotones.add(btnVer);
		
		btnVer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ver v = new Ver(g, idSucursal);
			}
		});
		
		JButton btnModificar = new JButton("Modificar " + Gestionables.nombre[g]);
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
		
		JButton btnNuevo = new JButton("Nuevo " + Gestionables.nombre[g]);
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
		
		JButton btnEliminar = new JButton("Eliminar " + Gestionables.nombre[g]);
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
		
		
		if(idSucursal > 0) {
			String s = Sucursal.nombre(idSucursal);
			JLabel lblSubtitulo = new JLabel("Sucursal " + s);
			lblSubtitulo.setHorizontalAlignment(SwingConstants.LEFT);
			lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 15));
			panTitulo.add(lblSubtitulo);
			
			switch(g) {
			case 0:
				panBotones.add(btnPedido);
				break;
			case 1:
				panBotones.add(btnModificar);
				panBotones.add(btnNuevo);
				panBotones.add(btnEliminar);
				break;
			case 3:
				panBotones.add(btnModificar);
				break;
			case 4:
				panBotones.add(btnPedido);
				break;
			}
			
		} else {
			panBotones.add(btnModificar);
			panBotones.add(btnNuevo);
			panBotones.add(btnEliminar);
			panBotones.add(btnPedido);
		}
		
		JPanel panVolver = new JPanel();
		panVolver.setBackground(new Color(254, 240, 226));
		panVolver.setBorder(new EmptyBorder(0, 0, 10, 15));
		FlowLayout flowLayout = (FlowLayout) panVolver.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panVolver, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 0, 64));
		btnVolver.setBackground(new Color(232, 252, 255));
		btnVolver.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		panVolver.add(btnVolver);

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
