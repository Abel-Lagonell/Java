import java.util.Scanner;

/**
 Abel Lagonell
 U000001730
 Jan 23, 2025
 <p>
 A fun game of sodoku given a single board.
 */
public class Driver {
    static boolean isPlaying = true;
    static Sodoku sodoku;

    /**
     Main function to play sodoku
     */
    public static void main (String[] args) {
        sodoku = new Sodoku(new int[][]
                {{5, 3, 4, 0, 7, 8, 9, 1, 2},
                        {6, 7, 0, 1, 9, 5, 3, 4, 8},
                        {1, 9, 8, 3, 4, 2, 5, 0, 7},
                        {8, 0, 9, 7, 6, 1, 4, 2, 3},
                        {4, 2, 6, 8, 0, 3, 7, 9, 0},
                        {7, 1, 3, 9, 2, 4, 8, 5, 6},
                        {9, 0, 1, 5, 3, 7, 2, 8, 4},
                        {2, 8, 7, 4, 1, 9, 6, 0, 5},
                        {3, 4, 5, 2, 8, 6, 1, 7, 9}}
        );

        System.out.println("Welcome to Sodoku!");
        Scanner in = new Scanner(System.in);
        do {
            sodoku.display();

            int col, row, num;
            col = inputValueInt("Please choose the column: (1-9)");
            row = inputValueInt("Please choose the row: (1-9)");
            if (sodoku.isValueValid(row) && sodoku.isValueValid(col)) {
                row--;
                col--;
                if (sodoku.isRowColumnValid(row, col)) {
                    num = inputValueInt("Please choose the number to input: (1-9)");
                    if (sodoku.isValueValid(num)) {
                        if (sodoku.isEntryCorrect(row, col, num)) {
                            System.out.println("Correct!");
                            if (sodoku.isSolved()) break;
                        } else {System.out.println("NOT Correct!");}
                    } else {System.out.println("Invalid value!");}
                } else {
                    System.out.println("Wrong Entry");
                }

            } else {
                System.out.println("Invalid row/column!");
            }

            System.out.println("Continue Playing (Y/N)");
            String answer;
            do {
                answer = in.nextLine();
                if (answer.equals("N")) {
                    isPlaying = false;
                    break;
                }
                if (answer.equals("Y")) break;
                System.out.println("Please enter (Y/N)");
            } while (true);
        } while (isPlaying);

        System.out.println("Thank you for playing!");
    }

    /**
     Helper Function for input of int

     @param prompt String input for the prompting of the user
     */
    private static int inputValueInt (String prompt) {
        int value;
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        value = input.nextInt();

        return value;
    }

}
