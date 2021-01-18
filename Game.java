
public class Game {
  Game() {
    boolean turnAlternator = true;
    int turnCount = 1;

    DialogOptions.welcomeMessage();

    DialogOptions.selectGameOptions();
    DialogOptions.getPlayerOne();
    DialogOptions.getPlayerTwo();

    System.out.println("Your selections are - board: " + DialogOptions.boardSize + " PlayerOne: "
        + DialogOptions.playerOne + " PlayerTwo: " + DialogOptions.playerTwo);

    Player playerOne = new Player(DialogOptions.playerOne, turnAlternator, 'X');
    Player playerTwo = new Player(DialogOptions.playerTwo, !turnAlternator, 'O');
    Board board = new Board(DialogOptions.boardSize);

    Choice playerOneChoice;
    Choice playerTwoChoice;

    int maxTurnCount = DialogOptions.boardSize * DialogOptions.boardSize;
    System.out.println("Max # turns: " + maxTurnCount);
    while (turnCount <= maxTurnCount) {
      if (playerOne.getTurn()) {
        playerOneChoice = playerOne.makeChoice(board);
        board.addMark(playerOneChoice);
        turnAlternator = !turnAlternator;
        playerOne.setTurn(!playerOne.getTurn());
        playerTwo.setTurn(!playerTwo.getTurn());
      } else if (playerTwo.getTurn()) {
        playerTwoChoice = playerTwo.makeChoice(board);
        board.addMark(playerTwoChoice);
        turnAlternator = !turnAlternator;
        playerOne.setTurn(!playerOne.getTurn());
        playerTwo.setTurn(!playerTwo.getTurn());
      }
      board.printBoard();
      if (board.checkWinCondition()) {
        System.out.println("Someone has won...");
        break;
      }
      System.out.println(turnCount);
      turnCount++;

    }
  }
}
