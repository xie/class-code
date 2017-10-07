/** COMP 1006/1406
  * Summer 2017
  *
  * Assignment 1
  */

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Random;
//testing



public class TicTacToeGame{
  /** symbol for X */
  public static final Character ex    = 'X';

  /** symbol for O */
  public static final Character oh    = 'O';

  /** symbol for empty grid element */
  public static final Character empty = ' ';

  /** board is the grid that the game is played on;
    * each element must be one of ex, oh or empty*/
  public static Character[][] board;


  /** rows is the number of rows (N) in the game board */
  public static int       rows;

  /** columns is the number of columns (M) in the game board */
  public static int       columns;

  /** win_condition is the value of K, the winning condition of the game */
  public static int       win_condition;

  /** specifies if the game is 1p (human-human) or 2p (human-computer) */
  public static boolean   human_human_game;

  //array to store game stats
  public static int[]     gameData;

  //stores who is moving
  public static int       currentPlayer;

  //moves counter
  public static int       moveCount;


  //test count for running multiple times
  public static int       testCount = 0;



  /** main method to run the game
    *
    * @param args optional command line arguments to
    * specify if the game is 1p (human-computer) or
    * 2p (human-human). Expect the string "2p" if any
    * command line argument is given.
    */
  public static void    main(String[] args){
    /*------------------------------------------
     * handle command line arguments if any
     * to determine if the game is human-human
     * or human-computer
     *------------------------------------------*/

     //game switch
    if( args.length > 0){
      /* there are commend line arguments present */
      human_human_game = true;
      System.out.println("This is a 2 player game.");
    } else {
      /* there are no command line argument present */
      // add your code here
      human_human_game = false;
      System.out.println("This is a computer game.");
    }



    /*------------------------------------
     * read N-M-K data from init file
       N = rows
       M = columns
       K = win_condition
     *------------------------------------*/

    /*-------------------------------------
     *-------------------------------------
     * BEGIN : Do NOT change the code here
     *-------------------------------------*/
    BufferedReader file_input;
    FileReader     file;
    String         file_name = "init";
    String         line;

    try{
      file            = new FileReader(file_name);
      file_input      = new BufferedReader(file);

      line            = file_input.readLine();
      rows            = Integer.parseInt(line);

      line            = file_input.readLine();
      columns         = Integer.parseInt(line);

      line            = file_input.readLine();
      win_condition   = Integer.parseInt(line);

      /* always close your files you are done with them! */
      file_input.close();

    }catch(Exception e){
      /* somethine went wrong! */
      System.err.println("Failure to read data from init file properly");
      System.err.println(e);
      System.err.println("Program ending");
      return;
    }

    /*-------------------------------------
     * END : Do NOT change the code here
     *-------------------------------------
     *-------------------------------------*/


    /* create and initialize the game board */

    /* allocate memory for the board array */
    board     = new Character[rows][columns];
    gameData  = new int[6];

    /** game data array
       0 : games played
       1 : player one wins
       2 : player two wins
       3 : computer wins
       4 : draws
       5 : best win
    */
    gameData[0] = 0;
    gameData[1] = 0;
    gameData[2] = 0;
    gameData[3] = 0;
    gameData[4] = 0;
    gameData[5] = 0;
    /* code to drive the game */

    // add your code here
    gameInit();

    //enter move message
  }

  //method to initialize game
  public static void    gameInit() {
    moveCount = 0;
    if (gameData[0]%2==0) {
      currentPlayer = 1;
    }
    if ((gameData[0]%2!=0)&&(human_human_game)) {
      currentPlayer = 2;
    }
    clearBoard();
    drawBoard();
    humanMove();
  }

  /**method to get move input
    * send to :
        -addToBoard function
  */
  public static void    humanMove() {
    Scanner keyboard;
    keyboard = new Scanner(System.in);
    int row;
    int col;
    int swap;
    String a;
    String b;
    System.out.print("Player "+currentPlayer+" move : ");
    a = keyboard.next();
    a = textChange(a);
    //check for end game command
    if (a.equals("end")) {
      System.exit(0);
    }
    row = keyboard.nextInt();
    b = keyboard.next();
    b = textChange(b);
    col = keyboard.nextInt();
    //checks for valid inputs and swaps value if needed
    while (true) {
      if (((b.equals("r"))||(b.equals("row"))) && ((a.equals("c"))||(a.equals("col"))||(a.equals("column")))) {
        swap = row;
        row = col;
        col = swap;
        if ((row < rows)&&(col<columns)) {
          addToBoard(row, col);
          break;
        } else {
          System.out.println("Invalid input!");
          humanMove();
          break;
        }
      } else if (((a.equals("r"))||(a.equals("row"))) && ((b.equals("c"))||(b.equals("col"))||(b.equals("column")))) {
          row = row;
          col = col;
          if ((row < rows)&&(col<columns)) {
            addToBoard(row, col);
            break;
          } else {
            System.out.println("Invalid input!");
            humanMove();
            break;
          }

      } else {
          System.out.println("Invalid input!");
          humanMove();
          break;
      }
    }
  }



