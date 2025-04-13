import Arithmetic.*;
public class TDemo{
    public static void main(String a[]){
        Add a1 = new Add(5,6);
        Sub s = new Sub(10,6);
        Mul m = new Mul(5,10);
        System.out.println("Sum="+a1.calculate()+"\nDifference="+s.calculate()+"\nProduct="+m.calculate());
    }
}