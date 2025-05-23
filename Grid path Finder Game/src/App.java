import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int pathSum = 0;
        int[][] board = new int[5][5];
        initialize(board);
        displayBoard(board);
        int[] position = new int[2];
        while (true) {
            System.out.println("Enter the Move (L/R/U/D) :");
            char direction = sc.next().charAt(0);   // Get the Moving Direction from the PLayer
            direction = Character.toUpperCase(direction);
            int response = move(board, direction, position); // Get the Response for to Check the Move is Valid or Not
            if (response == 0) {
                System.out.println("Invalid Move..!!");
                continue;
            }
            pathSum += response;
            if (position[0] == 4 && position[1] == 4) {     // check the Game Was Ended or Not
                System.out.println("Your Travelling Distance Points is :"+pathSum);
                System.out.println("Completed the Game...!!");
                break;
            }
            displayBoard(board);
        }
        sc.close();
    }
    static int move(int[][] board,char direction,int[] position){
        int row = position[0];
        int col = position[1];

        //Move to Left
        if (direction == 'L') {
            if(col == 0 || board[row][col-1] == 23){
                return 0;
            }
            else{
                int value =  board[row][col-1];
                 board[row][col-1] = 18;
                 position[1]--;
                return value;
            }
        }

        // Move to Right
        else if(direction == 'R'){
            if(col == board.length-1 || board[row][col+1] == 23){
                System.out.println("Invalid Move..");
                return 0;
            }
            else{
                int value = board[row][col+1];
                board[row][col+1] = 18;
                position[1]++;
                return value;
            }
        }

        // Move to Up
        else if(direction == 'U'){
            if(row == 0 || board[row-1][col] == 23){
                System.out.println("Invalid Move..");
                return 0;
            }
            else{
                int value = board[row-1][col];
                board[row-1][col] = 18;
                position[0]--;
                return value;
            }
        }

        //Move to Down
        else{
            if(row == board.length-1 || board[row+1][col] == 23){
                System.out.println("Invalid Move..");
                return 0;
            }
            else{
                int value = board[row+1][col];
                board[row+1][col] = 18;
                position[0]++;
                return value;
            }
        }
    }
    static void displayBoard(int[][] board) {
        for (int i = 0; i < board.length * 6; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 5) {
                    char ch = (char) ('A' + (board[i][j]));
                    System.out.printf("%3s  |", ch);
                } else {
                    System.out.printf("%3d  |", board[i][j]);
                }
            }
            System.out.println();
            for (int j = 0; j < board.length * 6; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    static void initialize(int[][] board) {
        Random r = new Random();
        int n = board.length;

        // Initialize board with random Numbers
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int randomNum = r.nextInt(5); // Random Number 0 - 5
                board[i][j] = randomNum + 1; // 1 - 5
            }
        }

        // plaxe the Wall using X character Number in random position
        int Xnumber = 23;
        int count = 0;
        while (count < 6) {
            int row = r.nextInt(n);
            int col = r.nextInt(n);
            if (checkPosition(row, col, board)) {
                board[row][col] = Xnumber;
                count++;
            }
        }

        // Define Start and End Place in the Board with S and G character
        board[0][0] = 18;// define S letter
        board[n - 1][n - 1] = 6; // define G letter
    }

    static boolean checkPosition(int row, int col, int[][] board) {
        if (row > 0 && board[row - 1][col] == 23) {
            return false;
        } else if (row < 4 && board[row + 1][col] == 23) {
            return false;
        } else if (col > 0 && board[row][col - 1] == 23) {
            return false;
        } else if (col < 4 && board[row][col + 1] == 23) {
            return false;
        }
        return true;
    }
}
