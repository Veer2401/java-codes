package SocketServerProgramming;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int port = 5001;

        try{
            ServerSocket s = new ServerSocket(port);
            System.out.println("Server Started. Waiting for client to Connect. ");

            Socket socket = s.accept();
            System.out.println("Client Connected.");

            BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter w = new PrintWriter(socket.getOutputStream());

            String msgFromClient, msgToClient;

            while(true){
                msgFromClient = r.readLine();
                if(msgFromClient == null || msgFromClient.equalsIgnoreCase("exit")){
                    System.out.println("Client Disconnected");
                    break;
                }
                System.out.println("Client: " + msgFromClient);

                System.out.println("Server: ");
                msgToClient = sc.nextLine();
                w.println(msgToClient);
                w.flush();

                if(msgToClient.equalsIgnoreCase("exit")){
                    System.out.println("Server exiting");
                    break;
                }
            }
            s.close();
            socket.close();
            sc.close();
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}