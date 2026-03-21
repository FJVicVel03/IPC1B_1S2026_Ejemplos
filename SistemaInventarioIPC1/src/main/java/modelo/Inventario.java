package modelo;


public class Inventario{
    //vamos a usar vectores estáticos por restricción
    private Producto[] productos;
    private int contadorProductos;


    public Inventario() {
        this.productos = new Producto[100];
        this.contadorProductos = 0;
    }

    public boolean agregarProductos(int tipo)
    {
        if(contadorProductos >= productos.length) return false; // No hay espacio para más productos
        //aplicamos polimorfismo para guardar objetos hijos en el mismo vector
        if(tipo %2 == 0)
        {
            productos[contadorProductos] = new Camisa(codigoUnico(), "Camisa " + (contadorProductos + 1), 29.99, 10, "M");
        }else {
            productos[contadorProductos] = new Accesorio(codigoUnico(), "Accesorio " + (contadorProductos + 1), 9.99, 20, "Pulsera");
        }
        contadorProductos++;
        return true;

    }

    private String codigoUnico()
    {
        //Vector con las letras del abecedario mayúsculas
        int numeroRandom = (int) (Math.random() * 1000);
        char letra = (char) ('A' + (numeroRandom % 26)); // Genera una letra basada en el código
        return letra + String.valueOf(numeroRandom); // Combina la letra con el código para

    }
    public Producto[] getProductos()
    {
        return productos;
    }
    public int getContadorProductos() {
        return contadorProductos;
    }

}