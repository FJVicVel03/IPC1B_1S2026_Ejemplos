# Ejemplo: Tablero tipo Pacman (Java)

Este proyecto genera un tablero de juego en consola de forma aleatoria.

## ¿Qué hace el programa?

1. Pide el tamaño del tablero:
   - `P` = Pequeño (5x6)
   - `G` = Grande (10x10)
2. Llena el tablero con elementos aleatorios:
   - `X` = pared
   - `$` = premio
   - `!` = trampa
   - `<` = jugador
3. Muestra el tablero y permite mover al jugador en consola hasta que el usuario termine el juego.

## Controles

- `8` = Arriba
- `2` = Abajo
- `4` = Izquierda
- `6` = Derecha
- `F` = Finalizar el juego (salir)

> Nota: El tablero tiene bordes "infinitos" (al moverte fuera de un borde, reapareces por el borde opuesto).

## Cambios recientes aplicados

- El método `main` es público para que la JVM pueda iniciar correctamente la aplicación.
- Se cierra el `Scanner` antes de salir para evitar warnings por recursos no liberados.

## Requisitos

- Java JDK 17 o superior
- Terminal (PowerShell / CMD) o IDE como IntelliJ

## Estructura

- `PacmanTablero/src/TableroPacman.java`: código fuente principal.

## ¿Cómo ejecutarlo? (desde terminal PowerShell)

Desde la raíz del repositorio (donde está la carpeta `PacmanTablero`):

```powershell
javac PacmanTablero/src/TableroPacman.java
java -cp PacmanTablero/src TableroPacman
```

Cuando el programa lo pida, escribe `P` o `G` y presiona Enter; luego usa las teclas de movimiento (`8`, `2`, `4`, `6`) y `F` para salir.

## ¿Cómo funciona internamente?

- Se define el tamaño y cantidades según la opción elegida.
- Se crea una matriz `char[][]` para representar el tablero.
- El tablero inicia vacío (`' '`).
- Con ciclos `while` y `Random`, se colocan paredes, premios y trampas en posiciones libres.
- Luego se coloca al jugador en una celda libre.
- En el loop principal se imprime el tablero y se procesa la entrada del jugador (movimiento con detección de colisiones y bordes infinitos).

## Nota para clase

Este ejemplo usa:

- Condicionales (`if/else`)
- Ciclos (`for`, `while`)
- Arreglos bidimensionales (`char[][]`)
- Entrada por teclado (`Scanner`)
- Aleatoriedad (`Random`)
