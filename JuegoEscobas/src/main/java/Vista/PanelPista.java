package Vista;

import Modelo.Corredor;

import javax.swing.*;
import java.awt.*;

public class PanelPista extends JPanel{

    private Corredor jugador;
    private Corredor computadora;

    //El controlador debe inyectar los modelos a la vista

    public void setCorredores(Corredor j1, Corredor pc){
        this.jugador = j1;
        this.computadora = pc;
    }

    @Override
    protected void paintComponent(Graphics g) // mandamos a llamar a la función que nos ayudará a pintar el panel
    {
        super.paintComponent(g);

        //Dibujamos al jugador 1 (Por ejemplo, un círculo dorado)
        if(jugador != null){
            g.setColor(Color.RED);
            g.fillOval(jugador.getPosicionX(), jugador.getPosicionY(), 30, 30); //Dibujamos un círculo de 30x30 píxeles
            g.drawString(jugador.getNombre(), jugador.getPosicionX(), jugador.getPosicionY() - 5); //Dibujamos el nombre del corredor
        }
        //Dibujamos a la computadora (Por ejemplo, con un rectangulo)
        if(computadora != null){
            g.setColor(Color.BLUE);
            g.fillRect(computadora.getPosicionX(), computadora.getPosicionY(), 30, 30); //Dibujamos un rectángulo de 30x30 píxeles
            g.drawString(computadora.getNombre(), computadora.getPosicionX(), computadora.getPosicionY() - 5); //Dibujamos el nombre del corredor
        }

        //Linea de meta
        g.setColor(Color.RED);
        g.drawLine(600, 0, 600, getHeight()); //Dibujamos una línea vertical en la posición de la meta
    }
}
