import java.util.ArrayList;
import java.util.Scanner;


public class Main {
  public static void main(String[] args) {
    // create a new ArrayList of Cupcake
    ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();
    Cupcake cupcake = new Cupcake();
    RedVelvet redVelvet = new RedVelvet();
    Chocolate chocolate = new Chocolate();

    getPriceFromUser(cupcake);
    getPriceFromUser(redVelvet);
    getPriceFromUser(chocolate);

    // ADD CUPCAKE TO THE MENU
    cupcakeMenu.add(cupcake);
    cupcakeMenu.add(redVelvet);
    cupcakeMenu.add(chocolate);
  }

  public static void getPriceFromUser(Cupcake cake) {
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
  public void type() {
    System.out.println("A red velvet based cupcake, with cream cheese frosting.");
  }
}

class Chocolate extends Cupcake {
  public void type() {
    System.out.println("A chocolate based cupcake, with chocolate frosting.");
  }
}
