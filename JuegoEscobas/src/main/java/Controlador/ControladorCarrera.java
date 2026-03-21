package Controlador;

import Modelo.Corredor;
import Vista.PanelPista;

import java.awt.*;

public class ControladorCarrera {
    private PanelPista panel;
    private Corredor jugador;
    private Corredor computadora;


    // Constructor que solo recibe la pista
    public ControladorCarrera(PanelPista pista)
    {
        this.panel = pista;
    }

    public void PrepararCarrera()
    {
        //Haremos una expresión lambda para repintar el panel cada vez que un corredor se mueva
        Runnable repintarVista = () -> panel.repaint();

        //Inicializamos los modelos
        //Jugador: Saeta de Fuego (1000 ms) . Computadora: Nimbus 2001 (200ms)
        jugador = new Corredor("Saeta de Fuego", 1000, 50, repintarVista);
        computadora = new Corredor("Nimbus 2001", 2000, 150, repintarVista);

        //Pasamos estos modelos a la vista

        panel.setCorredores(jugador, computadora);
        panel.repaint();

    }

    public void IniciarCarrera()
    {
        //Iniciamos los hilos de cada corredor
        //Creamos los hilos basados en nuestros modelos de Runnable
        Thread hiloJugador = new Thread(jugador);
        Thread hiloComputadora = new Thread(computadora);

        hiloJugador.start();
        hiloComputadora.start();
    }

    public static void main(String[] args) {
        //Creamos la ventana principal
        javax.swing.JFrame ventana = new javax.swing.JFrame("Carrera de Escobas");
        ventana.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 300);
        ventana.setLocationRelativeTo(null); //Centra la ventana

        //Inicializamos el panel Vista y lo agregamos a la ventana
        PanelPista panel = new PanelPista();
        ventana.add(panel);

        //Iniciamos el controlador
        ControladorCarrera controlador = new ControladorCarrera(panel);

        //Hacemos visible la ventana antes de arrancar la carrera
        ventana.setVisible(true);

        //Preparamos e iniciamos la carrera
        controlador.PrepararCarrera();
        controlador.IniciarCarrera();
    }

}
