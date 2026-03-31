package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import modelo.HiloInscripciones;

public class PanelAdministrador extends JPanel{
    private VentanaPrincipal ventanaPrincipal;
    private JTextArea txtConsola;
    private Thread hiloInscripciones;
    private HiloInscripciones tareaInscripciones;

    public PanelAdministrador(VentanaPrincipal ventanaPrincipal)
    {
        this.ventanaPrincipal=ventanaPrincipal;
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        //Título
        JLabel lblTitulo = new  JLabel("Administrador", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblTitulo, BorderLayout.NORTH);

        //Consola de Hilos (Centrada)
        txtConsola = new JTextArea();
        txtConsola.setEditable(false);
        txtConsola.setBackground(Color.BLACK);
        txtConsola.setForeground(Color.GREEN);
        txtConsola.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(txtConsola);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Consola de Inscripciones"));
        add(scrollPane, BorderLayout.CENTER);

        //Botones de lado de abajo

        JPanel panelBotones = new JPanel();
        JButton btnCargarCSV = new JButton("Cargar CSV");
        JButton btnLogout = new JButton("Cerrar Sesion");

        //Acción de cargar CSV

        btnCargarCSV.addActionListener(e-> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Seleccionar archivo CSV");
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                String path = fileChooser.getSelectedFile().getAbsolutePath();
                ventanaPrincipal.getControlador().cargarCSV(path);
                // Actualizar contador
                String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
                int actual = ventanaPrincipal.getControlador().getInscripcionesPendientes();
                txtConsola.append("[Carga CSV] Inscripciones Pendientes: " + actual + " [" + timeStamp + "]\n");
                txtConsola.setCaretPosition(txtConsola.getDocument().getLength());
            }
        });

        //Cerrar sesion y detener hilos

        btnLogout.addActionListener(e-> {
            detenerHilos();
            ventanaPrincipal.cambiarVista("Login");
        });

        panelBotones.add(btnCargarCSV);
        panelBotones.add(btnLogout);
        add(panelBotones, BorderLayout.SOUTH);


    }

    //Método que debemos llamar justo cuando se muestea este panel
    public void iniciarHilos()
    {
        txtConsola.setText("Iniciando Monitoreo de Hilos...\n");
        tareaInscripciones = new HiloInscripciones(txtConsola, ventanaPrincipal.getControlador());
        hiloInscripciones = new Thread(tareaInscripciones);
        hiloInscripciones.start(); //Iniciamos la ejecución en segundo plano
    }

    public void detenerHilos()
    {
        if(tareaInscripciones != null)
        {
            tareaInscripciones.detener(); // cambia de activo a false
            hiloInscripciones.interrupt(); //interrumpe el sleep
        }
    }
}
