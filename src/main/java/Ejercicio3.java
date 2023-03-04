import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3 {
    private final int FILAS = 10;
    private final int COLUMNAS = 10;
    private final int AGUA = 0;
    private final int BARCO = 1;
    private final int HUNDIDO = 2;
    private int[][] tabla;
    private int barcoFila;
    private int barcoColumna;

    public Ejercicio3() {
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
        Ejercicio3 juego = new Ejercicio3();
        int fila, columna;
        boolean hundido = false;
        juego.depositarBarco(5, 5);
        while (!hundido) {
            juego.visualizacion();
            System.out.println("Introduce la fila: ");
            fila = sc.nextInt();
            System.out.println("Introduce la columna: ");
            columna = sc.nextInt();
            hundido = juego.disparar(fila, columna);
        }
        System.out.println("¡Has hundido el barco!");
    }
}
