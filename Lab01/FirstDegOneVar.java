import java.util.Scanner;

public class FirstDegOneVar {
    public static void main(String[] args) {

        System.out.print("Parameter for ax + b = 0 [Separated by <Space>]: ");

        Scanner scan = new Scanner(System.in);
        
        double a = scan.nextDouble();
        double b = scan.nextDouble();

        if (a == 0 && b == 0) {
            System.out.println("Any real number");
        }
        else if (a == 0 && b != 0) {
            System.out.println("No solution");
        }
        else {
            System.out.println("x = " + -b/a);
        }


    }
}
