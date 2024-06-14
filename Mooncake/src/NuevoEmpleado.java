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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class NuevoEmpleado extends JFrame {

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

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoEmpleado frame = new NuevoEmpleado();
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
	public NuevoEmpleado(int idSucursal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Dimensiones.x, Dimensiones.y, Dimensiones.width, Dimensiones.height);
		setResizable(false);
		setTitle("Nuevo empleado");
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
		
		JLabel lblTitulo = new JLabel("Nuevo empleado");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(0, 0, 64));
		lblTitulo.setFont(new Font("UD Digi Kyokasho N-R", Font.BOLD, 21));
		panTitulo.add(lblTitulo);
		
		JPanel panFormulario = new JPanel();
		panFormulario.setForeground(new Color(254, 240, 226));
		panFormulario.setBackground(new Color(254, 240, 226));
		contentPane.add(panFormulario, BorderLayout.CENTER);
		panFormulario.setLayout(new GridLayout(4, 1, 5, 5));
		
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
		
		JComboBox<String> comboGeneros = new JComboBox<String>(Extras.generosNombres());
		comboGeneros.setBackground(new Color(232, 252, 255));
		comboGeneros.setFont(new Font("Verdana", Font.PLAIN, 9));
		panGenero.add(comboGeneros);
		
		JPanel panEstadoC = new JPanel();
		panEstadoC.setBackground(new Color(254, 240, 226));
		pan2.add(panEstadoC);
		
		JLabel lblEstadoC = new JLabel("Estado Civil:");
		lblEstadoC.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		panEstadoC.add(lblEstadoC);
		
		JComboBox<String> comboEstadosC = new JComboBox<String>(Extras.estadosCivilesNombres());
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
		
		JLabel lblCorreo = new JLabel("Correo electrónico:");
		lblCorreo.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		pan3.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Verdana", Font.PLAIN, 10));
		pan3.add(txtCorreo);
		txtCorreo.setColumns(20);
		
		JLabel lblDir = new JLabel("Dirección:");
		lblDir.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		pan3.add(lblDir);
		
		JTextArea txaDir = new JTextArea();
		txaDir.setFont(new Font("Verdana", Font.PLAIN, 10));
		txaDir.setRows(2);
		txaDir.setColumns(22);
		pan3.add(txaDir);
		
		JPanel pan4 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pan4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		pan4.setBackground(new Color(254, 240, 226));
		panFormulario.add(pan4);
		
		JLabel lblSucursal = new JLabel("Sucursal:");
		lblSucursal.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		pan4.add(lblSucursal);
		
		JComboBox<String> comboSucursal = new JComboBox<String>(Sucursal.nombres());
		comboSucursal.setBackground(new Color(232, 252, 255));
		comboSucursal.setFont(new Font("Verdana", Font.PLAIN, 9));
		pan4.add(comboSucursal);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		pan4.add(lblCargo);
		
		JComboBox<String> comboCargo = new JComboBox<String>(Extras.cargosNombres());
		comboCargo.setBackground(new Color(232, 252, 255));
		comboCargo.setFont(new Font("Verdana", Font.PLAIN, 9));
		pan4.add(comboCargo);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		pan4.add(lblEstado);
		
		JComboBox<String> comboEstado = new JComboBox<String>(Extras.estadosNombres());
		comboEstado.setBackground(new Color(232, 252, 255));
		comboEstado.setFont(new Font("Verdana", Font.PLAIN, 9));
		pan4.add(comboEstado);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		pan4.add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setFont(new Font("Verdana", Font.PLAIN, 10));
		pan4.add(txtSalario);
		txtSalario.setColumns(6);
		
		JLabel lblTurno = new JLabel("Turno:");
		lblTurno.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 10));
		pan4.add(lblTurno);
		
		JComboBox<String> comboTurno = new JComboBox<String>(Extras.turnosNombres());
		comboTurno.setFont(new Font("Verdana", Font.PLAIN, 9));
		comboTurno.setBackground(new Color(232, 252, 255));
		pan4.add(comboTurno);
		
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
					int genero = Extras.generosId(comboGeneros.getSelectedItem().toString());
					int estadoc = Extras.estadosCivilesId(comboEstadosC.getSelectedItem().toString());
					int dia = Integer.parseInt(txtDia.getText());
					int mes = Integer.parseInt(txtMes.getText());
					int anio = Integer.parseInt(txtAnio.getText());
					LocalDate fechaNac = LocalDate.of(anio, mes, dia);
					String tel = txtTel.getText();
					String correo = txtCorreo.getText();
					String dir = txaDir.getText();
					int sucursal = Sucursal.id(comboSucursal.getSelectedItem().toString());
					int cargo = Extras.cargosId(comboCargo.getSelectedItem().toString());
					int estado = Extras.estadosId(comboEstado.getSelectedItem().toString());
					int salario = Integer.parseInt(txtSalario.getText()); 
					int turno = Extras.turnoId(comboTurno.getSelectedItem().toString());
					
					Conexion c = new Conexion();
		    		con = c.conectar();
					
		    		String query = "insert into personas "
		    				+ "(idPersona, CI, nombre, apPaterno, apMaterno, fechaNac, correo, Generos_idGenero, EstadosCiviles_idEstadoC, TiposPersonas_idTipoPersona) "
		    				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    		
		    		PreparedStatement pstmt = con.prepareStatement(query);
		    		
		    		pstmt.setInt(1, 2000);
		    		pstmt.setInt(2, ci);
		    		pstmt.setString(3, nombres);
		    		pstmt.setString(4, paterno);
		    		pstmt.setString(5, materno);
		    		pstmt.setDate(6, Date.valueOf(fechaNac));
		    		pstmt.setString(7, correo);
		    		pstmt.setInt(8, genero);
		    		pstmt.setInt(9, estadoc);
		    		pstmt.setInt(10, 2);
		    		
		    		pstmt.executeUpdate();
		    		
		    		query = "insert into empleados (idEmpleado, salario, Personas_idPersona, Estados_idEstado, Cargos_idCargo, Turnos_idTurno) "
		    				+ "values (?, ?, ?, ?, ?, ?)";
		    		
		    		pstmt = con.prepareStatement(query);
		    		
		    		pstmt.setInt(1, 21);
		    		pstmt.setInt(2, salario);
		    		pstmt.setInt(3, 2000);
		    		pstmt.setInt(4, estado);
		    		pstmt.setInt(5, cargo);
		    		pstmt.setInt(6, turno);
		    		
		    		pstmt.executeUpdate();		    		
		    		
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
					txaDir.setText("");
					comboSucursal.setSelectedIndex(0);
					comboCargo.setSelectedIndex(0);
					comboEstado.setSelectedIndex(0);
					txtSalario.setText("");
					comboTurno.setSelectedIndex(0);
					
			    } catch (SQLException ee) {
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
			}
		});
		
		setVisible(true);
	}

}
