//PROJECT ON JAVA(E COMMERCE SHOPPING CART SYSTEM) 
// Import necessary classes 
import java.util.ArrayList; 
import java.util.List; 
import java.util.Scanner; 
             /*     PRODUCT CLASS */ 
  class Product { 
    int id; 
    String name; 
    double price; 
             // Constructor to initialize product details 
    Product(int id, String name, double price) { 
        this.id = id; 
        this.name = name; 
        this.price = price; 
    } 
            // Display product details 
    void display() { 
        System.out.println(id + ". " + name + " - Rs." + price); 
    } 
} 
           /*     CART CLASS 
   Stores selected products  */ 
class Cart { 
    // List to store products added to cart 
    List<Product> items = new ArrayList<>(); 
                       // Add product to cart 
    void addToCart(Product p) { 
        items.add(p); 
        System.out.println(p.name + " added to cart."); 
    } 
               // View items in the cart 
    void viewCart() { 
        if (items.isEmpty()) { 
            System.out.println("Cart is empty."); 
            return; 
        } 
   System.out.println("\n--- Your Cart ---"); 
        double total = 0; 
 
                       // Display each item in cart 
        for (Product p : items) { 
            System.out.println(p.id + ". " + p.name + " - Rs." + p.price); 
            total += p.price; 
                            // Display total price 
        System.out.println("Total: Rs." + total); 
    } 
} 
 
                 /*     MAIN CLASS  */ 
public class Main { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
                          // Create a list of products (like database) 
        ArrayList<Product> products = new ArrayList<>(); 
        products.add(new Product(1, "Mobile", 15000)); 
        products.add(new Product(2, "Laptop", 55000)); 
        products.add(new Product(3, "Headphones", 1200)); 
        products.add(new Product(4, "Smart Watch", 2500)); 
 
                             // Create cart object 
        Cart cart = new Cart(); 
                            // Infinite loop for menu-driven system 
        while (true) { 
            System.out.println("\n--- E-Commerce Shopping System ---"); 
            System.out.println("1. View Products"); 
            System.out.println("2. Add to Cart"); 
            System.out.println("3. View Cart"); 
            System.out.println("4. Exit"); 
            System.out.print("Enter choice: "); 
 
            int ch = sc.nextInt();  // User choice 
 
            switch (ch) { 
 
                // Display all products 
                case 1: 
                    System.out.println("\n--- Product List ---"); 
                    for (Product p : products) { 
                        p.display(); 
                    } 
                    break; 
 
                // Add selected product to cart 
                case 2: 
                    System.out.print("Enter product ID to add to cart: "); 
                    int id = sc.nextInt(); 
 
                    boolean found = false; 
 
                    // Search for product by ID 
                    for (Product p : products) { 
                        if (p.id == id) { 
                            cart.addToCart(p); 
                            found = true; 
                            break; 
                        } 
                    } 
 
                    // If product not found 
                    if (!found) { 
                        System.out.println("Invalid product ID!"); 
                    } 
                    break; 
 
                // View cart items 
                case 3: 
                    cart.viewCart(); 
                    break; 
 
                // Exit the program 
                case 4: 
                    System.out.println("Thank you for shopping!"); 
                    return; 
 
                // Invalid menu choice 
                default: 
                    System.out.println("Invalid choice!"); 
            } 
        } 
    } 
} 
 