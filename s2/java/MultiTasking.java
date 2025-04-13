import java.util.Scanner;

class PrimeRunnable implements Runnable {
    private int start, end;
    
    public PrimeRunnable(int start, int end) {
        this.start = start; 
        this.end = end;
    }

    @Override
    public void run() {
        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                System.out.println("Prime: " + num);
            }
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

class EvenRunnable implements Runnable {
    private int start, end;

    public EvenRunnable(int start, int end) {
        this.start = start;  
        this.end = end;
    }

    @Override
    public void run() {
        for (int num = start; num <= end; num++) {
            if (num % 2 == 0) {
                System.out.println("Even: " + num);
            }
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}

class FibonacciRunnable implements Runnable {
    private int n;

    public FibonacciRunnable(int n) {
        this.n = n;  
    }

    @Override
    public void run() {
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            System.out.println("Fibonacci: " + a);
            int next = a + b;
            a = b;
            b = next;
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}

public class MultiTasking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking inputs for range and Fibonacci count
        System.out.println("Enter start of range: ");
        int start = scanner.nextInt();
        System.out.println("Enter end of range: ");
        int end = scanner.nextInt();
        System.out.println("Enter number of Fibonacci numbers: ");
        int n = scanner.nextInt();

        // Create and start threads
        new Thread(new PrimeRunnable(start, end)).start();
        new Thread(new EvenRunnable(start, end)).start();
        new Thread(new FibonacciRunnable(n)).start();

        scanner.close();
    }
}
