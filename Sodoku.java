/**
 Abel Lagonell
 U000001730
 Jan 16, 2025
 <p>
 The data class for Sodoku, storing the board itself as a variable
 */
public class Sodoku {

    private int[][] board = new int[9][9];

    /**
     Constructor of the Sodoku board

     @param array The actual board
     */
    Sodoku (int[][] array) {
        board = array;
    }

    /**
     Displays the current board state
     */
    public void display () {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
                if ((j + 1) % 3 == 0 && j != 8) System.out.print("| ");
            }
            System.out.println();
            if ((i + 1) % 3 == 0 && i != 8) System.out.println("------+-------+------");
        }
    }


    /**
     Gives the user if there is no more zeroes on the board

     @return True when there remains zeroes on the board
     */
    boolean isSolved () {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        return true;
    }

    /**
     Validating the number given

     @return True if it is between 1-9
     */
    boolean isValueValid (int value) {
        return value >= 1 && value <= 9;
    }


    /**
     Validating that the coordinate can be changed.

     @return True if value  is equal to 0
     */
    boolean isRowColumnValid (int row, int col) {
        return board[row][col] == 0;
    }

    /**
     Checks if row, column, and box do not contain the given value.

     @return True if the value being inputted is unique
     */
    boolean isEntryCorrect (int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) return false;
            if (board[i][col] == value) return false;
        }
        int row_offset = row / 3;
        int col_offset = col / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[row_offset * 3 + i][col_offset * 3 + j] == value) return false;
            }
        }

        board[row][col] = value;
        return true;
    }
}
