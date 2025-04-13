package Arithmetic;
public class Add implements Computable{
    public double a,b;
    public Add(double a,double b){this.a=a;this.b=b;}
    public double calculate(){return (a+b);}
}
