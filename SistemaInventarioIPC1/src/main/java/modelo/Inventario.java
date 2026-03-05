package modelo;


public class Inventario{
    //vamos a usar vectores estáticos por restricción
    private Producto[] productos;
    private int contadorProductos;

    public Inventario() {
        this.productos = new Producto[100];
        this.contadorProductos = 0;
    }

    public boolean agregarProductos(String tipo, int codigo, String nombre, double precio, int cantidad, String detalle)
    {
        //Recibe del controlador los parametros ingresados por el usuario y crea un nuevo producto
        if(contadorProductos >= productos.length)
        {
            return false; // No se pueden agregar más productos, el inventario está lleno
        }
        if(tipo.equalsIgnoreCase("Accesorio"))
        {
            productos[contadorProductos] = new Accesorio(codigo, nombre, precio, cantidad, detalle);
            contadorProductos++;
            return true;
        }else if(tipo.equalsIgnoreCase("Camisa"))
        {
            productos[contadorProductos] = new Camisa(codigo, nombre, precio, cantidad, detalle);
            contadorProductos++;
            return true;
        } else {
            return false; // Tipo de producto no válido
        }

    }

    public Producto[] getProductos()
    {
        return productos;
    }
    public int getContadorProductos() {
        return contadorProductos;
    }

}