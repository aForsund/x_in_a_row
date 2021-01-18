
public class Game {
  Game() {
    boolean turnAlternator = true;
    DialogOptions.welcomeMessage();

    DialogOptions.selectGameOptions();
    DialogOptions.getPlayerOne();
    DialogOptions.getPlayerTwo();

    System.out.println("Your selections are - board: " + DialogOptions.boardSize + " PlayerOne: "
        + DialogOptions.playerOne + " PlayerTwo: " + DialogOptions.playerTwo);

    Player playerOne = new Player(DialogOptions.playerOne, turnAlternator, 'X');
    Player playerTwo = new Player(DialogOptions.playerTwo, !turnAlternator, 'O');
    Board board = new Board(DialogOptions.boardSize);

    Choice playerOneChoice = playerOne.makeChoice(board);
    board.addMark(playerOneChoice);
    Choice playerTwoChoice = playerTwo.makeChoice(board);
    board.addMark(playerTwoChoice);

    System.out.println("Player one has made choice: " + playerOneChoice.row + playerOneChoice.column);
    System.out.println("Player two has made choice: " + playerTwoChoice.row + playerTwoChoice.column);

    board.printBoard();
  }
}
