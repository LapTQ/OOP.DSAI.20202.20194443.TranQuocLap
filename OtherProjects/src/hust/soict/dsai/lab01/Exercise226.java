package hust.soict.dsai.lab01;

import java.util.Scanner;

public class Exercise226 {

    public void FirstDegreeOneVariable() {

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

    public void FirstDegreeTwoVariables() {

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

    public void SecondDegreeOneVariable() {

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
