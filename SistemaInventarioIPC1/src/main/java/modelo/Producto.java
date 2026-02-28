package modelo;

public abstract class Producto {
    protected int codigo;
    protected String nombre;
    protected double precio;
    protected int cantidad;

    public Producto(int codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public abstract String obtenerDetalles();

    public abstract int getCodigo();
}

//Clases hijas

class Camisa extends Producto {
    private String talla;

    public Camisa(int codigo, String nombre, double precio, int cantidad, String talla) {
        super(codigo, nombre, precio, cantidad);
        this.talla = talla;
    }

    @Override
    public String obtenerDetalles() {
        return "Camisa - Código: " + codigo + ", Nombre: " + nombre + ", Precio: $" + precio + ", Cantidad: " + cantidad + ", Talla: " + talla;
    }
        @Override
    public int getCodigo() {
            return codigo;
        }
}
class Accesorio extends Producto {
    private String tipo;

    public Accesorio(int codigo, String nombre, double precio, int cantidad, String tipo) {
        super(codigo, nombre, precio, cantidad);
        this.tipo = tipo;
    }

    @Override
    public String obtenerDetalles() {
        return "Accesorio  - Codigo: " + codigo + ", Nombre: " + nombre + ", Precio: $" + precio + ", Cantidad: " + cantidad + ", Tipo: " + tipo;
    }
        @Override
    public int getCodigo() {
        return  codigo;
        }
}

//Clase gestora de inventario

