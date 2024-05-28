import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione una opción:");
        System.out.println("1. Registrar nuevo cliente");
        System.out.println("2. Modificar cliente existente");
        System.out.println("3. Verificar existencia de cliente");
        System.out.println("4. Registrar nuevo empleado");
        System.out.println("5. Modificar empleado existente");
        System.out.println("6. Verificar existencia de empleado");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                registrarNuevoCliente();
                break;
            case 2:
                modificarClienteExistente();
                break;
            case 3:
                verificarExistenciaCliente();
                break;
            case 4:
                registrarNuevoEmpleado();
                break;
            case 5:
                modificarEmpleadoExistente();
                break;
            case 6:
                verificarExistenciaEmpleado();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    public static void registrarNuevoCliente() {
    
    	Cliente cliente = new Cliente(1, 12345678, 123, 123, "Nombre", "Apellido", "Apellido", 1, 1, LocalDate.of(2000, 1, 1), 123456789, 0, 0, 0, "correo@ejemplo.com", "Dirección", "", "Razón Social", 12345678);
    	cliente.registrarPersona();

    }

    public static void modificarClienteExistente() {
    	Cliente cliente = new Cliente(1, 12345678, 123, 123, "Nombre", "Apellido", "Apellido", 1, 1, LocalDate.of(2000, 1, 1), 123456789, 0, 0, 0, "correo@ejemplo.com", "Dirección", "", "Razón Social", 12345678);
		cliente.modificarPersona();
    }

    public static void verificarExistenciaCliente() {
    	Cliente cliente = null;
        cliente.verificarPersona();
    }

    public static void registrarNuevoEmpleado() {
    	
    	Cliente empleado = null;
		empleado.registrarPersona();
    }

    public static void modificarEmpleadoExistente() {
        
        Cliente empleado = null;
		empleado.modificarPersona();
    }

    public static void verificarExistenciaEmpleado() {
    	Cliente empleado = null;
        empleado.verificarPersona();
    }
}
