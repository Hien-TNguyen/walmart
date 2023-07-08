import java.util.ArrayList;
import java.util.Scanner;


public class Main {
  public static void main(String[] args) {
    // create a new ArrayList of Cupcake
    ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();
    Cupcake cupcake = new Cupcake();
    RedVelvet redVelvet = new RedVelvet();
    Chocolate chocolate = new Chocolate();

    getCakePriceFromUser(cupcake);
    getCakePriceFromUser(redVelvet);
    getCakePriceFromUser(chocolate);

    // ADD CUPCAKE TO THE MENU
    cupcakeMenu.add(cupcake);
    cupcakeMenu.add(redVelvet);
    cupcakeMenu.add(chocolate);

    ArrayList<Drink> drinkMenu = new ArrayList<>();
    Drink water = new Drink();
    Soda soda = new Soda();
    Milk milk = new Milk();

    getDrinkPriceFromUser(water);
    getDrinkPriceFromUser(soda);
    getDrinkPriceFromUser(milk);

    drinkMenu.add(water);
    drinkMenu.add(soda);
    drinkMenu.add(milk);

    Order order = new Order(cupcakeMenu, drinkMenu);
    order.takeOrder();

  }

  public static void getCakePriceFromUser(Cupcake cake) {
    // create a Scanner object
    Scanner input = new Scanner(System.in);
    System.out.println("We are deciding on the price for our type of cupcake. Here is the description:");
    cake.type();
    System.out.println("How much would you like to charge for this cupcake? (input a numerical number taken to 2 decimal places.)");  
    // Get the user input price
    String priceText = input.nextLine();
    // Parse the text price to double
    double price = Double.parseDouble(priceText);
    cake.setPrice(price);
  }

    public static void getDrinkPriceFromUser(Drink drink) {
    // create a Scanner object
    Scanner input = new Scanner(System.in);
    System.out.println("We are deciding on the price for our type of drink. Here is the description:");
    drink.type();
    System.out.println("How much would you like to charge for this drink? (input a numerical number taken to 2 decimal places.)");  
    // Get the user input price
    String priceText = input.nextLine();
    // Parse the text price to double
    double price = Double.parseDouble(priceText);
    drink.setPrice(price);
  }
}

class Item {
  private double price;
  private String description;
  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public Item(String description) {
    this.description = description;
  }
  public String getDescription() {
    return description;
  }
  @Override 
  public String toString() {
    return String.format("%s: %.2f", description, price);
  }
  public void type() {
    System.out.println(getDescription());
  }
}

class Cupcake extends Item {
  public Cupcake() {
    super("A basic, generic cupcake, with vanilla frosting.");
  }
  public Cupcake(String description) {
    super(description);
  }
}

class RedVelvet extends Cupcake {
  public RedVelvet() {
    super("A red velvet based cupcake, with cream cheese frosting.");
  }
}

class Chocolate extends Cupcake {
  public Chocolate() {
    super("A chocolate based cupcake, with chocolate frosting.");
  }
}

class Drink extends Item {
  public Drink() {
    super("A bottle of water.");
  }
  public Drink(String description) {
    super(description);
  }
}

class Soda extends Drink {
  public Soda() {
    super("A bottle of soda.");
  }
}

class Milk extends Drink {
  public Milk() {
    super("A bottle of milk.");
  }
}
