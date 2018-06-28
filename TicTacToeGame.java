

public class TicTacToeGame {
  private char[][] boardArray = new char[3][3];

  public static void main(String[] args) {


    TicTacToeGame board = new TicTacToeGame();
    board.initializeBoard();

    // board.addToken('O', 1, 0);
    board.addToken('X', 0, 0);
    // board.computerMove();
    board.addToken('X', 2, 1);
    board.addToken('X', 1, 1);
    board.addToken('X', 2, 2);
    board.addToken('X', 2, 0);

    board.printBoard();
  }

  public void initializeBoard() {
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        boardArray[i][j] = '-';
      }
    }
  }


  public void printBoard() {
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        char value = boardArray[j][i];
        System.out.print(value);
        if (j<2) {
           System.out.print( "|");
        }
      }
      System.out.println();
    }
  }

  public boolean addToken(char value, int h_index, int v_index) {
    if (value != 'X' ) {
      return false;
    }
    if (h_index < 0 || h_index > 2 || v_index < 0 || v_index > 2) {
      return false;
    }

    if (boardArray[h_index][v_index] == '-') {
      boardArray[h_index][v_index] = value;
    }
    else {
      System.out.println(h_index + "-" + v_index + " already have value");
      return false;
    }
     ;
    // printBoard();
    computerMove();
    System.out.println();
    return true;
  }

  public void computerMove() {
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        if (boardArray[i][j] == '-') {
          boardArray[i][j] = 'O';
          printBoard();
          return;
        }
      }
    }
    System.out.println("Game Over!");
  }


}
