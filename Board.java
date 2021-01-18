import java.util.ArrayList;

public class Board {
  public char[][] gameBoard;
  public int length;

  Board(int size) {
    length = size;
    gameBoard = new char[size][size];

    // initialize blank board
    for (int i = 0; i < gameBoard.length; i++) {
      for (int j = 0; j < gameBoard[i].length; j++) {
        gameBoard[i][j] = ' ';
      }
    }
  }

  Board(Board x) {
    this.copy(x);
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

  public void setLength(int length) {
    this.length = length;
  }

  public int getLength() {
    return length;
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
    gameBoard[choice.field.row][choice.field.column] = choice.mark;
  }

  public char getMark(int row, int column) {
    return gameBoard[row][column];
  }

  public Field[] getAvaliableMoves() {
    ArrayList<Field> avaliableMoves = new ArrayList<Field>();

    for (int i = 0; i < gameBoard.length; i++) {
      for (int j = 0; j < gameBoard[i].length; j++) {
        if (gameBoard[i][j] == ' ') {
          avaliableMoves.add(new Field(i, j));
        }
      }
    }

    return avaliableMoves.toArray(new Field[avaliableMoves.size()]);
  }

  public void copy(Board x) {
    this.setLength(x.getLength());
    this.gameBoard = new char[x.getLength()][x.getLength()];

    // initialize copy of board
    for (int i = 0; i < gameBoard.length; i++) {
      for (int j = 0; j < gameBoard[i].length; j++) {
        gameBoard[i][j] = x.getMark(i, j);
      }
    }

  }
}
