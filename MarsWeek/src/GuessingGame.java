import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

  public GuessingGame() {}

  public void PlayGame() {
    PrintWelcomeMessage();
    String name = GetPlayerName();
    int target = PickRandomNumber();
    int guessCount = RunGuessingLoop(target, name);
    PrintResult(guessCount, name);
  }

  private void PrintWelcomeMessage() {
    System.out.println("Welcome to the Guessing Game!");

  }

  private String GetPlayerName() {
    System.out.println("Please type your name.");
    Scanner scan = new Scanner(System.in);
    String name = scan.nextLine();
    return name;
  }

  private int PickRandomNumber() {
    Random rand = new Random();
    int number = rand.nextInt(100);
    return number; // Guaranteed random, picked by fair dice roll.
  }


  private int RunGuessingLoop(int target, String name) {
    int guessCount = 0;
    System.out.println("Try to guess my number.");
    while (true) {
      String input = inputScanner.next();
      try {
        int intGuess = Integer.parseInt(input);
        System.out.println(String.format("Your guess? %d", intGuess));
        guessCount += 1;
        if (intGuess < target) {
          System.out.println("Your guess is low.");
        } else if (intGuess > target) {
          System.out.println("Your guess is high.");
        } else {
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println("It is not an integer. Try again!");
        continue;
      }
    }
    return guessCount;
  }


  private void PrintResult(int guessCount, String name) {
    System.out.println(String.format("Well done, %s! You found my number in %d tries!", name, guessCount));
  }


  private Scanner inputScanner = new Scanner(System.in);
  
}
