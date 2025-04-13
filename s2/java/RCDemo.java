import java.util.Scanner;

interface Calculation {
    public void area();
    public void perimeter();
}

class Circle implements Calculation {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void area() {
        System.out.println("Area of Circle: " + (Math.PI * radius * radius));
    }

    @Override
    public void perimeter() {
        System.out.println("Perimeter of Circle: " + (2 * Math.PI * radius));
    }
}

class Rectangle implements Calculation {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void area() {
        System.out.println("Area of Rectangle: " + (length * width));
    }

    @Override
    public void perimeter() {
        System.out.println("Perimeter of Rectangle: " + (2 * (length + width)));
    }
}

public class RCDemo {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter radius of the circle: ");
                double radius = sc.nextDouble();
                Circle circle = new Circle(radius);
                circle.area();
                circle.perimeter();
            } else if (choice == 2) {
                System.out.print("Enter length of rectangle: ");
                double length = sc.nextDouble();
                System.out.print("Enter width of rectangle: ");
                double width = sc.nextDouble();
                Rectangle rectangle = new Rectangle(length, width);
                rectangle.area();
                rectangle.perimeter();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        sc.close();
    }
}
