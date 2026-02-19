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

        while(juegoActivo) {
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

            //Pedir al usuario que ingrese un movimiento
            System.out.println("Ingresa un movimiento (W/A/S/D): ");
            String movimiento = scanner.nextLine().toUpperCase();

            int nuevaFila = jugadorFila;
            int nuevaColumna = jugadorColumna;

            if(movimiento.equals("W")) {
                nuevaFila = jugadorFila - 1; //ARRIBA
            } else if(movimiento.equals("S")) {
                nuevaFila = jugadorFila + 1; //ABAJO
            } else if(movimiento.equals("A")) {
                nuevaColumna = jugadorColumna - 1; //Izquierda
            } else if(movimiento.equals("D")) {
                nuevaColumna = jugadorColumna + 1; //DERECHA
            }else if(movimiento.equals("F")) {
                juegoActivo = false;
                System.out.println("¡Gracias por jugar!");
                continue; // Salimos del ciclo principal
            }

            //Lógica de los bordes infinitos

            if(nuevaColumna < 0){
                nuevaColumna = columnas - 1; // Si se mueve a la izquierda del borde, aparece en la derecha
            } else if(nuevaColumna >= columnas){
                nuevaColumna = 0; // Si se mueve a la derecha del borde, aparece en la izquierda
            }

            if(nuevaFila < 0){
                nuevaFila = filas - 1; // Si se mueve hacia arriba del borde, aparece en la parte inferior
            } else if(nuevaFila >= filas){
                nuevaFila = 0; // Si se mueve hacia abajo del borde, aparece en la parte superior
            }

            //Verificar la colision con las paredes

            if(tablero[nuevaFila][nuevaColumna] == 'X')
            {
                System.out.println("Te chocaste por animal!");

            }else {
                //Movemos al jugador a la siguiente posición

                tablero[jugadorFila][jugadorColumna] = ' ';

                //actualizamos el jugador a la nueva posición
                jugadorFila = nuevaFila;
                jugadorColumna = nuevaColumna;
                //Colocamos al jugador en la posición nueva

                tablero[jugadorFila][jugadorColumna] = '<';
            }
        }
        }
    }

