/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modelo.MenuDatos;
import modelo.RecordsManager;
import vista.Snake;

/**
 *
 * @author Fernando Vicente
 */
public class ControlSnake {
    private final Snake snake;
    private PanelFondo fondo;
    private Timer timer;
    private List<Point> cuerpo = new ArrayList<>();
    private Direction direccion = Direction.RIGHT;
    private int celdas = 15;
    private final Random random = new Random();
    private Point comida;
    private int puntaje = 0;
    private final RecordsManager recordsManager = new RecordsManager();

    public ControlSnake(Snake snake) {
        this.snake = snake;
        this.snake.PSnake.setLayout(new BorderLayout());
        configurarControles();
    }

    public void prepararTablero(MenuDatos configuracion) {
        if (timer != null) {
            timer.stop();
        }

        if (fondo != null) {
            snake.PSnake.remove(fondo);
        }

        this.celdas = configuracion.getCeldas();
        fondo = new PanelFondo(celdas);
        snake.lblDif.setText(configuracion.getDificultad());
        snake.lblTam.setText(celdas + " x " + celdas);
        snake.lblVel.setText(configuracion.getVelocidadTexto());
        puntaje = 0;

        direccion = Direction.RIGHT;
        cuerpo = serpienteInicial(celdas);
        comida = generarComida();
        fondo.setSnakePositions(cuerpo);
        fondo.setFood(comida);

        snake.PSnake.add(fondo, BorderLayout.CENTER);
        snake.PSnake.revalidate();
        snake.PSnake.repaint();

        iniciarTimer(configuracion.getVelocidadMs());
        snake.requestFocusInWindow();
        snake.PSnake.requestFocusInWindow();
    }

    private List<Point> serpienteInicial(int celdas) {
        List<Point> cuerpo = new ArrayList<>();
        int centro = celdas / 2;
        // cabeza y dos segmentos hacia la izquierda
        cuerpo.add(new Point(centro, centro));
        cuerpo.add(new Point(centro - 1, centro));
        cuerpo.add(new Point(centro - 2, centro));
        return cuerpo;
    }

    private void iniciarTimer(int delayMs) {
        timer = new Timer(Math.max(50, delayMs), e -> avanzar());
        timer.start();
    }

    private void avanzar() {
        if (cuerpo.isEmpty()) {
            return;
        }

        Point cabeza = cuerpo.get(0);
        Point siguiente = new Point(cabeza.x + direccion.dx, cabeza.y + direccion.dy);
        siguiente = envolver(siguiente);

        boolean crece = comida != null && siguiente.equals(comida);

        if (colisionaConCuerpo(siguiente, crece)) {
            timer.stop();
            mostrarGameOver();
            return;
        }

        cuerpo.add(0, siguiente);
        if (!crece) {
            cuerpo.remove(cuerpo.size() - 1);
        } else {
            puntaje++;
            comida = generarComida();
            fondo.setFood(comida);
        }

        fondo.setSnakePositions(cuerpo);
    }

    private Point envolver(Point p) {
        int x = (p.x + celdas) % celdas;
        int y = (p.y + celdas) % celdas;
        return new Point(x, y);
    }

    private Point generarComida() {
        Set<Point> ocupados = new HashSet<>(cuerpo);
        if (ocupados.size() >= celdas * celdas) {
            return null; // no hay espacio
        }
        Point nueva;
        do {
            nueva = new Point(random.nextInt(celdas), random.nextInt(celdas));
        } while (ocupados.contains(nueva));
        return nueva;
    }

    private boolean colisionaConCuerpo(Point siguiente, boolean crece) {
        int limite = crece ? cuerpo.size() : cuerpo.size() - 1;
        for (int i = 0; i < limite; i++) {
            if (cuerpo.get(i).equals(siguiente)) {
                return true;
            }
        }
        return false;
    }

    private void configurarControles() {
        snake.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (timer == null) {
                    return;
                }
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        cambiarDireccion(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        cambiarDireccion(Direction.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        cambiarDireccion(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        cambiarDireccion(Direction.RIGHT);
                        break;
                }
            }
        });
        snake.PSnake.setFocusable(true);
    }

    private void cambiarDireccion(Direction nueva) {
        if (direccion.esOpuesta(nueva)) {
            return;
        }
        direccion = nueva;
    }

    private void mostrarGameOver() {
        String mensaje = "Perdiste.\nPuntaje: " + puntaje + "\n¿Quieres guardar tu record?";
        int opcion = JOptionPane.showConfirmDialog(snake, mensaje, "Juego terminado", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            String nombre = JOptionPane.showInputDialog(snake, "Ingresa tu nombre:", "Guardar record", JOptionPane.PLAIN_MESSAGE);
            if (nombre != null) {
                nombre = nombre.trim();
                if (nombre.isEmpty()) {
                    nombre = "Jugador";
                }
                recordsManager.guardar(nombre, puntaje, snake.lblDif.getText());
            }
        }
    }

    private enum Direction {
        UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);

        final int dx;
        final int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        boolean esOpuesta(Direction otra) {
            return (dx + otra.dx == 0) && (dy + otra.dy == 0);
        }
    }
}
