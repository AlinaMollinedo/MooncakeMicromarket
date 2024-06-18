import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ModificarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCi;
	private JTextField txtNombre;
	private JTextField txtPaterno;
	private JTextField txtMaterno;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAnio;
	private JTextField txtTel;
	private JTextField txtCorreo;
	private JTextField txtSalario;
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
					ModificarCliente frame = new ModificarCliente();
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
	public ModificarCliente(int idSucursal, int idCliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Dimensiones.x, Dimensiones.y, Dimensiones.width, Dimensiones.height);
		setResizable(true);
		setTitle("Modificar cliente");
		
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
		
		JLabel lblTitulo = new JLabel("Modificar cliente");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(0, 0, 64));
		lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 21));
		panTitulo.add(lblTitulo);
		
		JPanel panFormulario = new JPanel();
		panFormulario.setForeground(new Color(254, 240, 226));
		panFormulario.setBackground(new Color(254, 240, 226));
		contentPane.add(panFormulario, BorderLayout.CENTER);
		panFormulario.setLayout(new GridLayout(3, 1, 5, 5));
		
		JPanel pan1 = new JPanel();
		pan1.setForeground(new Color(254, 240, 226));
		pan1.setBackground(new Color(254, 240, 226));
		panFormulario.add(pan1);
		pan1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JPanel panCi = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panCi.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panCi.setForeground(new Color(254, 240, 226));
		panCi.setBackground(new Color(254, 240, 226));
		pan1.add(panCi);
		
		JLabel lblCi = new JLabel("Carnet de Identidad:");
		lblCi.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		panCi.add(lblCi);
		
		txtCi = new JTextField();
		txtCi.setFont(new Font("Verdana", Font.PLAIN, 10));
		panCi.add(txtCi);
		txtCi.setColumns(10);
		
		JPanel panNombre = new JPanel();
		panNombre.setForeground(new Color(254, 240, 226));
		panNombre.setBackground(new Color(254, 240, 226));
		pan1.add(panNombre);
		panNombre.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre completo:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		panNombre.add(lblNombre);
		
		JPanel panN = new JPanel();
		panN.setForeground(new Color(254, 240, 226));
		panN.setBackground(new Color(254, 240, 226));
		panNombre.add(panN);
		panN.setLayout(new BoxLayout(panN, BoxLayout.Y_AXIS));
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, 10));
		panN.setBorder(new EmptyBorder(5, 5, 5, 5));
		panN.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblN = new JLabel("Nombres");
		lblN.setFont(new Font("Verdana", Font.PLAIN, 8));
		lblN.setAlignmentX(Component.CENTER_ALIGNMENT);
		panN.add(lblN);
		
		JPanel panP = new JPanel();
		panP.setForeground(new Color(254, 240, 226));
		panP.setBackground(new Color(254, 240, 226));
		panNombre.add(panP);
		panP.setLayout(new BoxLayout(panP, BoxLayout.Y_AXIS));
		
		txtPaterno = new JTextField();
		txtPaterno.setFont(new Font("Verdana", Font.PLAIN, 10));
		panP.setBorder(new EmptyBorder(5, 5, 5, 5));
		panP.add(txtPaterno);
		txtPaterno.setColumns(10);
		
		JLabel lblP = new JLabel("Ap. paterno");
		lblP.setFont(new Font("Verdana", Font.PLAIN, 8));
		lblP.setAlignmentX(Component.CENTER_ALIGNMENT);
		panP.add(lblP);
		
		JPanel panM = new JPanel();
		panM.setForeground(new Color(254, 240, 226));
		panM.setBackground(new Color(254, 240, 226));
		panNombre.add(panM);
		panM.setLayout(new BoxLayout(panM, BoxLayout.Y_AXIS));
		
		txtMaterno = new JTextField();
		txtMaterno.setFont(new Font("Verdana", Font.PLAIN, 10));
		panM.setBorder(new EmptyBorder(5, 5, 5, 5));
		panM.add(txtMaterno);
		txtMaterno.setColumns(10);
		
		JLabel lblM = new JLabel("Ap. materno");
		lblM.setFont(new Font("Verdana", Font.PLAIN, 8));
		lblM.setAlignmentX(Component.CENTER_ALIGNMENT);
		panM.add(lblM);
		
		JPanel pan2 = new JPanel();
		pan2.setBackground(new Color(254, 240, 226));
		panFormulario.add(pan2);
		pan2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JPanel panGenero = new JPanel();
		panGenero.setBackground(new Color(254, 240, 226));
		pan2.add(panGenero);
		
		JLabel lblGenero = new JLabel("Género:");
		lblGenero.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		panGenero.add(lblGenero);
		
		JComboBox<String> comboGeneros = new JComboBox<String>(Extras.nombres("nombreGenero", "generos", "idgenero"));
		comboGeneros.setBackground(new Color(232, 252, 255));
		comboGeneros.setFont(new Font("Verdana", Font.PLAIN, 9));
		panGenero.add(comboGeneros);
		
		JPanel panEstadoC = new JPanel();
		panEstadoC.setBackground(new Color(254, 240, 226));
		pan2.add(panEstadoC);
		
		JLabel lblEstadoC = new JLabel("Estado Civil:");
		lblEstadoC.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		panEstadoC.add(lblEstadoC);
		
		JComboBox<String> comboEstadosC = new JComboBox<String>(Extras.nombres("nombreEstadoC", "estadosCiviles", "idestadoc"));
		comboEstadosC.setBackground(new Color(232, 252, 255));
		comboEstadosC.setFont(new Font("Verdana", Font.PLAIN, 9));
		panEstadoC.add(comboEstadosC);
		
		JPanel panFechaNac = new JPanel();
		panFechaNac.setBackground(new Color(254, 240, 226));
		pan2.add(panFechaNac);
		
		JPanel panF = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panF.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panF.setBackground(new Color(254, 240, 226));
		panFechaNac.add(panF);
		
		JLabel lblFechaNac = new JLabel("Fecha de nacimiento:");
		lblFechaNac.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		panF.add(lblFechaNac);
		
		JPanel panFecha = new JPanel();
		panFechaNac.add(panFecha);
		panFecha.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panDia = new JPanel();
		panDia.setBackground(new Color(254, 240, 226));
		panDia.setBorder(new EmptyBorder(5, 5, 5, 5));
		panFecha.add(panDia);
		panDia.setLayout(new BoxLayout(panDia, BoxLayout.Y_AXIS));
		
		txtDia = new JTextField();
		txtDia.setFont(new Font("Verdana", Font.PLAIN, 10));
		panDia.add(txtDia);
		txtDia.setColumns(5);
		
		JLabel lblDia = new JLabel("Día");
		lblDia.setFont(new Font("Verdana", Font.PLAIN, 8));
		lblDia.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDia.setHorizontalAlignment(SwingConstants.CENTER);
		panDia.add(lblDia);
		
		JPanel panMes = new JPanel();
		panMes.setBackground(new Color(254, 240, 226));
		panMes.setBorder(new EmptyBorder(5, 5, 5, 5));
		panFecha.add(panMes);
		panMes.setLayout(new BoxLayout(panMes, BoxLayout.Y_AXIS));
		
		txtMes = new JTextField();
		txtMes.setFont(new Font("Verdana", Font.PLAIN, 10));
		panMes.add(txtMes);
		txtMes.setColumns(5);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setFont(new Font("Verdana", Font.PLAIN, 8));
		lblMes.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		panMes.add(lblMes);
		
		JPanel panAnio = new JPanel();
		panAnio.setBackground(new Color(254, 240, 226));
		panAnio.setBorder(new EmptyBorder(5, 5, 5, 5));
		panFecha.add(panAnio);
		panAnio.setLayout(new BoxLayout(panAnio, BoxLayout.Y_AXIS));
		
		txtAnio = new JTextField();
		txtAnio.setFont(new Font("Verdana", Font.PLAIN, 10));
		panAnio.add(txtAnio);
		txtAnio.setColumns(5);
		
		JLabel lblAnio = new JLabel("Año");
		lblAnio.setFont(new Font("Verdana", Font.PLAIN, 8));
		lblAnio.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAnio.setHorizontalAlignment(SwingConstants.CENTER);
		panAnio.add(lblAnio);
		
		JPanel pan3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pan3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pan3.setBackground(new Color(254, 240, 226));
		panFormulario.add(pan3);
		
		JLabel lblTel = new JLabel("Teléfono:");
		lblTel.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		pan3.add(lblTel);
		
		txtTel = new JTextField();
		txtTel.setFont(new Font("Verdana", Font.PLAIN, 10));
		pan3.add(txtTel);
		txtTel.setColumns(9);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		pan3.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Verdana", Font.PLAIN, 10));
		pan3.add(txtCorreo);
		txtCorreo.setColumns(20);
		
		JPanel panDir = new JPanel();
		panDir.setBackground(new Color(254, 240, 226));
		pan3.add(panDir);
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
		
		String [] cData = Cliente.getData(idCliente);
		txtCi.setText(cData[0]);
		txtNombre.setText(cData[1]);
		txtPaterno.setText(cData[2]);
		txtMaterno.setText(cData[3]);
		comboGeneros.setSelectedIndex(Integer.parseInt(cData[4]) - 1);
		comboEstadosC.setSelectedIndex(Integer.parseInt(cData[5]) - 1);
		
		String fNac = cData[6];
		String [] fechaNac = fNac.split("-");
		String [] dia = fechaNac[2].split(" ");
		txtDia.setText(dia[0]);
		txtMes.setText(fechaNac[1]);
		txtAnio.setText(fechaNac[0]);
		
		txtTel.setText(cData[7]);
		txtCorreo.setText(cData[8]);
		comboCiudades.setSelectedIndex(Integer.parseInt(cData[9]) - 1);
		comboZonas.setSelectedIndex(Integer.parseInt(cData[10]) - 1);
		txtCalle.setText(cData[11]);
		txtNro.setText(cData[12]);
		
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
					
					int ci = Integer.parseInt(txtCi.getText());
					String nombres = txtNombre.getText();
					String paterno = txtPaterno.getText();
					String materno = txtMaterno.getText();
					int genero = Extras.id(comboGeneros.getSelectedItem().toString(), "idGenero", "nombreGenero", "generos");
					int estadoc = Extras.id(comboEstadosC.getSelectedItem().toString(), "idEstadoC", "nombreEstadoC", "estadosCiviles");
					int dia = Integer.parseInt(txtDia.getText());
					int mes = Integer.parseInt(txtMes.getText());
					int anio = Integer.parseInt(txtAnio.getText());
					LocalDate fechaNac = LocalDate.of(anio, mes, dia);
					int tel = Integer.parseInt(txtTel.getText());
					String correo = txtCorreo.getText();
					int ciudad = Extras.id(comboCiudades.getSelectedItem().toString(), "idCiudad", "nombre", "ciudades");
					int zona = Extras.id(comboZonas.getSelectedItem().toString(), "idZona", "nombreZona", "zonas");
					String calle = txtCalle.getText();
					int nro = Integer.parseInt(txtNro.getText());
					
					Conexion c = new Conexion();
		    		con = c.conectar();
					
		    		Integer [] ids = Cliente.ids(idCliente);
	    			String query = "update personas set idPersona = ?, CI = ?, nombre = ?, apPaterno = ?, apMaterno = ?, "
	    					+ "fechaNac = ?, correo = ?, Generos_idGenero = ?, EstadosCiviles_idEstadoC = ?, "
	    					+ "TiposPersonas_idTipoPersona = ? where idpersona = ?";
		    		
		    		PreparedStatement pstmt = con.prepareStatement(query);
		    		
		    		pstmt.setInt(1, ids[0]);
		    		pstmt.setInt(2, ci);
		    		pstmt.setString(3, nombres);
		    		pstmt.setString(4, paterno);
		    		pstmt.setString(5, materno);
		    		pstmt.setDate(6, Date.valueOf(fechaNac));
		    		pstmt.setString(7, correo);
		    		pstmt.setInt(8, genero);
		    		pstmt.setInt(9, estadoc);
		    		pstmt.setInt(10, 1);
		    		pstmt.setInt(11, ids[0]);
		    		
		    		pstmt.executeUpdate();
		    		
		    		query = "update clientes set idCliente = ?, Personas_idPersona = ? where idCliente = ?";

		    		pstmt = con.prepareStatement(query);
		    		
		    		pstmt.setInt(1, idCliente);
		    		pstmt.setInt(2, ids[0]);
		    		pstmt.setInt(3, idCliente);
		    		
		    		pstmt.executeUpdate();
		
		    		query = "update Direcciones set idDireccion = ?, calle = ?, nro = ?, Ciudades_idCiudad = ?, "
		    				+ "Zonas_idZona = ? where idDireccion = ?";
		    		
		    		pstmt = con.prepareStatement(query);
		    		
		    		pstmt.setInt(1, ids[1]);
		    		pstmt.setString(2, calle);
		    		pstmt.setInt(3, nro);
		    		pstmt.setInt(4, ciudad);
		    		pstmt.setInt(5, zona);
		    		pstmt.setInt(6, ids[1]);
		    		
		    		pstmt.executeUpdate();
		    		
		    		query = "update Telefonos set idTelefono = ?, telefono = ? where idTelefono = ?";
		    		
		    		pstmt = con.prepareStatement(query);
		    		
		    		pstmt.setInt(1, ids[2]);
		    		pstmt.setInt(2, tel);
		    		pstmt.setInt(3, ids[2]);
		    		
		    		pstmt.executeUpdate();
		    		
		    		pstmt.close();
		    		
		    		con.close();
		    		
		    		JOptionPane.showMessageDialog(null, "Success!");
					setVisible(false);
		    		
					txtCi.setText("");
					txtNombre.setText("");
					txtPaterno.setText("");
					txtMaterno.setText("");
					comboGeneros.setSelectedIndex(0);
					comboEstadosC.setSelectedIndex(0);
					txtDia.setText("");
					txtMes.setText("");
					txtAnio.setText("");
					txtTel.setText("");
					txtCorreo.setText("");
					comboCiudades.setSelectedIndex(0);
					comboZonas.setSelectedIndex(0);
					txtCalle.setText("");
					txtNro.setText("");

					Ver v = new Ver(Gestionables.clientes, idSucursal);
			    } catch (Exception ee) {
			    	JOptionPane.showMessageDialog(null, ee.getMessage());
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
				Ver v = new Ver(Gestionables.clientes, idSucursal);
			}
		});
		
		setVisible(true);
	}

}
