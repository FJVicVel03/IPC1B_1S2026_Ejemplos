package modelo;

import java.io.Serializable;

public class ListaSimple<T> implements Serializable {
    private Object[] elementos;
    private int contador;

    public ListaSimple() {
        this.elementos = new Object[10]; //tamaño inicial
        this.contador = 0;
    }

    public void agregar(T elemento) {
        if(contador == this.elementos.length) {
            expandir();
        }
        elementos[contador++] = elemento;
    }

    private void expandir() {
        Object[] nuevo = new Object[this.elementos.length * 2];
        System.arraycopy(this.elementos, 0, nuevo, 0, this.elementos.length);
        elementos = nuevo;
    }

    public T obtener(int indice){
        return (T) elementos[indice];
    }

    public int size(){
        return contador;
    }
}
