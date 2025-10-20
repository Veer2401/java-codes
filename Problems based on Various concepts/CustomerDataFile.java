import java.io.*;
import java.util.Scanner;

public class CustomerDataFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = "/Users/veer/Documents/customer.txt";

        while(true){
            System.out.println("\n--- Customer Data Management ---");
            System.out.println("1. Write Data (overwrite)");
            System.out.println("2. Append Data");
            System.out.println("3. Read Data");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                try(BufferedWriter w = new BufferedWriter(new FileWriter(filePath))){
                    String data;
                    System.out.println("Enter Customer Details: ");
                    data = sc.nextLine();
                    w.write(data);
                    w.newLine();
                    System.out.println("Data Written Successfully!");
                }catch(IOException e){
                    System.out.println(e.getMessage());
                }
                break;

                case 2:
                try(BufferedWriter w = new BufferedWriter(new FileWriter(filePath,true))){
                    String data;
                    System.out.println("Enter Customer Details: ");
                    data = sc.nextLine();
                    w.write(data);
                    w.newLine();
                    w.flush();
                    System.out.println("Data Written Successfully!");
                }catch(IOException e){
                    System.out.println(e.getMessage());
                }
                break;

                case 3:
                try(BufferedReader r = new BufferedReader(new FileReader(filePath))){
                    String line;
                    while((line = r.readLine()) != null){
                        System.out.println(line);
                    }

                   
                }catch(IOException e){
                    System.out.println(e.getMessage());
                }
                break;

                case 4:
                System.out.println("Exiting.");
                break;

                default:
                System.out.println("Enter correct choice!");

                sc.close();
            }
        }
        
    }
}