  /** Checks for a win based on the last symbol played in the game
   *
   * It is assumed that the position specified by the last_row_played
   * and last_column_played is valid and that the symbol in the board
   * at that position is not empty. (It must be <em>ex</em> or <em>oh</em>)
   *
   * @param last_row_played is the row of the last symbol played
   * @param last_column_played is the column of the last symbol played
   * @return the length of the winning row/column/diagonal of symbols
   * if the last move is a winning move, or -1 if the last move is not
   * a winning move.
   */
  public static int     win(int last_row_played, int last_column_played){
    char player = board[last_row_played][last_column_played];
    int x = last_row_played;
    int y = last_column_played;

    if ((horizontalCheck(x,y))||(verticalCheck(x,y))||(diagonalCheck(x,y))||(diagonalCheck1(x,y))) {
      statistics(false);
      gameOver();
      return win_condition;
    }

    if (moveCount == (rows*columns)-1) {
      System.out.println("Draw!");
      statistics(true);
      gameOver();
      return -1;
    }
    gameSwitch();
    return -1;
  }

  /**statistics method
    * updates gameData info
    * inputs :
      -draw boolean
  */
  public static void    statistics(boolean draw) {
    //total games += 1
    gameData[0] += 1;
    if (!draw) {
      gameData[currentPlayer] += 1;
      if (win_condition > gameData[4]) {
        //new best win
        gameData[5] = win_condition;
      }
    } else {
        //add to draw count
        gameData[4] += 1;
    }
  }

  /**method for horizontal check
    * inputs :
      @param row
      @param column
    * outputs :
      -win boolean
  */
  public static boolean horizontalCheck(int row, int col) {
    int right       = 1;
    int left        = 1;
    int horizontal  = 1;

    while((col + right) < columns) {
      if (board[row][col] == board[row][col+right]) {
        horizontal += 1;
      } else {
        break;
      }
      right += 1;
    }

    while((col - left) >= 0) {
      if (board[row][col] == board[row][col-left]) {
        horizontal += 1;
      } else {
        break;
      }
      left += 1;
    }
    if (horizontal >= win_condition) {
      System.out.println("Horizontal Win! at : "+row +" "+ col);
      return true;
    }
    return false;
  }

  /**method for vertical check
    * inputs :
      @param row
      @param column
    * outputs :
      -win boolean
  */
  public static boolean verticalCheck(int row, int col) {
    int up        = 1;
    int down      = 1;
    int vertical  = 1;
    while((row + down) < rows) {
      if (board[row][col] == board[row+down][col]) {
        vertical += 1;
      } else {
        break;
      }
      down += 1;
    }

    while((row - up) >= 0) {
      if (board[row][col] == board[row-up][col]) {
        vertical += 1;
      } else {
        break;
      }
      up += 1;
    }
    if (vertical >= win_condition) {
      System.out.println("Vertical Win! at : "+row +" "+ col);
      return true;
    }
    return false;
  }

  /**diagonalCheck1
  */
  public static boolean diagonalCheck1(int row, int col) {
    int downRight = 1;
    int upLeft    = 1;
    int antiDiagonal  = 1;
    while(((row - upLeft) >= 0) && ((col - upLeft) >= 0)) {
      if (board[row][col] == board[row-upLeft][col-upLeft]) {
        antiDiagonal += 1;
      } else {
        break;
      }
      upLeft += 1;
    }

    while(((row + downRight) < rows) && ((col + downRight) < columns)) {
      if (board[row][col] == board[row+downRight][col+downRight]) {
        antiDiagonal += 1;
      } else {
        break;
      }
      downRight += 1;
    }
    if (antiDiagonal >= win_condition) {
      System.out.println("Diagonal Win! at : "+row +" "+ col);
      return true;
    }
    return false;
  }

