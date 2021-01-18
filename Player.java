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

        choice = blockOrWin(board);
        ;
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

  private Choice blockOrWin(Board board) {
    Board clonedBoard;

    Field[] avaliableMoves = board.getAvaliableMoves();

    // Checking for possible win condition
    System.out.println("Checking for possible win condition...");
    for (int i = 0; i < avaliableMoves.length; i++) {
      clonedBoard = new Board(board);
      Choice choice = new Choice(avaliableMoves[i].row, avaliableMoves[i].column, mark);
      clonedBoard.addMark(choice);

      if (clonedBoard.checkWinCondition()) {
        System.out.println("I have found a win condition on " + choice.field.row + "-" + choice.field.column);
        return choice;
      }
    }

    // Checking for possible loss condition
    System.out.println("Checking for possible loss condition...");
    for (int i = 0; i < avaliableMoves.length; i++) {
      clonedBoard = new Board(board);
      Choice choice = new Choice(avaliableMoves[i].row, avaliableMoves[i].column, mark == 'X' ? 'O' : 'X');
      clonedBoard.addMark(choice);

      if (clonedBoard.checkWinCondition()) {
        System.out.println("I have found a loss condition on " + choice.field.row + "-" + choice.field.column);
        return choice;
      }

    }
    System.out.println("I was not able to find any win or loss conditions - making a random choice...");
    return randomChoice(board);
  }

}
