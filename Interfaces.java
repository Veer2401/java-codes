
//java interface Assignment 4

interface Vehicle{
    void start();
    void stop();
    int getSpeed();
    String getFuelType();     
}

interface Maintenance{
    void performMaintenance();
}

class Car implements Vehicle,Maintenance{

    public void start(){
        System.out.println("Car is starting");
    }
    public void stop(){
        System.out.println("Car has been stopped");
    }
    public int getSpeed(){
        return 80;
    }
    public String getFuelType(){
        return "Petrol";
    }
    public void performMaintenance(){
        System.out.println("Maintenance performed");
    }

}

class Bus implements Vehicle, Maintenance{

    public void start(){
        System.out.println("Bus is starting");
    }
    public void stop(){
        System.out.println("Bus has been stopped");
    }
    public int getSpeed(){
        return 100;
    }
    public String getFuelType(){
        return "Diesel";
    }

    public void performMaintenance(){
        System.out.println("Maintenance performed");
    }

}

class Motorcycle implements Vehicle{
    public void start(){
        System.out.println("Motorcycle is starting");
    }
    public void stop(){
        System.out.println("Motorcycle has been stopped");
    }
    public int getSpeed(){
        return 120;
    }
    public String getFuelType(){
        return "Petrol";
    }

}

public class Interfaces {
    public static void main(String[] args) {
        Vehicle[] obj = {
            new Car(),
            new Bus(),
            new Motorcycle()
        };

        for (Vehicle v : obj){
            v.start();
            System.out.println("The speed is: " + v.getSpeed());
            System.out.println("The fuel Type is: " + v.getFuelType());
            v.stop();
            if(v instanceof Maintenance){
                ((Maintenance)v).performMaintenance();
            }
            System.out.println("---------------------------");
        
        }
        
    }
}
