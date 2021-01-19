public class MinimaxPlayer {

  public boolean maximizer;
  public boolean turn;
  public char mark;

  public MinimaxPlayer(boolean maximizer, boolean turn, char mark) {
    this.maximizer = maximizer;
    this.turn = turn;
    this.mark = mark;
  }

  public void setTurn(boolean turn) {
    this.turn = turn;
  }

  public boolean getTurn() {
    return this.turn;
  }

  public boolean isMaximizer() {
    return this.maximizer;
  }

  public char getMark() {
    return this.mark;
  }

}
