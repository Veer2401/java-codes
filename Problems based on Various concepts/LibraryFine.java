import java.util.Scanner;

class LibraryAccount {
    String memberName;
    int daysOverdue;
    double fine;

    void inputDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Member name: ");
        memberName = sc.nextLine();
        System.out.print("Enter number of days overdue: ");
        daysOverdue = sc.nextInt();
    }

    void calculateFine(){
        fine = 0;

        if(daysOverdue <= 0){
            fine = 0;
        }else if(daysOverdue <= 5){
            fine = daysOverdue * 2;
        }else if(daysOverdue <= 10){
            fine = daysOverdue * 3;
        }else {
            fine = daysOverdue * 5;
        }
    }

    void displayDetails(){
        System.out.println("\nMember name: " + memberName);
        System.out.println("\nDays overdue: " + daysOverdue);
        System.out.println("\nFine: " + fine);
    }
}


public class LibraryFine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of members: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 1;i<=n;i++){
            System.out.println("\nDetails for Member " + i + ": ");
            LibraryAccount account = new LibraryAccount();
            account.inputDetails();
            account.calculateFine();
            account.displayDetails();
            System.out.println("-----------------------------");
        }
        sc.close();
    }


}
