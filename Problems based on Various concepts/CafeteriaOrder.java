import java.util.Scanner;

class Cafeteria {
    double total = 0;

    void showMenu(){
        System.out.println("------------Neha Cafe------------");
        System.out.println("1. Sandwich - $50");
        System.out.println("2. Coffee - $40");
        System.out.println("3. Burger - $70");
        System.out.println("4. Exit");
    }

    void placeOrder(int choice , int quantity){
        switch(choice){
            case 1:
            total += 50 * quantity;
            System.out.println("You Ordered x" + quantity + " Sandwich");
            break;

            case 2:
            total += 40 * quantity;
            System.out.println("You Ordered x" + quantity + " Coffee");
            break;

            case 3: 
            total += 70 * quantity;
            System.out.println("You Ordered x" + quantity + " Burger");
            break;

            case 4:
            System.out.println("Exiting menu...");
            break;

            default:
            System.out.println("Please enter a correct choice!");
        }
    }

    void displayBill(){
        System.out.println("\n--------FINAL BILL-------");
        System.out.println("Total amount: $" + total);

        if(total > 300){
            double discount = total * 0.1;
            System.out.println("You got a discount of $" + discount);
            System.out.println("Amount to pay: $" + (total - discount));
        }else{
            System.out.println("No discount applied.");
            System.out.println("Amount to Pay: ₹" + total);
        }

        System.out.println("Thankyou! Visit Again.");

    }
}
public class CafeteriaOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cafeteria cafe = new Cafeteria();

        cafe.showMenu();

        char orderAgain;
        int choice,quantiy;

        do{
            System.out.print("Enter Your choice: (1-4)");
            choice = sc.nextInt();
            sc.nextLine();

            if(choice == 4){
                break;
            }

            System.out.print("Enter Quantity: ");
            quantiy = sc.nextInt();
            sc.nextLine();

            cafe.placeOrder(choice, quantiy);

            System.out.print("Do you want to order more? (Y/N)");
            orderAgain = sc.next().charAt(0);
        }while(orderAgain == 'Y' || orderAgain == 'y');

        cafe.displayBill();
        sc.close();
    }
}
