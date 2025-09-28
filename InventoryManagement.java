

import java.util.*;

class Product {
    private final int id;
    private String name, cat, warehouse;
    private double price;
    private int qty;

    public Product(int id, String name, String cat, double price, int qty, String warehouse){
        this.id = id;
        this.name = name;
        this.cat = cat;
        this.price = price;
        this.qty = (qty < 0) ? 0 : qty;
        this.warehouse = warehouse;
    }

    public String getDetails(){
        return "ID: " + id + " | Name: " + name + " | Category: " + cat +
               " | Price: " + price + " | Qty: " + qty + " | Warehouse: " + warehouse;
    }

    public int getId(){ return id; }
    public String getCategory(){ return cat; }

    @Override
    public String toString(){
        return getDetails();
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Product)) return false;
        Product p = (Product)o;
        return this.id == p.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}

public class InventoryManagement {

    static ArrayList<Product> inventory = new ArrayList<>();
    static LinkedList<String> productLog = new LinkedList<>();
    static HashSet<Integer> index = new HashSet<>();
    static TreeSet<String> category = new TreeSet<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        preData();
        run();
    }

    static void menu(){
        System.out.println("\n--- Amazon India---");
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. Search Product by Category");
        System.out.println("4. List all Products");
        System.out.println("5. Show Categories");
        System.out.println("6. Show Activity Log");
        System.out.println("7. Exit");
    }

    static void preData(){
        // preload some data
        Product p1 = new Product(1, "Laptop", "Electronics", 45000, 5, "BLR");
        Product p2 = new Product(2, "Book", "Stationery", 300, 20, "DEL");
        Product p3 = new Product(3, "Smartphone", "Electronics", 25000, 10, "MUM");

        inventory.addAll(Arrays.asList(p1,p2,p3));
        for(Product p : inventory){
            index.add(p.getId());
            category.add(p.getCategory());
            productLog.addFirst("Added: " + p.getDetails());
        }

        inventory.sort(Comparator.comparingInt(Product::getId));
    }

    static void add(){
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt(); sc.nextLine();
        if(index.contains(id)){
            System.out.println("ID already exists!");
            return;
        }
        System.out.print("Enter name: ");
        String n = sc.nextLine();
        System.out.print("Enter category: ");
        String c = sc.nextLine();
        System.out.print("Enter price: ");
        double pr = sc.nextDouble(); sc.nextLine();
        System.out.print("Enter quantity: ");
        int q = sc.nextInt(); sc.nextLine();
        System.out.print("Enter warehouse: ");
        String w = sc.nextLine();

        Product p = new Product(id, n, c, pr, q, w);
        inventory.add(p);
        index.add(id);
        category.add(c);
        productLog.addFirst("Added: " + p.getDetails());

        inventory.sort(Comparator.comparingInt(Product::getId));
        System.out.println("Product added!");
    }

    static void remove(){
        System.out.print("Enter Product ID to remove: ");
        int id = sc.nextInt(); sc.nextLine();
        boolean found = false;

        Iterator<Product> it = inventory.iterator();
        while(it.hasNext()){
            Product p = it.next();
            if(p.getId() == id){
                it.remove();
                index.remove(id);
                productLog.addFirst("Removed: " + p.getDetails());
                System.out.println("Product removed.");
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Product not found!");
        }
    }

    static void search(){
        System.out.print("Enter category: ");
        String c = sc.nextLine();
        boolean f = false;

        for(Product p : inventory){
            if(p.getCategory().equalsIgnoreCase(c)){
                System.out.println(p.getDetails());
                f = true;
            }
        }
        if(!f){
            System.out.println("No products in this category.");
        }
    }

    static void list(){
        if(inventory.isEmpty()){
            System.out.println("No products available!");
            return;
        }
        System.out.println("--- All Products ---");
        for(Product p : inventory){
            System.out.println(p.getDetails());
        }
    }

    static void categories(){
        System.out.println("--- Categories ---");
        for(String c : category){
            System.out.println(c);
        }
    }

    static void log(){
        System.out.println("--- Product Log ---");
        for(String s : productLog){
            System.out.println(s);
        }
    }

    static void run(){
        int ch;
        do{
            menu();
            System.out.print("Enter choice: ");
            ch = sc.nextInt(); sc.nextLine();

            switch(ch){
                case 1 -> add();
                case 2 -> remove();
                case 3 -> search();
                case 4 -> list();
                case 5 -> categories();
                case 6 -> log();
                case 7 -> System.out.println("Exiting... Bye!");
                default -> System.out.println("Invalid choice!");
            }
        }while(ch != 7);
    }
}
