 import java.util.Scanner;
 class MyRunnable implements Runnable {
    @Override
    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to print Multiplication table");
         int n = scanner.nextInt();
        System.out.println("\t\t\tMultiplication table.....\n");
        for (int i=1;i<=10;i++)
        {
            System.out.println("\t\t\t"+i+"* "+n+" ="+(n*i));
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
 }

 public class Mulfact{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        System.out.println("Enter the number to print FACTORS");
        int n = scanner.nextInt();        
        thread2.start();
        for (int i=1;i<=n;i++){
            if(n%i==0)
            {
                System.out.println("F("+n+")="+i);
            }
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
 }

