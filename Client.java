import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        String hostName = "localhost";
        int port = 5001;

        try(Socket socket = new Socket(hostName,port)){
            System.out.println("Connected to server at " + hostName + ":" + port);

            PrintWriter w = new PrintWriter(socket.getOutputStream());
            BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message = "Hello Server!";
            w.println(message);
            w.flush();
            System.out.println("Sent to Server!" + message);

            String response = r.readLine();

            System.out.println("Recieved from Server! " + response);
            
        }catch(UnknownHostException e){
            System.out.println("Sever not found " + e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}