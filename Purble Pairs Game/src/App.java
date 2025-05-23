import java.util.Random;
import java.util.Scanner;

public class App {
    static char[][] orginalBoard = new char[4][4];
    static char[][] duplicateBoard = new char[4][4];
    static int n = orginalBoard.length;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        initialize(orginalBoard, duplicateBoard);
        int TotalMoves = 24;
        displayBoard(duplicateBoard);
        while (true) {
            int[][] moves = new int[2][2];

            if (TotalMoves <= 0) { // Check the Moves Left or Not
                if (!checkGameEnding()) {
                    System.out.println("You Lose..!!");
                    System.out.println("You dont Have Enough Moves left..!!!");
                    System.out.println("Try Again...!!!");

                } else {
                    System.out.println("Congratulations...!!!");
                    System.out.println("You Win the Game...!!!!");
                }
                break;
            }

            for (int i = 0; i < moves.length; i++) { // Get the Moves from the Player
                System.out.println("Total Moves Available : "+TotalMoves);
                System.out.println("Enter the Row Col to Open the card (1 - 4) (Row Col)");
                int row = sc.nextInt();
                int col = sc.nextInt();
                moves[i][0] = row - 1;
                moves[i][1] = col - 1;
                openCard(row - 1, col - 1);
                TotalMoves--;
            }

            if (checkOpenedCards(moves)) { // Check the Opened Card was Valid
                if (checkGameEnding()) { // Check the Game Was Ended Or Not
                    System.out.println("Congratulations...!!!");
                    System.out.println("You Win the Game...!!!!");
                    break;
                }
            }
            else{
                System.out.println("\nThe opend 2 card is not Same So the board will be Reset...!!!");
            }
            displayBoard(duplicateBoard);
        }
        sc.close();

    }

    static boolean checkGameEnding() {
        int openedCardCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (duplicateBoard[i][j] != ' ') {
                    openedCardCount++;
                }
            }
        }
        return openedCardCount == n * n; // All the Card or Open or Not
    }

    static boolean checkOpenedCards(int[][] moves) {
        // Extract the Last Two move from the moves
        int previousrow = moves[0][0];
        int previouscol = moves[0][1];
        int currentrow = moves[1][0];
        int currentcol = moves[1][1];

        // Check the Move was valid or Not
        if (orginalBoard[previousrow][previouscol] == orginalBoard[currentrow][currentcol]) {
            return true;
        }

        // If the Move is not Valid then Reset the moves
        duplicateBoard[previousrow][previouscol] = ' ';
        duplicateBoard[currentrow][currentcol] = ' ';
        return false;
    }

    static void openCard(int row, int col) {
        // For Index Out of Bound checking
        if (row < 0 || row > n - 1 || col < 0 || col > n - 1) {
            System.out.println("Invalid Card Open..!!!");
            return;
        }
        // Open the Card
        duplicateBoard[row][col] = orginalBoard[row][col];
        displayBoard(duplicateBoard);
    }

    static void displayBoard(char[][] board) {
        for (int i = 0; i < board.length * 6; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf("%3s  |", board[i][j]);
            }
            System.out.println();
            for (int j = 0; j < board.length * 6; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    static void initialize(char[][] orginalBoard, char[][] duplicateBoard) {
        Random r = new Random();
        int n = orginalBoard.length;

        // Initially fill the orginalBoard with White Space and Fill the Duplicate Board
        // with White Space
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                orginalBoard[i][j] = ' ';
                duplicateBoard[i][j] = ' ';
            }
        }

        // Fill the Board with Special Symbols
        char[] symbols = { '@', '#', '$', '%', '&', '!', '∞', '?' };
        for (char symbol : symbols) {
            int fillCount = 0;

            // Fill the Board Two places with same Symbol
            while (fillCount < 2) {
                int row = r.nextInt(n); // Generate Number Between 0 - n-1
                int col = r.nextInt(n);

                if (orginalBoard[row][col] == ' ') { // For to Fill the Symbol in empty Spaces
                    orginalBoard[row][col] = symbol;
                    fillCount++;
                }
            }

        }
    }
}
