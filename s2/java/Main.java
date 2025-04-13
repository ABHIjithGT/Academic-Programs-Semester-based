import java.util.*;

interface Showable {
    void show();
}

class Person {
    String name;
    String gender;
    String phoneNo;

    public Person(String name, String gender, String phoneNo) {
        this.name = name;
        this.gender = gender;
        this.phoneNo = phoneNo;
    }
}

class Student extends Person {
    String course;
    double score;

    public Student(String name, String gender, String phoneNo, String course, double score) {
        super(name, gender, phoneNo);
        this.course = course;
        this.score = score;
    }
}

class PGStudent extends Student {
    String researchArea;
    String guide;

    public PGStudent(String name, String gender, String phoneNo, String course, double score, String researchArea, String guide) {
        super(name, gender, phoneNo, course, score);
        this.researchArea = researchArea;
        this.guide = guide;
    }

    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Phone No: " + phoneNo);
        System.out.println("Course: " + course);
        System.out.println("Score: " + score);
        System.out.println("Research Area: " + researchArea);
        System.out.println("Guide: " + guide);
        System.out.println("------------------------------");
    }

    public double getScore() {
        return score;
    }

    public String getResearchArea() {
        return researchArea;
    }
}

public class Main {
    public static void main(String[] args) {
        List<PGStudent> students = new ArrayList<>();
        students.add(new PGStudent("Alice", "Female", "1234567890", "MSc", 88.5, "AI", "Dr. Smith"));
        students.add(new PGStudent("Bob", "Male", "0987654321", "MTech", 92.0, "Data Science", "Dr. Brown"));
        students.add(new PGStudent("Charlie", "Male", "1122334455", "MSc", 85.0, "AI", "Dr. White"));
        students.add(new PGStudent("Diana", "Female", "2233445566", "MTech", 91.0, "Quantum Computing", "Dr. Green"));

        students.sort(Comparator.comparingDouble(PGStudent::getScore).reversed());

        System.out.println("Students ranked by score (descending):");
        for (PGStudent student : students) {
            student.show();
        }

        students.sort(Comparator.comparing(PGStudent::getResearchArea));

        System.out.println("Students sorted by research area (ascending):");
        for (PGStudent student : students) {
            student.show();
        }
    }
}
