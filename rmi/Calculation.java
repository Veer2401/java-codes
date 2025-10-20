package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculation extends Remote {

    String message(String text) throws RemoteException;

    int add(int a, int b) throws RemoteException;
    int subtract(int a, int b) throws RemoteException;
    int multiply(int a, int b) throws RemoteException;
    int divide(int a, int b) throws RemoteException;
    
} 
