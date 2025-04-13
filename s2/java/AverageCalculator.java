import java.util.Scanner;
class NegativeInputException extends Exception {
    public NegativeInputException(String message) {
        super(message);
    }
}
public class AverageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of integers (N): ");
        int N = scanner.nextInt();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            int number = scanner.nextInt();
            try {
                if (number < 0) {
                    throw new NegativeInputException("Negative input not allowed: " + number);
                }
                sum += number;
                count++;

            } catch (NegativeInputException e) {
                System.out.println(e.getMessage());
            }
        }
        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("The average of the valid positive integers is: " + average);
        } else {
            System.out.println("No valid positive integers entered.");
        }
        scanner.close();
    }
}
