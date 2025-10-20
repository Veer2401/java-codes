
import java.util.Scanner;
interface Appliance{
    void switchOn();

    void switchOff();
}

interface Connectable {
    void isSmart();
}

class Light implements Appliance, Connectable {
    public void switchOn(){
        System.out.println("The light is Turned On");
    }

    public void switchOff(){
        System.out.println("Light is Off");
    }

    public void isSmart(){
        System.out.println("The light can be connected to Wifi");
    }

}

class Fan implements Appliance{
    public void switchOn(){
        System.out.println("The fan is Turned On");
    }

    public void switchOff(){
        System.out.println("Fan is Off");
    }
}

class AirConditioner implements Appliance {
    public void switchOn(){
        System.out.println("The AC is Turned On");
    }

    public void switchOff(){
        System.out.println("AC is Off");
    }
}

public class SmartHomeInterface {

    public static void main(String[] args) {
        Appliance[] obj = {
            new Light(),
            new Fan(),
            new AirConditioner()
        };

        for(Appliance a : obj){
            a.switchOn();
            a.switchOff();
            if(a instanceof Connectable){
                ((Connectable)a).isSmart();
            }
            System.out.println("---------------------------");
        }
    }
}