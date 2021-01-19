import java.util.*;

public class DialogOptions {

  static Scanner input = new Scanner(System.in);
  static boolean valid = true;

  static int temp = 0;

  public static boolean ongoing = true;
  public static int boardSize = 0;
  public static int playerOne = 0;
  public static int playerTwo = 0;

  public static void welcomeMessage() {
    System.out.println("* * * Welcome to tic tac toe java edition * * *");
    System.out.println("This is a text-based version of tictactoe_v2 made with Java");
  }

  public static void selectGameOptions() {
    while (valid) {
      System.out.print("Please select board size (3-10): ");

      try {
        temp = input.nextInt();
        if (temp >= 3 && temp <= 10) {
          System.out.println("You have selected " + temp);
          boardSize = temp;
          valid = false;
        } else {
          System.out.println("Number has to be between 3 and 10...");
        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid input, try again...");
        input.next();
        continue;
      }
    }
    valid = true;
  }

  public static void getPlayerOne() {
    System.out.println("Please select options for player 1");

    while (valid) {
      System.out
          .println("0: Local Player, 1: CPU Easy, 2: CPU Moderate, 3: CPU Hard, 4: CPU Impossible, 5: CPU Random");
      System.out.print("#: ");
      try {
        temp = input.nextInt();
        switch (temp) {
          case 0:
            playerOne = 0;
            valid = false;
            break;
          case 1:
            playerOne = 1;
            valid = false;
            break;
          case 2:
            playerOne = 2;
            valid = false;
            break;
          case 3:
            playerOne = 3;
            valid = false;
            break;
          case 4:
            playerOne = 4;
            valid = false;
            break;
          case 5:
            playerOne = 5;
            valid = false;
            break;
          default:
            System.out.println("Number has to be between 0 and 5");
            break;

        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid input, try again...");
        input.next();
        continue;
      }

    }
    valid = true;
  }

  public static void getPlayerTwo() {
    System.out.println("Please select options for player 2");

    while (valid) {
      System.out.println("1: CPU Easy, 2: CPU Moderate, 3: CPU Hard, 4: CPU Impossible, 5: CPU Random");
      System.out.print("#: ");
      try {
        temp = input.nextInt();
        switch (temp) {
          case 0:
            playerTwo = 0;
            valid = false;
            break;
          case 1:
            playerTwo = 1;
            valid = false;
            break;
          case 2:
            playerTwo = 2;
            valid = false;
            break;
          case 3:
            playerTwo = 3;
            valid = false;
            break;
          case 4:
            playerTwo = 4;
            valid = false;
            break;
          case 5:
            playerTwo = 5;
            valid = false;
            break;
          default:
            System.out.println("Number has to be between 0 and 5");
            break;

        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid input, try again...");
        input.next();
        continue;
      }

    }
    valid = true;
  }

  public static void playAgain() {
    valid = true;
    String answer;
    input.nextLine();
    while (valid) {
      System.out.println("Play again? (y/n) ");
      try {
        answer = input.nextLine();
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"))
          valid = false;
        else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
          valid = false;
          ongoing = false;
        } else
          System.out.println("Please answer yes (y) or no (n)");
      } catch (InputMismatchException e) {
        System.out.println("Invalid input, try again...");
        input.next();
        continue;
      }

    }

  }

}
