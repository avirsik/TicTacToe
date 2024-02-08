import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * TicTacToeViewer - The front end of a TicTacToe game
 * Built by Annie Virsik on January 7, 2024
 * This program runs a TicTacToe game.
 */

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;

    // Values used for painting the window
    public static final int SQUARE_SIZE = 150;
    public static final int START_X = 250;          // x value at the starting point of the grid
    public static final int START_Y = 200;          // y value [...]
    public static final int NUM_START_X = 315;      // x value at the starting point of the axis numbers
    public static final int NUM_START_O = 300;      // y value [...]
    private Image[] XOs;
    private TicTacToe t;

    // Constructor that sets up the window and creates the x and o images
    public TicTacToeViewer(TicTacToe t) {
        this.t = t;

        this.XOs = new Image[2];
        XOs[0] = new ImageIcon("Resources/O.png").getImage();
        XOs[1] = new ImageIcon("Resources/X.png").getImage();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe Board");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    // Getter for array that holds the images
    public Image[] getXOs() {
        return this.XOs;
    }


    // Paints the window including the TicTacToe grid and draws each x and o as the game is run
    public void paint(Graphics g) {
        // Fill background white (this is to account for problem with windows computer)
        g.setColor(Color.white);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        // Draws axis numbers
        drawAxisNumbers(g);
        // Draw black lines
        drawBlackLines(g);
        // Each square draws an x or o as the game runs. Each time, it checks to see if someone has won and executes the printWin() method if so
        for (int i = 0; i < t.getBoard().length; i++) {
            for (int j = 0; j < t.getBoard()[i].length; j++) {
                t.getBoard()[i][j].draw(g);
                printWin(g);
            }
        }
    }

    // Draws axis numbers
    public void drawAxisNumbers(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("Serif", Font.PLAIN, 50));
        // Horizontal line of numbers
        g.drawString("0", NUM_START_X, 150);
        g.drawString("1", NUM_START_X+145, 150);
        g.drawString("2", NUM_START_X+290, 150);
        // Vertical line of numbers
        g.drawString("0", 120, NUM_START_O);
        g.drawString("1", 120, NUM_START_O+150);
        g.drawString("2", 120, NUM_START_O+300);
    }

    // Draws black squares that form the TicTacToe grid
    public void drawBlackLines(Graphics g) {
        // Draws column 0
        g.setColor(Color.black);
        g.drawRect(START_X, START_Y, SQUARE_SIZE, SQUARE_SIZE);
        g.drawRect(START_X, START_Y+150, SQUARE_SIZE, SQUARE_SIZE);
        g.drawRect(START_X, START_Y+300, SQUARE_SIZE, SQUARE_SIZE);
        // Draws column 1
        g.drawRect(START_X+150, START_Y, SQUARE_SIZE, SQUARE_SIZE);
        g.drawRect(START_X+150, START_Y+150, SQUARE_SIZE, SQUARE_SIZE);
        g.drawRect(START_X+150, START_Y+300, SQUARE_SIZE, SQUARE_SIZE);
        // Draws column 2
        g.drawRect(START_X+300, START_Y, SQUARE_SIZE, SQUARE_SIZE);
        g.drawRect(START_X+300, START_Y+150, SQUARE_SIZE, SQUARE_SIZE);
        g.drawRect(START_X+300, START_Y+300, SQUARE_SIZE, SQUARE_SIZE);
    }

    // Prints the win (or tie) statement
    public void printWin(Graphics g) {
        if (t.getWinner().equals(TicTacToe.O_MARKER)) {
            // Draw green squares
            this.drawGreenSquares(g);
            // Redraw black lines
            this.drawBlackLines(g);
            // Winner displayed
            g.setColor(Color.black);
            g.setFont(new Font("Serif", Font.PLAIN, 100));
            g.drawString("O Wins", 325, 750);
        }
        else if (t.getWinner().equals(TicTacToe.X_MARKER)) {
            // Draw green squares
            this.drawGreenSquares(g);
            // Redraw black lines
            this.drawBlackLines(g);
            // Winner displayed
            g.setColor(Color.black);
            g.setFont(new Font("Serif", Font.PLAIN, 100));
            g.drawString("X Wins", 325, 750);
        }
        // If the game ends in a tie, it displays this
        else if (t.getWinner().equals(TicTacToe.BLANK) && t.getGameOver()) {
            g.setColor(Color.black);
            g.setFont(new Font("Serif", Font.PLAIN, 100));
            g.drawString("It's a Tie", 320, 750);
        }
    }

    // Draws green squares for the winning player, looping through each square and checking if it is a winning square.
    // If the square is, it draws a green rectangle and redraws the x and o on top.
    public void drawGreenSquares(Graphics g) {
        for (int i = 0; i < t.getBoard().length; i++) {
            for (int j = 0; j < t.getBoard()[i].length; j++) {
                if (t.getBoard()[i][j].getIsWinningSquare()) {
                    g.setColor(Color.green);
                    // Algorithm that calculates the left corner of the winning square and draws a green square. Then an x/o is redrawn on top
                    g.fillRect(j*SQUARE_SIZE + START_X, i*SQUARE_SIZE + START_Y, SQUARE_SIZE, SQUARE_SIZE);
                    t.getBoard()[i][j].draw(g);
                }
            }
        }
    }
}
