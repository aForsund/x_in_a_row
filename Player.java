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

  public Choice makeChoice(Board board) {

    Choice choice;
    System.out.println("I'm told to make a choice, but for now I'm only printing my variables");
    System.out.println(cpu);
    System.out.println(difficulty);
    System.out.println(turn);

    switch (difficulty) {
      case 1:
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

}
