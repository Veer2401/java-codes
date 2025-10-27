import java.io.*;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputFile = "/Users/veer/desktop/books_input.txt";
        String outputFile = "/Users/veer/desktop/books_output.txt";
        String line;

        try{
            BufferedReader r = new BufferedReader(new FileReader(inputFile));
            System.out.println("Books in the Store: ");

            while((line = r.readLine()) != null){
                    System.out.println(line);
            }
            r.close();
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        try{
            BufferedWriter w = new BufferedWriter(new FileWriter(outputFile,true));

            System.out.println("Do you want to add a new Book? (yes/no)");
            String choice = sc.nextLine();

            while(choice.equalsIgnoreCase("yes")){
                System.out.println("Enter Book ID: ");
                String id = sc.nextLine();

                System.out.println("Enter Book name: ");
                String name = sc.nextLine();

                System.out.println("Enter price: ");
                String price = sc.nextLine();

                w.write(id + ", " + name + ", " + price);
                w.newLine();
                w.flush();

                System.out.println("Add another book? (yes/no)");
                choice = sc.nextLine();
            }
            w.close();
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            sc.close();
        }

    }
}
