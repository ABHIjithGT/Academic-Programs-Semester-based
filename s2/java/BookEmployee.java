class Publisher {
    String publisherName;

    Publisher(String publisherName) {
        this.publisherName = publisherName;
    }
}

class Book extends Publisher {
    String bookTitle;
    double price;

    Book(String publisherName, String bookTitle, double price) {
        super(publisherName);
        this.bookTitle = bookTitle;
        this.price = price;
    }

    void displayBookDetails() {
        System.out.println("Book Title: " + bookTitle);
        System.out.println("Publisher: " + publisherName);
        System.out.println("Price: $" + price);
    }
}

class Dept {
    String deptName;

    Dept(String deptName) {
        this.deptName = deptName;
    }
}

class Employee extends Dept {
    String empName;
    int empId;

    Employee(String deptName, String empName, int empId) {
        super(deptName);
        this.empName = empName;
        this.empId = empId;
    }

    void displayEmployeeDetails() {
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee ID: " + empId);
        System.out.println("Department: " + deptName);
    }
}

class BookThread extends Thread {
    Book book;

    BookThread(Book book) {
        this.book = book;
    }

    public void run() {
        book.displayBookDetails();
    }
}

class EmployeeThread extends Thread {
    Employee employee;

    EmployeeThread(Employee employee) {
        this.employee = employee;
    }

    public void run() {
        employee.displayEmployeeDetails();
    }
}

public class BookEmployee {
    public static void main(String[] args) {
        Book book = new Book("Pearson", "Java Programming", 39.99);
        Employee employee = new Employee("IT", "Alice", 101);

        Thread bookThread = new BookThread(book);
        Thread employeeThread = new EmployeeThread(employee);

        bookThread.start();
        employeeThread.start();

        try {
            bookThread.join();
            employeeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread completed");
    }
}