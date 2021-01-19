public class Player {
  public boolean cpu;
  public boolean turn;
  public int difficulty;
  public char mark;

  public Player(int difficulty, boolean turn, char mark) {
    this.difficulty = difficulty;
    this.mark = mark;
    this.turn = turn;
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
        break;
      case 3:
        choice = bestMove(board, 3);
        break;
      case 4:
        choice = bestMove(board, 9);
        break;
      case 5:
        int randomNumber = (int) (Math.random() * 4 + 1);
        if (randomNumber == 1)
          choice = randomChoice(board);
        else if (randomNumber == 2)
          choice = blockOrWin(board);
        else
          choice = bestMove(board, (int) (Math.random() * 9 + 1));
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

      if (clonedBoard.checkWinCondition(mark)) {
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

      if (clonedBoard.checkWinCondition(mark == 'X' ? 'O' : 'X')) {
        System.out.println("I have found a loss condition on " + choice.field.row + "-" + choice.field.column);
        choice = new Choice(avaliableMoves[i].row, avaliableMoves[i].column, mark);
        return choice;
      }

    }
    System.out.println("I was not able to find any win or loss conditions - making a random choice...");
    return randomChoice(board);
  }

  private Choice bestMove(Board board, int depth) {
    MinimaxPlayer maxPlayer = new MinimaxPlayer(true, true, mark);
    MinimaxPlayer minPlayer = new MinimaxPlayer(false, false, mark == 'X' ? 'O' : 'X');

    int maxEvaluation = -200000;
    int alpha = -200000;
    int beta = 200000;
    Field[] avaliableMoves = board.getAvaliableMoves();
    int turnCount = DialogOptions.boardSize * DialogOptions.boardSize - avaliableMoves.length;
    Choice bestChoice = new Choice(avaliableMoves[0].row, avaliableMoves[0].column, maxPlayer.getMark());
    for (int i = 0; i < avaliableMoves.length; i++) {
      Board clonedBoard = new Board(board);
      Choice choice = new Choice(avaliableMoves[i].row, avaliableMoves[i].column, maxPlayer.getMark());
      clonedBoard.addMark(choice);
      int returnEvaluation = minimax(clonedBoard, depth, false, turnCount + 1, alpha, beta, maxPlayer, minPlayer);

      if (returnEvaluation > maxEvaluation) {
        maxEvaluation = returnEvaluation;
        bestChoice = choice;

      }
    }
    return bestChoice;
  }

  private int minimax(Board board, int depth, boolean maximizer, int turnCount, int alpha, int beta,
      MinimaxPlayer maxPlayer, MinimaxPlayer minPlayer) {
    if (depth == 0 || board.isEnded())
      return board.getScore(maxPlayer, minPlayer) / turnCount;

    if (maximizer) {
      // int maxEvaluation = -200000;
      Field[] avaliableMoves = board.getAvaliableMoves();
      int newTurnCount = turnCount + 1;

      for (int i = 0; i < avaliableMoves.length; i++) {
        Board clonedBoard = new Board(board);
        Choice choice = new Choice(avaliableMoves[i].row, avaliableMoves[i].column, maxPlayer.mark);
        clonedBoard.addMark(choice);
        int evaluation = minimax(clonedBoard, depth - 1, false, newTurnCount, alpha, beta, maxPlayer, minPlayer);
        if (evaluation > alpha)
          alpha = evaluation;
        if (alpha >= beta)
          break;
        // maxEvaluation = Math.max(maxEvaluation, evaluation);
      }
      return alpha;
    } else {
      // int minEvaluation = 200000;
      Field[] avaliableMoves = board.getAvaliableMoves();
      int newTurnCount = turnCount + 1;

      for (int i = 0; i < avaliableMoves.length; i++) {
        Board clonedBoard = new Board(board);
        Choice choice = new Choice(avaliableMoves[i].row, avaliableMoves[i].column, minPlayer.mark);
        clonedBoard.addMark(choice);
        int evaluation = minimax(clonedBoard, depth - 1, true, newTurnCount, alpha, beta, maxPlayer, minPlayer);
        if (evaluation < beta)
          beta = evaluation;
        if (alpha >= beta)
          break;
        // minEvaluation = Math.min(minEvaluation, evaluation);
      }
      return beta;
    }
  }

}
