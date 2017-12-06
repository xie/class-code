public class diagonal {

  public static int rows = 10;

  public static int cols = 10;

  public static Character[][] board;

  public static final Character ex = 'X';

  public static final Character oh = 'O';

  public static final Character empty = ' ';


  public static void main(String[] args) {

  }

  
  public static void clearBoard() {
    for (int i = 0; i < rows; i++) {
      for (int x = 0; x < columns; x++) {
        board[i][x] = empty;
      }
    }
  }

  public static void drawBoard() {
    System.out.println(playCount);
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        System.out.print("|" + board[r][c] );
        if (c == (columns-1)) {
          System.out.print("|");
          System.out.print("\n");
        }
      }
    }



}
