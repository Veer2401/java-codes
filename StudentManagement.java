
 //java assignment 5

import java.util.*;

enum Department {
    CSE, ECE, MECHANICAL, CIVIL, PSYCHOLOGY;
}

class Student {
    String name, subject1, subject2, year;
    int roll_No;
    double totalMarks, mark1, mark2, mark3, average, sgpa, cgpa;
    Department department;

    private static int rollCounter = 1;
    private String teacher1 = "Prajakta mam";
    private String teacher2 = "Prachi mam";

    Student(String n, Department dept, String s1, String s2, double m1, double m2, double m3, String year, double sgpa, double cgpa) {
        name = n;
        roll_No = rollCounter++;
        department = dept;
        subject1 = s1;
        subject2 = s2;
        mark1 = m1;
        mark2 = m2;
        mark3 = m3;
        totalMarks = mark1 + mark2 + mark3;
        average = totalMarks / 3.0;
        this.year = year;
        this.sgpa = sgpa;
        this.cgpa = cgpa;
    }

    void display() {
        System.out.println("-----------------------------------");
        System.out.println("Name        : " + name);
        System.out.println("Roll Number : " + roll_No);
        System.out.println("Department  : " + department);
        System.out.println("Year        : " + year);
        System.out.println("Subjects    : " + subject1 + ", " + subject2);

        if (!year.equalsIgnoreCase("FY")) {
            System.out.println("Marks       : " + mark1 + ", " + mark2 + ", " + mark3);
            System.out.println("Total Marks : " + totalMarks);
            System.out.println("Average     : " + average);
            System.out.println("SGPA        : " + sgpa);
            System.out.println("CGPA        : " + cgpa);
        }
        System.out.println("-----------------------------------");
    }

    class Teacher {
        void displayTeacher() {
            System.out.println("The faculty for Java programming is " + teacher1);
            System.out.println("The Head of School is " + teacher2);
        }
    }
}

public class StudentManagement {
    static Student[] students; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n================ STUDENT MANAGEMENT SYSTEM ================");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int loginChoice = sc.nextInt();
            sc.nextLine();

            if (loginChoice == 1) {
                System.out.println("\n=== ADMIN LOGIN ===");
                System.out.print("Enter Admin Username: ");
                String username = sc.nextLine();
                System.out.print("Enter Admin Password: ");
                String password = sc.nextLine();

                if (username.equals("admin") && password.equals("1234")) {
                    System.out.println("Login Successful as ADMIN!");

                    System.out.print("Enter the total number of Students: ");
                    int count = sc.nextInt();
                    sc.nextLine();

                    students = new Student[count];

                    for (int i = 0; i < count; i++) {
                        System.out.println("\nEnter student " + (i + 1) + " details: ");
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Department: ");
                        String department = sc.nextLine().toUpperCase();
                        Department dept = Department.valueOf(department);
                        System.out.print("Enter Year (FY/SY/TY): ");
                        String year = sc.nextLine();
                        System.out.print("Enter Major Subject: ");
                        String sub1 = sc.nextLine();
                        System.out.print("Enter Minor Subject: ");
                        String sub2 = sc.nextLine();

                        double m1 = 0, m2 = 0, m3 = 0, sgpa = 0, cgpa = 0;
                        if (!year.equalsIgnoreCase("FY")) {
                            System.out.print("Enter marks for Subject 1: ");
                            m1 = sc.nextDouble();
                            System.out.print("Enter marks for Subject 2: ");
                            m2 = sc.nextDouble();
                            System.out.print("Enter marks for Subject 3: ");
                            m3 = sc.nextDouble();
                            System.out.print("Enter SGPA: ");
                            sgpa = sc.nextDouble();
                            System.out.print("Enter CGPA: ");
                            cgpa = sc.nextDouble();
                            sc.nextLine();
                        }

                        students[i] = new Student(name, dept, sub1, sub2, m1, m2, m3, year, sgpa, cgpa);
                    }

                    System.out.println("\n=== DATA OF STUDENTS ===");
                    for (Student s : students) {
                        s.display();
                    }
                } else {
                    System.out.println("Invalid Admin Credentials!");
                }

            } else if (loginChoice == 2) {
                if (students == null) {
                    System.out.println("No student data found. Please ask Admin to add students first.");
                    continue;
                }

                System.out.println("\n=== STUDENT LOGIN ===");
                System.out.print("Enter Your Name: ");
                String studentName = sc.nextLine();

                boolean found = false;
                for (Student s : students) {
                    if (s.name.equalsIgnoreCase(studentName)) {
                        System.out.println("\nWelcome, " + studentName + "! Here are your details:");
                        s.display();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student not found!");
                }

            } else if (loginChoice == 3) {
                System.out.println("Exiting... Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
