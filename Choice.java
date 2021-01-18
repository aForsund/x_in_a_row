public class Choice {
  public char mark;
  public Field field;

  Choice(int rValue, int cValue, char playerMark) {
    field = new Field(rValue, cValue);
    mark = playerMark;
  }

}
