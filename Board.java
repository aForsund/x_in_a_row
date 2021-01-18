public class Board {
  public char[][] gameBoard;
  public int length;

  public Board(int size) {
    length = size;
    gameBoard = new char[size][size];

    // initialize blank board
    for (int i = 0; i < gameBoard.length; i++) {
      for (int j = 0; j < gameBoard[i].length; j++) {
        gameBoard[i][j] = ' ';
      }
    }
  }

  public void printBoard() {
    System.out.println();
    printDots();
    for (int i = 0; i < gameBoard.length; i++) {
      int count = 0;
      while (count < gameBoard[i].length) {
        System.out.print("| " + gameBoard[i][count] + " ");
        count++;
        if (count == gameBoard[i].length)
          System.out.println("|");
      }
      printDots();
    }

  }

  private void printDots() {
    int count = 0;
    int length = gameBoard.length * 3 + gameBoard.length;

    while (count <= length) {
      System.out.print("-");
      count++;
    }
    System.out.println();
  }

  public void addMark(Choice choice) {
    gameBoard[choice.row][choice.column] = choice.mark;
  }

  public char getMark(int row, int column) {
    return gameBoard[row][column];
  }
}
