public class Board {
  public char[][] board;

  public Board(int size) {
    board = new char[size][size];

    // initialize blank board
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = ' ';
      }
    }
  }

  public void printBoard() {
    System.out.println();
    printDots();
    for (int i = 0; i < board.length; i++) {
      int count = 0;
      while (count < board[i].length) {
        System.out.print("| " + board[i][count] + " ");
        count++;
        if (count == board[i].length)
          System.out.println("|");
      }
      printDots();
    }

  }

  private void printDots() {
    int count = 0;
    int length = board.length * 3 + board.length;

    while (count <= length) {
      System.out.print("-");
      count++;
    }
    System.out.println();
  }

  public void addMark(char mark, Choice choice) {
    board[choice.row][choice.column] = mark;
  }
}
