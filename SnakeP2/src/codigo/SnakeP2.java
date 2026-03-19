/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package codigo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Menu;
import vista.Snake;

/**
 *
 * @author Fernando Vicente
 */
public class SnakeP2{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Menu menu = new Menu();
            Snake snake = new Snake();

            ControlSnake controlSnake = new ControlSnake(snake);
            new ControlMenu(menu, snake, controlSnake);

            menu.setVisible(true);
        });
    }


    
}
