public class Player {
  public boolean cpu;
  public boolean turn;
  public int difficulty = 0;

  public Player(int hasDifficulty, boolean hasTurn) {
    difficulty = hasDifficulty;
    turn = hasTurn;
    if (difficulty == 0)
      cpu = false;
    else
      cpu = true;
  }

  public void makeChoice() {
    System.out.println("I'm told to make a choice, but for now I'm only printing my variables");
    System.out.println(cpu);
    System.out.println(difficulty);
    System.out.println(turn);
  }

}
