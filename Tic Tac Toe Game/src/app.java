import java.util.Scanner;

public class app {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];
        char player = 'O';
        initialize(board);
        displayBoard(board);
        while (true) {
            System.out.println("Player "+player+" Turn..");
            System.out.println("Enter the Row Number (1 - 3) to place :");
            int row = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Coloumn Number (1 - 3) to place : ");
            int col = sc.nextInt();
            sc.nextLine();
            if(placeElement(board, player, row-1, col-1)){
                break;
            }
            player = (player == 'O') ? 'X' : 'O';
        }
        sc.close();
    }
    static boolean checkStatus(char[][] board,int row,int col,char player){
        if((board[row][0] == player && board[row][1] == player && board[row][2] == player) || 
        (board[0][col] == player && board[1][col] == player && board[2][col] == player) ||
        (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
        (board[0][2] == player && board[1][1] == player && board[2][0] == player)){
            return true;
        }
        return false;
    }
    static boolean checkTieStatus(char[][] board){
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] != ' '){
                    count++;
                }
            }
        }
        if (count == 9) {
            System.out.println("The Game Was Tie..!!!");
            System.out.println("Play Again..!!");
            return true;
        }
        return false;
    }
    static boolean placeElement(char[][] board,char player,int row,int col){
        if(board[row][col] != ' '){
            System.out.println("The Place can be Already Occupied by Player : "+board[row][col]);
            displayBoard(board);
            return false;
        }
        board[row][col] = player;
        displayBoard(board);
        if (checkStatus(board, row, col, player)) {
            System.out.println("Congratulations....");
            System.out.println("Player "+player+" Wins the Game..!!!");
            return true;
        }
        if(checkTieStatus(board)){
            return true;
        }
        return false;
    }
    static void displayBoard(char[][] board){
        System.out.println("\n");
        System.out.println("-------------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board.length; j++) {
                System.out.printf("%3s  |",board[i][j]);
            }
            System.out.println();
            System.out.print("-------------------");
            System.out.println();
        }
        System.out.println("\n");
    }
    static void initialize(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ' ';
            }
        }
    }
}
