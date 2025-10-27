import java.util.Scanner;

class Employee{
    String name;
    int id;

    Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    void displayRole(){
        System.out.println("I am a general Employee of this Organization.");
    }

    void displayDetails(){
        System.out.println("Name " + name);
        System.out.println("ID: " + id);
    }
}

class Manager extends Employee {
    String salary,department;

    Manager(String name, int id, String salary, String department){
        super(name, id);
        this.salary = salary;
        this.department = department;
    }

    @Override
    void displayRole(){
        System.out.println("I am the manager of department of " + department);
    }
}

class Developer extends Employee {
    String progLang;

    Developer(String name, int id, String progLang){
        super(name, id);
        this.progLang = progLang;
    }
    @Override
    void displayRole(){
        System.out.println("I am a " + progLang + " developer.");
    }
}

class Intern extends Employee {
    String duration;

    Intern(String name, int id, String duration){
        super(name, id);
        this.duration = duration;
    }

    @Override
    void displayRole(){
        System.out.println("I am an intern for " + duration + " months.");
    }
}

public class Organisation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Employee Details: ");
        System.out.print("Name: ");
        String eName = sc.nextLine();
        System.out.print("ID: ");
        int eID = sc.nextInt(); sc.nextLine();

        Employee emp = new Employee(eName, eID);

        System.out.println("Enter the Manager Details: ");
        System.out.print("Name: ");
        String mName = sc.nextLine();
        System.out.print("ID: ");
        int mID = sc.nextInt(); sc.nextLine();
        System.out.print("Salary: ");
        String mSalary = sc.nextLine();
        System.out.print("Department: ");
        String mDept = sc.nextLine();

        Manager manager = new Manager(mName, mID, mSalary, mDept);

        System.out.println("Enter the Developer Details");
        System.out.print("Name: ");
        String dName = sc.nextLine();
        System.out.print("ID: ");
        int dID = sc.nextInt(); sc.nextLine();
        System.out.print("Programming Language: ");
        String dLang = sc.nextLine();

        Developer developer = new Developer(dName, dID, dLang);

        System.out.println("Enter the Intern Details: ");
        System.out.print("Name: ");
        String iName = sc.nextLine();
        System.out.print("ID: ");
        int iID = sc.nextInt(); sc.nextLine();
        System.out.println("Duration of the Internship: ");
        String iDuration = sc.nextLine();

        Intern intern = new Intern(iName, iID, iDuration);

        System.out.println("\n-----------Employee Details------------");
        emp.displayDetails();
        emp.displayRole();

        System.out.println("\n-----------Manager Details--------------");
        manager.displayDetails();
        manager.displayRole();

        System.out.println("\n-----------Developer Details--------------");
        developer.displayDetails();
        developer.displayRole();

        System.out.println("\n-----------Intern Details------------------");
        intern.displayDetails();
        intern.displayRole();

        sc.close();
    }    
}
