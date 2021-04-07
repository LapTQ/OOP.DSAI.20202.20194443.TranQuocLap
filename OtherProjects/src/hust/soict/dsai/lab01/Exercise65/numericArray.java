package hust.soict.dsai.lab01.Exercise65;

import java.util.Arrays;
import java.util.Scanner;

public class numericArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Number of elements: ");
        int n = scan.nextInt();
        int[] a = new int[n];
        System.out.println("Input element of the array: [Separated by <Space>]");
        for (int i = 0; i < n; i ++) {
            a[i] = scan.nextInt();
        }
        
        
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.stream(a).sum());
        System.out.println(Arrays.stream(a).average().orElse(Double.NaN));
    }

}