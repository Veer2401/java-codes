import java.util.Scanner;

class Food {
    int id;
    String foodName;

    Food(int id, String foodName){
        this.id = id;
        this.foodName = foodName;
    }

    public void display(){
        System.out.println(id + " , " + foodName);
    }
}

class Payment implements Runnable {
    String customer; 

    Payment(String customer){
        this.customer = customer;
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        String method = "";

        System.out.println("\n------ Payment Options ------");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.println("3. Cash on Delivery");
        System.out.print("Choose How You will Pay.");
        int ch = sc.nextInt();
        sc.nextLine();

        switch(ch){
            case 1: method = "UPI";
            break;
            case 2: method = "Card";
            break;
            case 3: method = "Case on delivery";
            break;
            default:
            System.out.println("Invalid option!");
        }

        try{
            System.out.println("Processing Payment via... " + method);
            Thread.sleep(2500);
            System.out.println("Payment was successful using " + method);
        }catch(InterruptedException e){
            System.out.println("Payment failed! Please try again");
        }
    }
}

class DeliveryCounter {
    private boolean orderAvail = true;

    public synchronized void deliverOrder(String agentName, String customer, String food){
            if(orderAvail){
                System.out.println("Food was picked up by " + agentName + " for " + customer);
                //orderAvail = false;
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    System.out.println("Delivery interuppted!");
                }
                System.out.println(food + " was delivered by " + agentName);
            }else{
                System.out.println("no order available!");
            }
    }
}

class DeliveryAgent extends Thread {
    String agentName,customer,food;
    DeliveryCounter counter;

    DeliveryAgent(String agentName, String customer, String food, DeliveryCounter counter){
        this.agentName = agentName;
        this.customer = customer;
        this.food = food;
        this.counter = counter;
    }

    public void run(){
        counter.deliverOrder(agentName, customer, food);
    }
}

public class FoodSystem {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n---------------Food Delivery System------------");


        Food[] menu = {
            new Food(1, "Pizza"),
            new Food(2, "Burger"),
            new Food(3, "Pasta"),
            new Food(4, "Sandwich")
        };

        System.out.println("Enter customer name: ");
        String customer = sc.nextLine();

        System.out.println("Menu: ");
        for(Food f : menu){
            f.display();
        }

        System.out.println("Select food item number: ");
        int choice = sc.nextInt();
        sc.nextLine();

        String order = menu[choice - 1].foodName;

        Payment payment = new Payment(customer);
        Thread payThread = new Thread(payment);
        payThread.start();
        payThread.join();


        System.out.println("Agents: ");
        DeliveryCounter counter = new DeliveryCounter();

        DeliveryAgent a1 = new DeliveryAgent("Zomato", customer, order, counter);
        DeliveryAgent a2 = new DeliveryAgent("Swiggy", customer, order, counter);
        DeliveryAgent a3 = new DeliveryAgent("Eat Club", customer, order, counter);

        a1.setPriority(Thread.MIN_PRIORITY);
        a2.setPriority(Thread.NORM_PRIORITY);
        a3.setPriority(Thread.MAX_PRIORITY);

        System.out.println(a1.agentName + " Priority: " + a1.getPriority());
        System.out.println(a2.agentName + " Priority: " + a2.getPriority());
        System.out.println(a3.agentName + " Priority: " + a3.getPriority());


        a1.start();
        a2.start();
        a3.start();

        a1.join();
        a2.join();
        a3.join();
        System.out.println("Delivery Completed!");

        sc.close();

    }
}