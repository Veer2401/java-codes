package rmi;

import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Hello stub = (Hello) Naming.lookup("rmi://localhost/HelloService");

            String greeting = stub.sayHello("Veer");
            System.out.println("Server replied: " + greeting);

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the first number: ");
            int a = sc.nextInt(); sc.nextLine();

            System.out.print("Enter the second number: ");
            int b = sc.nextInt(); sc.nextLine();

            int result = stub.addNumbers(a, b);

            System.out.println("Sum is calulated: " + result);

            sc.close();
        }catch (Exception e){
            System.out.println("Client Error: " + e);
        }
    }
}
