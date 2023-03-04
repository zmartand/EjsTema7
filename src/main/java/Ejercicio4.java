import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {

        private final int FILAS = 10;
        private final int COLUMNAS = 10;
        private final int AGUA = 0;
        private final int BARCO = 1;
        private final int HUNDIDO = 2;
        private int[][] tabla;
        private int barcoFila;
        private int barcoColumna;

        public Ejercicio4() {
            tabla = new int[FILAS][COLUMNAS];
            for (int i = 0; i < FILAS; i++) {
                Arrays.fill(tabla[i], AGUA);
            }
        }

        public void depositarBarco(int fila, int columna) {
            barcoFila = fila;
            barcoColumna = columna;
            tabla[fila][columna] = BARCO;
        }

        public boolean disparar(int fila, int columna) {
            if (tabla[fila][columna] == BARCO) {
                tabla[fila][columna] = HUNDIDO;
                if (fila == barcoFila && columna == barcoColumna) {
                    return true;
                }
            }
            return false;
        }

        public void visualizacion() {
            System.out.println("  0 1 2 3 4 5 6 7 8 9");
            for (int i = 0; i < FILAS; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < COLUMNAS; j++) {
                    if (tabla[i][j] == AGUA) {
                        System.out.print("~ ");
                    } else if (tabla[i][j] == BARCO) {
                        System.out.print("~ ");
                    } else {
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Random rand = new Random();

            System.out.println("Bienvenido a la micro guerra de barcos. ");
            System.out.println("Usted se enfrentará a la computadora.");

            Ejercicio4 cuadriculaHumano = new Ejercicio4();
            Ejercicio4 cuadriculaComputadora = new Ejercicio4();

            // Posicionar barcos
            System.out.println("Posicione su barco:");
            int filaBarcoHumano = sc.nextInt();
            int columnaBarcoHumano = sc.nextInt();
            cuadriculaHumano.depositarBarco(filaBarcoHumano, columnaBarcoHumano);

            int filaBarcoComputadora = rand.nextInt(10);
            int columnaBarcoComputadora = rand.nextInt(10);
            cuadriculaComputadora.depositarBarco(filaBarcoComputadora, columnaBarcoComputadora);

            boolean humanoActivo = true;
            boolean computadoraActiva = true;

            while (humanoActivo && computadoraActiva) {
                // Turno del humano
                System.out.println("Turno del humano.");
                cuadriculaComputadora.visualizacion();
                System.out.print("Disparo en fila: ");
                int filaDisparoHumano = sc.nextInt();
                System.out.print("Disparo en columna: ");
                int columnaDisparoHumano = sc.nextInt();
                if (cuadriculaComputadora.disparar(filaDisparoHumano, columnaDisparoHumano)) {
                    System.out.println("¡Has hundido el barco de la computadora!");
                    computadoraActiva = false;
                    break;
                }
// Turno de la computadora
                System.out.println("Turno de la computadora.");
                int filaDisparoComputadora = rand.nextInt(10);
                int columnaDisparoComputadora = rand.nextInt(10);
                if (cuadriculaHumano.disparar(filaDisparoComputadora, columnaDisparoComputadora)) {
                    System.out.println("La computadora ha hundido tu barco.");
                    humanoActivo = false;
                    break;
                }
            }

            if (!humanoActivo) {
                System.out.println("La computadora ha ganado.");
            } else {
                System.out.println("¡Felicidades! ¡Has ganado!");
            }
        }
    }

