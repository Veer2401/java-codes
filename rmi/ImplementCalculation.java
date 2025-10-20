package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementCalculation extends UnicastRemoteObject implements Calculation {

    public ImplementCalculation() throws RemoteException{
        super();
    }

    public String message(String text) throws RemoteException {
        return text;
    }

    public int add(int a, int b) throws RemoteException{
        int addition = a + b;
        System.out.println("Addition: " + addition);
        return addition;
    }

    public int subtract(int a, int b) throws RemoteException{
        int subtraction = a - b;
        System.out.println("Subtraction: " + subtraction);
        return subtraction;
    }

    public int multiply(int a, int b) throws RemoteException{
        int multiplication = a*b;
        System.out.println("Multiplication: " + multiplication);
        return multiplication;
    }

    public int divide(int a, int b){
        int division = a / b;
        System.out.println("Division: " + division);
        return division;
    }
}
