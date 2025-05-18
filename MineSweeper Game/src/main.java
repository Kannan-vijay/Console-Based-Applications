import java.util.Random;
import java.util.Scanner;

public class main {
    public static char[][] originalBoard = new char[5][5]; // For checking the board
    public static char[][] duplicateBoard = new char[5][5]; // For showing to the User
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        initialize();
        displayBoard(duplicateBoard);

        while (true) {

            //Get the Row And Coloumn From the Player
            System.out.println("\nEnter the Row And Coloumn To Open (ROW COL)(1 - 5):");
            int row = sc.nextInt();
            int col = sc.nextInt();

            //Check the Opening Card was Mine. it Is Mine then Game Was Ended
            if (openCard(row - 1, col - 1)) {
                displayBoard(originalBoard);
                System.out.println("\nThe Opened Card Was Mine..!!");
                System.out.println("Game Over...!!!!!");
                break;
            }

            // if that is not mine then Continue the Game...
            displayBoard(duplicateBoard);
        }
        
        sc.close();
        
    }

    static boolean openCard(int row,int col){

        //to prevent Index Out Of Bound Error...
        if (row < 0 || row > 4 || col < 0 || col > 4) {
            System.out.println("\nThat is Invalid Move...");
            System.out.println("Enter the Number With in the Range..");
            return false;
        }

        // the opening Card was Mine then Game over
        if (originalBoard[row][col] == 'M') {
            return true;
        }

        //Open the Coresponding card
        duplicateBoard[row][col] = originalBoard[row][col];

        return false;
    }


    static void displayBoard(char[][] board){
        for (int i = 0; i < board.length * 6; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board.length; j++) {
                System.out.printf("%3s  |",board[i][j]);
            }
            System.out.println();
            for (int j = 0; j < board.length * 6; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }


    static void initialize(){
        //Duplicate Board Initialization
        for (int i = 0; i < duplicateBoard.length; i++) {
            for (int j = 0; j < duplicateBoard.length; j++) {
                duplicateBoard[i][j] = '?';
            }
        }

        //Original Board Intializaton
        Random r = new Random();
        int n = originalBoard.length;

        //Random Number Character Intialization
        for (int i = 0; i < originalBoard.length; i++) {
            for (int j = 0; j < originalBoard.length; j++) {
                int num = r.nextInt(10);  //Generate Number 0 - 9
                originalBoard[i][j] = (char) ('0' + num);
            }
        }
        
        //10 Mine Intialization In random Places
        int count = 0;
        while (count < 10) {
            int row = r.nextInt(n); // generate number 0 - n-1
            int col = r.nextInt(n);
            if (originalBoard[row][col] != 'M') {
                originalBoard[row][col] = 'M';
                count++;
            }
        }
    }
}
