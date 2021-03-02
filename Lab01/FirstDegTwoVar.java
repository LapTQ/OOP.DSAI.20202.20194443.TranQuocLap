import java.util.Scanner;

public class FirstDegTwoVar {
    public static void main(String[] args) {
        
        System.out.println("Parameters for a11*x1 + a12*x2 = b1: ");
        Scanner scan = new Scanner(System.in);

        double a11, a12, b1;
        a11 = scan.nextDouble();
        a12 = scan.nextDouble();
        b1 = scan.nextDouble();

        System.out.println("Parameters for a21*x1 + a22*x2 = b2: ");
        scan = new Scanner(System.in);
        double a21, a22, b2;
        a21 = scan.nextDouble();
        a22 = scan.nextDouble();
        b2 = scan.nextDouble();

        double D = a11*a22 - a12*a21;
        double Dx = b1*a22 - b2*a12;
        double Dy = a11*b2 - b1*a21;

        System.out.println("Solve equation:\n" + a11 + "x1 + " + a12 + "x2 = " + b1 + "\n" + a21 + "x1 + " + a22 + "x2 = " + b2);

        if (D == 0) {
            if (Dx == Dy) {
                System.out.println("Infinite number of solution");
            }
            else {
                System.out.println("No solution");
            }
        }
        else {
            System.out.println("x1 = " + Dx/D + ", x2 = " + Dy/D);
        }

    }    
}
