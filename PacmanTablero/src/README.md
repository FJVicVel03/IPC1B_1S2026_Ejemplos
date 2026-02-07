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
3. Muestra el tablero final en consola.

## Requisitos

- Java JDK 17 o superior
- Terminal (PowerShell / CMD) o IDE como IntelliJ

## Estructura

- `PacmanTablero/src/TableroPacman.java`: código fuente principal.

## ¿Cómo ejecutarlo? (desde terminal)

Desde la raíz del repositorio:

```bash
javac PacmanTablero/src/TableroPacman.java
java -cp PacmanTablero/src TableroPacman
```

Cuando el programa lo pida, escribe `P` o `G` y presiona Enter.

## ¿Cómo funciona internamente?

- Se define el tamaño y cantidades según la opción elegida.
- Se crea una matriz `char[][]` para representar el tablero.
- El tablero inicia vacío (`' '`).
- Con ciclos `while` y `Random`, se colocan paredes, premios y trampas en posiciones libres.
- Luego se coloca al jugador en una celda libre.
- Finalmente, se imprime toda la matriz con bordes.

## Nota para clase

Este ejemplo usa:

- Condicionales (`if/else`)
- Ciclos (`for`, `while`)
- Arreglos bidimensionales (`char[][]`)
- Entrada por teclado (`Scanner`)
- Aleatoriedad (`Random`)
