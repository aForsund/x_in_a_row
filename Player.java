public class Player {
  public boolean cpu;
  public boolean turn;
  public int difficulty = 0;
  public char mark;

  public Player(int hasDifficulty, boolean hasTurn, char hasMark) {
    difficulty = hasDifficulty;
    turn = hasTurn;
    if (difficulty == 0)
      cpu = false;
    else
      cpu = true;
    mark = hasMark;
  }

  public void setTurn(boolean turn) {
    this.turn = turn;
  }

  public boolean getTurn() {
    return this.turn;
  }

  public Choice makeChoice(Board board) {

    Choice choice;

    switch (difficulty) {
      case 1:
        choice = randomChoice(board);
        break;
      case 2:
        blockOrWin(board);
        choice = randomChoice(board);
        break;
      default:
        choice = randomChoice(board);
    }
    return choice;
  }

  private Choice randomChoice(Board board) {
    int min = 0;
    int max = board.length;
    boolean found = false;
    int hValue = -1;
    int vValue = -1;

    while (!found) {
      hValue = (int) (Math.random() * max + min);
      vValue = (int) (Math.random() * max + min);
      if (board.getMark(hValue, vValue) == ' ') {
        found = true;
      }
    }

    return new Choice(hValue, vValue, mark);
  }

  private void blockOrWin(Board board) {
    Board clonedBoard = new Board(board);

    Field[] avaliableMoves = board.getAvaliableMoves();

    for (int i = 0; i < avaliableMoves.length; i++) {

      Choice choice = new Choice(avaliableMoves[i].row, avaliableMoves[i].column, mark);
      clonedBoard.addMark(choice);
    }
    System.out.println("Printing cloned board: ");

    clonedBoard.printBoard();

    System.out.println("Printing original board: ");
    board.printBoard();

  }

}
