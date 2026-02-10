import java.util.Random;
import java.util.Scanner;

public class TableroPacman {
    public static void main(String[] args) {
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
            scanner.close();
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
        int jugadorFila = 0;
        int jugadorColumna = 0;
        //Buscamos la posición del jugador para guardarla en las variables
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] == '<') {
                    jugadorFila = i;
                    jugadorColumna = j;
                    break; // Salimos del ciclo interno una vez que encontramos al jugador
                }
            }
        }

        boolean juegoActivo = true;

        while(juegoActivo)
        {
            //Mostrar el tablero
            System.out.println("---TABLERO---");
            System.out.println("-------------");
            for (int i = 0; i <filas; i++)
            {
                for (int j = 0; j < columnas; j++) {
                    System.out.print("|" + tablero[i][j] + " ");
                }
                System.out.println("|");

            }
            System.out.println("-------------");

            //Pedir movimiento
            System.out.println("Ingresa tu movimiento -> 8 (Arriba), 2 (Abajo), 4 (Izquierda), 6 (Derecha)");
            String movimiento = scanner.nextLine();

            //Calcular nueva posición del jugador
            int nuevaFila = jugadorFila;
            int nuevaColumna = jugadorColumna;


            if(movimiento.equalsIgnoreCase("8"))
            {
                nuevaFila = jugadorFila - 1;  //Arriba
            }else if(movimiento.equalsIgnoreCase("2"))
            {
                nuevaFila = jugadorFila + 1;  //Abajo
            }else if(movimiento.equalsIgnoreCase("4"))
            {
                nuevaColumna = jugadorColumna - 1; // Izquierda
            }else if(movimiento.equalsIgnoreCase("6"))
            {
                nuevaColumna = jugadorColumna + 1; // Derecha
            }else if(movimiento.equalsIgnoreCase("F"))
            {
                juegoActivo = false;
                System.out.println("¡Gracias por jugar!");
                continue; // Salir del ciclo principal
            }else
            {
                System.out.println("Movimiento no válido. Intenta de nuevo.");
                continue; // Volver al inicio del ciclo para pedir otro movimiento
            }

            //Lógica de bordes infinitos

            if(nuevaFila<0)
            {
                nuevaFila = filas - 1; // Si se mueve hacia arriba desde la fila 0, va a la última fila
            }else if(nuevaFila>=filas)
            {
                nuevaFila = 0; // Si se mueve hacia abajo desde la última fila, va a la fila 0
            }

            if(nuevaColumna<0)
            {
                nuevaColumna = columnas - 1; // Si se mueve hacia la izquierda desde la columna 0, va a la última columna
            }else if(nuevaColumna>=columnas)
            {
                nuevaColumna = 0; // Si se mueve hacia la derecha desde la última columna, va a la columna 0
            }

            //Verificar colisiones
            if(tablero[nuevaFila][nuevaColumna] == 'X')
            {
                System.out.println("¡Te chocaste con una pared! Intenta de nuevo.");
                continue; // Volver al inicio del ciclo para pedir otro movimiento
            }else
            {
                //realizamos el movimiento del jugador
                tablero[jugadorFila][jugadorColumna] = ' '; // Limpiar la posición anterior del jugador
                //actualizamos coordenadas del jugador
                jugadorFila = nuevaFila;
                jugadorColumna = nuevaColumna;
                // acá colocamos de nuevo al jugador en su nueva posición
                tablero[jugadorFila][jugadorColumna] = '<'; // Colocar al jugador en la nueva posición
            }



        }

        //Cerrar scanner antes de salir
        scanner.close();
    }

}
