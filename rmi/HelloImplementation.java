package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImplementation extends UnicastRemoteObject implements Hello {
    
    public HelloImplementation() throws RemoteException {
        super();
    }

    public String sayHello(String name) throws RemoteException {
        return "Hello " + name + "! from RMI Servers.";
    }

    public int addNumbers(int a, int b) throws RemoteException {
        int sum = a + b;
        System.out.println("Recieved numbers: " + a + " and " + b);
        System.out.println("Sum = " + sum);
        return sum;
    }
}


//UnicastRemoteObject is used to export the remote objects. 
