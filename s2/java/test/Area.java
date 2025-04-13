public class Area{
    public int area(int x,int y){ return (x * y); }
    public int area(int x){ return (x * x); }
    public int area(int r){ return ((22/7)*r*r); }
    public int area(int b,int h){ return ((1/2)*b*h); }

   public static void main(String args[])
    {
        Area a = new Area();
        System.out.println(a.area(10, 20));
        System.out.println(a.area(10));
        
        System.out.println(a.area(10, 20));
        System.out.println(a.area(10));
    }
}
