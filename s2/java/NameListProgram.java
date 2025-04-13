import java.util.ArrayList;
import java.util.Scanner;

public class NameListProgram {
    private static ArrayList<String> namesList = new ArrayList<>();

    public static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Name");
        System.out.println("2. Remove Name");
        System.out.println("3. Search for a Name");
        System.out.println("4. Display All Names");
        System.out.println("5. Exit");
    }

    public static void addName(Scanner scanner) {
        System.out.print("Enter name to add: ");
        String name = scanner.nextLine();
        namesList.add(name);
        System.out.println(name + " added successfully.");
    }

    public static void removeName(Scanner scanner) {
        System.out.print("Enter name to remove: ");
        String name = scanner.nextLine();
        if (namesList.remove(name)) {
            System.out.println(name + " removed successfully.");
        } else {
            System.out.println(name + " not found.");
        }
    }

    public static void searchName(Scanner scanner) {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        if (namesList.contains(name)) {
            System.out.println(name + " is in the list.");
        } else {
            System.out.println(name + " is not found in the list.");
        }
    }

    public static void displayNames() {
        if (namesList.isEmpty()) {
            System.out.println("No names in the list.");
        } else {
            System.out.println("Names in the list: ");
            for (String name : namesList) {
                System.out.println(name);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addName(scanner);
                    break;
                case 2:
                    removeName(scanner);
                    break;
                case 3:
                    searchName(scanner);
                    break;
                case 4:
                    displayNames();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
