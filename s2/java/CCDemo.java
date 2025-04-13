import java.util.Scanner;

interface Compareable {
    double Volume();
    int CompareByVolume(Compareable other);
}

class Cuboid implements Compareable {
    double length, width, height;

    Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double Volume() {
        return length * width * height;
    }

    @Override
    public int CompareByVolume(Compareable other) {
        return Double.compare(Volume(), other.Volume());
    }

    @Override
    public String toString() {
        return "Cuboid(" + Volume() + ")";
    }
}

class Cylinder implements Compareable {
    double radius, height;

    Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double Volume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public int CompareByVolume(Compareable other) {
        return Double.compare(Volume(), other.Volume());
    }

    @Override
    public String toString() {
        return "Cylinder(" + Volume() + ")";
    }
}

public class CCDemo {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:\n1. Compare Cuboid with Cuboid\n2. Compare Cylinder with Cylinder\n3. Compare Cuboid with Cylinder\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                Cuboid cuboid1 = new Cuboid(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                Cuboid cuboid2 = new Cuboid(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                System.out.println(cuboid1.CompareByVolume(cuboid2) == 0 ? "Both cuboids have the same volume." : cuboid1.CompareByVolume(cuboid2) < 0 ? "First cuboid is smaller." : "First cuboid is larger.");
            } else if (choice == 2) {
                Cylinder cylinder1 = new Cylinder(sc.nextDouble(), sc.nextDouble());
                Cylinder cylinder2 = new Cylinder(sc.nextDouble(), sc.nextDouble());
                System.out.println(cylinder1.CompareByVolume(cylinder2) == 0 ? "Both cylinders have the same volume." : cylinder1.CompareByVolume(cylinder2) < 0 ? "First cylinder is smaller." : "First cylinder is larger.");
            } else if (choice == 3) {
                Cuboid cuboid = new Cuboid(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                Cylinder cylinder = new Cylinder(sc.nextDouble(), sc.nextDouble());
                System.out.println(cuboid.CompareByVolume(cylinder) == 0 ? "Both have the same volume." : cuboid.CompareByVolume(cylinder) < 0 ? "Cuboid is smaller." : "Cuboid is larger.");
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
























// interface Compareable 
// {
//     public double Volume();
//     public double CompareByVolume(Comparable other);
// }

// class Cuboid implements Compareable
// {
//  double length,width;
//  Cuboid(double length,double width)
//  {
//    this.length = length;
//    this.width = width;
//  }
//  @Override
//  public double Volume()
//  {

//  }
//  public double CompareByVolume()
//  {
//   if (Volume()<other.Volume()) return -1;
//   else if (Volume()>other.Volume()) return  1;
//   else return 0; 
//  }
//  public String toString()
//  {
//     return "Cuboid(+"Volume()")" ;
//  }
// }
// class Cylinder implements Compareable
// {
//  double radius;
//  Cylinder(double radius)
//  {
//    this.radius = radius;
//  }
//  @Override
//  public double Volume()
//  {

//  }
//  public double CompareByVolume(Compareable other)
//  {
//   if (Volume()<other.Volume()) return -1;
//   else if (Volume()>other.Volume()) return  1;
//   else return 0;
//  }
//  public String toString()
//  {
//     return "Cylinder(+"Volume()")" ;
//  }
// }

// public class RCDemo {
//     public static void main(String[] a) {
//         Scanner sc = new Scanner(System.in);
        
//         while (true) {
//             System.out.println("Menu:");
//             System.out.println("1. Cuboid");
//             System.out.println("2. Cylinder");
//             System.out.println("3. Exit");
//             System.out.print("Enter your choice: ");
//             int choice = sc.nextInt();