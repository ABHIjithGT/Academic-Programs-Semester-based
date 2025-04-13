import java.util.HashMap;
import java.util.Map;
class StudentSystem {
    private Map<Integer, String> studentDatabase;
    public StudentSystem() {
        studentDatabase = new HashMap<>();
    }
    public void addStudent(int id, String name) {
        studentDatabase.put(id, name);
    }
    public String getStudentName(int id) {
        return studentDatabase.get(id);
    }
    public void removeStudent(int id) {
        studentDatabase.remove(id);
    }
    public boolean studentExists(int id) {
        return studentDatabase.containsKey(id);
    }

    public void printAllStudents() {
        for (Map.Entry<Integer, String> entry : studentDatabase.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        StudentSystem system = new StudentSystem();
        system.addStudent(101, "Alice");
        system.addStudent(102, "Bob");
        system.addStudent(103, "Charlie");
        System.out.println("Student with ID 102: " + system.getStudentName(102)); 
        System.out.println("Does student with ID 104 exist? " + system.studentExists(104)); 
        system.printAllStudents();
        system.removeStudent(101);
        System.out.println("After removal:");
        system.printAllStudents();
    }
}
