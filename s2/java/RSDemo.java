import java.util.Scanner;

interface Printable {
    public void display();
    public void Show();
}

interface Computable {
    public double area();
    public double perimeter();
    public double volume();
}

interface Durable {
    public void draw();
}

class Rectangle implements Printable, Computable, Durable {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void display() {  System.out.println("Rectangle(" + length + "," + width + ")");    }

    public void Show() {    }

    public double area() {  return length * width;    }

    public double perimeter() {  return 2 * (length + width);    }

    public double volume() {   return -1;  }

    public void draw() { System.out.println("Drawing Rectangle......");  }
}

class Sphere implements Printable, Computable, Durable {
    double radius;

    Sphere(double radius) {  this.radius = radius;  }

    @Override
    public void display() {  System.out.println("Sphere(" + radius + ")");   }

    public void Show() {    }

    public double area() {  return 4 * Math.PI * radius * radius;   }

    public double perimeter() {  return 2 * (Math.PI * radius);  }

    public double volume() {  return (4 / 3) * Math.PI * Math.pow(radius, 3);  }

    public void draw() {  System.out.println("Drawing Sphere......");   }
}

public class RSDemo {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Rectangle");
            System.out.println("2. Sphere");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter length of rectangle: ");
                double length = sc.nextDouble();
                System.out.print("Enter width of rectangle: ");
                double width = sc.nextDouble();
                Rectangle rectangle = new Rectangle(length, width);

                rectangle.display();
                rectangle.Show();
                System.out.println("Area: " + rectangle.area());
                System.out.println("Perimeter: " + rectangle.perimeter());
                System.out.println("Volume: " + rectangle.volume());
                rectangle.draw();
            } else if (choice == 2) {
                System.out.print("Enter radius of sphere: ");
                double radius = sc.nextDouble();
                Sphere sphere = new Sphere(radius);

                sphere.display();
                sphere.Show();
                System.out.println("Area: " + sphere.area());
                System.out.println("Perimeter: " + sphere.perimeter());
                System.out.println("Volume: " + sphere.volume());
                sphere.draw();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        sc.close();
    }
}



































// interface Printable
// {
//     public void display();
//     public void Show();
// }
// interface Computable
// {
//     public double area();
//     public double perimeter();
//     public double volume();
// }
// interface Durable
// {
//  public void draw();
// }
// class Rectangle implements Printable,Computable,Durable
// {
//     double length,width;
//     Rectangle(double length,double width)
//     {
//         this.length = length;
//         this.width = width;
//     }
//     @Override
//     public void display()
//     {
//      System.out.println("Rectangle("+length+","+width+")");
//     }
//     public void show(){}
//     public double area() { return length*width; }
//     public double perimeter(){return 2*(length+width);}
//     public double volume(){return -1;}
//     public void draw(){System.out.println("Drawing Rectangle......");}
// }
// class Sphere implements Printable,Computable,Durable
// {
//     double radius;
//     Rectangle(double radius)
//     {
//         this.radius = radius;
//     }
//     @Override
//     public void display()
//     {
//      System.out.println("Sphere("+length+")");
//     }
//     public void show(){}
//     public double area() { return 4*Math.PI*radius*radius ; }
//     public double perimeter(){return 2*(Math.PI*radius);}
//     public double volume(){return 4/3(Math.PI*radius*radius*radius) ;}
//     public void draw(){System.out.println("Drawing Sphere......");}
// }

// public class RSDemo
// {
//     public satic void main(String[] a)
//     {

//     }
// }