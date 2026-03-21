/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Fernando Vicente
 */
public class PanelFondo extends JPanel{
    private final Color gridColor = new Color(220, 220, 220);
    private final Color snakeBodyColor = new Color(0, 128, 0);
    private final Color snakeHeadColor = new Color(0, 180, 0);
    private final Color foodColor = new Color(200, 30, 30);
    private final int cells;
    private List<Point> snakeCells = new ArrayList<>();
    private Point food;

    public PanelFondo(int cells) {
        this.cells = Math.max(1, cells);

        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.WHITE);
    }

    public PanelFondo() {
        this(15);
    }

    @Override
    protected void paintComponent(Graphics pintor) {
        super.paintComponent(pintor);

        int cellSize = Math.max(1, Math.min(getWidth(), getHeight()) / cells);
        int boardDrawSize = cellSize * cells;
        int xOffset = (getWidth() - boardDrawSize) / 2;
        int yOffset = (getHeight() - boardDrawSize) / 2;

        pintor.setColor(gridColor);
        // Dibujar la grilla
        for (int y = 0; y <= cells; y++) {
            int py = yOffset + y * cellSize;
            pintor.drawLine(xOffset, py, xOffset + boardDrawSize, py);
        }
        for (int x = 0; x <= cells; x++) {
            int px = xOffset + x * cellSize;
            pintor.drawLine(px, yOffset, px, yOffset + boardDrawSize);
        }

        // Dibujar la serpiente
        for (int i = 0; i < snakeCells.size(); i++) {
            Point p = snakeCells.get(i);
            int px = xOffset + p.x * cellSize;
            int py = yOffset + p.y * cellSize;
            pintor.setColor(i == 0 ? snakeHeadColor : snakeBodyColor);
            pintor.fillRect(px + 1, py + 1, cellSize - 2, cellSize - 2);
        }

        // Dibujar la comida
        if (food != null) {
            int px = xOffset + food.x * cellSize;
            int py = yOffset + food.y * cellSize;
            pintor.setColor(foodColor);
            pintor.fillOval(px + 3, py + 3, cellSize - 6, cellSize - 6);
        }
    }

    public void setSnakePositions(List<Point> snakeCells) {
        this.snakeCells = new ArrayList<>(snakeCells);
        repaint();
    }

    public void setFood(Point food) {
        this.food = food;
        repaint();
    }
}
