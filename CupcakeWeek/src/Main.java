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

class Cupcake {
  public double price;

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void type() {
    System.out.println("A basic, generic cupcake, with vanilla frosting.");
  }
}

class RedVelvet extends Cupcake {
  @Override
  public void type() {
    System.out.println("A red velvet based cupcake, with cream cheese frosting.");
  }
}

class Chocolate extends Cupcake {
  @Override
  public void type() {
    System.out.println("A chocolate based cupcake, with chocolate frosting.");
  }
}

class Drink {
  public double price;

  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public void type() {
    System.out.println("A bottle of water.");
  }
}

class Soda extends Drink {
  @Override
  public void type() {
    System.out.println("A bottle of soda.");
  }
}

class Milk extends Drink {
  @Override
  public void type() {
    System.out.println("A bottle of milk.");
  }
}
