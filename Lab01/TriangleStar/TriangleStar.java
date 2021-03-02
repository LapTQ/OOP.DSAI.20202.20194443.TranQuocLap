package TriangleStar;

import java.util.Scanner;

public class TriangleStar {
    public static void main(String[] args) {

        System.out.print("n = ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i ++) {
            System.out.println(" ".repeat(n - i - 1) + "*".repeat(2*i + 1));    
            
            
        }
        
    }
}