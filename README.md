# Introduccion a la Programacion y Computacion 1
## Curso 0770 - IPC1B (1er semestre 2026)

Repositorio de ejemplos y practicas del curso. Aqui se incluyen proyectos en Java (consola y Swing) para reforzar fundamentos de programacion, POO, MVC e hilos.

## Proyectos incluidos

### 1. PacmanTablero
- Ruta: `PacmanTablero/`
- Tipo: Java de consola (sin Maven)
- Archivo principal: `PacmanTablero/src/TableroPacman.java`
- Enfoque: arreglos bidimensionales, aleatoriedad, entrada por teclado y logica de movimiento.

### 2. SistemaInventarioIPC1
- Ruta: `SistemaInventarioIPC1/`
- Tipo: Java + Maven + Swing
- Punto de entrada: `SistemaInventarioIPC1/src/main/java/vista/VistaInventario.java`
- Enfoque: Programacion Orientada a Objetos con patron MVC para un inventario basico.
- Documentacion especifica: `SistemaInventarioIPC1/README.md`

### 3. SnakeP2
- Ruta: `SnakeP2/`
- Tipo: Java Swing (estructura NetBeans)
- Punto de entrada recomendado: `SnakeP2/src/codigo/SnakeP2.java`
- Enfoque: juego de Snake con interfaz grafica, controlador y manejo de records.

### 4. Sancarlista_Academy
- Ruta: `Sancarlista_Academy/`
- Tipo: Java + Maven + Swing
- Punto de entrada: `Sancarlista_Academy/src/main/java/controlador/Main.java`
- Enfoque: interfaz de academia, estructuras de datos (lista simple) y control de flujo en GUI.

### 5. JuegoEscobas
- Ruta: `JuegoEscobas/`
- Tipo: Java + Maven + Swing
- Punto de entrada: `JuegoEscobas/src/main/java/Controlador/ControladorCarrera.java`
- Enfoque: simulacion visual con hilos usando el modelo de corredores y premios.

## Estructura general

```text
IPC1B_1S2026_Ejemplos/
|- README.md
|- PacmanTablero/
|- SistemaInventarioIPC1/
|- SnakeP2/
|- Sancarlista_Academy/
|- JuegoEscobas/
```

## Requisitos

- JDK 17+ (recomendado: JDK 21 o superior)
- Maven (para los proyectos que incluyen `pom.xml`)
- IDE recomendado: NetBeans o IntelliJ IDEA

## Como ejecutar los ejemplos

### Opcion A: desde IDE
1. Abrir la carpeta del proyecto que quieras ejecutar.
2. Ejecutar su clase `main` correspondiente.

### Opcion B: desde terminal

#### PacmanTablero (sin Maven)
```powershell
javac PacmanTablero/src/TableroPacman.java
java -cp PacmanTablero/src TableroPacman
```

#### Proyectos Maven (`SistemaInventarioIPC1`, `Sancarlista_Academy`, `JuegoEscobas`)
Desde la carpeta del proyecto:
```powershell
mvn clean package
```
Luego ejecuta la clase principal desde el IDE o configura `exec.mainClass` en el `pom.xml` para usar `mvn exec:java`.

## Nota del repositorio

En algunas carpetas hay archivos generados por IDE/compilacion (`out/`, `target/`, `.iml`, `.jar`, logs). Son utiles para pruebas locales, pero no forman parte del codigo fuente principal.

## Autor

Fernando Jose Vicente Velasquez

Ultima actualizacion: 31 de marzo de 2026
