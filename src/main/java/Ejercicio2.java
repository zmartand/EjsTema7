import java.util.Scanner;

public class Ejercicio2 {

    private int numeroCliente;
    private String nombre;
    private static int contador = 0;
    public Ejercicio2(String nombre){
        this.nombre = nombre;
    }

    //Asignar el numero de cliente por orden

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = contador;
        contador++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Ejercicio2.contador = contador;
    }

    //Mostrar el cliente con su numero asignado
    @Override
    public String toString() {
        return "Cliente n.°" + getNumeroCliente() + " [" + this.nombre + "]";
    }

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int opcion = 0;
            int contador = 0;
            String nombre;
            Ejercicio2[] clientes = new Ejercicio2[100];
            while (opcion != 3){
                System.out.println("-- Menú --");
                System.out.println("1 - Mostrar clientes");
                System.out.println("2 - Crear un cliente");
                System.out.println("3 - Salir");
                opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("-- Clientes --");
                        for (int i = 0; i < contador; i++) {
                            System.out.println(clientes[i].toString());
                        }
                        break;
                    case 2:
                        System.out.println("¿Nombre?");
                        nombre = sc.next();
                        clientes[contador] = new Ejercicio2(nombre);
                        System.out.println(clientes[contador].toString() + " añadido");
                        contador++;
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }
        }


    
}
