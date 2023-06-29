import java.util.Scanner;

public class Anti4{
    private char[][] board;
    private char cPlayer;

    public static void main(String[] args){
        Anti4 game =new Anti4();
        game.play();
    }
    public Anti4(){
        board = new char[4][4];
        cPlayer = 'X';
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = ' ';
            }
        }
    }
    //method to print the current state of gameboard
    public void printBoard(){
        System.out.println("  1 2 3 4");
        for(int i = 0; i < board.length; i++){
            System.out.print(i+1 + " ");
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    //method to make a move
    public void makeMove(int row,int col){
        if(row>=0 && row<board.length && col>=0 && col < 4 && board[row][col]==' '){
            board[row][col]=cPlayer;
            if(cPlayer=='X'){cPlayer='O';}else{cPlayer='X';}   
        }
        else{
            System.out.println("invalide move. Try again.");
        }
    }
    public void play(){
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            printBoard();
            System.out.println("Player " + cPlayer + " make your move. Please Enter the row number between 0 and"+board.length);
            int row = scanner.nextInt();
            if(row<board.length){
            System.out.println("Player " + cPlayer + " make your move. Please Enter the column number between 0 and"+board[row].length);}
            int col=scanner.nextInt();
            if(col<board[row].length){
            makeMove(row,col);
            char winner =checkWinner();
            if(winner!=' '){
                printBoard();
                System.out.println("Player " + winner + " wins!");
                break;
            }
            }
            else{System.out.println("Number out of bounds. Please try again.");}
        }
        scanner.close();
    }

}