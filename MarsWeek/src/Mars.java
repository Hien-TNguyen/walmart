public class Mars {
  public static void main(String[] args) throws InterruptedException{
    String colonyMars = "Jupiter";
    int shipPopulation = 300;
    double meals = 4000.00;
    boolean landing = true;

    // meals remaining after two days
    meals = meals - 2 * (shipPopulation * 0.75);
    System.out.println(meals);

    // meals increases 50%
    meals += meals / 2;

    // shipPopulation is increased by 5 more babies
    shipPopulation += 5;

    String landingLocation = "The Ocean";

    if (landingLocation == "The Plain") {
      System.out.println("Bbzzz Landing on the Plain");
    } else {
      System.out.println("ERROR!!! Flight plan already set. Landing on the Plain");
    }

    landing = landingCheck(10);

    // GUESSING GAME
    GuessingGame game = new GuessingGame();
    game.PlayGame();

    // EXPEDITION PREP
    MarsExpedition prep = new MarsExpedition();
    prep.ExpeditionPrep();

    // FINDING LIST
    FindingsList postWorks = new FindingsList();
    postWorks.CollectThings();
  }

  public static boolean landingCheck(int minutesLeft) throws InterruptedException {
    for (int minute = 0; minute <= minutesLeft; minute ++) {
      if ((minute % 2 == 0) && (minute % 3 == 0)) {
        System.out.println("Keep Center");
      }else if (minute % 2 == 0) {
        System.out.println("Right");
      } else if (minute % 3 == 0) {
        System.out.println("Left");
      } else {
        System.out.println("Calculating");
      }
      Thread.sleep(250);
    }
    System.out.println("Landed");
    return false;
  }
}