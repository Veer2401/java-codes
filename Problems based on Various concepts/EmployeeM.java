import java.util.Scanner;

class Employee{
    String name;
    int age;
    double salary;

    Employee(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    double calculateSalary(){
        return salary;
    }
}

class FullTime extends Employee{
    double bonus;

    FullTime(String name, int age, double salary,double bonus){
        super(name, age, salary);
        this.bonus = bonus;
    }

    @Override
    double calculateSalary(){
        return salary + bonus;
    }
}

class PartTime extends Employee{
    int hoursWorked;
    double hourlyRate;

    PartTime(String name, int age, int hoursWorked, double hourlyRate){
        super(name, age, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateSalary(){
        return hourlyRate * hoursWorked;
    }
}

public class EmployeeM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----Employee Management-------");
        System.out.println("1. Full Time Employee");
        System.out.println("2. Part Time Employee");
        System.out.print("Choose type of employee: ");
        int ch = sc.nextInt(); sc.nextLine();

        Employee emp;

        if(ch == 1){
            System.out.print("Enter Name: ");
            String n = sc.nextLine();
            System.out.print("Enter age: ");
            int a = sc.nextInt(); sc.nextLine();
            System.out.print("Enter Salary: ");
            double s = sc.nextDouble(); sc.nextLine();
            System.out.print("Enter bonus: ");
            double b = sc.nextDouble(); sc.nextLine();
            emp = new FullTime(n, a, s, b);
        }else{
            System.out.print("Enter name: ");
            String n = sc.nextLine();
            System.out.print("Enter age: ");
            int a = sc.nextInt(); sc.nextLine();
            System.out.print("Enter hourly rate: ");
            double hr = sc.nextDouble(); sc.nextLine();
            System.out.print("Enter hours worked: ");
            int hrs = sc.nextInt(); sc.nextLine();
            emp = new PartTime(n, a, hrs, hr);
        }

        System.out.println("\n----------Details-----------");
        emp.displayDetails();
        System.out.println("\nTotal Salary: " + emp.calculateSalary());
    }
}
