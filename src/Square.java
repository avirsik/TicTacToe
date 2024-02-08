import java.awt.*;
/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 * Edited by Annie Virsik January 7, 2024
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;
    public TicTacToeViewer window;
    private Image oImage;
    private Image xImage;
    public static final int SIDE_LENGTH = 150;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer window) {
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;

        this.window = window;

        oImage = window.getXOs()[0];
        xImage = window.getXOs()[1];
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    // Getter for isWinningSquare
    public boolean getIsWinningSquare() {
        return this.isWinningSquare;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    // pass reference into square (parameter/instance variable)
    public void draw(Graphics g) {
        if (marker.equals(TicTacToe.O_MARKER)) {
//            g.drawImage(oImage, row, col, SIDE_LENGTH, SIDE_LENGTH, this.window);
            g.drawImage(oImage, window.START_X + (col * window.SQUARE_SIZE), window.START_Y + (row* window.SQUARE_SIZE), SIDE_LENGTH, SIDE_LENGTH, this.window);
        }
        else if (marker.equals(TicTacToe.X_MARKER)) {
//            g.drawImage(xImage, row, col, SIDE_LENGTH, SIDE_LENGTH, this.window);
            g.drawImage(xImage, window.START_X + (col * window.SQUARE_SIZE), window.START_Y + (row * window.SQUARE_SIZE), SIDE_LENGTH, SIDE_LENGTH, this.window);
        }
    }

}

