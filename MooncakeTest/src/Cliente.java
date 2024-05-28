import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Cliente extends Persona{
	private String razonSocial;
	private int nit;
	
	public Cliente(int idPersona, int docIdentidad, int complemento, int expedicion, String nombre, String paterno,
			String materno, int genero, int estadoCivil, LocalDate fechaNac, int celular1, int celular2, int telefono1,
			int telefono2, String correo, String direccion1, String direccion2, String razonSocial, int nit) {
		super(idPersona, docIdentidad, complemento, expedicion, nombre, paterno, materno, genero, estadoCivil, fechaNac,
				celular1, celular2, telefono1, telefono2, correo, direccion1, direccion2);
		this.razonSocial = razonSocial;
		this.nit = nit;
	}
	
	public Cliente(int idPersona, int docIdentidad, String nombre, String paterno, String materno, int genero, int estadoCivil, 
			LocalDate fechaNac, int celular1, int celular2, int telefono1, String correo, String direccion1, String razonSocial, int nit) {
		super(idPersona, docIdentidad, nombre, paterno, materno, genero, estadoCivil, fechaNac,
				celular1, celular2, telefono1, correo, direccion1);
		this.razonSocial = razonSocial;
		this.nit = nit;
	}

	public Cliente(int idPersona, String razonSocial, int nit) {
		super(idPersona);
		this.razonSocial = razonSocial;
		this.nit = nit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public int getNit() {
		return nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}

	@Override
	public String toString() {
	    return super.toString() + ";" + razonSocial + ";" + nit;
	}

	public void registrarPersona() {
		try {
            FileWriter escritor = new FileWriter(Archivos.ClientesTxt, true);
            escritor.write(this.toString() + "\n");
            escritor.close();
            System.out.println("Nuevo cliente registrado en el archivo clientes.txt");
        } catch (IOException e) {
            System.out.println("Error al registrar nuevo cliente: " + e.getMessage());
        }
	}

	public void modificarPersona() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Ingrese el ID de la persona a modificar: ");
	    int idModificar = scanner.nextInt();

	    ArrayList<Cliente> clientes = leerPersonas();
	    for (int i = 0; i < clientes.size(); i++) {
	        Cliente cliente = clientes.get(i);
	        if (cliente.getIdPersona() == idModificar) {
	            System.out.println("Cliente encontrado:");
	            System.out.println(cliente);

	            System.out.print("Nuevo documento de identidad: ");
	            cliente.setDocIdentidad(scanner.nextInt());
	            System.out.print("Nuevo complemento: ");
	            cliente.setComplemento(scanner.nextInt());
	            System.out.print("Nueva expedición: ");
	            cliente.setExpedicion(scanner.nextInt());
	            System.out.print("Nuevo nombre: ");
	            cliente.setNombre(scanner.next());
	            System.out.print("Nuevo apellido paterno: ");
	            cliente.setPaterno(scanner.next());
	            System.out.print("Nuevo apellido materno: ");
	            cliente.setMaterno(scanner.next());
	            System.out.print("Nuevo género: ");
	            cliente.setGenero(scanner.nextInt());
	            System.out.print("Nuevo estado civil: ");
	            cliente.setEstadoCivil(scanner.nextInt());
	            System.out.print("Nueva fecha de nacimiento (YYYY-MM-DD): ");
	            cliente.setFechaNac(LocalDate.parse(scanner.next())); 
	            System.out.print("Nuevo número de celular 1: ");
	            cliente.setCelular1(scanner.nextInt());
	            System.out.print("Nuevo número de celular 2: ");
	            cliente.setCelular2(scanner.nextInt());
	            System.out.print("Nuevo número de teléfono 1: ");
	            cliente.setTelefono1(scanner.nextInt());
	            System.out.print("Nuevo número de teléfono 2: ");
	            cliente.setTelefono2(scanner.nextInt());
	            System.out.print("Nuevo correo electrónico: ");
	            cliente.setCorreo(scanner.next());
	            System.out.print("Nueva dirección 1: ");
	            cliente.setDireccion1(scanner.next());
	            System.out.print("Nueva dirección 2: ");
	            cliente.setDireccion2(scanner.next());
	            System.out.print("Nueva razón social: ");
	            cliente.setRazonSocial(scanner.next());
	            System.out.print("Nuevo NIT: ");
	            cliente.setNit(scanner.nextInt());

	            clientes.set(i, cliente);

	            break;
	        }
	    }

	    try {
	        FileWriter escritor = new FileWriter(Archivos.ClientesTxt);
	        for (Cliente cliente : clientes) {
	            escritor.write(cliente.toString() + "\n");
	        }
	        escritor.close();
	        System.out.println("Clientes actualizados en el archivo clientes.txt");
	    } catch (IOException e) {
	        System.out.println("Error al modificar cliente: " + e.getMessage());
	    }
	}
	
	 public ArrayList<Cliente> leerPersonas() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            BufferedReader lector = new BufferedReader(new FileReader(Archivos.ClientesTxt));
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
                String razonSocial = datos[17];
                int nit = Integer.parseInt(datos[18]);
                clientes.add(new Cliente(idPersona, docIdentidad, complemento, expedicion, nombre, paterno, materno,
                        genero, estadoCivil, fechaNac, celular1, celular2, telefono1, telefono2, correo, direccion1, direccion2, razonSocial, nit));
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer los clientes: " + e.getMessage());
        }
        return clientes;
    }

	@Override
	public Boolean verificarPersona() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Ingrese el ID de la persona a verificar: ");
	    int idVerificar = scanner.nextInt();

	    ArrayList<Cliente> personas = leerPersonas();
	    for (Persona persona : personas) {
	        if (persona.getIdPersona() == idVerificar) {
	            System.out.println("La persona con ID " + idVerificar + " existe.");
	            return true;
	        }
	    }

	    System.out.println("La persona con ID " + idVerificar + " no existe.");
	    return false;
	}
}
