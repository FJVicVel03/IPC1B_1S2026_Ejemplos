package Controlador;

import Modelo.Corredor;
import Modelo.Premios;
import Vista.PanelPista;
import java.util.Random;


public class ControladorCarrera {
    private PanelPista panel;
    private Corredor jugador;
    private Corredor computadora;
    private Premios premios;
    private Random rand = new Random();

    int numero = rand.nextInt(2);
    int posX_aleatoria = rand.nextInt(200);

    //Constructor que solo recibe la pista

    public ControladorCarrera(PanelPista panel) {
        this.panel = panel;
    }

    public void PrepararCarrera()
    {
        Runnable repintarVista = () -> panel.repaint();

        //Inicializar los modelos
        jugador = new Corredor("Fernando", 1000, 50,15,  repintarVista);
        computadora = new Corredor("Chatio", 2000, 150,30, repintarVista );

        //Llammamos a los premios
        if(numero == 0)
        {
            premios = new Premios("Premio 1", 3000, posX_aleatoria, 50, 10, repintarVista);
        }else if(numero == 1)
        {
            premios = new Premios("Premio 2", 3000, posX_aleatoria, 150, 20, repintarVista);
        }


        //Pasar los modelos a la vista

        panel.setCorredores(jugador, computadora);
        panel.setPremios(premios);
        panel.repaint();
    }

    public void IniciarCarrera()
    {
        //Iniciar los hilos de cada jugador
        //Hilos basados ennuestros modelos runnable

        Thread hiloJugador = new Thread(jugador);
        Thread hiloComputadora = new Thread(computadora);
        Thread hiloPremios = new Thread(premios);

        hiloJugador.start();
        hiloComputadora.start();
        hiloPremios.start();
    }

    public static void main (String[] args)
    {
        //Crear la ventana principal
        javax.swing.JFrame ventana = new javax.swing.JFrame();
        ventana.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 200);
        ventana.setLocationRelativeTo(null); // Lo centra


        //Inicializamos el panel vista y lo agregamos a la ventana
        PanelPista pista = new PanelPista();
        ventana.add(pista);

        //Inicializar el controlador
        ControladorCarrera controlador = new ControladorCarrera(pista);

        //Hacemos visible la ventana principal
        ventana.setVisible(true);

        //Preparamos e iniciamos la carrera
        controlador.PrepararCarrera();
        controlador.IniciarCarrera();
    }

}
