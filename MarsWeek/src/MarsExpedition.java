import java.util.Scanner;


public class MarsExpedition {

  private Scanner inputScanner = new Scanner(System.in);

  public MarsExpedition() {}

  public void ExpeditionPrep() {
    BootupMessage();
    String name = GetUserName();
    int teamSize = TeamSetup(name);
    String snackChoice = GetSnackChoice();
    String vehicle = ChooseAVehicle();
    PrintFinalMessage(name, teamSize, snackChoice, vehicle);
  }
  
  private void BootupMessage() {
      System.out.println("Expedition prep program starting ...");
      System.out.println("...");
      System.out.println("Ready!");
  }

  private String GetUserName() {
    System.out.println("What is your name?");
    String userName = inputScanner.nextLine();
    return userName;
  }

  private int TeamSetup(String name) {
    System.out.println(String.format(
      "Hi, %s - Welcome to the Expedition prep program. Are you ready to head out into the new world? Type Y or N", name));
    
    String input = inputScanner.next();
    while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
      System.out.println("Please enter Y or N: ");
      input = inputScanner.next();
    }

    if (input.equalsIgnoreCase("y")) {
      System.out.println("I knew you would say that. You are team leader for a reason.");
    } else {
      System.out.println("Too bad you are team leader. You have to go.");
    }

    System.out.println("How many people would you like in  your team?");
    input = inputScanner.next();
    
    while (true) {
      try {
        int teamSize = Integer.parseInt(input);
        if (teamSize > 2) {
          System.out.println("It is way too many. We can only send 2 more members.");
          break;
        } else {
          System.out.println("We need a team of 2.");
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println("It is not a valid number.");
        input = inputScanner.next();
        continue;
      }
    }
    return 2;
  }

  private String GetSnackChoice() {
    System.out.println("You are allowed to bring one snack with you. What do you want to bring?");
  
    String snack = inputScanner.next();
    System.out.println(String.format("Nice choice, you will bring a %s with you", snack));

    return snack;
  }

  private String ChooseAVehicle() {
    // present the vehicles lists
    System.out.println("You have the choice of one of the below vehicles:" +
              "\nA: Curiosity" + 
              "\nB: Spirit" + 
              "\nC: Sojourner" +
              "\nD: Mars Rover");    

    // Ask user to choose an option
    String  userChoice = inputScanner.next();
    
    if (userChoice.equalsIgnoreCase("A")) {
      userChoice = "Curiosity";
    } else if (userChoice.equalsIgnoreCase("B")) {
      userChoice = "Spirit";
    } else if (userChoice.equalsIgnoreCase("C")) {
      userChoice = "Sojourner";
    } else if (userChoice.equalsIgnoreCase("D")) {
      userChoice = "Mars Rover";
    } else {
      userChoice = "your feet";
    }

    return userChoice;
  }

  private void PrintFinalMessage(String name, int teamSize, String snack, String vehicle) {
    System.out.println("Your expedition team is not ready" + 
          "\nLed by " + name + "with " + teamSize + " teammates." +
          "\nTo explore the surface of Mars using " + vehicle +
          "\nExploration team heads out in" + 
          "\n3..." +
          "\n2..." +
          "\n1..." +
          "\nGO GO GO!");
  }
}
