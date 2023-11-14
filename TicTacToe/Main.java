
import java.util.Scanner;
public class Main
{
    static int start = 0;
    static String whoWon = new String();
   public static void PrintBoard(){
       Scanner in =  new Scanner(System.in);
     
       String[][] board = new String[3][3];
       for(int row = 0; row < board.length; row++){
           for(int col = 0; col < board.length; col++){
              board[row][col] = "[ ]";
              System.out.print(board[row][col]);
           }
           System.out.println();
       }
        String playerIn = in.nextLine();
       playerTurn(playerIn,board);
   }
    
   public static void playerTurn(String n,String[][] board){
       Scanner in =  new Scanner(System.in);
       String y = n.substring(0,1);
       String x = n.substring(2,3);

       int row = Integer.parseInt(y);
       int col = Integer.parseInt(x);
       if(!(board[row][col].equals("[ ]"))){
           System.out.println("Already Selected make another move");
           String newTurn = in.nextLine();
           playerTurn(newTurn,board);
       }
      board[row][col] = "[" + XO() + "]";
      board(board);
      next(board);
   }
   
   public static String XO(){
       String x = "X";
       String y = "O";
       String ans = new String();
       if(start%2 == 0) ans = x;
       else if(start%2 == 1) ans = y;
       start++;
       return ans;
    }
    
   public static void board(String board[][]){
       for(int z = 0; z < board.length; z++){
           for(int b = 0; b < board.length; b++){
              System.out.print(board[z][b]);
           }
           System.out.println();
       }
      System.out.print(detectWin(board));
   }
   
   public static void next(String[][] board){
       Scanner in =  new Scanner(System.in); 
       String playerIn = in.nextLine();
       playerTurn(playerIn,board);
   }
   
   public static String detectWin(String[][]board){
        boolean winB = false;
       String win = new String();
       boolean XWin = false;
       boolean OWin = false;
        for(int z = 0; z < board.length; z++){
             boolean[] rowX = new boolean[3];
            boolean[] rowO = new boolean[3];
           for(int b = 0; b < board.length; b++){
            if(board[z][b].equals("[X]")) rowX[b] = true;
            else{
                rowX[b] = false;
            }
            if(board[z][b].equals("[O]")) rowO[b] = true;
            else rowO[b] = false;
           }
           if(rowX[0] && rowX[1] && rowX[2]) XWin = true;
           if(rowO[0] && rowO[1] && rowO[2]) OWin = true;
       }
       for(int z = 0; z < board.length; z++){
             boolean[] rowX = new boolean[3];
            boolean[] rowO = new boolean[3];
           for(int b = 0; b < board.length; b++){
            if(board[b][z].equals("[X]")) rowX[b] = true;
            else{
                rowX[b] = false;
            }
            if(board[b][z].equals("[O]")) rowO[b] = true;
            else rowO[b] = false;
           }
           if(rowX[0] && rowX[1] && rowX[2]) XWin = true;
           if(rowO[0] && rowO[1] && rowO[2]) OWin = true;
       }
 
         
          for(int z = 0; z < 1; z++){
            boolean[] rowX = new boolean[3];
            boolean[] rowO = new boolean[3];
           for(int b = 0; b < board.length; b++){
            if(board[b][b].equals("[X]")) rowX[b] = true;
            else{
                rowX[b] = false;
            }
            if(board[b][b].equals("[O]")) rowO[b] = true;
            else rowO[b] = false;
           }
           if(rowX[0] && rowX[1] && rowX[2]) XWin = true;
           if(rowO[0] && rowO[1] && rowO[2]) OWin = true;
       }
       
            for(int z = 0; z < board.length; z++){
            boolean[] rowX = new boolean[3];
            boolean[] rowO = new boolean[3];
            if(board[z][z].equals("[X]")) rowX[z] = true;
            else{
                rowX[z] = false;
            }
            if(board[z][z].equals("[O]")) rowO[z] = true;
            else rowO[z] = false;
           
           if(rowX[0] && rowX[1] && rowX[2]) XWin = true;
           if(rowO[0] && rowO[1] && rowO[2]) OWin = true;
       }
       int bed = 2;
       boolean[] rowX1 = new boolean[3];
        boolean[] rowO1 = new boolean[3];
         for(int z = 0; z < board.length; z++){
            if(board[z][bed].equals("[X]")) rowX1[z] = true;
            else{
                rowX1[z] = false;
            }
            if(board[z][bed].equals("[O]")) rowO1[z] = true;
            else rowO1[z] = false;
           if(rowX1[0] && rowX1[1] && rowX1[2]) XWin = true;
           if(rowO1[0] && rowO1[1] && rowO1[2]) OWin = true;
           bed--;
       }
       boolean isFull = true;
       for(int i = 0; i < board.length; i++){
           for(int x = 0; x < board.length; x++){
               if(board[i][x].equals("[ ]")) isFull = false;
           }
       }
       
       if(OWin) win = "O wins!";
       if(XWin) win = "X wins!";
       if(XWin || OWin) winB = true;
       if(isFull){
         win = "Full board";  
         winB = true;
       }
       
       whoWon = win;
       endGame(winB);
       return win;
   }
   
   public static void endGame(boolean win){
       
       Scanner in =  new Scanner(System.in);
       String cont = new String();
       boolean Yes = false;
       if(win){
           System.out.println(whoWon);
           System.out.println("Play Again? enter Y/N");
           cont = in.nextLine();
           cont = cont.substring(0,1);
           if(cont.equalsIgnoreCase("y")) Yes = true;
           else System.exit(0);
           
           if(Yes) PrintBoard();
       }
   }
}
