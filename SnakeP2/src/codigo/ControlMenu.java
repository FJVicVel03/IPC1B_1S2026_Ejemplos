/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.MenuDatos;
import modelo.Record;
import modelo.RecordsManager;
import vista.Menu;
import vista.Snake;

/**
 *
 * @author Fernando Vicente
 */
public class ControlMenu implements ActionListener{
    private final Menu menu;
    private final Snake snake;
    private final ControlSnake controlSnake;
    private final RecordsManager recordsManager = new RecordsManager();

    public ControlMenu(Menu menu, Snake snake, ControlSnake controlSnake) {
        this.menu = menu;
        this.snake = snake;
        this.controlSnake = controlSnake;

        this.menu.btnJugar.addActionListener(this);
        this.menu.btnRecord.addActionListener(this);
    }

    private MenuDatos obtenerConfiguracionSeleccionada() {
        String dificultadSeleccionada = menu.cmbDificultad.getSelectedItem().toString().trim();
        String dificultadNormalizada = dificultadSeleccionada.toLowerCase().replace(" ", "");

        MenuDatos datos = new MenuDatos();
        datos.setDificultad(dificultadSeleccionada);

        switch (dificultadNormalizada) {
            case "facil":
                datos.setCeldas(12);
                datos.setVelocidadTexto("Lento");
                datos.setVelocidadMs(400);
                break;
            case "medio":
                datos.setCeldas(16);
                datos.setVelocidadTexto("Normal");
                datos.setVelocidadMs(250);
                break;
            case "dificil":
                datos.setCeldas(20);
                datos.setVelocidadTexto("Rapido");
                datos.setVelocidadMs(150);
                break;
            default:
                datos.setCeldas(15);
                datos.setVelocidadTexto("Normal");
                datos.setVelocidadMs(250);
                break;
        }

        return datos;
    }

    private void mostrarRecords() {
        java.util.List<Record> records = recordsManager.cargar();
        if (records.isEmpty()) {
            JOptionPane.showMessageDialog(menu, "No hay records guardados.", "Records", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Top records\n\n");
        int limite = Math.min(10, records.size());
        for (int i = 0; i < limite; i++) {
            Record r = records.get(i);
            sb.append(i + 1)
              .append(". ")
              .append(r.getNombre())
              .append(" - ")
              .append(r.getPuntaje())
              .append(" pts (")
              .append(r.getDificultad())
              .append(") ")
              .append(r.getFecha())
              .append("\n");
        }

        JOptionPane.showMessageDialog(menu, sb.toString(), "Records", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == menu.btnJugar) {
            MenuDatos configuracion = obtenerConfiguracionSeleccionada();
            controlSnake.prepararTablero(configuracion);
            snake.setVisible(true);
            snake.requestFocusInWindow();
            return;
        }

        if (source == menu.btnRecord) {
            mostrarRecords();
        }
    }
}
