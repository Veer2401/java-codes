package RailwayReservation.src.railway.main;

// java assignment 5

import java.util.Scanner;

import RailwayReservation.src.railway.booking.*;
import RailwayReservation.src.railway.login.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Login log = new UserLogin();
        log.message();

        System.out.print("\nEnter Username: ");
        String username = sc.nextLine();
        System.out.print("\nEnter Password: ");
        String password = sc.nextLine();

        if(log.login(username, password)){
            System.out.println("Signed in Successfully! ");

            Ticket t = new Ticket();

            t.destination();
            System.out.println("\n");
            t.selectTrain();
            t.selectQuota();
            t.numberOfPassengers();
            t.bookingConfirmation();

        } else {
            System.out.println("Login failed! ");
        }
        sc.close();
    }
}
