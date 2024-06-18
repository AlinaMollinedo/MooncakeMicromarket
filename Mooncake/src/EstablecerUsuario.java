import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EstablecerUsuario extends JFrame {

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
					EstablecerUsuario frame = new EstablecerUsuario();
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
	public EstablecerUsuario(Boolean mod, int idEmpleado, int idSucursal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Dimensiones.x, Dimensiones.y, Dimensiones.width, Dimensiones.height);
		setResizable(true);
		if(mod) {
			setTitle("Modificar usuario");
		} else {
			setTitle("Establecer usuario");
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panTitulo = new JPanel();
		panTitulo.setForeground(new Color(254, 240, 226));
		panTitulo.setBackground(new Color(254, 240, 226));
		panTitulo.setBorder(new EmptyBorder(20, 0, 5, 0));
		contentPane.add(panTitulo, BorderLayout.NORTH);
		panTitulo.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblTitulo = new JLabel();
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(0, 0, 64));
		lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 21));
		panTitulo.add(lblTitulo);
		
		JLabel lblSubtitulo = new JLabel();
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 15));
		panTitulo.add(lblSubtitulo);
		
		if(mod) {
			lblTitulo.setText("Modificar usuario y contraseña");
			lblSubtitulo.setText("Modifique el usuario y contraseña del empleado seleccionado.");
		} else {
			lblTitulo.setText("Establecer usuario");
			lblSubtitulo.setText("Establezca un usuario y contraseña para el nuevo empleado.");
		}
		
		JPanel panDatos = new JPanel();
		panDatos.setBackground(new Color(254, 240, 226));
		panDatos.setBorder(new EmptyBorder(10, 100, 100, 100));
		contentPane.add(panDatos, BorderLayout.CENTER);
		panDatos.setLayout(new GridLayout(3, 2, 5, 15));
		
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
		
		JTextField txtPan12 = new JTextField();
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
		
		JPanel pan31 = new JPanel();
		pan31.setBackground(new Color(254, 240, 226));
		FlowLayout flowLayout_5 = (FlowLayout) pan31.getLayout();
		flowLayout_5.setAlignment(FlowLayout.RIGHT);
		panDatos.add(pan31);
		
		JLabel lblPan31 = new JLabel("Confirmar contraseña:");
		lblPan31.setFont(new Font("UD Digi Kyokasho NP-R", Font.PLAIN, 13));
		pan31.add(lblPan31);
		
		JPanel pan32 = new JPanel();
		pan32.setBackground(new Color(254, 240, 226));
		FlowLayout flowLayout_6 = (FlowLayout) pan32.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panDatos.add(pan32);
		
		JPasswordField passff = new JPasswordField(10);
		passff.setFont(new Font("Verdana", Font.PLAIN, 11));
		pan32.add(passff);
		
		JCheckBox chbxPasss = new JCheckBox("Mostrar contraseña");
		chbxPasss.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 10));
		chbxPasss.setBackground(new Color(254, 240, 226));
		chbxPasss.setFocusable(false);
		pan32.add(chbxPasss);
		
		chbxPasss.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				if(chbxPasss.isSelected()) {
					passff.setEchoChar((char) 0);
				} else {
					passff.setEchoChar('\u2022');
				}
			}
		});
		
		if(mod) {
			String [] uc = Empleado.usuario(idEmpleado);
			txtPan12.setText(uc[0]);
			passf.setText(uc[1]);
		}
		
		JPanel panBotones = new JPanel();
		panBotones.setBackground(new Color(254, 240, 226));
		panBotones.setBorder(new EmptyBorder(0, 0, 10, 15));
		FlowLayout flowLayout = (FlowLayout) panBotones.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panBotones, BorderLayout.SOUTH);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(new Color(0, 0, 64));
		btnAceptar.setBackground(new Color(232, 252, 255));
		btnAceptar.setFont(new Font("UD Digi Kyokasho NK-R", Font.PLAIN, 14));
		panBotones.add(btnAceptar);
		
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pass1 = new String(passf.getPassword());
				String pass2 = new String(passff.getPassword());
				
				if(pass1.equals(pass2)) {
					String username = txtPan12.getText();
					Connection con =  null;
					
					try {
						Conexion c = new Conexion();
			    		con = c.conectar();
			    		
			    		if(mod) {
			    			String query = "update Usuarios set idUsuario = ?, usuario = ?, contrasenia = ?, Empleados_idEmpleado = ? "
									+ "where Empleados_idEmpleado = ?";
				    		
				    		PreparedStatement pstmt = con.prepareStatement(query);
				    		
				    		pstmt.setInt(1, Empleado.idUsuario(idEmpleado));
				    		pstmt.setString(2, username);
				    		pstmt.setString(3, pass1);
				    		pstmt.setInt(4, idEmpleado);
				    		pstmt.setInt(5, idEmpleado);
				    		
				    		pstmt.executeUpdate();
			    		} else {
			    			String query = "insert into Usuarios (idUsuario, usuario, contrasenia, Empleados_idEmpleado) "
									+ "values (?, ?, ?, ?)";
				    		
				    		PreparedStatement pstmt = con.prepareStatement(query);
				    		
				    		int idU = Extras.maxId("idUsuario", "usuarios") + 1;
				    		
				    		pstmt.setInt(1, idU);
				    		pstmt.setString(2, username);
				    		pstmt.setString(3, pass1);
				    		pstmt.setInt(4, idEmpleado);
				    		
				    		pstmt.executeUpdate();
			    		}
			    		    		
			    		JOptionPane.showMessageDialog(null, "Success!");
			    		setVisible(false);
			    		Ver v = new Ver(Gestionables.empleados, idSucursal);
			    		
					} catch (SQLException ee) {
				    	JOptionPane.showMessageDialog(null, ee);
				    } 
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
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
				Ver v = new Ver(Gestionables.empleados, idSucursal);
				setVisible(false);
			}
		});
		
		if(mod) {
			panBotones.add(btnVolver);
		}
		
		setVisible(true);
	}

}
