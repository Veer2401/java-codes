import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;

class Product {
    int id;
    String name,category;

    Product(int id, String name, String category){
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public String toString(){
        return id + " | " + name + " | " + category;
    }
}

public class Inventory {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Product> products = new ArrayList<>();
    static LinkedList<String> log = new LinkedList<>();
    static HashSet<Integer> productIDs = new HashSet<>();
    static TreeSet<String> categories = new TreeSet<>();

    public static void main(String[] args) {
        int choice;

        do{
            System.out.println("------------Inventory Menu------------");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Show all Products");
            System.out.println("4. Show Categories");
            System.out.println("5. Show recent activity");
            System.out.println("6. Search");
            System.out.println("7. Exiting");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice){
                case 1: add();
                break;

                case 2: remove();
                break;

                case 3: showProducts();
                break;

                case 4: showCategories();
                break;

                case 5: activityLog();
                break;

                case 6: search();
                break;

                case 7:
                System.out.println("Exiting...");
                break;
                
                default:
                System.out.println("Please enter correct choice!");

            }


        }while(choice != 7);

        sc.close();
    }

    static void add(){
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt(); sc.nextLine();

        if(productIDs.contains(id)){
            System.out.println("Product ID already Exists! Please choose a different profuct ID");
            return;
            
        }

        System.out.print("Enter Procut Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Product Category: ");
        String cat = sc.nextLine();

        Product p = new Product(id, name, cat);
        productIDs.add(id);
        products.add(p);
        categories.add(cat);
        log.addFirst("Added: " + id + ". |" + name + " | " + cat );

        System.out.println("Product Added Successfully!");
    }

    static void remove(){
        System.out.print("Enter Product ID to remove: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        Iterator<Product> it = products.iterator();
        while(it.hasNext()){
            Product p = it.next();
            if(p.id == id){
                it.remove();
                productIDs.remove(id);
                log.addFirst("Removed " + p);
                System.out.println("Product removed successfully");
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("Product not found!");
        }
    }

    static void showProducts(){
        System.out.println("--------Product List---------");
        if(products.isEmpty()){
            System.out.println("No products available!");
        }else{
            for(Product p : products){
                System.out.println(p);
                System.out.println("Total Products: " + products.size());
            }
        }
    }

    static void showCategories(){
        System.out.println("--------Categories-----------");
        if(categories.isEmpty()){
            System.out.println("No categories found!");
        }else{
            for(String c : categories){
                System.out.println(c);
                
            }
        }
    }
    static void activityLog(){
        System.out.println("-----Recent Activity-------");
        if(log.isEmpty()){
            System.out.println("No recent log recorded!");
        }else{
            for(String entry : log){
                System.out.println(entry);
            }
        }
    }
    
    static void search(){
        System.out.println("Enter Product id to Search");
        int id = sc.nextInt();
        sc.nextLine();

    

        for(Product p : products){
            if(p.id == id){
                System.out.println("Product found: " + p);
                return;
            }
        }
        System.out.println("Product not found!");
    }
    
}
