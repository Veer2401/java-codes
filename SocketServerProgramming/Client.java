package SocketServerProgramming;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        
        String hostName = "localhost";
        int port = 5001;
        Scanner sc = new Scanner(System.in);

        try{
            Socket socket = new Socket(hostName,port);
            System.out.println("Connected to Server. ");

            BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter w = new PrintWriter(socket.getOutputStream());

            String msgToServer, msgFromServer;

            while (true) {
                System.out.println("Client: ");
                msgToServer = sc.nextLine();
                w.println(msgToServer);
                w.flush();

                if(msgToServer.equalsIgnoreCase("exit")){
                    System.out.println("Client exiting");
                    break;
                }

                msgFromServer = r.readLine();
                if(msgFromServer == null || msgFromServer.equalsIgnoreCase("exit")){
                    System.out.println("Server disconnected.");
                    break;
                }
                System.out.println("Server: " + msgFromServer);
            }
            socket.close();
            sc.close();
        }catch(UnknownHostException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}