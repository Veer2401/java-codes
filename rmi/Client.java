package rmi;

import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            Calculation stub = (Calculation) Naming.lookup("rmi://localhost/Calculation");

            String response = stub.message("Arithmetic Calculation using RMI programming.");
            System.out.println("Server replied: " + response);

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the first number: ");
            int a = sc.nextInt(); sc.nextLine();

            System.out.println("Enter the second number: ");
            int b = sc.nextInt(); sc.nextLine();

            int result1 = stub.add(a, b);
            int result2 = stub.subtract(a, b);
            int result3 = stub.multiply(a, b);
            int result4 = stub.divide(a, b);

            System.out.println(stub.add(a, b));
            System.out.println(stub.subtract(a, b));
            System.out.println(stub.multiply(a, b));
            System.out.println(stub.divide(a, b));

            sc.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
