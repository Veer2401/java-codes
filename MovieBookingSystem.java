import java.util.Scanner;

// ------------------ Movie Class ------------------
class Movie {
    int id;
    String name;

    Movie(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.println(id + ". " + name);
    }
}

// ------------------ Theatre Class ------------------
class Theatre {
    int id;
    String name;

    Theatre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.println(id + ". " + name);
    }
}

// ------------------ Show Class ------------------
class Show {
    int id;
    String time;

    Show(int id, String time) {
        this.id = id;
        this.time = time;
    }

    public void display() {
        System.out.println(id + ". " + time);
    }
}

// ------------------ Seat Checking Thread ------------------
class SeatThread extends Thread {
    String user;

    SeatThread(String user) {
        this.user = user;
    }

    public void run() {
        try {
            System.out.println(user + " -> Checking seat availability...");
            Thread.sleep(1500);
            System.out.println(user + " -> Seat locked successfully!");
        } catch (InterruptedException e) {
            System.out.println("Error while checking seats for " + user);
        }
    }
}

// ------------------ Payment Runnable ------------------
class Payment implements Runnable {
    String user, mode;

    Payment(String user) {
        this.user = user;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n------Payment Options------");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.println("3. Net Banking");
        System.out.print("Choose your payment method: ");
        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                mode = "UPI";
                break;
            case 2:
                mode = "Card";
                break;
            case 3:
                mode = "Net Banking";
                break;
            default:
                mode = "Unknown";
                System.out.println("Invalid option!");
        }

        try {
            System.out.println(user + " -> Processing payment...");
            Thread.sleep(2000);
            System.out.println(user + " -> Payment successful using " + mode);
        } catch (InterruptedException e) {
            System.out.println(user + " -> Payment failed due to interruption.");
        }
    }
}

// ------------------ Shared Ticket Counter ------------------
class TicketCounter {
    private int seatsAvailable = 3;

    public synchronized void bookSeat(String user) {
        if (seatsAvailable > 0) {
            System.out.println(user + " successfully booked a seat!");
            seatsAvailable--;
        } else {
            System.out.println(user + " tried to book, but no seats left!");
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Booking interrupted for " + user);
        }
    }
}

// ------------------ User Booking Thread ------------------
class UserBooking extends Thread {
    String user;
    TicketCounter counter;

    UserBooking(String user, TicketCounter counter) {
        this.user = user;
        this.counter = counter;
    }

    public void run() {
        counter.bookSeat(user);
    }
}

// ------------------ MAIN CLASS ------------------
public class Thread1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------- Movie Ticket Booking System ---------");
        System.out.println("1. Login");
        System.out.println("2. Exit");

        try {
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter username: ");
                    String userName = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    // ✅ Correct way to compare strings in Java
                    if (userName.equals("User") && password.equals("123")) {
                        System.out.println("Login successful!");

                        // Movies
                        Movie[] movies = {
                            new Movie(1, "F1 The Movie"),
                            new Movie(2, "Saiyaara"),
                            new Movie(3, "The Bengal Files")
                        };
                        System.out.println("\nMovies:");
                        for (Movie m : movies) m.display();
                        System.out.print("Pick a movie: ");
                        int mChoice = sc.nextInt();
                        Movie selectedMovie = movies[mChoice - 1];

                        // Theatres
                        Theatre[] theatres = {
                            new Theatre(1, "PVR"),
                            new Theatre(2, "INOX"),
                            new Theatre(3, "Cinepolis")
                        };
                        System.out.println("\nTheatres:");
                        for (Theatre t : theatres) t.display();
                        System.out.print("Pick a theatre: ");
                        int tChoice = sc.nextInt();
                        Theatre selectedTheatre = theatres[tChoice - 1];

                        // Shows
                        Show[] shows = {
                            new Show(1, "8:00 AM"),
                            new Show(2, "2:00 PM"),
                            new Show(3, "7:00 PM")
                        };
                        System.out.println("\nShows:");
                        for (Show s : shows) s.display();
                        System.out.print("Select a show: ");
                        int sChoice = sc.nextInt();
                        Show selectedShow = shows[sChoice - 1];

                        sc.nextLine(); // clear buffer
                        System.out.print("Enter your name: ");
                        String uName = sc.nextLine();

                        // --- Seat Thread ---
                        SeatThread seat = new SeatThread(uName);
                        seat.start();
                        seat.join();

                        // --- Payment Thread ---
                        Payment payment = new Payment(uName);
                        Thread pThread = new Thread(payment);
                        pThread.start();
                        pThread.join();

                        // --- Booking Confirmation ---
                        System.out.println("\n---------- BOOKING CONFIRMATION ----------");
                        System.out.println("Movie: " + selectedMovie.name);
                        System.out.println("Theatre: " + selectedTheatre.name);
                        System.out.println("Show: " + selectedShow.time);
                        System.out.println("User: " + uName);
                        System.out.println("Ticket booked successfully!");

                        // --- Multi-user simulation ---
                        System.out.println("\n==== MULTI-USER SIMULATION ====");
                        TicketCounter counter = new TicketCounter();
                        UserBooking u1 = new UserBooking("Pranav", counter);
                        UserBooking u2 = new UserBooking("Shubham", counter);
                        UserBooking u3 = new UserBooking("Veer", counter);
                        u1.start();
                        u2.start();
                        u3.start();

                    } else {
                        System.out.println("Invalid username or password!");
                    }
                    break;

                case 2:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } catch (Exception e) {
            System.out.println("Invalid input! Please try again.");
        }

        sc.close();
    }
}
