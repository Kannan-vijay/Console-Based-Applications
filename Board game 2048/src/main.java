import java.util.Random;
import java.util.Scanner;

public class main {
    public static Random r = new Random();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[][] board = new String[4][4];
        initialize(board);
        while (true) {
            displayBoard(board);
            System.out.println("\n Enter move ( UP/DOWN/LEFT/RIGHT ) :");
            String move = sc.nextLine().toUpperCase();
            switch (move) {
                case "UP":
                    upMove(board);
                    break;
                case "DOWN":
                    downMove(board);
                    break;
                case "LEFT":
                    leftMove(board);
                    break;
                case "RIGHT":
                    rightMove(board);
                    break;
                default:
                    break;
            }
            placeNumber(board);
            if (checkBoard(board)) {
                System.out.println("There is No possible Move Available..");
                System.out.println("The game Was ended..!!");
                break;
            }
        }
        sc.close();

    }
    static void placeNumber(String[][] board){
        String[] nums = {"2","4"};
        int count = 0;
        while(count < 1) {
            int row = r.nextInt(4);
            int col = r.nextInt(4);
            int idx = r.nextInt(2);
            if(board[row][col].equals(" ")){
                board[row][col] = nums[idx];
                count++;
            }
        }
    }
    static boolean checkBoard(String[][] board){
        int n = board.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!board[i][j].equals(" ")){
                    count++;
                }
            }
        }
        return count == n * n;
    }
    static void downMove(String[][] board){
        int n = board.length;
        for (int col = 0; col < n; col++) {
            int swapIdx = n-1;
            for (int row = n - 1; row >= 0; row--) {
                if (!board[row][col].equals(" ")) {
                    if (swapIdx < n-1 && board[swapIdx + 1][col].equals(board[row][col])) {
                        board[swapIdx + 1][col] = Integer.toString(Integer.parseInt(board[swapIdx + 1][col]) * 2);
                        board[row][col] = " ";
                    }
                    else{
                        String temp = board[row][col];
                        board[row][col] = board[swapIdx][col];
                        board[swapIdx][col] = temp;
                        swapIdx--;
                    }
                }
            }
        }
    }
    static void upMove(String[][] board){
        int n = board.length;
        for (int col = 0; col < n; col++) {
            int swapIdx = 0;
            for (int row = 0; row < n; row++) {
                if (!board[row][col].equals(" ")) {
                    if (swapIdx > 0 && board[swapIdx - 1][col].equals(board[row][col])) {
                        board[swapIdx - 1][col] = Integer.toString(Integer.parseInt(board[swapIdx - 1][col]) * 2);
                        board[row][col] = " ";
                    }
                    else{
                        String temp = board[row][col];
                        board[row][col] = board[swapIdx][col];
                        board[swapIdx][col] = temp;
                        swapIdx++;
                    }
                }
            }
        }
    }
    static void rightMove(String[][] board){
        int n = board.length;
        for (int i = 0; i < board.length; i++) {
            int l = board[i].length-1;
            for (int j = board[i].length -1 ; j >= 0; j--) {
                if (!board[i][j].equals(" ")) {
                    if (l<n-1 && board[i][l+1].equals(board[i][j])) {
                        board[i][l+1] = Integer.toString(Integer.parseInt(board[i][l+1]) * 2);
                        board[i][j] = " ";
                    }
                    else{
                        String temp = board[i][l];
                        board[i][l] = board[i][j];
                        board[i][j] = temp;
                        l--;
                    }
                }
            }
        }
    }
    static void leftMove(String[][] board){
        for (int i = 0; i < board.length; i++) {
            int l = 0;
            for (int j = 0; j < board[0].length; j++) {
                if (!board[i][j].equals(" ")) {
                    if (l>0 && board[i][l-1].equals(board[i][j])) {
                        board[i][l-1] = Integer.toString(Integer.parseInt(board[i][l-1]) * 2);
                        board[i][j] = " ";
                    }
                    else{
                        String temp = board[i][l];
                        board[i][l] = board[i][j];
                        board[i][j] = temp;
                        l++;
                    }
                }
            }
        }
    }
    static void displayBoard(String[][] board){
        for (int i = 0; i < board.length*6; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf("%3s  |",board[i][j]);
            }
            System.out.println();
            for (int j = 0; j < board.length*6; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        
    }
    static void initialize(String[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = " ";
            }
        }
        String[] nums = {"2","4"};
        int count = 0;
        while(count < 2) {
            int row = r.nextInt(4);
            int col = r.nextInt(4);
            int idx = r.nextInt(2);
            if(board[row][col].equals(" ")){
                board[row][col] = nums[idx];
                count++;
            }
        }
    }
}
