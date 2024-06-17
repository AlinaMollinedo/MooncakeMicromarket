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
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class NuevaSucursal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCalle;
	private JTextField txtNro;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevaSucursal frame = new NuevaSucursal();
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
	public NuevaSucursal(int idSucursal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Dimensiones.x, Dimensiones.y, Dimensiones.width, Dimensiones.height);
		setResizable(true);
		if(idSucursal > 0) {
			setTitle("Modificar sucursal");
		} else {
			setTitle("Nueva sucursal");
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
		panTitulo.setLayout(new GridLayout(1, 1, 0, 0));
		
		JLabel lblTitulo = new JLabel();
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(0, 0, 64));
		lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 21));
		panTitulo.add(lblTitulo);
		
		if(idSucursal > 0) {
			lblTitulo.setText("Modificar sucursal");
		} else {
			lblTitulo.setText("Nueva sucursal");
		}
		
		JPanel panFormulario = new JPanel();
		panFormulario.setForeground(new Color(254, 240, 226));
		panFormulario.setBackground(new Color(254, 240, 226));
		contentPane.add(panFormulario, BorderLayout.CENTER);
		panFormulario.setLayout(new GridLayout(2, 1, 5, 5));
		
		JPanel pan1 = new JPanel();
		pan1.setForeground(new Color(254, 240, 226));
		pan1.setBackground(new Color(254, 240, 226));
		panFormulario.add(pan1);
		pan1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblCi = new JLabel("Nombre de la sucursal:");
		lblCi.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		pan1.add(lblCi);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, 10));
		pan1.add(txtNombre);
		txtNombre.setColumns(10);
		
		JPanel panDir = new JPanel();
		panDir.setBackground(new Color(254, 240, 226));
		panFormulario.add(panDir);
		panDir.setLayout(new GridLayout(2, 2, 5, 5));
		
		JPanel pan11 = new JPanel();
		pan11.setBackground(new Color(254, 240, 226));
		FlowLayout flowLayout_4 = (FlowLayout) pan11.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panDir.add(pan11);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		pan11.add(lblCiudad);
		
		JComboBox<String> comboCiudades = new JComboBox<String>(Extras.nombres("nombre", "ciudades", "idciudad"));
		comboCiudades.setBackground(new Color(232, 252, 255));
		comboCiudades.setFont(new Font("Verdana", Font.PLAIN, 9));
		pan11.add(comboCiudades);
		
		JPanel pan12 = new JPanel();
		pan12.setBackground(new Color(254, 240, 226));
		FlowLayout flowLayout_5 = (FlowLayout) pan12.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panDir.add(pan12);
		
		JLabel lblZona = new JLabel("Zona:");
		lblZona.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		pan12.add(lblZona);
		
		JComboBox<String> comboZonas = new JComboBox<String>(Extras.nombres("nombreZona", "zonas", "idzona"));
		comboZonas.setBackground(new Color(232, 252, 255));
		comboZonas.setFont(new Font("Verdana", Font.PLAIN, 9));
		pan12.add(comboZonas);
		
		JPanel pan21 = new JPanel();
		pan21.setBackground(new Color(254, 240, 226));
		FlowLayout flowLayout_6 = (FlowLayout) pan21.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panDir.add(pan21);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		pan21.add(lblCalle);
		
		txtCalle = new JTextField();
		pan21.add(txtCalle);
		txtCalle.setColumns(10);
		
		JPanel pan22 = new JPanel();
		pan22.setBackground(new Color(254, 240, 226));
		FlowLayout flowLayout_7 = (FlowLayout) pan22.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		panDir.add(pan22);
		
		JLabel lblNro = new JLabel("Número:");
		lblNro.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		pan22.add(lblNro);
		
		txtNro = new JTextField();
		pan22.add(txtNro);
		txtNro.setColumns(4);
		
		if(idSucursal > 0) {
			String [] sData = Sucursal.getData(idSucursal);
			txtNombre.setText(sData[0]);
			comboCiudades.setSelectedIndex(Integer.parseInt(sData[1]) - 1);
			comboZonas.setSelectedIndex(Integer.parseInt(sData[2]) - 1);
			txtCalle.setText(sData[3]);
			txtNro.setText(sData[4]);
		}
		
		JPanel panBotones = new JPanel();
		panBotones.setBackground(new Color(254, 240, 226));
		panBotones.setBorder(new EmptyBorder(10, 0, 10, 15));
		FlowLayout fl_panBotones = (FlowLayout) panBotones.getLayout();
		fl_panBotones.setAlignment(FlowLayout.RIGHT);
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
				Connection con =  null;
				
				try {
					/*
					ValueChecker.checkInt(txtCi.getText());
					ValueChecker.checkString(txtNombre.getText());
					ValueChecker.checkString(txtPaterno.getText());
					ValueChecker.checkString(txtMaterno.getText());
					ValueChecker.checkInt(txtDia.getText());
					ValueChecker.checkInt(txtMes.getText());
					ValueChecker.checkInt(txtAnio.getText());
					ValueChecker.checkInt(txtTel.getText());
					ValueChecker.checkString(txtCorreo.getText());
					ValueChecker.checkInt(txtSalario.getText());
					*/
					
					String nombre = txtNombre.getText();
					int ciudad = Extras.id(comboCiudades.getSelectedItem().toString(), "idCiudad", "nombre", "ciudades");
					int zona = Extras.id(comboZonas.getSelectedItem().toString(), "idZona", "nombreZona", "zonas");
					String calle = txtCalle.getText();
					int nro = Integer.parseInt(txtNro.getText());
					
					Conexion c = new Conexion();
		    		con = c.conectar();
		    		
		    		if(idSucursal > 0) {
		    			String query = "update Direcciones set idDireccion = ?, calle = ?, nro = ?, "
		    					+ "Ciudades_idCiudad = ?, Zonas_idZona = ? where idDireccion = ?";
		    		    		
    		    		PreparedStatement pstmt = con.prepareStatement(query);
    		    		
    		    		pstmt.setInt(1, 2000);
			    		pstmt.setString(2, calle);
			    		pstmt.setInt(3, nro);
			    		pstmt.setInt(4, ciudad);
			    		pstmt.setInt(5, zona);
			    		pstmt.setInt(6, 2000);
    		    		
    		    		pstmt.executeUpdate();
    		    		
    		    		query = "update Sucursales set idSucursal = 0, nombreSucursal = 0, Direcciones_idDireccion = 0 where idSucursal = ?";
    		    		
    		    		pstmt.setInt(1, 4);
			    		pstmt.setString(2, nombre);
			    		pstmt.setInt(3, 2000);
			    		pstmt.setInt(6, 4);
    		    		
    		    		pstmt.executeUpdate();
		    		} else {
		    			String query = "insert into Direcciones (idDireccion, calle, nro, Ciudades_idCiudad, Zonas_idZona) "
		    					+ "values (?, ?, ?, ?, ?)";
		    		    		
    		    		PreparedStatement pstmt = con.prepareStatement(query);
    		    		
    		    		pstmt.setInt(1, 2000);
			    		pstmt.setString(2, calle);
			    		pstmt.setInt(3, nro);
			    		pstmt.setInt(4, ciudad);
			    		pstmt.setInt(5, zona);
    		    		
    		    		pstmt.executeUpdate();
    		    		
    		    		query = "insert into Sucursales (idSucursal, nombreSucursal, Direcciones_idDireccion) values (?, ?, ?)";
    		    		
    		    		pstmt.setInt(1, 4);
			    		pstmt.setString(2, nombre);
			    		pstmt.setInt(3, 2000);
    		    		
    		    		pstmt.executeUpdate();
		    		}
		    	
					txtNombre.setText("");
					comboCiudades.setSelectedIndex(0);
					comboZonas.setSelectedIndex(0);
					txtCalle.setText("");
					txtNro.setText("");
					
					JOptionPane.showMessageDialog(null, "Success!");
					setVisible(false);
					Ver v = new Ver(3, idSucursal);
		    		
				} catch(SQLException ee) {
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});
		
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
				Ver v = new Ver(3, idSucursal);
			}
		});
		
		setVisible(true);
	}

}
