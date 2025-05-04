import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Rows and Coloumns (Row  Col) : ");
        int r = sc.nextInt();
        sc.nextLine();
        int c = sc.nextInt();
        sc.nextLine();
        char[][] board = new char[r][c];
        intialize(board);
        while (true) {
            System.out.println("Emter the Coloumn Number (1 - "+c+") :");
            int col = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Color of Balloon (G,R,B,Y,O) : ");
            char color = sc.next().charAt(0);
            sc.nextLine();
            fillBoard(board, col-1, Character.toUpperCase(color));
            System.out.println("Do You Want Continue (Y / N) : ");
            String exit = sc.nextLine();
            if(exit.equalsIgnoreCase("N")){
                break;
            }
        }
        sc.close();
    }


    static void checkBoard(char[][] board,int row,int col,char color){
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if(board[i][col] == color){
                count++;
            }
        }
        if(count == board.length){
            displayBoard(board);
            System.out.println("\nColoumn Will Be Filled with same color So it will be cleared.");
            coloumnRefill(board,col);
            return;
        }
        count = 0;
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == color) {
                count++;
            }
        }
        if (count == board[0].length) {
            displayBoard(board);
            System.out.println("\nRow Will Be Filled with same color So it will be cleared.");
            rowRefill(board, row);
            return;
        }
        count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '-'){
                    count++;
                }
            }
        }
        if(count == board.length * board[0].length){
            displayBoard(board);
            System.out.println("Board Will be Filled So Clearing the board..");
            System.out.println("Replay the Game..");
            intialize(board);
        }
    }
    static void rowRefill(char[][] board,int row){
        for (int i = 0; i < board[0].length; i++) {
            board[row][i] = '-';
        }
    }
    static void coloumnRefill(char[][] board,int col){
        for (int i = 0; i < board.length; i++) {
            board[i][col] = '-';
        }
    }
    static void fillBoard(char[][] board,int col,char color){
        int row = 0;
        while (row < board.length && board[row][col] == '-') {
            row++;
        }
        if (row == 0) {
            displayBoard(board);
            System.out.println("The Coloumn Will be Already Filled..");
            return;

        }
        board[row-1][col] = color;
        checkBoard(board,row-1,col,color);
        displayBoard(board);
    }
    static void displayBoard(char[][] board){
        System.out.println();
        for (int i = 0; i <= board[0].length*6; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf("%3s  |",board[i][j]);
            }
            System.out.println();
            for (int k = 0; k <= board[0].length*6; k++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
    static void intialize(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '-';
            }
        }
    }
}
