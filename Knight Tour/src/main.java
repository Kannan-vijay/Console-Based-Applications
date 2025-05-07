import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[8][8];
        ArrayList<ArrayList<Integer>> moves = new ArrayList<>();
        initialize(board);
        displayBoard(board);
        moves = findPosibleMoves(board, 7, 0);
        while (true) {
            if (moves.size() == 0) {
                System.out.println("There is No possible Moves Available..!!!");
                System.out.println("The Game was ended You Lose..");
                break;
            }

            System.out.println("Available Moves Are ("+moves+")");
            System.out.println("Enter the Move (ROW COL):");
            int row = sc.nextInt();
            sc.nextLine();
            int col = sc.nextInt();
            sc.nextLine();
            if(placeKnight(board, row, col)){
                System.out.println("Congratulations..!!! You Win the Game..");
                break;
            }
            moves = findPosibleMoves(board, row, col);
        }   
        sc.close();
    }

    static void initialize(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
        board[7][0] = 'K';
    }

    static boolean placeKnight(char[][] board,int row,int col){
        if(row > 7 || row < 0 || col > 7 || col < 0){
            System.out.println("The places are out of range..");
            return false;
        }
        if (board[row][col] == 'k') {
            System.out.println("The place will be Already occupied..");
            return false;
        }
        
        board[row][col] = 'K';
        displayBoard(board);
        return checkWin(board);
    }

    static boolean checkWin(char[][] board){
        int knightCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 'K'){
                    knightCount++;
                }
            }
        }
        return knightCount == 8*8;
    }
    
    static ArrayList<ArrayList<Integer>> findPosibleMoves(char[][] board,int row,int col){
        ArrayList<ArrayList<Integer>> moves = new ArrayList<>();
        ArrayList<Integer> move = new ArrayList<>();
        int temprow = row+2,tempcol = col+1;
        if (temprow<8 ) {
            tempcol = col+1;
            if (tempcol<8 && board[temprow][tempcol] !='K') {
                move = new ArrayList<>();
                move.add(temprow);move.add(tempcol);
                moves.add(move);
            }
            tempcol = col-1;
            if (tempcol >-1 && board[temprow][tempcol] != 'K'){
                move = new ArrayList<>();
                move.add(temprow);move.add(tempcol);
                moves.add(move);
            }
        }
        tempcol = col+2; 
        if(tempcol < 8 ){
            temprow = row - 1;
            if (temprow>-1 && board[temprow][tempcol] != 'K') {
                move = new ArrayList<>();
                move.add(temprow);move.add(tempcol);
                moves.add(move);
            }
            temprow = row+1;
            if (temprow<8 && board[temprow][tempcol] != 'K') {
                move = new ArrayList<>();
                move.add(temprow);move.add(tempcol);
                moves.add(move);
            }
            
        }
        tempcol = col - 2;
        if(tempcol > -1){
            temprow = row - 1;
            if(temprow>-1 && board[temprow][tempcol] !='K'){
                move = new ArrayList<>();
                move.add(temprow);move.add(tempcol);
                moves.add(move);
            }
            temprow = row + 1;
            if(temprow < 8 && board[temprow][tempcol] !='K'){
                move = new ArrayList<>();
                move.add(temprow);move.add(tempcol);
                moves.add(move);
            }
        }

        temprow = row - 2;
        if (temprow > -1) {
            tempcol = col + 1;
            if (tempcol < 8 && board[temprow][tempcol] != 'K') {
                move = new ArrayList<>();
                move.add(temprow);move.add(tempcol);
                moves.add(move);
            }
            tempcol = col - 1;
            if (tempcol > -1 && board[temprow][tempcol] != 'K') {
                move = new ArrayList<>();
                move.add(temprow);move.add(tempcol);
                moves.add(move);
            }
        }
        return moves;
    }

    static void displayBoard(char[][] board){
        for (int i = 0; i < board.length*5; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf(" %2s |",board[i][j]);
            }
            System.out.println();
            for (int j = 0; j < board.length*5; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        
    }
}
