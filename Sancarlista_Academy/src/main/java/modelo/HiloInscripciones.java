package modelo;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import controlador.AppController;

public class HiloInscripciones implements Runnable{
    private boolean activo;
    private JTextArea areaConsola;
    private AppController controlador;

    public HiloInscripciones(JTextArea areaConsola, AppController controlador) {
        this.areaConsola = areaConsola;
        this.controlador = controlador;
        this.activo = true;
    }

    //Método para detener el hilo d eforma segura cuando cerramos la sesión del usuario activo
    public void detener()
    {
        this.activo = false;
    }

    @Override
    public void run()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        while(activo)
        {
            try
            {
                int cantidad = controlador.getInscripcionesPendientes();
                String timeStamp = sdf.format(new Date());

                //formato que nos menciona el enunciado
                String mensaje = "[Thread-Inscripciones] Inscripciones Pendientes: " + cantidad + " - Procesando ... [" + timeStamp + "]\n";

                //SwingUtilites.invokeLater asegura que sí se modifique la GUI (interfaz gráfica pues) de forma segura
                SwingUtilities.invokeLater(() -> {
                    areaConsola.append(mensaje);
                    //AUTO-SCROLL hacia abajo

                    areaConsola.setCaretPosition(areaConsola.getDocument().getLength());
                });

                //Pausamos el hilo por 8 segundos
                Thread.sleep(8000);

                //Simulación de que el sistema procesa una inscripción
                modelo.Inscripcion procesada = controlador.procesarInscripcion();
                if (procesada != null) {
                    String mensajeProcesada = "[Thread-Inscripciones] Procesada: " + procesada.getNombre() + " (" + procesada.getCodigo() + ") [" + timeStamp + "]\n";
                    SwingUtilities.invokeLater(() -> {
                        areaConsola.append(mensajeProcesada);
                        areaConsola.setCaretPosition(areaConsola.getDocument().getLength());
                    });
                }
            }catch(InterruptedException e)
            {
                JOptionPane.showMessageDialog(null,
                        "Error al iniciar el Inscripciones", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            }

        }
    }
}
