package controlador;

import vista.VentanaPrincipal;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        // Es buena práctica usar invokeLater para hilos de Swing
        SwingUtilities.invokeLater(() -> {
            try {
                // Opcional: Ajustar el aspecto visual al del sistema operativo
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                // Iniciamos la ventana principal
                // Esta a su vez crea el AppController y carga los datos serializados
                new VentanaPrincipal();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}