package modelo;

public abstract class Producto {
    protected String codigo;
    protected String nombre;
    protected double precio;
    protected int cantidad;

    public Producto(String codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigoUnico();
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public abstract String obtenerDetalles();

    public abstract String getCodigo();

    public abstract String codigoUnico(); //Por Ejemplo A128
}

//Clases hijas

class Camisa extends Producto {
    private String talla;

    public Camisa(String codigo, String nombre, double precio, int cantidad, String talla) {
        super(codigo, nombre, precio, cantidad);
        this.talla = talla;
    }

    @Override
    public String obtenerDetalles() {
        return "Camisa - Código: " + codigo + ", Nombre: " + nombre + ", Precio: $" + precio + ", Cantidad: " + cantidad + ", Talla: " + talla;
    }
        @Override
    public String getCodigo() {
            return codigo;
        }
        @Override
    public String codigoUnico()
        {
            //Vector con las letras del abecedario mayúsculas
            int numeroRandom = (int) (Math.random() * 1000); // Genera un número aleatorio entre 0 y 999
            char letra = (char) ('A' + (numeroRandom % 26)); // Genera una letra basada en el código
            return letra + String.valueOf(numeroRandom); // Combina la letra con el código para

        }
}
class Accesorio extends Producto {
    private String tipo;

    public Accesorio(String codigo, String nombre, double precio, int cantidad, String tipo) {
        super(codigo, nombre, precio, cantidad);
        this.tipo = tipo;
    }

    @Override
    public String obtenerDetalles() {
        return "Accesorio  - Codigo: " + codigo + ", Nombre: " + nombre + ", Precio: $" + precio + ", Cantidad: " + cantidad + ", Tipo: " + tipo;
    }
        @Override
    public String getCodigo() {
        return  codigo;
        }
    @Override
    public String codigoUnico()
    {
        //Vector con las letras del abecedario mayúsculas
        int numeroRandom = (int) (Math.random() * 1000);
        char letra = (char) ('A' + (numeroRandom % 26)); // Genera una letra basada en el código
        return letra + String.valueOf(numeroRandom); // Combina la letra con el código para

    }
}

//Clase gestora de inventario

