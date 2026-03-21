package Modelo;

import javax.swing.*;

public class Corredor implements Runnable{
    private String nombre;
    private int posicionX;
    private int posicionY;
    private int tiempoDescanso; //Esto debe ser en misilegundos (1000, 2000)
    private boolean enCarrera;
    //debemos tener una referencia a un actualizador para que repinte la vista
    private Runnable onMove;

    public Corredor(String nombre, int tiempoDescanso, int posicionY, Runnable onMove) {
        this.nombre = nombre;
        this.posicionX = 20; // POsición inicial
        this.posicionY = posicionY;
        this.tiempoDescanso = tiempoDescanso;
        this.enCarrera = true;
        this.onMove = onMove;
    }



    @Override
    public void run()
    {
        while(enCarrera && posicionX < 600)
        {
            posicionX += 5; //avanza 20 pixeles

            if(onMove != null)
            {
                onMove.run();
            }
            try
            {
                //Dormir el hilo según el modelo de la escoba que utilizaremos
                Thread.sleep(tiempoDescanso);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Error en Corredor");
            }
        }



    }

    //Encapsulamiento
    public String getNombre() {
        return nombre;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

}
