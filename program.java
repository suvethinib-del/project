import java.util.*;

class Food {
    int id;
    String name;
    double price;

    Food(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println(id + ". " + name + " - Rs." + price);
    }
}

class Order {
    String customerName;
    ArrayList<Food> items = new ArrayList<>();

    Order(String customerName) {
        this.customerName = customerName;
    }

    void addFood(Food food) {
        items.add(food);
    }

    void displayOrder() {

        if (items.isEmpty()) {
            System.out.println("Order is empty!");
            return;
        }

        double total = 0;

        System.out.println("\n===== ORDER DETAILS =====");
        System.out.println("Customer: " + customerName);

        // Nested loop
        for (int i = 0; i < items.size(); i++) {
            for (int j = i; j <= i; j++) {
                Food f = items.get(j);

                System.out.println(
                    f.name + " - Rs." + f.price
                );

                total = total + f.price;
            }
        }

        System.out.println("-------------------------");
        System.out.println("Total Amount: Rs." + total);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Array
        String[] categories = {
            "Pizza",
            "Burger",
            "Snacks",
            "Beverages",
            "Pasta"
        };

        // Collection
        ArrayList<Food> menu = new ArrayList<>();

        menu.add(new Food(1, "Pizza", 250));
        menu.add(new Food(2, "Burger", 150));
        menu.add(new Food(3, "French Fries", 100));
        menu.add(new Food(4, "Coke", 60));
        menu.add(new Food(5, "Pasta", 200));

        System.out.println("===== FOOD DELIVERY SYSTEM =====");

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        // OOP - Object creation
        Order order = new Order(name);

        int choice = 0;

        // Loop
        while (choice != 5) {

            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Display Food");
            System.out.println("2. Add Food");
            System.out.println("3. View Order");
            System.out.println("4. Show Categories");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            try {

                choice = sc.nextInt();

                // Switch case
                switch (choice) {

                    case 1:

                        System.out.println("\n===== FOOD MENU =====");

                        // For loop
                        for (Food food : menu) {
                            food.display();
                        }

                        break;

                    case 2:

                        System.out.print("Enter Food ID: ");
                        int id = sc.nextInt();

                        boolean found = false;

                        // Conditional statement + loop
                        for (Food food : menu) {

                            if (food.id == id) {

                                order.addFood(food);

                                System.out.println(
                                    food.name +
                                    " added to your order!"
                                );

                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Invalid Food ID!");
                        }

                        break;

                    case 3:

                        order.displayOrder();

                        break;

                    case 4:

                        System.out.println("\n===== CATEGORIES =====");

                        for (int i = 0; i < categories.length; i++) {
                            System.out.println(
                                (i + 1) + ". " + categories[i]
                            );
                        }

                        break;

                    case 5:

                        System.out.println(
                            "Thank you for using Food Delivery System!"
                        );

                        break;

                    default:

                        System.out.println(
                            "Invalid choice! Please try again."
                        );
                }

            } catch (InputMismatchException e) {

                System.out.println(
                    "ERROR: Please enter numbers only!"
                );

                sc.nextLine();
            }
        }

        sc.close();
    }
}