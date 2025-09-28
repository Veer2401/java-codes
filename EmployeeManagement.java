
// Java Assignment 3 

import java.util.Scanner;


class Employee {
    String name;
    int id;
    double salary;
    String job, nationality, department, location;

    
    static int counter = 100;

   
    Employee(String name, double salary, String job, String nationality, String department, String location) {
        this.name = name;
        this.salary = salary;
        this.job = job;
        this.nationality = nationality;
        this.department = department;
        this.location = location;
        this.id = counter++; 
    }

    
    void display() {
        System.out.println("Name        : " + name);
        System.out.println("ID          : " + id);
        System.out.println("Salary      : " + salary);
        System.out.println("Job         : " + job);
        System.out.println("Nationality : " + nationality);
        System.out.println("Department  : " + department);
        System.out.println("Location    : " + location);
    }
}


class Manager extends Employee {
    Manager(String name, double salary, String job, String nationality, String department, String location) {
        super(name, salary, job, nationality, department, location);
    }

    @Override
    void display() {
        super.display();
        System.out.println("Role        : Manager");
    }
}

// ===================== General Manager =====================
class GeneralManager extends Manager {
    GeneralManager(String name, double salary, String job, String nationality, String department, String location) {
        super(name, salary, job, nationality, department, location);
    }

    @Override
    void display() {
        super.display();
        System.out.println("Role        : General Manager");
    }
}

class Developer extends Employee {
    String lang; 

    Developer(String name, double salary, String job, String nationality, String department, String location, String lang) {
        super(name, salary, job, nationality, department, location);
        this.lang = lang;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Role        : Developer");
        System.out.println("Language    : " + lang);
    }
}


class SalaryDetails extends Employee {
    double hra, da;

    SalaryDetails(String name, double salary, String job, String nationality, String department, String location) {
        super(name, salary, job, nationality, department, location);
        calculateComponents();
    }

    void calculateComponents() {
        hra = 0.2 * salary; 
        da = 0.1 * salary;  
    }

    void showSalaryComponents() {
        System.out.println("HRA         : " + hra);
        System.out.println("DA          : " + da);
    }
}

class Performance extends SalaryDetails {
    double award;

    Performance(String name, double salary, String job, String nationality, String department, String location, boolean outstanding) {
        super(name, salary, job, nationality, department, location);
        award = outstanding ? 2000 : 0;
    }

    void showPerformanceAward() {
        System.out.println("Performance Award: " + award);
    }
}

class Admin extends Performance {
    Admin(String name, double salary, String job, String nationality, String department, String location, boolean outstanding) {
        super(name, salary, job, nationality, department, location, outstanding);
    }

    @Override
    void showSalaryComponents() {
        super.showSalaryComponents();
        System.out.println("Role        : Admin");
    }

    @Override
    void display() {
        super.showPerformanceAward();
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Manager details:");
        Object[] commonM = getCommonInputs(sc);
        Manager manager = new Manager(
            (String) commonM[0],
            (Double) commonM[1],
            (String) commonM[2],
            (String) commonM[3],
            (String) commonM[4],
            (String) commonM[5]
        );
        System.out.println("\n--- Manager Details ---");
        manager.display();

        System.out.println("\nEnter General Manager details:");
        Object[] commonGM = getCommonInputs(sc);
        GeneralManager gm = new GeneralManager(
            (String) commonGM[0],
            (Double) commonGM[1],
            (String) commonGM[2],
            (String) commonGM[3],
            (String) commonGM[4],
            (String) commonGM[5]
        );
        System.out.println("\n--- General Manager Details ---");
        gm.display();

        System.out.println("\nEnter Developer details:");
        Object[] commonD = getCommonInputs(sc);
        System.out.print("Enter Programming Language: ");
        String lang = sc.nextLine();
        Developer dev = new Developer(
            (String) commonD[0],
            (Double) commonD[1],
            (String) commonD[2],
            (String) commonD[3],
            (String) commonD[4],
            (String) commonD[5],
            lang
        );
        System.out.println("\n--- Developer Details ---");
        dev.display();

        System.out.println("\nEnter Admin details:");
        Object[] commonA = getCommonInputs(sc);
        System.out.print("Was the performance outstanding? (true/false): ");
        boolean outstanding = sc.nextBoolean();
        Admin admin = new Admin(
            (String) commonA[0],
            (Double) commonA[1],
            (String) commonA[2],
            (String) commonA[3],
            (String) commonA[4],
            (String) commonA[5],
            outstanding
        );
        System.out.println("\n--- Admin Details ---");
        admin.display();
        admin.showSalaryComponents();
        admin.showPerformanceAward();

        sc.close();
    }

    
    public static Object[] getCommonInputs(Scanner sc) {
        Object[] inputs = new Object[6];

        System.out.print("Name: ");
        inputs[0] = sc.nextLine();

        System.out.print("Salary: ");
        inputs[1] = sc.nextDouble();
        sc.nextLine();

        System.out.print("Job Type: ");
        inputs[2] = sc.nextLine();

        System.out.print("Nationality: ");
        inputs[3] = sc.nextLine();

        System.out.print("Department: ");
        inputs[4] = sc.nextLine();

        System.out.print("Work Location (Offline/Hybrid): ");
        inputs[5] = sc.nextLine();

        return inputs;    
    }
}