  /**method for diagonal check
    * inputs :
      @param row
      @param column
    * outputs :
      -win boolean
  */
  public static boolean diagonalCheck(int row, int col) {
    int upRight   = 1;
    int downLeft  = 1;
    int diag      = 1;
    while(((row - upRight) >= 0) && ((col + upRight) < columns)) {
      if (board[row][col] == board[row-upRight][col+upRight]) {
        diag += 1;
      } else {
        break;
      }
      upRight += 1;
    }

    while(((row + downLeft) < rows) && ((col - downLeft) >= 0)) {
      if (board[row][col] == board[row+downLeft][col-downLeft]) {
        diag += 1;
      } else {
        break;
      }
      downLeft += 1;
    }

    if (diag >= win_condition) {
      System.out.println("Diagonal Win! at : "+row +" "+ col);
      return true;
    }
    return false;
  }

  /**game over display stats
    * calls :
      -displayStats function
      gameInit function
  */
  public static void    gameOver() {
    Scanner keyboard;
    keyboard = new Scanner(System.in);


    String game;
    displayStats();
    System.out.println("Would you like to play again?");
    game = keyboard.next();

    if (game.equals("yes")) {
      gameInit();
    }
  }

  //display game info
  public static void    displayStats() {
    System.out.println("Game Over!");
    System.out.println("Total games played: "+gameData[0]);
    System.out.println("Player one wins: "+gameData[1]);
    System.out.println("Player two wins: "+gameData[2]);
    System.out.println("Computer wins: "+gameData[3]);
    System.out.println("Draws: "+gameData[4]);
    System.out.println("Best win: "+gameData[5]);
  }

  /**computer move
    * @sends to :
        -addToBoard
  */
  public static void    computerMove() {
    Random rand = new Random();
    int row;
    int col;
    boolean played = true;
    do {
      row = rand.nextInt(rows);
      col = rand.nextInt(columns);
      if (board[row][col] == empty) {
        played = false;
        System.out.println("Computer played at: "+row+","+col);
        addToBoard(row,col);
        break;
      }
    } while (played);
  }


  //method to control game flow path
  public static void    gameSwitch() {
    moveCount += 1;
    if ((human_human_game == false) && (currentPlayer == 1)) {
      currentPlayer = 3;
      computerMove();
      return;
    }
    if ((human_human_game == true) && (currentPlayer == 1)) {
      currentPlayer = 2;
      humanMove();
      return;
    }
    if (currentPlayer != 1) {
      currentPlayer = 1;
      humanMove();
      return;
    }
  }

  //method for converting string input to good format
  public static String  textChange(String i) {
    i = i.toLowerCase();
    i = i.trim();
    return i;
  }


  /*method to display the board*/
  public static void    drawBoard() {
    System.out.print("  ");
    for (int x = 0; x < columns; x++) {
      if (x < 10) {
        System.out.print(x + " ");
      } else {
        System.out.print(x + "");
      }
    }
    System.out.println("");
    for (int r = 0; r < rows; r++) {
      System.out.print(r + "");
      for (int c = 0; c < columns; c++) {
        System.out.print("|" + board[r][c] );
        if (c == (columns-1)) {
          System.out.print("|");
          System.out.print("\n");
        }
      }
    }
    System.out.println("");
    for (int d = 0; d < columns; d++) {
      System.out.print(" - ");
    }
    System.out.println("");
  }

  /*method to clear board*/
  public static void    clearBoard() {
    for (int i = 0; i < rows; i++) {
      for (int x = 0; x < columns; x++) {
        board[i][x] = empty;
      }
    }
  }

  /**method to add to board
    * inputs :
        -row
        -column
    * sends to :
        -drawBoard function
        -win function
  */
  public static void    addToBoard(int row, int col) {
    if (board[row][col] == empty) {
      if (currentPlayer == 1) {
        board[row][col] = ex;
      } else {
          board[row][col] = oh;
      }
      drawBoard();
      if (moveCount >= ((win_condition*2)-2)) {
        win(row,col);
      } else {
        gameSwitch();
      }
    } else {
        System.out.println("Already taken!");
        humanMove();
    }
  }
}
/** Diagram represents path of game loop for a 2p game and computer game.
  *
  *                         main
  *                          |
  *               2player <- * -> [error catch]
  *                  |
  *               gameInit <- - - - - - - - *
  *                  |                      |
  *              gameSwitch <- - - - *      |
  *                  |               |      |
  *     humanMove <- * -> computer   |      |
  *        |                  |      |      |
  *        * -> addToBoard <- *      |      |
  *                  |               |      |
  *                 win              |      |
  *                  |               |      |
  *                  * - - - - - - - *      |
  *                  |                      |
  *               gameOver                  |
  *                  |                      |
  * [end program] <- * - - - - - - - - - - -*
  *
*/
