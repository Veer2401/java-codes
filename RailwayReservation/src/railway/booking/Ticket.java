package RailwayReservation.src.railway.booking;

import java.util.*;

public class Ticket extends Booking {
    
    Integer trainChoice,numberOfPassengers;
    Character selectQuota;
    String from,to,trainName;

    Scanner sc = new Scanner(System.in);

    @Override
    public void destination(){
        System.out.print("Departure: ");
        from = sc.nextLine();
        System.out.print("Arrival: ");
        to = sc.nextLine();

        System.out.println("Getting results for " + from + " to " + to + "...");
    }

    public void selectTrain(){
        System.out.println("Available Trains to " + to + " 🚉");
        System.out.println("1. Tejas Express");
        System.out.println("2. Deccan Queen Express");
        System.out.println("3. Coimbatore Express");
        System.out.println("4. Golden Chariot Luxury Train");
        System.out.println("5. Vande Bharat Express");

        System.out.print("Enter Train number (1 to 5): ");
        trainChoice = sc.nextInt();
        sc.nextLine();

        switch(trainChoice){
            case 1: trainName = "Tejas Express";
            System.out.println(trainName);
            break;
            case 2: trainName = "Deccan Queen Express";
            System.out.println(trainName);
            break;
            case 3: trainName = "Coimbatore Express";
            System.out.println(trainName);
            break;
            case 4: trainName = "Golden Chariot Luxury Train";
            System.out.println(trainName);
            break;
            case 5: trainName = "Vande Bharat Express";
            System.out.println(trainName);
            break;
            default: System.out.println("Invalid choice!");
            break;
        }
    }

    public void selectQuota(){
        System.out.println("Available quota: ");
        System.out.println("a. Reservation");
        System.out.println("b. General");
        System.out.println("c. Tatkaal");
        System.out.println("d. Ladies");

        System.out.print("Enter Quota choice (a to d): ");
        selectQuota = sc.next().charAt(0);
        sc.nextLine();

        switch(selectQuota) {
            case 'a': System.out.println("Reservation");
            break;
            case 'b': System.out.println("General");
            break;
            case 'c': System.out.println("Tatkaal");
            break;
            case 'd': System.out.println("Ladies");
            break;
            default: System.out.println("Invalid Choice");
            break;
        }
    }

    public void numberOfPassengers(){
        System.out.print("Enter number of passengers: ");
        numberOfPassengers = sc.nextInt();
        sc.nextLine();
    }

    public void bookingConfirmation(){
        System.out.println("\n------ Booking confirmation -------- ");
        System.out.println("Your Booking Has Been Confirmed! ✅ ");
        System.out.println(from.toUpperCase() + " to " + to.toUpperCase());
        System.out.println("Train: " + trainName.toUpperCase());
        System.out.println("Quota: " + selectQuota);
        System.out.println("Number of passengers: " + numberOfPassengers);
    }
}
