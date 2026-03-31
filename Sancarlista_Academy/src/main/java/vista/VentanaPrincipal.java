package vista;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.AppController;

public class VentanaPrincipal extends JFrame{
    private AppController controlador;
    private CardLayout cardLayout; // Esto sirve para organizar varios paneles como si fueran cartas en uno solo, es útil, úsenlo
    private JPanel panelPrincipal;
    private PanelAdministrador panelAdministrador;



    public VentanaPrincipal(){
        this.controlador = new AppController();

        //Configuración de la ventana
        this.cardLayout = new CardLayout();
        this.panelPrincipal = new JPanel(cardLayout);

        //Registro de vistas
        panelPrincipal.add(new PanelLogin(this), "Login");
        panelAdministrador = new PanelAdministrador(this);
        panelPrincipal.add(panelAdministrador, "Administrador");
        //acá les faltaría a ustedes agregar los demás paneles


        add(panelPrincipal);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void cambiarVista(String nombreVista)
    {
        cardLayout.show(panelPrincipal, nombreVista);
        if("Administrador".equals(nombreVista)) {
            panelAdministrador.iniciarHilos();
        }
    }

    public AppController getControlador()
    {
        return controlador;
    }

}
