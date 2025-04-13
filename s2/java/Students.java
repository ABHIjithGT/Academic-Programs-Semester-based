import java.util.Scanner;

class Student {
    String Name;
    int Rollno;
    int Mark;

    public Student() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Rollno ?: ");
        Rollno = sc.nextInt();
        
        sc.nextLine(); 
        
        System.out.print("Name ?: ");
        Name = sc.nextLine();
        
        System.out.print("Mark ?: ");
        Mark = sc.nextInt();
    }

    public void display() {
        System.out.println("Rollno: " + Rollno + "\nName: " + Name + "\nMark: " + Mark);
    }
}

public class Students {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        Student[] students = new Student[n]; 
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1));
            students[i] = new Student(); 
        }
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (students[i].Mark < students[j].Mark) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        
        System.out.println("\nRank List:");
        for (int i = 0; i < n; i++) {
            System.out.println("\nRank " + (i + 1) + ":");
            students[i].display();
        }
    }
}

















// import java.util.Scanner;

// class Student {
//     String Name;
//     int Rollno;
//     int Mark;

//     public Student() {
//         Scanner sc = new Scanner(System.in);
        
//         System.out.print("Rollno ?: ");
//         Rollno = sc.nextInt();
        
//         sc.nextLine(); 
        
//         System.out.print("Name ?: ");
//         Name = sc.nextLine();
        
//         System.out.print("Mark ?: ");
//         Mark = sc.nextInt();
//     }

//     public void display() {
//         System.out.println("Rollno: " + Rollno + "\nName: " + Name + "\nMark: " + Mark);
//     }
// }

// public class Students {
//     public static void main(String[] a) {
//         Student s1 = new Student();
//         s1.display();
//     }
// }
