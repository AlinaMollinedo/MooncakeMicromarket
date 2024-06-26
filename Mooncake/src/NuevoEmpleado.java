import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.DateTimeException;
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
	public NuevoEmpleado(int idSucursal, int idEmpleado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Dimensiones.x, Dimensiones.y, Dimensiones.width, Dimensiones.height);
		setResizable(true);
		if(idEmpleado > 0) {
			setTitle("Modificar empleado");
		} else {
			setTitle("Nuevo empleado");
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
		
		if(idEmpleado > 0) {
			lblTitulo.setText("Modificar empleado");
		} else {
			lblTitulo.setText("Nuevo empleado");
		}
		
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
		lblCi.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, Dimensiones.flbl));
		panCi.add(lblCi);
		
		txtCi = new JTextField();
		txtCi.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.ftxt));
		panCi.add(txtCi);
		txtCi.setColumns(10);
		
		txtCi.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				int ultimo = txtCi.getText().length()-1;
				String correcta = txtCi.getText();
				try {
					if(correcta.length() > 0 && correcta.charAt(ultimo) < 48 || correcta.charAt(ultimo) > 57) {
						correcta = correcta.substring(0,ultimo);
					}
					txtCi.setText(correcta);
				}catch(StringIndexOutOfBoundsException ee) {
					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int ultimo = txtCi.getText().length()-1;
				String correcta = txtCi.getText();
				try {
					if(correcta.length() > 0 && correcta.charAt(ultimo) < 48 || correcta.charAt(ultimo) > 57) {
						correcta = correcta.substring(0,ultimo);
					}
					txtCi.setText(correcta);
				}catch(StringIndexOutOfBoundsException ee) {
					
				}
				
			}
		});
		
		JPanel panNombre = new JPanel();
		panNombre.setForeground(new Color(254, 240, 226));
		panNombre.setBackground(new Color(254, 240, 226));
		pan1.add(panNombre);
		panNombre.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre completo:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, Dimensiones.flbl));
		panNombre.add(lblNombre);
		
		JPanel panN = new JPanel();
		panN.setForeground(new Color(254, 240, 226));
		panN.setBackground(new Color(254, 240, 226));
		panNombre.add(panN);
		panN.setLayout(new BoxLayout(panN, BoxLayout.Y_AXIS));
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.ftxt));
		panN.setBorder(new EmptyBorder(5, 5, 5, 5));
		panN.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblN = new JLabel("Nombres");
		lblN.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.flbl));
		lblN.setAlignmentX(Component.CENTER_ALIGNMENT);
		panN.add(lblN);
		
		JPanel panP = new JPanel();
		panP.setForeground(new Color(254, 240, 226));
		panP.setBackground(new Color(254, 240, 226));
		panNombre.add(panP);
		panP.setLayout(new BoxLayout(panP, BoxLayout.Y_AXIS));
		
		txtPaterno = new JTextField();
		txtPaterno.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.ftxt));
		panP.setBorder(new EmptyBorder(5, 5, 5, 5));
		panP.add(txtPaterno);
		txtPaterno.setColumns(10);
		
		JLabel lblP = new JLabel("Ap. paterno");
		lblP.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.flblsub));
		lblP.setAlignmentX(Component.CENTER_ALIGNMENT);
		panP.add(lblP);
		
		JPanel panM = new JPanel();
		panM.setForeground(new Color(254, 240, 226));
		panM.setBackground(new Color(254, 240, 226));
		panNombre.add(panM);
		panM.setLayout(new BoxLayout(panM, BoxLayout.Y_AXIS));
		
		txtMaterno = new JTextField();
		txtMaterno.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.flblsub));
		panM.setBorder(new EmptyBorder(5, 5, 5, 5));
		panM.add(txtMaterno);
		txtMaterno.setColumns(10);
		
		JLabel lblM = new JLabel("Ap. materno");
		lblM.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.flblsub));
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
		lblGenero.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, Dimensiones.flbl));
		panGenero.add(lblGenero);
		
		JComboBox<String> comboGeneros = new JComboBox<String>(Extras.nombres("nombreGenero", "generos", "idgenero"));
		comboGeneros.setBackground(new Color(232, 252, 255));
		comboGeneros.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.fcombo));
		panGenero.add(comboGeneros);
		
		JPanel panEstadoC = new JPanel();
		panEstadoC.setBackground(new Color(254, 240, 226));
		pan2.add(panEstadoC);
		
		JLabel lblEstadoC = new JLabel("Estado Civil:");
		lblEstadoC.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, Dimensiones.flbl));
		panEstadoC.add(lblEstadoC);
		
		JComboBox<String> comboEstadosC = new JComboBox<String>(Extras.nombres("nombreEstadoC", "estadosCiviles", "idestadoc"));
		comboEstadosC.setBackground(new Color(232, 252, 255));
		comboEstadosC.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.fcombo));
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
		lblFechaNac.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, Dimensiones.flbl));
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
		txtDia.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.ftxt));
		panDia.add(txtDia);
		txtDia.setColumns(5);
		
		txtDia.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				int ultimo = txtDia.getText().length()-1;
				String correcta = txtDia.getText();
				try {
					if(correcta.length() > 0 && correcta.charAt(ultimo) < 48 || correcta.charAt(ultimo) > 57) {
						correcta = correcta.substring(0,ultimo);
					}
					txtDia.setText(correcta);
				}catch(StringIndexOutOfBoundsException ee) {
					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int ultimo = txtDia.getText().length()-1;
				String correcta = txtDia.getText();
				try {
					if(correcta.length() > 0 && correcta.charAt(ultimo) < 48 || correcta.charAt(ultimo) > 57) {
						correcta = correcta.substring(0,ultimo);
					}
					txtDia.setText(correcta);
				}catch(StringIndexOutOfBoundsException ee) {
					
				}
				
			}
		});
		
		JLabel lblDia = new JLabel("Día");
		lblDia.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.flblsub));
		lblDia.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDia.setHorizontalAlignment(SwingConstants.CENTER);
		panDia.add(lblDia);
		
		JPanel panMes = new JPanel();
		panMes.setBackground(new Color(254, 240, 226));
		panMes.setBorder(new EmptyBorder(5, 5, 5, 5));
		panFecha.add(panMes);
		panMes.setLayout(new BoxLayout(panMes, BoxLayout.Y_AXIS));
		
		txtMes = new JTextField();
		txtMes.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.ftxt));
		panMes.add(txtMes);
		txtMes.setColumns(5);
		
		txtMes.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				int ultimo = txtMes.getText().length()-1;
				String correcta = txtMes.getText();
				try {
					if(correcta.length() > 0 && correcta.charAt(ultimo) < 48 || correcta.charAt(ultimo) > 57) {
						correcta = correcta.substring(0,ultimo);
					}
					txtMes.setText(correcta);
				}catch(StringIndexOutOfBoundsException ee) {
					
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int ultimo = txtMes.getText().length()-1;
				String correcta = txtMes.getText();
				try {
					if(correcta.length() > 0 && correcta.charAt(ultimo) < 48 || correcta.charAt(ultimo) > 57) {
						correcta = correcta.substring(0,ultimo);
					}
					txtMes.setText(correcta);
				}catch(StringIndexOutOfBoundsException ee) {
					
				}
				
				
			}
		});
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.flblsub));
		lblMes.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		panMes.add(lblMes);
		
		JPanel panAnio = new JPanel();
		panAnio.setBackground(new Color(254, 240, 226));
		panAnio.setBorder(new EmptyBorder(5, 5, 5, 5));
		panFecha.add(panAnio);
		panAnio.setLayout(new BoxLayout(panAnio, BoxLayout.Y_AXIS));
		
		txtAnio = new JTextField();
		txtAnio.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.ftxt));
		panAnio.add(txtAnio);
		txtAnio.setColumns(5);
		
		txtAnio.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				int ultimo = txtAnio.getText().length()-1;
				String correcta = txtAnio.getText();
				try {
					if(correcta.length() > 0 && correcta.charAt(ultimo) < 48 || correcta.charAt(ultimo) > 57) {
						correcta = correcta.substring(0,ultimo);
					}
					txtAnio.setText(correcta);
				}catch(StringIndexOutOfBoundsException ee) {
					
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int ultimo = txtAnio.getText().length()-1;
				String correcta = txtAnio.getText();
				try {
					if(correcta.length() > 0 && correcta.charAt(ultimo) < 48 || correcta.charAt(ultimo) > 57) {
						correcta = correcta.substring(0,ultimo);
					}
					txtAnio.setText(correcta);
				}catch(StringIndexOutOfBoundsException ee) {
					
				}
				
			}
		});
		
		JLabel lblAnio = new JLabel("Año");
		lblAnio.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.flblsub));
		lblAnio.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAnio.setHorizontalAlignment(SwingConstants.CENTER);
		panAnio.add(lblAnio);
		
		JPanel pan3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pan3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pan3.setBackground(new Color(254, 240, 226));
		panFormulario.add(pan3);
		
		JLabel lblTel = new JLabel("Teléfono:");
		lblTel.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, Dimensiones.flbl));
		pan3.add(lblTel);
		
		txtTel = new JTextField();
		txtTel.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.ftxt));
		pan3.add(txtTel);
		txtTel.setColumns(9);
		
		txtTel.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				int ultimo = txtTel.getText().length()-1;
				String correcta = txtTel.getText();
				try {
					if(correcta.length() > 0 && correcta.charAt(ultimo) < 48 || correcta.charAt(ultimo) > 57) {
						correcta = correcta.substring(0,ultimo);
					}
					txtTel.setText(correcta);
				}catch(StringIndexOutOfBoundsException ee) {
					
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int ultimo = txtTel.getText().length()-1;
				String correcta = txtTel.getText();
				try {
					if(correcta.length() > 0 && correcta.charAt(ultimo) < 48 || correcta.charAt(ultimo) > 57) {
						correcta = correcta.substring(0,ultimo);
					}
					txtTel.setText(correcta);
				}catch(StringIndexOutOfBoundsException ee) {
					
				}
				
			}
		});
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, Dimensiones.flbl));
		pan3.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.ftxt));
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
		lblCiudad.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, Dimensiones.flbl));
		pan11.add(lblCiudad);
		
		JComboBox<String> comboCiudades = new JComboBox<String>(Extras.nombres("nombre", "ciudades", "idciudad"));
		comboCiudades.setBackground(new Color(232, 252, 255));
		comboCiudades.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.fcombo));
		pan11.add(comboCiudades);
		
		JPanel pan12 = new JPanel();
		pan12.setBackground(new Color(254, 240, 226));
		FlowLayout flowLayout_5 = (FlowLayout) pan12.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panDir.add(pan12);
		
		JLabel lblZona = new JLabel("Zona:");
		lblZona.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, Dimensiones.flbl));
		pan12.add(lblZona);
		
		JComboBox<String> comboZonas = new JComboBox<String>(Extras.nombres("nombreZona", "zonas", "idzona"));
		comboZonas.setBackground(new Color(232, 252, 255));
		comboZonas.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.fcombo));
		pan12.add(comboZonas);
		
		JPanel pan21 = new JPanel();
		pan21.setBackground(new Color(254, 240, 226));
		FlowLayout flowLayout_6 = (FlowLayout) pan21.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panDir.add(pan21);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, Dimensiones.flbl));
		pan21.add(lblCalle);
		
		txtCalle = new JTextField();
		txtCalle.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.ftxt));
		pan21.add(txtCalle);
		txtCalle.setColumns(10);
		
		JPanel pan22 = new JPanel();
		pan22.setBackground(new Color(254, 240, 226));
		FlowLayout flowLayout_7 = (FlowLayout) pan22.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		panDir.add(pan22);
		
		JLabel lblNro = new JLabel("Número:");
		lblNro.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, Dimensiones.flbl));
		pan22.add(lblNro);
		
		txtNro = new JTextField();
		txtNro.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.ftxt));
		pan22.add(txtNro);
		txtNro.setColumns(4);
		
		txtNro.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				int ultimo = txtNro.getText().length()-1;
				String correcta = txtNro.getText();
				try {
					if(correcta.length() > 0 && correcta.charAt(ultimo) < 48 || correcta.charAt(ultimo) > 57) {
						correcta = correcta.substring(0,ultimo);
					}
					txtNro.setText(correcta);
				}catch(StringIndexOutOfBoundsException ee) {
					
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int ultimo = txtNro.getText().length()-1;
				String correcta = txtNro.getText();
				try {
					if(correcta.length() > 0 && correcta.charAt(ultimo) < 48 || correcta.charAt(ultimo) > 57) {
						correcta = correcta.substring(0,ultimo);
					}
					txtNro.setText(correcta);
				}catch(StringIndexOutOfBoundsException ee) {
					
				}
				
			}
		});
		
		JPanel pan4 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pan4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		pan4.setBackground(new Color(254, 240, 226));
		panFormulario.add(pan4);
		
		JLabel lblSucursal = new JLabel("Sucursal:");
		lblSucursal.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, Dimensiones.flbl));
		pan4.add(lblSucursal);
		
		JComboBox<String> comboSucursal = new JComboBox<String>(Sucursal.nombres());
		comboSucursal.setBackground(new Color(232, 252, 255));
		comboSucursal.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.fcombo));
		pan4.add(comboSucursal);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, Dimensiones.flbl));
		pan4.add(lblCargo);
		
		JComboBox<String> comboCargo = new JComboBox<String>(Extras.nombres("nombreCargo", "cargos", "idcargo"));
		comboCargo.setBackground(new Color(232, 252, 255));
		comboCargo.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.fcombo));
		pan4.add(comboCargo);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, Dimensiones.flbl));
		pan4.add(lblEstado);
		
		JComboBox<String> comboEstado = new JComboBox<String>(Extras.nombres("nombre", "tipoestado", "idtipo"));
		comboEstado.setBackground(new Color(232, 252, 255));
		comboEstado.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.fcombo));
		pan4.add(comboEstado);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, Dimensiones.flbl));
		pan4.add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.ftbl));
		pan4.add(txtSalario);
		txtSalario.setColumns(6);
		
		txtSalario.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				int ultimo = txtSalario.getText().length()-1;
				String correcta = txtSalario.getText();
				try {
					if(correcta.length() > 0 && correcta.charAt(ultimo) < 48 || correcta.charAt(ultimo) > 57) {
						correcta = correcta.substring(0,ultimo);
					}
					txtSalario.setText(correcta);
				}catch(StringIndexOutOfBoundsException ee) {
					
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int ultimo = txtSalario.getText().length()-1;
				String correcta = txtSalario.getText();
				try {
					if(correcta.length() > 0 && correcta.charAt(ultimo) < 48 || correcta.charAt(ultimo) > 57) {
						correcta = correcta.substring(0,ultimo);
					}
					txtSalario.setText(correcta);
				}catch(StringIndexOutOfBoundsException ee) {
					
				}
			}
		});
		
		JLabel lblTurno = new JLabel("Turno:");
		lblTurno.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, Dimensiones.flbl));
		pan4.add(lblTurno);
		
		JComboBox<String> comboTurno = new JComboBox<String>(Extras.nombres("nombreTurno", "turnos", "idturno"));
		comboTurno.setFont(new Font("Verdana", Font.PLAIN, Dimensiones.fcombo));
		comboTurno.setBackground(new Color(232, 252, 255));
		pan4.add(comboTurno);
		
		if(idEmpleado > 0) {
			String [] eData = Empleado.getData(idEmpleado);
			txtCi.setText(eData[0]);
			txtNombre.setText(eData[1]);
			txtPaterno.setText(eData[2]);
			txtMaterno.setText(eData[3]);
			comboGeneros.setSelectedIndex(Integer.parseInt(eData[4]) - 1);
			comboEstadosC.setSelectedIndex(Integer.parseInt(eData[5]) - 1);
			
			String fNac = eData[6];
			String [] fechaNac = fNac.split("-");
			String [] dia = fechaNac[2].split(" ");
			txtDia.setText(dia[0]);
			txtMes.setText(fechaNac[1]);
			txtAnio.setText(fechaNac[0]);
			
			txtTel.setText(eData[7]);
			txtCorreo.setText(eData[8]);
			comboCiudades.setSelectedIndex(Integer.parseInt(eData[9]) - 1);
			comboZonas.setSelectedIndex(Integer.parseInt(eData[10]) - 1);
			txtCalle.setText(eData[11]);
			txtNro.setText(eData[12]);
			comboSucursal.setSelectedIndex(Empleado.sucursal(idEmpleado) - 1);
			comboCargo.setSelectedIndex(Integer.parseInt(eData[13]) - 1);
			comboEstado.setSelectedIndex(Integer.parseInt(eData[14]) - 1);
			txtSalario.setText(eData[15]);
			comboTurno.setSelectedIndex(Integer.parseInt(eData[16]) - 1);
			
			if(idSucursal > 0) {
				comboSucursal.setEnabled(false);
			}
		}
		
		if(idSucursal > 0 && idEmpleado == 0) {
			comboSucursal.setSelectedIndex(idSucursal - 1);
			comboSucursal.setEnabled(false);
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
					int sucursal = Sucursal.id(comboSucursal.getSelectedItem().toString());
					int cargo = Extras.id(comboCargo.getSelectedItem().toString(), "idCargo", "nombreCargo", "cargos");
					int estado = Extras.id(comboEstado.getSelectedItem().toString(), "idTipo", "nombre", "tipoEstado");
					int salario = Integer.parseInt(txtSalario.getText()); 
					int turno = Extras.id(comboTurno.getSelectedItem().toString(), "idTurno", "nombreTurno", "turnos");
					
					if(estado == 3) {
						int op = JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere despedir al empleado?");
						if(op != 0) {
							return;
						}
					}
					
					Conexion c = new Conexion();
		    		con = c.conectar();
					
		    		if(idEmpleado > 0) {
		    			Integer [] ids = Empleado.ids(idEmpleado);
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
			    		pstmt.setInt(10, 2);
			    		pstmt.setInt(11, ids[0]);
			    		
			    		pstmt.executeUpdate();
			    		
			    		query = "update estados set idEstado = ?, fechaFin = ?, tipoEstado_idTipo = ? where idEstado = ?";

			    		pstmt = con.prepareStatement(query);
			    		
			    		pstmt.setInt(1, ids[1]);
			    		pstmt.setDate(2, Date.valueOf(LocalDate.now()));
			    		pstmt.setInt(3, estado);
			    		pstmt.setInt(4, ids[1]);
			    		
			    		pstmt.executeUpdate();
			    		
			    		query = "update empleados set idEmpleado = ?, salario = ?, Personas_idPersona = ?, Estados_idEstado = ?, "
			    				+ "Cargos_idCargo = ?, Turnos_idTurno = ? where idEmpleado = ?";
			    		
			    		pstmt = con.prepareStatement(query);
			    		
			    		pstmt.setInt(1, idEmpleado);
			    		pstmt.setInt(2, salario);
			    		pstmt.setInt(3, ids[0]);
			    		pstmt.setInt(4, ids[1]);
			    		pstmt.setInt(5, cargo);
			    		pstmt.setInt(6, turno);
			    		pstmt.setInt(7, idEmpleado);
			    		
			    		pstmt.executeUpdate();
			    		
			    		query = "update Direcciones set idDireccion = ?, calle = ?, nro = ?, Ciudades_idCiudad = ?, "
			    				+ "Zonas_idZona = ? where idDireccion = ?";
			    		
			    		pstmt = con.prepareStatement(query);
			    		
			    		pstmt.setInt(1, ids[2]);
			    		pstmt.setString(2, calle);
			    		pstmt.setInt(3, nro);
			    		pstmt.setInt(4, ciudad);
			    		pstmt.setInt(5, zona);
			    		pstmt.setInt(6, ids[2]);
			    		
			    		pstmt.executeUpdate();
			    		
			    		query = "update Telefonos set idTelefono = ?, telefono = ? where idTelefono = ?";
			    		
			    		pstmt = con.prepareStatement(query);
			    		
			    		pstmt.setInt(1, ids[3]);
			    		pstmt.setInt(2, tel);
			    		pstmt.setInt(3, ids[3]);
			    		
			    		pstmt.executeUpdate();
			    		
			    		query = "update SucursalesEmpleados set Empleados_idEmpleado = ?, Sucursales_idSucursal = ? "
			    				+ "where Empleados_idEmpleado = ?";
			    		
			    		pstmt = con.prepareStatement(query);
			    		
			    		pstmt.setInt(1, idEmpleado);
			    		pstmt.setInt(2, sucursal);
			    		pstmt.setInt(3, idEmpleado);
			    		
			    		pstmt.executeUpdate();
			    		
			    		pstmt.close();
			    		
			    		con.close();
			    		
			    		JOptionPane.showMessageDialog(null, "Success!");
			    		Ver v = new Ver(Gestionables.empleados, idSucursal, false);
						setVisible(false);
						
		    		} else {
		    			int idP = Persona.maxId() + 1;
		    			int idE = Empleado.maxId() + 1;
		    			int idEs = Extras.maxId("idEstado", "estados") + 1;
		    			int idDir = Extras.maxId("idDireccion", "direcciones") + 1;
		    			int idTel = Extras.maxId("idTelefono", "telefonos") + 1;
		    			
		    			String query = "insert into personas "
			    				+ "(idPersona, CI, nombre, apPaterno, apMaterno, fechaNac, correo, Generos_idGenero, EstadosCiviles_idEstadoC, TiposPersonas_idTipoPersona) "
			    				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			    		
			    		PreparedStatement pstmt = con.prepareStatement(query);
			    		
			    		pstmt.setInt(1, idP);
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
			    		
			    		query = "insert into estados (idEstado, fechaInicio, fechaFin, tipoEstado_idTipo) values (?, ?, ?, ?)";
			    		
			    		pstmt = con.prepareStatement(query);
			    		
			    		pstmt.setInt(1, idEs);
			    		pstmt.setDate(2, Date.valueOf(LocalDate.now()));
			    		pstmt.setDate(3, Date.valueOf(LocalDate.of(1, 1, 1)));
			    		pstmt.setInt(4, estado);
			    		
			    		pstmt.executeUpdate();
			    		
			    		query = "insert into empleados (idEmpleado, salario, Personas_idPersona, Estados_idEstado, Cargos_idCargo, Turnos_idTurno) "
			    				+ "values (?, ?, ?, ?, ?, ?)";
			    		
			    		pstmt = con.prepareStatement(query);
			    		
			    		pstmt.setInt(1, idE);
			    		pstmt.setInt(2, salario);
			    		pstmt.setInt(3, idP);
			    		pstmt.setInt(4, idEs);
			    		pstmt.setInt(5, cargo);
			    		pstmt.setInt(6, turno);
			    		
			    		pstmt.executeUpdate();
			    		
			    		query = "insert into Direcciones (idDireccion, calle, nro, Ciudades_idCiudad, Zonas_idZona) "
			    				+ "values (?, ?, ?, ?, ?)";
			    		
			    		pstmt = con.prepareStatement(query);
			    		
			    		pstmt.setInt(1, idDir);
			    		pstmt.setString(2, calle);
			    		pstmt.setInt(3, nro);
			    		pstmt.setInt(4, ciudad);
			    		pstmt.setInt(5, zona);
			    		
			    		pstmt.executeUpdate();
			    		
			    		query = "insert into DireccionesPersonas (Direcciones_idDireccion, Personas_idPersona) "
			    				+ "values (?, ?)";
			    		
			    		pstmt = con.prepareStatement(query);
			    		
			    		pstmt.setInt(1, idDir);
			    		pstmt.setInt(2, idP);
			    		
			    		pstmt.executeUpdate();
			    		
			    		query = "insert into Telefonos (idTelefono, telefono) values (?, ?)";
			    		
			    		pstmt = con.prepareStatement(query);
			    		
			    		pstmt.setInt(1, idTel);
			    		pstmt.setInt(2, tel);
			    		
			    		pstmt.executeUpdate();
			    		
			    		query = "insert into TelefonosPersonas (Personas_idPersona, Telefonos_id_telefono) "
			    				+ "values (?, ?)";
			    		
			    		pstmt = con.prepareStatement(query);
			    		
			    		pstmt.setInt(1, idP);
			    		pstmt.setInt(2, idTel);
			    		
			    		pstmt.executeUpdate();
			    		
			    		query = "insert into SucursalesEmpleados (Empleados_idEmpleado, Sucursales_idSucursal) "
			    				+ "values (?, ?)";
			    		
			    		pstmt = con.prepareStatement(query);
			    		
			    		pstmt.setInt(1, idE);
			    		pstmt.setInt(2, sucursal);
			    		
			    		pstmt.executeUpdate();			    
			    		
			    		pstmt.close();
			    		
			    		con.close();
			    		
			    		JOptionPane.showMessageDialog(null, "Success!");
						EstablecerUsuario eu = new EstablecerUsuario(false, idE, idSucursal);
						setVisible(false);
		    		}
		    		
		    		
		    		
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
					comboSucursal.setSelectedIndex(0);
					comboCargo.setSelectedIndex(0);
					comboEstado.setSelectedIndex(0);
					txtSalario.setText("");
					comboTurno.setSelectedIndex(0);
					
			    } catch (SQLException ee) {
			    	JOptionPane.showMessageDialog(null, ee.getMessage());
			    } catch (DateTimeException ee) {
			    	JOptionPane.showMessageDialog(null, ee.getMessage());
			    }catch (NumberFormatException ee) {
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
				Ver v = new Ver(Gestionables.empleados, idSucursal, false);
			}
		});
		
		contentPane.getRootPane().setDefaultButton(btnAceptar);
		
		setVisible(true);
	}

}
