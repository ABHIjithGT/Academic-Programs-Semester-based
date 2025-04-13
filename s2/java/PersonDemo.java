import java.util.Scanner;

class Person {
    String name;
    String gender;
    String address;
    int age;

    public Person(String name, String gender, String address, int age) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }

    public void displayPerson() {
        System.out.println("Name: " + name + "\nGender: " + gender + "\nAddress: " + address + "\nAge: " + age);
    }
}

class Employee extends Person {
    int employee_id;
    String company_name;
    String qualification;
    int salary;

    public Employee(String name, String gender, String address, int age, int employee_id, String company_name, String qualification, int salary) {
        super(name, gender, address, age);
        this.employee_id = employee_id;
        this.company_name = company_name;
        this.qualification = qualification;
        this.salary = salary;
    }

    public void displayEmployee() {
        System.out.println("Employee ID: " + employee_id + "\nCompany Name: " + company_name + "\nQualification: " + qualification + "\nSalary: " + salary);
    }
}

class Teacher extends Employee {
    int teacher_id;
    String subject;
    String department;

    public Teacher(String name, String gender, String address, int age, int employee_id, String company_name, String qualification, int salary, int teacher_id, String subject, String department) {
        super(name, gender, address, age, employee_id, company_name, qualification, salary);
        this.teacher_id = teacher_id;
        this.subject = subject;
        this.department = department;
    }

    public void displayTeacher() {
        displayPerson();
        displayEmployee();
        System.out.println("Teacher ID: " + teacher_id + "\nSubject: " + subject + "\nDepartment: " + department);
    }
}

public class PersonDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of teachers: ");
        int N = scanner.nextInt();
        scanner.nextLine();

        Teacher[] teachers = new Teacher[N];

        for (int i = 0; i < N; i++) {
            System.out.println("\nEnter details for Teacher " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            System.out.print("Employee ID: ");
            int employee_id = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Company Name: ");
            String company_name = scanner.nextLine();
            System.out.print("Qualification: ");
            String qualification = scanner.nextLine();
            System.out.print("Salary: ");
            int salary = scanner.nextInt();
            System.out.print("Teacher ID: ");
            int teacher_id = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Subject: ");
            String subject = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();

            teachers[i] = new Teacher(name, gender, address, age, employee_id, company_name, qualification, salary, teacher_id, subject, department);
        }

        System.out.println("\nDisplaying details of all teachers:");
        for (int i = 0; i < N; i++) {
            System.out.println("\nTeacher " + (i + 1) + " Details:");
            teachers[i].displayTeacher();
        }

        scanner.close();
    }
}

























// class Person {
//     String name;
//     String gender;
//     String address;
//     int age;

//     public Person(String name, String gender, String address, int age) {
//         this.name = name;
//         this.gender = gender;
//         this.address = address;
//         this.age = age;
//     }

//     public void displayPerson() {
//         System.out.println("Name: " + name + "\nGender: " + gender + "\nAddress: " + address + "\nAge: " + age);
//     }
// }

// class Employee extends Person {
//     int employee_id;
//     String company_name;
//     String qualification;
//     int salary;

//     public Employee(String name, String gender, String address, int age, int employee_id, String company_name, String qualification, int salary) {
//         super(name, gender, address, age);
//         this.employee_id = employee_id;
//         this.company_name = company_name;
//         this.qualification = qualification;
//         this.salary = salary;
//     }

//     public void displayEmployee() {
//         System.out.println("Employee ID: " + employee_id + "\nCompany Name: " + company_name + "\nQualification: " + qualification + "\nSalary: " + salary);
//     }
// }

// class Teacher extends Employee {
//     int teacher_id;
//     String subject;
//     String department;

//     public Teacher(String name, String gender, String address, int age, int employee_id, String company_name, String qualification, int salary, int teacher_id, String subject, String department) {
//         super(name, gender, address, age, employee_id, company_name, qualification, salary);
//         this.teacher_id = teacher_id;
//         this.subject = subject;
//         this.department = department;
//     }

//     public void displayTeacher() {
//         displayPerson();
//         displayEmployee();
//         System.out.println("Teacher ID: " + teacher_id + "\nSubject: " + subject + "\nDepartment: " + department);
//     }
// }

// public class PersonDemo {
//     public static void main(String[] args) {
        
//         Teacher t1 = new Teacher("John Doe", "Male", "123 Street", 35, 101, "XYZ School", "MSc Math", 50000, 1001, "Mathematics", "Science");
//         Teacher t2 = new Teacher("Jane Smith", "Female", "456 Avenue", 42, 102, "ABC Academy", "PhD Physics", 55000, 1002, "Physics", "Science");

        
//         System.out.println("Teacher 1 Details:");
//         t1.displayTeacher();

//         System.out.println("\nTeacher 2 Details:");
//         t2.displayTeacher();
//     }
// }












































// class Person{
//     String name;
//     String gender;
//     String address;
//     int age;
//     public Person(String name,String gender,String address,int age){
//         this.name = name;
//         this.gender = gender;
//         this.address = address;
//         this.age = age;
//     }
//     public void displayPerosn(){
//         System.out.println("Name:"+name+"\n Gender:"+gender+"\n Address:"+address+"\nAge:"+age);
//     }
// }
// class Employee extends Person{
//     int employee_id;
//     String company_name;
//     String qualification;
//     int salary;
//     public Employee(String name,String gender,String address,int age, int employee_id,String company_name,String qualification,int salary){
//         this.employee_id = employee_id;
//         this.company_name = company_name;
//         this.qualification = qualification;
//         this.salary = salary;
//     }
//     public void diaplayEmployee(){
//         System.out.println("Employee ID:"+employee_id+"\n Company Name:"+company_name+"\n Qualification"+qualification+"\n Salary"+salary);
//     }
// }
// class Teacher extends Employee{
//     int teacher_id;
//     String subject;
//     String department;
//     public Teacher(int employee_id,String company_name,String qualification,int salary,int teacher_id,String subject,String department){
//         this.teacher_id = teacher_id;
//         this.subject = subject;
//         this.department = department;
//     }
//     public void displayTeacher(){
//         System.out.println("Teacher ID:"+teacher_id+"\nSubject"+subject+"\nDepartment"+department);
//     }
// }
// public class PersonDemo{
//     public static void main(String a[])
// }