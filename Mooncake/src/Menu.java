import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.BoxLayout;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Dimensiones.x, Dimensiones.y, Dimensiones.width, Dimensiones.height);
		setResizable(false);
		setTitle("Menu Principal");
		contentPane = new JPanel();
		contentPane.setForeground(new Color(254, 240, 226));
		contentPane.setBackground(new Color(254, 240, 226));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panTitulo = new JPanel();
		panTitulo.setForeground(new Color(254, 240, 226));
		panTitulo.setBackground(new Color(254, 240, 226));
		panTitulo.setBorder(new EmptyBorder(50, 0, 50, 0));
		contentPane.add(panTitulo, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Menú Principal");
		lblTitulo.setForeground(new Color(0, 0, 64));
		lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 21));
		panTitulo.add(lblTitulo);
		
		JPanel panBotones = new JPanel();
		panBotones.setBackground(new Color(254, 240, 226));
		panBotones.setBorder(new EmptyBorder(0, 250, 50, 250));
		panBotones.setLayout(new GridLayout(2, 1, 30, 30));
		contentPane.add(panBotones, BorderLayout.CENTER);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setForeground(new Color(0, 0, 64));
		btnIniciarSesion.setBackground(new Color(232, 252, 255));
		btnIniciarSesion.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnIniciarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);
		panBotones.add(btnIniciarSesion);

		btnIniciarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InicioSesion i = new InicioSesion();
				setVisible(false);
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(232, 252, 255));
		btnSalir.setForeground(new Color(0, 0, 64));
		btnSalir.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
		panBotones.add(btnSalir);
		
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		JPanel panCute = new JPanel();
		panCute.setBackground(new Color(254, 240, 226));
		FlowLayout flowLayout = (FlowLayout) panCute.getLayout();
		panCute.setBorder(new EmptyBorder(0, 0, 10, 15));
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panCute, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("By Rack y Ali <3");
		lblNewLabel.setFont(new Font("UD Digi Kyokasho NP-R", Font.PLAIN, 17));
		panCute.add(lblNewLabel);
		
		setVisible(true);
	}
}
