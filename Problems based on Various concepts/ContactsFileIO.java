import java.io.*;
import java.nio.channels.Pipe.SourceChannel;
import java.util.Scanner;

public class ContactsFileIO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = "/Users/veer/Desktop/contacts.txt";

        try{
            File file = new File(filePath);

            if(!file.exists()) file.createNewFile();

            while(true){
                System.out.println("\n-----------Contact Management------------");
                System.out.println("1. Add Contact");
                System.out.println("2. View Contacts");
                System.out.println("3. Exit");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt(); sc.nextLine();

                switch(choice){
                    case 1:

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    FileWriter w = new FileWriter(file,true);
                    BufferedWriter bw = new BufferedWriter(w);
                    bw.write(name + " , " + phone + " , " + email);
                    bw.flush();
                    bw.close();
                    System.out.println("CONTACT ADDED SUCCESSFULLY");
                    break;

                    case 2:
                    BufferedReader r = new BufferedReader(new FileReader(file));
                    String line;
                    while((line = r.readLine()) != null){
                        System.out.println(line);
                    }
                    r.close();
                    break;

                    case 3:
                    System.out.println("Exiting");
                    break;

                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
