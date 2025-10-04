

import java.io.*;
import java.util.Scanner;

public class FileIO{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String filePath = "C:\\Users\\Matrix It Solutions\\Desktop\\text.txt";
		
		try {
			try(BufferedReader r = new BufferedReader(new FileReader(filePath))){
				String line;
				while((line = r.readLine()) != null) {
					System.out.println(line);
				}
			}catch(FileNotFoundException e) {
				System.out.println("Error " + e.getMessage());
			}
			
			
			try(BufferedWriter w = new BufferedWriter(new FileWriter(filePath,true))){
				System.out.println("Type your message.. Type '0' to close.");
				
				while(true) {
					String input = sc.nextLine();
					
					if(input.equalsIgnoreCase("0")) {
						System.out.println("Thankyou");
						break;
					}
					
					w.write(input);
					w.newLine();
					w.flush();
				}
			}
		}catch(IOException e) {
			System.out.println(e);
		}finally {
			sc.close();
		}
		
	}
}
