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
            char lost =checkScore();
            if(lost!=' '){
                printBoard();
                System.out.println("Player " + lost + " Lost");
                break;
            }
            }
            else{System.out.println("Number out of bounds. Please try again.");}
        }
        scanner.close();
    }
    public char checkScore(){
       //rows
       char r=checkrow();
       char d=checkDiag();
       if(r==d){
        return r;
       }
       else if(r==' '&&d!=' '){return d;}
       else{return ' ';}
    }
    public char checkrow(){
        //rows
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2] ) {
                return board[i][0];
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i] ) {
                return board[0][i];
            }
        }
        // No winner yet
        return ' ';
    }
    public char checkDiag(){
        // Check diagonals
        for(int y=0;y+2<board.length; y++){
            for(int x=0;x+2<board[y].length;x++){
                if (board[y][x] != ' ' && board[y][x] == board[y+1][x+1] && board[y+1][x+1] == board[y+2][x+2] ) {
                return board[y][x];
            }
            }
        }
         for(int y=board.length-1;y>2; y--){
            for(int x=0;x+2<board[y].length; x++){
                if (board[y][x] != ' ' && board[y][x] == board[y-1][x+1] && board[y-1][x+1] == board[y-2][x+2] ) {
                return board[y][x];
            }
            }
        }
        return ' ';
    }


}