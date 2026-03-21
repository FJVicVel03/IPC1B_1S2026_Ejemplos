package Vista;

import Modelo.Corredor;
import Modelo.Premios;

import javax.swing.*;
import java.awt.*;

public class PanelPista extends JPanel {

    private Corredor jugador;
    private Corredor computadora;
    private Premios premios;

    public void setCorredores(Corredor jugador, Corredor computadora) {
        this.jugador = jugador;
        this.computadora = computadora;
    }
    public void setPremios(Premios premios) {
        this.premios = premios;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //Dibujar al jugador 1

        if(jugador != null)
        {
            g.setColor(Color.RED);
            g.fillRect(jugador.getPosicionX(),jugador.getPosicionY(), 30, 30);
            g.drawString(jugador.getNombre(),  jugador.getPosicionX(), jugador.getPosicionY() - 5); // Dibujar el nombre
        }

        if(computadora != null)
        {
            g.setColor(Color.BLUE);
            g.fillOval(computadora.getPosicionX(), computadora.getPosicionY(), 30, 30);
            g.drawString(computadora.getNombre(), computadora.getPosicionX(), computadora.getPosicionY() - 5);
        }

        if(premios != null)
        {
            g.setColor(Color.YELLOW);
            g.fillArc(premios.getPosicionX(), premios.getPosicionY(), 20, 20, 0, 360);
            g.drawString(premios.getNombre(), premios.getPosicionX(), premios.getPosicionY() - 5);
        }

        //Linea de meta
        g.setColor(Color.BLACK);
        g.drawLine(500, 0, 500, getHeight()); // Dibujamos una línea vertical

    }
}
