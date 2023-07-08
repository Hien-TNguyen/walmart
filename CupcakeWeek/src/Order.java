import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Order {
  public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {
    this.cupcakeMenu = cupcakeMenu;
    this.drinkMenu = drinkMenu;
  }

  public void takeOrder() {
    System.out.println("Hello customer. Would you like to place an order? (Y or N)");
    Scanner input = new Scanner(System.in);
    String placeOrder = input.nextLine();
    ArrayList<Object> order = new ArrayList<>();
    if (placeOrder.equalsIgnoreCase("y")) {
      order.add(LocalDate.now());
      order.add(LocalTime.now());
      // create a boolean variable ordering
      boolean ordering = true;
      Item[] items = {null, 
        cupcakeMenu.get(0), 
        cupcakeMenu.get(1),
        cupcakeMenu.get(2),
        drinkMenu.get(0),
        drinkMenu.get(1),
        drinkMenu.get(2)
      };
      while (ordering) {
        PrintMenu(cupcakeMenu, drinkMenu);
        System.out.println("What would you like to order? Please use the number associated with each item to order.");
        int orderChoice = input.nextInt();
        input.nextLine();
        if ((orderChoice > 0) && (orderChoice < items.length)) {
          order.add(items[orderChoice]);
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
      double subtotal = 0.0;
      for(Object line : order) {
        if (line instanceof Item) {
          Item lineItem = (Item)line;
          subtotal += lineItem.getPrice();
        }
      }
      System.out.println(String.format("Your total is: %.2f", subtotal));
      new WriteToFile("salesData.txt", order);
    } else {
      System.out.println("Have a nice day then.");
    }
  }
  private void PrintMenu(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {
      System.out.println("Here is the menu.");
      System.out.println("CUPCAKES:");
      int itemNumber = 0;
      for (int i = 0; i < cupcakeMenu.size(); i++) {
        itemNumber += 1;
        System.out.println("Item number is " + itemNumber);
        cupcakeMenu.get(i).type();
        System.out.println("Price is " + cupcakeMenu.get(i).getPrice());
        System.out.println("\n"); 
      }

      System.out.println("DRINKS:"); 
      // create a for loop that iterates through each index of drinkMenu
      for (int i = 0; i < drinkMenu.size(); i++) {
        itemNumber += 1;
        System.out.println("Item number is " + itemNumber);
        drinkMenu.get(i).type();
        System.out.println("Price is " + drinkMenu.get(i).getPrice());
        System.out.println("\n"); 
      }

  }
  private ArrayList<Cupcake> cupcakeMenu;
  private ArrayList<Drink> drinkMenu;
}

class WriteToFile {
  public WriteToFile(String filename, ArrayList<Object> order) {
    try {
      File file = new File(filename);
      boolean created = file.createNewFile();
      if (created) {
        System.out.println("File created: " + filename);
      } else {
        System.out.println("File already exists: " + filename);
      }
    } catch(IOException e) {
      System.out.println("An error occurred.");
    }
    try {
      FileWriter fw = new FileWriter(filename, true);
      PrintWriter salesWriter = new PrintWriter(fw);
      for (Object line: order) {
        if (line instanceof Item) {
          salesWriter.println(line);
        } else if (line instanceof LocalTime) {
          LocalTime time = (LocalTime)line;
          salesWriter.println(time.format(
            DateTimeFormatter.ISO_LOCAL_TIME));
        } else {
          salesWriter.println(line);
        }
      }
      salesWriter.close();
      System.out.println("Successfully wrote to the file.");

    } catch(IOException e) {
      System.out.println("bad things happened.");
    }
  }
}
