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

  public boolean checkWinCondition() {
    boolean winCondition = false;
    winCondition = checkRows();
    if (winCondition)
      return true;
    winCondition = checkColumns();
    if (winCondition)
      return true;
    winCondition = checkDiagonals();
    return winCondition;
  }

  public boolean checkWinCondition(char mark) {
    boolean winCondition = false;
    winCondition = checkRows(mark);
    if (winCondition)
      return true;
    winCondition = checkColumns(mark);
    if (winCondition)
      return true;
    winCondition = checkDiagonals(mark);
    return winCondition;
  }

  private boolean checkRows() {
    int j = 0;

    for (int i = 0; i < length; i++) {
      j = 0;
      if (getMark(i, j) == ' ')
        continue;
      while (j < length - 1) {
        if (getMark(i, j) != getMark(i, j + 1))
          break;
        if (j == length - 2)
          return true;
        j++;
      }
    }
    return false;
  }

  private boolean checkRows(char mark) {
    int j = 0;

    for (int i = 0; i < length; i++) {
      j = 0;
      while (j < length) {
        if (getMark(i, j) != mark)
          break;
        if (j == length - 1)
          return true;
        j++;
      }
    }
    return false;
  }

  private boolean checkColumns() {
    int i = 0;
    for (int j = 0; j < length; j++) {
      i = 0;
      if (getMark(i, j) == ' ')
        continue;
      while (i < length - 1) {
        if (getMark(i, j) != getMark(i + 1, j))
          break;
        if (i == length - 2)
          return true;
        i++;
      }
    }
    return false;
  }

  private boolean checkColumns(char mark) {
    int i = 0;
    for (int j = 0; j < length; j++) {
      i = 0;
      while (i < length) {
        if (getMark(i, j) != mark)
          break;
        if (i == length - 1)
          return true;
        i++;
      }
    }
    return false;
  }

  private boolean checkDiagonals() {

    for (int i = 0; i < length - 1; i++) {
      if (getMark(i, i) == ' ')
        break;
      if (getMark(i, i) != getMark(i + 1, i + 1))
        break;
      if (i == length - 2)
        return true;
    }

    for (int i = 0; i < length - 1; i++) {
      if (getMark(i, length - 1 - i) == ' ')
        break;
      if (getMark(i, length - 1 - i) != getMark(i + 1, length - 2 - i))
        break;
      if (i == length - 2)
        return true;
    }
    return false;
  }

  private boolean checkDiagonals(char mark) {

    for (int i = 0; i < length; i++) {
      if (getMark(i, i) != mark)
        break;
      if (i == length - 1)
        return true;
    }

    for (int i = 0; i < length; i++) {
      if (getMark(i, length - 1 - i) != mark)
        break;
      if (i == length - 1)
        return true;
    }
    return false;
  }

  // Methods used for minimax algorithim
  public boolean isEnded() {
    Field[] avaliableMoves = getAvaliableMoves();
    if (avaliableMoves.length == 0)
      return true;
    else if (checkWinCondition())
      return true;
    else
      return false;
  }

  public int getScore(MinimaxPlayer maxPlayer, MinimaxPlayer minPlayer) {
    int score = 0;

    if (checkWinCondition(minPlayer.mark)) {
      score = -1000;
    }

    if (checkWinCondition(maxPlayer.mark)) {
      score = 1000;
    }

    return score;
  }

}
