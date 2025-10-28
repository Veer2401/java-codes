import java.util.Scanner;

abstract class Ticket {
    String passengerName;
    int age;
    double fare;

    Ticket(String passengerName, int age, double fare){
        this.passengerName = passengerName;
        this.age = age;
        this.fare = fare;
    }

    abstract void calculateFare();

    void display(){
        System.out.println("\n--- Ticket Details ---");
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Age: " + age);
        System.out.println("Final Fare: ₹" + fare);
    }
}

class AcCoach extends Ticket{

    AcCoach(String passengerName, int age, double price){
        super(passengerName, age, price);
    }

    void calculateFare(){
        fare = fare + (fare * 0.20);
        System.out.println("AC Coach selected: 20% extra charge applied.");
    }
}

class SleeperCoach extends Ticket{
    SleeperCoach(String passengerName, int age, double fare){
        super(passengerName, age, fare);    
    }

    void calculateFare(){
        fare = fare - (fare * 0.10);
        System.out.println("Sleeper coach selected. 10% Discount is applied.");
    }
}

public class Railway {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char moreTickets;

        System.out.println("Train Reservation System");

        do{
            System.out.print("Enter passenger Name: ");
            String name = sc.nextLine();

            System.out.print("Enter age: ");
            Integer age = Integer.valueOf(sc.nextLine());

            System.out.print("Enter base fare: ");
            Double baseFare = Double.valueOf(sc.nextLine());

            System.out.print("Select Coach Type: ");
            System.out.println("1. AC Coach");
            System.out.println("2. Sleeper");
            int choice = sc.nextInt(); sc.nextLine();

            Ticket t;

            if(choice == 1){
                t = new AcCoach(name, age, baseFare);
            }else{
                t = new SleeperCoach(name, age, baseFare);
            }

            t.calculateFare();
            t.display();

            System.out.println("Do you want to add another ticket? (Y/N)");
            moreTickets = sc.next().charAt(0);
            sc.nextLine();
        }while(moreTickets == 'Y' || moreTickets == 'y');

        sc.close();
    }
}
