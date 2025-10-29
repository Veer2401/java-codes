import java.util.*;

public class Inventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> products = new ArrayList<>();
        LinkedList<String> log = new LinkedList<>();
        HashSet<Integer> productIDs = new HashSet<>();
        TreeSet<String> categories = new TreeSet<>();

        int choice;

        do {
            System.out.println("\n===== INVENTORY MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Show All Products");
            System.out.println("4. Show Categories");
            System.out.println("5. Show Recent Activity Log");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear input buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    // Check for duplicate ID
                    if (productIDs.contains(id)) {
                        System.out.println("⚠️ Product ID already exists! Duplicate not added.");
                        break;
                    }

                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();

                    // Check for duplicate name
                    if (products.contains(name)) {
                        System.out.println("⚠️ Product name already exists!");
                        break;
                    }

                    System.out.print("Enter product category: ");
                    String cat = sc.nextLine();

                    // Add to data structures
                    productIDs.add(id);
                    products.add(name);
                    categories.add(cat);
                    log.addFirst("✅ Added: " + name + " (ID: " + id + ", Category: " + cat + ")");

                    System.out.println("✅ Product added successfully!");
                }

                case 2 -> {
                    System.out.print("Enter product name to remove: ");
                    String name = sc.nextLine();

                    if (products.remove(name)) {
                        log.addFirst("🗑 Removed: " + name);
                        System.out.println("🗑 Product removed.");
                    } else {
                        System.out.println("❌ Product not found.");
                    }
                }

                case 3 -> {
                    System.out.println("\n--- Product List ---");
                    if (products.isEmpty())
                        System.out.println("No products available!");
                    else {
                        for (String p : products)
                            System.out.println(p);
                        System.out.println("Total Products: " + products.size());
                    }
                }

                case 4 -> {
                    System.out.println("\n--- Categories (Sorted & Unique) ---");
                    if (categories.isEmpty())
                        System.out.println("No categories found!");
                    else
                        for (String c : categories)
                            System.out.println(c);
                }

                case 5 -> {
                    System.out.println("\n--- Recent Activity Log ---");
                    if (log.isEmpty())
                        System.out.println("No recent actions recorded!");
                    else
                        for (String entry : log)
                            System.out.println(entry);
                }

                case 6 -> System.out.println("Exiting... Bye!");

                default -> System.out.println("Invalid choice. Try again!");
            }

        } while (choice != 6);

        sc.close();
    }
}
