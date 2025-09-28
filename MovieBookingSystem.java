

//java assignment 6

import java.util.Scanner;

class Movie {
    int id;
    String name;

    Movie(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void display(){
        System.out.println(id + ". " + name);
    }
}

class Theatre {
    int id;
    String name;

    Theatre(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void display(){
        System.out.println(id + ". " + name);
    }
}

class Show {
    int id;
    String time;

    Show(int id, String time){
        this.id = id;
        this.time = time;
    }

    public void display(){
        System.out.println(id + ". " + time);
    }
}

class SeatThread extends Thread {
    String user;

    SeatThread(String user){
        this.user = user;
    }

    public void run(){
        try{
            System.out.println(user + " -> checking seats...");
            Thread.sleep(1000);
            System.out.println(user + " -> seat locked!");
        }catch(InterruptedException e){
            System.out.println("Problem while loading seats for " + user);
        }
    }
}

class Payment implements Runnable {
    String user;
    String mode;

    Payment(String user){
        this.user = user;
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\n== Payment Options for " + user + " ==");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.println("3. Net Banking");
        System.out.print("Choose method: ");
        int ch = sc.nextInt();

        switch(ch){
            case 1: mode = "UPI"; break;
            case 2: mode = "Card"; break;
            case 3: mode = "NetBanking"; break;
            default: mode = "Unknown"; System.out.println("Invalid option!");
        }

        try{
            System.out.println(user + " -> processing payment...");
            Thread.sleep(3000);
            System.out.println(user + " -> Paid using " + mode);
        }catch(Exception e){
            System.out.println(user + " -> Payment failed.");
        }
        sc.close();
    }

    public String getMode(){
        return mode;
    }
}

class UserBooking extends Thread {
    String user;

    UserBooking(String user){
        this.user = user;
    }

    public void run(){
        try{
            System.out.println(user + " is booking a ticket...");
            Thread.sleep(1000);
            System.out.println(user + " booked a ticket!");
        }catch(Exception e){
            System.out.println(user + " booking failed.");
        }
    }
}

public class MovieBookingSystem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("==== Movie Ticket Booking System ====");
        System.out.println("1. Login");
        System.out.println("2. Exit");

        try{
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch(ch){
                case 1:
                    System.out.println("Login successful!");

                    Movie[] movies = {
                        new Movie(1, "F1 The Movie"),
                        new Movie(2, "Saiyaara"),
                        new Movie(3, "The Bengal Files")
                    };

                    System.out.println("\nMovies:");
                    for(Movie m : movies){
                        m.display();
                    }
                    System.out.print("Pick a movie: ");
                    int mChoice = sc.nextInt();
                    Movie m = null;
                    try{
                        m = movies[mChoice-1];
                        System.out.println("You selected movie: " + m.name);
                    }catch(Exception e){
                        System.out.println("Wrong movie!");
                        System.exit(0);
                    }

                    Theatre[] ths = {
                        new Theatre(1,"PVR"),
                        new Theatre(2,"INOX"),
                        new Theatre(3,"Cinepolis")
                    };
                    System.out.println("\nTheatres:");
                    for(Theatre t : ths){
                        t.display();
                    }
                    System.out.print("Pick a theatre: ");
                    int tChoice = sc.nextInt();
                    Theatre t = null;
                    try{
                        t = ths[tChoice-1];
                        System.out.println("You selected theatre: " + t.name);
                    }catch(Exception e){
                        System.out.println("Wrong theatre!");
                        System.exit(0);
                    }

                    Show[] shows = {
                        new Show(1,"8:00 AM"),
                        new Show(2,"2:00 PM"),
                        new Show(3,"7:00 PM")
                    };
                    System.out.println("\nShows:");
                    for(Show s : shows){
                        s.display();
                    }
                    System.out.print("Pick a show: ");
                    int sChoice = sc.nextInt();
                    Show s = null;
                    try{
                        s = shows[sChoice-1];
                        System.out.println("Show time: " + s.time);
                    }catch(Exception e){
                        System.out.println("Wrong show!");
                        System.exit(0);
                    }

                    System.out.print("Enter your name: ");
                    sc.nextLine();
                    String uname = sc.nextLine();

                    SeatThread seatTh = new SeatThread(uname);
                    seatTh.start();
                    seatTh.join();

                    Payment pay = new Payment(uname);
                    Thread payTh = new Thread(pay);
                    payTh.start();
                    payTh.join();

                    System.out.println("\n==== BOOKING CONFIRMATION ====");
                    System.out.println("Movie: " + m.name);
                    System.out.println("Theatre: " + t.name);
                    System.out.println("Show: " + s.time);
                    System.out.println("User: " + uname);
                    System.out.println("Ticket booked successfully!\n");

                    System.out.println("==== MULTI-USER TEST ====");
                    UserBooking u1 = new UserBooking("Pranav");
                    UserBooking u2 = new UserBooking("Shubham");
                    u1.start();
                    u2.start();

                    break;
                case 2:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice!");
            }
        }catch(Exception e){
            System.out.println("Invalid input. Try again.");
        }

        sc.close();
    }
}
