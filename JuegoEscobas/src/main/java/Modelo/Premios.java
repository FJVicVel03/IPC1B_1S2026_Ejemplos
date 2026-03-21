package Modelo;

import javax.swing.*;

public class Premios implements Runnable{
    private String nombre;
    private int tiempoDescanso;
    private int posicionX;
    private int posicionY;
    private int puntaje;

    private Runnable onMovePremio;

    public Premios(String nombre, int tiempoDescanso, int posicionX, int posicionY, int puntaje, Runnable onMovePremio ) {
        this.nombre = nombre;
        this.tiempoDescanso = tiempoDescanso;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.puntaje = puntaje;
        this.onMovePremio = onMovePremio;
    }

    @Override
    public void run() {
        while (true) {
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}
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



