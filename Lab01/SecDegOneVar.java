import java.util.Scanner;
import java.lang.Math;

public class SecDegOneVar {
    public static void main(String[] args) {

        System.out.println("Parameters for ax^2 + bx + c = 0: ");

        Scanner scan = new Scanner(System.in);

        double a, b, c;
        a = scan.nextDouble();
        b = scan.nextDouble();
        c = scan.nextDouble();

        double delta = b*b - 4*a*c;

        if (delta < 0) {
            System.out.println("No solution");
        }
        else if (delta == 0) {
            System.out.println("x = " + -b/(2*a));
        }
        else {
            double x1 = (-b + Math.sqrt(delta))/(2*a);
            double x2 = (-b - Math.sqrt(delta))/(2*a);
            System.out.println("x1 = " + x1 + "\t" + "x2 = " + x2);
        }
    }
}
