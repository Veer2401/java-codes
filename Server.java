import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        int port = 5001;

        try(ServerSocket s = new ServerSocket(port)){
            System.out.println("Server started on port " + port);

            Socket socket = s.accept();

            System.out.println("Client Connected from: " + socket.getInetAddress());

            BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter w = new PrintWriter(socket.getOutputStream());

            String clientMessage = r.readLine();

            if(clientMessage != null){
                System.out.println("Message: " + clientMessage);

                String response = "Hello Client! You Sent: " + clientMessage;
                w.println(response);
                w.flush();
                System.out.println("Response Sent.");
            }
            socket.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}