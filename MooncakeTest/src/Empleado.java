import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class Empleado extends Persona{
	private int turno;
	private LocalDate fechaIngreso;
	private int salarioHora;
	private int posicion;
	private int idSupervisor;
	private String usuario;
	private String contrasena;
	
	public Empleado(int idPersona, int docIdentidad, int complemento, int expedicion, String nombre, String paterno,
			String materno, int genero, int estadoCivil, LocalDate fechaNac, int celular1, int celular2, int telefono1,
			int telefono2, String correo, String direccion1, String direccion2, int turno, LocalDate fechaIngreso,
			int salarioHora, int posicion, int idSupervisor) {
		super(idPersona, docIdentidad, complemento, expedicion, nombre, paterno, materno, genero, estadoCivil, fechaNac,
				celular1, celular2, telefono1, telefono2, correo, direccion1, direccion2);
		this.turno = turno;
		this.fechaIngreso = fechaIngreso;
		this.salarioHora = salarioHora;
		this.posicion = posicion;
		this.idSupervisor = idSupervisor;
		this.usuario = new String();
		this.contrasena = new String();
	}
	
	public Empleado(int idPersona, int docIdentidad, int complemento, int expedicion, String nombre, String paterno,
			String materno, int genero, int estadoCivil, LocalDate fechaNac, int celular1, int celular2, int telefono1,
			int telefono2, String correo, String direccion1, String direccion2, int turno, LocalDate fechaIngreso,
			int salarioHora, int posicion) {
		super(idPersona, docIdentidad, complemento, expedicion, nombre, paterno, materno, genero, estadoCivil, fechaNac,
				celular1, celular2, telefono1, telefono2, correo, direccion1, direccion2);
		this.turno = turno;
		this.fechaIngreso = fechaIngreso;
		this.salarioHora = salarioHora;
		this.posicion = posicion;
		this.idSupervisor = 0;
		this.usuario = new String();
		this.contrasena = new String();
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getSalarioHora() {
		return salarioHora;
	}

	public void setSalarioHora(int salarioHora) {
		this.salarioHora = salarioHora;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getIdSupervisor() {
		return idSupervisor;
	}

	public void setIdSupervisor(int idSupervisor) {
		this.idSupervisor = idSupervisor;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
	    return super.toString() + ";" + turno + ";" + fechaIngreso + ";" + salarioHora + ";" + posicion + ";" + idSupervisor;
	}

	public void establecerAcceso(String usuario, String contrasena) {
	    this.usuario = usuario;
	    this.contrasena = contrasena;
	}


	@Override
	public void registrarPersona() {
        try {
            FileWriter escritor = new FileWriter(Archivos.EmpleadosTxt, true);
            escritor.write(this.toString() + "\n");
            escritor.close();
            System.out.println("Nuevo empleado registrado en el archivo empleados.txt");
        } catch (IOException e) {
            System.out.println("Error al registrar nuevo empleado: " + e.getMessage());
        }
    }

	@Override
	public void modificarPersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del empleado a modificar: ");
        int idModificar = scanner.nextInt();

        ArrayList<Empleado> empleados = leerPersonas();
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            if (empleado.getIdPersona() == idModificar) {
                System.out.println("Empleado encontrado:");
                System.out.println(empleado);

                System.out.print("Nuevo documento de identidad: ");
                this.setDocIdentidad(scanner.nextInt());
                System.out.print("Nuevo complemento: ");
                this.setComplemento(scanner.nextInt());
                System.out.print("Nueva expedición: ");
                this.setExpedicion(scanner.nextInt());
                System.out.print("Nuevo nombre: ");
                this.setNombre(scanner.next());
                System.out.print("Nuevo apellido paterno: ");
                this.setPaterno(scanner.next());
                System.out.print("Nuevo apellido materno: ");
                this.setMaterno(scanner.next());
                System.out.print("Nuevo género: ");
                this.setGenero(scanner.nextInt());
                System.out.print("Nuevo estado civil: ");
                this.setEstadoCivil(scanner.nextInt());
                System.out.print("Nueva fecha de nacimiento (YYYY-MM-DD): ");
                this.setFechaNac(LocalDate.parse(scanner.next())); 
                System.out.print("Nuevo número de celular 1: ");
                this.setCelular1(scanner.nextInt());
                System.out.print("Nuevo número de celular 2: ");
                this.setCelular2(scanner.nextInt());
                System.out.print("Nuevo número de teléfono 1: ");
                this.setTelefono1(scanner.nextInt());
                System.out.print("Nuevo número de teléfono 2: ");
                this.setTelefono2(scanner.nextInt());
                System.out.print("Nuevo correo electrónico: ");
                this.setCorreo(scanner.next());
                System.out.print("Nueva dirección 1: ");
                this.setDireccion1(scanner.next());
                System.out.print("Nueva dirección 2: ");
                this.setDireccion2(scanner.next());
                System.out.print("Nuevo turno: ");
                this.setTurno(scanner.nextInt());
                System.out.print("Nueva fecha de ingreso (YYYY-MM-DD): ");
                this.setFechaIngreso(LocalDate.parse(scanner.next())); 
                System.out.print("Nuevo salario por hora: ");
                this.setSalarioHora(scanner.nextInt());
                System.out.print("Nueva posición: ");
                this.setPosicion(scanner.nextInt());
                System.out.print("Nuevo ID de supervisor: ");
                this.setIdSupervisor(scanner.nextInt());
                System.out.println("Empleado modificado.");

                break;
            }
        }

        try {
            FileWriter escritor = new FileWriter(Archivos.EmpleadosTxt);
            for (Empleado empleado : empleados) {
                escritor.write(empleado.toString() + "\n");
            }
            escritor.close();
            System.out.println("Empleados actualizados en el archivo empleados.txt");
        } catch (IOException e) {
            System.out.println("Error al modificar empleado: " + e.getMessage());
        }
    }

	@Override
	public ArrayList<Empleado> leerPersonas() {
	    ArrayList<Empleado> empleados = new ArrayList<>();
	    try {
	        BufferedReader lector = new BufferedReader(new FileReader(Archivos.EmpleadosTxt));
	        String linea;
	        while ((linea = lector.readLine()) != null) {
	            String[] datos = linea.split(";");
	            int idPersona = Integer.parseInt(datos[0]);
	            int docIdentidad = Integer.parseInt(datos[1]);
	            int complemento = Integer.parseInt(datos[2]);
	            int expedicion = Integer.parseInt(datos[3]);
	            String nombre = datos[4];
	            String paterno = datos[5];
	            String materno = datos[6];
	            int genero = Integer.parseInt(datos[7]);
	            int estadoCivil = Integer.parseInt(datos[8]);
	            LocalDate fechaNac = LocalDate.parse(datos[9]); 
	            int celular1 = Integer.parseInt(datos[10]);
	            int celular2 = Integer.parseInt(datos[11]);
	            int telefono1 = Integer.parseInt(datos[12]);
	            int telefono2 = Integer.parseInt(datos[13]);
	            String correo = datos[14];
	            String direccion1 = datos[15];
	            String direccion2 = datos[16];
	            int turno = Integer.parseInt(datos[17]);
	            LocalDate fechaIngreso = LocalDate.parse(datos[18]); 
	            int salarioHora = Integer.parseInt(datos[19]);
	            int posicion = Integer.parseInt(datos[20]);
	            int idSupervisor = Integer.parseInt(datos[21]);

	            empleados.add(new Empleado(idPersona, docIdentidad, complemento, expedicion, nombre, paterno, materno,
	                    genero, estadoCivil, fechaNac, celular1, celular2, telefono1, telefono2, correo, direccion1, direccion2,
	                    turno, fechaIngreso, salarioHora, posicion, idSupervisor));
	        }
	        lector.close();
	    } catch (IOException e) {
	        System.out.println("Error al leer los empleados: " + e.getMessage());
	    }
	    return empleados;
	}


	@Override
	public Boolean verificarPersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del empleado a verificar: ");
        int idVerificar = scanner.nextInt();

        ArrayList<Empleado> empleados = leerPersonas();
        for (Empleado empleado : empleados) {
            if (empleado.getIdPersona() == idVerificar) {
                System.out.println("El empleado con ID " + idVerificar + " existe.");
                return true;
            }
        }

        System.out.println("El empleado con ID " + idVerificar + " no existe.");
        return false;
    }
}