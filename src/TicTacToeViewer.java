import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * TicTacToe
 * (TicTacToe, TicTacToeViewer, & Square)
 *
 * Built by Annie Virsik on January 7, 2024
 *
 * This program runs a tictactoe game.
 */

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    // Instance Variables
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private Square[][] board;

    // Constructor
    public TicTacToeViewer(Square[][] board) {
        // Setup the window and the buffer strategy.
        this.board = board;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe Board");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        // Draw axis
        g.setColor(Color.red);
        g.setFont(new Font("Serif", Font.PLAIN, 50));
    }
}
