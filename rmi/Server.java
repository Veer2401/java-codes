package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {

        
        try {
            LocateRegistry.createRegistry(1099);

            HelloImplementation obj = new HelloImplementation();

            Naming.rebind("HelloService", obj);

            System.out.println("Server is ready and 'Service' is bounded to register");
        } catch(Exception e){
            System.out.println("Server Error! " + e);
        }
    }
}
