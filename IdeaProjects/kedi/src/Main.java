import java.util.Scanner;

class Dikdortgen{
    public double a;
    public double b;

    public  Dikdortgen(double a,double b){
this.a=a;
this.b=b;
    }
    public double circumferenc(){
        return 2*(this.a+this.b);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter a and b:");
        double a=scanner.nextDouble();
        double b=scanner.nextDouble();
Dikdortgen d=new Dikdortgen(a,b);
        System.out.println("The circumference is:"+d.circumferenc());
    }
}