interface Larea{
    double area(int x);
}
class LambdaArea{
    public static void main(String[] args){
        Larea square = (x) -> x * x;
        Larea cube = (x) -> 6 * (x * x);
        Larea circle = (x) -> Math.PI * (x * x);
        Larea sphere = (x) -> 4 * Math.PI * (x * x);

        System.out.println("Area of Square = " + square.area(2));
        System.out.println("Surface Area of Cube = " + cube.area(2));
        System.out.println("Area of Circle = " + circle.area(2));
        System.out.println("Surface Area of Sphere = " + sphere.area(2));
    }
}