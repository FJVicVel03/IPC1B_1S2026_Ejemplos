# SistemaInventarioIPC1

Proyecto de ejemplo en Java (Swing) para aprender Programación Orientada a Objetos usando un sistema de inventario simple.

## 1) ¿Qué hace este proyecto?

Este programa muestra una ventana con un menú de botones para gestionar productos de inventario.

Actualmente implementa estas acciones:

- `Agregar Producto`: agrega un producto de ejemplo al inventario.
- `Eliminar Producto`: en este código **no elimina**; realmente muestra un reporte con los productos cargados.
- `Salir`: cierra la aplicación.

Hay otros botones visibles (`Buscar Producto`, `Registrar Venta`, `Generar Reporte`, `Ver Datos Estudiante`), pero todavía no tienen lógica asociada en el controlador.

## 2) Estructura de carpetas y por qué existen

```text
SistemaInventarioIPC1/
|- pom.xml
|- src/
|  |- main/
|     |- java/
|        |- modelo/
|        |  |- Producto.java
|        |  |- Inventario.java
|        |- vista/
|        |  |- VistaInventario.java
|        |  |- VistaInventario.form
|        |- controlador/
|           |- ControladorInventario.java
|- target/
|- .idea/
```

- `src/main/java`: código fuente principal del programa.
- `modelo`: guarda datos y reglas del negocio (inventario y productos).
- `vista`: interfaz gráfica (la ventana Swing).
- `controlador`: conecta botones de la vista con acciones del modelo.
- `pom.xml`: configuración de Maven (cómo compilar/empaquetar).
- `target`: salida de compilación de Maven (archivos generados).
- `.idea`: configuración del IDE IntelliJ.
- `VistaInventario.form`: diseño visual generado por NetBeans Form Editor.

## 3) Patrón usado: MVC (Modelo - Vista - Controlador)

Se usa MVC para separar responsabilidades y que el código sea más fácil de mantener:

- **Modelo (`modelo`)**: maneja la información del inventario.
- **Vista (`vista`)**: solo muestra la interfaz al usuario.
- **Controlador (`controlador`)**: escucha eventos de botones y decide qué hacer.

## 4) Clases principales y por qué se usaron

### `Producto` (abstracta)

Archivo: `src/main/java/modelo/Producto.java`

- Representa la idea general de un producto.
- Tiene atributos comunes: `codigo`, `nombre`, `precio`, `cantidad`.
- Es `abstract` para obligar a que cada tipo de producto defina su propio detalle con `obtenerDetalles()`.

¿Por qué sirve?

- Permite reutilizar campos comunes.
- Facilita **polimorfismo**: tratar distintos productos como `Producto`.

### `Camisa` y `Accesorio` (clases hijas)

Archivo: `src/main/java/modelo/Producto.java`

- `Camisa` agrega `talla`.
- `Accesorio` agrega `tipo`.

¿Por qué sirve?

- Muestran herencia en un caso real: cada categoría tiene datos propios.

### `Inventario`

Archivo: `src/main/java/modelo/Inventario.java`

- Guarda productos en un arreglo fijo `Producto[] productos = new Producto[100]`.
- Lleva `contadorProductos` para saber cuántos están ocupados.
- Método `agregarProductos(int tipo)` agrega una `Camisa` o `Accesorio` según par/impar.

¿Por qué sirve?

- Centraliza la lógica de almacenamiento del inventario.
- El arreglo fijo es didáctico para practicar estructuras básicas sin colecciones.

### `VistaInventario`

Archivo: `src/main/java/vista/VistaInventario.java`

- Crea la ventana y botones con Swing.
- En el `main` instancia vista + modelo + controlador.

¿Por qué sirve?

- Separa la parte visual de la lógica.
- Es el punto de arranque de la aplicación en este proyecto.

### `ControladorInventario`

Archivo: `src/main/java/controlador/ControladorInventario.java`

- Registra `ActionListener` para los botones.
- Cuando se hace clic en `Agregar Producto`, llama al modelo para agregar.
- Cuando se hace clic en `Eliminar Producto`, actualmente muestra el listado en un `JOptionPane`.
- Maneja `Salir` con `System.exit(0)`.

¿Por qué sirve?

- Evita mezclar lógica de negocio dentro de la vista.
- Es la capa que coordina todo en MVC.

## 5) Flujo del programa paso a paso

1. En `main`, se crea `VistaInventario`.
2. Se crea `Inventario` vacío.
3. Se crea `ControladorInventario(vista, inventario)`.
4. El controlador conecta eventos de botones.
5. `controlador.iniciar()` muestra la ventana.
6. El usuario presiona botones y el controlador ejecuta acciones.

## 6) Conceptos de POO que practica este proyecto

- **Encapsulamiento**: atributos dentro de clases.
- **Herencia**: `Camisa` y `Accesorio` heredan de `Producto`.
- **Abstracción**: `Producto` abstracta define contrato común.
- **Polimorfismo**: el inventario guarda diferentes tipos en un arreglo `Producto[]`.

## 7) Cómo ejecutar el proyecto

### Opción A: desde NetBeans o IntelliJ

1. Abrir la carpeta del proyecto.
2. Ejecutar la clase `vista.VistaInventario`.

### Opción B: con Maven (línea de comandos)

```bash
mvn clean package
```

Después, ejecutar la clase principal configurada (ver nota abajo).

## 8) Notas importantes del estado actual

- El botón `Eliminar Producto` no elimina todavía; solo muestra reporte.
- Hay botones en la interfaz que aún no tienen funcionalidad.
- En `pom.xml`, `exec.mainClass` apunta a `com.mycompany.sistemainventarioipc1.SistemaInventarioIPC1`, pero en el código el `main` real está en `vista.VistaInventario`.
- Se observan textos con caracteres mal codificados (`CÃ³digo`, `gestiÃ³n`) por tema de encoding en algunos archivos.

## 9) Ideas de mejora para continuar aprendiendo

- Implementar eliminación real por código.
- Implementar búsqueda de productos por nombre/código.
- Registrar ventas descontando cantidad.
- Cambiar arreglo fijo por `ArrayList<Producto>`.
- Mover `Camisa` y `Accesorio` a archivos separados para mayor claridad.
- Corregir el `mainClass` en `pom.xml` para ejecutar directo con Maven.
- Agregar validaciones y pruebas unitarias.

---
