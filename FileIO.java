
//java assignment 8

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileIO{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String f = "/Users/veer/desktop/assignment8.txt";
        
        try{
            File file = new File(f);
            if(file.exists()){
                System.out.println("Chats: ");
                try(BufferedReader r = new BufferedReader(new FileReader(file))){
                    String line;
                    while((line = r.readLine()) != null){
                        System.out.println(line);
                    }
                }catch(FileNotFoundException e){
                    System.out.println(e);
                }
            } else{
                System.out.println("No chat was found. Start a new chat");
            }

        

        try(BufferedWriter w = new BufferedWriter(new FileWriter(f,true))){
            System.out.println("Type your message. Type '0' to stop.\n");

            while(true){
                System.out.println("Start..");
                String input = sc.nextLine();

                if(input.equalsIgnoreCase("0")){
                    break;
                }

                w.write(input);
                w.newLine();
                w.flush();
        } 
    }
    } catch (IOException e){

        } finally{
            sc.close();
        }
    }  
}