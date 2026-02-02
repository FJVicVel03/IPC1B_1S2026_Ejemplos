import java.util.Random;
import java.util.Scanner;

public class TableroPacman {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int filas = 0;
        int columnas = 0;
        int cantidadParedes = 0;
        int cantidadPremios = 0;
        int cantidadTrampas = 0;

        System.out.println("Configuremos nuestro pacman!");

        System.out.println("Ingresa el tamaño -> P (Pequeño), G (Grande)");
        String opcion = scanner.nextLine().toUpperCase();

        if (opcion.equalsIgnoreCase("P")) {
            filas = 5;
            columnas = 6;
            cantidadParedes = 3;
            cantidadPremios = 4;
            cantidadTrampas = 2;
        } else if (opcion.equalsIgnoreCase("G")) {
            filas = 10;
            columnas = 10;
            cantidadParedes = 10;
            cantidadPremios = 12;
            cantidadTrampas = 8;
        } else {
            System.out.println("Opción no válida. Saliendo del programa.");
            return;
        }

        char[][] tablero = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = ' ';
            }
        }

        //Acá vamos a colocar las paredes
        int paredesColocadas = 0;
        while (paredesColocadas < cantidadParedes) {
            int f = random.nextInt(filas); // <- esto es una fila alteatoria
            int c = random.nextInt(columnas); // <- esto es una columna alteatoria

            if (tablero[f][c] == ' ') {
                tablero[f][c] = 'X'; // Pared
                paredesColocadas++;
            }
        }
        //Acá vamos a colocar los premios
        int premiosColocados = 0;
        while (premiosColocados < cantidadPremios) {
            int f = random.nextInt(filas); // <- esto es una fila alteatoria
            int c = random.nextInt(columnas); // <- esto es una columna alteatoria

            if (tablero[f][c] == ' ') {
                tablero[f][c] = '$'; // Premio
                premiosColocados++;
            }
        }
        //Acá vamos a colocar las trampas
        int trampasColocadas = 0;
        while (trampasColocadas < cantidadTrampas) {
            int f = random.nextInt(filas); // <- esto es una fila alteatoria
            int c = random.nextInt(columnas); // <- esto es una columna alteatoria

            if (tablero[f][c] == ' ') {
                tablero[f][c] = '!'; // Trampa
                trampasColocadas++;
            }
        }
        //acá colocaremos al jugador (representado con < )
        //el jugador tiene una posición única
        boolean jugadorColocado = false;
        while (!jugadorColocado) {
            int f = random.nextInt(filas); // <- esto es una fila alteatoria
            int c = random.nextInt(columnas); // <- esto es una columna alteatoria

            if (tablero[f][c] == ' ') {
                tablero[f][c] = '<'; // Jugador
                jugadorColocado = true; // <- acá rompemos el ciclo
            }
        }

        //Mostrar el tablero
        System.out.println("---TABLERO---");
        System.out.println("-------------");
        for (int i = 0; i <filas; i++)
        {
            for (int j = 0; j < columnas; j++) {
                System.out.print("|" + tablero[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

}
