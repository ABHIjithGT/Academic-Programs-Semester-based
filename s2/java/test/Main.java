import java.util.HashMap;
import java.util.Map;
class Attendee {
    private String name;
    private String email;
    private int registrationId;
    public Attendee(String name, String email, int registrationId) {
        this.name = name;
        this.email = email;
        this.registrationId = registrationId;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public int getRegistrationId() {
        return registrationId;
    }
    @Override
    public String toString() {
        return "Attendee{" +
               "name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", registrationId=" + registrationId +
               '}';
    }
}
class AttendeeRegistry {
    private Map<Integer, Attendee> attendees;
    public AttendeeRegistry() {
        attendees = new HashMap<>();
    }
    public boolean addAttendee(String name, String email, int registrationId) {
        if (attendees.containsKey(registrationId)) {
            System.out.println("Registration ID " + registrationId + " is already registered.");
            return false;
        } else {
            Attendee newAttendee = new Attendee(name, email, registrationId);
            attendees.put(registrationId, newAttendee);
            System.out.println("Attendee " + name + " added successfully.");
            return true;
        }
    }
    public Attendee getAttendee(int registrationId) {
        return attendees.get(registrationId);
    }
    public void printAllAttendees() {
        for (Attendee attendee : attendees.values()) {
            System.out.println(attendee);
        }
    }
    public boolean removeAttendee(int registrationId) {
        if (attendees.containsKey(registrationId)) {
            attendees.remove(registrationId);
            System.out.println("Attendee with ID " + registrationId + " removed.");
            return true;
        } else {
            System.out.println("Attendee with ID " + registrationId + " not found.");
            return false;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        AttendeeRegistry registry = new AttendeeRegistry();
        registry.addAttendee("Alice", "alice@example.com", 101);
        registry.addAttendee("Bob", "bob@example.com", 102);
        registry.addAttendee("Charlie", "charlie@example.com", 103);
        registry.addAttendee("David", "david@example.com", 102); 
        registry.printAllAttendees();

        Attendee attendee = registry.getAttendee(101);
        if (attendee != null) {
            System.out.println("Retrieved Attendee: " + attendee);
        }
        registry.removeAttendee(103);
        registry.removeAttendee(105); 
        System.out.println("Remaining attendees:");
        registry.printAllAttendees();
    }
}
