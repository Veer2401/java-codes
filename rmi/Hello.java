package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String sayHello(String name) throws RemoteException;

    int addNumbers(int a, int b) throws RemoteException;
} 

//remoteException is used because the rmi method calls can fail due to I/O
//network problems.
