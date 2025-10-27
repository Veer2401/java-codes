import java.util.Scanner;

abstract class Payment {
    double amount;

    Payment(double amount){
        this.amount = amount;
    }

    abstract void pay();

    void paymentDetails(){
        System.out.println("Payable amount: Rs." + amount);
    }
}

class CreditCard extends Payment {
    String cardNumber,cardHolder;

    CreditCard(double amount, String cardNumber, String cardHolder){
        super(amount);
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    void pay(){
        System.out.println("\nCredit Card Details");
        System.out.println("Processing Payment....");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Card Holder: " + cardHolder);
        paymentDetails();
        System.out.println("Credit Card Payment Successful!");
    }
}

class UPI extends Payment{
    String upiID;

    UPI(double amount, String upiID){
        super(amount);
        this.upiID = upiID;
    }

    void pay(){
    System.out.println("Processing UPI Payment...");
    System.out.println("UPI ID: " + upiID);
    paymentDetails();
    System.out.println("UPI Payment Successful!\n");
    }
}

public class OnlinePaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Payment Method");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        int ch = sc.nextInt(); sc.nextLine();

        System.out.print("Enter Amount");
        double amount = sc.nextDouble(); sc.nextLine();

        Payment p;

        if(ch == 1){
            System.out.print("Enter Card Number: ");
            String card = sc.nextLine();
            System.out.print("Enter Card Holder Name: ");
            String name = sc.nextLine();
            
            p = new CreditCard(amount, card, card);

        }else{
            System.out.print("Enter UPI ID: ");
            String upi = sc.nextLine();

            p = new UPI(amount, upi);
        }

        p.pay();

        sc.close();
    }
}
