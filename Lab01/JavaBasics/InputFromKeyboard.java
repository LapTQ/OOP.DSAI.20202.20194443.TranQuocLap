package JavaBasics;

import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {

        System.out.println("Input your name, age, height:");
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int age = scan.nextInt();
        double height = scan.nextDouble();

        System.out.println("Hi " + name + " " + age + " years old " + height + " tall");
    }
}
