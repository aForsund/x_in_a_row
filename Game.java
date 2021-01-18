
public class Game {
  Game() {
    boolean turnAlternator = true;
    DialogOptions.welcomeMessage();

    DialogOptions.selectGameOptions();
    DialogOptions.getPlayerOne();
    DialogOptions.getPlayerTwo();

    System.out.println("Your selections are - board: " + DialogOptions.boardSize + " PlayerOne: "
        + DialogOptions.playerOne + " PlayerTwo: " + DialogOptions.playerTwo);

    Player playerOne = new Player(DialogOptions.playerOne, turnAlternator);
    Player playerTwo = new Player(DialogOptions.playerTwo, !turnAlternator);
    // Board board = new Board(DialogOptions.boardSize);

    playerOne.makeChoice();
    playerTwo.makeChoice();
  }
}
