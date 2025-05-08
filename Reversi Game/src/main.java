import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[][] originalBoard = new char[8][8];
        char[][] duplicateBoard = new char[8][8];
        initialize(originalBoard);
        emptyInitialize(duplicateBoard);
        int OplayerCardCount = countPlayerCard(originalBoard, 'O');
        int XplayerCardCount = countPlayerCard(originalBoard, 'X');
        char player = 'O';
        displayBoard(duplicateBoard);
        while (true) {
            System.out.println("Player "+player+" Turn..");
            System.out.println("Enter the Row Column of the Card To Open (Row Col) (0 - 7):");
            int row = sc.nextInt();
            sc.nextLine();
            int col = sc.nextInt();
            sc.nextLine();
            if (row < 0 || row > 7 || col < 0 || col > 7) {
                System.out.println("That Is Invalid Move Enter Correct Row Column..");
                continue;
            }
            if (duplicateBoard[row][col] != ' ') {
                System.out.println("The Card Will be Already Opened So Try agin..");
                continue;
            }
            boolean playerChange = openCard(originalBoard, duplicateBoard, row, col, player);
            if (player == 'O') {
                if (OplayerCardCount == countPlayerCard(duplicateBoard, player)) {
                    System.out.println("Player "+player+" Wins the Game..");
                    System.out.println("\nOriginal Board Was..");
                    System.out.println("---------------------------------------------");
                    System.out.println("|               Original Board              |");
                    System.out.println("---------------------------------------------");
                    displayBoard(originalBoard);
                    break;
                }
            }
            else{
                if (XplayerCardCount == countPlayerCard(duplicateBoard, player)) {
                    System.out.println("Player "+player+" Wins the Game..");
                    System.out.println("Original Board Was..");
                    displayBoard(originalBoard);
                    break;
                }
            }
            if (playerChange) {
                player = (player == 'O') ? 'X' : 'O';
            }
        }
        sc.close();
    }
    
    static boolean openCard(char[][] originalBoard,char[][] duplicateBoard,int row,int col,char player){
        duplicateBoard[row][col] = originalBoard[row][col];
        displayBoard(duplicateBoard);
        return originalBoard[row][col] != player;
    }

    static void displayBoard(char[][] board){
        for (int i = 0; i < board.length * 5; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf(" %2s |",board[i][j]);
            }
            System.out.println();
            for (int j = 0; j < board.length * 5; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
    static int countPlayerCard(char[][] board,char player){
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == player) {
                    count++;
                }
            }
        }
        return count;
    }
    static void emptyInitialize(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }
    static void initialize(char[][] board){
        Random r = new Random();
        char[] pieces = {'O','X'};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int randomIdx = r.nextInt(1 - 0 + 1) + 0;
                board[i][j] = pieces[randomIdx];
            }
        }
    }
}
