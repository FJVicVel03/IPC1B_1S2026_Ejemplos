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
        return "Camisa - Código: " + codigo + ", Nombre: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidad + ", Talla: " + talla;
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
        return "Accesorio - Código: " + codigo + ", Nombre: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidad + ", Tipo: " + tipo;
    }
}

//Clase gestora de inventario

