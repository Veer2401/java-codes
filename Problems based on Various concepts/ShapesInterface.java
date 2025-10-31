import java.util.Scanner;


interface Shape {
    double area();
    double perimeter();
    String getName();
}

class Circle implements Shape{
    double radius;

    Circle(double radius){
        this.radius = radius;
    }

    public double area(){
        return Math.PI * radius * radius;
    }

    public double perimeter(){
        return 2 * Math.PI * radius;
    }

     public String getName(){
        return "Circle";
    }
}

class Rectangle implements Shape {
    double len,bre;

    Rectangle(double len, double bre){
        this.len = len;
        this.bre = bre;
    }

    public double area(){
        return len * bre;
    }
    
    public double perimeter(){
        return 2 * (len + bre);
    }

     public String getName(){
        return "Rectangle";
    }
}

class Triangle implements Shape {
    double base,height;

    Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    public double area(){
        return 0.5 * base * height;
    }

    public double perimeter(){
        double hypo = Math.sqrt(base * base + height * height);
        return base + height + hypo;
    }

    public String getName(){
        return "Triangle";
    }
}


public class ShapesInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter radius of Circle: ");
        double r = sc.nextDouble();
        Shape circle = new Circle(r);

        System.out.println("Enter length of rectangle: ");
        double l = sc.nextDouble();
        System.out.println("Enter breadth of rectangle: ");
        double b = sc.nextDouble();
        Shape rectangle = new Rectangle(l, b);

        System.out.println("Enter base of Triangle: ");
        double base = sc.nextDouble();
        System.out.println("Enter height of triangle: ");
        double height = sc.nextDouble();
        Shape triangle = new Triangle(base, height);

        Shape[] shapes = {circle,rectangle,triangle};

        System.out.println("Shape Details: ");
        for(Shape s : shapes){
            System.out.println("Shape: " + s.getName());
            System.out.printf("Area: %.2f%n", s.area());
            System.out.printf("Perimeter: %.2f%n", s.perimeter());
            System.out.println("-------------------------------");
        }
        sc.close();
    }
    
}
