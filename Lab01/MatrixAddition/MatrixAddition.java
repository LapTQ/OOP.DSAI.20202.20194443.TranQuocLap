package MatrixAddition;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m, n;
        System.out.print("Input size mxn (Separated by <Space>): ");
        m = scan.nextInt();
        n = scan.nextInt();
        double[][] a = new double[m][n];
        
        System.out.println("Input the 1st matrix: (Rows in newlines)");
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                a[i][j] = scan.nextDouble();
            }
        }
        System.out.println("Input the 2nd matrix: (Rows in newlines)");
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                a[i][j] += scan.nextDouble();
            }
        }
        System.out.println(Arrays.deepToString(a));

    }
}