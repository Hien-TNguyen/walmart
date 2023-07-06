import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
  public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {
    System.out.println("Hello customer. Would you like to place an order? (Y or N)");
    Scanner input = new Scanner(System.in);
    String placeOrder = input.nextLine();
    ArrayList<Object> order = new ArrayList<>();
    if (placeOrder.equalsIgnoreCase("y")) {
      order.add(LocalDate.now());
      order.add(LocalTime.now());
      System.out.println("Here is the menu.");
      System.out.println("CUPCAKES:");
      int itemNumber = 0;
      for (int i = 0; i < cupcakeMenu.size(); i++) {
        itemNumber += 1;
        System.out.println("Item number is " + itemNumber);
        cupcakeMenu.get(i).type();
        System.out.println("Price is " + cupcakeMenu.get(i).price);
        System.out.println("\n"); 
      }

      System.out.println("DRINKS:"); 
      // create a for loop that iterates through each index of drinkMenu
      for (int i = 0; i < drinkMenu.size(); i++) {
        itemNumber += 1;
        System.out.println("Item number is " + itemNumber);
        drinkMenu.get(i).type();
        System.out.println("Price is " + drinkMenu.get(i).price);
        System.out.println("\n"); 
      }
      // create a boolean variable ordering
      boolean ordering = true;

      while (ordering) {
        System.out.println("What would you like to order? Please use the number associated with each item to order.");
        int orderChoice = input.nextInt();
        input.nextLine();

        if (orderChoice == 1) {
          order.add(cupcakeMenu.get(0));
          System.out.println("Item added to order.");
        } else if (orderChoice == 2) {
          order.add(cupcakeMenu.get(1));
          System.out.println("Item added to order.");
        } else if (orderChoice == 3) {
          order.add(cupcakeMenu.get(2));
          System.out.println("Item added to order.");
        } else if (orderChoice == 4) {
          order.add(drinkMenu.get(0));
          System.out.println("Item added to order.");
        } else if (orderChoice == 5) {
          order.add(drinkMenu.get(1));
          System.out.println("Item added to order.");
        } else if (orderChoice == 6) {
          order.add(drinkMenu.get(2));
          System.out.println("Item added to order.");
        } else {
          System.out.println("Sorry, we don't seem to have that on the menu");
        } 
        System.out.println("Would you like to continue ordering? (Y/N)");
        // set placeOrder to input.nextLine()
        placeOrder = input.nextLine();
        //check if placeOrder not equal to Y, set ordering to false.
        if (!placeOrder.equalsIgnoreCase("Y")) {
          ordering = false;
        }
      }
        
    } else {
      System.out.println("Have a nice day then.");
    }
  }
}
