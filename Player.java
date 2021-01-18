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
    int hValue = 0;
    int vValue = 0;
    System.out.println("I'm told to make a choice, but for now I'm only printing my variables");
    System.out.println(cpu);
    System.out.println(difficulty);
    System.out.println(turn);

    switch (difficulty) {
      case 0:
        break;
      default:

    }
    return new Choice(hValue, vValue);
  }

}
