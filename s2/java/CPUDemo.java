class cpu{
    int price;
    public cpu(int price){
        this.price = price;
    }
    public void display1(){
        System.out.println("Price = "+price);
    }
    class processor{
        int nocore;
        int price;
        public processor(int nocore,int price){
            this.nocore = nocore;
            this.price = price;
        }
        public void display2(){
            System.out.println(nocore+" , "+price);
        }
    }
    static class RAM{
        String memory;
        String manufacture;
        public RAM(String m,String mn){
            memory = m;
            manufacture = mn;
        }
        public void display3(){
            System.out.println(memory+" , "+manufacture);
        }
    }
}
public class CPUDemo{
    public static void main (String[] arg){
        cpu c = new cpu (500);
        cpu.processor p = c.new processor(3,300);
        cpu.RAM r = new cpu.RAM("12 gb","NVIDIA");
        c.display1();
        p.display2();
        r.display3();
    }
}