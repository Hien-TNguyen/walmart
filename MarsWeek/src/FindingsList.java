import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;


public class FindingsList {
  public FindingsList() throws InterruptedException {
  }

  public void CollectThings() throws InterruptedException {
    Thread.sleep(500);
    ListRocks();
    System.out.println("Loading fossil data ...");
    Thread.sleep(1000);
    StoreFossils();
    System.out.println("Loading special supplies used");
    Thread.sleep(700);
    CheckSpecialSupplies();
  }

  private void ListRocks() {
    // display welcome back message
    System.out.println("Welcome back to the Earth!");

    // Create an array to store things
    ArrayList<String> rockCollection = new ArrayList<String>();
    rockCollection.add("rock");
    rockCollection.add("weird rock");
    rockCollection.add("smooth rock");
    rockCollection.add("not rock");

    // Print the list of rocks
    System.out.println("Everything is downloaded. Here are the items");
    System.out.println(rockCollection);

    System.out.println("Oops, there is non-rock in the list. Please remove it!");
    // Remove non-rocks
    rockCollection.remove("not rock");
    // Print the list again
    System.out.println(rockCollection);
  }

  private void StoreFossils() {
    // create a HashMap
    HashMap<String, String> fossils = new HashMap<String, String>();
    // add fossils into the HashMap
    fossils.put("Bird Fossil", "The fossil has wings implying it was capable of flight");
    fossils.put("Fish Fossil", "The fossil is vaguely fish shaped implies there was once water");
    fossils.put("Tooth Fossil", "The tooth from an unknown fossil");
    // Print Fossil data 
    System.out.println(fossils);

    System.out.println("Which fossils would you like to learn more about?");
    Scanner input = new Scanner(System.in);
    String fossilChoice = input.next();

    if (fossilChoice.equalsIgnoreCase("Bird")) {
      System.out.println(String.format("Fossil: %s \nDescription: %s", fossilChoice, fossils.get("Bird Fossil")));
    } else if (fossilChoice.equalsIgnoreCase("Fish")) {
      System.out.println(String.format("Fossil: %s \nDescription: %s", fossilChoice, fossils.get("Fish Fossil")));
    } else if (fossilChoice.equalsIgnoreCase("Tooth")) {
      System.out.println(String.format("Fossil: %s \nDescription: %s", fossilChoice, fossils.get("Tooth Fossil")));
    }
  }

  private void CheckSpecialSupplies() {
    // create an HashSet to store special supplies
    HashSet<String> supplies = new HashSet<>();
    // Add items into the HashSet
    supplies.add("Food");
    supplies.add("Water");
    supplies.add("Medicine");

    // Print the items in the HashSet
    Iterator<String> itr = supplies.iterator();

    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
    // Remove one of the items 
    supplies.remove("Medicine");

    // Print the HashSet again
    System.out.println("The new list is: ");
    itr = supplies.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }

}
