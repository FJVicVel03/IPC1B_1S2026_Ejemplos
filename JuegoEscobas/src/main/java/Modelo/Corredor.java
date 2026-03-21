package Modelo;

import javax.swing.*;

public class Corredor implements Runnable {

    private String nombre;
    private int posicionX;
    private int posicionY;
    private int tiempoDescanso;
    private boolean enCarrera;

    private Runnable onMove;


    public Corredor(String nombre, int tiempoDescanso, int posicionY,int posicionX, Runnable onMove) {
        this.nombre = nombre;
        this.tiempoDescanso = tiempoDescanso;
        this.posicionX = posicionX; // Posición inicial en X
        this.posicionY = posicionY; // Posición en Y para cada corredor
        this.onMove = onMove;
        this.enCarrera = true;
    }

    @Override
    public void run() {
        while(enCarrera && posicionX < 500){
            posicionX += 5; // Avanza 5 unidades en cada iteración
            if(onMove != null){
                onMove.run();
            }

            try
            {
                Thread.sleep(tiempoDescanso);

            }catch(InterruptedException e)
            {
                JOptionPane.showMessageDialog(null, "Error en el Thread");
            }

        }

    }

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

