
public class Game {
  Game() {
    do {
      int turnCount = 1;

      DialogOptions.welcomeMessage();

      DialogOptions.selectGameOptions();
      DialogOptions.getPlayerOne();
      DialogOptions.getPlayerTwo();

      System.out.println("Your selections are - board: " + DialogOptions.boardSize + " PlayerOne: "
          + DialogOptions.playerOne + " PlayerTwo: " + DialogOptions.playerTwo);

      Player playerOne = new Player(DialogOptions.playerOne, true, 'X');
      Player playerTwo = new Player(DialogOptions.playerTwo, false, 'O');
      Board board = new Board(DialogOptions.boardSize);

      Choice playerOneChoice;
      Choice playerTwoChoice;

      int maxTurnCount = DialogOptions.boardSize * DialogOptions.boardSize;
      System.out.println("Max # turns: " + maxTurnCount);
      while (turnCount <= maxTurnCount) {
        if (playerOne.getTurn()) {
          playerOneChoice = playerOne.makeChoice(board);
          board.addMark(playerOneChoice);
        } else if (playerTwo.getTurn()) {
          playerTwoChoice = playerTwo.makeChoice(board);
          board.addMark(playerTwoChoice);
        }
        board.printBoard();
        if (board.checkWinCondition()) {
          char winner = playerOne.getTurn() ? playerOne.mark : playerTwo.mark;
          System.out.println(winner + " has won...");
          break;
        }
        playerOne.setTurn(!playerOne.getTurn());
        playerTwo.setTurn(!playerTwo.getTurn());
        System.out.println("Turn #: " + turnCount);
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          return;
        }
        turnCount++;
      }
      DialogOptions.playAgain();
    } while (DialogOptions.ongoing);
    System.exit(0);
  }
}
